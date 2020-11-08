<%-- 
    Document   : delete_booking
    Created on : Dec 23, 2019, 5:10:44 PM
    Author     : taruc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<%
    String id = (String)request.getParameter("id");
    Object[] cust,driver;
    Booking booking;
    cust = new CustomerDA().getRecords();
    driver = new DriverDA().getRecords();
    booking = (Booking)new BookingDA().getRecord(id);
    String cust_list = "[";
    String driver_list = "[";
    String booking_list = "[";
    for(Object x: cust){
        Customer customer = (Customer)x;
        cust_list += ('\"' +customer.getCust_id() +'-' +customer.getFull_Name()+ "\", ");
    }
    cust_list += "\" ~ \"]";
    for(Object x: driver){
        Driver driver_s = (Driver)x;
        driver_list += ('\"' +driver_s.getDriver_id() +'-' +driver_s.getFull_Name()+ "\", ");
    }
    driver_list += "\" ~ \"]";
    for(int i = 0; i < 5;i++){
        BookingStatus booking_z = BookingStatus.getValue(String.format("B%d", i + 1));
        booking_list += ('\"' +booking_z.getCode() +'-' +booking_z.getName()+ "\", ");
    }
    booking_list += "\" ~ \"]";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - Booking [update]</title>
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
                    choices_cust = <%= cust_list%>;
                    choices_driver = <%= driver_list%>;
                    choices_booking = <%= booking_list%>;
                    $("#cust_id").autocomplete({minChars:2,source:choices_cust});
                    $("#driver_id").autocomplete({minChars:2,source:choices_driver});
                    $("#booking_status").autocomplete({minChars:2,source:choices_booking});
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
    </head>
    <body>
        <div id="header"></div>
        <br>
        <div class="container">
        <h1>Update booking</h1>
        <h4>Booking ID : <%= id%></h4>
        <form id="updateform" method="post" action="approve_update.jsp?booking_id=<%= id%>">
                <div class="form-group row">
                    <div class="col-sm-6">Booking ID</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="booking_id" value="<%= id%>" name="booking_id" disabled=""></div>
                </div>  
                <div class="form-group row">
                    <div class="col-sm-6">Customer ID:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="cust_id" value="<%= booking.getCustomer().getCust_id()%>" placeholder="Enter customer id" name="cust_id"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Driver ID:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="driver_id" value="<%= booking.getDriver().getDriver_id()%>" placeholder="Enter driver id" name="driver_id"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Booking Date:</div>
                    <div class="col-sm-6"><input type="datetime-local" class="form-control" id="booking_date" value="<%= formatter.format(booking.getBooking_date())%>" placeholder="Enter booking date" name="booking_date"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Fetch Date:</div>
                    <div class="col-sm-6"><input type="datetime-local" class="form-control" id="fetch_date" value="<%= formatter.format(booking.getFetch_date())%>" placeholder="Enter fetch date" name="fetch_date"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Booking Status:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="booking_status" value="<%= booking.getBooking_status().getCode()%>" placeholder="Enter booking status" name="booking_status"></div>
                </div>
                <div class="form-group row c_map_flip" id="flip_sl">
                    <div class="col-sm-6">Start Location:</div>
                    <div class="col-sm-6"><input type="text" class="form-control controls" id="start_location" value="<%= booking.getStart_location()%>" placeholder="Search a start location" name="start_location"></div>
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
                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw&libraries=places&callback=initMap_all"
                        async defer></script>
                <div class="form-group row c_map_flip" id="flip_el">
                    <div class="col-sm-6">End Location:</div>
                    <div class="col-sm-6"><input type="text" class="form-control controls" id="end_location" value="<%= booking.getEnd_location()%>" placeholder="Search a end location" name="end_location"></div>
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
                    <input type="submit" style="margin: 10px" value="Submit" class="btn btn-success pull-right">
                    <input type="reset" style="margin: 10px" value="Reset" class="btn btn-warning pull-right">
                </div>
            </form>
            <br>
            <script>
            $(document).ready(function () {
                $("#createform").validate({
                    rules: {
                        booking_id: {
                            required: true,
                            minlength: 16,
                            regex: regex_list.Validate.booking_id
                        },
                        cust_id: {
                            required: true,
                            minlength: 10,
                            regex: regex_list.Validate.cust_id
                        },
                        driver_id: {
                            required: true,
                            minlength: 7,
                            regex: regex_list.Validate.driver_id
                        },
                        booking_date: {
                            required: true
                        },
                        start_location: {
                            required: true
                        },
                        end_location: {
                            required: true
                        },
                        fetch_date: {
                            required: true
                        },
                        booking_status: {
                            required: true,
                            regex: regex_list.Validate.enum
                        },
                        payment_method_id: {
                            required: true,
                            regex: regex_list.Validate.id
                        }
                    },
                    messages: {
                        booking_id: {
                            required: "The booking id cannot be modify please take note",
                            minlength: "The lenght is not match to booking id format"
                        },
                        cust_id: {
                            required: "The customer is not yet define please define before continue",
                            minlength: "The custormer id is not matcher to our format please try agian"
                        },
                        driver_id: {
                            required: "The driver is not yet define please define before continue",
                            minlength: "The driver id is not matcher to our format please try agian"
                        },
                        booking_date: {
                            required: "Please fill in the booking date before procide to next"
                        },
                        start_location: {
                            required: "The start location is not define yet for this booking"
                        },
                        end_location: {
                            required: "The destination location is not fill in please ffill in to continue"
                        },
                        fetch_date: {
                            required: "Fetch date is the required field to know when driver go to fetch you."
                        }
                    },    
                    errorPlacement: function(label, element) {
                        label.addClass('text-danger');
                        label.insertAfter(element);
                    },
                    wrapper: 'span'
                });
            });
            </script>
        </div>
        <div id="footer"></div>
    </body>
</html>
