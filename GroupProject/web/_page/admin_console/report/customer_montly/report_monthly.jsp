<%-- 
    Document   : report_booking
    Created on : Dec 24, 2019, 4:36:51 PM
    Author     : xps
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="_control.domain.SQL_control"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="_enum.ErrorDetails"%>
<%@page import="_control.domain.Report"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SimpleDateFormat month = new SimpleDateFormat("MMMMM yyyy");
    SimpleDateFormat year_s = new SimpleDateFormat("yyyy");
    SimpleDateFormat month_s = new SimpleDateFormat("MM");
    SimpleDateFormat my = new SimpleDateFormat("MM-yyyy");
    Date report_date = null;
    String report_date_s = null;
    String date = request.getParameter("report_month");  
    int __month = 0;
    int __year = 0;
    try {
        report_date = my.parse(date);
    }catch(Exception e){
        report_date = new Date();
    }
    __month = Integer.valueOf(month_s.format(report_date));
    __year = Integer.valueOf(year_s.format(report_date));
    report_date_s = Report.REPORT_HEADER_FORMAT_S.format(report_date);
%>

<%
    String query = SQL_control.read_sql("customer_monthly_report.sql");
    SQL_control control = new SQL_control();
    PreparedStatement ps = control.prepareStatement(query);
    ps.setInt(1, __month);
    ps.setInt(2, __year);
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
        <b>Monthly report of static management department - Customer booking report <%= month.format(report_date)%></b>
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
        <p><i><u>Customer monthly report <%= report_date_s%></u></i></p>
    </td>
  </tr>
  <tr class='foo' style="border-bottom: 1px solid #000;border-top: 1px solid #000;">
    <td style="width:13.636363%;border: 0;"><b></b></td>
    <td style="width:18.181818%;border: 0;"><b>Customer Name</b></td>
    <td style="width:18.181818%;border: 0;"><b>Customer ID</b></td>
    <td style="width:13.636363%;border: 0;"><b>Total booking time</b></td> 
    <td style="width:13.636363%;border: 0;"><b>Average payment amount</b></td>
    <td style="width:13.636363%;border: 0;"><b>Sum of payment</b></td>
    <td style="width:13.636363%;border: 0;"><b></b></td>
  </tr>
  
<%= Report.new_line()%>
  <%
      while(rs.next()){
      String data_1 = rs.getString(2);
      String data_2 = rs.getString(1);
      String data_3 = rs.getString(3);
      String data_4 = rs.getString(4);
      String data_5 = rs.getString(5);
  %>
    <%= Report.report_row("", data_1, data_2, data_3, data_4, data_5, "")%>
    <%= Report.new_line()%>
    <%}
        rs.close();
        ps.close();
    %>
</table>

</body>
</html>
