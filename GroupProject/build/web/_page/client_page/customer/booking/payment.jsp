<%-- 
    Document   : payment
    Created on : Jan 5, 2020, 11:07:17 AM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_domain.Customer"%>
<%@page import="_domain.Booking"%>
<%@page import="_enum.ErrorDetails"%>
<%@page import="_da.PaymentDA"%>
<%@page import="_da.RatingDA"%>
<%@page import="_da.BookingDA"%>
<%@page import="_enum.PaymentStatus"%>
<%@page import="_domain.Car"%>
<%@page import="_da.CarDA"%>
<%@page import="_manipulation.MapManipulation"%>
<%@page import="_domain.DistanceMatricRespond"%>
<%@page import="_da.PaymentMethodDA"%>
<%@page import="_domain.PaymentMethod"%>
<%@page import="_domain.PaymentMethod"%>
<%@page import="_domain.Payment"%>
<%@page import="_enum.RatingStar"%>
<%@page import="_domain.Rating"%>
<%@page import="_enum.BookingStatus"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="_domain.Driver"%>
<%@page import="_servletAPI._session.CustomerSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
    Object[] drivers = new _da.DriverDA().getRecords();        
    int max = drivers.length - 1; 
    int min = 0; 
    int range = max - min + 1; 
    int random_driver = (int)(Math.random() * range) + min;
    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    String pay_method_id = request.getParameter("pay_method_id").split("-")[0];
    String booking_id = _control.GenerateID.generate_Booking();
    String rating_id = _control.GenerateID.generate_Rating();
    String cust_id = new_c.getUsername();
    String driver_id = ((Driver)drivers[random_driver]).getDriver_id();
    String driver_name = ((Driver)drivers[random_driver]).getFull_Name();
    String payment_id = _control.GenerateID.generate_Payment(pay_method_id);
    Date fetch_date = formatter.parse((String)request.getParameter("fetch_date"));
    BookingStatus booking_status = BookingStatus.PADDING_PAYMENT;
    String start_location = request.getParameter("start_location");
    String end_location = request.getParameter("end_location");
    Rating rating = new Rating(rating_id, RatingStar.ZERO_STAR, "", new Date());
    PaymentMethod payment_mothod = (PaymentMethod)new PaymentMethodDA().getRecord(pay_method_id);
    Payment payment = new Payment(payment_id, payment_mothod, PaymentStatus.NOT_YET_PAID ,new Date(), 0.00);
    DistanceMatricRespond distance = MapManipulation.getResponse(start_location, end_location);
    CarDA carda = new CarDA();
    Object[] car = carda.getRecords("driver_id = '" + driver_id + "'");
    Car real_car = (Car)car[0];
    double price1 = real_car.getQuickar_type().getPrice_per_km() * distance.getDistance_value() / 1000;
    double price2 = real_car.getQuickar_type().getPrice_per_min() * distance.getDuration_value() / 60;
    double price = (price1 + price2)/2;
    price += real_car.getQuickar_type().getBase_fair_price();
    if(price < real_car.getQuickar_type().getMinimum_price())
        price = real_car.getQuickar_type().getMinimum_price();
    payment.setPayment_amount(price);
    BookingDA da = new BookingDA();
    RatingDA da_1 = new RatingDA();
    PaymentDA da_2 = new PaymentDA();
    ErrorDetails error = ErrorDetails.E000;
    if(!da_2.addRecord(payment)){
        error = ErrorDetails.E009;
    }
    if(!da_1.addRecord(rating)){
        error = ErrorDetails.E009;
    }
    Booking booking = new Booking(booking_id, rating, new Customer(cust_id), new Driver(driver_id), payment, new Date(), fetch_date, booking_status, start_location, end_location);
    if(!da.addRecord(booking)){
        error = ErrorDetails.E009;
    }
    request.getSession().setAttribute("current_payment_object", payment);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="payment.css">
        <link rel="icon" href="http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-ui.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css">
        <link rel="stylesheet" href="http://localhost:8080/GroupProject/_css/main_style.css">
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
        <div id="header"></div>
        
        <div class="container" style="padding-top: 100px;padding-bottom: 100px">
            <h1>Searching driver for you</h1>
            <h2 id="demo"></h2>
        </div>
        <%if(payment.getPayment_method().getPay_method().getCode() != "CH"){%>
        <script>
            $.confirm({
                title: '',
                content: 'Do you want to pay not! with <%=payment.getPayment_method().getPay_method().getName()%>',
                type: 'green',
                typeAnimated: true,
                buttons: {
                    tryAgain: {
                        text: 'Pay now',
                        btnClass: 'btn-green',
                        action: function(){
                            window.location.replace("http://localhost:8080/GroupProject/doing_payment_cust_now");
                        }
                    },
                    close: {
                        text: 'Finish',
                        btnClass: 'btn-red',
                        action:function () {
                            window.location.replace("http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html");
                        }
                    }
                }
            });
        </script>
        <%}%>
<script>
// Set the date we're counting down to
var list_s = [
  "System findind driver for you ..........",
  "Get the nearest driver to you ..........",
  "Just amoment ...........................",
  "<%= ((Driver)drivers[(int)(Math.random() * range) + min]).getFull_Name()%> rejected you ....", 
  "<%= ((Driver)drivers[(int)(Math.random() * range) + min]).getFull_Name()%> rejected you ....", 
  "<%= ((Driver)drivers[(int)(Math.random() * range) + min]).getFull_Name()%> rejected you ....", 
  "<%= ((Driver)drivers[(int)(Math.random() * range) + min]).getFull_Name()%> rejected you ...."
];
var i = 0;

// Update the count down every 1 second
var x = setInterval(function() {
  	document.getElementById("demo").innerHTML = list_s[i] 
  	i ++;
  // If the count down is over, write some text 
  if (i === 6) {
    clearInterval(x);                        
    document.getElementById("demo").innerHTML = "<%= driver_name%> accepted your halling ....";
  }
}, 1000);
</script>

        <div id="footer"></div>
    </body>
</html>
