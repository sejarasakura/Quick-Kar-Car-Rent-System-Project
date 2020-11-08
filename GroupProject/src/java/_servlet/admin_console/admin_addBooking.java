/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import _control.GenerateID;
import _da.*;
import _domain.Booking;
import _domain.*;
import _enum.BookingStatus;
import _enum.ErrorDetails;
import _enum.PaymentStatus;
import _enum.RatingStar;
import _manipulation.MapManipulation;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xps
 */
public class admin_addBooking extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ErrorDetails error = ErrorDetails.E000;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Payment payment = new Payment();
        PaymentMethod pay_method = new PaymentMethod(request.getParameter("payment_method_id").split("-")[0]);
        payment.setPayment_id(_control.GenerateID.generate_Payment(pay_method.getPay_method_id()));
        payment.setPayment_method(pay_method);
        payment.setPayment_status(PaymentStatus.NOT_YET_PAID);
        Booking booking = new Booking();
        booking.setBooking_id(GenerateID.generate_Booking());
        booking.setStart_location(request.getParameter("start_location"));
        booking.setEnd_location(request.getParameter("end_location"));
        Rating rating = new Rating(GenerateID.generate_Rating(), RatingStar.ZERO_STAR, "", new Date());
        booking.setRating(rating);
        booking.setCustomer(new _domain.Customer(request.getParameter("cust_id").split("-")[0]));
        booking.setDriver(new _domain.Driver(request.getParameter("driver_id").split("-")[0]));
        try {
            payment.setPayment_date(new Date());
            booking.setBooking_date(new Date());
            booking.setFetch_date(formatter.parse(request.getParameter("fetch_date")));
        } catch (ParseException ex) {
            error = ErrorDetails.E008;
        }
        booking.setPayment(payment);
        booking.setBooking_status(BookingStatus.getValue(request.getParameter("booking_status").split("-")[0]));
        DistanceMatricRespond distance = MapManipulation.getResponse(booking.getStart_location(), booking.getEnd_location());
        CarDA carda = new CarDA();
        Object[] car = carda.getRecords("driver_id = '" + booking.getDriver().getDriver_id() + "'");
        if(car!=null){
            error = ErrorDetails.E015;
        }
        Car real_car = (Car)car[0];
        double price1 = real_car.getQuickar_type().getPrice_per_km() * distance.getDistance_value() / 1000;
        double price2 = real_car.getQuickar_type().getPrice_per_min() * distance.getDuration_value() / 60;
        double price = (price1 + price2)/2;
        price += real_car.getQuickar_type().getBase_fair_price();
        if(price < real_car.getQuickar_type().getMinimum_price())
            price = real_car.getQuickar_type().getMinimum_price();
        payment.setPayment_amount(price);
        
        BookingDA da = new BookingDA();
        RatingDA da_1 = new RatingDA();
        PaymentDA da_2 = new PaymentDA();
        if(!da_2.addRecord(booking.getPayment())){
            error = ErrorDetails.E009;
        }
        if(!da_1.addRecord(booking.getRating())){
            error = ErrorDetails.E009;
        }
        String id = booking.getBooking_id();
        if(!da.addRecord(booking)){
            error = ErrorDetails.E009;
        }
        response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/_profile/booking.jsp?id=" + id);  
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
