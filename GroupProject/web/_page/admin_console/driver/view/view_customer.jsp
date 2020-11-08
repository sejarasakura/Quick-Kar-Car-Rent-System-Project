<%-- 
    Document   : newjsp
    Created on : Dec 23, 2019, 5:03:17 PM
    Author     : taruc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - Booking [delete]</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/image.css">
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_sub_page/header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_sub_page/footer.html");
                }
            );
        </script>
        <style>
            a{
                display: block;
            }
        </style>
    </head>
    <body>
        <div id="header"></div>
        <br>
        <h1 class="text-center">Delete Customer Module</h1>
        <br>
        <div class="container">
            <input class="form-control" id="myInput" type="text" placeholder="Search..">
            <br>
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>Customer ID</th>
                  <th>Name</th>
                  <th>Phone number</th>
                  <th>IC number</th>
                  <th>Point amount</th>
                  <th>Membership level</th>
                  <th>Profile picture</th>
                </tr>
              </thead>
              <script>
              </script>
              <tbody id="myTable">
                <%
                    String URL_PART = "http://localhost:8080/GroupProject/_page/admin_console/_profile/";
                    CustomerDA booking = new CustomerDA();
                    Object[] bookings = booking.getRecords();
                %>
                <%for(int i = 0; i < bookings.length; i++){ %>
                <%Customer b = (Customer)bookings[i];%>
                    <tr>
                        <td><a href="<%= URL_PART%>customer.jsp?id=<%= b.getCust_id()%>"><%= b.getCust_id()%></a></td>
                        <td><%= b.getFull_Name()%></td>
                        <td><%= b.getPhone_num()%></td>
                        <td><%= b.getIc_num()%></td>
                        <td><%= b.getPoint_amount()%></td>
                        <td><%= b.getMembership_level().getName()%></td>
                        <td>
                            <div class="center-block" style="height: 30px; width: 30px;">
                                <img class="img-circle img-full" src="http://localhost:8080/GroupProject/DisplayImage?id=<%= b.getCust_id()%>">
                            </div>
                        </td>
                    </tr>
                <%}%>
              </tbody>
            </table>

            <p>Note that after delete customer cannot be change reverse back to un delete from database forever!!</p>
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
