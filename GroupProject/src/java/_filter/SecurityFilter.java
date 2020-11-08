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
/**
 *
 * @author ITSUKA KOTORI
 */
public class SecurityFilter implements Filter {
    
    private static boolean login = false;
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public SecurityFilter() {   
    }               

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        SecurityFilter.login = login;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (login == false) {
            HttpServletResponse res = (HttpServletResponse) response;
            if (debug) {
                log("SecurityFilter:doFilter()");
            }
            AdminSession admin_s = new AdminSession();
            admin_s.retriveSeesion(request);
            try {
                login = admin_s.hasLogin(request);
                if (login) {
                    chain.doFilter(request, response);
                }
            } catch (IOException ex) {
                res.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                        + ErrorDetails.E006.getUrl() + "&url=SecurityFilter");                
            } catch (ServletException t) {
                res.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                        + ErrorDetails.E005.getUrl() + "&url=SecurityFilter");                
            }
            System.out.println("Username : " + admin_s.getUsername() + "Password : " + admin_s.getPassword());
            res.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E001.getUrl() + "&url=SecurityFilter");            
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
                log("SecurityFilter:Initializing filter");
            }
        }
    }
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
}
