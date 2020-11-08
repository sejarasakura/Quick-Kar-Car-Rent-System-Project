/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-05 21:33:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005fpage.admin_005fconsole.booking.update;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import _da.*;
import _domain.*;
import _enum.*;

public final class approve_005fupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("_enum");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("_da");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Admin console - booking detials</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            jQuery(document).ready(\n");
      out.write("                function(){\n");
      out.write("                    $(\"#header\").load(\"http://localhost:8080/GroupProject/_sub_page/header.jsp\");\n");
      out.write("                    $(\"#footer\").load(\"http://localhost:8080/GroupProject/_sub_page/footer.html\");\n");
      out.write("                }\n");
      out.write("            );\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String URL_PART = "http://localhost:8080/GroupProject/_page/admin_console/_profile/";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            String id = (String)request.getParameter("booking_id");
            BookingDA driver_da = new BookingDA();
            Booking cust = (Booking)driver_da.getRecord(id);
            cust.setCustomer(new Customer(((String)request.getParameter("cust_id")).split("-")[0]));
            cust.setDriver(new Driver(((String)request.getParameter("driver_id")).split("-")[0]));
            cust.setBooking_date(formatter.parse((String)request.getParameter("booking_date")));
            cust.setFetch_date(formatter.parse((String)request.getParameter("fetch_date")));
            cust.setStart_location(((String)request.getParameter("start_location")));
            cust.setEnd_location(((String)request.getParameter("end_location")));
            cust.setBooking_status(BookingStatus.getValue(((String)request.getParameter("booking_status")).split("-")[0]));
            request.getSession().setAttribute("booking", cust);
        
      out.write("\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("        <div>\n");
      out.write("\n");
      out.write("            <div class=\"jumbotron text-center\">\n");
      out.write("              <h1>Booking Update ?</h1>    \n");
      out.write("              <p>Confirm your booking update</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-1\"></div>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <h3>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Booking ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getBooking_id());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Rating ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"");
      out.print( URL_PART);
      out.write("rating.jsp?id=");
      out.print( cust.getRating().getRating_id());
      out.write("\">\n");
      out.write("                                    ");
      out.print( cust.getRating().getRating_id());
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"");
      out.print( URL_PART);
      out.write("customer.jsp?id=");
      out.print( cust.getCustomer().getCust_id());
      out.write("\">\n");
      out.write("                                    ");
      out.print( cust.getCustomer().getCust_id());
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Driver ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"");
      out.print( URL_PART);
      out.write("driver.jsp?id=");
      out.print( cust.getDriver().getDriver_id());
      out.write("\">\n");
      out.write("                                    ");
      out.print( cust.getDriver().getDriver_id());
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Payment ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"");
      out.print( URL_PART);
      out.write("payment.jsp?id=");
      out.print( cust.getPayment().getPayment_id());
      out.write("\">\n");
      out.write("                                    ");
      out.print( cust.getPayment().getPayment_id());
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Booking Date :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getBooking_date());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Fetch Date :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getFetch_date());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Booking Status :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getBooking_status());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Start Location Google MAP ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"https://maps.googleapis.com/maps/api/place/details/xml?place_id=");
      out.print( cust.getStart_location());
      out.write("&fields=geometry,address_component,name,rating,formatted_phone_number&key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw\">\n");
      out.write("                                    ");
      out.print( cust.getStart_location().substring(0, 20));
      out.write(".....\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">End Location Google MAP ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"https://maps.googleapis.com/maps/api/place/details/xml?place_id=");
      out.print( cust.getEnd_location());
      out.write("&fields=geometry,address_component,name,rating,formatted_phone_number&key=AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw\">\n");
      out.write("                                    ");
      out.print( cust.getEnd_location().substring(0, 20));
      out.write(".....\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div\n");
      out.write("                        <div class=\"row\" style=\"padding-top: 10px;\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\"></div>\n");
      out.write("                            <div class=\"col-sm-6 text-left row\">\n");
      out.write("                                <form method=\"post\" action=\"/GroupProject/updateBooking\">\n");
      out.write("                                    <style>.padding-15{margin: 15px;}</style>\n");
      out.write("                                    <input type=\"submit\" value=\"Confrim..\" class=\"btn btn-success pull-right padding-15\">\n");
      out.write("                                    <a href=\"update_booking.jsp\" class=\"btn btn-danger pull-right padding-15\">\n");
      out.write("                                        Cancel..\n");
      out.write("                                    </a>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        </h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-1\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("                        <div style=\"padding-bottom: 20px\"></div>\n");
      out.write("        <div id=\"footer\"></div>\n");
      out.write("    </body>\n");
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