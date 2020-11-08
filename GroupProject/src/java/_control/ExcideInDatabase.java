/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _control;

/**
 *
 * @author ITSUKA KOTORI
 */
public class ExcideInDatabase {
    
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    //<editor-fold defaultstate="collapsed" desc="public static method for check excide or not for current database ... ">
    public static boolean bookingID_EXCIDE(String booking_id){
        return new _da.BookingDA().getRecord(booking_id) != null;
    }
    public static boolean driverID_EXCIDE(String driver_id){
        return new _da.DriverDA().getRecord(driver_id) != null;
    }
    public static boolean paymentID_EXCIDE(String payment_id){
        return new _da.PaymentDA().getRecord(payment_id) != null;
    }
    public static boolean carID_EXCIDE(String car_id){
        return new _da.CarDA().getRecord(car_id) != null;
    }
    public static boolean carTypeID_EXCIDE(String cartype_id){
        return new _da.CarTypeDA().getRecord(cartype_id) != null;
    }
    public static boolean payMethodID_EXCIDE(String paymethod_id){
        return new _da.PaymentMethodDA().getRecord(paymethod_id) != null;
    }
    public static boolean ratingID_EXCIDE(String rating_id){
        return new _da.RatingDA().getRecord(rating_id) != null;
    }
    public static boolean customerID_EXCIDE(String customer_id){
        return new _da.CustomerDA().getRecord(customer_id) != null;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static method ... ">
    public static void main(String[] args){
        if(bookingID_EXCIDE(""))
            System.out.println("The Booking is excite at the darabase!!");
        else
            System.out.println("The booking is not found darabase!!");
    }
    //</editor-fold>
    //</editor-fold>
}
