/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _module.server_side;

import _control.domain.Admin;
import _control.domain.AdminControl;
import _control.*;

/**
 *
 * @author ITSUKA KOTORI
 */
public class AdminLogin_mod {
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    public static Object[] admin = AdminControl.get_Admins();
    private boolean logined = false;
    public boolean hasdLogined(){return logined;}
    public AdminLogin_mod(String admin_id, String password) {
        if (Validation.check_Admin(admin_id) || Validation.check_Password(password)) {
            for (Object x : admin) {
                if (!admin_id.equals(((Admin) x).getAdmin_id())) {
                    continue;
                }
                if (password.equals(((Admin) x).getPassword())) {
                    logined = true;
                    break;
                }
            }
        }
    }
    //</editor-fold>
}
