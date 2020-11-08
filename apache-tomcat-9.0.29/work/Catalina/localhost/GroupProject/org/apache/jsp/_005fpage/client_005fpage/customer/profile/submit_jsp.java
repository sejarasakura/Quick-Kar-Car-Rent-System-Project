/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-06 02:32:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005fpage.client_005fpage.customer.profile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _enum.ErrorDetails;
import _enum.MembershipLevel;
import _domain.Customer;
import _da.CustomerDA;
import _servletAPI._session.*;

public final class submit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("_servletAPI._session");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("_enum.MembershipLevel");
    _jspx_imports_classes.add("_domain.Customer");
    _jspx_imports_classes.add("_da.CustomerDA");
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
      out.write("\n");

    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    String id = null;
    try{
        id = new_c.getUsername();
    }catch(Exception ex){
    }
    String url = "http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html";
    _da.CustomerDA da = new CustomerDA();
    _domain.Customer domain = new Customer();
    domain = (Customer)da.getRecord(id);
    String first_name = request.getParameter("first_name");
    String last_name = request.getParameter("last_name");
    String member_level = request.getParameter("member_level");
    String phone_num = request.getParameter("phone_num");
    domain.setFirst_name(first_name);
    domain.setLast_name(last_name);
    domain.setMembership_level(MembershipLevel.getValue(member_level));
    domain.setPhone_num(phone_num);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
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
      out.write("        <title>Uploading Data</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("                $.confirm({\n");
      out.write("                   title: 'Update?',\n");
      out.write("                    content: 'Do you want to make changes, auto make changes in 10 Seconds',\n");
      out.write("                    type: 'blue',\n");
      out.write("                    autoClose: 'update|10000',\n");
      out.write("                    buttons: {\n");
      out.write("                        update: {\n");
      out.write("                            text: 'Update',\n");
      out.write("                            action: function () {\n");
      out.write("                                ");

                                    request.getSession().setAttribute("Cusrrent_customer_update_data", domain);
                                
      out.write("\n");
      out.write("                                window.location.replace('http://localhost:8080/GroupProject/Customer_update_cilent');                           \n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        cancel: function () {\n");
      out.write("                            $.alert('your update had been canceled');\n");
      out.write("                                window.location.replace('http://localhost:8080/GroupProject/_page/client_page/all_user/home/home.html');    \n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            \n");
      out.write("            });\n");
      out.write("        </script>\n");
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
