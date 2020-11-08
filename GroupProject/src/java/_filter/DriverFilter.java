/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _filter;

import _enum.ErrorDetails;
import _manipulation.Path_Manipulate;
import _module.server_side.AdminLogin_mod;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import _servletAPI._session.AdminSession;
import _servletAPI._session.DriverSession;
/**
 *
 * @author ITSUKA KOTORI
 */
public class DriverFilter implements Filter {
    
    private static boolean login = false;
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public DriverFilter() {   
    }               

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        DriverFilter.login = login;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (login == false) {
            HttpServletResponse res = (HttpServletResponse) response;
            if (debug) {
                log("DriverFilter:doFilter()");
            }
            DriverSession driver_s = new DriverSession();
            driver_s.retriveSeesion(request);
            try {
                login = driver_s.hasLogin(request);
                if (login) {
                    chain.doFilter(request, response);
                }
            } catch (IOException ex) {
                res.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                        + ErrorDetails.E006.getUrl() + "&url=DriverFilter");                
            } catch (ServletException t) {
                res.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                        + ErrorDetails.E005.getUrl() + "&url=DriverFilter");                
            }
            System.out.println("Username : " + driver_s.getUsername() + "Password : " + driver_s.getPassword());
            res.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E004.getUrl() + "&url=DriverFilter");            
        }else{
            chain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {        
    }
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("DriverFilter:Initializing filter");
            }
        }
    }
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
}
