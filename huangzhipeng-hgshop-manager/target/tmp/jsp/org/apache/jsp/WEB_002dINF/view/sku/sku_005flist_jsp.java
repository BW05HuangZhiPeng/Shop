/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.20.v20190813
 * Generated at: 2019-11-22 01:12:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.sku;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sku_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/program/mvn_rep/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("file:/D:/program/mvn_rep/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1567342320925L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("  <head>\r\n");
      out.write("  \t<base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>hgshop后台管理系统</title>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"/resource/css/bootstrap.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resource/bootstrap-treeview/css/bootstrap-treeview.css\" />\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/resource/jquery/jquery-3.4.1.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/resource/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/resource/bootstrap-treeview/js/bootstrap-treeview.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 加入了列 填充整行 -->\r\n");
      out.write("\t\t\t\t\t\t<form class=\"col-sm-12\" action=\"/Sku/skuList\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>商品名称</label> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"title\" class=\"form-control\" placeholder=\"请输入商品名称\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>商品副标题</label> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"sellPoint\" class=\"form-control\" placeholder=\"请输入卖点\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.sellPoint}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-success\" type=\"submit\">搜索</button>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- 外边距(下方) 10像素的大小 -->\r\n");
      out.write("\t\t\t\t\t<div class=\"row\" style=\"margin-bottom: 10px;\">\r\n");
      out.write("\t\t\t\t\t\t<!-- 右端对齐 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-12\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" class=\"btn btn-danger\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"deleteSku()\" value=\"批量删除\" />\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-primary btn-sm\" onclick=\"preAddSku()\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-toggle=\"modal\" data-target=\"#skuAddModal\">添加sku</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-striped\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\"><input type=\"checkbox\" id=\"cbk\" />全选</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">序号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">商品图片</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">商品标题</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">商品价格</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">商品状态</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">商品库存</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">操作</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- ////////////////写入添加模态框 //////////////////////////////-->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"skuAddModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<!-- 关闭的x效果 -->\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\t\taria-hidden=\"true\" onclick=\"clearAddSku()\">&times;</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- 模态框的标题 -->\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\" id=\"skuAddModalLabel\">添加商品操作</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"modalForm\" enctype=\"multipart/form-data\" action=\"javascript:void(0)\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"id\" id=\"addId\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"image\" id=\"addImage\"/>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addTitle\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"col-sm-3 col-form-label col-form-label-sm\">商品标题</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control form-control-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"addTitle\" name=\"title\" placeholder=\"请输入商品标题\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addPrice\" class=\"col-sm-3 col-form-label\">商品价格</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"addPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"price\" placeholder=\"请输入商品价格\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addCostPrice\" class=\"col-sm-3 col-form-label\">成本价格</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"addCostPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"costPrice\" placeholder=\"请输入成本价格\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addMarketPrice\" class=\"col-sm-3 col-form-label\">市场价格</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"addMarketPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"marketPrice\" placeholder=\"请输入市场价格\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addSpuId\" class=\"col-sm-3 col-form-label\">所属商品</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"addSpuId\" name=\"spuId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"\">请选择商品</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t                     <div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addStockCount\" class=\"col-sm-3 col-form-label\">商品库存</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"addStockCount\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"stockCount\" placeholder=\"请输入商品库存\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addSellPoint\" class=\"col-sm-3 col-form-label\">商品卖点</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"addSellPoint\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"sellPoint\" placeholder=\"请输入商品卖点\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t  <div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addBarcode\" class=\"col-sm-3 col-form-label\">商品条形码</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"addBarcode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"barcode\" placeholder=\"请输入商品条形码\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"addImage1\" class=\"col-sm-3 col-form-label\">商品图标</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"file\" class=\"form-control\" id=\"addImage1\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"file\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<img alt=\"商品图标\" id=\"addImage2\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t   \t<input type=\"button\" class=\"btn btn-info\" value=\"增加下来选中规格及选项内容\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonclick=\"addSpecAndSpecOption()\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"addSkuSpecId\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t  <option value=\"\">请选择规格</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\"  onclick=\"clearAddSku()\">关闭</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"addButton\" onclick=\"addSku()\">添加</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.modal-content -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.modal -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ///////////////////添加模态框结束//////////////////////////// -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t $('.page-link').click(function (e) {\r\n");
      out.write("\t\t  \t\r\n");
      out.write("\t  \t  //获取点击的的url\r\n");
      out.write("\t      var url = $(this).attr('data');\r\n");
      out.write("\t       // console.log(url);\r\n");
      out.write("\t       //在中间区域显示地址的内容\r\n");
      out.write("\t       location=url;\r\n");
      out.write("\t  });\r\n");
      out.write("\tfunction preAddSku(){\r\n");
      out.write("\t\tclearAddSku();\r\n");
      out.write("\t\t//追加商品\r\n");
      out.write(" \t\t$.post(\"/Spu/spus\", {},function(data) {\r\n");
      out.write("        \t//遍历数据\r\n");
      out.write("        \tfor(var i in data){\r\n");
      out.write("            \t$(\"#addSpuId\").append(\"<option value='\"+data[i].id+\"'>\"+data[i].goodsName+\"</option>\");\r\n");
      out.write("        \t}\r\n");
      out.write("\t\t},\"json\");\r\n");
      out.write("\r\n");
      out.write("    \t//追加规格\r\n");
      out.write("\t\t$.post(\"/Spec/specs\", {},function(data) {\r\n");
      out.write("        \t//遍历数据\r\n");
      out.write("        \tfor(var i in data){\r\n");
      out.write("            \t$(\"#addSkuSpecId\").append(\"<option value='\"+data[i].id+\"'>\"+data[i].specName+\"</option>\");\r\n");
      out.write("         \t}\r\n");
      out.write("\t\t},\"json\");\r\n");
      out.write("   }\r\n");
      out.write("\t\r\n");
      out.write("\tvar ii=0;\r\n");
      out.write("    function addSpecAndSpecOption(){\r\n");
      out.write("        //规格的specId\r\n");
      out.write("        var specId = $(\"#addSkuSpecId option:selected\").val();\r\n");
      out.write("        //查询出规格对应的规格选项\r\n");
      out.write("        $.post('/Spec/getSpecById',{id:specId},function(spec){\r\n");
      out.write("            if(spec!=null && spec.options!=null && spec.options.length>0){\r\n");
      out.write("               //定义拼接的字符串\r\n");
      out.write("               var options='';\r\n");
      out.write("               //遍历规格选项\r\n");
      out.write("               for(var i in spec.options){\r\n");
      out.write("                   options+='<option value=\"'+spec.options[i].id+'\">'+spec.options[i].optionName+'</option>';\r\n");
      out.write("               }\r\n");
      out.write("               //创建div对象\r\n");
      out.write("               var str = '<div class=\"form-group row specOptionDiv\"><label class=\"col-sm-3 col-form-label\">'+spec.specName+'</label><input type=\"hidden\" name=\"skuSpec['+ii+'].specId\" value=\"'+spec.id+'\"/><div class=\"col-sm-9\"><select name=\"skuSpec['+ii+'].specOptionId\" class=\"form-control\"><option value=\"0\">请选择'+spec.specName+'项</option>'+options+'</select></div></div>';\r\n");
      out.write("               //加入到指定的form中\r\n");
      out.write("               $(\"#modalForm\").append(str);\r\n");
      out.write("               ii++;\r\n");
      out.write("            }else{\r\n");
      out.write("               alert(\"你的规格没有规格选项\");\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        },'json');\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addSku(){\r\n");
      out.write("\t\tvar formData = new FormData($('#modalForm')[0]);\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("            type:'post',\r\n");
      out.write("            data:formData,\r\n");
      out.write("            url:'/Sku/skuAdd',\r\n");
      out.write("\t\t\tprocessData : false, // 告诉jQuery不要去处理发送的数据\r\n");
      out.write("\t\t\tcontentType : false, // 告诉jQuery不要去设置Content-Type请求头\r\n");
      out.write("\t\t\tdataType:'json',\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("               \tif(data){\r\n");
      out.write("\t               \t//关闭模态框\r\n");
      out.write("\t               \t$('#myModal').modal('hide')\r\n");
      out.write("            \t\twindow.location.reload();\r\n");
      out.write("               \t}else{\r\n");
      out.write("               \t\talert(\"sku添加失败\");\r\n");
      out.write("               \t}\r\n");
      out.write(" \t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction clearAddSku(){\r\n");
      out.write("\t\t$('#addId').val('');\r\n");
      out.write("\t\t$('#addImage').val('');\r\n");
      out.write("\t\t$('#addImage2').prop('src','');\r\n");
      out.write("\t\t$('#addTitle').val('');\r\n");
      out.write("\t\t$('#addSellPoint').val('');\r\n");
      out.write("\t\t$('#addPrice').val('');\r\n");
      out.write("\t\t$('#addCostPrice').val('');\r\n");
      out.write("\t\t$('#addMarketPrice').val('');\r\n");
      out.write("\t\t$('#addStockCount').val('');\r\n");
      out.write("\t\t$('#addBarcode').val('');\r\n");
      out.write("\t\t$('#addStatus').val('');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#addButton').show();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#modalForm input').prop('readonly', false);\r\n");
      out.write("\t\t$('#modalForm input').prop('disabled',false);\r\n");
      out.write("\t\t$('#modalForm select').prop('disabled', false);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('.specOptionDiv').remove();\r\n");
      out.write("\t\t$(\"#addSpuId\").html('<option value=\"\">请选择商品</option>');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#addSkuSpecId\").html('<option value=\"\">请选择规格</option>');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tii = 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getSkuById(id,flag){\r\n");
      out.write("    \t\tpreAddSku();\r\n");
      out.write("    \t\t$.post('/Sku/getSkuById',{id:id},function(data){\r\n");
      out.write("    \t\t\tvar sku = data.sku;\r\n");
      out.write("    \t\t\tvar specs = data.specs;\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\t//1.规格参数div展示\r\n");
      out.write("    \t\t\tfor(var i in specs){\r\n");
      out.write("\t            \t//var spec = specs[i].specs.split(':');\r\n");
      out.write("\t            \tvar spec = specs[i];\r\n");
      out.write("\t            \t//var optionArr = specs[i].options.split(',');\r\n");
      out.write("\t            \tvar optionArr = spec.options;\r\n");
      out.write("                   \tvar options = '';\r\n");
      out.write("\t            \tfor(var j in optionArr){\r\n");
      out.write("                   \t\t//var option = optionArr[j].split(':');\r\n");
      out.write("                   \t\tvar option = optionArr[j];\r\n");
      out.write("                   \t\t//options += '<option value=\"'+option[0]+'\">'+option[1]+'</option>';\r\n");
      out.write("                   \t\toptions += '<option value=\"'+option.id+'\">'+option.optionName+'</option>';\r\n");
      out.write("\t            \t}\r\n");
      out.write("                    //var str = '<div class=\"form-group row specOptionDiv\"><label class=\"col-sm-3 col-form-label\">'+spec[1]+'</label><input type=\"hidden\" name=\"skuSpec['+ii+'].specId\" value=\"'+spec[0]+'\"/><div class=\"col-sm-9\"><select id=\"specOptionId' + ii + '\" name=\"skuSpec['+ii+'].specOptionId\" class=\"form-control\"><option value=\"0\">请选择'+spec[1]+'项</option>'+options+'</select></div></div>';\r\n");
      out.write("                    var str = '<div class=\"form-group row specOptionDiv\"><label class=\"col-sm-3 col-form-label\">'+spec.specName+'</label><input type=\"hidden\" name=\"skuSpec['+ii+'].specId\" value=\"'+spec.id+'\"/><div class=\"col-sm-9\"><select id=\"specOptionId' + ii + '\" name=\"skuSpec['+ii+'].specOptionId\" class=\"form-control\"><option value=\"0\">请选择'+spec.specName+'项</option>'+options+'</select></div></div>';\r\n");
      out.write("                    $(\"#modalForm\").append(str);\r\n");
      out.write("                \t\r\n");
      out.write("                    //1.2.将各个规格参数选项进行默认值选中\r\n");
      out.write("                \tvar specs1 = sku.skuSpec;    \t\t\t\r\n");
      out.write("    \t\t\t\tfor(var k in specs1){\r\n");
      out.write("    \t\t\t\t\t//if(specs1[k].specId==spec[0]){\r\n");
      out.write("    \t\t\t\t\t//1.2.1.如果规格参数选项是当前sku关联的spec_id，option处于选中状态\r\n");
      out.write("    \t\t\t\t\tif(specs1[k].specId==spec.id){\t\r\n");
      out.write("    \t\t\t\t\t\t$('#specOptionId' + ii + ' option[value=' + specs1[k].specOptionId + ']').prop('selected',true);\r\n");
      out.write("    \t\t\t\t\t\tbreak;\r\n");
      out.write("    \t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t}\t\r\n");
      out.write("    \t\t\t\tii++;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("    \t\t\t//2.sku信息展示\r\n");
      out.write("    \t\t\t$('#addId').val(sku.id);\r\n");
      out.write("    \t\t\t$('#addImage').val(sku.image);\r\n");
      out.write("    \t\t\t$('#addImage2').prop('src','pic/' + sku.image);\r\n");
      out.write("    \t\t\t$('#addTitle').val(sku.title);\r\n");
      out.write("    \t\t\t$('#addSellPoint').val(sku.sellPoint);\r\n");
      out.write("    \t\t\t$('#addPrice').val(sku.price);\r\n");
      out.write("    \t\t\t$('#addCostPrice').val(sku.costPrice);\r\n");
      out.write("    \t\t\t$('#addMarketPrice').val(sku.marketPrice);\r\n");
      out.write("    \t\t\t$('#addSpuId option[value=' + sku.spuId + ']').prop('selected', true);\r\n");
      out.write("    \t\t\t$('#addStockCount').val(sku.stockCount);\r\n");
      out.write("    \t\t\t$('#addBarcode').val(sku.barcode);\r\n");
      out.write("    \t\t\t$('#addStatus').val(sku.status);\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\tif(flag == 1){\r\n");
      out.write("    \t\t\t\t$('#skuAddModalLabel').text('编辑sku');\r\n");
      out.write("    \t\t\t}else{\r\n");
      out.write("    \t\t\t\t$('#skuAddModalLabel').text('查看sku');\r\n");
      out.write("    \t\t\t\t$('#addButton').hide();\r\n");
      out.write("    \t\t\t\t$('#modalForm input').prop('readonly',true);\r\n");
      out.write("    \t\t\t\t$('#modalForm input').prop('disabled',true);\r\n");
      out.write("    \t\t\t\t$('#modalForm select').prop('disabled', true);\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t},'json');\r\n");
      out.write("    \t}\r\n");
      out.write("    \t$(function(){\r\n");
      out.write("    \t\t$('#cbk').on('click',function(){\r\n");
      out.write("    \t\t\t$('.ck').prop('checked', this.checked);\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t})\r\n");
      out.write("    \tfunction deleteSku(ids){\r\n");
      out.write("    \t\tif(ids==undefined){\r\n");
      out.write("    \t\t\tids = $('.ck:checked').map(function(){\r\n");
      out.write("    \t\t\t\treturn this.value;\r\n");
      out.write("    \t\t\t}).get().join(',');\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tif(ids!=''){\r\n");
      out.write("    \t\t\tif(confirm('确定要删除选中的数据吗?')){\r\n");
      out.write("    \t\t\t\t$.post('/Sku/skuDelete',{ids:ids},function(data){\r\n");
      out.write("    \t    \t\t\tif(data){\r\n");
      out.write("    \t    \t\t\t\twindow.location.reload();\r\n");
      out.write("    \t    \t\t\t}else{\r\n");
      out.write("    \t    \t\t\t\talert('删除sku失败');\r\n");
      out.write("    \t    \t\t\t}\r\n");
      out.write("    \t    \t\t},'json');\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t}else{\r\n");
      out.write("    \t\t\talert('请选中要删除的数据');\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/view/sku/sku_list.jsp(66,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/sku/sku_list.jsp(66,8) '${pageInfo.list}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageInfo.list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/view/sku/sku_list.jsp(66,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("sku");
      // /WEB-INF/view/sku/sku_list.jsp(66,8) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("index");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td scope=\"row\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"ck\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"/>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${index.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<img width=\"40px\" height=\"40px\" src=\"pic/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"/>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.status==0 ? '上架' : '下架' }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.stockCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"deleteSku()\" class=\"btn btn-info\">删除</a>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-info btn-sm\" data-toggle=\"modal\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tdata-target=\"#skuAddModal\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"getSkuById(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(",1)\">修改</button>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-primary btn-sm\" data-toggle=\"modal\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tdata-target=\"#skuAddModal\"\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"getSkuById(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sku.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(",2)\">详情</button></td>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
