package org.apache.jsp._005fpage.client_005fpage.driver.recent_005factivity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import _control.domain.Report;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import _control.domain.SQL_control;
import _da.*;
import _domain.*;
import _enum.*;

public final class driver_005factivity_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Recent Activity</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/rate-it/rateit.css\">\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_js/map-google.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/rate-it/jquery.rateit.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/rate-it/jquery.rateit.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_js/Validatation_c.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            jQuery(document).ready(\n");
      out.write("                function(){\n");
      out.write("                    $(\"#header\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_header.jsp\");\n");
      out.write("                    $(\"#footer\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_footer.html\");\n");
      out.write("                }\n");
      out.write("            );\n");
      out.write("        </script>\n");
      out.write("<style media=\"screen\">\n");
      out.write(".checked {\n");
      out.write("color: orange;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("<div class=\"container\">\n");
      out.write("  <center>\n");
      out.write("  <h2>Fetch Activity</h2>\n");
      out.write("<p>The results are the recent 7 day(s) activities. If you need more information please contact our customer services.</p>\n");
      out.write("  <p>You may check your recent activities here</p><br>\n");
      out.write("</center>\n");
      out.write("\n");

    String id = request.getParameter("id");
    String query = SQL_control.read_sql("driver_rating_personal.sql");
    SQL_control control = new SQL_control();
    System.out.println(query);
    PreparedStatement ps = control.prepareStatement(query);
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();

      out.write("\n");
      out.write("  ");

      if(!rs.next()){
          out.print("<br><h1 class='text-center'>No record found</h1><br><br><br><br><br>");
      }
      while(rs.next()){
      String cust_id = rs.getString(1);
      String cust_name = rs.getString(2);
      String rating_star = rs.getString(3);
      String cust_comment = rs.getString(4);
      Date rating_date = rs.getTimestamp(5);
      RatingStar rts = RatingStar.getValue(rating_star);
  
      out.write("\n");
      out.write("  <hr>\n");
      out.write("  <div class=\"media\">\n");
      out.write("    <div class=\"media-left\">\n");
      out.write("        <img src=\"/GroupProject/DisplayImage?id=");
      out.print( cust_id);
      out.write("\" class=\"media-object\" style=\"width:100px\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"media-body\">\n");
      out.write("        <h4 class=\"media-heading\">");
      out.print( cust_name);
      out.write("&ensp;<small class=\"pull-right\"><i>");
      out.print( Report.REPORT_HEADER_FORMAT.format(rating_date));
      out.write("</i></small></h4>\n");
      out.write("      <div class=\"rateit\" data-rateit-value=\"");
      out.print( rts.getRating_value());
      out.write("\" data-rateit-ispreset=\"true\" data-rateit-readonly=\"true\"></div>\n");
      out.write("      <h5> <p>Your comment(s): </p> </h5>\n");
      out.write("      <p>");
      out.print( cust_comment);
      out.write("</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <hr>\n");
      out.write("  ");
}
    rs.close();
    ps.close();
  
      out.write("\n");
      out.write("  </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("        <div id=\"footer\"></div> \n");
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
