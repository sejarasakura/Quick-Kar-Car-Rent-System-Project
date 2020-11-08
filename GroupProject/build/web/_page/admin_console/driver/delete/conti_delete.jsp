<%-- 
    Document   : view_booking
    Created on : Dec 23, 2019, 5:12:26 PM
    Author     : taruc
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.nio.file.Path"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="_control.GenerateID"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" media="all" href="http://localhost:8080/GroupProject/_sub_page/drop_drag/styles.css" />
        
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_sub_page/header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_sub_page/footer.html");
                }
            );
        </script>
    </head>
    <body>
        <%
            DriverDA driver_da = new DriverDA();
            String id = request.getParameter("id");
            boolean approved = driver_da.deleteRecord(id);
        %>
        <div id="header"></div>
        <div>
            <%if(approved == true){%>
            <div class="jumbotron text-center">
              <h1>The driver with id of [<%= id%>] registration is already completed delete, it is completed. </h1>
            </div>
              <div class="container">
                  <a class="btn btn-warning pull-right" style="margin-left: 15px" href="delete_driver.jsp">Delete Other Record</a>
                  <a class="btn btn-info pull-right" href="http://localhost:8080/GroupProject/_page/admin_console/index.html">Back to menu</a>
              </div>
            <%}else{%>
            <div class="jumbotron text-center text-danger bg-danger">
              <h1>Driver id [<%= id%>] not added</h1>    
              <p>your approve , please try again!!</p>
            <a class="btn btn-danger pull-right" href="delete_driver.jsp">Return</a>
            </div>
            <%}%>
        </div>
        <div style="padding-bottom: 20px"></div>
        <div id="footer"></div>
    </body>
</html>
