/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _manipulation.Converter;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Location extends AbstractDomain{

    private String location_code;
    private String location_address;
    private double y_latitude;
    private double x_longtitude;
    
    public Location() {
    }
    public Location(String location_code) {
        this.location_code = location_code;
    }
    public Location(String location_code, String location_name, double y_latitude, double x_longtitude) {
        this.location_code = location_code;
        this.location_address = location_name;
        this.y_latitude = y_latitude;
        this.x_longtitude = x_longtitude;
    }
    @Override
    public boolean isNotNull() {
        return location_code.length() == 10;
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.location_code = rs.getString("location_code"); // string
            this.x_longtitude = rs.getDouble("x_longtitude"); // string
            this.y_latitude = rs.getDouble("y_latitude"); // string
            this.location_address = rs.getString("location_name"); // string
            return true;
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.location_code, other.location_code)) {
            return false;
        }
        if (!Objects.equals(this.x_longtitude, other.x_longtitude)) {
            return false;
        }if (!Objects.equals(this.y_latitude, other.y_latitude)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.location_code);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "location_code=" + location_code + ", location_name=" + location_address + ", y_latitude=" + y_latitude + ", x_longtitude=" + x_longtitude + '}';
    }

    public String getLocation_code() {
        return location_code;
    }

    public String getLocation_address() {
        return location_address;
    }
    
    public double getY_latitude() {
        return y_latitude;
    }
    public double getX_longtitude() {
        return x_longtitude;
    }
    
}
