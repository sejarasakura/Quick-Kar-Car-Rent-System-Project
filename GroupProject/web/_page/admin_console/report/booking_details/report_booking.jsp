<%-- 
    Document   : report_booking
    Created on : Dec 24, 2019, 4:36:51 PM
    Author     : xps
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="_control.domain.SQL_control"%>
<%@page import="_enum.ErrorDetails"%>
<%@page import="_control.domain.Report"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    SimpleDateFormat f1 = new SimpleDateFormat("dd");
    SimpleDateFormat f2 = new SimpleDateFormat("MM");
    SimpleDateFormat f3 = new SimpleDateFormat("yyyy");
    Date report_date = null;
    String report_date_s = null;
    String date = request.getParameter("report_date");  
    try {
        report_date = Report.PARAMETER_FORMAT.parse(date);
    }catch(Exception e){
        report_date = new Date();
    }
    report_date_s = Report.REPORT_HEADER_FORMAT_S.format(report_date);
%>
<%
    String query = SQL_control.read_sql("booking_report.sql");
    SQL_control control = new SQL_control();
    PreparedStatement ps = control.prepareStatement(query);
    ps.setInt(1, Integer.parseInt(f1.format(report_date)));
    ps.setInt(2, Integer.parseInt(f2.format(report_date)));
    ps.setInt(3, Integer.parseInt(f3.format(report_date)));
    ResultSet rs = ps.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body style="margin: 25px 15px;width:1080;margin:auto">
    <p style="margin: 20px">Page one of one<p>
<table style="border: 1px solid black;border-collapse: collapse;margin:auto;">
  
  <tr style="border: 0;" >
    <th style="width:100px;border: 0;"></th>
    <th style="width:180px;border: 0;"></th>
    <th style="width:100px;border: 0;"></th>
    <th style="width:100px;border: 0;"></th>
    <th style="width:100px;border: 0;"></th>
    <th style="width:100px;border: 0;"></th>
    <th style="width:100px;border: 0;"></th>
  </tr>
  <tr style="border: 0;">
    <td colspan=7 style="text-align: center;border: 0;">
        <b>Details report of static management department - Booking details report <%= report_date_s%></b>
    </td>
  </tr>
  <tr style="border-bottom: 1px solid #000;border-top: 1px solid #000;">
    <td colspan=3 style="text-align: left;border: 0;">
        <b><i>Report ID : R432380242</i></b>
    </td>
    <td colspan=4 style="border: 0; text-align: right">
        <p><i><%= Report.REPORT_HEADER_FORMAT.format(new Date())%> | Version 1.0</i></p>
    </td>
</tr>
  <tr style="border: 0;">
    <td colspan=7 style="text-align: center; margin: 10px;border: 0;">
        <h1 style="margin:10px; font-size: 30pt;"><b>QuicKar SND BHD</b></h1>
        <p><i><u>Booking details report <%= report_date_s%></u></i></p>
    </td>
</tr>
<tr class='foo' style="border-bottom: 1px solid #000;border-top: 1px solid #000;">
    <td style="width:13.636363%;border: 0;"><b>Booking ID</b></td> 
    <td style="width:18.181818%;border: 0;"><b>Customer Name</b></td>
    <td style="width:13.636363%;border: 0;"><b>Driver Name</b></td>
    <td style="width:13.636363%;border: 0;"><b>Car Plate Number</b></td>
    <td style="width:13.636363%;border: 0;"><b>Fetch Date</b></td>
    <td style="width:13.636363%;border: 0;"><b>Booking Status</b></td>
    <td style="width:13.636363%;border: 0;"><b>Payment Amount</b></td>
</tr>

<%= Report.new_line()%>
  <%
      while(rs.next()){
      String data_1 = rs.getString(1);
      String data_2 = rs.getString(2);
      String data_3 = rs.getString(3);
      String data_4 = rs.getString(4);
      Date data_5 = rs.getDate(5);
      String data_6 = rs.getString(6);
      String data_7 = rs.getString(7);
  %>
  <%= Report.report_row(data_1, data_2, data_3, data_4, Report.PARAMETER_FORMAT.format(data_5),data_6, data_7)%>
    <%= Report.new_line()%>
    <%}
        rs.close();
        ps.close();
    %>
</table>

</body>
</html>
