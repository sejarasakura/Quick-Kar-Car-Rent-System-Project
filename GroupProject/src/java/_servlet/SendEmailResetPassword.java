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
public class SendEmailResetPassword extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("user_id");
        String email = request.getParameter("email");
        String html;
        Object user;
        if(id.length() == 11|| id.length() == 8){
            if (id.length() == 11) {
                _da.CustomerDA da = new _da.CustomerDA();
                user = da.getRecord(id);
            } else {
                _da.DriverDA da = new _da.DriverDA();
                user = da.getRecord(id);
            }
            html = gethtml(user);
            try {
                SendMailPassword.sendMail(email, "Forgot QuicKar userid or password", html);
                if (id.length() == 11) {
                    response.sendRedirect("https://mail.google.com/"); 
                } else {
                    response.sendRedirect("https://mail.google.com/"); 
                }
            } catch (MessagingException ex) {
                Logger.getLogger(SendEmailResetPassword.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
                ErrorDetails.E014.getUrl() + "&url=" + "Customer Login send mail error"); 
            }
        }else{
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
            ErrorDetails.E013.getUrl() + "&url=" + "Customer Login not match lenght"); 
        }
    }
    
    private String gethtml(Object user) throws IOException{
        String html = "";
        String path = _manipulation.Path_Manipulate.getResourceDirectory() + "html/password.html";
        byte[] array = Files.readAllBytes(Paths.get(path));
        html = new String(array);
        if(user instanceof Customer){
            Customer cust = (Customer)user;
            html = html.replaceAll("@url@", "http://localhost:8080/GroupProject/index.html");
            html = html.replaceAll("@user@", cust.getFull_Name());
            html = html.replaceAll("@id@", cust.getCust_id());
            html = html.replaceAll("@password@", cust.getPassword());
            html = html.replaceAll("@url_change_password@", "http://localhost:8080/GroupProject/_page/login/client/customer.html");
        }else if(user instanceof Driver){
            Driver cust = (Driver)user;
            html = html.replaceAll("@url@", "http://localhost:8080/GroupProject/index.html");
            html = html.replaceAll("@user@", cust.getFull_Name());
            html = html.replaceAll("@id@", cust.getDriver_id());
            html = html.replaceAll("@password@", cust.getPassword());
            html = html.replaceAll("@url_change_password@", "http://localhost:8080/GroupProject/_page/login/client/driver.html");
        }
        Date date = new Date();
        html = html.replaceAll("@date@", date + "");
        return html;
    }
}
