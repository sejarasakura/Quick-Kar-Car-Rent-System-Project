<%-- 
    Document   : retrive_backup
    Created on : Dec 26, 2019, 1:28:55 PM
    Author     : xps
--%>

<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_manipulation.*"%>
<%
    File file = new File(Path_Manipulate.getDatabaseDirectory() + "DB-BACKUP/");
    String[] directories = file.list(new FilenameFilter() {
      @Override
      public boolean accept(File current, String name) {
        return new File(current, name).isDirectory();
      }
    });
%>
<!DOCTYPE html>
<html>
    <head>
        <title>QuicKar - Admin console</title>
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
        <style>
            .modules{
                min-height: 200px;
            }
        </style>
    </head>
    <body>
        <div id="header"></div>
        <div class="jumbotron text-center">
            <div id="_maintance" class="modules-s">
                <h2>QuicKar backup and recovery</h2>
                <p>QuicKar - Admin console</p>
            </div>
        </div>
        <div class="container">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th> No. </th>
                        <th> Table Name </th>
                        <th> Backup Date </th>
                        <th> Recovery </th>
                    <tr>
                </thead>
                <tbody>
                    <%request.getSession().setAttribute("directories", directories);%>
                    <%for(int i = 0; i < directories.length; i++){%>
                    <tr>
                        <td><%= (i + 1)%></td>
                        <td><%= directories[i].split("-")[0]%></td>
                        <td><%= directories[i].split("-", 2)[1]%></td>
                        <td><a href="/GroupProject/restore_backup?index=<%= i%>" class="btn btn-danger" style="">Recovery</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <div id="footer"></div>
    </body>
</html>

