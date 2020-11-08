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
  <title>Booking record and comments</title>
  <meta charset="utf-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/rate-it/rateit.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
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

.c_panel{
    background-color: #f6f6f6;
    border: 1px solid #ccc!important;
    padding: 10px;
    display: none;
    position: fixed;
    z-index: 2;
    transform: translate(-50%, -50%);
    left:50%;
    top:50%;
    border-radius: 5px;
    width: 500px;
    height: 290px;
}
</style>

</head>
<body>

        <div id="header"></div>
<div class="container">
  <center>
  <h2>Recent Activity</h2>
<p>The results are the recent 7 day(s) activities. If you need more information please contact our customer services.</p>
  <p>You may check your recent activities here</p><br>
</center>

<%
    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    String id = new_c.getUsername();
    String query = SQL_control.read_sql("customer_rating_history.sql");
    SQL_control control = new SQL_control();
    PreparedStatement ps = control.prepareStatement(query);
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();
    boolean loopliao = false;
%>
  <hr>
  <%
      while(rs.next()){
          loopliao = true;
      String driver_id = rs.getString(1);
      String driver_name = rs.getString(2);
      String rating_star = rs.getString(3);
      String cust_comment = rs.getString(4);
      Date rating_date = rs.getTimestamp(5);
      String rating_id = rs.getString(6);
      String s7 = rs.getString(7);
      String s8 = rs.getString(8);
      RatingStar rts = RatingStar.getValue(rating_star);
  %>
  <div class="media" id="media-<%= rating_id%>">
    <div class="media-left">
        <img src="/GroupProject/DisplayImage?id=<%= driver_id%>" class="media-object" style="width:100px">
    </div>
    <div class="media-body">
        <h4 class="media-heading"><%= driver_name%>&ensp;<small class="pull-right"><i><%= Report.REPORT_HEADER_FORMAT.format(rating_date)%></i><button style="margin-left: 10px;" class="btn btn-info" id="button-<%= rating_id%>">Comment</button></small></h4>
      <div class="rateit" data-rateit-value="<%= rts.getRating_value()%>" data-rateit-ispreset="true" data-rateit-readonly="true"></div>
      <div class="row">
          <div class="col-sm-4">Payment Amount :</div>
          <div class="col-sm-8"><%= s7%></div>
      </div>
      <div class="row">
          <div class="col-sm-4">Payment Status :</div>
          <div class="col-sm-8"><%= PaymentStatus.getValue(s8).getName()%></div>
      </div>
      <h5> <p>Your comment(s): </p> </h5>
      <p><%= cust_comment%></p>
    </div>
  </div>
  <div class="c_panel" id="box-<%= rating_id%>">
      <form method="post" action="http://localhost:8080/GroupProject/CustomerUpdateRating">
            <div class="form-group">
                <label for="comment">Comment:</label>
                <textarea class="form-control" rows="5" name="comment"></textarea>
                <br>
                <div class="center-block">
                    <div onclick="$('#star-<%= rating_id%>').val($('#rate-<%= rating_id%>').rateit('value'));" class="rateit" id="rate-<%= rating_id%>" data-rateit-mode="font"  style="font-size:50px">
                    </div>
                </div>
            </div>
                    <input style="display:none" type="hidden" name="rating_id" value="<%= rating_id%>">
                    <input style="display:none" type="hidden" name="star" id="star-<%= rating_id%>" value="<%= rating_id%>">
                    <input style="display:none" type="hidden" name="status" value="1">
            <div class="row">
                <div class="col-sm-6"><input type="submit" style="width: 100%" value="Submit Comment" class="btn btn-success"></div>
                <div class="col-sm-6"><input style="width: 100%" class="btn btn-danger" onclick='$("#box-<%= rating_id%>").toggle();' value="Close"></div>
            </div>
      </form>
  </div>
  <hr>
  <script>
    $(document).ready(function(){
      $("#button-<%= rating_id%>").click(function(){
        $("#box-<%= rating_id%>").toggle();
      });
    });
  </script>
  <%}
    rs.close();
    ps.close();
    if(!loopliao){
        out.print("<br><h1 class='text-center'>No record found</h1><br><br><br><br><br>");
    }
  %>
  
  </div>
</body>

        <div id="footer"></div> 
</html>
