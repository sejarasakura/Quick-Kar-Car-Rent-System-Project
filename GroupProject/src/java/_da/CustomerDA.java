
package _da;

//<editor-fold defaultstate="collapsed" desc="import documents...">
import _domain.*;
import _enum.*;
import _manipulation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;
//</editor-fold>

public class CustomerDA extends AbstractDA{
 //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    
    //<editor-fold defaultstate="collapsed" desc="constructor...">
    public CustomerDA() {
        super("Customer");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="override method...">
    @Override
    public Object getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUST_ID = ?";
        Customer records = new Customer();
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
        ArrayList<Customer> records = new ArrayList<Customer>();
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                records.add(new Customer());
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
        String queryStr = "INSERT INTO " + this.tableName + " (Cust_id, first_name, last_name, phone_num, "
                + "ic_num, point_amount, membership_level, proc_pic, password) VALUES (?,?,?,?,?,?,?,?,?)";
        Customer datax = (Customer)data;
        int i = 0;
        boolean r = false;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getCust_id());
            stmt.setString(2, datax.getFirst_name());
            stmt.setString(3, datax.getLast_name());
            stmt.setString(4, datax.getPhone_num());
            stmt.setString(5, datax.getIc_num());
            stmt.setDouble(6, datax.getPoint_amount());
            stmt.setString(7, datax.getMembership_level().getDatabaseCode());
            if(datax.getProc_pic() != null)
                stmt.setBlob(8, new SerialBlob(datax.getProc_pic()));
            else
                stmt.setNull(8, java.sql.Types.BLOB);
            stmt.setString(9, datax.getPassword());
            r = stmt.executeUpdate() == 1;
            stmt.close();
            conn.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }

    @Override
    public boolean updateRecord(Object new_data, String code) {
        
        String queryStr = "UPDATE " + this.tableName + " SET Cust_id = ?, first_name = ?, last_name = ?, phone_num = ?, "
                + "ic_num = ?, point_amount = ?, membership_level = ?, proc_pic = ?, password = ? WHERE Cust_id = ?";
        Customer datax = (Customer)new_data;
        if(datax.getProc_pic() == null)
            queryStr = queryStr.replace("proc_pic = ?, ", "");
        int i = 0;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, datax.getCust_id());
            stmt.setString(2, datax.getFirst_name());
            stmt.setString(3, datax.getLast_name());
            stmt.setString(4, datax.getPhone_num());
            stmt.setString(5, datax.getIc_num());
            stmt.setDouble(6, datax.getPoint_amount());
            stmt.setString(7, datax.getMembership_level().getDatabaseCode());
            if(datax.getProc_pic() != null){
                stmt.setBlob(8, new SerialBlob(datax.getProc_pic()));
                stmt.setString(9, datax.getPassword());
                stmt.setString(10, code);
            }
            else{
                stmt.setString(8, datax.getPassword());
                stmt.setString(9, code);
            }
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
        return super.deleteRecord(primary_key, "cust_id");
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main...">
    public static void main(String[] args) {
        Object[] xs = new CustomerDA().getRecords();
        for (int i = 0; i < 10; i++) {
            System.out.println((Customer)xs[i]);
        }
        String code = ((Customer)xs[6]).getCust_id();
        Object data = xs[6];
        new CustomerDA().updateRecord(data, code);
    }
    //</editor-fold>
 //</editor-fold>
}
