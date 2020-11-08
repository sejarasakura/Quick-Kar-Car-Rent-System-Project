/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _enum.RatingStar;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Rating extends AbstractDomain{
    private String rating_id;
    private RatingStar rating_star;
    private String cust_comments;
    private Date rating_datetime;

    public Rating() {
    }
    public Rating(String rating_id) {
        this.rating_id = rating_id;
    }
    public Rating(String rating_id, RatingStar rating_star, String cust_comments, Date rating_datetime) {
        this.rating_id = rating_id;
        this.rating_star = rating_star;
        this.cust_comments = cust_comments;
        this.rating_datetime = rating_datetime;
    }
    @Override
    public boolean isNotNull() {
        return this.rating_id.length() == 9;
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.rating_id = rs.getString("rating_id"); // string
            this.rating_star = RatingStar.getValue(rs.getString("rating_star")); // string
            this.cust_comments = rs.getString("cust_comments"); // string
            this.rating_datetime = rs.getTimestamp("rating_datetime"); // string
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
        final Rating other = (Rating) obj;
        if (!Objects.equals(this.rating_id, other.rating_id)) {
            return false;
        }
        if (!Objects.equals(this.rating_datetime, other.rating_datetime)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rating_id);
        return hash;
    }
    @Override
    public String toString() {
        return "Rating{" + "rating_id=" + rating_id + ", rating_star=" + rating_star + ", cust_comments=" + cust_comments + ", rating_datetime=" + rating_datetime + '}';
    }

    public String getRating_id() {
        return rating_id;
    }

    public RatingStar getRating_star() {
        return rating_star;
    }

    public String getCust_comments() {
        return cust_comments;
    }

    public Date getRating_datetime() {
        return rating_datetime;
    }

    public void setRating_id(String rating_id) {
        this.rating_id = rating_id;
    }

    public void setRating_star(RatingStar rating_star) {
        this.rating_star = rating_star;
    }

    public void setCust_comments(String cust_comments) {
        this.cust_comments = cust_comments;
    }

    public void setRating_datetime(Date rating_datetime) {
        this.rating_datetime = rating_datetime;
    }
    
    
    
}
