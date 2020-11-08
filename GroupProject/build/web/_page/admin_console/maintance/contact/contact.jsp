<%-- 
    Document   : contact
    Created on : Dec 29, 2019, 2:32:58 AM
    Author     : xps
--%>

<%@page import="_domain.*"%>
<%@page import="_da.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QuicKar contact</title>
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
        <div id="header"></div>
        
        <br>
        <h1 class="text-center">Contact Us List</h1>
        <br>
        <div class="container">
            <input class="form-control" id="myInput" type="text" placeholder="Search..">
            <br>
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>Contact us ID</th>
                  <th>Full name</th>
                  <th>Email Address</th>
                  <th>Phone number</th>
                  <th>Description</th>
                  <th>Contact Time</th>
                </tr>
              </thead>
              <tbody id="myTable">
                <%
                    ContactUsDA booking = new ContactUsDA();
                    Object[] bookings = booking.getRecords();
                %>
                <%for(int i = 0; i < bookings.length; i++){ %>
                <%ContactUs b = (ContactUs)bookings[i];%>
                    <tr>
                        <td><%= b.getId()%></td>
                        <td><%= b.getName()%></td>
                        <td><%= b.getEmail()%></td>
                        <td><%= b.getPhone()%></td>
                        <td><%= b.getMessagge()%></td>
                        <td><%= b.getContact_date()%></td>
                    </tr>
                <%}%>
              </tbody>
            </table>

          </div>
        <div id="footer"></div>
    </body>
    
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});
</script>

</html>