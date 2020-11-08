<%-- 
    Document   : driver_done
    Created on : Jan 4, 2020, 3:16:13 AM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_domain.Customer"%>
<%@page import="_da.DriverDA"%>
<%@page import="_da.PaymentMethodDA"%>
<%@page import="_domain.PaymentMethod"%>
<%@page import="_domain.Driver"%>
<%@page import="_enum.ErrorDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_servletAPI._session.*"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Register</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_page/client_base/css/base2.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
        <script src="http://localhost:8080/GroupProject/_page/client_base/javascript/base_loading.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
        <%boolean updated = false;%>
        <%
            Customer domain = new Customer();
            PaymentMethod domain2 = new PaymentMethod();
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String ic_number = request.getParameter("ic_number");
            String email = request.getParameter("email");
            String phone_num = request.getParameter("phone_num");
            String payment_method = request.getParameter("payment_method").split("-")[0];
            String password = request.getParameter("password");
            String member_level = request.getParameter("member_level");
            String card_num = request.getParameter("card_num");
            domain.setFirst_name(first_name);
            domain.setLast_name(last_name);
            domain.setIc_num(ic_number);
            domain.setPassword(password);
            domain.setPhone_num(phone_num);
            domain.setCust_id(_control.GenerateID.generate_Cust(member_level));
            domain2.setPay_method(_enum.PaymentMethodType.getValue(payment_method));
            domain2.setCard_num(card_num);
            domain2.setUser(domain.getCust_id());
            domain2.setPay_method_id(_control.GenerateID.generate_PayMethod(domain2));
            DriverDA da1 = new DriverDA();
            PaymentMethodDA da2 = new PaymentMethodDA();
            da1.addRecord(domain);
            da2.addRecord(domain2);
        %>
    </head>
    <body>
        <div id="header"></div>
        <%if(updated){%>
            <%response.sendRedirect("http://localhost:8080/GroupProject/_page/login/client/customer.html");%>
        <%}else{%>
        <%
            response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                    + ErrorDetails.E009.getUrl() + "&url=addCustoemr");      
        %>
        <%}%>
        <div id="footer"></div> 
    </body>
</html>
