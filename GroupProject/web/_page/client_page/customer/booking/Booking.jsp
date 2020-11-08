<%-- 
    Document   : Booking
    Created on : Dec 30, 2019, 6:16:19 PM
    Author     : xps
--%>

<%@page import="_enum.ErrorDetails"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_servletAPI._session.*" %>
<%
    String id = request.getParameter("id");
    if(id == null){
        id = (String)request.getSession().getAttribute("Customer_username");
    }
    CustomerDA da = new CustomerDA();
    Customer domain = (Customer)da.getRecord(id);
    PaymentMethodDA da2 = new PaymentMethodDA();
    Object[] domain2 = da2.getRecords("user_id = \'" + domain.getCust_id() + "\'");
    String pm_list = "[";
    if(id == null){
        response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
        ErrorDetails.E017.getUrl() + "&url=" + "Customer Login send mail error"); 
    }
    else if(domain2.length == 0){
        response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/customer/payment/payment_Confirm.jsp?status=1");
    }
    for(Object x: domain2){
        PaymentMethod customer = (PaymentMethod)x;
        pm_list += ('\"' +customer.getPay_method_id() +'-' +customer.getPay_method().getName() + "\", ");
    }
    pm_list += "\" ~ \"]";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
    request.getSession().setAttribute("url", "http://localhost:8080/GroupProject/_page/client_page/customer/booking/Booking.jsp");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" type="text/css" href="Booking.css">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
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
                    choices_pm = <%= pm_list%>;
                    $("#pay_method_id").autocomplete({minChars:2,source:choices_pm});
                }
            );      
            $(document).ready(function(){
              $("#sl_close").click(function(){
                $("#panel_sl").slideToggle("normal");
              });
              $("#flip_sl").click(function(){
                $("#panel_sl").slideToggle("normal");
              });
              $("#flip_el").click(function(){
                $("#panel_el").slideToggle("normal");
              });
              $("#el_close").click(function(){
                $("#panel_el").slideToggle("normal");
              });
              $("#el_submit").click(function(){
                var id = $("#place-id_el").text();
                $("#end_location").val(id);
                $("#panel_el").slideToggle("normal");
              });
              $("#sl_submit").click(function(){
                var id = $("#place-id_sl").text();
                $("#start_location").val(id);
                $("#panel_sl").slideToggle("normal");
              });
              $("#pay_method_id").click(function(){
                $("#panel_pm").slideToggle("normal");
              });
            });
        </script>
        <style> 
            .map {
              height: 500px;
              width: 700px;
            }
            .c_map_panel {
              padding: 5px;
              text-align: center;
            }

            .c_map_panel{
                background-color: #f6f6f6;
                border: 1px solid #ccc!important;
            }

            .c_map_panel {
              padding: 10px;
              display: none;
              position: absolute;
              z-index: 2;
              transform: translate(-50%, -50%);
              left:50%;
              top:50%;
              border-radius: 5px;
            }
            .title {
              font-weight: bold;
            }
            .infowindow-content {
              display: none;
            }
            .map .infowindow-content {
              display: inline;
            }
            .pac-input{
                padding:10px!important;
                width: 410px!important;
                margin: 12px!important;
            }
        </style>
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
    <div class="container center-block small" style="width: 500px;min-height: 600px;">
        <h3 class="booking">Select Your Location</h3>
        <form class="booking" action="payment.jsp" method="post">
            <div class="form-group row">
                <div class="col-sm-6">Fetch Date:</div>
                <div class="col-sm-6"><input type="datetime-local" class="form-control" id="fetch_date" value="<%= formatter.format(new Date())%>" placeholder="Enter phone number format 6018-999-9999" name="fetch_date"></div>
            </div>
            <div class="form-group row">
                <div class="col-sm-6">Payment method:</div>
                <div class="col-sm-6"><input type="text" class="form-control" id="pay_method_id" value="" placeholder="Select a payment method" name="pay_method_id"></div>
            </div>
            <div class="form-group row c_map_flip" id="flip_sl">
                <div class="col-sm-6">Start Location:</div>
                <div class="col-sm-6"><input type="text" class="form-control controls" id="start_location" value="" placeholder="Search a start location" name="start_location"></div>
            </div>
            <div id="panel_sl" class="form-group row c_map_panel">
                <div style="display: none">
                    <input id="pac-input_sl" class="form-control controls pac-input" type="text" placeholder="Enter a location">
                </div>
                <div class="map" id="map_sl">
                </div>    
                <div id="infowindow-content_sl" class="infowindow-content">
                    <!--The id value change-->
                    <span id="place-name_sl" class="title"></span><br>
                    Place ID: <span id="place-id_sl"></span><br>
                    <span id="place-address_sl"></span>
                    <button type="button" class="btn btn-success" id='sl_submit'>Confirm</button>
                    <button type="button" class="btn btn-danger" id='sl_close'>Close</button>
                </div>
            </div>
            <div class="form-group row c_map_flip" id="flip_el">
                <div class="col-sm-6">End Location:</div>
                <div class="col-sm-6"><input type="text" class="form-control controls" id="end_location" value="" placeholder="Search a end location" name="end_location"></div>
            </div>
            <div id="panel_el" class="c_map_panel">
                <div style="display: none">
                    <input id="pac-input_el" class="form-control controls pac-input" type="text" placeholder="Enter a location">
                </div>
                <div class="map" id="map_el">
                </div>    
                <div id="infowindow-content_el" class="infowindow-content">
                    <!--The id value change-->
                    <span id="place-name_el" class="title"></span><br>
                    Place ID: <span id="place-id_el"></span><br>
                    <span id="place-address_el"></span>
                    <button type="button" class="btn btn-success" id='el_submit'>Confirm</button>
                    <button type="button" class="btn btn-danger" id='el_close'>Close</button>
                </div>
                    <script>
                      function initMap_all(){
                          initMap('_sl');
                          initMap('_el');
                      }
                    </script>
            </div>
            <div class="form-group row">
                <input type="submit" style="margin: 10px" value="Book now" class="btn btn-success pull-right">
                <input type="reset" style="margin: 10px" value="Reset" class="btn btn-warning pull-right">
            </div>
        </form>
    </div>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw&libraries=places&callback=initMap_all" async defer></script>
    <div id="footer"></div>
</body>
</html>
