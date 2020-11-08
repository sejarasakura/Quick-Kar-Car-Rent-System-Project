/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.cilent_side;

import _da.CustomerDA;
import _da.RatingDA;
import _domain.Customer;
import _domain.Rating;
import _enum.ErrorDetails;
import _enum.RatingStar;
import _servletAPI._session.CustomerSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class CustomerUpdateRating extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String s1 = request.getParameter("rating_id");
            String s2 = request.getParameter("comment");
            String s3 = request.getParameter("star");
            String status = request.getParameter("status");
            float star = Float.parseFloat(s3);
            Rating rating = new Rating();
            RatingDA da = new RatingDA();
            boolean updated = false;
            if(s1 == null || "".equals(s1)){
                rating.setRating_id(s1);
                rating.setCust_comments(s2);
                rating.setRating_datetime(new Date());
                rating.setRating_star(RatingStar.getValue(star));
                updated = da.addRecord(rating);
            }else{
                rating = (Rating)da.getRecord(s1);
                rating.setRating_star(RatingStar.getValue(star));
                rating.setCust_comments(s2);
                rating.setRating_datetime(new Date());
                updated = da.updateRecord(rating, s1);
            }
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
           switch(status){
               case "1":
                   url = "http://localhost:8080/GroupProject/_page/client_page/customer/recent_activity/recent_activity.jsp";
                   if(updated){
                       out.print(this.dispaly_done(url));
                   }else{
                       out.print(this.dispaly_not_done(url));
                   }
                   break;
           }
            response.sendRedirect(url);
        }
    }
    private String dispaly_done(String url){
        return "$.confirm({\n" +
        "    title: 'Rating complete!',\n" +
        "    content: 'Thank you for your rating and yours support',\n" +
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
            "    content: 'You rating had not updated please try agian',\n" +
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
