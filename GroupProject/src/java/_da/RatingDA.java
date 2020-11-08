/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _da;

import _domain.*;
import _enum.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ITSUKA KOTORI
 */
public class RatingDA extends AbstractDA{
        public RatingDA() {
        super("Rating");
    }

    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE RATING_ID = ?";
        Rating records = new Rating ();
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
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records;
    }

    @Override
    public Object[] getRecords() {
        String queryStr = "SELECT * FROM " + tableName + "";
        ArrayList<Rating> records = new ArrayList<Rating>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Rating());
                records.get(i).split(rs);
                i ++;
            }
            rs.close();
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return records.toArray();
    }

    @Override
    public boolean addRecord(Object data) {
        String queryStr = "INSERT INTO " + this.tableName + " (rating_id, rating_star, cust_comments, rating_datetime) VALUES (?,?,?,?)";
        Rating datax = (Rating)data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getRating_id());
            stmt.setString(2, datax.getRating_star().getCode());
            if(datax.getCust_comments() != null && datax.getCust_comments() != "")
                stmt.setString(3, datax.getCust_comments());
            else
                stmt.setString(3, "");
            stmt.setTimestamp(4, new Timestamp(datax.getRating_datetime().getTime()));
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
        String queryStr = "UPDATE " + this.tableName + " SET rating_id = ?, rating_star = ?, cust_comments = ?, rating_datetime = ? WHERE rating_id = ?";
        Rating datax = (Rating)new_data;
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getRating_id());
            stmt.setString(2, datax.getRating_star().getCode());
            stmt.setString(3, datax.getCust_comments());
            stmt.setTimestamp(4, new Timestamp(datax.getRating_datetime().getTime()));
            stmt.setString(5, datax.getRating_id());
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
        return super.deleteRecord(primary_key, "rating_id");
    }
}
