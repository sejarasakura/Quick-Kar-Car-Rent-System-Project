/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _module.client_side;
import _control.domain.AdminControl;
import _da.*;
import _domain.*;
/**
 *
 * @author ITSUKA KOTORI
 */
public class DriverLogin_mod {

    private boolean logined = false;
    public boolean hasdLogined(){return logined;}
    public DriverLogin_mod(String driver_id, String password) {
        DriverDA da = new DriverDA();
        Driver data = (Driver)da.getRecord(driver_id);
        logined = (data.getPassword() == null ? password == null : data.getPassword().equals(password));        
    }
    
}
