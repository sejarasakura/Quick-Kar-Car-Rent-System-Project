/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-06 01:20:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005fpage.client_005fpage.customer.recent_005factivity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _servletAPI._session.CustomerSession;
import java.util.Date;
import _control.domain.Report;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import _control.domain.SQL_control;
import _da.*;
import _domain.*;
import _enum.*;

public final class recent_005factivity_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("_control.domain.Report");
    _jspx_imports_classes.add("_control.domain.SQL_control");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.Timestamp");
    _jspx_imports_classes.add("_servletAPI._session.CustomerSession");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Booking record and comments</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/rate-it/rateit.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_css/main_style.css\">\n");
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
      out.write("\n");
      out.write(".c_panel{\n");
      out.write("    background-color: #f6f6f6;\n");
      out.write("    border: 1px solid #ccc!important;\n");
      out.write("    padding: 10px;\n");
      out.write("    display: none;\n");
      out.write("    position: fixed;\n");
      out.write("    z-index: 2;\n");
      out.write("    transform: translate(-50%, -50%);\n");
      out.write("    left:50%;\n");
      out.write("    top:50%;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    width: 500px;\n");
      out.write("    height: 290px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("<div class=\"container\">\n");
      out.write("  <center>\n");
      out.write("  <h2>Recent Activity</h2>\n");
      out.write("<p>The results are the recent 7 day(s) activities. If you need more information please contact our customer services.</p>\n");
      out.write("  <p>You may check your recent activities here</p><br>\n");
      out.write("</center>\n");
      out.write("\n");

    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    String id = new_c.getUsername();
    String query = SQL_control.read_sql("customer_rating_history.sql");
    SQL_control control = new SQL_control();
    PreparedStatement ps = control.prepareStatement(query);
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();
    boolean loopliao = false;

      out.write("\n");
      out.write("  <hr>\n");
      out.write("  ");

      while(rs.next()){
          loopliao = true;
      String driver_id = rs.getString(1);
      String driver_name = rs.getString(2);
      String rating_star = rs.getString(3);
      String cust_comment = rs.getString(4);
      Date rating_date = rs.getTimestamp(5);
      String rating_id = rs.getString(6);
      String s7 = rs.getString(7);
      String s8 = rs.getString(8);
      RatingStar rts = RatingStar.getValue(rating_star);
  
      out.write("\n");
      out.write("  <div class=\"media\" id=\"media-");
      out.print( rating_id);
      out.write("\">\n");
      out.write("    <div class=\"media-left\">\n");
      out.write("        <img src=\"/GroupProject/DisplayImage?id=");
      out.print( driver_id);
      out.write("\" class=\"media-object\" style=\"width:100px\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"media-body\">\n");
      out.write("        <h4 class=\"media-heading\">");
      out.print( driver_name);
      out.write("&ensp;<small class=\"pull-right\"><i>");
      out.print( Report.REPORT_HEADER_FORMAT.format(rating_date));
      out.write("</i><button style=\"margin-left: 10px;\" class=\"btn btn-info\" id=\"button-");
      out.print( rating_id);
      out.write("\">Comment</button></small></h4>\n");
      out.write("      <div class=\"rateit\" data-rateit-value=\"");
      out.print( rts.getRating_value());
      out.write("\" data-rateit-ispreset=\"true\" data-rateit-readonly=\"true\"></div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("          <div class=\"col-sm-4\">Payment Amount :</div>\n");
      out.write("          <div class=\"col-sm-8\">");
      out.print( s7);
      out.write("</div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("          <div class=\"col-sm-4\">Payment Status :</div>\n");
      out.write("          <div class=\"col-sm-8\">");
      out.print( PaymentStatus.getValue(s8).getName());
      out.write("</div>\n");
      out.write("      </div>\n");
      out.write("      <h5> <p>Your comment(s): </p> </h5>\n");
      out.write("      <p>");
      out.print( cust_comment);
      out.write("</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"c_panel\" id=\"box-");
      out.print( rating_id);
      out.write("\">\n");
      out.write("      <form method=\"post\" action=\"http://localhost:8080/GroupProject/CustomerUpdateRating\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"comment\">Comment:</label>\n");
      out.write("                <textarea class=\"form-control\" rows=\"5\" name=\"comment\"></textarea>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"center-block\">\n");
      out.write("                    <div onclick=\"$('#star-");
      out.print( rating_id);
      out.write("').val($('#rate-");
      out.print( rating_id);
      out.write("').rateit('value'));\" class=\"rateit\" id=\"rate-");
      out.print( rating_id);
      out.write("\" data-rateit-mode=\"font\"  style=\"font-size:50px\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                    <input style=\"display:none\" type=\"hidden\" name=\"rating_id\" value=\"");
      out.print( rating_id);
      out.write("\">\n");
      out.write("                    <input style=\"display:none\" type=\"hidden\" name=\"star\" id=\"star-");
      out.print( rating_id);
      out.write("\" value=\"");
      out.print( rating_id);
      out.write("\">\n");
      out.write("                    <input style=\"display:none\" type=\"hidden\" name=\"status\" value=\"1\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-6\"><input type=\"submit\" style=\"width: 100%\" value=\"Submit Comment\" class=\"btn btn-success\"></div>\n");
      out.write("                <div class=\"col-sm-6\"><input style=\"width: 100%\" class=\"btn btn-danger\" onclick='$(\"#box-");
      out.print( rating_id);
      out.write("\").toggle();' value=\"Close\"></div>\n");
      out.write("            </div>\n");
      out.write("      </form>\n");
      out.write("  </div>\n");
      out.write("  <hr>\n");
      out.write("  <script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("      $(\"#button-");
      out.print( rating_id);
      out.write("\").click(function(){\n");
      out.write("        $(\"#box-");
      out.print( rating_id);
      out.write("\").toggle();\n");
      out.write("      });\n");
      out.write("    });\n");
      out.write("  </script>\n");
      out.write("  ");
}
    rs.close();
    ps.close();
    if(!loopliao){
        out.print("<br><h1 class='text-center'>No record found</h1><br><br><br><br><br>");
    }
  
      out.write("\n");
      out.write("  \n");
      out.write("  </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("        <div id=\"footer\"></div> \n");
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
