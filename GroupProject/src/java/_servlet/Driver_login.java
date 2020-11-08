/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import _enum.ErrorDetails;
import _filter.CustomerFilter;
import _filter.DriverFilter;
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
import _servletAPI._session.DriverSession;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Driver_login extends HttpServlet {
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DriverSession driver_s=  new DriverSession();
        String username = request.getParameter(DriverSession.session_name_user);
        String password = request.getParameter(DriverSession.session_name_password);
        DriverLogin_mod driver_mod = new DriverLogin_mod(username, password);
        if(driver_mod.hasdLogined()){
            driver_s.setPassword(password);
            driver_s.setUsername(username);
            driver_s.addSeesion(request);
            DriverFilter.setLogin(true);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html");
        }
        else{
            DriverSession.removeSeesion(request);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
            ErrorDetails.E002.getUrl() + "&url=" + "Driver Login"); 
        }
    }
    //</editor-fold>
}
