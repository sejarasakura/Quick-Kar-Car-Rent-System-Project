/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servletAPI._session;

import _module.server_side.AdminLogin_mod;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ITSUKA KOTORI
 */
public class CustomerSession {
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    public static final String session_name_user = "Customer_username";
    public static final String session_name_password = "Customer_password";
    public static final String session_boolean = "Customer_status";
    private String username, password;
    private CustomerSession(String username, String password){
        this.username = username;
        this.password = password;
    }
    public CustomerSession(){
        this("", "");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasLogin(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        Object obj = session.getAttribute(CustomerSession.session_boolean);
        if(obj instanceof String)
            return Boolean.valueOf((String)obj);
        else if (obj instanceof Boolean)
            return (boolean) obj;
        else
            return false;
    }
    
    public void addSeesion(ServletRequest request){
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        session.setAttribute(CustomerSession.session_name_user, this.username);
        session.setAttribute(CustomerSession.session_name_password, this.password);
        session.setAttribute(CustomerSession.session_boolean, true);
    }
    
    public static void removeSeesion(ServletRequest request){
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        session.removeAttribute(CustomerSession.session_name_user);
        session.removeAttribute(CustomerSession.session_name_password);
        session.setAttribute(CustomerSession.session_boolean, false);
    }
    
    public void retriveSeesion(ServletRequest request){
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        this.username = (String)session.getAttribute(CustomerSession.session_name_user);
        this.password = (String)session.getAttribute(CustomerSession.session_name_password);
    }
    //</editor-fold>

}
