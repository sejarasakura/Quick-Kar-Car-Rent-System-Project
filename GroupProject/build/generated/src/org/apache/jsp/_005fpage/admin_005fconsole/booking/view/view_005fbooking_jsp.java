package org.apache.jsp._005fpage.admin_005fconsole.booking.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _da.*;
import _domain.*;
import _enum.*;

public final class view_005fbooking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Admin console - Booking [view]</title>\n");
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
      out.write("        <style>\n");
      out.write("            a{\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("        <br>\n");
      out.write("        <h1 class=\"text-center\">Display Booking Module</h1>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">\n");
      out.write("            <br>\n");
      out.write("            <table class=\"table table-bordered table-striped\">\n");
      out.write("              <thead>\n");
      out.write("                <tr>\n");
      out.write("                  <th>Booking ID</th>\n");
      out.write("                  <th>Customer ID</th>\n");
      out.write("                  <th>Driver ID</th>\n");
      out.write("                  <th>Booking Date</th>\n");
      out.write("                  <th>Fetch Date</th>\n");
      out.write("                  <th>Booking Status</th>\n");
      out.write("                  <th>Rating</th>\n");
      out.write("                </tr>\n");
      out.write("              </thead>\n");
      out.write("              <tbody id=\"myTable\">\n");
      out.write("                ");

                    String URL_PART = "http://localhost:8080/GroupProject/_page/admin_console/_profile/";
                    BookingDA booking = new BookingDA();
                    Object[] bookings = booking.getRecords();
                
      out.write("\n");
      out.write("                ");
for(int i = 0; i < bookings.length; i++){ 
      out.write("\n");
      out.write("                ");
Booking b = (Booking)bookings[i];
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td><a href=\"");
      out.print( URL_PART);
      out.write("booking.jsp?id=");
      out.print( b.getBooking_id());
      out.write('"');
      out.write('>');
      out.print( b.getBooking_id());
      out.write("</a></td>\n");
      out.write("                        <td><a href=\"");
      out.print( URL_PART);
      out.write("customer.jsp?id=");
      out.print( b.getCustomer().getCust_id());
      out.write('"');
      out.write('>');
      out.print( b.getCustomer().getCust_id());
      out.write("</a></td>\n");
      out.write("                        <td><a href=\"");
      out.print( URL_PART);
      out.write("driver.jsp?id=");
      out.print( b.getDriver().getDriver_id());
      out.write('"');
      out.write('>');
      out.print( b.getDriver().getDriver_id());
      out.write("</a></td>\n");
      out.write("                        <td>");
      out.print( b.getBooking_date());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( b.getFetch_date());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( b.getBooking_status().getName());
      out.write("</td>\n");
      out.write("                        <td><a href=\"");
      out.print( URL_PART);
      out.write("rating.jsp?id=");
      out.print( b.getRating().getRating_id());
      out.write('"');
      out.write('>');
      out.print( b.getRating().getRating_id());
      out.write("</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("              </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <p>Note that after cancel booking cannot be change reverse back to un cancel!!</p>\n");
      out.write("          </div>\n");
      out.write("        <div id=\"footer\"></div>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write("  $(\"#myInput\").on(\"keyup\", function() {\n");
      out.write("    var value = $(this).val().toLowerCase();\n");
      out.write("    $(\"#myTable tr\").filter(function() {\n");
      out.write("      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
