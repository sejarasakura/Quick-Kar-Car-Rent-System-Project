/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _da;

import _domain.*;
import _enum.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ITSUKA KOTORI
 */
public class PaymentMethodDA extends AbstractDA{
     public PaymentMethodDA() {
        super("Payment_method");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAY_METHOD_ID = ?";
        PaymentMethod records = new PaymentMethod ();
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
        ArrayList<PaymentMethod > records = new ArrayList<PaymentMethod >();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new PaymentMethod ());
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
        ArrayList<PaymentMethod > records = new ArrayList<PaymentMethod >();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new PaymentMethod ());
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
        String queryStr = "INSERT INTO " + this.tableName + " (pay_method_id, user_id, payment_method, card_num) VALUES (?,?,?,?)";
        PaymentMethod datax = (PaymentMethod)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getPay_method_id());
            stmt.setString(2, datax.getUser());
            stmt.setString(3, datax.getPay_method().getCode());
            stmt.setString(4, datax.getCard_num());
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
        String queryStr = "UPDATE " + this.tableName + " SET pay_method_id = ?, user_id = ?, payment_method = ?, card_num = ? WHERE pay_method_id = ?";
        PaymentMethod datax = (PaymentMethod)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getPay_method_id());
            stmt.setString(2, datax.getUser());
            stmt.setString(3, datax.getPay_method().getCode());
            stmt.setString(4, datax.getCard_num());
            stmt.setString(5, code);
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
        return super.deleteRecord(primary_key, "pay_method_id");
    }
}
