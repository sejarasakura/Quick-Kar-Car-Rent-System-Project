/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Driver extends User{

    private String driver_id;
    private String license;
    private int year_of_drive;

    public Driver() {
        
    }
    public Driver(String driver_id) {
        this.driver_id = driver_id;
    }
    public Driver(String driver_id, String lecense, int year_of_drive, String first_name, String last_name, String ic_num, String phone_num, String password, byte[] proc_pic) {
        super(first_name, last_name, ic_num, phone_num, password, proc_pic);
        this.driver_id = driver_id;
        this.license = lecense;
        this.year_of_drive = year_of_drive;
    }
    @Override
    public boolean isNotNull() {
        try {
            return this.driver_id.length() == 8;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.driver_id = rs.getString("driver_id"); // string
            this.license = rs.getString("license"); // string
            this.year_of_drive = rs.getInt("year_of_drive"); // string
            return super.split(rs);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex, "Error found in mysql", JOptionPane.ERROR_MESSAGE);
       }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Driver other = (Driver) obj;
        if (!Objects.equals(this.driver_id, other.driver_id)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.driver_id);
        return hash;
    }
    @Override
    public String toString() {
        return "Driver{" + "driver_id=" + driver_id + ", lecense=" + license + ", year_of_drive=" + year_of_drive + '}' + super.toString();
    }

    public String getDriver_id() {
        return driver_id;
    }

    public String getLicense() {
        return license;
    }

    public int getYear_of_drive() {
        return year_of_drive;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setYear_of_drive(int year_of_drive) {
        this.year_of_drive = year_of_drive;
    }
    
}
