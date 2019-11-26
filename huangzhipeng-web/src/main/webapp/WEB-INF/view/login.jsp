<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<jsp:include page="common.jsp"/>
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
								<form class="main-form full">
									<div class="row">
										<div class="col-12 mb-20">
											<div class="heading-part heading-bg">
												<h2 class="heading">Customer Login</h2>
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="login-email">Email address</label> <input
													id="login-email" type="email" required
													placeholder="Email Address">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="login-pass">Password</label> <input
													id="login-pass" type="password" required
													placeholder="Enter your Password">
											</div>
										</div>
										<div class="col-12">
											<div class="check-box left-side">
												<span> <input type="checkbox" name="remember_me"
													id="remember_me" class="checkbox"> <label
													for="remember_me">Remember Me</label>
												</span>
											</div>
											<button name="submit" type="submit"
												class="btn-color right-side">Log In</button>
										</div>
										<div class="col-12">
											<a title="Forgot Password" class="forgot-password mtb-20"
												href="#">Forgot your password?</a>
											<hr>
										</div>
										<div class="col-12">
											<div class="new-account align-center mt-20">
												<span>New to Shopholic?</span> <a class="link"
													title="Register with Shopholic" href="register.html">Create
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