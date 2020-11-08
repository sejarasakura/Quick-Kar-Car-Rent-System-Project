<%-- 
    Document   : profile_card
    Created on : Jan 2, 2020, 12:23:14 PM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_enum.ErrorDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*, _control.*"%>
<%@page import="_domain.*"%>
<% 
    String id = request.getParameter("id");
    Driver domain = null;
    DriverDA da = new DriverDA();
    domain = (Driver)da.getRecord(id);
    if(domain == null)
        response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + ErrorDetails.E013.getUrl() + "&url=Driver ID");
    CarDA car_da = new CarDA();
    Object[] cars = car_da.getRecords("driver_id = \'" + domain.getDriver_id() + "\'");
    if(cars.length == 0)
        response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + ErrorDetails.E013.getUrl() + "&url=Car ID");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_page/client_page/driver/profile/profile_card.css">
    </head>
    <body>
        <div class="card">
          <img src="http://localhost:8080/GroupProject/DisplayImage?id=<%= domain.getDriver_id()%>" alt="<%= domain.getFull_Name()%>" style="width:100%">
          <h1><%= domain.getFull_Name()%></h1>
          <p class="title"><%= domain.getPhone_num()%></p>
          <p>QuicKar 2.0</p>
          <div style="margin: 24px 0;">
            <a href="#"><i class="fa fa-dribbble"></i></a> 
            <a href="#"><i class="fa fa-twitter"></i></a>  
            <a href="#"><i class="fa fa-linkedin"></i></a>  
            <a href="#"><i class="fa fa-facebook"></i></a> 
          </div>
          <p><a href=""><button>Book now</button></a></p>
        </div>
    </body>
</html>
