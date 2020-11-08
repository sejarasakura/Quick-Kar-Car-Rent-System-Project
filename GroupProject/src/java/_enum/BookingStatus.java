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
public enum BookingStatus {
    IN_WISH_LIST("B1", "Added to my wish list", ""), 
    PICK_UPKING("B2", "Aready pickup", ""), 
    DROP_OFFED("B3", "Drop offed", ""), 
    CANCELED_BOOKING("B4", "Cancel entier booking", ""), 
    PADDING_PAYMENT("B5", "Padding For Payment", "");
    private final String code;
    private final String name;
    private final String decription;
    private BookingStatus(String code, String name, String des){
        this.code = code;
        this.name = name;
        this.decription = des;
    }
    public static BookingStatus getValue(String string) {
        try {
            if (Arrays.asList(IN_WISH_LIST.code.toLowerCase(), IN_WISH_LIST.name.toLowerCase()).contains(string.toLowerCase())) {
                return IN_WISH_LIST;
            } else if (Arrays.asList(PICK_UPKING.code.toLowerCase(), PICK_UPKING.name.toLowerCase()).contains(string.toLowerCase())) {
                return PICK_UPKING;
            } else if (Arrays.asList(DROP_OFFED.code.toLowerCase(), DROP_OFFED.name.toLowerCase()).contains(string.toLowerCase())) {
                return DROP_OFFED;
            } else if (Arrays.asList(CANCELED_BOOKING.code.toLowerCase(), CANCELED_BOOKING.name.toLowerCase()).contains(string.toLowerCase())) {
                return CANCELED_BOOKING;
            } else if (Arrays.asList(PADDING_PAYMENT.code.toLowerCase(), PADDING_PAYMENT.name.toLowerCase()).contains(string.toLowerCase())) {
                return PADDING_PAYMENT;
            } else {
                try {return valueOf(string.toUpperCase());} catch (Exception ex) {return null;}
            }
        } catch (Exception e) {
            try {return valueOf(string.toUpperCase());} catch (Exception ex) {return null;}
        }
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
     public static BookingStatus getValue(Object booking_status){
         if(booking_status instanceof BookingStatus)
            return (BookingStatus)booking_status;
        else if(booking_status instanceof String)
            return BookingStatus.getValue((String)booking_status);
        else{
            return null;
        }
     }
}
