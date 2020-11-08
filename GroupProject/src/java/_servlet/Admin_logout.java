/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import _filter.SecurityFilter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import _module.server_side.*;
import _servletAPI._session.AdminSession;

/**
 *
 * @author taruc
 */
public class Admin_logout extends HttpServlet {

    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminSession.removeSeesion(request);
        SecurityFilter.setLogin(false);
        response.sendRedirect("http://localhost:8080/GroupProject/_page/login/admin/adminlogin.html");
    }
    //</editor-fold>
}
