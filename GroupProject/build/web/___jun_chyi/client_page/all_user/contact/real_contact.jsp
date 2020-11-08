<%-- 
    Document   : real_contact
    Created on : Dec 29, 2019, 12:04:10 AM
    Author     : xps
--%>

<%@page import="java.util.Date"%>
<%@page import="_control.GenerateID"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*, _domain.*"%>
<!DOCTYPE html>
<%
    _da.ContactUsDA da = new _da.ContactUsDA();
    String name = (String)request.getParameter("name");
    String email = (String)request.getParameter("email");
    String phone = (String)request.getParameter("phone");
    String message = (String)request.getParameter("message");
    ContactUs domain = new ContactUs();
    domain.setName(name);
    domain.setEmail(email);
    domain.setPhone(phone);
    domain.setMessagge(message);
    domain.setId(GenerateID.generate_ContactUs());
    domain.setContact_date(new Date());
    boolean success = da.addRecord(domain);
%>
<html>
    <head>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us - result</title>
    </head>
    <body>
        <div>
            <div class="jumbotron text-center">
                <%if(success){%>
                <h1>Your feed back is send to us</h1>
                <%} else {%>
                <h1>Message is not send, please try agian</h1>
                <%}%>
                <div class="container">
                    <div class="row">
                        <%if(success){%>
                        <div class="alert alert-success">
                            <b>Success to to send your feedback to us,</b> we will reply your email or phone number in 1 week and try to solve the problem as fast as possible. Thank you
                        </div>
                        <%} else {%>
                        <div class="alert alert-danger">
                            <b>Failed to send the message to us,</b> maybe due to the connection to the serve. You might try again to resend your problem or massage to us. 
                        </div>
                        <%}%>
                    </div>
                </div>
                    <div class="center-block">
                        <a href="../../index.html" class="btn btn-warning">
                            Back to home page
                        </a>
                    </div>
            </div>
        </div>
    </body>
</html>
