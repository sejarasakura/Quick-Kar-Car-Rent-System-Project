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
            Driver cust = (Driver)driver_da.getRecord(id);
            cust.setDriver_id(_control.GenerateID.generate_Driver(cust.getDriver_id(), true));
            boolean approved = driver_da.updateRecord(cust, id);
            if(approved){
                request.getSession().setAttribute("driver_data_for_sen_mail", cust);
                String email = (String)request.getSession().getAttribute("email-" + id);
            }
        %>
        <div id="header"></div>
        <input name="id" type="hidden" style="display:none" value="<%= id%>">
        <div>
            <%if(approved == true){%>
            <div class="jumbotron text-center">
              <h1>The driver with id of [<%= id%>] registration is already approve, it is completed. </h1>
            </div>
              <div class="container">
                  <a class="btn btn-success pull-right" style="margin-left: 15px" href="/_servlet/SendMailApproveDriver" target="_blank">Send mail</a>
                  <a class="btn btn-warning pull-right" style="margin-left: 15px" href="approve_html.html">Return</a>
                  <a class="btn btn-info pull-right" href="http://localhost:8080/GroupProject/_page/admin_console/_profile/driver.jsp?id=<%= id%>">View record</a>
              </div>
            <%}else{%>
            <div class="jumbotron text-center text-danger bg-danger">
              <h1>Customer id [<%= id%>] not added</h1>    
              <p>your approve , please try again!!</p>
            </div>
            <a class="btn btn-danger pull-right" href="approve_driver.html">Return</a>
            <%}%>
        </div>
        <div style="padding-bottom: 20px"></div>
        <div id="footer"></div>
    </body>
</html>
