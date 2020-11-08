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
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
/**
 *
 * @author ITSUKA KOTORI
 */
public class DriverDA extends AbstractDA{
    
    public DriverDA() {
        super("Driver");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE DRIVER_ID = ?";
        Driver records = new Driver ();
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
            Logger.getLogger(DriverDA.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records;
    }

    public Object[] getRecords(String condition) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE " + condition;
        ArrayList<Driver> records = new ArrayList<>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Driver ());
                records.get(i).split(rs);
                i ++;
            }
            rs.close();
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {            
            Logger.getLogger(DriverDA.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records.toArray();
    }

    @Override
    public Object[] getRecords() {
        return getRecords(" SUBSTR(driver_id, 1, 1) = 'D'");
    }

    @Override
    public boolean addRecord(Object data) {
        String queryStr = "INSERT INTO " + this.tableName + " (driver_id, first_name, last_name, phone_num, "
                + "ic_num, license, year_of_drive, proc_pic, password) VALUES (?,?,?,?,?,?,?,?,?)";
        Driver datax = (Driver)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getDriver_id());
            stmt.setString(2, datax.getFirst_name());
            stmt.setString(3, datax.getLast_name());
            stmt.setString(4, datax.getPhone_num());
            stmt.setString(5, datax.getIc_num());
            stmt.setString(6, datax.getLicense());
            stmt.setInt(7, datax.getYear_of_drive());
            if(datax.getProc_pic() != null)
                stmt.setBlob(8, new SerialBlob(datax.getProc_pic()));
            else
                stmt.setNull(8, java.sql.Types.BLOB);
            stmt.setString(9, datax.getPassword());
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
        String queryStr = "UPDATE " + this.tableName + " SET driver_id = ?, first_name = ?, last_name = ?, phone_num = ?, "
                + "ic_num = ?, license = ?, year_of_drive = ?, proc_pic = ?, password = ? WHERE driver_id = ?";
        Driver datax = (Driver)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getDriver_id());
            stmt.setString(2, datax.getFirst_name());
            stmt.setString(3, datax.getLast_name());
            stmt.setString(4, datax.getPhone_num());
            stmt.setString(5, datax.getIc_num());
            stmt.setString(6, datax.getLicense());
            stmt.setInt(7, datax.getYear_of_drive());
            if(datax.getProc_pic() != null)
                stmt.setBlob(8, new SerialBlob(datax.getProc_pic()));
            else
                stmt.setNull(8, java.sql.Types.BLOB);
            stmt.setString(9, datax.getPassword());
            stmt.setString(10, code);
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
        return super.deleteRecord(primary_key, "driver_id");
    }
    //<editor-fold defaultstate="collapsed" desc="main...">
    public static void main(String[] args) {
        Object[] xs = new DriverDA().getRecords();
        for (int i = 0; i < 10; i++) {
            System.out.println((Driver)xs[i]);
        }
    }
    //</editor-fold>
}
