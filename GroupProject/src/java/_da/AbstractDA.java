package _da;

//<editor-fold defaultstate="collapsed" desc="Imported documents.">
import _control.domain.DatabaseControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import _manipulation.Path_Manipulate;
import _servlet.admin_console.restore_backup;
import java.util.Properties;

//</editor-fold>
public abstract class AbstractDA{
 //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    //<editor-fold defaultstate="collapsed" desc="properties...">
    protected static final DatabaseControl DATABASE = DatabaseControl.get_Database(Path_Manipulate.getDatabaseDirectory() + "xml/database_info.xml");
    protected String tableName = "Abstract Table";
    protected Connection conn;
    protected PreparedStatement stmt;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructor...">
    protected AbstractDA(String tableName) {
        this.tableName = tableName;
        createConnection();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="private method...">
    private void createConnection() {
        try {
            Class.forName(DATABASE.getJdbcDrive()).newInstance();
            String host = DATABASE.getHost() + Path_Manipulate.getDatabaseDirectory() + DATABASE.getDatabaseName();
            conn = DriverManager.getConnection( host ,  DATABASE.getUsername(), DATABASE.getPassword());
            System.out.println("***TRACE: Connection established : " + this.tableName);
            return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
             Logger.getLogger(AbstractDA.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AbstractDA.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("***TRACE: Unable to connection : " + this.tableName);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="protected method...">
    protected void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected boolean deleteRecord(String primary_key, String col_name){
        String queryStr = "DELETE FROM " + tableName + " WHERE "+col_name+" = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, primary_key);
            boolean x = stmt.executeUpdate() == 1;
            stmt.close();
            conn.commit();
            return x;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public method ... ">
    public Object getRecord(String code){
        return null;
    }
    
    public Object[] getRecords(){
        return null;
    }
    
    public boolean addRecord(Object data){
        return false;
    }
    
    public boolean updateRecord(Object new_data, String code){
        return false;
    }
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="main...">
    public static void main(String[] args) {
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="main...">
    public boolean recovery_database(String full_filename_restore_from){
        String nsURL2 = null, nsURL1 = null;
        try {
            Class.forName(DATABASE.getJdbcDrive()).newInstance();
            Properties connectionProps = new Properties();
            nsURL1 = DATABASE.getHost() + Path_Manipulate.getDatabaseDirectory() + 
                    DATABASE.getDatabaseName() + ";shutdown=true";
            nsURL2 = DATABASE.getHost() + Path_Manipulate.getDatabaseDirectory() + 
                    DATABASE.getDatabaseName() + ";restoreFrom="+ full_filename_restore_from + "/" + DATABASE.getDatabaseName();
            connectionProps.setProperty("user", DATABASE.getUsername());
            connectionProps.setProperty("password", DATABASE.getPassword());
            try{this.conn.close();}catch(Exception ex){}
            try{DriverManager.getConnection(nsURL1, connectionProps);}catch(Exception ex){}
            this.conn = DriverManager.getConnection(nsURL2, connectionProps);
            this.conn.commit();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(restore_backup.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, ex +"\n"+ nsURL1 +"\n"+ nsURL2, "ClassNotFoundException- Url = " + nsURL1 + nsURL2, JOptionPane.DEFAULT_OPTION);
        } catch (InstantiationException ex) {
            Logger.getLogger(restore_backup.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, ex +"\n"+ nsURL1 +"\n"+ nsURL2, "InstantiationException - Url = " + nsURL1 + nsURL2, JOptionPane.DEFAULT_OPTION);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(restore_backup.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, ex +"\n"+ nsURL1 +"\n"+ nsURL2, "IllegalAccessException- Url = ", JOptionPane.DEFAULT_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(restore_backup.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, ex +"\n"+ nsURL1 +"\n"+ nsURL2, "SQLException - Url = " + nsURL1 + nsURL2, JOptionPane.DEFAULT_OPTION);
        }
        return false;
    }
    public void shutdowns(){
        this.shutDown();
    }
    //</editor-fold>
    //</editor-fold>

}
