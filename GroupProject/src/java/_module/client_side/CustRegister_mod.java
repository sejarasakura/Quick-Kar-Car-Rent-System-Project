/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _module.client_side;

//<editor-fold defaultstate="collapsed" desc="Imported documents.">
import _control.Reformat;
import _control.Validation;
import _domain.Customer;
import _enum.MembershipLevel;
import java.awt.Image;

//</editor-fold>
public class CustRegister_mod {
    
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    private Customer data = null;
    private boolean exsite = true;
    //<editor-fold defaultstate="collapsed" desc="Constructor ...">
    public CustRegister_mod(Customer customer, String confrim_pass){
        data = customer;
        reformating();
        data.setPoint_amount(1000);
        check_validation();
    }
    public CustRegister_mod(Object membership_level, String first_name, String last_name,  
            String ic_num, String phone_num, String password, byte[] proc_pic){
        MembershipLevel mbl = MembershipLevel.getValue(membership_level);
        if(mbl == null){
            exsite = false;
            return;
        }
        data = new Customer(_control.GenerateID.generate_Cust(mbl), 
                1000, mbl, first_name, last_name, ic_num, phone_num, 
                password, proc_pic);
        reformating();
        check_validation();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="public method...">
    public boolean register_now(){
        if(!exsite || data == null)
            return false;
        
        return new _da.CustomerDA().addRecord(data);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Private method...">
    private void check_validation(){
        if(!data.isNotNull()){
            exsite = false;
            return;
        }
        exsite &= Validation.check_ICNumber(data.getIc_num());
        exsite &= Validation.check_PhoneNumber(data.getPhone_num());
        exsite &= Validation.check_Name(data.getFirst_name(), data.getLast_name());
    }
    private void reformating(){
        data.setIc_num(Reformat.refomat_IcNumber(data.getIc_num()));
        data.setPhone_num(Reformat.reformat_PhoneNumber(data.getPhone_num()));
    }
    //</editor-fold>
    //</editor-fold>
}
