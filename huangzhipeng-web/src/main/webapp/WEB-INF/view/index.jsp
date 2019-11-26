<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<jsp:include page="common.jsp" />
</head>
<body class="homepage">
	<div class="main">
		<jsp:include page="header.jsp" />
		<section class="main-wrap">
			<div class="row">
				<div class="col-12">
					<!-- BANNER STRAT -->
					<section class="banner-main">
						<div class="banner">
							<div class="main-banner">
								<div class="banner-1">
									<img src="images/banner1.jpg" alt="Shopholic">
									<div class="banner-detail">
										<div class="row">
											<div class="col-lg-5 col-6"></div>
											<div class="col-lg-7 col-6 align-center">
												<div class="banner-detail-inner">
													<h1 class="banner-title">Toy for kids</h1>
													<span class="offer">Soft and simple toys</span>
													<p>New Born Baby Cloth and Toy</p>
												</div>
												<a class="btn big-btn btn-color" href="shop.html">Shop
													Now!</a>
											</div>
										</div>
									</div>
								</div>
								<div class="banner-2">
									<img src="images/banner2.jpg" alt="Shopholic">
									<div class="banner-detail">
										<div class="row">
											<div class="col-xl-2 col-0"></div>
											<div class="col-xl-4 col-7 align-center">
												<div class="banner-detail-inner">
													<h1 class="banner-title">Latest Collection</h1>
													<span class="offer">flat 40% off</span>
													<p>Shop for comfortable and trendy clothes</p>
												</div>
												<a class="btn btn-color" href="shop.html">Shop Now!</a>
											</div>
											<div class="col-xl-6 col-5"></div>
										</div>
									</div>
								</div>
								<div class="banner-3">
									<img src="images/banner3.jpg" alt="Shopholic">
									<div class="banner-detail">
										<div class="row">
											<div class="col-lg-5 col-6"></div>
											<div class="col-lg-7 col-6 align-center">
												<div class="banner-detail-inner">
													<h1 class="banner-title">New Cycle</h1>
													<span class="offer">For 3 year new baby</span>
													<p>Many Cycle For Kids</p>
												</div>
												<a class="btn big-btn btn-color" href="shop.html">Shop
													Now!</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
					<!-- BANNER END -->
				</div>
			</div>
		</section>


		<section class="featured-product ptb-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="heading-part align-center mb-30">
							<h2 class="main_title heading">精品</h2>
							<div class="category-bar" id="tabs">
								<ul class="tab-stap">
									<li><a title="step1" class="tab-step1 selected">新品</a></li>
									<li><a title="step2" class="tab-step2">畅销</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="pro_cat tab_content product-listing grid-type">
					<div id="items">
						<ul>
							<li>
								<div id="data-step1"
									class="items-step1 product-slider-main position-r selected"
									data-temp="tabdata">
									<div class="pro_cat product-listing grid-type">
										<div class="row mlr_-20">
											<div class="owl-carousel best-seller-pro">
												<c:forEach items="${newSkus}" var="sku">
													<div class="item">
														<div class="product-item mb-20">
															<div class="product-item-inner">
																<div class="product-image">
																	<a href="/page?id=${sku.id }"> <img alt="Shopholic"
																		src="pic/${sku.image }">
																	</a>
																</div>
																<div class="product-item-details">
																	<div class="product-item-name">
																		<a href="/page?id=${sku.id }">${sku.title }</a>
																	</div>
																	<div class="rating-summary-block">
																		<div title="53%" class="rating-result">
																			<span style="width: 53%"></span>
																		</div>
																	</div>
																	<div class="price-box">
																		<span class="price">${sku.price }</span>
																		<del class="price old-price">${sku.marketPrice }</del>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div id="data-step2"
									class="items-step2 product-slider-main position-r"
									data-temp="tabdata">
									<div class="pro_cat product-listing grid-type">
										<div class="row mlr_-20">
											<div class="owl-carousel best-seller-pro">
												<c:forEach items="${hotSkus}" var="sku">
													<div class="item">
														<div class="product-item mb-20">
															<div class="product-item-inner">
																<div class="product-image">
																	<a href="/page?id=${sku.id }"> <img alt="Shopholic"
																		src="pic/${sku.image }">
																	</a>
																</div>
																<div class="product-item-details">
																	<div class="product-item-name">
																		<a href="/page?id=${sku.id }">${sku.title }</a>
																	</div>
																	<div class="rating-summary-block">
																		<div title="53%" class="rating-result">
																			<span style="width: 53%"></span>
																		</div>
																	</div>
																	<div class="price-box">
																		<span class="price">${sku.price }</span>
																		<del class="price old-price">${sku.marketPrice }</del>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<section class="ptb-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="heading-part align-center">
							<h2 class="main_title heading">畅销产品</h2>
						</div>
					</div>
				</div>
				<div class="pro_cat product-listing grid-type">
					<div class="row mlr_-20">
						<div class="owl-carousel best-seller-pro">
							<c:forEach items="${newSkus}" var="sku">
								<div class="item">
									<div class="product-item mb-20">
										<div class="product-item-inner">
											<div class="product-image">
												<a href="/page?id=${sku.id }"> <img alt="Shopholic"
													src="pic/${sku.image }">
												</a>
											</div>
											<div class="product-item-details">
												<div class="product-item-name">
													<a href="/page?id=${sku.id }">${sku.title }</a>
												</div>
												<div class="rating-summary-block">
													<div title="53%" class="rating-result">
														<span style="width: 53%"></span>
													</div>
												</div>
												<div class="price-box">
													<span class="price">${sku.price }</span>
													<del class="price old-price">${sku.marketPrice }</del>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!-- Blog section start -->
		<section class="pt-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="heading-part align-center">
							<h2 class="main_title heading">新品推出</h2>
						</div>
					</div>
				</div>
				<div class="pro_cat product-listing grid-type">
					<div class="row mlr_-20">
						<div class="owl-carousel best-seller-pro">
							<c:forEach items="${newSkus}" var="sku">
								<div class="item">
									<div class="product-item mb-20">
										<div class="product-item-inner">
											<div class="product-image">
												<a href="/page?id=${sku.id }"> <img alt="Shopholic"
													src="pic/${sku.image }">
												</a>
											</div>
											<div class="product-item-details">
												<div class="product-item-name">
													<a href="/page?id=${sku.id }">${sku.title }</a>
												</div>
												<div class="rating-summary-block">
													<div title="53%" class="rating-result">
														<span style="width: 53%"></span>
													</div>
												</div>
												<div class="price-box">
													<span class="price">${sku.price }</span>
													<del class="price old-price">${sku.marketPrice }</del>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- CONTAINER END -->
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
