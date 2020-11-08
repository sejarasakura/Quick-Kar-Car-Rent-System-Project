
<%@page import="java.io.InputStream"%>
<%@page import="java.nio.file.Path"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="_control.GenerateID"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<%
    String id = request.getParameter("id");
    _da.CustomerDA da = new CustomerDA();
    _domain.Customer domain = new Customer();
    domain = (Customer)da.getRecord(id);
    _da.PaymentMethodDA da_m = new PaymentMethodDA();
    PaymentMethod payment;
    Object[] data = da_m.getRecords("user_id = '" + domain.getCust_id() + "'");
    if(data.length == 0){
        payment = null;
    }else{
        payment = (PaymentMethod)data[0];
    }
    request.getSession().setAttribute("cust_id", id);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - Booking [create]</title>
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
        <h1>Customer Update</h1>
        <br>
        <form id="createform" method="post" action="approve_update.jsp">
                <div class="form-group row">
                    <div class="col-sm-6">Customer ID:</div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="cust_id" value="<%= id%>" name="cust_id" disabled=""></div>
                </div>  
                <div class="form-group row">
                    <div class="col-sm-6">First Name:<input type="text" class="form-control" value="<%= domain.getFirst_name()%>" id="first_name" placeholder="Please enter the first name" name="first_name"></div>
                    <div class="col-sm-6">Last Name:<input type="text" class="form-control" value="<%= domain.getLast_name()%>" id="last_name" placeholder="Please enter the last name" name="last_name"></div>
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
                        <select class="form-control" id="payment_method" name="payment_method">
                            <option value="EW">EW-Ewallet</option>
                            <option value="CH">CH-Cash</option>
                            <option value="CD">CD-Credit / Debitcard</option>
                            <option value="MP">MP-Mobile Pay</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">Member level:</div>
                    <div class="col-sm-6">
                        <select class="form-control" id="member_level" name="member_level">
                            <option value="BR">BR-Bronze Member, Free</option>
                            <option value="SI">SI-Silver Member, RM 10 per month, 8% discount</option>
                            <option value="AU">AU-Gold Member, RM 50 per month, 20% discount</option>
                            <option value="PL">PL-Platinium Member, RM 100 per month, 50% discount</option>
                        </select>
                    </div>
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
                
                $(function() {
                    $("#member_level").val('<%= domain.getMembership_level().getDatabaseCode()%>');
                });
                $(function() {
                    <%if(payment != null){%>
                    $("#payment_method").val('<%= payment.getPay_method().getCode()%>');
                    <%}%>
                });
                $("#createform").validate({
                    rules: {
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
