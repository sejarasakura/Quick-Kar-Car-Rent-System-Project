/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _control.domain;

import java.text.SimpleDateFormat;
/**
 *
 * @author ITSUKA KOTORI
 */
public class Report {
    public static final SimpleDateFormat PARAMETER_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    public static final SimpleDateFormat REPORT_HEADER_FORMAT = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
    public static final SimpleDateFormat REPORT_HEADER_FORMAT_S = new SimpleDateFormat("dd MMMM yyyy");
    public static final SimpleDateFormat REPORT_CONTENT_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");        
    public final static String ROW_OF_TABLE = 
        "<tr style='border: 0;'>"
            + "<td style='border: 0;'>@col_1@</td>"
            + "<td style='border: 0;'>@col_2@</td>"
            + "<td style='border: 0;'>@col_3@</td>"
            + "<td style='border: 0;'>@col_4@</td>"
            + "<td style='border: 0;'>@col_5@</td>"
            + "<td style='border: 0;'>@col_6@</td>"
            + "<td style='border: 0; text-align:right;'>@col_7@</td>"
        + "</tr>";

    public static String report_row(String col_1, String col_2, String col_3,String col_4, String col_5, String col_6, String col_7){
        String result = ROW_OF_TABLE;
        result = result.replace("@col_1@", col_1);
        result = result.replace("@col_2@", col_2);
        result = result.replace("@col_3@", col_3);
        result = result.replace("@col_4@", col_4);
        result = result.replace("@col_5@", col_5);
        result = result.replace("@col_6@", col_6);
        result = result.replace("@col_7@", col_7);
        return result;
    }
    public static String report_row(String []col){
        return report_row(col[0], col[1], col[2], col[3], col[4], col[5], col[6]);
    }
    public static String new_line(){
        String result = report_row("", "", "", "", "", "", "");
        result = result.replace("tr style='border: 0;'", "tr style='border: 0;margin:10px;min-height:20px;height:20px'");
        return result;
    }
    
    
}
