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
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="payment.css">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
        <%String status = request.getParameter("status");%>
        <%if(status != null){%>
            <%if(status.equals("1")){%>
                <script>
                    $.confirm({
                        title: 'Had error found !!!',
                        content: 'Your account is not yet have any payment method, please add a payment method to try agian',
                        type: 'red',
                        autoClose: 'close|5000',
                        typeAnimated: true,
                        buttons: {
                            close: function () {
                            }
                        }
                    });
                </script>
            <%}%>
        <%}%>
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
        <h2>Confirmation<p>Select payment method</p>
        </h2>

        <div class="form">
            <div>
                <a class="btn btn-info" href="payment_Cash.jsp">
                Pay in Cash
                </a>
            </div>
            
            <div>
                <a class="btn btn-info" href="payment_eWallet.jsp">
                Pay in eWallet
                </a>
            </div>

            <div>
                <a class="btn btn-info" href="payment_Card.jsp">
                Pay in Card/ Debit Card
                </a>
            </div>
        </div>
    </div>

      <div id="footer"></div>
</body>

</html>