/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.admin_console;

import _da.*;
import _domain.*;
import _enum.ErrorDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author xps
 */
public class updateCustomer_admin extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer cust = (Customer)request.getSession().getAttribute("customer_data_update");
        CustomerDA da = new CustomerDA();
        if(da.updateRecord(cust, cust.getCust_id())){
            response.sendRedirect("http://localhost:8080/GroupProject/_page/admin_console/_profile/customer.jsp?id="
                    + cust.getCust_id());   
        }else{
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E007.getUrl() + "&url=updateCustomer_admin");          
        }
    }
}
