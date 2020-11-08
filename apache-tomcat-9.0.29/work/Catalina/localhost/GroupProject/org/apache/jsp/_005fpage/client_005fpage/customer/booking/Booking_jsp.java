/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-05 22:27:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005fpage.client_005fpage.customer.booking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _enum.ErrorDetails;
import java.util.Date;
import java.text.SimpleDateFormat;
import _da.*;
import _domain.*;
import _servletAPI._session.*;

public final class Booking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("_domain");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("_servletAPI._session");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("_da");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("_enum.ErrorDetails");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String id = request.getParameter("id");
    if(id == null){
        id = (String)request.getSession().getAttribute("Customer_username");
    }
    CustomerDA da = new CustomerDA();
    Customer domain = (Customer)da.getRecord(id);
    PaymentMethodDA da2 = new PaymentMethodDA();
    Object[] domain2 = da2.getRecords("user_id = \'" + domain.getCust_id() + "\'");
    String pm_list = "[";
    if(id == null){
        response.sendRedirect("http://localhost:8080/GroupProject/_page/error/error_page_design.jsp?" + 
        ErrorDetails.E017.getUrl() + "&url=" + "Customer Login send mail error"); 
    }
    else if(domain2.length == 0){
        response.sendRedirect("http://localhost:8080/GroupProject/_page/client_page/customer/payment/payment_Confirm.jsp?status=1");
    }
    for(Object x: domain2){
        PaymentMethod customer = (PaymentMethod)x;
        pm_list += ('\"' +customer.getPay_method_id() +'-' +customer.getPay_method().getName() + "\", ");
    }
    pm_list += "\" ~ \"]";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
    request.getSession().setAttribute("url", "http://localhost:8080/GroupProject/_page/client_page/customer/booking/Booking.jsp");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Booking</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"Booking.css\">\n");
      out.write("        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css\">\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_js/map-google.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_js/Validatation_c.js\"></script>\n");
      out.write("        <script>\n");
      out.write("      \n");
      out.write("            jQuery(document).ready(\n");
      out.write("                function(){\n");
      out.write("                    choices_pm = ");
      out.print( pm_list);
      out.write(";\n");
      out.write("                    $(\"#pay_method_id\").autocomplete({minChars:2,source:choices_pm});\n");
      out.write("                }\n");
      out.write("            );      \n");
      out.write("            $(document).ready(function(){\n");
      out.write("              $(\"#sl_close\").click(function(){\n");
      out.write("                $(\"#panel_sl\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("              $(\"#flip_sl\").click(function(){\n");
      out.write("                $(\"#panel_sl\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("              $(\"#flip_el\").click(function(){\n");
      out.write("                $(\"#panel_el\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("              $(\"#el_close\").click(function(){\n");
      out.write("                $(\"#panel_el\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("              $(\"#el_submit\").click(function(){\n");
      out.write("                var id = $(\"#place-id_el\").text();\n");
      out.write("                $(\"#end_location\").val(id);\n");
      out.write("                $(\"#panel_el\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("              $(\"#sl_submit\").click(function(){\n");
      out.write("                var id = $(\"#place-id_sl\").text();\n");
      out.write("                $(\"#start_location\").val(id);\n");
      out.write("                $(\"#panel_sl\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("              $(\"#pay_method_id\").click(function(){\n");
      out.write("                $(\"#panel_pm\").slideToggle(\"normal\");\n");
      out.write("              });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <style> \n");
      out.write("            .map {\n");
      out.write("              height: 500px;\n");
      out.write("              width: 700px;\n");
      out.write("            }\n");
      out.write("            .c_map_panel {\n");
      out.write("              padding: 5px;\n");
      out.write("              text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .c_map_panel{\n");
      out.write("                background-color: #f6f6f6;\n");
      out.write("                border: 1px solid #ccc!important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .c_map_panel {\n");
      out.write("              padding: 10px;\n");
      out.write("              display: none;\n");
      out.write("              position: absolute;\n");
      out.write("              z-index: 2;\n");
      out.write("              transform: translate(-50%, -50%);\n");
      out.write("              left:50%;\n");
      out.write("              top:50%;\n");
      out.write("              border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            .title {\n");
      out.write("              font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .infowindow-content {\n");
      out.write("              display: none;\n");
      out.write("            }\n");
      out.write("            .map .infowindow-content {\n");
      out.write("              display: inline;\n");
      out.write("            }\n");
      out.write("            .pac-input{\n");
      out.write("                padding:10px!important;\n");
      out.write("                width: 410px!important;\n");
      out.write("                margin: 12px!important;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("                jQuery(document).ready(\n");
      out.write("                    function(){\n");
      out.write("                        $(\"#header\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_header.jsp\");\n");
      out.write("                        $(\"#footer\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_footer.html\");\n");
      out.write("                    }\n");
      out.write("                );\n");
      out.write("            </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div id=\"header\"></div>\n");
      out.write("    <div class=\"container center-block small\" style=\"width: 500px;min-height: 600px;\">\n");
      out.write("        <h3 class=\"booking\">Select Your Location</h3>\n");
      out.write("        <form class=\"booking\" action=\"payment.jsp\" method=\"post\">\n");
      out.write("            <div class=\"form-group row\">\n");
      out.write("                <div class=\"col-sm-6\">Fetch Date:</div>\n");
      out.write("                <div class=\"col-sm-6\"><input type=\"datetime-local\" class=\"form-control\" id=\"fetch_date\" value=\"");
      out.print( formatter.format(new Date()));
      out.write("\" placeholder=\"Enter phone number format 6018-999-9999\" name=\"fetch_date\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group row\">\n");
      out.write("                <div class=\"col-sm-6\">Payment method:</div>\n");
      out.write("                <div class=\"col-sm-6\"><input type=\"text\" class=\"form-control\" id=\"pay_method_id\" value=\"\" placeholder=\"Select a payment method\" name=\"pay_method_id\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group row c_map_flip\" id=\"flip_sl\">\n");
      out.write("                <div class=\"col-sm-6\">Start Location:</div>\n");
      out.write("                <div class=\"col-sm-6\"><input type=\"text\" class=\"form-control controls\" id=\"start_location\" value=\"\" placeholder=\"Search a start location\" name=\"start_location\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"panel_sl\" class=\"form-group row c_map_panel\">\n");
      out.write("                <div style=\"display: none\">\n");
      out.write("                    <input id=\"pac-input_sl\" class=\"form-control controls pac-input\" type=\"text\" placeholder=\"Enter a location\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"map\" id=\"map_sl\">\n");
      out.write("                </div>    \n");
      out.write("                <div id=\"infowindow-content_sl\" class=\"infowindow-content\">\n");
      out.write("                    <!--The id value change-->\n");
      out.write("                    <span id=\"place-name_sl\" class=\"title\"></span><br>\n");
      out.write("                    Place ID: <span id=\"place-id_sl\"></span><br>\n");
      out.write("                    <span id=\"place-address_sl\"></span>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-success\" id='sl_submit'>Confirm</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-danger\" id='sl_close'>Close</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group row c_map_flip\" id=\"flip_el\">\n");
      out.write("                <div class=\"col-sm-6\">End Location:</div>\n");
      out.write("                <div class=\"col-sm-6\"><input type=\"text\" class=\"form-control controls\" id=\"end_location\" value=\"\" placeholder=\"Search a end location\" name=\"end_location\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"panel_el\" class=\"c_map_panel\">\n");
      out.write("                <div style=\"display: none\">\n");
      out.write("                    <input id=\"pac-input_el\" class=\"form-control controls pac-input\" type=\"text\" placeholder=\"Enter a location\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"map\" id=\"map_el\">\n");
      out.write("                </div>    \n");
      out.write("                <div id=\"infowindow-content_el\" class=\"infowindow-content\">\n");
      out.write("                    <!--The id value change-->\n");
      out.write("                    <span id=\"place-name_el\" class=\"title\"></span><br>\n");
      out.write("                    Place ID: <span id=\"place-id_el\"></span><br>\n");
      out.write("                    <span id=\"place-address_el\"></span>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-success\" id='el_submit'>Confirm</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-danger\" id='el_close'>Close</button>\n");
      out.write("                </div>\n");
      out.write("                    <script>\n");
      out.write("                      function initMap_all(){\n");
      out.write("                          initMap('_sl');\n");
      out.write("                          initMap('_el');\n");
      out.write("                      }\n");
      out.write("                    </script>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group row\">\n");
      out.write("                <input type=\"submit\" style=\"margin: 10px\" value=\"Book now\" class=\"btn btn-success pull-right\">\n");
      out.write("                <input type=\"reset\" style=\"margin: 10px\" value=\"Reset\" class=\"btn btn-warning pull-right\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw&libraries=places&callback=initMap_all\" async defer></script>\n");
      out.write("    <div id=\"footer\"></div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}