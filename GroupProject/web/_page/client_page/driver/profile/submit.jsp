<%-- 
    Document   : submit
    Created on : Jan 5, 2020, 12:11:12 PM
    Author     : ITSUKA KOTORI
--%>

<%@page import="_enum.ErrorDetails"%>
<%@page import="_da.DriverDA"%>
<%@page import="_domain.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Driver domain = (Driver)request.getSession().getAttribute("driver_update_profile_stdio");
    String first_name = request.getParameter("first_name");
    String phone_num = request.getParameter("phone_num");
    String last_name = request.getParameter("last_name");
    domain.setFirst_name(first_name);
    domain.setLast_name(last_name);
    domain.setPhone_num(phone_num);
    DriverDA driver = new DriverDA();
    boolean data = driver.updateRecord(domain, domain.getDriver_id());
    if(data)
        response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/driver/profile/driverProfile.jsp");
    else
        response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?"
                + ErrorDetails.E007.getUrl() + "&url=updateCustomer");      
    
%>