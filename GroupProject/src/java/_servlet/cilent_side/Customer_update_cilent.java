/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet.cilent_side;

import _da.CustomerDA;
import _domain.Customer;
import _enum.ErrorDetails;
import _enum.MembershipLevel;
import _servletAPI._session.CustomerSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Customer_update_cilent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            CustomerSession new_c = new CustomerSession();
            new_c.retriveSeesion(request);
            String id = null;
            try{
                id = new_c.getUsername();
            }catch(Exception ex){
                
            }
            String url = "http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html";
            _da.CustomerDA da = new CustomerDA();
            _domain.Customer domain = (Customer)request.getSession().getAttribute("Cusrrent_customer_update_data");
            boolean try_data = da.updateRecord(domain, domain.getCust_id());
            if(try_data){
                out.print("$.alert('Your update is complete');");
                url = "http://localhost:8080/GroupProject/_page/client_page/customer/profile/customerProfile.jsp";
            }else{
                out.print("$.alert('Your update is not complete, please try agian later');");
                url = "http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + ErrorDetails.E007.getUrl() + "&url=" + "Customer Login send mail error";
            }
            response.sendRedirect(url);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
