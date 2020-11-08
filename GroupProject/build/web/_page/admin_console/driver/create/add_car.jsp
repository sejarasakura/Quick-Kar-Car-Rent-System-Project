<%-- 
    Document   : add_car
    Created on : Jan 2, 2020, 2:01:05 PM
    Author     : ITSUKA KOTORI
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
        <title>Admin console - Driver [add]</title>
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
        </script>
    </head>
    <body>
        <div id="header"></div>
        <br>
        <div class="container">
        <h1>Driver registration</h1>
        <br>
            <form id="createform" method="post" action="/GroupProject/admin_addCarType">
                <div class="form-group row">
                    <div class="col-sm-6">Car plate number:</div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="car_plate_number" value="" name="car_plate_number" placeholder="eg WMD#9999"></div>
                </div>  
            <%
                String id = request.getParameter("id");
                Driver driver = (Driver)new _da.DriverDA().getRecord(id);
                Object[] car_type;
                car_type = new _da.CarTypeDA().getRecords();
                String car_list = "[";
                for(Object x: car_type){
                    CarType car = (CarType)x;
                    car_list += ('\"' + car.getCar_type_id() + '-' + car.getCar_type_name() + "\", ");
                }
                car_list += "\" ~ \"]";
                request.getSession().setAttribute("driver", driver);
            %>
            <script> 
                $(document).ready(
                    function(){
                        choices_car = <%= car_list%>;
                        $("#car_type").autocomplete({minChars:2,source:choices_car});
                    }
                );
            </script>
                <div class="form-group row">
                    <div class="col-sm-6">Car type:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="car_type" value="" placeholder="Select a car type" name="car_type"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Owner Name:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="owner_name" value="<%= driver.getFull_Name()%>" placeholder="Enter owner name" name="owner_name" disabled=""></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">QuicKar Type:</div>
                    <div class="col-sm-6">
                        <select class="form-control" id="quickar_type" name="quickar_type">
                            <option value="JQ">Just Quick (4-seat)</option>
                            <option value="PQ">Premium Quick (4-seat)</option>
                            <option value="SS">QuicKar (6-seat)</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6"></div>
                    <div class="col-sm-6">
                        <input type="reset" class="btn btn-warning pull-right" value="Reset" style="margin: 10px">
                        <input type="submit" class="btn btn-success pull-right" value="Register" style="margin: 10px">
                    </div>
                </div>
            <br>
            </form>
            <script>
            $(document).ready(function () {
                $("#createform").validate({
                    rules: {
                    },
                    message:{
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
