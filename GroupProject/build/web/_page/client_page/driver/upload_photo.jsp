<%-- 
    Document   : upload_photo
    Created on : Jan 4, 2020, 6:09:52 AM
    Author     : ITSUKA KOTORI
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="_servletAPI._session.CustomerSession"%>
<%@page import="_servletAPI._session.DriverSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>QuicKar</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_page/client_base/css/base2.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
        <script src="http://localhost:8080/GroupProject/_page/client_base/javascript/base_loading.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
        
    </head>
    <body>
        <div id="header"></div>
        <%
            String id = request.getParameter("id");
        %>
        <% request.getSession().setAttribute("id", id);%>
        <% request.getSession().setAttribute("Add_response_2_driver_reg_admin", true);%>
        <div class="container center-block" style="margin: 100px auto">
              <div id="drag_drop">
                <form id="upload" action="/GroupProject/Add_response_2_driver_reg_admin" method="POST" enctype="multipart/form-data">
                    <fieldset>
                        <legend>Upload photo here</legend>
                        <div class="form-group row">
                            <div class="col-sm-6"><label for="proc_pic">Files to upload:</label></div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-12"><input class="form-control" type="file" id="proc_pic" name="proc_pic" style="height: 200px"></div>
                        </div>
                    </fieldset>
                    <input class="btn btn-success pull-right" style="margin-left: 15px;" type="submit" value="upload">
                    <a class="btn btn-danger pull-right" href="" style="margin-left: 15px">Cancel Upload</a>
                </form>
              </div>
            </div>
        <div id="footer"></div>
    </body>
</html>
