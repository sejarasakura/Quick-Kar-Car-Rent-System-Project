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
            String license = request.getParameter("license");
            int year_of_drive = Integer.parseInt(request.getParameter("year_of_drive"));
            String id = GenerateID.generate_Driver(year_of_drive, true);
            String first_name = (String)request.getParameter("first_name");
            String last_name = (String)request.getParameter("last_name");
            String phone_num = (String)request.getParameter("phone_num");
            String ic_num = (String)request.getParameter("ic_num");
            String password = (String)request.getParameter("password");
            String c_password = (String)request.getParameter("confirm_password");
            DriverDA driver_da = new DriverDA();
            Driver driver = new Driver(id, license, year_of_drive, first_name, last_name, ic_num, phone_num, password, null);
            request.getSession().setAttribute("id", driver.getDriver_id());
            boolean added = driver_da.addRecord(driver);
        %>
        <div id="header"></div>
        <div>
            <%if(added){%>
            <div class="jumbotron text-center">
              <h1>The driver has been added with id of [<%= id%>] has been added</h1> 
              <h2>Add profile picture and upload now</h2>
              <p>booking details record is added to database now!!</P>
            </div>
              <div class="container">
              <div id="drag_drop">
                <form id="upload" action="/GroupProject/Add_response_2_driver_reg_admin" method="POST" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Upload photo here</legend>
                        <div class="form-group row">
                            <div class="col-sm-6"><label for="proc_pic">Files to upload:</label></div>
                            <div class="col-sm-6"><input class="form-control" type="file" id="proc_pic" name="proc_pic" ></div>
                        </div>
                    </fieldset>
                    <input class="btn btn-success pull-right" style="margin-left: 15px;" type="submit" value="upload">
                    <button class="btn btn-danger pull-right" action="admin_add_driver.jsp" style="margin-left: 15px">Skip and return</button>
                </form>
              </div>
            <%}else{%>
            <div class="jumbotron text-center text-danger bg-danger">
              <h1>driver id [<%= id%>] not added</h1>    
              <p>driver details record is not added to database, please try again!!</p>
            </div>
            <button class="btn btn-danger" action="admin_add_driver.jsp">Return</button>
            <%}%>
        </div>
        <div style="padding-bottom: 20px"></div>
        <div id="footer"></div>
        <script src="http://localhost:8080/GroupProject/_sub_page/drop_drag/filedrag.js"></script>
    </body>
</html>
