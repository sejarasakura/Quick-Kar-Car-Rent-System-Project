/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-05 17:31:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005fpage.admin_005fconsole._005fprofile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _da.*;
import _domain.*;
import _enum.*;

public final class customer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Admin console - customer detials</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_css/image.css\">\n");
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

            String id = (String)request.getParameter("id");
            CustomerDA driver_da = new CustomerDA();
            Customer cust = (Customer)driver_da.getRecord(id);
        
      out.write("\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("        <div>\n");
      out.write("\n");
      out.write("            <div class=\"jumbotron text-center\">\n");
      out.write("              <h1>Customer details</h1>    \n");
      out.write("              <p>customer details record view only!!</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-1\"></div>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <h3>\n");
      out.write("                            <div class=\"row\" style=\"margin: auto;\">\n");
      out.write("                                <div class=\"img-250-con center-block\" style=\"margin-bottom: 20px\">\n");
      out.write("                                    <img class=\"proc_pic-large img-circle img-full img-p-10\" src=\"http://localhost:8080/GroupProject/DisplayImage?id=");
      out.print( cust.getCust_id());
      out.write("\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer ID :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getCust_id());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer Name :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getFull_Name());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer Phone Number :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getPhone_num());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer IC Number :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getIc_num());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer Point Amount :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getPoint_amount());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\">Customer Membership Level :</div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">");
      out.print( cust.getMembership_level().getName());
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\" style=\"padding-top: 10px;\">\n");
      out.write("                            <div class=\"col-sm-6 text-right\"></div>\n");
      out.write("                            <div class=\"col-sm-6 text-left\">\n");
      out.write("                                <a href=\"#\" onclick=\"window.history.back()\" class=\"btn btn-default pull-right\" style=\"margin: 10px\">\n");
      out.write("                                    return back\n");
      out.write("                                </a>\n");
      out.write("                                <a href=\"http://localhost:8080/GroupProject/_page/admin_console/index.html\" onclick=\"\" class=\"btn btn-info pull-right\" style=\"margin: 10px\">\n");
      out.write("                                    Back to menu\n");
      out.write("                                </a>\n");
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