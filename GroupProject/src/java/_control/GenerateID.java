package _control;
//<editor-fold defaultstate="collapsed" desc="Imported documents.">
import _domain.*;
import _da.*;
import _enum.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.*;
//</editor-fold>
public class GenerateID {
    // All the funtion is for generate id or primary key for the database
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    private static Date date = new Date();
    private static DataReader datareader = new DataReader("Start connection");
    private static SimpleDateFormat sf = new SimpleDateFormat("ddMMyy");
    private static SimpleDateFormat sf_y = new SimpleDateFormat("yy");
    private static SimpleDateFormat sf_yyyy = new SimpleDateFormat("ddMMyyyy");
    //<editor-fold defaultstate="collapsed" desc="private static class DataReader...">
    private static class DataReader extends AbstractDA{
        Statement stmt_s;
        public DataReader(String tableName) {
            super(tableName);
        }
        public int excuteQuery(String tablename, String pk_row_name, int start, int end) {
                return this.excuteConditionQuery(tablename, pk_row_name, start, end, "1=1");
        }
        public int excuteConditionQuery(String tablename, String pk_row_name, int start, int end, String condition) {
                //SUBSTR('cc', start, end);
                String query = "SELECT SUBSTR("+pk_row_name+", "+start+", "+end+") FROM (SELECT * FROM "+ tablename + " WHERE "+ condition 
                        +" ORDER BY SUBSTR("+pk_row_name+", "+start+", "+end+") DESC) as TEMP FETCH FIRST 1 ROWS ONLY";
                try {
                    stmt_s =  conn.createStatement();
                    ResultSet rs = stmt_s.executeQuery(query);
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    if(ex.getErrorCode() != -20001)
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR" + ex.getErrorCode(), JOptionPane.ERROR_MESSAGE);
                }
                return 0;
        }
        public int excuteNumberQuery(String tablename) {
                //SUBSTR('cc', start, end);
                String query = "SELECT COUNT(*) FROM "+ tablename+ "";
                try {
                    stmt_s =  conn.createStatement();
                    ResultSet rs = stmt_s.executeQuery(query);
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                return 0;
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_Cust() function">
    public static String generate_Cust(MembershipLevel member_L){
        int seq = datareader.excuteQuery("Customer", "cust_id", 3, 3);
        if(seq == 0){
            if(datareader.excuteNumberQuery("Customer") != 0)
            return "error";
        }
        return String.format("%s%03d%s", member_L.getDatabaseCode(), 
                ++seq, sf.format(date));
    }
    public static String generate_Cust(Customer member_L) {
        return generate_Cust(member_L.getMembership_level());
    }
    public static String generate_Cust(String member_L) {
        return generate_Cust(MembershipLevel.getValue(member_L));
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_Rating() function">
    public static String generate_Rating(){
        int seq = datareader.excuteQuery("Rating", "rating_id", 2, 6);
        if(seq == 0){
            if(datareader.excuteNumberQuery("Rating") != 0)
            return "error";
        }
        return String.format("%s%06d%s", "R", ++seq, sf_y.format(date));
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_CarType() function">
    public static String generate_CarType(){
        int seq = datareader.excuteQuery("CarType", "car_type_id", 2, 5);
        if(seq == 0){
            if(datareader.excuteNumberQuery("CarType") != 0)
            return "error";
        }
        return String.format("%s%05d", "CT", ++seq);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_PayMethod() function">
    public static String generate_PayMethod_s(String pd, String user_id){
        int seq = datareader.excuteQuery("Payment_method", "pay_method_id", 3 + user_id.length(), 2);
        return String.format("%s%s%02d", pd, user_id, ++seq);
    }
    public static String generate_PayMethod(PaymentMethod pm) {return generate_PayMethod(pm.getPay_method(), pm.getUser());}
    public static String generate_PayMethod(Object pm, Object user_id) {
        String pass_pm = null;
        if(pm instanceof _enum.PaymentMethodType)
           pass_pm = ((PaymentMethodType)pm).getCode();
        else if(pm instanceof String){
             PaymentMethodType temp = PaymentMethodType.getValue((String)pm);
             pass_pm = temp != null? temp.getCode(): null;
        }
        if(pass_pm == null)
            JOptionPane.showConfirmDialog(null, "The payment method selection is invalid please try agian ! !", "Payment method exception", JOptionPane.ERROR_MESSAGE);
        else {
            if (user_id instanceof Customer) {
                return generate_PayMethod_s((String)pass_pm, ((Customer) user_id).getCust_id());
            } else if (user_id instanceof Driver) {
                return generate_PayMethod_s((String)pass_pm, ((Driver) user_id).getDriver_id());
            } else if (user_id instanceof String) {
                return generate_PayMethod_s((String)pass_pm, (String)user_id);
            } else {
                JOptionPane.showConfirmDialog(null, "The payment method selection is invalid please try agian ! !", "Payment method exception", JOptionPane.ERROR_MESSAGE);
            }
        }
        return "error";
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_Payment() function">
    public static String generate_Payment(String pay_method_id){
        int seq = datareader.excuteConditionQuery("Payment", "payment_id", 1, 4, "1=1");
        return String.format("%04d%s", ++seq, pay_method_id);
    }
    public static String generate_Payment(PaymentMethod pay_method){
        return generate_Payment(pay_method.getPay_method_id());
    }
    public static String generate_Payment(Payment pay_method){
        return generate_Payment(pay_method.getPayment_method());
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_Driver() function">
    public static String generate_Driver(int year_of_drive, boolean approved){
        int seq = datareader.excuteQuery("Driver", "driver_id", 4, 5);
        if(seq == 0){
            if(datareader.excuteNumberQuery("Driver") != 0)
            return "error";
        }
        if(approved)
            return String.format("D%02d%05d", year_of_drive, ++seq);
        else
            return String.format("E%02d%05d", year_of_drive, ++seq);
    }
    public static String generate_Driver(String driver_id, boolean approved){
        if(approved == true)
            return driver_id.replace("E", "D");
        else
            return driver_id;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_Booking() function">
    public static String generate_Booking(){
        int seq = datareader.excuteQuery("Booking", "booking_id", 10, 8);
        System.out.println(seq);
        if(seq == 0){
            if(datareader.excuteNumberQuery("Booking") != 0)
            return "error";
        }
        seq++;
        return String.format("B%s%08d", sf_yyyy.format(date), seq);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public static String generate_ContactUs() function">
    public static String generate_ContactUs(){
        int seq = datareader.excuteQuery("UnknowContact", "contact_no", 1, 8);
        seq++;
        return String.format("%08d", seq);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="main...">
    public static void main(String[] args) {
        System.out.println(generate_ContactUs());
    }
    //</editor-fold>
    //</editor-fold>
}
