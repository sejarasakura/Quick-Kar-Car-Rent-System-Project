/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _manipulation.Converter;
import java.awt.Image;
import java.io.IOException;
import java.sql.Blob;
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
public abstract class User extends AbstractDomain{
    
 //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    protected String first_name;
    protected String last_name;
    protected String ic_num;
    protected String phone_num;
    protected String password;
    protected byte[] proc_pic;
    
 //<editor-fold defaultstate="collapsed" desc="Constructor...">
    public User(){
        this("", "", "", "", "", null);
    };
    public User(String first_name, String last_name, String ic_num, String phone_num, String password, byte[] proc_pic) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ic_num = ic_num;
        this.phone_num = phone_num;
        this.password = password;
        this.proc_pic = proc_pic;
    }
 //</editor-fold>
 //<editor-fold defaultstate="collapsed" desc="Override method...">
    @Override 
    public boolean isNotNull(){
        return this.ic_num.length() == 14;
    }
    @Override
    public boolean split(ResultSet rs){
        try {
            this.first_name = rs.getString("first_name"); // string
            this.last_name = rs.getString("last_name"); // string
            this.ic_num = rs.getString("ic_num"); // string
            this.phone_num = rs.getString("phone_num"); // string
            this.password = rs.getString("password"); // string
            Blob blob = rs.getBlob("proc_pic");
            if(blob != null)
                this.proc_pic = blob.getBytes(1, (int)blob.length()); // string
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
        final User other = (User) obj;
        return Objects.equals(this.ic_num, other.ic_num);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.ic_num);
        return hash;
    }
    @Override
    public String toString() {
        return "User{" + "first_name=" + first_name + ", last_name=" + last_name + ", ic_num=" + ic_num + ", phone_num=" + phone_num +", password=" + password + '}';
    }
 //</editor-fold>
 //<editor-fold defaultstate="collapsed" desc="Getterand setter...">
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getIc_num() {
        return ic_num;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getProc_pic() {
        return proc_pic;
    }

    public String getFull_Name() {
        return first_name +" "+ last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setIc_num(String ic_num) {
        this.ic_num = ic_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProc_pic(byte[] proc_pic) {
        this.proc_pic = proc_pic;
    }
 //</editor-fold">
 //</editor-fold">
}
