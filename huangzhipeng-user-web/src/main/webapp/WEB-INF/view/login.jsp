<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<jsp:include page="common.jsp"/>
	<script type="text/javascript">
		$(function(){
			redirectUrl = '${redirectUrl}';
		});
		function login(){
			$.post("/login", $("#loginForm").serialize(),function(data){
				if (data.code == 1000) {
					if (redirectUrl == '') {
						location.href = "http://localhost:8080";
					} else {
						location.href = redirectUrl;
					}
				} else {
					alert("登录失败:" + data.code + "&" + data.msg);
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
					<h1 class="banner-title">Login</h1>
					<div class="bread-crumb right-side float-none-xs">
						<ul>
							<li><a href="index.html"><i class="fa fa-home"></i>Home</a>/</li>
							<li><span>Login</span></li>
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
							<div class="col-xl-6 col-lg-8 col-md-8 ">
								<form class="main-form full" action="javascript:void(0)" id="loginForm">
									<div class="row">
										<div class="col-12 mb-20">
											<div class="heading-part heading-bg">
												<h2 class="heading">Customer Login</h2>
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="login-username">账号</label> <input
													id="login-username" name="name" type="text" required
													placeholder="请输入账号">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="login-pass">密码</label> <input
													id="login-pass" name="password" type="password" required
													placeholder="请输入密码">
											</div>
										</div>
										<div class="col-12">
											<div class="check-box left-side" id="loginForm">
												<span> <input type="checkbox" name="remember_me"
													id="remember_me" class="checkbox"> <label
													for="remember_me">记住我</label>
												</span>
											</div>
											<button name="submit" onclick="login()"
												class="btn-color right-side">登录</button>
										</div>
										<div class="col-12">
											<a title="Forgot Password" class="forgot-password mtb-20"
												href="#">Forgot your password?</a>
											<hr>
										</div>
										<div class="col-12">
											<div class="new-account align-center mt-20">
												<span>New to Shopholic?</span> <a class="link"
													title="Register with Shopholic" href="/toRegister">Create
													New Account</a>
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