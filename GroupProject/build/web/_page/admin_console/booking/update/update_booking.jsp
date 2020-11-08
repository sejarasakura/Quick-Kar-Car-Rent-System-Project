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
        <title>Admin console - Booking [update]</title>
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
        <style>
            a{
                display: block;
            }
        </style>
    </head>
    <body>
        <div id="header"></div>
        <br>
        <h1 class="text-center">Update Booking Module</h1>
        <br>
        <div class="container">
            <input class="form-control" id="myInput" type="text" placeholder="Search..">
            <br>
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>Booking ID</th>
                  <th>Customer ID</th>
                  <th>Driver ID</th>
                  <th>Booking Date</th>
                  <th>Fetch Date</th>
                  <th>Booking Status</th>
                  <th>Cancel</th>
                </tr>
              </thead>
              <script>
                  function update_booking_s(id){
                    var valid = confirm("Do you sure want to update the booking process with id of " + id); 
                    if(valid){
                        var link = "http://localhost:8080/GroupProject/_page/admin_console/_profile/conti_update.jsp?id=" + id;
                        location.replace(link);
                    }
                  }
              </script>
              <tbody id="myTable">
                <%
                    String URL_PART = "http://localhost:8080/GroupProject/_page/admin_console/_profile/";
                    BookingDA booking = new BookingDA();
                    Object[] bookings = booking.getRecords();
                %>
                <%for(int i = 0; i < bookings.length; i++){ %>
                <%Booking b = (Booking)bookings[i];%>
                    <tr>
                        <td><a href="<%= URL_PART%>booking.jsp?id=<%= b.getBooking_id()%>"><%= b.getBooking_id()%></a></td>
                        <td><a href="<%= URL_PART%>customer.jsp?id=<%= b.getCustomer().getCust_id()%>"><%= b.getCustomer().getCust_id()%></a></td>
                        <td><a href="<%= URL_PART%>driver.jsp?id=<%= b.getDriver().getDriver_id()%>"><%= b.getDriver().getDriver_id()%></a></td>
                        <td><%= b.getBooking_date()%></td>
                        <td><%= b.getFetch_date()%></td>
                        <td><%= b.getBooking_status().getName()%></td>
                        <td>
                            <button onclick="location.href='conti_update.jsp?id=<%= b.getBooking_id()%>'" class="btn btn-success">
                                Update
                            </button>
                        </td>
                    </tr>
                <%}%>
              </tbody>
            </table>

            <p>Note that after cancel booking cannot be change reverse back to un cancel!!</p>
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
