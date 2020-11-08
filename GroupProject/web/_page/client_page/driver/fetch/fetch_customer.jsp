<%-- 
    Document   : fetch_customer
    Created on : Jan 5, 2020, 9:46:00 PM
    Author     : ITSUKA KOTORI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="payment.css">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
    <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
    <title>Payment</title>
    </head>
    <body>
        <div id="header"></div>
        
        <script type="text/javascript">
            $(document).ready(function() {
                var reloadData = 0; // store timer

                // load data on page load, which sets timeout to reload again
                loadData();
            });

            function loadData() {
                $('#load_me').load('fetching.jsp', function() {
                    if (reloadData != 0)
                        window.clearTimeout(reloadData);
                        
                    reloadData = window.setTimeout(loadData, 3000);
                }).fadeIn("slow"); 
            }
        </script>

        <div id="load_me"></div>
        
        <div id="footer"></div>
    </body>
</html>