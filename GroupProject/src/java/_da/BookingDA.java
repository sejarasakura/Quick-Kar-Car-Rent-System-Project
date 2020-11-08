package _da;

import _domain.*;
import _manipulation.Converter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BookingDA extends AbstractDA{

    public static void main(String[] args) {
        Object[] data = new BookingDA().getRecords();
        int max = (data.length > 10?10:data.length);
        for(int i = 0; i < max ; i++){
            System.out.println(((Booking)data[i]).toString());
        }
    }

    public BookingDA() {
        super("Booking");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BOOKING_ID = ?";
        Booking records = new Booking();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                records.split(rs);
            }
            rs.close();
            stmt.close();
            conn.commit();
            return records;
        } catch (SQLException ex) {
            if(ex.getErrorCode() != -20001)
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR" + ex.getErrorCode(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public Object[] getRecords() {
        String queryStr = "SELECT * FROM " + tableName + "";
        ArrayList<Booking> records = new ArrayList<Booking>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Booking());
                records.get(i).split(rs);
                i ++;
            }
            rs.close();
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records.toArray();
    }
    
    public Object[] getRecords(String condition) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE " + condition;
        ArrayList<Booking> records = new ArrayList<Booking>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Booking());
                records.get(i).split(rs);
                i ++;
            }
            rs.close();
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records.toArray();
    }

    @Override
    public boolean addRecord(Object data) {
        String queryStr = "INSERT INTO " + this.tableName + "(booking_id, rating_id, cust_id, driver_id, payment_id,"
            + " booking_date, fetch_date, booking_status, start_location_code, end_location_code) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Booking datax = (Booking)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getBooking_id());
            stmt.setString(2, datax.getRating().getRating_id());
            stmt.setString(3, datax.getCustomer().getCust_id());
            stmt.setString(4, datax.getDriver().getDriver_id());
            stmt.setString(5, datax.getPayment().getPayment_id());
            stmt.setTimestamp(6, new Timestamp(datax.getBooking_date().getTime()));
            stmt.setTimestamp(7, new Timestamp(datax.getFetch_date().getTime()));
            stmt.setString(8, datax.getBooking_status().getCode());
            stmt.setString(9, datax.getStart_location());
            stmt.setString(10, datax.getEnd_location());
            boolean boo = stmt.executeUpdate() == 1;
            stmt.close();
            conn.commit();
            return boo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean updateRecord(Object new_data, String code) {
        String queryStr = "UPDATE " + this.tableName + " SET booking_id = ?, rating_id = ?, cust_id = ?, driver_id = ?, payment_id = ?,"
            + " booking_date = ?, fetch_date = ?, booking_status = ?, start_location_code = ?, end_location_code = ? WHERE booking_id = ?";
        Booking datax = (Booking)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getBooking_id());
            stmt.setString(2, datax.getRating().getRating_id());
            stmt.setString(3, datax.getCustomer().getCust_id());
            stmt.setString(4, datax.getDriver().getDriver_id());
            stmt.setString(5, datax.getPayment().getPayment_id());
            stmt.setTimestamp(6, new Timestamp(datax.getBooking_date().getTime()));
            stmt.setTimestamp(7, new Timestamp(datax.getFetch_date().getTime()));
            stmt.setString(8, datax.getBooking_status().getCode());
            stmt.setString(9, datax.getStart_location());
            stmt.setString(10, datax.getEnd_location());
            stmt.setString(11, code);
            boolean boo = stmt.executeUpdate() == 1;
            stmt.close();
            conn.commit();
            return boo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteRecord(String primary_key) {
        return super.deleteRecord(primary_key, "booking_id");
    }
    
}
