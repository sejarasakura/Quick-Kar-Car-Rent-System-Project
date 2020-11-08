<%-- 
    Document   : driverProfile
    Created on : Jan 5, 2020, 12:08:29 PM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_servletAPI._session.DriverSession"%>
<%@page import="_da.DriverDA"%>
<%@page import="_domain.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DriverSession new_c = new DriverSession();
    new_c.retriveSeesion(request);
    String id = null;
    try{
        id = new_c.getUsername();
    }catch(Exception ex){
    }
    _da.DriverDA da = new DriverDA();
    _domain.Driver domain = new Driver();
    domain = (Driver)da.getRecord(id);
    request.getSession().setAttribute("driver_update_profile_stdio", domain);
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <title>Customer Profile</title>
    <link rel="stylesheet" href="../customerprofile.css">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
        
    <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
    <meta charset="utf-8">
    <title>Driver Profile</title>
</head>

<body>
  <div id="header"></div>
  <center>
    <h2>Driver Profile</h2>
  </center>
  <style>
    .classes {
      margin: 10px auto;
      height: 200px;
      width: 200px;
    }
    .img {
      height: 100%;
      width: 100%;
    }
  </style>
  <div class="container">
<form class="" action="submit.jsp" method="post">
    <div class="row">
      <div class="center-block">
        <div class="classes"><img src="http://localhost:8080/GroupProject/DisplayImage?id=<%= id%>" alt="" class="img img-circle"></div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-6">
        <div class="form-group">
          <label for="First Name">First Name:</label>
          <input type="First Name" class="form-control" id="first_name" placeholder="First Name" name="first_name" value="<%= domain.getFirst_name()%>">
        </div>
        <div class="form-group">
          <label for="Username">License:</label>
          <input type="Username" class="form-control" id="license" placeholder="Liscence" name="license" value="<%= domain.getLicense()%>" disabled="">
        </div>
        <div class="form-group">
          <label for="userid">User ID:</label>
          <input type="userid" class="form-control" id="user_id" placeholder="user ID" name="user_id" disabled value="<%= domain.getDriver_id()%>">
        </div>
        <div class="form-group">
          <label for="icnumber">IC Number:</label>
          <input type="icnumber" class="form-control" id="ic_num" placeholder="ic number" name="ic_num" disabled value="<%= domain.getIc_num()%>">
        </div>
        <div class="form-group">
          <label for="Year(s) of driving">Year(s) of driving:</label>
          <input type="Year(s) of driving" class="form-control" id="year_of_drive" placeholder="Year(s) of driving" name="year_of_drive" disabled value="<%= domain.getYear_of_drive()%>">
        </div>

      </div>
      <div class="col-sm-6">
        <div class="form-group">
          <label for="Last Name">Last Name:</label>
          <input type="Last Name" class="form-control" id="last_name" placeholder="Last Name" name="last_name" value="<%= domain.getLast_name()%>">
        </div>
        <div class="form-group">
          <label for="pnumber">Phone Number:</label>
          <input type="pnumber" class="form-control" id="phone_num" placeholder="phone number" name="phone_num" value="<%= domain.getPhone_num()%>">
        </div>

        <input type="submit" class="btn btn-primary" style="width: 100%; margin-top: 20px;" value="Changes">
        <a class="btn btn-danger" style="width: 100%; margin-top: 20px;" href="http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html">Cancel</a>

      </div>
        </div>
</form>
    </div>
  <div id="footer"></div>
</body>

</html>