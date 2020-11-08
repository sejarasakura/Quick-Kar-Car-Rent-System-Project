<%-- 
    Document   : fetching
    Created on : Jan 5, 2020, 10:02:27 PM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_manipulation.MapManipulation"%>
<%@page import="_domain.DistanceMatricRespond"%>
<%@page import="_domain.DistanceMatricRespond"%>
<%@page import="_enum.MembershipLevel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="_control.domain.Report"%>
<%@page import="_enum.RatingStar"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="_control.domain.SQL_control"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <title>Future Fetch</title>
    </head>
    <body>
        <div id="googlemaps"></div>
        <div style="padding-top: 50px;padding-bottom: 50px;" class="container">

        <center>
            <h2>Fetch Activity</h2>
            <p>The results are the future activities. If you need more information please contact our customer services.</p>
            <p>You may check the customer can fetch activities here</p><br>
        </center>
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.card .title {
  color: grey;
  font-size: 18px;
}

.card button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

.card button:hover, .card a:hover {
  opacity: 0.7;
}
</style>

          <%
              
              SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy hh:mm");
              String id = request.getParameter("id");
              String query = SQL_control.read_sql("driver_take_need_fetch_now.sql");
              SQL_control control = new SQL_control();
              System.out.println(query);
              PreparedStatement ps = control.prepareStatement(query);
              ResultSet rs = ps.executeQuery();
              int count = 0;
              boolean loop_liao = false;
          %>
            <%
                while(rs.next()){
                loop_liao = true;
                String cust_id = rs.getString(1);
                String cust_name = rs.getString(2);
                String phone_number = rs.getString(3);
                String member_level = rs.getString(4);
                Date fetch_date = rs.getTimestamp(5);
                String start_location = rs.getString(6);
                String end_location = rs.getString(7);
                if(count == 0){
                    %><div class="row"><%
                }
                DistanceMatricRespond temp_matric_data = MapManipulation.getResponse(start_location, end_location);
            %>
            
<div class="col-sm-4">
    <div class="card">
      <img src="http://localhost:8080/GroupProject/DisplayImage?id=<%= cust_id%>" alt="<%= cust_name%>[<%= cust_id%>]" style="width:100%">
      <h1><%= cust_name%></h1>
      <h3><%= MembershipLevel.getValue(member_level).getName()%> Member</h3>
      <p class="title">Phone Number:<%= phone_number%></p>
      <p>Fetch Time: <%= DATE_FORMAT.format(fetch_date)%></p>
      <p>Distance : <%= temp_matric_data.getDistance_text()%></p>
      <p>Duration : <%= temp_matric_data.getDuration_text()%></p>
      <p>From <%= temp_matric_data.getOrigin_address()%> To <%= temp_matric_data.getDestination_address()%></p>
      <p><button>Pick up</button></p>
    </div>
</div>

            <%
                count++;
                if(count == 3){
                    %></div><%
                    count = 0;
                }
            %>
            <%}%>
            <%
              rs.close();
              ps.close();
              if(!loop_liao){
                    out.print("<br><h1 class='text-center'>No record found</h1><br><br><br><br><br>");
                }
            %>
        </div>
    </body>
</html>
