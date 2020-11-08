<%-- 
    Document   : Booking
    Created on : Dec 30, 2019, 6:16:19 PM
    Author     : xps
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_servletAPI._session.*" %>
<!DOCTYPE html>

<%
    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    request.getSession().setAttribute("cust_id", new_c.getUsername());
    request.getSession().setAttribute("pay_method", "cash");
%>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="payment.css">

        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
    <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
    <title>Payment</title>
</head>

<body>
    
      <div id="header"></div>
    <div class="payment">
        <h2>Payment <p>Cash</p></h2>

        <form action="http://localhost:8080/GroupProject/_page/client_page/customer/payment/payment_conti.jsp" method="post">
            <div class="form">
                <div class="card space icon-relative">
                    <label class="label">Cash:</label>
                    <input type="text" class="input" name="card_holder" placeholder="Pay on ride the amount" readonly="">
                    <input type="submit" class="btn btn-info" value="Select">
                </div>
            </div>
        </form>
    </div>

      <div id="footer"></div>
</body>

</html>