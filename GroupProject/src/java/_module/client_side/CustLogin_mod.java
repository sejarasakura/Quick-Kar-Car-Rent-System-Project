/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _module.client_side;

import _da.*;
import _domain.Customer;

/**
 *
 * @author ITSUKA KOTORI
 */
public class CustLogin_mod {

    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    private boolean logined = false;
    public boolean hasdLogined(){return logined;}
    public CustLogin_mod(String cust_id, String password) {
        CustomerDA da = new CustomerDA();
        Customer data = (Customer)da.getRecord(cust_id);
        logined = (data.getPassword() == null ? password == null : data.getPassword().equals(password));
    }
    //</editor-fold>
    
}
