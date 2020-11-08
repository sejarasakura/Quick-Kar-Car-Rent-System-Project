/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _da;

import _domain.AbstractDomain;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Main_Test_Run {
    
    public static void main(String[] args) {
        System.out.println("=====================================================");
        Main_Test_Run try_pro = new Main_Test_Run();
        BookingDA.main(null);
    }
    
    private void test_data(AbstractDA database){
        Object[] try_datas = database.getRecords();
            System.out.println("=====================================================");
            System.out.printf("|        \n", database.tableName);
            System.out.println("=====================================================");
        for(Object data: try_datas){
            System.out.println(((AbstractDomain)data).toString());
        }
    }
}
