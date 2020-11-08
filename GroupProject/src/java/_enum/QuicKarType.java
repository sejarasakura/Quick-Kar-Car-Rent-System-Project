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
public enum QuicKarType {

    /*Example(code, name, seat, base price, min price, min fees, price 1km)*/
    JUSTQUICK("JQ", "Just Quick", 4, 2.0F, 5.0F, 0.95F, 0.3f,"Find a nerest QuicKar now !!"),
    PREMQUICK("PQ", "Premium Quick", 4, 4.0F, 15.0F, 1.95F, 0.45f,"Premium car drivers all are top rate driver !!"),
    QUICK_6SEAT("SS", "QuicKar (6-Seat)", 6, 3.00f, 12.00f, 1.59f, 0.45f,"It is larger venicles that can fit up to 6 passengers !!");
    private final String code, name, decription;
    private final int seat_number; 
    private final float base_fair_price, minimum_price, price_per_km, price_per_min;
    private QuicKarType(String code, String name, int seat_number, float base_fair_price, float min_price, float price_per_km, float price_per_min, String desc) {
        this.code = code;
        this.name = name;
        this.seat_number = seat_number;
        this.base_fair_price = base_fair_price;
        this.minimum_price = min_price;
        this.price_per_km = price_per_km;
        this.decription = desc;
        this.price_per_min = price_per_min;
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

    public int getSeat_number() {
        return seat_number;
    }

    public float getBase_fair_price() {
        return base_fair_price;
    }

    public float getMinimum_price() {
        return minimum_price;
    }

    public float getPrice_per_km() {
        return price_per_km;
    }
    
    public float getPrice_per_min() {
        return price_per_min;
    }
    
    public static QuicKarType getValue(String string) {
        try {
            if (Arrays.asList(JUSTQUICK.code.toLowerCase(), JUSTQUICK.name.toLowerCase()).contains(string.toLowerCase())) {
                return JUSTQUICK;
            } else if (Arrays.asList(PREMQUICK.code.toLowerCase(), PREMQUICK.name.toLowerCase()).contains(string.toLowerCase())) {
                return PREMQUICK;
            } else if (Arrays.asList(QUICK_6SEAT.code.toLowerCase(), QUICK_6SEAT.name.toLowerCase()).contains(string.toLowerCase())) {
                return QUICK_6SEAT;
            } else {
                try {return valueOf(string.toUpperCase());} catch (Exception ex) {return null;}
            }
        } catch (Exception e) {
            try {
                return QuicKarType.valueOf(string.toUpperCase());
            } catch (Exception ex) {
                return null;
            }
        }
    }
     public static QuicKarType getValue(Object quickar_type){
         if(quickar_type instanceof QuicKarType)
            return (QuicKarType)quickar_type;
        else if(quickar_type instanceof String)
            return QuicKarType.getValue((String)quickar_type);
        else{
            return null;
        }
     }
    public static void main(String []args){
        System.out.println(QuicKarType.getValue("Find a nerest QuicKar now !!"));
        System.out.println(QuicKarType.getValue("Find a nerest QuicKar "));
        System.out.println(QuicKarType.getValue("QuicKar"));
        System.out.println(QuicKarType.getValue("a nerest QuicKar now !!"));
        System.out.println(QuicKarType.getValue("Find a QuicKar now !!"));
    }
}
