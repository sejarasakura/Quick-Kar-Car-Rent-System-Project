/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _control;

import static _control.Validation.DATE_FORMAT;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Reformat {
    public static String refomat_IcNumber(String ic){
        if(!Validation.check_ICNumber(ic)){
            if( ic.matches("[0-9]{12}"))
                return ic.substring(0, 6) +"-"+ ic.substring(6, 8) +"-"+ ic.substring(8, 12);
            else if(ic.contains("-")){
                String[] ics = ic.split("-");
                ic = "";
                for(String data: ics)
                    ic += data;
                if( ic.matches("[0-9]{12}"))
                    return ic.substring(0, 6) +"-"+ ic.substring(6, 8) +"-"+ ic.substring(8, 12);
            }
            return "the IC number is not correct";
        }else
            return ic;
    }
    public static String reformat_PhoneNumber(String phone_num){
        if(!Validation.check_PhoneNumber(phone_num)){
            if(phone_num.matches("[0-9]{3}[-][0-9]{3}[-][0-9]{4}"))
                return "6" + phone_num;
            else if (phone_num.matches("[+]{1}[0-9]{4}[-][0-9]{3}[-][0-9]{4}"))
                return phone_num.substring(1);
            return "the mobile phone number is not correct";
        }else
            return phone_num;
    }
    public static String reformat_PrimaryKey(String pk){
        return pk.toUpperCase();
    }
}
