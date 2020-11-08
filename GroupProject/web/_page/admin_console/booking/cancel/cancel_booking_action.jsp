<%-- 
    Document   : view_booking
    Created on : Dec 23, 2019, 5:12:26 PM
    Author     : taruc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - Cancel booking</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_sub_page/header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_sub_page/footer.html");
                }
            );
        </script>
    </head>
    <body>
        <%
            boolean success_s = false;
            String id = (String)request.getParameter("id");
            BookingDA booking = new BookingDA();
            Booking bookings = (Booking)booking.getRecord(id);
            bookings.setBooking_status(BookingStatus.getValue("B4"));
            if(booking.updateRecord(bookings, id))
                success_s = true;
        %>
        <div id="header"></div>
        <div class="jumbotron text-center">
            <%if(success_s){%>
              <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Success cancel the following booking!</h4>
                <p>
                    The booking with ID of <%= bookings.getBooking_id()%> has been canceled completely success.
                </p>
              </div>
                <div class="container row center-block">
                    <div class="col-sm-6">
                        <a class="btn btn-default" style="width: 100%" href="http://localhost:8080/GroupProject/_page/admin_console/index.html">
                            Back to menu
                        </a>  
                    </div>
                    <div class="col-sm-6">
                        <a class="btn btn-info" style="width: 100%" href="http://localhost:8080/GroupProject/_page/admin_console/booking/cancel/cancel_booking.jsp">
                            Return Back
                        </a>  
                    </div>
                </div>
            <%}else{%>
              <div class="alert alert-danger" role="alert">
                <h4 class="alert-heading">Failed cancel the following booking!</h4>
                <p>
                    The booking with ID of <%= bookings.getBooking_id()%> has not been cancel , please try again later.
                </p>
              </div
                <div class="container row">
                    <div class="col-sm-6">
                        <a class="btn btn-default" href="http://localhost:8080/GroupProject/_page/admin_console/index.html">
                            Back to menu
                        </a>  
                    </div>
                    <div class="col-sm-6">
                        <a class="btn btn-info" href="http://localhost:8080/GroupProject/_page/admin_console/booking/cancel/cancel_booking.jsp">
                            Try Agian
                        </a>  
                    </div>
                </div>
            <%}%>
        </div>
        <div id="footer"></div>
    </body>
</html>
