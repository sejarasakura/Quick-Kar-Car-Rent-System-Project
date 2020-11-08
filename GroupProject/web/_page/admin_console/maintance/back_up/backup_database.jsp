<%-- 
    Document   : backup_database
    Created on : Dec 26, 2019, 5:28:59 AM
    Author     : xps
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Back up complete</title>
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <div id="header"></div>
        <div class="jumbotron text-center">
            <div id="_maintance" class="modules-s">
                <h1>Yours backup is done and finish.</h1>
            </div>
        </div>
        <div class="container">            
            <a href="http://localhost:8080/GroupProject/_page/admin_console/index.html" class="btn btn-info pull-right" style="margin: 15px;display:block">Return back</a>
        </div>
        
        <div id="footer"></div>
    </body>
</html>
