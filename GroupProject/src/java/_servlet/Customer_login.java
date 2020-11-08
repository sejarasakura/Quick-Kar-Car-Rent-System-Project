/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import _enum.ErrorDetails;
import _filter.CustomerFilter;
import _filter.SecurityFilter;
import _module.client_side.CustLogin_mod;
import _servletAPI._session.AdminSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _servletAPI._session.CustomerSession;
import _module.client_side.*;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Customer_login extends HttpServlet {
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerSession cust_s = new CustomerSession();
        String username = request.getParameter(CustomerSession.session_name_user);
        String password = request.getParameter(CustomerSession.session_name_password);
        CustLogin_mod cust_mod = new CustLogin_mod(username, password);
        if(cust_mod.hasdLogined()){
            cust_s.setPassword(password);
            cust_s.setUsername(username);
            cust_s.addSeesion(request);
            CustomerFilter.setLogin(true);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html");
        }
        else{
            CustomerSession.removeSeesion(request);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
            ErrorDetails.E002.getUrl() + "&url=" + "Customer Login"); 
        }
    }
    //</editor-fold>
}
