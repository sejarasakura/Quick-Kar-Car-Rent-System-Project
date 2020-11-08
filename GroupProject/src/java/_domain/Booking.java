/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _enum.*;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Booking extends AbstractDomain{

    private String booking_id;
    private Rating rating;
    private Customer customer;
    private Driver driver;
    private Payment payment;
    private Date booking_date;
    private Date fetch_date;
    private BookingStatus booking_status;
    private String start_location;
    private String end_location;

    public Booking() {
    }
    public Booking(String booking_id) {
        this.booking_id = booking_id;
    }
    public Booking(String booking_id, Rating rating, Customer customer, Driver car, Payment payment, Date booking_date, Date fetch_date, BookingStatus booking_status, String start_location, String end_location) {
        this.booking_id = booking_id;
        this.rating = rating;
        this.customer = customer;
        this.driver = car;
        this.payment = payment;
        this.booking_date = booking_date;
        this.fetch_date = fetch_date;
        this.booking_status = booking_status;
        this.start_location = start_location;
        this.end_location = end_location;
    }

    @Override
    public boolean isNotNull() {
        try {
            return this.booking_id.length() == 18;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.booking_id = rs.getString("booking_id"); // string
            this.rating = new Rating(rs.getString("rating_id")); // string
            this.customer = new Customer(rs.getString("cust_id")); // string
            this.driver = new Driver(rs.getString("driver_id")); // string
            this.payment = new Payment(rs.getString("payment_id")); // string
            this.booking_date = rs.getTimestamp("booking_date"); // string
            this.fetch_date = rs.getTimestamp("fetch_date"); // string
            this.booking_status = BookingStatus.getValue(rs.getString("booking_status")); // string
            this.start_location = rs.getString("start_location_code"); // string
            this.end_location = rs.getString("end_location_code"); // string
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
        final Booking other = (Booking) obj;
        if (!Objects.equals(this.booking_id, other.booking_id)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.booking_id);
        return hash;
    }
    @Override
    public String toString() {
        return "Booking{" + "booking_id=" + booking_id + ", rating=" + rating + ", customer=" + customer + ", car=" + driver + ", payment=" + payment + ", booking_date=" + booking_date + ", fetch_date=" + fetch_date + ", booking_status=" + booking_status + ", start_location=" + start_location + ", end_location=" + end_location + '}';
    }

    public String getBooking_id() {
        return booking_id;
    }

    public Rating getRating() {
        return rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public Payment getPayment() {
        return payment;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public Date getFetch_date() {
        return fetch_date;
    }

    public BookingStatus getBooking_status() {
        return booking_status;
    }

    public String getStart_location() {
        return start_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public void setFetch_date(Date fetch_date) {
        this.fetch_date = fetch_date;
    }

    public void setBooking_status(BookingStatus booking_status) {
        this.booking_status = booking_status;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
    }

    public void setEnd_location(String end_location) {
        this.end_location = end_location;
    }
    
}
