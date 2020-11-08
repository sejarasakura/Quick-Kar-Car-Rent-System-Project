/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _enum.PaymentStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Payment extends AbstractDomain{

    DecimalFormat df = new DecimalFormat("###.##");
    private String payment_id;
    private PaymentMethod payment_method;
    private PaymentStatus payment_status;
    private Date payment_date;
    private double payment_amount;

    public Payment() {
    }
    
    public Payment(String payment_id) {
        this.payment_id = payment_id;
    }
    
    public Payment(String payment_id, PaymentMethod payment_method, PaymentStatus payment_status, Date payment_date,double payment_amount) {
        this.payment_id = payment_id;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.payment_date = payment_date;
        this.payment_amount = payment_amount;
    }
    
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.payment_id = rs.getString("payment_id"); // string
            this.payment_method = new PaymentMethod(rs.getString("payment_method")); // string
            this.payment_status = PaymentStatus.getValue(rs.getString("payment_status")); // string
            this.payment_date = rs.getTimestamp("payment_date"); // string
            this.payment_amount = rs.getDouble("pay_amount"); // string
            return true;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex, "Error found in mysql", JOptionPane.ERROR_MESSAGE);
       }
        return false;
    }
    @Override
    public boolean isNotNull() {
        try {
            return payment_id.length() == 18 && payment_amount != 0;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.payment_id);
        return hash;
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
        final Payment other = (Payment) obj;
        if (!Objects.equals(this.payment_id, other.payment_id)) {
            return false;
        }
        return Objects.equals(this.payment_date, other.payment_date);
    }
    @Override
    public String toString() {
        return "Payment{" + "payment_id=" + payment_id + ", payment_method=" + payment_method + ", payment_status=" + payment_status + ", payment_date=" + payment_date + '}';
    }

    public String getPayment_id() {
        return payment_id;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public PaymentStatus getPayment_status() {
        return payment_status;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public double getPayment_amount() {
        return payment_amount;
    }
    
    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }

    public void setPayment_status(PaymentStatus payment_status) {
        this.payment_status = payment_status;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = Double.parseDouble(df.format(payment_amount));
    }
    
}
