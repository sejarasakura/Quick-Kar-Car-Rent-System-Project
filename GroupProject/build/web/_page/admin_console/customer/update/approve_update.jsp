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
        <title>Admin console - customer detials</title>
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
            String cust_id = (String)request.getSession().getAttribute("cust_id");
            String member_level = request.getParameter("member_level").split("-")[0];
            String first_name = (String)request.getParameter("first_name");
            String last_name = (String)request.getParameter("last_name");
            String phone_num = (String)request.getParameter("phone_num");
            String ic_num = (String)request.getParameter("ic_num");
            Customer cust = new Customer();
            try{
                CustomerDA driver_da = new CustomerDA();
                cust = (Customer)driver_da.getRecord(cust_id);
                cust.setCust_id(cust_id);
                cust.setFirst_name(first_name);
                cust.setLast_name(last_name);
                cust.setMembership_level(MembershipLevel.getValue(member_level));
                cust.setPhone_num(phone_num);
                cust.setIc_num(ic_num);
                request.getSession().setAttribute("customer_data_update", cust);
            }catch(Exception ex){
                response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + ErrorDetails.E007.getUrl() + "&url=Add_customer_res2");   
            }
        %>
        <div id="header"></div>
        <div>

            <div class="jumbotron text-center">
              <h1>Customer Update ?</h1>    
              <p>Confirm your customer update</p>
            </div>

            <div class="container">
                
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                        <h3>
                            <div class="row" style="margin: auto;">
                                <div class="img-250-con center-block" style="margin-bottom: 20px">
                                    <img class="proc_pic-large img-circle img-full img-p-10" src="http://localhost:8080/GroupProject/DisplayImage?id=<%= cust.getCust_id()%>">
                                </div>
                            </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer ID :</div>
                            <div class="col-sm-6 text-left"><%= cust.getCust_id()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer Name :</div>
                            <div class="col-sm-6 text-left"><%= cust.getFull_Name()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer Phone Number :</div>
                            <div class="col-sm-6 text-left"><%= cust.getPhone_num()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer IC Number :</div>
                            <div class="col-sm-6 text-left"><%= cust.getIc_num()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer Point Amount :</div>
                            <div class="col-sm-6 text-left"><%= cust.getPoint_amount()%></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-right">Customer Membership Level :</div>
                            <div class="col-sm-6 text-left"><%= cust.getMembership_level().getName()%></div>
                        </div>
                        </h3>
                        
                        <div class="row" style="padding-top: 10px;">
                            <div class="col-sm-6 text-right"></div>
                            <div class="col-sm-6 text-left row">
                                <form method="post" action="/GroupProject/updateCustomer_admin">
                                    <style>.padding-15{margin: 15px;}</style>
                                    <input type="submit" value="Confrim.." class="btn btn-success pull-right padding-15">
                                    <a href="update_customer.jsp" class="btn btn-danger pull-right padding-15">
                                        Cancel..
                                    </a>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-1"></div>
                </div>
            </div>   
        </div>
        <div style="padding-bottom: 20px"></div>
        <div id="footer"></div>
    </body>
</html>
