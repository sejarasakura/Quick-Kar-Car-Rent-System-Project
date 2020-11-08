/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _control.domain;
import _manipulation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ITSUKA KOTORI
 */
public class SQL_control extends _da.AbstractDA{

    public SQL_control() {
        super("SQL_control");
    }
    public static String read_sql(String sql_file_name) throws IOException{
        String file_path = Path_Manipulate.getResourceDirectory() + "sql/" + sql_file_name;
        Path path = Paths.get(file_path);
        byte[] data = Files.readAllBytes(path);
        return new String(data);
    }
    public PreparedStatement prepareStatement(String sql) throws SQLException{
        return conn.prepareStatement(sql);
    } 
    public void end_read() throws SQLException{
        if(!stmt.isClosed())
            stmt.close();
        if(!conn.getAutoCommit())
            conn.commit();
    } 
}
