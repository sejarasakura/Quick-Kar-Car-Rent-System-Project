package _da;

import _domain.*;
import _manipulation.Converter;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ImageDA extends AbstractDA{
    private static final int CUSTOMER = 0;
    private static final int DRIVER = 1;
    private static final String TABLES[] = {"Customer", "Driver"};
    private static final String ID_VALUE[] = {"cust_id", "driver_id"};
    public ImageDA() {
        super("Image DA");
    }
    private byte[] retrive(String id,int user_type) throws SQLException{
      String sql = "Select proc_pic from "+TABLES[user_type]+" where "+ID_VALUE[user_type]+" = ?";
      byte[] imageData = null;
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Blob blob = rs.getBlob("proc_pic");
                if(blob != null){
                    imageData = blob.getBytes(1, (int)blob.length());
                }
            } 
        }
      stmt.close();
      conn.commit();
      return imageData;
    }
    
    public byte[] getImageByte(String id) throws SQLException{
        switch (id.length()) {
            case 11:
                return retrive(id, CUSTOMER);
            case 8:
                return retrive(id, DRIVER);
            default:
                return null;
        }
    }
}
