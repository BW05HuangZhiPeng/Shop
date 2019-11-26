﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
								<form class="main-form full">
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
												<label for="f-name">First Name</label> <input type="text"
													id="f-name" required placeholder="First Name">
											</div>
										</div>
										<div class="col-12">
											<div class="input-box">
												<label for="l-name">Last Name</label> <input type="text"
													id="l-name" required placeholder="Last Name">
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
												<label for="telephone">Telephone</label> <input
													id="telephone" type="email" required
													placeholder="Telephone">
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
											<div class="input-box">
												<label for="re-enter-pass">Re-enter Password</label> <input
													id="re-enter-pass" type="password" required
													placeholder="Re-enter your Password">
											</div>
										</div>
										<div class="col-12">
											<div class="check-box left-side mb-20">
												<span> <input type="checkbox" name="remember_me"
													id="remember_me" class="checkbox"> <label
													for="remember_me">Remember Me</label>
												</span>
											</div>
											<button name="submit" type="submit"
												class="btn-color right-side">Submit</button>
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