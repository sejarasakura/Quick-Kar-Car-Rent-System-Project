<%-- 
    Document   : view_booking
    Created on : Dec 23, 2019, 5:12:26 PM
    Author     : taruc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - booking detials</title>
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
            String id = (String)request.getParameter("id");
            BookingDA driver_da = new BookingDA();
            boolean deleted = driver_da.deleteRecord(id);
        %>
        <div id="header"></div>
        <div>
            <%if(deleted){%>
            <div class="jumbotron text-center">
              <h1>Booking id [<%= id%>] has been deleted</h1>    
              <p>booking details record is not able to view now!!</p>
            </div>
              <div class="center-block container">
                  <div class="row">
                      <div class="col-sm-6">
                            <a class="btn btn-info center-block" href="delete_booking.jsp">Return</a>
                      </div>
                      <div class="col-sm-6">
                            <a class="btn btn-warning center-block" href="http://localhost:8080/GroupProject/_page/admin_console/index.html#">Back to menu</a>
                      </div>
                  </div>
              </div>
            <%}else{%>
            <div class="jumbotron text-center text-danger bg-danger">
              <h1>Booking id [<%= id%>] has not deleted</h1>    
              <p>booking details record is not deleted please try again!!</p>
            </div>
              <div class="center-block container">
                  <div class="row">
                      <div class="col-sm-6">
                            <a class="btn btn-danger center-block" href="delete_booking.jsp">Return and try agian</a>
                      </div>
                      <div class="col-sm-6">
                            <a class="btn btn-warning center-block" href="http://localhost:8080/GroupProject/_page/admin_console/index.html#">Back to menu</a>
                      </div>
                  </div>
              </div>
            <%}%>
        </div>
        <div style="padding-bottom: 20px"></div>
        <div id="footer"></div>
    </body>
</html>
