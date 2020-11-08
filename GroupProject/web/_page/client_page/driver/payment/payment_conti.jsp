<%-- 
    Document   : payment_conti
    Created on : Jan 5, 2020, 9:50:24 AM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_da.PaymentMethodDA"%>
<%@page import="_domain.PaymentMethod"%>
<%@page import="_enum.PaymentMethodType"%>
<%@page import="_domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PaymentMethod payment= new PaymentMethod();
    String pay_method = (String)request.getSession().getAttribute("pay_method");
    String user_id = (String)request.getSession().getAttribute("driver_id");
    String card_num = request.getParameter("card_num");
    String car_holder = request.getParameter("car_holder");
    String expiry_date = request.getParameter("expiry_date");
    String statuc = "error"; 
    switch(pay_method){
        case "ewallate":
        case "card":
            String cvv = request.getParameter("cvv");
            String paymethod_id = _control.GenerateID.generate_PayMethod_s(pay_method.equals("card")?PaymentMethodType.CARD.getCode():PaymentMethodType.EWALLET.getCode(), user_id);
            payment.setPay_method_id(paymethod_id);
            payment.setCard_num(card_num);
            payment.setPay_method(pay_method.equals("card")?PaymentMethodType.CARD:PaymentMethodType.EWALLET);
            payment.setUser(user_id);
            request.getSession().setAttribute("payment_method", payment);
            statuc = "ok"; 
            break;
        case "cash":
            String paymethod_id_2 = _control.GenerateID.generate_PayMethod_s(PaymentMethodType.CASH.getCode(), user_id);    
            payment.setPay_method_id(paymethod_id_2);
            payment.setPay_method(PaymentMethodType.CASH);
            payment.setUser(user_id);        
            request.getSession().setAttribute("payment_method", payment);
            statuc = "ok"; 
            break; 
    }
%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="payment.css">
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
                    $("#header").load("http://localhost:8080/GroupProject/_page/client_base/c_header.jsp");
                    $("#footer").load("http://localhost:8080/GroupProject/_page/client_base/c_footer.html");
                }
            );
        </script>
    <title>Payment</title>
    </head>
    <body>
        <%if(statuc.equals("ok")){%>
        <script>
            $.confirm({
                title: '<%= user_id%>, You had added mew payment method !!!',
                content: 'Your payment method is added a new paymetn with using <%=pay_method%> mehtod please enjoy our services',
                type: 'green',
                autoClose: 'Confrim|5000',
                typeAnimated: true,
                buttons: {
                    Confrim: function () {
                        <%
                            String url = (String)request.getSession().getAttribute("url");
                            if(url == null)
                                url ="http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html";
                            PaymentMethodDA da = new PaymentMethodDA();
                            da.addRecord(payment);
                            request.getSession().removeAttribute("url");
                            response.sendRedirect(url);
                        %>
                    }
                }
            });
        </script>
        <%}else{%>
            <script>
                $.confirm({
                    title: 'Had error found !!!',
                    content: 'Your payment method is not sucessful added please contact us to know more, please add a payment method to try agian',
                    type: 'red',
                    autoClose: 'close|5000',
                    typeAnimated: true,
                    buttons: {
                        close: function () {
                            <%response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/driver/payment/payment_Confirm.jsp");%>
                        }
                    }
                });
            </script>
        <%}%>
    </body>
</html>
