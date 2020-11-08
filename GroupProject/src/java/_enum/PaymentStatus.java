/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _enum;

import java.util.Arrays;

/**
 *
 * @author ITSUKA KOTORI
 */
public enum PaymentStatus {

    NOT_YET_PAID("P1", "Paid", "You payment is done proccessed."),
    ALREADY_PAID("P2", "Pendding", "Pendding your payment !!"),
    OVERDUE         ("P3", "Expired", "Your payment is overdue !!"),
    CANCELED       ("P4", "Cancel", "Your payment is canceled");
    private final String code;
    private final String name;
    private final String decription;
    private PaymentStatus(String code, String name, String des){
        this.code = code;
        this.name = name;
        this.decription = des;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDecription() {
        return decription;
    }
    
    public static PaymentStatus getValue(String string) {
        string = string.toLowerCase();
        try {
            if (Arrays.asList(NOT_YET_PAID.code.toLowerCase(), NOT_YET_PAID.name.toLowerCase()).contains(string)) {
                return NOT_YET_PAID;
            } else if (Arrays.asList(ALREADY_PAID.code.toLowerCase(), ALREADY_PAID.name.toLowerCase()).contains(string)) {
                return ALREADY_PAID;
            } else if (Arrays.asList(OVERDUE.code.toLowerCase(), OVERDUE.name.toLowerCase()).contains(string)) {
                return OVERDUE;
            } else if (Arrays.asList(CANCELED.code.toLowerCase(), CANCELED.name.toLowerCase()).contains(string)) {
                return CANCELED;
            } else {
                try {return valueOf(string.toUpperCase());} catch (Exception ex) {return null;}
            }
        } catch (Exception e) {
            try {
                return PaymentStatus.valueOf(string.toUpperCase());
            } catch (Exception ex) {
                return null;
            }
        }
    }
     public static PaymentStatus getValue(Object payment_status){
         if(payment_status instanceof PaymentStatus)
            return (PaymentStatus)payment_status;
        else if(payment_status instanceof String)
            return PaymentStatus.getValue((String)payment_status);
        else{
            return null;
        }
     }
}
