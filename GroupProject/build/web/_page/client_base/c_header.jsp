<%-- 
    Document   : c_header
    Created on : Dec 27, 2019, 9:36:54 PM
    Author     : xps
--%>

<%@page import="_servletAPI._session.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    boolean javaCust = false;
    boolean javaDriver = false;
    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    DriverSession new_d = new DriverSession();
    new_d.retriveSeesion(request);
    String id = null;
    try{
        javaDriver = (boolean)request.getSession().getAttribute("Driver_status");
        id = new_d.getUsername();
        byte[] b = id.getBytes();
    }catch(Exception ex){
        javaDriver = false;
        try{
            javaCust = (boolean)request.getSession().getAttribute("Customer_status");
            id = new_c.getUsername();
        }catch(Exception ex2){
            javaCust = false;
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>
    </head>
    <body>
        <nav class="navbar navbar-inverse" style="margin:0; border-radius: 0px">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html#">QuicKar</a>
    </div>
    <ul class="nav navbar-nav">
      <li class=""><a href="http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html#">Home</a></li>
      
      <%if(javaDriver == true){%>
      <li><a href="http://localhost:8080/GroupProject/_page/client_page/driver/fetch/fetch_customer.jsp">Fetch now</a></li>
      <%}else if(javaCust == true){%>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Book Now<span class="caret"></span></a>
        <ul class="dropdown-menu" style="background-color: #333;color: #eee;">
          <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/booking/Booking.jsp">Just Quick</a></li>
          <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/booking/Booking.jsp">Premium Quick</a></li>
          <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/booking/Booking.jsp">Six Seat Quick</a></li>
        </ul>
      </li>
      <%}%>
      <li><a href="http://localhost:8080/GroupProject/_page/client_page/all_user/contact/index-contact.html">Contact Us</a></li>
    </ul>
      <%if(javaDriver == true){%>
      <ul class="nav navbar-nav navbar-right">
      <li class=""><a href="http://localhost:8080/GroupProject/_servlet/Driver_Logout">Logout</a></li>
      <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="padding: 5px 18px;">
              <div style="height: 40px;width: 40px">
                  <img alt="profile picture"  class="img-circle" height="100%" width="100%" src="http://localhost:8080/GroupProject/DisplayImage?id=<%= id%>">
              </div>
          </a>
            <ul class="dropdown-menu" style="background-color: #333;color: #eee;">
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/driver/upload_photo.jsp?id=<%= id%>">Change profile picture</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/driver/profile/driverProfile.jsp">Driver profile</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/driver/recent_activity/driver_activity.jsp?id=<%= id%>">Rental activity</a></li>
            </ul>
        </li>
    </ul>
      <%}else if(javaCust == true){%>
      <ul class="nav navbar-nav navbar-right">
      <li class=""><a href="http://localhost:8080/GroupProject/_servlet/Customer_Logout">Logout</a></li>
      <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="padding: 5px 18px;">
              <div style="height: 40px;width: 40px">
                  <img alt="profile picture"  class="img-circle" height="100%" width="100%" src="http://localhost:8080/GroupProject/DisplayImage?id=<%= id%>">
              </div>
          </a>
            <ul class="dropdown-menu" style="background-color: #333;color: #eee;">
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/upload_photo.jsp?id=<%= id%>">Change profile picture</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/profile/customerProfile.jsp">Customer profile</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/recent_activity/recent_activity.jsp">Booking record</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/client_page/customer/payment/payment_Confirm.jsp">Add payment method</a></li>
                </ul>
        </li>
    </ul>
      <%}else{%>
    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>Register</a>
            <ul class="dropdown-menu" style="background-color: #333;color: #eee;">
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/register/driverregister.html">Driver</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/register/customerregister.html">Customer</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a>
            <ul class="dropdown-menu" style="background-color: #333;color: #eee;">
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/login/client/driver.html">Driver</a></li>
                <li style="color: #eee;"><a style="color: #eee;background-color:#333" href="http://localhost:8080/GroupProject/_page/login/client/customer.html">Customer</a></li>
            </ul>
        </li>
    </ul>
    <%}%>
  </div>
</nav>
  
    </body>
</html>
