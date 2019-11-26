<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- HEADER START -->
<header class="navbar navbar-custom container-full-sm" id="header">
	<div class="header-top">
		<div class="container">
			<div class="row m-0">
				<div class="col-12 col-md-12 col-sm-7 p-0">
					<div class="top-right-link right-side d-none d-sm-block" id="loginbar">
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
													<li class="login-icon">
														<a href="http://localhost:8090/toLogin" title="Login"><i class="fa fa-user"></i> 登录</a>
													</li>
													<li class="register-icon"><a href="http://localhost:8090/toRegister"
														title="Register"><i class="fa fa-user-plus"></i>
															注册</a></li>
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


	<div class="popup-links">
      <div class="popup-links-inner">
        <ul>
          <li class="categories">
            <a class="popup-with-form" href="#categories_popup"><span class="icon"></span><span class="icon-text">Categories</span></a>
          </li>
          <li class="cart-icon">
            <a class="popup-with-form" href="#cart_popup"><span class="icon"></span><span class="icon-text">Cart</span></a>
          </li>
          <li class="account">
            <a class="popup-with-form" href="#account_popup"><span class="icon"></span><span class="icon-text">Account</span></a>
          </li>
          <li class="search">
            <a class="popup-with-form" href="#search_popup"><span class="icon"></span><span class="icon-text">Search</span></a>
          </li>
          <li class="scroll scrollup">
            <a href="#"><span class="icon"></span><span class="icon-text">Scroll-top</span></a>
          </li>
        </ul>
      </div>
      <div id="popup_containt">
        <div id="categories_popup" class="white-popup-block mfp-hide popup-position">
          <div class="popup-title">
            <h2 class="main_title heading"><span>Categories</span></h2>
          </div>
          <div class="popup-detail">
            <ul class="cate-inner">
              <li class="level sub-megamenu">
                <span class="opener plus"></span>
                <a href="shop.html" class="page-scroll"><i class="fa fa-female"></i>Fashion (10)</a>
                <div class="megamenu  mega-sub-menu">
                  <div class="megamenu-inner-top">
                    <ul class="sub-menu-level1">
                      <li class="level2">
                        <ul class="sub-menu-level2 ">
                          <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Skirts</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Tops</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sleepwear</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Jeans</a></li>
                        </ul>
                      </li>
                    </ul>
                  </div>
                </div>
              </li>
              <li class="level">
                <a href="shop.html" class="page-scroll"><i class="fa fa-camera-retro"></i>Cameras (70)</a>
              </li>
              <li class="level">
                <a href="shop.html" class="page-scroll"><i class="fa fa-desktop"></i>computers (10)</a>
              </li>
              <li class="level sub-megamenu">
                <span class="opener plus"></span>
                <a href="shop.html" class="page-scroll"><i class="fa fa-clock-o"></i>Wathches (15)</a>
                <div class="megamenu mega-sub-menu">
                  <div class="megamenu-inner-top">
                    <ul class="sub-menu-level1">
                      <li class="level2">
                        <ul class="sub-menu-level2">
                          <li class="level3"><a href="shop.html"><span>■</span>Dresses</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sport Jeans</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Skirts</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Tops</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sleepwear</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Jeans</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Phone Cases</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                        </ul>
                      </li>
                    </ul>
                  </div>
                </div>
              </li>
              <li class="level">
                <a href="shop.html" class="page-scroll"><i class="fa fa-shopping-bag"></i>Bags (18)</a>
              </li>
              <li class="level sub-megamenu ">
                <span class="opener plus"></span>
                <a href="shop.html" class="page-scroll"><i class="fa fa-tablet"></i>Smartphones (20)</a>
                <div class="megamenu mega-sub-menu">
                  <div class="megamenu-inner-top">
                    <ul class="sub-menu-level1">
                      <li class="level2">
                        <ul class="sub-menu-level2">
                          <li class="level3"><a href="shop.html"><span>■</span>Dresses</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sport Jeans</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Skirts</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Tops</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sleepwear</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Jeans</a></li>
                        </ul>
                      </li>
                      <li class="level2">
                        <ul class="sub-menu-level2 ">
                          <li class="level3"><a href="shop.html"><span>■</span>Blazer & Coat</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Sport Shoes</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Phone Cases</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Trousers</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Purse</a></li>
                          <li class="level3"><a href="shop.html"><span>■</span>Wallets</a></li>
                        </ul>
                      </li>
                    </ul>
                  </div>
                </div>
              </li>
              <li class="level">
                <a href="shop.html" class="page-scroll"><i class="fa fa-heart"></i>Software</a>
              </li>
              <li class="level "><a href="shop.html" class="page-scroll"><i class="fa fa-headphones"></i>Headphone (12)</a></li>
              <li class="level">
                <a href="shop.html" class="page-scroll"><i class="fa fa-microphone"></i>Accessories (70)</a>
              </li>
              <li class="level"><a href="shop.html" class="page-scroll"><i class="fa fa-bolt"></i>Printers & Ink</a></li>
              <li class="level"><a href="shop.html" class="page-scroll"><i class="fa fa-plus-square"></i>More Categories</a></li>
            </ul>
          </div>  
        </div>
        <div id="cart_popup" class="white-popup-block mfp-hide popup-position">
          <div class="popup-title">
            <h2 class="main_title heading"><span>Cart</span></h2>
          </div>
          <div class="popup-detail">
            <div class="cart-dropdown ">
              <ul class="cart-list link-dropdown-list">
                <li> <a class="close-cart"><i class="fa fa-times-circle"></i></a>
                  <div class="media"> <a class="pull-left"> <img alt="Shopholic" src="images/1.jpg"></a>
                    <div class="media-body"> <span><a href="#">Black African Print Skirt</a></span>
                      <p class="cart-price">$14.99</p>
                      <div class="product-qty">
                        <label>Qty:</label>
                        <div class="custom-qty">
                          <input type="text" name="qty" maxlength="8" value="1" title="Qty" class="input-text qty">
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
                <li> <a class="close-cart"><i class="fa fa-times-circle"></i></a>
                  <div class="media"> <a class="pull-left"> <img alt="Shopholic" src="images/2.jpg"></a>
                    <div class="media-body"> <span><a href="#">Black African Print Skirt</a></span>
                      <p class="cart-price">$14.99</p>
                      <div class="product-qty">
                        <label>Qty:</label>
                        <div class="custom-qty">
                          <input type="text" name="qty" maxlength="8" value="1" title="Qty" class="input-text qty">
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
              <p class="cart-sub-totle"> <span class="pull-left">Cart Subtotal</span> <span class="pull-right"><strong class="price-box">$29.98</strong></span> </p>
              <div class="clearfix"></div>
              <div class="mt-20"> <a href="cart.html" class="btn-color btn">Cart</a> <a href="checkout.html" class="btn-color btn right-side">Checkout</a> </div>
            </div>
          </div>
        </div>
        <div id="account_popup" class="white-popup-block mfp-hide popup-position">
          <div class="popup-title">
            <h2 class="main_title heading"><span>Account</span></h2>
          </div>
          <div class="popup-detail">
            <div class="row">
              <div class="col-lg-4">
                <a href="account.html">
                  <div class="account-inner mb-30">
                    <i class="fa fa-user"></i><br/>
                    <span>Account</span>
                  </div>
                </a>
              </div>
              <div class="col-lg-4">
                <a href="register.html">
                  <div class="account-inner mb-30">
                    <i class="fa fa-user-plus"></i><br/>
                    <span>Register</span>
                  </div>
                </a>
              </div>
              <div class="col-lg-4">
                <a href="cart.html">
                  <div class="account-inner mb-30">
                    <i class="fa fa-shopping-bag"></i><br/>
                    <span>Shopping</span>
                  </div>
                </a>
              </div>
              <div class="col-lg-4">
                <a href="account.html#step4">
                  <div class="account-inner">
                    <i class="fa fa-key"></i><br/>
                    <span>Change Pass</span>
                  </div>
                </a>
              </div>
              <div class="col-lg-4">
                <a href="/orderList#step3">
                  <div class="account-inner">
                    <i class="fa fa-history"></i><br/>
                    <span>我的订单</span>
                  </div>
                </a>
              </div>
              <div class="col-lg-4">
                <a href="login.html">
                  <div class="account-inner">
                    <i class="fa fa-share-square-o"></i><br/>
                    <span>log out</span>
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div>
        <div id="search_popup" class="white-popup-block mfp-hide popup-position">
          <div class="popup-title">
            <h2 class="main_title heading"><span>Search</span></h2>
          </div>            
          <div class="popup-detail">
            <div class="main-search">
              <div class="header_search_toggle desktop-view">
                <form>
                  <div class="search-box">
                    <input class="input-text" type="text" placeholder="Search entire store here...">
                    <button class="search-btn"></button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</header>
<!-- HEADER END -->