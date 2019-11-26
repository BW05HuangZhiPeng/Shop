<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登陆</title>
		<!--用百度的静态资源库的cdn安装bootstrap环境-->
		<!-- Bootstrap 核心 CSS 文件 -->
		<link href="/resource/css/bootstrap.css" rel="stylesheet">
		<!-- <!--font-awesome 核心我CSS 文件-->
		<!-- <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">  -->
		<!-- 在bootstrap.min.js 之前引入 -->
		<script src="/resource/jquery/jquery-3.4.1.js"></script>
		<!-- Bootstrap 核心 JavaScript 文件 -->
		<script src="/resource/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<style type="text/css">
			body{background: url(/pic/400.jpg) no-repeat;background-size:cover;font-size: 16px;}
			.form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
			#login_form{display: block;}
			#register_form{display: none;}
			.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
			input[type="text"],input[type="password"]{padding-left:26px;}
			.checkbox{padding-left:21px;}
		</style>
	</head>
	<body>
		<!--
			基础知识：
			网格系统:通过行和列布局
			行必须放在container内
			手机用col-xs-*
			平板用col-sm-*
			笔记本或普通台式电脑用col-md-*
			大型设备台式电脑用col-lg-*
			为了兼容多个设备，可以用多个col-*-*来控制；
		-->
	<div class="container">
		<div class="form row">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3" action="/user/login" method="post">
				<h1 class="form-title">豪歌商城</h1>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i>
						<input class="form-control required" type="text" placeholder="请输入用户名" name="name" value="${user.name}" autofocus="autofocus" maxlength="20"/>
					</div>
					<div class="form-group">
							<i class="fa fa-lock fa-lg"></i>
							<input class="form-control required" type="password" placeholder="请输入密码" name="password" value="${user.password}"  maxlength="8"/>
					</div>
					<samp style="color:red">${error}</samp>
					<div class="form-group">
						<label class="checkbox">
							<input type="checkbox" name="remember" value="1"/>记住密码
						</label>
						<hr />
						<a href="/user/register" id="register_btn" class="">注册账号</a>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="登录"/>   
					</div>
				</div>
			</form>
		</div>
		</div>
		
	<script type="text/javascript">
  
	
	</script>
	</body>
</html>