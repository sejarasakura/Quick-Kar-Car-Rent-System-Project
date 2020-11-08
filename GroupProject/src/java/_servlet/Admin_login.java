/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import _enum.ErrorDetails;
import _filter.SecurityFilter;
import _servletAPI._session.AdminSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _module.server_side.*;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Admin_login extends HttpServlet {
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminSession admin_s = new AdminSession();
        String username = request.getParameter(AdminSession.session_name_user);
        String password = request.getParameter(AdminSession.session_name_password);
        AdminLogin_mod admin_mod = new AdminLogin_mod(username, password);
        if(admin_mod.hasdLogined()){
            admin_s.setPassword(password);
            admin_s.setUsername(username);
            admin_s.addSeesion(request);
            SecurityFilter.setLogin(true);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/index.html");
        }
        else{
            AdminSession.removeSeesion(request);
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
            ErrorDetails.E002.getUrl() + "&url=" + "Admin Login"); 
        }
    }
    //</editor-fold>
}
