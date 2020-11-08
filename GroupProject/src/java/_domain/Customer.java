/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _enum.MembershipLevel;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Customer extends User{

    private String cust_id;
    private int point_amount;
    private MembershipLevel membership_level;

    public Customer() {
    }
    public Customer(String cust_id) {
        this.cust_id = cust_id;
    }
    public Customer(String cust_id, int point_amount, MembershipLevel membership_level, String first_name, String last_name, String ic_num, String phone_num, String password, byte[] proc_pic) {
        super(first_name, last_name, ic_num, phone_num, password, proc_pic);
        this.cust_id = cust_id;
        this.point_amount = point_amount;
        this.membership_level = membership_level;
    }
    @Override
    public boolean isNotNull() {
        return cust_id.length() == 10;
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.cust_id = rs.getString("cust_id"); // string
            this.membership_level = MembershipLevel.getValue(rs.getString("membership_level")); // string
            this.point_amount = rs.getInt("point_amount"); // string
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
        final Customer other = (Customer) obj;
        if (this.point_amount != other.point_amount) {
            return false;
        }
        if (!Objects.equals(this.cust_id, other.cust_id)) {
            return false;
        }
        if (!Objects.equals(this.membership_level, other.membership_level)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.cust_id);
        return hash;
    }
    @Override
    public String toString() {
        return "Customer{" + "cust_id=" + cust_id + ", point_amount=" + point_amount + ", membership_level=" + membership_level + '}' + super.toString();
    }

    public String getCust_id() {
        return cust_id;
    }

    public int getPoint_amount() {
        return point_amount;
    }

    public MembershipLevel getMembership_level() {
        return membership_level;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public void setPoint_amount(int point_amount) {
        this.point_amount = point_amount;
    }

    public void setMembership_level(MembershipLevel membership_level) {
        this.membership_level = membership_level;
    }
    
}
