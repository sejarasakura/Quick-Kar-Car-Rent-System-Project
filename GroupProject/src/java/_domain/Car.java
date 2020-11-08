/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _enum.QuicKarType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Car extends AbstractDomain{
    // "XXX 9999"
    private String car_plate_number;
    private CarType car_type;
    private String owner_name;
    private QuicKarType quickar_type;
    private Driver driver;

    public Car() {
    }
    public Car(String code){
        this.car_plate_number = car_plate_number;
    }
    public Car(String car_plate_number, CarType car_type, String owner_name, QuicKarType quickar_type, Driver driver) {
        this.car_plate_number = car_plate_number;
        this.car_type = car_type;
        this.owner_name = owner_name;
        this.quickar_type = quickar_type;
        this.driver = driver;
    }
    @Override
    public boolean isNotNull() {
        if(car_plate_number.length() != 8)
                return false;
        else
                return true;
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.car_plate_number = rs.getString("car_plate_num"); // string
            this.owner_name = rs.getString("owner_name"); // string
            this.car_type = new CarType(rs.getString("car_type_id")); // class
            this.driver = new Driver(rs.getString("driver_id")); // class
            this.quickar_type = QuicKarType.getValue(rs.getString("quickar_type")); // enum
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
        final Car other = (Car) obj;
        if (!Objects.equals(this.car_plate_number, other.car_plate_number)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.car_plate_number);
        return hash;
    }
    @Override
    public String toString() {
        return "Car{" + "car_plate_number=" + car_plate_number + ", car_type=" + car_type + ", owner_name=" + owner_name + ", quickar_type=" + quickar_type + ", driver=" + driver + '}';
    }

    public String getCar_plate_number() {
        return car_plate_number;
    }

    public CarType getCar_type() {
        return car_type;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public QuicKarType getQuickar_type() {
        return quickar_type;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setCar_plate_number(String car_plate_number) {
        this.car_plate_number = car_plate_number;
    }

    public void setCar_type(CarType car_type) {
        this.car_type = car_type;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setQuickar_type(QuicKarType quickar_type) {
        this.quickar_type = quickar_type;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    
}
