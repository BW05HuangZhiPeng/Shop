<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<jsp:include page="common.jsp"/>
	<script>
	function decrement(i){
		var qty = $("#qty"+i).val();
		if(!isNaN(qty) && qty>1){
			qty--;
		}
		$("#qty"+i).val(qty);
		var price = $("#price" + i).text();
		$("#subPrice" + i).text(Math.round(parseFloat(price)*parseInt(qty)*100)/100);	
	}
	function increment(i){
		var qty = $("#qty"+i).val();
		if(!isNaN(qty)){
			qty++;
		}
		$("#qty"+i).val(qty);
		var price = $("#price" + i).text();
		$("#subPrice" + i).text(Math.round(parseFloat(price)*parseInt(qty)*100)/100);	
	}
	function decrement2(i,skuId){
		var qty = $("#qty"+i).val();
		if(!isNaN(qty) && qty>1){
			qty--;
		}
		$.post("cartUpdate2?skuId="+skuId+"&num="+qty,function(res){
			if (res) {
				window.location.reload();
			}
		});
	}
	function increment2(i,skuId){
		var qty = $("#qty"+i).val();
		if(!isNaN(qty)){
			qty++;
		}
		$.post("cartUpdate2?skuId="+skuId+"&num="+qty,function(res){
			if (res) {
				window.location.reload();
			}
		});
	
	}
	
	
	 function conshop(){
		 window.location.href="http://localhost:8080";
	}  
	 function order(){
		 window.location.href="http://localhost:8700/checkOut";
		 
	 }
	</script>
</head>
<body class="homepage">
	<div class="main">
<!-- HEADER START -->
<header class="navbar navbar-custom container-full-sm" id="header">
	<div class="header-top">
		<div class="container">
			<div class="row m-0">
				<div class="col-12 col-md-12 col-sm-7 p-0">
					<div class="top-right-link right-side d-none d-sm-block">
						<ul>
							<li class="info-link wishlist-icon content"><a
								href="wishlist.html" title="Wishlist"> <span></span> Wish
									List
							</a></li>
							<li class="info-link compare-icon"><a href="compare.html"
								title="Compare"> <span></span> Compare
							</a></li>
							<li class="info-link giftcard-icon"><a href="#"
								title="Gift card"> <span></span> Gift card
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="header-middle">
		<div class="container">
			<div class="row mlr_-20">
				<div class="col-md-3 col-sm-12 plr-20">
					<div class="header-middle-left">
						<div class="navbar-header float-none-sm">
							<a class="navbar-brand page-scroll" href="index.html"> <img
								alt="Shopholic" src="images/logo.png">
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-9 col-sm-12 plr-20">
					<div class="row">
						<div class="col-12">
							<div class="main-right-part">
								<div class="header-right-part">
									<div class="category-main">
										<div class="main-search">
											<div class="header_search_toggle desktop-view">
												<form method="post" action="shop">
													<div class="search-box">
														<input class="input-text" type="text" name="keyword"
															placeholder="Search entire store here..." value="${sku.title}">
														<button class="search-btn" type="submit"></button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
								<div class="right-part">
									<ul>
										<li class="login-icon content"><a class="content-link">
												<span class="content-icon"></span>
										</a>
											<div class="content-dropdown">
												<ul>
													<li class="login-icon"><a href="http://localhost:9090/login.html"
														title="Login"><i class="fa fa-user"></i> Login</a></li>
													<li class="register-icon"><a href="http://localhost:9090/register.html"
														title="Register"><i class="fa fa-user-plus"></i>
															Register</a></li>
												</ul>
											</div></li>
										<li class="cart-icon cart-box-main"><a href="#"> <span
												class="cart-icon-main"> <small
													class="cart-notification">0</small>
											</span>
												<div class="my-cart">
													My cart<br>$99.00
												</div>
										</a>
											<div class="cart-dropdown header-link-dropdown">
												<ul class="cart-list link-dropdown-list">
													<li><a class="close-cart"><i
															class="fa fa-times-circle"></i></a>
														<div class="media">
															<a class="pull-left"> <img alt="Shopholic"
																src="images/1.jpg"></a>
															<div class="media-body">
																<span><a href="#">Black African Print Skirt</a></span>
																<p class="cart-price">$14.99</p>
																<div class="product-qty">
																	<label>Qty:</label>
																	<div class="custom-qty">
																		<input type="text" name="qty" maxlength="8" value="1"
																			title="Qty" class="input-text qty">
																	</div>
																</div>
															</div>
														</div></li>
													<li><a class="close-cart"><i
															class="fa fa-times-circle"></i></a>
														<div class="media">
															<a class="pull-left"> <img alt="Shopholic"
																src="images/2.jpg"></a>
															<div class="media-body">
																<span><a href="#">Black African Print Skirt</a></span>
																<p class="cart-price">$14.99</p>
																<div class="product-qty">
																	<label>Qty:</label>
																	<div class="custom-qty">
																		<input type="text" name="qty" maxlength="8" value="1"
																			title="Qty" class="input-text qty">
																	</div>
																</div>
															</div>
														</div></li>
												</ul>
												<p class="cart-sub-totle">
													<span class="pull-left">Cart Subtotal</span> <span
														class="pull-right"><strong class="price-box">$29.98</strong></span>
												</p>
												<div class="clearfix"></div>
												<div class="mt-20">
													<a href="cart.html" class="btn-color btn">Cart</a> <a
														href="checkout.html" class="btn-color btn right-side">Checkout</a>
												</div>
											</div></li>
										<li class="side-toggle">
											<button data-target=".navbar-collapse" data-toggle="collapse"
												class="navbar-toggle" type="button">
												<i class="fa fa-bars"></i>
											</button>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="container">
			<div class="header-line">
				<div class="row position-r mlr_-20">
					<div class="col-lg-3 plr-20 bottom-part position-initial">
						<div class="sidebar-menu-dropdown home">
							<a class="btn-sidebar-menu-dropdown"> Categories <i
								class="fa fa-bars"></i></a>
							<div id="cat" class="cat-dropdown">
								<div class="sidebar-contant">
									<div id="menu" class="navbar-collapse collapse">
										<ul class="nav navbar-nav ">
											<c:forEach items="${navCategories}" var="category">
												<li class="level">
													<a href="shop.html" class="page-scroll"> <i class="fa fa-desktop"></i>${category.name }</a>
													<c:if test="${!empty category.childs}">
														<div class="megamenu mobile-sub-menu"
															style="width: 430px;">
															<div class="megamenu-inner-top">
																<ul class="sub-menu-level1">
																	<c:forEach items="${category.childs}" var="secondCategory">
																		<li class="level3">
																			<a href="shop.html"><span>■</span>${secondCategory.name }></a>
																			<c:forEach items="${secondCategory.childs}" var="threeCategory">
																				<a href="shop.html">${threeCategory.name }</a>
																			</c:forEach>
																		</li>
																	</c:forEach>
																</ul>
															</div>
														</div>	
													</c:if>
											</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9 plr-20 bottom-part">
				<div class="nav_sec position-r float-none-md">
					<div class="mobilemenu-title mobilemenu">
						<span>Menu</span> <i class="fa fa-bars pull-right"></i>
					</div>
					<div class="mobilemenu-content">
						<ul class="nav navbar-nav" id="menu-main">
							<li><a href="index.html"><span>Home</span></a></li>
							<li class="level dropdown "><span class="opener plus"></span>
								<a href="shop.html"><span>Shop</span></a>
								<div class="megamenu mobile-sub-menu">
									<div class="megamenu-inner-top">
										<ul class="sub-menu-level1">
											<li class="level2">
												<ul class="sub-menu-level2 ">
													<li class="level3"><a href="shop.html"><span>■</span>Shop</a></li>
													<li class="level3"><a href="shop_2.html"><span>■</span>Shop
															2</a></li>
												</ul>
											</li>
										</ul>
									</div>
								</div></li>
							<li><a href="about.html"><span>About Us</span></a></li>
							<li class="level dropdown"><span class="opener plus"></span>
								<a href="blog.html"><span>Blog</span></a>
								<div class="megamenu mobile-sub-menu">
									<div class="megamenu-inner-top">
										<ul class="sub-menu-level1">
											<li class="level2">
												<ul class="sub-menu-level2 ">
													<li class="level3"><a href="blog.html"><span>■</span>Blog</a></li>
													<li class="level3"><a href="blog_2.html"><span>■</span>Blog
															2</a></li>
													<li class="level3"><a href="single-blog.html"><span>■</span>Single
															Blog</a></li>
												</ul>
											</li>
										</ul>
									</div>
								</div></li>
							<li><a href="contact.html"><span>Contact</span></a></li>
							<li class="level dropdown "><span class="opener plus"></span>
								<a href="#" class="page-scroll"><span>Pages</span></a>
								<div class="megamenu mobile-sub-menu">
									<div class="megamenu-inner-top">
										<ul class="sub-menu-level1">
											<li class="level2">
												<ul class="sub-menu-level2 ">
													<li class="level3"><a href="account.html"><span>■</span>Account</a></li>
													<li class="level3"><a href="checkout.html"><span>■</span>Checkout</a></li>
													<li class="level3"><a href="compare.html"><span>■</span>Compare</a></li>
													<li class="level3"><a href="wishlist.html"><span>■</span>Wishlist</a></li>
													<li class="level3"><a href="404.html"><span>■</span>404
															Error</a></li>
													<li class="level3"><a href="faq.html"><span>■</span>Faq</a></li>
													<li class="level3"><a href="product-page.html"><span>■</span>product-page</a></li>
													<li class="level3"><a href="product-page_2.html"><span>■</span>product-page
															2</a></li>
													<li class="level3"><a href="product-page_3.html"><span>■</span>product-page
															3</a></li>
												</ul>
											</li>
										</ul>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</header>
<!-- HEADER END -->

		<!-- Bread Crumb STRAT -->
		<div class="banner inner-banner1">
			<div class="container">
				<section class="banner-detail center-xs">
					<h1 class="banner-title">Shopping Cart</h1>
					<div class="bread-crumb right-side float-none-xs">
						<ul>
							<li><a href="index.html"><i class="fa fa-home"></i>Home</a>/</li>
							<li><span>Shopping Cart</span></li>
						</ul>
					</div>
				</section>
			</div>
		</div>
		<!-- Bread Crumb END -->

		<!-- CONTAIN START -->
		<section class="ptb-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="cart-item-table commun-table">
							<div class="table-responsive">
								<table class="table" id="cart-table">
									<thead>
										<tr>
											<th>商品图片</th>
											<th>商品名称</th>
											<th>价格</th>
											<th>数量</th>
											<th>小计</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${cartList}" var="cart" varStatus="index">
										<tr>
										<td><input type="hidden" class="skuId" value="${cart.skuid }"/></td>
											<td><a href="http://localhost:8080/page?id=${cart.skuid }"><div class="product-image"><img alt="Shopholic" src="pic/${cart.image}"></div></a></td>
											<td><div class="product-title"><a href="http://localhost:8080/page?id=${cart.skuid }"><span>${cart.title}</span></a></div></td>
											<td><ul><li><div class="base-price price-box"><span class="price" id="price${index.count}">${cart.price}</span></div></li></ul></td>
											<td><div class="input-box select-dropdown"><fieldset>
											<div class="custom-qty">
											<button onclick="decrement2(${index.count},${cart.skuid});" class="reduced items" type="button"><i class="fa fa-minus"></i></button>
											<input type="text" class="input-text qty" title="Qty" value="${cart.pnum }" maxlength="8" id="qty${index.count}" name="qty">
											<button onclick="increment2(${index.count},${cart.skuid});" class="increase items" type="button"><i class="fa fa-plus"></i></button>
											</div>
											</fieldset></div></td>
											<td><div class="total-price price-box"><span class="sumprice" id="subPrice${index.count}">${cart.subPrice}</span></div></td>											
											<td><a href="cartDelete2?skuId=${cart.skuid}"><i title="Remove Item From Cart" data-id="100" class="fa fa-trash cart-remove-item"></i></a></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="mb-30">
					<div class="row">
						<div class="col-md-6">
							<div class="mt-30">
								<a href="javascript:void(0)" class="btn btn-color" onclick="conshop()"><span><i
										class="fa fa-angle-left"></i></span> Continue Shopping
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="mt-30 right-side float-none-xs">
								<a class="btn btn-color">Update Cart</a>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="mtb-30">
					<div class="row">
						<div class="col-md-6 mb-xs-40">
							<div class="estimate">
								<div class="heading-part mb-20">
									<h3 class="sub-heading">Estimate shipping and tax</h3>
								</div>
								<form class="full">
									<div class="row">
										<div class="col-md-12">
											<div class="input-box select-dropdown mb-20">
												<fieldset>
													<select id="country_id" class="option-drop">
														<option selected="" value="">Select Country</option>
														<option value="1">India</option>
														<option value="2">China</option>
														<option value="3">Pakistan</option>
													</select>
												</fieldset>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input-box select-dropdown mb-20">
												<fieldset>
													<select id="state_id" class="option-drop">
														<option selected="" value="1">Select
															State/Province</option>
														<option value="2">---</option>
													</select>
												</fieldset>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input-box select-dropdown mb-20">
												<fieldset>
													<select id="city_id" class="option-drop">
														<option selected="" value="1">Select City</option>
														<option value="2">---</option>
													</select>
												</fieldset>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-md-6">
							<div class="cart-total-table commun-table">
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th colspan="2">Cart Total</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Item(s) Subtotal</td>
												<td>
													<div class="price-box">
														<span class="price" id="subTotal">$${totalPrice}</span>
													</div>
												</td>
											</tr>
											<tr>
												<td>Shipping</td>
												<td>
													<div class="price-box">
														<span class="price">$0.00</span>
													</div>
												</td>
											</tr>
											<tr>
												<td><b>Amount Payable</b></td>
												<td>
													<div class="price-box">
														<span class="price" id="totalAmount"><b>$${totalPrice}</b></span>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="mt-30">
					<div class="row">
						<div class="col-12">
							<div class="right-side float-none-xs">
								<a class="btn btn-color" onclick="order()">Proceed to
									checkout <span><i class="fa fa-angle-right"></i></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- CONTAINER END -->

		<div class="footer">
	<div class="copy-right-bg">
		<div class="container">
			<div class="row  align-center">
				<div class="col-12">
					<div class="site-link">
						<ul>
							<li><a href="#">About Us</a>|</li>
							<li><a href="#">Contact Us</a>|</li>
							<li><a href="#">Customer </a>|</li>
							<li><a href="#">Service</a>|</li>
							<li><a href="#">Privacy</a>|</li>
							<li><a href="#">Policy </a>|</li>
							<li><a href="#">Accessibility</a>|</li>
							<li><a href="#">Directory </a></li>
						</ul>
					</div>
				</div>
				<div class="col-12">
					<div class="copy-right ">
						© 2019 All Rights <a href="http://www.bootstrapmb.com/"
							title="bootstrapmb">Reserved</a>. Design By Aaryaweb
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	</div>
</body>
</html>