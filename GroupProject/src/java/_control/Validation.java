package _control;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Validation {
    
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy"); 
    //<editor-fold defaultstate="collapsed" desc="Validation method car_type_id">
    public static boolean check_CarTypeID(String car_type_id){
        if(car_type_id == null) return false;
        return car_type_id.matches("[C]{1}[T]{1}[0-9]{5}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method series name">
    public static boolean check_SeriesName(String series_name){
        if(series_name == null) return false;
        return series_name.matches("[A-Za-z]*");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method plate number">
    public static boolean check_CarPlateNumber(String car_plate_number){
        if(car_plate_number == null) return false;
        return car_plate_number.matches("[A-Z]{3}[#]{1}[0-9]{4}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method name checking">
    public static boolean check_Name(String name){
        return name == null ? false: name.matches("[A-Za-z ]*");
    }
    public static boolean check_Name(String f_name, String l_name){
        if(f_name == null || l_name == null)
            return false;
        return check_Name(f_name) && check_Name(f_name);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method driver">
    public static boolean check_DriverID(String driver_id){
        if(driver_id == null) return false;
        return driver_id.matches("[D]{1}[0-9]{7}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method phone number">
    public static boolean check_PhoneNumber(String phone_num){
        if(phone_num == null) return false;
        return phone_num.matches("[0-9]{4}[-][0-9]{3}[-][0-9]{4}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method ic number">
    public static boolean check_ICNumber(String ic_num){
        if(ic_num == null) return false;
        return ic_num.matches("[0-9]{6}[-][0-9]{2}[-][0-9]{4}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method license number">
    public static boolean check_license(String license_num){
        return license_num.matches("[0-9]{8}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method rating id ">
    public static boolean check_RatingID(String rating_id){
        return rating_id.matches("[R]{1}[0-9]{8}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method payement id">
    public static boolean check_PaymentID(String payment_id){
        if(payment_id == null) return false;
        return payment_id.matches("[A-Z0-9]{21}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method date range">
    public static boolean check_Date(Date su_date){
        if(su_date == null) return false;
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.setTime(su_date);
        try {
            cal.getTime();
            return (su_date.after(DATE_FORMAT.parse("1-1-1800")) && su_date.before(DATE_FORMAT.parse("1-1-2020")));
        } catch (Exception e) {
                return false;
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method location code & name">
    public static boolean check_LocationCode(String location_code){
        if(location_code == null) return false;
        return location_code.matches("[0-9]{10}");
    }
    
    public static boolean check_LocationName(String location_name){
        if(location_name == null) return false;
        return location_name != null && !"".equals(location_name);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method payment method">
    public static boolean check_PaymentMethodID(String payment_method_id){
        if(payment_method_id == null) return false;
        return payment_method_id.matches("[A-Z]{2}[A-Z]{2}[0-9]{3}[0-9]{6}[0-9]{2}") || 
                payment_method_id.matches("[A-Z]{2}[D]{1}[0-9]{2}[0-9]{5}[0-9]{2}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method admin_id">
    public static boolean check_Admin(String admin_id) {
        if(admin_id == null) return false;
        return admin_id.matches("[a-zA-Z0-9]*");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method password">
    public static boolean check_Password(String password) {
        if(password == null) return false;
        if(password.length() < 8) return false;
        return password.matches("[a-zA-Z0-9]*");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Validation method customer id">
    public static boolean check_CustID(String cust_id) {
        if(cust_id == null) return false;
        if(cust_id.length() < 11) return false;
        return cust_id.matches("[A-Z]{2}[0-9]{9}");
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="main...">
    public static void main(String[] args) {
        String user_ip = "";
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        jf.setLocation(1000, 500);
        while(!user_ip.equals("-999")){
            user_ip = JOptionPane.showInputDialog(jf, "Enter a string to check the result. (-999) exit");
            if(Validation.check_CarPlateNumber(user_ip) == true)
                System.out.println("Validation.check_CarPlateNumber("+user_ip+"); = " + Validation.check_CarPlateNumber(user_ip));
            if(Validation.check_Admin(user_ip) == true)
                System.out.println("Validation.check_Admin("+user_ip+"); = " + Validation.check_Admin(user_ip));
            if(Validation.check_CarTypeID(user_ip) == true)
                System.out.println("Validation.check_CarTypeID("+user_ip+"); = " + Validation.check_CarTypeID(user_ip));
            if(Validation.check_DriverID(user_ip) == true)
                System.out.println("Validation.check_DriverID("+user_ip+"); = " + Validation.check_DriverID(user_ip));
            if(Validation.check_ICNumber(user_ip) == true)
                System.out.println("Validation.check_ICNumber("+user_ip+"); = " + Validation.check_ICNumber(user_ip));
            if(Validation.check_LocationCode(user_ip) == true)
                System.out.println("Validation.check_LocationCode("+user_ip+"); = " + Validation.check_LocationCode(user_ip));
            if(Validation.check_LocationName(user_ip) == true)
                System.out.println("Validation.check_LocationName("+user_ip+"); = " + Validation.check_LocationName(user_ip));
            if(Validation.check_Name(user_ip) == true)
                System.out.println("Validation.check_Name("+user_ip+"); = " + Validation.check_Name(user_ip));
            if(Validation.check_Password(user_ip) == true)
                System.out.println("Validation.check_Password("+user_ip+"); = " + Validation.check_Password(user_ip));
            if(Validation.check_PaymentID(user_ip) == true)
                System.out.println("Validation.check_PaymentID("+user_ip+"); = " + Validation.check_PaymentID(user_ip));
            if(Validation.check_PaymentMethodID(user_ip) == true)
                System.out.println("Validation.check_PaymentMethodID("+user_ip+"); = " + Validation.check_PaymentMethodID(user_ip));
            if(Validation.check_PhoneNumber(user_ip) == true)
                System.out.println("Validation.check_PhoneNumber("+user_ip+"); = " + Validation.check_PhoneNumber(user_ip));
            if(Validation.check_RatingID(user_ip) == true)
                System.out.println("Validation.check_RatingID("+user_ip+"); = " + Validation.check_RatingID(user_ip));
            if(Validation.check_SeriesName(user_ip) == true)
                System.out.println("Validation.check_SeriesName("+user_ip+"); = " + Validation.check_SeriesName(user_ip));
            if(Validation.check_license(user_ip) == true)
                System.out.println("Validation.check_license("+user_ip+"); = " + Validation.check_license(user_ip));
        }
    }
    //</editor-fold>
    //</editor-fold>

}
