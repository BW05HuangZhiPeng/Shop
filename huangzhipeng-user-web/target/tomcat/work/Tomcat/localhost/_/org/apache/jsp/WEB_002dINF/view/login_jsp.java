/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-11-25 02:28:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!-->\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<!--<![endif]-->\r\n");
      out.write("<head>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common.jsp", out, false);
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\tredirectUrl = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${redirectUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction login(){\r\n");
      out.write("\t\t\t$.post(\"/login\", $(\"#loginForm\").serialize(),function(data){\r\n");
      out.write("\t\t\t\tif (data.code == 1000) {\r\n");
      out.write("\t\t\t\t\tif (redirectUrl == '') {\r\n");
      out.write("\t\t\t\t\t\tlocation.href = \"http://localhost:8080\";\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tlocation.href = redirectUrl;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"登录失败:\" + data.code + \"&\" + data.msg);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"homepage\">\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Bread Crumb STRAT -->\r\n");
      out.write("\t\t<div class=\"banner inner-banner1\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<section class=\"banner-detail center-xs\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"banner-title\">Login</h1>\r\n");
      out.write("\t\t\t\t\t<div class=\"bread-crumb right-side float-none-xs\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"index.html\"><i class=\"fa fa-home\"></i>Home</a>/</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><span>Login</span></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- Bread Crumb END -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- CONTAIN START -->\r\n");
      out.write("\t\t<section class=\"checkout-section ptb-60\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row justify-content-center\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xl-6 col-lg-8 col-md-8 \">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form class=\"main-form full\" action=\"javascript:void(0)\" id=\"loginForm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-12 mb-20\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"heading-part heading-bg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<h2 class=\"heading\">Customer Login</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"login-username\">账号</label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"login-username\" name=\"name\" type=\"text\" required\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"请输入账号\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"login-pass\">密码</label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"login-pass\" name=\"password\" type=\"password\" required\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"请输入密码\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"check-box left-side\" id=\"loginForm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span> <input type=\"checkbox\" name=\"remember_me\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"remember_me\" class=\"checkbox\"> <label\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tfor=\"remember_me\">记住我</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button name=\"submit\" onclick=\"login()\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"btn-color right-side\">登录</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a title=\"Forgot Password\" class=\"forgot-password mtb-20\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\thref=\"#\">Forgot your password?</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"new-account align-center mt-20\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>New to Shopholic?</span> <a class=\"link\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\ttitle=\"Register with Shopholic\" href=\"/toRegister\">Create\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tNew Account</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<!-- CONTAINER END -->\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
