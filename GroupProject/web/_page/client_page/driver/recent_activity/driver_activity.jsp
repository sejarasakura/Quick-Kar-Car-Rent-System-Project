<%-- 
    Document   : driver_activity
    Created on : Jan 3, 2020, 10:04:49 AM
    Author     : ITSUKA KOTORI
--%>
<%@page import="_servletAPI._session.CustomerSession"%>
<%@page import="java.util.Date"%>
<%@page import="_control.domain.Report"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="_control.domain.SQL_control"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Driver Fetch Activity</title>
  <meta charset="utf-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/rate-it/rateit.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/rate-it/jquery.rateit.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/rate-it/jquery.rateit.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
<style media="screen">
.checked {
color: orange;
}
</style>

</head>
<body>

        <div id="header"></div>
<div class="container">
  <center>
  <h2>Fetch Activity</h2>
<p>The results are the recent 7 day(s) activities. If you need more information please contact our customer services.</p>
  <p>You may check your recent activities here</p><br>
</center>

<%
    String id = request.getParameter("id");
    if(id == null||id == ""){
        CustomerSession new_c = new CustomerSession();
        new_c.retriveSeesion(request);
        id = new_c.getUsername();
    }
    String query = SQL_control.read_sql("driver_rating_personal.sql");
    SQL_control control = new SQL_control();
    System.out.println(query);
    PreparedStatement ps = control.prepareStatement(query);
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();
%>
  <hr>
  <%
      if(!rs.next()){
          out.print("<br><h1 class='text-center'>No record found</h1><br><br><br><br><br>");
      }
      while(rs.next()){
      String cust_id = rs.getString(1);
      String cust_name = rs.getString(2);
      String rating_star = rs.getString(3);
      String cust_comment = rs.getString(4);
      Date rating_date = rs.getTimestamp(5);
      RatingStar rts = RatingStar.getValue(rating_star);
  %>
  <div class="media">
    <div class="media-left">
        <img src="/GroupProject/DisplayImage?id=<%= cust_id%>" class="media-object" style="width:100px">
    </div>
    <div class="media-body">
        <h4 class="media-heading"><%= cust_name%>&ensp;<small class="pull-right"><i><%= Report.REPORT_HEADER_FORMAT.format(rating_date)%></i></small></h4>
      <div class="rateit" data-rateit-value="<%= rts.getRating_value()%>" data-rateit-ispreset="true" data-rateit-readonly="true"></div>
      <h5> <p>Your comment(s): </p> </h5>
      <p><%= cust_comment%></p>
    </div>
  </div>
  <hr>
  <%}
    rs.close();
    ps.close();
  %>
  </div>
</body>

        <div id="footer"></div> 
</html>
