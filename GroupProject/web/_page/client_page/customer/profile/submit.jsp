<%-- 
    Document   : submit
    Created on : Jan 5, 2020, 12:11:12 PM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_enum.ErrorDetails"%>
<%@page import="_enum.MembershipLevel"%>
<%@page import="_domain.Customer"%>
<%@page import="_da.CustomerDA"%>
<%@page import="_servletAPI._session.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    String id = null;
    try{
        id = new_c.getUsername();
    }catch(Exception ex){
    }
    String url = "http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html";
    _da.CustomerDA da = new CustomerDA();
    _domain.Customer domain = new Customer();
    domain = (Customer)da.getRecord(id);
    String first_name = request.getParameter("first_name");
    String last_name = request.getParameter("last_name");
    String member_level = request.getParameter("member_level");
    String phone_num = request.getParameter("phone_num");
    domain.setFirst_name(first_name);
    domain.setLast_name(last_name);
    domain.setMembership_level(MembershipLevel.getValue(member_level));
    domain.setPhone_num(phone_num);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Uploading Data</title>
    </head>
    <body>
        <script>
            $(document).ready(function () {

                $.confirm({
                   title: 'Update?',
                    content: 'Do you want to make changes, auto make changes in 10 Seconds',
                    type: 'blue',
                    autoClose: 'update|10000',
                    buttons: {
                        update: {
                            text: 'Update',
                            action: function () {
                                <%
                                    request.getSession().setAttribute("Cusrrent_customer_update_data", domain);
                                %>
                                window.location.replace('http://localhost:8080/GroupProject/Customer_update_cilent');                           
                            }
                        },
                        cancel: function () {
                            $.alert('your update had been canceled');
                                window.location.replace('http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html');    
                        }
                    }
                });
            
            });
        </script>
    </body>
</html>
