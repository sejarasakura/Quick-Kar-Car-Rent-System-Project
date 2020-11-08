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
public enum RatingStar {

   ZERO_STAR                       ("SS", 0.0f, "Zero Star"),
   HALF_STAR                       ("S0", 0.5f, "Half Star"),
   ONE_STAR                         ("S1", 1.0f, "One Star"),
   ONE_AND_HALF_STAR     ("S2", 1.5f, "One and Half Star"),
   TWO_STAR                        ("S3", 2.0f, "Two Star"),
   TWO_AND_HALF_STAR    ("S4", 2.5f, "Two and Half Star"),
   THREE_STAR                     ("S5", 3.0f, "Three Star"),
   THREE_AND_HALF_STAR ("S6", 3.5f, "Three and Half Star"),
   FOUR_STAR                      ("S7", 4.0f, "Four Star"),
   FOUR_AND_HALF_STAR  ("S8", 4.5f, "Four and Half Star"),
   FIVE_STAR                        ("S9", 5.0f, "Five full Star");
    final String code;
    final float rating_value;
    final String name;
     private RatingStar(String code, float rating_value, String name) {
        this.code = code;
        this.rating_value = rating_value;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public float getRating_value() {
        return rating_value;
    }

    public String getName() {
        return name;
    }
     
    public static RatingStar getValue(float data) {
        int int_data = (int)(data * 10);
        switch(int_data){
            case 5:
                return RatingStar.HALF_STAR;
            case 10:
                return RatingStar.ONE_STAR;
            case 15:
                return RatingStar.ONE_AND_HALF_STAR;
            case 20:
                return RatingStar.TWO_STAR;
            case 25:
                return RatingStar.TWO_AND_HALF_STAR;
            case 30:
                return RatingStar.THREE_STAR;
            case 35:
                return RatingStar.THREE_AND_HALF_STAR;
            case 40:
                return RatingStar.FOUR_STAR;
            case 45:
                return RatingStar.FOUR_AND_HALF_STAR;
            case 50:
                return FIVE_STAR;
            default: return ZERO_STAR;
        }
    }
    public static RatingStar getValue(String string) {
        string = string.toLowerCase();
        try {
            if (Arrays.asList(ZERO_STAR.code.toLowerCase(), ZERO_STAR.name.toLowerCase()).contains(string)) {
                return ZERO_STAR;
            } else if (Arrays.asList(HALF_STAR.code.toLowerCase(), HALF_STAR.name.toLowerCase()).contains(string)) {
                return HALF_STAR;
            } else if (Arrays.asList(ONE_STAR.code.toLowerCase(), ONE_STAR.name.toLowerCase()).contains(string)) {
                return ONE_STAR;
            } else if (Arrays.asList(ONE_AND_HALF_STAR.code.toLowerCase(), ONE_AND_HALF_STAR.name.toLowerCase()).contains(string)) {
                return ONE_AND_HALF_STAR;
            } else if (Arrays.asList(TWO_STAR.code.toLowerCase(), TWO_STAR.name.toLowerCase()).contains(string)) {
                return TWO_STAR;
            } else if (Arrays.asList(TWO_AND_HALF_STAR.code.toLowerCase(), TWO_AND_HALF_STAR.name.toLowerCase()).contains(string)) {
                return TWO_AND_HALF_STAR;
            } else if (Arrays.asList(THREE_STAR.code.toLowerCase(), THREE_STAR.name.toLowerCase()).contains(string)) {
                return THREE_STAR;
            } else if (Arrays.asList(THREE_AND_HALF_STAR.code.toLowerCase(), THREE_AND_HALF_STAR.name.toLowerCase()).contains(string)) {
                return THREE_AND_HALF_STAR;
            } else if (Arrays.asList(FOUR_STAR.code.toLowerCase(), FOUR_STAR.name.toLowerCase()).contains(string)) {
                return FOUR_STAR;
            } else if (Arrays.asList(FOUR_AND_HALF_STAR.code.toLowerCase(), FOUR_AND_HALF_STAR.name.toLowerCase()).contains(string)) {
                return FOUR_AND_HALF_STAR;
            } else if (Arrays.asList(FIVE_STAR.code.toLowerCase(), FIVE_STAR.name.toLowerCase()).contains(string)) {
                return FIVE_STAR;
            } else {
                try {return valueOf(string.toUpperCase());} catch (Exception ex) {return null;}
            }
        } catch (Exception e) {
            try {
                return RatingStar.valueOf(string.toUpperCase());
            } catch (Exception ex) {
                return null;
            }
        }
    }
    
     public static RatingStar getValue(Object rating_star){
         if(rating_star instanceof RatingStar)
            return (RatingStar)rating_star;
        else if(rating_star instanceof String)
            return RatingStar.getValue((String)rating_star);
        else if(rating_star instanceof Float)
            return RatingStar.getValue(rating_star);
        else{
            return null;
        }
     }
}
