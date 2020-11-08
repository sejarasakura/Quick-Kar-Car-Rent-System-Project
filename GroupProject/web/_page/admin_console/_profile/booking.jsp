<%-- 
    Document   : view_booking
    Created on : Dec 23, 2019, 5:12:26 PM
    Author     : taruc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - booking detials</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
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
            String id = (String)request.getParameter("id");
            BookingDA driver_da = new BookingDA();
            Booking cust = (Booking)driver_da.getRecord(id);
        %>
        <div id="header"></div>
        <div>

            <div class="jumbotron text-center">
              <h1>Booking details</h1>    
              <p>booking details record view only!!</p>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                        <h3>
                            <div class="row">
                            <div class="col-sm-6 text-right">Booking ID :</div>
                            <div class="col-sm-6 text-left"><%= cust.getBooking_id()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Rating ID :</div>
                            <div class="col-sm-6 text-left">
                                <a href="rating.jsp?id=<%= cust.getRating().getRating_id()%>">
                                    <%= cust.getRating().getRating_id()%>
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer :</div>
                            <div class="col-sm-6 text-left">
                                <a href="customer.jsp?id=<%= cust.getCustomer().getCust_id()%>">
                                    <%= cust.getCustomer().getCust_id()%>
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Driver ID :</div>
                            <div class="col-sm-6 text-left">
                                <a href="driver.jsp?id=<%= cust.getDriver().getDriver_id()%>">
                                    <%= cust.getDriver().getDriver_id()%>
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Payment ID :</div>
                            <div class="col-sm-6 text-left">
                                <a href="payment.jsp?id=<%= cust.getPayment().getPayment_id()%>">
                                    <%= cust.getPayment().getPayment_id()%>
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Booking Date :</div>
                            <div class="col-sm-6 text-left"><%= cust.getBooking_date()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Fetch Date :</div>
                            <div class="col-sm-6 text-left"><%= cust.getFetch_date()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Booking Status :</div>
                            <div class="col-sm-6 text-left"><%= cust.getBooking_status().getName()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Start Location Google MAP ID :</div>
                            <div class="col-sm-6 text-left">
                                <a href="https://maps.googleapis.com/maps/api/place/details/xml?place_id=<%= cust.getStart_location()%>&fields=geometry,address_component,name,rating,formatted_phone_number&key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw">
                                    <%= cust.getStart_location().substring(0, 20)%>.....
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">End Location Google MAP ID :</div>
                            <div class="col-sm-6 text-left">
                                <a href="https://maps.googleapis.com/maps/api/place/details/xml?place_id=<%= cust.getEnd_location()%>&fields=geometry,address_component,name,rating,formatted_phone_number&key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw">
                                    <%= cust.getEnd_location().substring(0, 20)%>.....
                                </a>
                            </div>
                        </div
                        <div class="row" style="padding-top: 10px;">
                            <div class="col-sm-6 text-right"></div>
                            <div class="col-sm-6 text-left">
                                <a href="#" onclick="window.history.back()" class="btn btn-default pull-right" style="margin: 10px">
                                    return back
                                </a>
                                <a href="http://localhost:8080/GroupProject/_page/admin_console/index.html" onclick="" class="btn btn-info pull-right" style="margin: 10px">
                                    Back to menu
                                </a>
                            </div>
                        </div>
                        </h3>
                    </div>
                    <div class="col-sm-1"></div>
                </div>
            </div>
            
        </div>
                        <div style="padding-bottom: 20px"></div>
        <div id="footer"></div>
    </body>
</html>
