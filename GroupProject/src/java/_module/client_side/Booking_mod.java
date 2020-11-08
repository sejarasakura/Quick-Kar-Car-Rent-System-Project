/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _module.client_side;
import _control.Validation;
import _domain.*;
import _da.*;
import _enum.*;
/**
 *
 * @author ITSUKA KOTORI
 */
public class Booking_mod {
    
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    public static boolean add_booking(Booking booking){
        if(!Validation.check_RatingID(booking.getRating().getRating_id()) &&
           !Validation.check_CustID(booking.getCustomer().getCust_id()) &&
           !Validation.check_DriverID(booking.getDriver().getDriver_id()) &&
           !Validation.check_PaymentID(booking.getPayment().getPayment_id()) &&
           !Validation.check_Date(booking.getFetch_date()) &&
           !Validation.check_Date(booking.getBooking_date()))
            return false;
        return new BookingDA().addRecord((Booking)booking);
    }
    public static boolean update_booking(Booking booking){
        if(!Validation.check_RatingID(booking.getRating().getRating_id()) &&
           !Validation.check_CustID(booking.getCustomer().getCust_id()) &&
           !Validation.check_DriverID(booking.getDriver().getDriver_id()) &&
           !Validation.check_PaymentID(booking.getPayment().getPayment_id()) &&
           !Validation.check_Date(booking.getFetch_date()) &&
           !Validation.check_Date(booking.getBooking_date()))
            return false;
        String code= ((Booking)booking).getBooking_id();
        return new BookingDA().updateRecord((Booking)booking, code);
    }
    public static boolean update_booking_status(String booking_id, Object booking_status){
        Booking booking = (Booking)new BookingDA().getRecord(booking_id);
        if(booking_status instanceof BookingStatus)
            booking.setBooking_status((BookingStatus)booking_status);
        else if(booking_status instanceof String)
            booking.setBooking_status(BookingStatus.getValue((String)booking_status));
        else 
            return false;
        if(booking.getBooking_status() == null)
            return false;
        return new BookingDA().updateRecord(booking, booking.getBooking_id());
    }
    //</editor-fold>
}
