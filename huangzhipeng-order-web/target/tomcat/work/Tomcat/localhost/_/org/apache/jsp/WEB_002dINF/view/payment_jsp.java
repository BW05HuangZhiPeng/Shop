/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-11-26 03:23:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class payment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!-->\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("<div class=\"se-pre-con\"></div>\r\n");
      out.write("<div class=\"main\"> \r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  <!-- Bread Crumb STRAT -->\r\n");
      out.write("  <div class=\"banner inner-banner1\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <section class=\"banner-detail center-xs\">\r\n");
      out.write("        <h1 class=\"banner-title\">Payment</h1>\r\n");
      out.write("        <div class=\"bread-crumb right-side float-none-xs\">\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"index.html\"><i class=\"fa fa-home\"></i>Home</a>/</li>\r\n");
      out.write("            <li><a href=\"cart.html\">Cart</a>/</li>\r\n");
      out.write("            <li><span>Checkout</span></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </section>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- Bread Crumb END -->\r\n");
      out.write("\r\n");
      out.write("  <!-- CONTAIN START -->\r\n");
      out.write("  <section class=\"checkout-section ptb-60\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-12\">\r\n");
      out.write("          <div class=\"checkout-step mb-40\">\r\n");
      out.write("            <ul>\r\n");
      out.write("              <li> \r\n");
      out.write("                <a href=\"checkout.html\">\r\n");
      out.write("                  <div class=\"step\">\r\n");
      out.write("                    <div class=\"line\"></div>\r\n");
      out.write("                    <div class=\"circle\">1</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <span>Shipping</span> \r\n");
      out.write("                </a> \r\n");
      out.write("              </li>\r\n");
      out.write("              <li> \r\n");
      out.write("                <a href=\"order-overview.html\">\r\n");
      out.write("                  <div class=\"step\">\r\n");
      out.write("                    <div class=\"line\"></div>\r\n");
      out.write("                    <div class=\"circle\">2</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <span>Order Overview</span> \r\n");
      out.write("                </a> \r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"active\"> \r\n");
      out.write("                <a href=\"payment.html\">\r\n");
      out.write("                  <div class=\"step\">\r\n");
      out.write("                    <div class=\"line\"></div>\r\n");
      out.write("                    <div class=\"circle\">3</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <span>Payment</span> \r\n");
      out.write("                </a> \r\n");
      out.write("              </li>\r\n");
      out.write("              <li> \r\n");
      out.write("                <a href=\"order-complete.html\">\r\n");
      out.write("                  <div class=\"step\">\r\n");
      out.write("                    <div class=\"line\"></div>\r\n");
      out.write("                    <div class=\"circle\">4</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <span>Order Complete</span> \r\n");
      out.write("                </a> \r\n");
      out.write("              </li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <div class=\"step\">\r\n");
      out.write("                  <div class=\"line\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <hr>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"checkout-content\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"col-12\">\r\n");
      out.write("                <div class=\"heading-part align-center\">\r\n");
      out.write("                  <h2 class=\"heading\">Select a payment method</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row justify-content-center\">\r\n");
      out.write("              <div class=\"col-xl-6 col-lg-8 col-md-8 \">\r\n");
      out.write("                <div class=\"payment-option-box mb-30\">\r\n");
      out.write("                  <div class=\"payment-option-box-inner gray-bg\">\r\n");
      out.write("                    <div class=\"payment-top-box\">\r\n");
      out.write("                      <div class=\"radio-box left-side\"> <span>\r\n");
      out.write("                        <input type=\"radio\" id=\"paypal\" value=\"paypal\" name=\"payment_type\">\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <label for=\"paypal\">PayPal</label>\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"paypal-box\">\r\n");
      out.write("                        <div class=\"paypal-top\"> <img src=\"images/paypal-img.png\" alt=\"Shopholic\"> </div>\r\n");
      out.write("                        <div class=\"paypal-img\"> <img src=\"images/payment-method.png\" alt=\"Shopholic\"> </div>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <p>If you Don't have CCAvenue Account, it doesn,t matter. You can also pay via CCAvenue with you credit card or bank debit card</p>\r\n");
      out.write("                    <p>Payment can be submitted in any currency.</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"payment-option-box mb-30\">\r\n");
      out.write("                  <div class=\"payment-option-box-inner gray-bg\">\r\n");
      out.write("                    <div class=\"payment-top-box\">\r\n");
      out.write("                      <div class=\"radio-box left-side\"> <span>\r\n");
      out.write("                        <input type=\"radio\" id=\"cash\" value=\"cash\" name=\"payment_type\">\r\n");
      out.write("                        </span>\r\n");
      out.write("                        <label for=\"cash\">Would you like to pay by Cash on Delivery?</label>\r\n");
      out.write("                      </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <p>Vestibulum semper accumsan nisi, at blandit tortor maxi'mus in phasellus malesuada sodales odio, at dapibus libero malesuada quis.</p>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"right-side float-none-xs\"> <a class=\"btn btn-color\" href=\"order-complete.html\">Place Order<span><i class=\"fa fa-angle-right\"></i></span></a> </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </section>\r\n");
      out.write("  <!-- CONTAINER END --> \r\n");
      out.write("\r\n");
      out.write("  <!-- FOOTER START -->\r\n");
      out.write("  <div class=\"footer\">\r\n");
      out.write("    <div class=\"footer-top\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-xl-3 col-lg-3 col-sm-12 center-sm mb-sm-20\">\r\n");
      out.write("          <div class=\"f-logo\">\r\n");
      out.write("            <a href=\"index.html\" class=\"\">\r\n");
      out.write("              <img src=\"images/footer-logo.png\" alt=\"Shopholic\">\r\n");
      out.write("            </a>\r\n");
      out.write("          </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-xl-6 col-lg-6 col-sm-12 center-sm mb-sm-20 align-center\">\r\n");
      out.write("            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consequat massa quis lorem hendrerit ultrices.</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-xl-3 col-lg-3 col-sm-12 center-sm\">\r\n");
      out.write("          <div class=\"footer_social right-side float-none-md\">\r\n");
      out.write("            <ul class=\"social-icon\">\r\n");
      out.write("              <li><a title=\"Facebook\" class=\"facebook\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("              <li><a title=\"Twitter\" class=\"twitter\"><i class=\"fa fa-twitter\"></i></a></li>\r\n");
      out.write("              <li><a title=\"Linkedin\" class=\"linkedin\"><i class=\"fa fa-linkedin\"> </i></a></li>\r\n");
      out.write("              <li><a title=\"RSS\" class=\"rss\"><i class=\"fa fa-rss\"> </i></a></li>\r\n");
      out.write("              <li><a title=\"Pinterest\" class=\"pinterest\"><i class=\"fa fa-pinterest\"> </i></a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"js/jquery-1.12.3.min.js\"></script> \r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.js\"></script>  \r\n");
      out.write("<script src=\"js/jquery.downCount.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-ui.min.js\"></script> \r\n");
      out.write("<script src=\"js/fotorama.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.magnific-popup.js\"></script> \r\n");
      out.write("<script src=\"js/owl.carousel.min.js\"></script>  \r\n");
      out.write("<script src=\"js/custom.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
