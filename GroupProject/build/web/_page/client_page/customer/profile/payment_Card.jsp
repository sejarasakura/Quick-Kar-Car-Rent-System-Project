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
<html lang="en" dir="ltr"><!-- Latest compiled and minified CSS -->
  <head>
    <meta charset="utf-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
    <link rel="stylesheet" href="payment.css">
    <title>Payment</title>
    <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
  </head>

  <body>
      <div id="header"></div>
      
      <form action="" type="post">
            <div class="payment">
        <h2>Payment<p>Credit/ Debit Card</p></h2>

        <div class="form">
          <div class="card space icon-relative">
            <label class="label">Card Holder:</label>
            <input type="text" class="input" name="card_holder" placeholder="Your name">
          </div>

          <div class="card space icon-relative">
            <label class="label">Card Number:</label>
            <input type="text" class="input" name="card_number" placeholder="Card Number">
          </div>

          <div class="card-grp space">
            <div class="card-item icon-relative">
              <label class="label">Expiry Date: </label>
              <input type="text" class="input" name="expiry_date" placeholder="00/00">
            </div>

            <div class="card-item icon-relative">
                <label class="label">CVV: </label>
                <input type="text" class="input" name="cvv" placeholder="000">
          </div>
        </div>
        <a class="btn btn-info">
                  Pay
        </a>

      </div>
    </div>
      </form>
      <div id="footer"></div>
  </body>
</html>
