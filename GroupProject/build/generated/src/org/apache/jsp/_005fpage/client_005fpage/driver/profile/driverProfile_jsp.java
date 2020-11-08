package org.apache.jsp._005fpage.client_005fpage.driver.profile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _servletAPI._session.DriverSession;
import _da.DriverDA;
import _domain.Driver;

public final class driverProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    DriverSession new_c = new DriverSession();
    new_c.retriveSeesion(request);
    String id = null;
    try{
        id = new_c.getUsername();
    }catch(Exception ex){
    }
    _da.DriverDA da = new DriverDA();
    _domain.Driver domain = new Driver();
    domain = (Driver)da.getRecord(id);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>Customer Profile</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../customerprofile.css\">\n");
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
      out.write("        \n");
      out.write("    <script>\n");
      out.write("            jQuery(document).ready(\n");
      out.write("                function(){\n");
      out.write("                    $(\"#header\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_header.jsp\");\n");
      out.write("                    $(\"#footer\").load(\"http://localhost:8080/GroupProject/_page/client_base/c_footer.html\");\n");
      out.write("                }\n");
      out.write("            );\n");
      out.write("        </script>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Driver Profile</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <div id=\"header\"></div>\n");
      out.write("  <center>\n");
      out.write("    <h2>Driver Profile</h2>\n");
      out.write("  </center>\n");
      out.write("  <style>\n");
      out.write("    .classes {\n");
      out.write("      margin: 10px auto;\n");
      out.write("      height: 200px;\n");
      out.write("      width: 200px;\n");
      out.write("    }\n");
      out.write("body{\n");
      out.write("  background:linear-gradient( #ffff66 0%, #ffcc00 100%);\n");
      out.write("  height: auto;\n");
      out.write("  background-repeat:no-repeat;\n");
      out.write("\n");
      out.write("}\n");
      out.write("    .img {\n");
      out.write("      height: 100%;\n");
      out.write("      width: 100%;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("  <div class=\"container\">\n");
      out.write("<form class=\"\" action=\"submit.jsp\" method=\"post\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"center-block\">\n");
      out.write("        <div class=\"classes\"><img src=\"http://localhost:8080/GroupProject/DisplayImage?id=");
      out.print( id);
      out.write("\" alt=\"\" class=\"img img-circle\"></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-sm-6\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"First Name\">First Name:</label>\n");
      out.write("          <input type=\"First Name\" class=\"form-control\" id=\"first_name\" placeholder=\"First Name\" name=\"first_name\" value=\"");
      out.print( domain.getFirst_name());
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"Username\">Liscence:</label>\n");
      out.write("          <input type=\"Username\" class=\"form-control\" id=\"Username\" placeholder=\"Liscence\" name=\"Username\" value=\"");
      out.print( domain.getLicense());
      out.write("\" disabled=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"userid\">User ID:</label>\n");
      out.write("          <input type=\"userid\" class=\"form-control\" id=\"user_id\" placeholder=\"user ID\" name=\"user_id\" disabled value=\"");
      out.print( domain.getDriver_id());
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"icnumber\">IC Number:</label>\n");
      out.write("          <input type=\"icnumber\" class=\"form-control\" id=\"ic_num\" placeholder=\"ic number\" name=\"ic_num\" disabled value=\"");
      out.print( domain.getIc_num());
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"Year(s) of driving\">Year(s) of driving:</label>\n");
      out.write("          <input type=\"Year(s) of driving\" class=\"form-control\" id=\"year_of_drive\" placeholder=\"Year(s) of driving\" name=\"year_of_drive\" disabled value=\"");
      out.print( domain.getYear_of_drive());
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-sm-6\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"Last Name\">Last Name:</label>\n");
      out.write("          <input type=\"Last Name\" class=\"form-control\" id=\"last_name\" placeholder=\"Last Name\" name=\"last_name\" value=\"");
      out.print( domain.getLast_name());
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <label for=\"pnumber\">Phone Number:</label>\n");
      out.write("          <input type=\"pnumber\" class=\"form-control\" id=\"phone_num\" placeholder=\"phone number\" name=\"phone_num\" value=\"");
      out.print( domain.getPhone_num());
      out.write("\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\" style=\"width: 100%; margin-top: 20px;\">Changes</button>\n");
      out.write("        <button type=\"button\" class=\"btn btn-danger\" style=\"width: 100%; margin-top: 20px;\">Cancel</button>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("        </div>\n");
      out.write("</form>\n");
      out.write("    </div>\n");
      out.write("  <div id=\"footer\"></div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
