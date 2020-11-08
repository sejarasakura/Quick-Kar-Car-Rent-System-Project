<!DOCTYPE html>
<%-- 
    Document   : not_admin_error
    Created on : Dec 9, 2019, 6:06:27 PM
    Author     : ITSUKA KOTORI
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "_enum.*,_servletAPI._session.*" %>
<%
    ErrorDetails code = ErrorDetails.E000;
    code = code.getValue(request.getParameter("code"));
    AdminSession admin_s = new AdminSession();
    admin_s.retriveSeesion(request);
%>
<html>
    <head>
        <link rel="icon" href="../../_resource/icon/top_full_icon.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../_jquery/jquery.min.js">
        <link rel="stylesheet" href="../../_bootstrap/js/bootstrap.min.js">
        <title><%= code.getName()%></title>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1 class="text-danger"><%= code.getName()%></h1>
            <h3>Error Code: <%= code%></h3>
        </div>
        <div class="row">
            <div class="col-sm-2">

            </div>
            <div class="col-sm-8" style="padding: 50px;">
                <div style="padding: 25px; margin: auto; height: 250px;width: 250px">
                    <img src="http://localhost:8080/GroupProject/_resource/icon/road_block.png" class="" alt="Eccess error" width="200" height="200" />
                </div>
                <h3 calss="text-secondary">
                    Description : <%= code.getDecription()%>
                </h3>
                <h3 class="text-secondary">
                    Message From URL :<%= request.getParameter("url")%>
                </h3>
                <h2 class="text-secondary">
                    Session value
                </h2>
                <h4 class="text-secondary">
                    <ol>
                        <li>Admin username: <%= admin_s.getUsername()%></li>
                        <li>Admin password: <%= admin_s.getPassword()%></li>
                        <li>Admin login status: <%= admin_s.hasLogin(request)%></li>
                    </ol>
                </h4>
            </div>
            <div class="col-sm-2">

            </div>
        </div>
    </body>
</html>
