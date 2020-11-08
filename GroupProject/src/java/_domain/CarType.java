/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class CarType extends AbstractDomain{

    private String car_type_id;
    private String car_type_name;
    private int cust_capacity;

    public CarType() {
    }
    public CarType(String car_type_id) {
        this.car_type_id = car_type_id;
    }
    public CarType(String car_type_id, String car_type_name, int cust_capacity) {
        this.car_type_id = car_type_id;
        this.car_type_name = car_type_name;
        this.cust_capacity = cust_capacity;
    }
    @Override
    public boolean isNotNull() {
        return car_type_id.length() == 8;
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.car_type_id = rs.getString("car_type_id"); // string
            this.car_type_name = rs.getString("car_series_name"); // string
            this.cust_capacity = rs.getInt("cust_capacity"); // int
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
        final CarType other = (CarType) obj;
        if (!Objects.equals(this.car_type_id, other.car_type_id)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.car_type_id);
        return hash;
    }
    @Override
    public String toString() {
        return "CarType{" + "car_type_id=" + car_type_id + ", car_type_name=" + car_type_name + ", cust_capacity=" + cust_capacity + '}';
    }

    public String getCar_type_id() {
        return car_type_id;
    }

    public String getCar_type_name() {
        return car_type_name;
    }

    public int getCust_capacity() {
        return cust_capacity;
    }

    public void setCar_type_id(String car_type_id) {
        this.car_type_id = car_type_id;
    }

    public void setCar_type_name(String car_type_name) {
        this.car_type_name = car_type_name;
    }

    public void setCust_capacity(int cust_capacity) {
        this.cust_capacity = cust_capacity;
    }
    
}
