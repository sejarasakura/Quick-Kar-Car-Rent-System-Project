/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-05 22:37:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005fpage.client_005fpage.customer.payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import _da.*;
import _domain.*;
import _servletAPI._session.*;

public final class payment_005fCard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    CustomerSession new_c = new CustomerSession();
    new_c.retriveSeesion(request);
    request.getSession().setAttribute("cust_id", new_c.getUsername());
    request.getSession().setAttribute("pay_method", "card");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\"><!-- Latest compiled and minified CSS -->\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("        <link rel=\"icon\" href=\"http://localhost:8080/GroupProject/_resource/icon/top_full_icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_bootstrap/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://localhost:8080/GroupProject/_css/main_style.css\">\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_js/map-google.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-confirm.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery.validate.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-ui.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_jquery/jquery-migrate-3.0.0.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:8080/GroupProject/_js/Validatation_c.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"payment.css\">\n");
      out.write("    <title>Payment</title>\n");
      out.write("    <script>\n");
      out.write("            jQuery(document).ready(\n");
      out.write("                function(){\n");
      out.write("                    $(\"#header\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_header.jsp\");\n");
      out.write("                    $(\"#footer\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_footer.html\");\n");
      out.write("                }\n");
      out.write("            );\n");
      out.write("        </script>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("      <div id=\"header\"></div>\n");
      out.write("      \n");
      out.write("      <form id=\"createform\" action=\"http://localhost:8080/GroupProject/_page/client_page/customer/payment/payment_conti.jsp?pay_method=card\" method=\"post\">\n");
      out.write("            <div class=\"payment\">\n");
      out.write("        <h2>Payment<p>Credit/ Debit Card</p></h2>\n");
      out.write("\n");
      out.write("        <div class=\"form\">\n");
      out.write("          <div class=\"card space icon-relative\">\n");
      out.write("            <label class=\"label\">Card Holder:</label>\n");
      out.write("            <input type=\"text\" class=\"input\" name=\"card_holder\" id=\"card_holder\" placeholder=\"Your name\">\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"card space icon-relative\">\n");
      out.write("            <label class=\"label\">Card Number:</label>\n");
      out.write("            <input type=\"text\" class=\"input\" name=\"card_num\" id=\"card_num\" placeholder=\"Card Number\">\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"card-grp space\">\n");
      out.write("            <div class=\"card-item icon-relative\">\n");
      out.write("              <label class=\"label\">Expiry Date: </label>\n");
      out.write("              <input type=\"text\" class=\"input\" id=\"expiry_date\" name=\"expiry_date\" placeholder=\"00/00\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"card-item icon-relative\">\n");
      out.write("                <label class=\"label\">CVV: </label>\n");
      out.write("                <input type=\"text\" class=\"input\" name=\"cvv\" id=\"cvv\" placeholder=\"000\">\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <input class=\"btn btn-info\" type=\"submit\" value=\"Pay\">\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      </form>\n");
      out.write("      <div id=\"footer\"></div>\n");
      out.write("  </body>\n");
      out.write("  <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#createform\").validate({\n");
      out.write("                    rules: {\n");
      out.write("                        card_holder: {\n");
      out.write("                            required: true,\n");
      out.write("                            regex: regex_list.Validate.name\n");
      out.write("                        },\n");
      out.write("                        cvv: {\n");
      out.write("                            required: true,\n");
      out.write("                            regex: regex_list.Validate.cvv\n");
      out.write("                        },\n");
      out.write("                        expiry_date: {\n");
      out.write("                            required: true,\n");
      out.write("                            regex: regex_list.Validate.expiry_date\n");
      out.write("                        },\n");
      out.write("                        card_num: {\n");
      out.write("                            required: true,\n");
      out.write("                            regex: regex_list.Validate.card_num\n");
      out.write("                        },\n");
      out.write("                    },\n");
      out.write("                    message:{\n");
      out.write("                        \n");
      out.write("                    },\n");
      out.write("                    errorPlacement: function(label, element) {\n");
      out.write("                        label.addClass('text-danger');\n");
      out.write("                        label.insertAfter(element);\n");
      out.write("                    },\n");
      out.write("                    wrapper: 'span'\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("  </script>\n");
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
