package org.apache.jsp._005fpage.client_005fpage.driver.fetch;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _manipulation.MapManipulation;
import _domain.DistanceMatricRespond;
import _domain.DistanceMatricRespond;
import _enum.MembershipLevel;
import java.text.SimpleDateFormat;
import _control.domain.Report;
import _enum.RatingStar;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import _control.domain.SQL_control;

public final class fetching_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"payment.css\">\n");
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
      out.write("    <title>Payment</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"googlemaps\"></div>\n");
      out.write("        <div style=\"padding-top: 50px;padding-bottom: 50px;\" class=\"container\">\n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("            <h2>Fetch Activity</h2>\n");
      out.write("            <p>The results are the recent 7 day(s) activities. If you need more information please contact our customer services.</p>\n");
      out.write("            <p>You may check your recent activities here</p><br>\n");
      out.write("        </center>\n");
      out.write("<style>\n");
      out.write(".card {\n");
      out.write("  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n");
      out.write("  max-width: 300px;\n");
      out.write("  margin: auto;\n");
      out.write("  text-align: center;\n");
      out.write("  font-family: arial;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".title {\n");
      out.write("  color: grey;\n");
      out.write("  font-size: 18px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button {\n");
      out.write("  border: none;\n");
      out.write("  outline: 0;\n");
      out.write("  display: inline-block;\n");
      out.write("  padding: 8px;\n");
      out.write("  color: white;\n");
      out.write("  background-color: #000;\n");
      out.write("  text-align: center;\n");
      out.write("  cursor: pointer;\n");
      out.write("  width: 100%;\n");
      out.write("  font-size: 18px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a {\n");
      out.write("  text-decoration: none;\n");
      out.write("  font-size: 22px;\n");
      out.write("  color: black;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button:hover, a:hover {\n");
      out.write("  opacity: 0.7;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("          ");

              
              SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy hh:mm");
              String id = request.getParameter("id");
              String query = SQL_control.read_sql("driver_take_need_fetch_now.sql");
              SQL_control control = new SQL_control();
              System.out.println(query);
              PreparedStatement ps = control.prepareStatement(query);
              ResultSet rs = ps.executeQuery();
              int count = 0;
              boolean loop_liao = false;
          
      out.write("\n");
      out.write("            ");

                while(rs.next()){
                loop_liao = true;
                String cust_id = rs.getString(1);
                String cust_name = rs.getString(2);
                String phone_number = rs.getString(3);
                String member_level = rs.getString(4);
                Date fetch_date = rs.getTimestamp(5);
                String start_location = rs.getString(6);
                String end_location = rs.getString(7);
                if(count == 0){
                    
      out.write("<div class=\"row\">");

                }
                DistanceMatricRespond temp_matric_data = MapManipulation.getResponse(start_location, end_location);
            
      out.write("\n");
      out.write("            \n");
      out.write("<div class=\"col-sm-4\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("      <img src=\"http://localhost:8080/GroupProject/DisplayImage?id=");
      out.print( cust_id);
      out.write("\" alt=\"");
      out.print( cust_name);
      out.write('[');
      out.print( cust_id);
      out.write("]\" style=\"width:100%\">\n");
      out.write("      <h1>");
      out.print( cust_name);
      out.write("</h1>\n");
      out.write("      <h3>");
      out.print( MembershipLevel.getValue(member_level).getName());
      out.write(" Member</h3>\n");
      out.write("      <p class=\"title\">Fetch Time: ");
      out.print( DATE_FORMAT.format(fetch_date));
      out.write("</p>\n");
      out.write("      <p>Phone Number:");
      out.print( phone_number);
      out.write("</p>\n");
      out.write("      <p>Distance : ");
      out.print( temp_matric_data.getDistance_text());
      out.write("</p>\n");
      out.write("      <p>Duration : ");
      out.print( temp_matric_data.getDuration_text());
      out.write("</p>\n");
      out.write("      <p>From ");
      out.print( temp_matric_data.getOrigin_address());
      out.write(" To ");
      out.print( temp_matric_data.getDestination_address());
      out.write("</p>\n");
      out.write("      <p><button>Pick up</button></p>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("            ");

                count++;
                if(count == 3){
                    
      out.write("</div>");

                    count = 0;
                }
            
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            ");

              rs.close();
              ps.close();
              if(!loop_liao){
                    out.print("<br><h1 class='text-center'>No record found</h1><br><br><br><br><br>");
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
