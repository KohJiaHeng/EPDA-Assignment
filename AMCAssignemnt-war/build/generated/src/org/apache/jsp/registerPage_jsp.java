package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Manager;

public final class registerPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    Manager manager = (Manager) session.getAttribute("manager");
    boolean isManagerAccount = (manager != null);


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>");
      out.print( isManagerAccount ? "Admin Register Page" : "User Registration Page");
      out.write("</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if (isManagerAccount) { 
      out.write("\n");
      out.write("        <h2>Welcome Admin, register new accounts below:</h2>\n");
      out.write("        <a href=\"adminPage.jsp\">← Back to Admin Page</a>\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("        <a href=\"loginPage.jsp\">Login Page</a>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        <form action=\"");
      out.print( isManagerAccount ? "adminRegister" : "Register");
      out.write("\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Username: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"username\" size=\"20\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Password: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"Password\" size=\"20\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Roles: </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
 if (isManagerAccount) { 
      out.write("\n");
      out.write("                        <select name=\"roles\" id=\"role\" required>\n");
      out.write("                            <option value=\"\" disabled selected>Select role</option>\n");
      out.write("                            <option value=\"Manager\">Manager</option>\n");
      out.write("                            <option value=\"Doctor\">Doctor</option>\n");
      out.write("                            <option value=\"CounterStaff\">Counter Staff</option>\n");
      out.write("                        </select>\n");
      out.write("\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                       \n");
      out.write("                        <input type=\"text\" name=\"roles\" size=\"20\" placeholder=\"CUSTOMER\">\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <input type=\"text\" name=\"email\" size=\"20\" placeholder=\"Email\">\n");
      out.write("                        \n");
      out.write("                       \n");
      out.write("                        <input type=\"text\" name=\"gender\" size=\"20\" placeholder=\"Gender\">\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <input type=\"text\" name=\"phone\" size=\"20\" placeholder=\"Phone Number\">\n");
      out.write("                        \n");
      out.write("                       \n");
      out.write("                        <input type=\"text\" name=\"ic\" size=\"20\" placeholder=\"IC\">\n");
      out.write("                        \n");
      out.write("                       \n");
      out.write("                        <input type=\"text\" name=\"address\" size=\"20\" placeholder=\"Address\">\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <p><input type=\"submit\" value=\"Register\"></p>\n");
      out.write("        </form>\n");
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
