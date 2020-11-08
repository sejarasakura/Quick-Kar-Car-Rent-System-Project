<%-- 
    Document   : newjsp
    Created on : Dec 23, 2019, 5:03:17 PM
    Author     : taruc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<%
    String id = request.getParameter("id");
    _da.DriverDA da = new _da.DriverDA();
    Driver domain = (Driver)da.getRecord(id);
    request.getSession().setAttribute("domain", domain);
    Object[] payment_list = new _da.PaymentMethodDA().getRecords("user_id ='" +domain.getDriver_id()+ "'");
    PaymentMethod p;
    if(payment_list.length >= 1)
        p = (PaymentMethod)payment_list[0];
    else
        p = new PaymentMethod();
    
    request.getSession().setAttribute("driver_id", domain.getDriver_id());
    request.getSession().setAttribute("payment_method", p);
%>
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
        <h1>Driver update</h1>
        <br>
        <form id="createform" method="post" action="update_response.jsp">
                <div class="form-group row">
                    <div class="col-sm-6">Driver ID:</div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="driver_id" value="<%= domain.getDriver_id()%>" name="driver_id" disabled=""></div>
                </div>  
                <div class="form-group row">
                    <div class="col-sm-6">First Name:<input type="text" value="<%= domain.getFirst_name()%>" class="form-control" id="first_name" placeholder="Please enter the first name" name="first_name"></div>
                    <div class="col-sm-6">Last Name:<input type="text" value="<%= domain.getLast_name()%>" class="form-control" id="last_name" placeholder="Please enter the last name" name="last_name"></div>
                </div>  
                <div class="form-group row">
                    <div class="col-sm-6">Password: </div>
                    <div class="col-sm-6"><a href="http://localhost:8080/GroupProject/_page/client_page/all_user/forgot_password/ForgotPsd.html">Forgot password click here to change ... </a></div>
                </div>  
                <div class="form-group row">
                    <div class="col-sm-6">Phone number:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="phone_num" value="<%= domain.getPhone_num()%>" placeholder="Enter phone number format 6018-999-9999" name="phone_num"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">IC number:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="ic_num" value="<%= domain.getIc_num()%>" placeholder="Enter ic number" name="ic_num"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Payment Method:</div>
                    <div class="col-sm-6">
                        <select class="form-control" id="payment_method" name="payment_method" value="<%= p.getPay_method() == null ? "" :p.getPay_method().getCode() + "-" +  p.getPay_method().getName()%>">
                            <option>EW-Ewallet</option>
                            <option>CH-Cash</option>
                            <option>CD-Credit / Debitcard</option>
                            <option>MP-Mobile Pay</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">License:</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="license" value="<%= domain.getLicense()%>" placeholder="Enter License munber format [99999999]" name="license"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Year of drive:</div>
                    <div class="col-sm-6"><input type="number" class="form-control" id="year_of_drive" value="<%= domain.getYear_of_drive()%>" placeholder="Year of drive" name="year_of_drive"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Card number(requited * for credit/debit card):</div>
                    <div class="col-sm-6"><input type="text" class="form-control" id="card_num" value="<%= p.getCard_num() == null ? "" : p.getCard_num()%>" placeholder="Enter card number format 9999-9999-9999-9999" name="card_num"></div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6"></div>
                    <div class="col-sm-6">
                        <input type="reset" class="btn btn-warning pull-right" value="Reset" style="margin: 10px">
                        <input type="submit" class="btn btn-success pull-right" value="Update" style="margin: 10px">
                    </div>
                </div>
            </form>
            <br>
            <script>
            $(document).ready(function () {
                $("#createform").validate({
                    rules: {
                        license: {
                            required: true,
                            regex: regex_list.Validate.license
                        },
                        first_name: {
                            required: true,
                            regex: regex_list.Validate.name
                        },
                        last_name: {
                            required: true,
                            regex: regex_list.Validate.name
                        },
                        phone_num: {
                            required: true,
                            regex: regex_list.Validate.phone_num
                        },
                        ic_num: {
                            required: true,
                            regex: regex_list.Validate.ic_num
                        },
                        card_num: {
                            regex: regex_list.Validate.card_num
                        },
                        password: {
                            required: true,
                            minlength: 8,
                            regex: regex_list.Validate.password
                        },
                        confirm_password: {
                            required: true,
                            minlength: 8,
                            equalTo: "#password",
                            regex: regex_list.Validate.password
                        },
                        payment_method: {
                            required: true,
                            regex: regex_list.Validate.enum
                        }
                    },
                    message:{
                        confirm_password: {
                            equalTo: "The password enter is not match, please tray agian"
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
