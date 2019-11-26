<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>豪歌后台管理系统</title>

	<!-- Bootstrap core CSS -->
    <link href="/resource/css/bootstrap.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="/resource/css/dashboard.css" rel="stylesheet">
    <link href="/resource/css/font-awesome.min.css" rel="stylesheet">
    <script src="/resource/jquery/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js" ></script>
<style>
    	
    	img{
    		width:30px;
    		height: 30px;
    		border-radius: 100%;
    		
    	}
			.sidebar-open-button{
    			font-size: 20px;
    			padding-top: 10px;
    			color: #76747A;
    			text-align: center;
    			float: left;
    		}
    		.nav-sidebar > .active > a,
				.nav-sidebar > .active > a:hover,
				.nav-sidebar > .active > a:focus {
				  color: #fff;
				  background-color: darkgray;
				}
    </style>
    <script>
    	$(function(){
    		var marginLeft = $(".main").css("marginLeft");
    		$(".sidebar-open-button").on("click",function(){
	    		if($(".sidebar").hasClass("hidden")){
	    			//将左边显示
	    			$(".sidebar").removeClass("hidden");
	    			$(".main").css("margin-left", marginLeft);
	    		}else{
	    			//将左边隐藏
	    			$(".sidebar").addClass("hidden");
	    			$(".main").css("margin-left", "0");
	    		}
	    	});
    		$(".nav-sidebar li").click(function(){
    	    	  $(".nav-sidebar li").removeClass("active");
    	    	  $(this).addClass("active");
    	      })
    	})
    	
    	
    </script>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="col-md-2 navbar-header" >
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">HgShop后台</a>
        </div>
    
    		<a href="#" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
    
    		<div class="dropdown navbar-right" style="padding-top:10px;">
  				<a id="dLabel" data-toggle="dropdown" style="color: white;">
    				<!-- 登录的头像 -->
         		<img src="/pic/8.jpg" alt="img">
         		<!-- 用户名称 -->
         		<b>${userinfo.name}</b>
   					<span class="caret"></span>
  				</a>
				  <ul class="dropdown-menu">
				    <li class="dropdown-header">个人操作</li>
				    <li role="separator" class="divider"></li>
				    <li><a href="/user/login">切换账号</a></li>
				    <li><a href="/user/loginout">注销</a></li>
				  </ul>
				</div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active" ><a href="/admin/towelcome" style="color:black" target="mainFrame">首页</a></li>
            <li><a href="/Brand/tobrand_list" style="color:black" target="mainFrame">品牌管理</a></li>
            <li><a href="/Category/categoryList" style="color:black"  target="mainFrame">分类管理</a></li>
            <li><a href="/Spec/specList" style="color:black"  target="mainFrame">规格参数管理</a></li>
            <li><a href="/Spu/showCategoryTree" style="color:black" target="mainFrame">spu管理</a></li>
            <li><a href="/Sku/skuList" style="color:black" target="mainFrame">sku管理</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="height:600px">
          <iframe width="100%" height="100%" name="mainFrame" src="/admin/towelcome" frameborder="0"></iframe>
</div>
      </div>
    </div>
</body>
</html>