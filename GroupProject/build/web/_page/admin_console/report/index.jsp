<%-- 
    Document   : index
    Created on : Jan 1, 2020, 9:59:21 PM
    Author     : ITSUKA KOTORI
--%>

<%@page import="java.util.Date"%>
<%@page import="_control.domain.*"%>
<%@page import="_control.GenerateID"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String report_type = request.getParameter("report_type");
    String url = "";
    int validate = 0;
    if(report_type != null){
        switch(report_type){
            case "booking":
                url="http://localhost:8080/GroupProject/_page/admin_console/report/booking_details/report_booking.jsp";
                validate = 1;
                break;
            case "customer":
                url = "http://localhost:8080/GroupProject/_page/admin_console/report/customer_montly/report_monthly.jsp";
                validate = 1;
                break;
            case "driver":
                url = "http://localhost:8080/GroupProject/_page/admin_console/report/total_fetch/report_fetch.jsp";
                validate = 1;
                break;
        }
    }
    Object[] driver;
    driver = new DriverDA().getRecords();
    String driver_list = "[";
    for(Object x: driver){
        Driver driver_s = (Driver)x;
        driver_list += ('\"' +driver_s.getDriver_id() +'-' +driver_s.getFull_Name()+ "\", ");
    }
    driver_list += "\" ~ \"]";
    if(validate == 1)
    {
        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - Report [delete]</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <script src="http://localhost:8080/GroupProject/_js/map-google.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-ui.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_js/Validatation_c.js"></script>
        <script>
            jQuery(document).ready(
                function(){
                    $("#header").load("http://localhost:8080/GroupProject/_sub_page/header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_sub_page/footer.html");
                }
            );
            jQuery(document).ready(
                function(){
                    choices_driver = <%= driver_list%>;
                    $("#driver_id").autocomplete({minChars:2,source:choices_driver});
                }
            );
        </script>
        <style>
            iframe{
                padding: 10px;
                width: 100%;
                height: 500px;
            }
            .btn-group-justified{
                margin-top: 5px;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <div id="header"></div>
        <div class="container">
            
            <div style="padding: 10px">
                <div class='row' style="padding: 5px">
                    <div class="col-sm-4">
                      <div class="form-group">
                        <label for="report_date">Booking details date :</label>
                        <input type="text" class="form-control" name="report_date" id="report_date" placeholder="Format dd-mm-yyyy">
                      </div>
                    </div>
                    <div class="col-sm-4">
                      <div class="form-group">
                        <label for="report_month">Customer report month :</label>
                        <input type="text" class="form-control" name="report_month" id="report_month" placeholder="Enter a month-year eg.12-2019">
                      </div>
                    </div>
                    <div class="col-sm-4">
                    </div>
                </div>
                <div class="btn-group btn-group-justified">
                    <a href="#" onclick="return loadIframe('frame', 'http://localhost:8080/GroupProject/_page/admin_console/report/booking_details/report_booking.jsp?report_date=' + $('#report_date').val())" class="btn btn-primary">Booking details report - diary report</a>
                    <a href="#" onclick="return loadIframe('frame', 'http://localhost:8080/GroupProject/_page/admin_console/report/customer_montly/report_monthly.jsp?report_month=' + $('#report_month').val())" class="btn btn-primary">Customer booking report - monthly report</a>
                    <a href="#" onclick="return loadIframe('frame', 'http://localhost:8080/GroupProject/_page/admin_console/report/total_fetch/report_fetch.jsp')" class="btn btn-primary">Driver rating report - summary report</a>
                </div>
            </div>
            <iframe name="frame" id="frame" src="<%= url%>">
                
            </iframe>
        </div>
        <div id="footer"></div>
    </body>
    <script>
        function loadIframe(iframeName, url) {
            var $iframe = $('#' + iframeName);
            if ( $iframe.length ) {
                $iframe.attr('src',url);   
                return false;
            }
            return true;
        }
    </script>
</html>