/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import _da.*;
import _enum.ErrorDetails;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xps
 */
public class backup_database extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DA da = new DA() {};
        String file = (String)request.getParameter("filename");
        boolean data =  da.backup(file);
        if(data){
            response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/maintance/back_up/backup_database.jsp");   
        }else{
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E010.getUrl() + "&url=addBooking");   
        }
    }
    private class DA extends AbstractDA{

        public DA() {
            super("da");
        }
        public boolean backup(String filename){
            try {
                backUpDatabase(this.conn, filename);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(backup_database.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        public void backUpDatabase(Connection conn, String filename)throws SQLException
        {
            // Get today's date as a string:
            java.text.SimpleDateFormat todaysDate = 
                new java.text.SimpleDateFormat("yyyy-MM-dd");
            String backupdirectory = _manipulation.Path_Manipulate.getDatabaseDirectory() +"DB-BACKUP/" + filename +'-'+ todaysDate.format((java.util.Calendar.getInstance()).getTime());

            CallableStatement cs = conn.prepareCall("CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE(?)"); 
            cs.setString(1, backupdirectory);
            cs.execute(); 
            cs.close();
            System.out.println("backed up database to "+backupdirectory);
        }

    }
}
