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

public class ContactUsDA extends AbstractDA{

    public ContactUsDA() {
        super("UnknowContact");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE contact_no  = ?";
        ContactUs records = new ContactUs();
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
        } catch (SQLException ex) {
            if(ex.getErrorCode() != -20001)
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR" + ex.getErrorCode(), JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return records;
    }

    @Override
    public Object[] getRecords() {
        String queryStr = "SELECT * FROM " + tableName + "";
        ArrayList<ContactUs> records = new ArrayList<ContactUs>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new ContactUs());
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
        ArrayList<ContactUs> records = new ArrayList<ContactUs>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new ContactUs());
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
        String queryStr = "INSERT INTO " + this.tableName 
                + "(contact_no, name, email, phone, message, send_date)" +
                "values (?, ?, ?, ?, ?, ?)";
        ContactUs datax = (ContactUs)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getId());
            stmt.setString(2, datax.getName());
            stmt.setString(3, datax.getEmail());
            stmt.setString(4, datax.getPhone());
            stmt.setString(5, datax.getMessagge());
            stmt.setTimestamp(6, new Timestamp(datax.getContact_date().getTime()));
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
        String queryStr = "UPDATE " + this.tableName + " SET contact_no = ?, name = ?, email = ?, phone = ?, message = ?,"
            + " send_date = ? WHERE contact_no = ?";
        ContactUs datax = (ContactUs)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getId());
            stmt.setString(2, datax.getName());
            stmt.setString(3, datax.getEmail());
            stmt.setString(4, datax.getPhone());
            stmt.setString(5, datax.getMessagge());
            stmt.setTimestamp(6, new Timestamp(datax.getContact_date().getTime()));
            stmt.setString(7, datax.getId());
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
        return super.deleteRecord(primary_key, "contact_no");
    }
    
}
