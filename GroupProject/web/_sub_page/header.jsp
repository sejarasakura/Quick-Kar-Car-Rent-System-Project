<%-- 
    Document   : header
    Created on : Dec 23, 2019, 11:40:56 AM
    Author     : taruc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_servletAPI._session.AdminSession"%>
<!DOCTYPE html>
<html>
    <head>
        <title>QuicKar</title>
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script>
            var btn = "";
            <%
                boolean javaString = false;
                AdminSession new_se = new AdminSession();
                new_se.retriveSeesion(request);
                try{javaString = (boolean)request.getSession().getAttribute("Admin_status");}catch(Exception ex){}
            %>
            var status = <%= javaString%>;
            var user = "<%= new_se.getUsername()%>";
            if(status === false || user === null|| user === 'null'){
                btn = '<button onclick="location.href = \'http://localhost:8080/GroupProject/_page/login/admin/adminlogin.html\';" title="unautorise user" class="btn btn-success pull-right" style="margin: 30px 30px 30px 15px;" value="Log in"><span class="glyphicon glyphicon-log-in"></span>Log in</button>';
            }
            else{
                btn = "<form action='/GroupProject/Admin_logout' method='post'>"
                btn += '<input type="submit" title="Log out account <%= new_se.getUsername()%>" class="btn btn-danger pull-right" style="margin: 30px 30px 30px 15px;" value="Log out">';
                btn += "</form>"
            }
            jQuery(document).ready(
                function(){
                    $("#btn-log").html(btn);
                }
            );
        </script>
    </head>
    <body>
        <header styLe="background-color: #535353">
            <div class="row">
                <div class="col-sm-2" style="margin: 10px 0">
                    <div class="" style="height: 100px;width: 100px;text-align: center; margin: auto;">
                        <a href="http://localhost:8080/GroupProject/_page/admin_console/index.html">
                            <img src="http://localhost:8080/GroupProject/_resource/icon/Quickar_admin_CONSOLE.png" alt="QuicKar Admin console" style="display:block;text-align: middle;height: 100px; width: 100px">
                        </a>
                    </div>
                </div>
                <div class="col-sm-10">
                    <div id="btn-log"></div>
                    <button class="btn btn-primary pull-right" style="margin: 30px 15px;" value="Help" onclick="">Help</button>
                </div>
            </div>
        </header>
    </body>
</html>
