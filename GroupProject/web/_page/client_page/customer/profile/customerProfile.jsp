
<%@page import="_domain.Customer"%>
<%@page import="_da.CustomerDA"%>
<%@page import="_servletAPI._session.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    String id = null;
    try{
        id = new_c.getUsername();
    }catch(Exception ex){
    }
    _da.CustomerDA da = new CustomerDA();
    _domain.Customer domain = new Customer();
    domain = (Customer)da.getRecord(id);
%>
<!DOCTYPE html>
<link rel="stylesheet" href="customerprofile.css">
<html lang="en" dir="lt">
  <head>
    <title>Customer Profile</title>
    <link rel="stylesheet" type="text/css" href="Booking.css">
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
    <title>Customer Profile</title>
  </head>
  <body>
      
    <div id="header"></div>
    <center>
      <h2>Customer Profile</h2>
    </center>
<style>
.classes{
  margin: 10px auto;
  height: 200px;
  width: 200px;


} 
.img{
  height: 100%;
  width:100%;
}

</style>

<div class="container">
  <div class="row">
<div class="center-block">
  <div class="classes"><img src="http://localhost:8080/GroupProject/DisplayImage?id=<%= id%>" alt="" class="img img-circle"></div>
</div>
  </div>

<form class="" action="submit.jsp" method="post">
  <div class="row">
  <div class="col-sm-6">
    <div class="form-group">
      <label for="First Name">First Name:</label>
      <input type="Username" class="form-control" id="first_name" placeholder="First Name" name="first_name" value="<%= domain.getFirst_name()%>">
    </div>

  <div class="form-group">
    <label for="userid">User ID:</label>
    <input type="userid" class="form-control" id="userid" placeholder="user ID" name="userid" disabled value="<%= domain.getCust_id()%>">
  </div>
  <div class="form-group">
    <label for="icnumber">IC Number:</label>
    <input type="icnumber" class="form-control" id="ic_num" placeholder="ic number" name="ic_num" disabled value="<%= domain.getIc_num()%>">
  </div>
  <div class="form-group">
    <label for="Membership">Membership Level:</label>
    <select class="form-control" id="member_level" name="member_level" value="">
        <option value="BR">BR-Bronze Member, Free</option>
        <option value="SI">SI-Silver Member, RM 10 per month, 8% discount</option>
        <option value="AU">AU-Gold Member, RM 50 per month, 20% discount</option>
        <option value="PL">PL-Platinium Member, RM 100 per month, 50% discount</option>
    </select>
  </div>
  <div class="form-group">
    <label for="pnumber">Phone Number:</label>
    <input type="pnumber" class="form-control" id="phone_num" placeholder="phone number" name="phone_num"  value="<%= domain.getPhone_num()%>">
  </div>
</div>
<div class="col-sm-6">
  <div class="form-group">
      <label for="Last Name">Last Name:</label>
      <input type="Username" class="form-control" id="last_name" placeholder="Last Name" name="last_name" value="<%= domain.getLast_name()%>">
  </div>

  <div class="form-group">
    <label for="points">Points:</label>
      <input type="points" class="form-control" id="points" placeholder="points" name="points" disabled value="<%= domain.getPoint_amount()%>">
      </div>
      <button type="submit" class="btn btn-primary" style="width: 100%; margin-top: 20px;">Changes</button>
      <button type="button" onclick="window.history.back();" class="btn btn-danger" style="width: 100%; margin-top: 20px;">Cancel</button>

    </div>
  </div>
</form>
  </div>

            <script>
            $(document).ready(function () {
                
                $(function() {
                    $("#member_level").val('<% out.print(domain.getMembership_level().getDatabaseCode());%>');
                });
            });
            </script>
    <div id="footer"></div>
  </body>
</html>
