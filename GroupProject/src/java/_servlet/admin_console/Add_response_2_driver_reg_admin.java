/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import _domain.*;
import _enum.ErrorDetails;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author xps
 */
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 2,  // 1 MB
        maxFileSize         = 1024 * 1024 * 2, // 10 MB
        maxRequestSize      = 1024 * 1024 * 2  // 15 MB
        )
public class Add_response_2_driver_reg_admin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean client = false;
        try{
            client = (boolean)request.getSession().getAttribute("Add_response_2_driver_reg_admin");
        }catch(Exception e){
            client = false;
        }
        Part filepart = request.getPart("proc_pic");
        InputStream filecontent = filepart.getInputStream();
        byte[] proc_pic = IOUtils.toByteArray(filecontent);
        _da.DriverDA da = new _da.DriverDA();
        Driver domain =  (Driver)da.getRecord((String) request.getSession().getAttribute("id"));
        domain.setProc_pic(proc_pic);
        //JOptionPane.showConfirmDialog(null, domain.getDriver_id());
        boolean updated = da.updateRecord(domain, domain.getDriver_id());
        if (!client) {
            if (updated) {
                response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/driver/create/add_car.jsp?id=" + domain.getDriver_id());                
            } else {
                response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                        + ErrorDetails.E012.getUrl() + "&url=Add_drivert_res2");                
            }
        } else {
            if (updated) {
                response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html");                
            } else {
                response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + ErrorDetails.E012.getUrl() + "&url=Add_customer_res2 client");                
            }
        }
    }
   
}
