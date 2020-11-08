/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ITSUKA KOTORI
 */
public class PaymentDA extends AbstractDA{
    public PaymentDA() {
        super("Payment");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENT_ID = ?";
        Payment records = new Payment ();
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
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records;
    }

    @Override
    public Object[] getRecords() {
        String queryStr = "SELECT * FROM " + tableName + "";
        ArrayList<Payment > records = new ArrayList<Payment >();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Payment ());
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
        String queryStr = "INSERT INTO " + this.tableName + " (payment_id, payment_method, payment_status, payment_date, "
                + "pay_amount) VALUES (?,?,?,?,?)";
        Payment datax = (Payment)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getPayment_id());
            stmt.setString(2, datax.getPayment_method().getPay_method_id());
            stmt.setString(3, datax.getPayment_status().getCode());
            stmt.setTimestamp(4, new Timestamp(datax.getPayment_date().getTime()));
            stmt.setDouble(5, datax.getPayment_amount());
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
        String queryStr = "UPDATE " + this.tableName + " SET payment_id = ?, payment_method = ?, "
                + "payment_status = ?, payment_date = ?, pay_amount = ? WHERE payment_id = ?";
        Payment datax = (Payment)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getPayment_id());
            stmt.setString(2, datax.getPayment_method().getPay_method_id());
            stmt.setString(3, datax.getPayment_status().getCode());
            stmt.setTimestamp(4, new Timestamp(datax.getPayment_date().getTime()));
            stmt.setDouble(5, datax.getPayment_amount());
            stmt.setString(6, code);
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
        return super.deleteRecord(primary_key, "payment_id");
    }
}
