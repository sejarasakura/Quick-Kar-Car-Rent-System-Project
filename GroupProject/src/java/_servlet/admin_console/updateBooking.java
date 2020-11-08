/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import _da.BookingDA;
import _domain.Booking;
import _enum.ErrorDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xps
 */
public class updateBooking extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Booking booking = (Booking)request.getSession().getAttribute("booking");
        BookingDA da = new BookingDA();
        if(da.updateRecord(booking, booking.getBooking_id())){
            response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/_profile/booking.jsp?id="
                    + booking.getBooking_id());   
        }else{
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E007.getUrl() + "&url=updateBooking");          
        }
          
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
