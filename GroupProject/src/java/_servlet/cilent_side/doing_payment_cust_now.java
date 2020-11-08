/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.cilent_side;

import _da.BookingDA;
import _da.PaymentDA;
import _domain.Booking;
import _domain.Payment;
import _enum.BookingStatus;
import _enum.PaymentStatus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class doing_payment_cust_now extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        try {
            Payment payment = (Payment)request.getSession().getAttribute("current_payment_object");
            PaymentDA da = new PaymentDA();
            boolean updated = false;
            payment.setPayment_status(PaymentStatus.ALREADY_PAID);
            updated = da.updateRecord(payment, payment.getPayment_id());
            out.print("\n" +
"        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n" +
"        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n" +
"        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.css\">\n" +
"        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css\">\n" +
"        <script src=\"http://localhost:8080/GroupProject/_js/map-google.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.min.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js\"></script>\n" +
"        <script src=\"http://localhost:8080/GroupProject/_js/Validatation_c.js\"></script>");
           String url = "";
            url = "http://localhost:8080/GroupProject/_page/client_page/customer/recent_activity/recent_activity.jsp";
            out.print("<script>");
            out.print("$(document).ready(function() {");
            if(updated){
                out.print(this.dispaly_done(url));
            }else{
                out.print(this.dispaly_not_done(url));
            }
            out.print("});");
             out.print("<script>");
        }catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex);
        }
        }catch(Exception ex2){
            JOptionPane.showConfirmDialog(null, ex2);
        }
    }
    private String dispaly_done(String url){
        return "$.confirm({\n" +
        "    title: 'Payment complete!',\n" +
        "    content: 'Thank you for your support !!',\n" +
        "    type: 'blue',\n" +
        "    typeAnimated: true,\n" +
        "    buttons: {\n" +
        "        tryAgain: {\n" +
        "            text: 'OK',\n" +
        "            btnClass: 'btn-blue',\n" +
        "            action: function(){\n"
                + "window.location.replace(\"" + url + "\");" +
        "            }\n" +
        "        }"+
        "    }\n" +
        "});";
    }
    private String dispaly_not_done(String url){
        return "$.confirm({\n" +
            "    title: 'Encountered an error!',\n" +
            "    content: 'You payment work uncollectly, please try agian',\n" +
            "    type: 'red',\n" +
            "    typeAnimated: true,\n" +
            "    buttons: {\n" +
            "        close: {\n" +
            "            text: 'OK',\n" +
            "            btnClass: 'btn-red',\n" +
            "            action: function(){\n" +
                 "window.location.replace(\"" + url + "\");" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "});";
    }
}
