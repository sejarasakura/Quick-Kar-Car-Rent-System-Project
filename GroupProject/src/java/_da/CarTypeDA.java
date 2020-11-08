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
public class CarTypeDA extends AbstractDA{

    public CarTypeDA() {
        super("CarType");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CAR_TYPE_ID = ?";
        CarType records = new CarType ();
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
            return null;
        }
        return records;
    }

    @Override
    public Object[] getRecords() {
        String queryStr = "SELECT * FROM " + tableName + "";
        ArrayList<CarType > records = new ArrayList<CarType >();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new CarType ());
                records.get(i).split(rs);
                i ++;
            }
            rs.close();
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return records.toArray();
    }

    @Override
    public boolean addRecord(Object data) {
        String queryStr = "INSERT INTO " + this.tableName + " (car_type_id, "
                + "car_series_name, cust_capacity) VALUES (?,?,?)";
        CarType datax = (CarType)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getCar_type_id());
            stmt.setString(2, datax.getCar_type_name());
            stmt.setInt(3, datax.getCust_capacity());
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
        String queryStr = "UPDATE " + this.tableName + " SET car_type_id = ?, "
                + "car_series_name = ?, cust_capacity = ? WHERE car_type_id = ?";
        CarType datax = (CarType)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getCar_type_id());
            stmt.setString(2, datax.getCar_type_name());
            stmt.setInt(3, datax.getCust_capacity());
            stmt.setString(4, code);
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
        return super.deleteRecord(primary_key, "car_type_id");
    }
}
