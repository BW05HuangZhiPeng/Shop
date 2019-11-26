<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<jsp:include page="common.jsp"/>
	<script>
		function register(){
			$.ajax({
				url: "check",
				data: {"param":$("#username").val(),"type":1},
				success: function(data){
					if(!data){
						$.ajax({
							url: "check",
							data: {"param":$("#email").val(),"type":2},
							success: function(data){
								if(!data){
									$.ajax({
										url: "check",
										data: {"param":$("#telephone").val(),"type":3},
										success: function(data){
											if(!data){
												$.post("/register",$("#registerForm").serialize(), function(data){
													if(data){
														window.location.href="toLogin";
													} else {
														alert("注册失败");
													}
												});
											}else{
												alert("手机号已存在");
											}
										}	
									});
								}else{
									alert("邮箱已存在");
								}
							}
						});		
					}else{
						alert("用户名已存在");
					}
				}
			});
		}
	</script>
</head>
<body class="homepage">
	<div class="main">
		<jsp:include page="header.jsp"/>

		<!-- Bread Crumb STRAT -->
		<div class="banner inner-banner1">
			<div class="container">
				<section class="banner-detail center-xs">
					<h1 class="banner-title">Register</h1>
					<div class="bread-crumb right-side float-none-xs">
						<ul>
							<li><a href="index.html"><i class="fa fa-home"></i>Home</a>/</li>
							<li><span>Register</span></li>
						</ul>
					</div>
				</section>
			</div>
		</div>
		<!-- Bread Crumb END -->

		<!-- CONTAIN START -->
		<section class="checkout-section ptb-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="row justify-content-center">
							<div class="col-xl-8 col-lg-8 col-md-8 ">
								<form class="main-form full" id="registerForm" action="javascript:void(0)">
									<div class="row">
										<div class="col-12 mb-20">
											<div class="heading-part heading-bg">
												<h2 class="heading">Create your account</h2>
											</div>
										</div>
										<div class="col-12">
											<div class="heading-part line-bottom ">
												<h2 class="form-title heading">Your Personal Details</h2>
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="username">用户名</label> 
												<input type="text" id="username" name="username" required placeholder="请输入用户名">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="password">密码</label> 
												<input type="password" id="password" name="password" required placeholder="请输入密码">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="name">昵称</label> 
												<input type="text" id="name" name="name" required placeholder="请输入昵称">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="email">邮箱</label> 
												<input type="email" id="email" name="email" required placeholder="请输入邮箱">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="telephone">手机号</label> 
												<input type="tel" id="telephone" name="telephone" required placeholder="请输入手机号">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="birthday">生日</label> 
												<input type="date" id="birthday" name="birthday" required placeholder="请输入生日">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="sex">性别</label> 
												<input type="radio" class="sex radio" style="min-height:20px;width:10%" name="sex" value="男"/>
												<input type="radio" class="sex radio" style="min-height:20px;width:10%" name="sex" value="女"/>
											</div>
										</div>
										<div class="col-12">
											<div class="check-box left-side mb-20">
												<span> <input type="checkbox" name="remember_me"
													id="remember_me" class="checkbox"> <label
													for="remember_me">记住我</label>
												</span>
											</div>
											<button name="submit" onclick="register();"
												class="btn-color right-side">注册</button>
										</div>
										<div class="col-12">
											<hr>
											<div class="new-account align-center mt-20">
												<span>Already have an account with us</span> <a class="link"
													title="Register with Shopholic" href="login.html">Login
													Here</a>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- CONTAINER END -->

		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>