/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import _domain.Customer;
import _domain.Driver;
import _enum.ErrorDetails;
import _module.client_side.SendMailPassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xps
 */
public class SendMailApproveDriver extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        Driver user = (Driver)request.getSession().getAttribute("driver_data_for_sen_mail");
        String email = (String)request.getSession().getAttribute("email-" + id);
        String html;
        html = gethtml(user);
        try {
            SendMailPassword.sendMail(email, "Forgot QuicKar userid or password", html);
            response.sendRedirect("https://mail.google.com/");
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailApproveDriver.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
            ErrorDetails.E014.getUrl() + "&url=" + "Customer Login send mail error"); 
        }
    }
    
    private String gethtml(Driver user) throws IOException{
        String html = "";
        String path = _manipulation.Path_Manipulate.getResourceDirectory() + "html/confrim_driver.html";
        byte[] array = Files.readAllBytes(Paths.get(path));
        html = new String(array);
        user = (Driver)user;
        html = html.replaceAll("@url@", "http://localhost:8080/GroupProject/index.html");
        html = html.replaceAll("@user@", user.getFull_Name());
        html = html.replaceAll("@id@", user.getDriver_id());
        html = html.replaceAll("@url_change_password@", "http://localhost:8080/GroupProject/_page/login/client/useromer.html");
        Date date = new Date();
        html = html.replaceAll("@date@", date + "");
        return html;
    }
}
