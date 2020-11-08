/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _da;

import _domain.*;
import _enum.*;
import _manipulation.Converter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class CarDA extends AbstractDA{
    
    public static void main(String[] args) {
        Object[] data = new CarDA().getRecords();
        int max = (data.length > 10?10:data.length);
        for(int i = 0; i < max ; i++){
            System.out.println(((Car)data[i]).toString());
        }
    }

    public CarDA() {
        super("Car");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CAR_PLATE_NUM = ?";
        Car records = new Car();
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
        ArrayList<Car> records = new ArrayList<Car>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Car ());
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
        ArrayList<Car> records = new ArrayList<Car>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Car ());
                records.get(i).split(rs);
                i ++;
            }
            rs.close();
            stmt.close();
            conn.commit();        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records.toArray();
    }

    @Override
    public boolean addRecord(Object data) {
        String queryStr = "INSERT INTO " + this.tableName + " (car_plate_num, car_type_id, "
                + "owner_name, quickar_type, driver_id) VALUES (?,?,?,?,?)";
        Car datax = (Car)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getCar_plate_number());
            stmt.setString(2, datax.getCar_type().getCar_type_id());
            stmt.setString(3, datax.getOwner_name());
            stmt.setString(4, datax.getQuickar_type().getCode());
            stmt.setString(5, datax.getDriver().getDriver_id());
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
        String queryStr = "INSERT INTO " + this.tableName + " car_plate_num = ?, car_type_id = ?, "
                + "owner_name = ?, quickar_type = ?, driver_id = ? WHERE car_plate_num = ?";
        Car datax = (Car)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getCar_plate_number());
            stmt.setString(2, datax.getCar_type().getCar_type_id());
            stmt.setString(3, datax.getOwner_name());
            stmt.setString(4, datax.getQuickar_type().getCode());
            stmt.setString(5, datax.getDriver().getDriver_id());
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
        return super.deleteRecord(primary_key, "car_plate_num");
    }
}
