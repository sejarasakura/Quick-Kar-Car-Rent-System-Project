/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import _da.AbstractDA;
import _enum.ErrorDetails;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _manipulation.*;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author xps
 */
public class restore_backup extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String[] dirs = (String[])request.getSession().getAttribute("directories");
        int index = Integer.parseInt(request.getParameter("index"));
        String directory = Path_Manipulate.getDatabaseDirectory() + "DB-BACKUP/" + dirs[index];
        AbstractDA da = new AbstractDA("Restore Backup") {};
        if(new File(directory).isDirectory()){
            
            if(da.recovery_database(directory)){
                response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/maintance/retrive_backup/retrive_bkup.html");   
            }else{
                response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                        + ErrorDetails.E011.getUrl() + "&url=restore_backup" + "&directory="+directory);   
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Your database directory not correct", "Your database drectory is wrong please try agian", JOptionPane.CLOSED_OPTION);
        }
    }

}
