<%-- 
    Document   : view_booking
    Created on : Dec 23, 2019, 5:12:26 PM
    Author     : taruc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="_da.*,_domain.*,_enum.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin console - driveromer detials</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <script src="http://localhost:8080/GroupProject/_jquery/jquery.min.js"></script>
        <script src="http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/image.css">
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
            String driver_id = (String)request.getSession().getAttribute("driver_id");
            PaymentMethod payment_method_class = (PaymentMethod)request.getSession().getAttribute("payment_method");
            String first_name = (String)request.getParameter("first_name");
            String last_name = (String)request.getParameter("last_name");
            String phone_num = (String)request.getParameter("phone_num");
            String ic_num = (String)request.getParameter("ic_num");
            String payment_method = (String)request.getParameter("payment_method").split("-")[0];
            String license = (String)request.getParameter("license");
            String year_of_drive = (String)request.getParameter("year_of_drive");
            String card_num = (String)request.getParameter("card_num");
            Driver driver = new Driver();
            PaymentMethod payment_m = new PaymentMethod();
            try{
                DriverDA driver_da = new DriverDA();
                PaymentMethodDA payment_da = new PaymentMethodDA();
                driver = (Driver)driver_da.getRecord(driver_id);
                if(payment_method_class.isNotNull()){
                    payment_m = (PaymentMethod)payment_da.getRecords("user_id='" +driver_id+ "'")[0];
                    payment_m.setCard_num(card_num);
                    payment_m.setPay_method(PaymentMethodType.getValue(payment_method));
                    payment_da.updateRecord(payment_m, payment_m.getPay_method_id());
                }else{
                    payment_m = new PaymentMethod(_control.GenerateID.generate_PayMethod_s(PaymentMethodType.getValue(payment_method).getCode(), driver_id), 
                            PaymentMethodType.getValue(payment_method), card_num, driver_id);
                    payment_da.addRecord(payment_m);
                }
                driver.setDriver_id(driver_id);
                driver.setFirst_name(first_name);
                driver.setLast_name(last_name);
                driver.setLicense(license);
                driver.setPhone_num(phone_num);
                driver.setIc_num(ic_num);
                driver.setYear_of_drive(Integer.parseInt(year_of_drive));
                driver_da.updateRecord(driver, driver_id);
            }catch(Exception ex){
                response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + ErrorDetails.E007.getUrl() + "&url=Add_customer_res2");   
            }
        %>
        <div id="header"></div>
        <div>

            <div class="jumbotron text-center">
              <h1>Record is updated</h1>    
              <p>The record is updated to the database</p>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                        <h3>
                            <div class="row" style="margin: auto;">
                                <div class="img-250-con center-block" style="margin-bottom: 20px">
                                    <img class="proc_pic-large img-circle img-full img-p-10" src="http://localhost:8080/GroupProject/DisplayImage?id=<%= driver.getDriver_id()%>">
                                </div>
                            </div>
                            <div class="row">
                            <div class="col-sm-6 text-right">Driver ID :</div>
                            <div class="col-sm-6 text-left"><%= driver.getDriver_id()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Driver Name :</div>
                            <div class="col-sm-6 text-left"><%= driver.getFull_Name()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Driver Phone Number :</div>
                            <div class="col-sm-6 text-left"><%= driver.getPhone_num()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Driver IC Number :</div>
                            <div class="col-sm-6 text-left"><%= driver.getIc_num()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Driver Year of Drive :</div>
                            <div class="col-sm-6 text-left"><%= driver.getYear_of_drive()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Driver License :</div>
                            <div class="col-sm-6 text-left"><%= driver.getLicense()%></div>
                        </div>
                            
                        <div class="row" style="padding-top: 10px;">
                            <div class="col-sm-6 text-right"></div>
                            <div class="col-sm-6 text-left row">
                                <a href="update_driver.jsp" class="btn btn-warning pull-right padding-15">
                                    Update other driver..
                                </a>
                                <a href="http://localhost:8080/GroupProject/_page/admin_console/index.html" class="btn btn-info pull-right padding-15">
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
