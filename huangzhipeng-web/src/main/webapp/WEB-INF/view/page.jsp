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
		function cartAdd(skuId){
			var num = $("#qty").val();
			var image = $(".fotorama__img").prop("src");
			var price = $("#price").text();
			var title = $("#title").text();
			/*************************redis存储**************************/
			//window.location.href="http://localhost:8900/cartAdd2?skuId=" + skuId + "&num=" + num;
			/*************************cookie存储**************************/
			window.location.href="http://localhost:8900/cartAdd2?skuId=" + skuId + "&num=" + num;
			//*********************************localStorage本地存储*************************/
			//window.location.href="http://localhost:8900/cart.html";
			
            //localStorage.setItem("cart", JSON.stringify(carts));
          	
            //window.location.href="http://localhost:8900/cart.html";
            
           /* 	var cartItem = {};
            cartItem.skuId=skuId;
            cartItem.title=title;
            cartItem.price=parseFloat(price);
            cartItem.image=image;
            cartItem.num=parseInt(num);
            cartItem.subPrice=cartItem.price * cartItem.num;
            
            window.frames[0].postMessage(JSON.stringify(cartItem), 'http://localhost:8900');
            window.location.href="http://localhost:8900/cart.html"; */
		}
		
		
		function decrement(){
			var qty = $("#qty").val();
			if(!isNaN(qty) && qty>1){
				qty--;
			}
			$("#qty").val(qty);
		}
		function increment(){
			var qty = $("#qty").val();
			if(!isNaN(qty)){
				qty++;
			}
			$("#qty").val(qty);
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
					<h1 class="banner-title">Women</h1>
					<div class="bread-crumb right-side float-none-xs">
						<ul>
							<li><a href="index.html"><i class="fa fa-home"></i>Home</a>/</li>
							<li><span>Women</span></li>
						</ul>
					</div>
				</section>
			</div>
		</div>
		<!-- Bread Crumb END -->

		<!-- CONTAIN START -->
		<section class="pt-60">
			<div class="container">
				<div class="row mlr_-20">
					<div class="col-lg-12 plr-20">
						<div class="row mlr_-20">
							<div class="col-lg-5 col-md-5 mb-xs-30 plr-20">
								<div class="fotorama" data-nav="thumbs"
									data-allowfullscreen="native">
									<a href="#"><img src="pic/${map.sku.image}" alt="Shopholic"></a>
									<a href="#"><img src="images/2.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/3.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/4.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/5.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/6.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/4.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/5.jpg" alt="Shopholic"></a>
									<a href="#"><img src="images/6.jpg" alt="Shopholic"></a>
								</div>
							</div>
							<div class="col-lg-7 col-md-7 plr-20">
								<div class="row">
									<div class="col-12">
										<div class="product-detail-main">
											<div class="product-item-details">
												<h1 class="product-item-name" id="title">${map.sku.title }</h1>
												<div class="rating-summary-block">
													<div title="53%" class="rating-result">
														<span style="width: 53%"></span>
													</div>
												</div>
												<div class="price-box">
													<span class="price" id="price">${map.sku.price}</span>
													<del class="price old-price">${map.sku.marketPrice}</del>
												</div>
												<div class="product-info-stock-sku">
													<div>
														<label>Availability: </label> <span class="info-deta">In
															stock</span>
													</div>
													<div>
														<label>SKU: </label> <span class="info-deta">20MVC-18</span>
													</div>
												</div>
												<hr class="mb-20">
												<ul class="product-list">
													<li><i class="fa fa-check"></i> Satisfaction 100%
														Guaranteed</li>
													<li><i class="fa fa-check"></i> Free shipping on
														orders over $99</li>
													<li><i class="fa fa-check"></i> 14 day easy Return</li>
												</ul>
												<hr class="mb-20">
												<div class="mb-20">
													<div class="row">
														<c:forEach items="${map.specs}" var="spec" varStatus="index">
														<div class="col-12">
															<div class="row">
																<div class="col-lg-4 col-md-12">
																	<input type="hidden" value="${spec.id}"/>
																	<span>${spec.specName} :</span>
																</div>
																<div class="col-lg-8 col-md-12">
																	<div class="select-size">
																		<ul class="listing" id="spec_${index.index}">
																		<c:forEach items="${spec.options}" var="option" varStatus="index1">
																			<li id="spec_option_${index.index}${index1.index}" onclick="getSkuBySpecOptionIds(this)" 
																				<c:forEach items="${map.sku.skuSpec}" var="skuSpec">
																				<c:if test="${option.id == skuSpec.specOptionId}">class="active"</c:if>
																				</c:forEach>
																			>
																				<input type="hidden" value="${option.id}"/>
																				<span>${option.optionName}</span>
																			</li>
																		</c:forEach>
																		</ul>
																	</div>
																</div>
															</div>
														</div>
														</c:forEach>
														<div class="col-12">
															<div class="row">
																<div class="col-lg-4 col-md-12">
																	<span>数量:</span>
																</div>
																<div class="col-lg-8 col-md-12">
																	<div class="custom-qty">
																		<button
																			onclick="decrement();"
																			class="reduced items" type="button">
																			<i class="fa fa-minus"></i>
																		</button>
																		<input type="text" class="input-text qty" title="Qty"
																			value="1" maxlength="8" id="qty" name="qty">
																		<button
																			onclick="increment();"
																			class="increase items" type="button">
																			<i class="fa fa-plus"></i>
																		</button>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-12">
															<div class="bottom-detail cart-button">
																<ul>
																	<li class="pro-cart-icon"><a href="javascript:void(0)" onclick="cartAdd(${map.sku.id})"
																		title="Add to Cart" class="btn btn-color"><span></span>
																			加入购物车</a></li>
																</ul>
															</div>
														</div>
													</div>
												</div>
												<hr class="mb-20">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="ptb-60">
			<div class="container">
				<div class="product-detail-tab">
					<div class="row">
						<div class="col-lg-12">
							<div id="tabs">
								<ul class="nav nav-tabs">
									<li><a class="tab-Description selected"
										title="Description">Description</a></li>
									<li><a class="tab-Product-Tags" title="Product-Tags">Product-Tags</a></li>
									<li><a class="tab-Reviews" title="Reviews">Reviews</a></li>
								</ul>
							</div>
							<div id="items">
								<div class="tab_content">
									<ul>
										<li>
											<div class="items-Description selected ">
												<div class="Description">
													<strong>The standard Lorem Ipsum passage, used
														since the 1500s</strong><br />
													<p>Proin lectus ipsum, gravida et mattis vulputate,
														tristique ut lectus. Sed et lorem nunc. Vestibulum ante
														ipsum primis in faucibus orci luctus et ultrices posuere
														cubilia Curae; Aenean eleifend laoreet congue. Vivamus
														adipiscing nisl ut dolor dignissim semper. Nulla luctus
														malesuada Lorem Ipsum is simply dummy text of the printing
														and typesetting industry. Lorem Ipsum has been the
														industry's standard dummy took a galley of type and
														scrambled it to make a type specimen book. It has survived
														not only five centuries, but also the leap into
														Shopholicnic typesetting, remaining essentially unchanged.
														It was popularised in the 1960s with the release of
														Letraset sheets</p>
													<p>Tristique ut lectus. Sed et lorem nunc. Vestibulum
														ante ipsum primis in faucibus orci luctus et ultrices
														posuere cubilia Curae; Aenean eleifend laoreet congue.
														Vivamus adipiscing nisl ut dolor dignissim semper. Nulla
														luctus malesuada Lorem Ipsum is simply dummy text of the
														printing and typesetting industry.</p>
												</div>
											</div>
										</li>
										<li>
											<div class="items-Product-Tags">
												<strong>Section 1.10.32 of "de Finibus Bonorum et
													Malorum", written by Cicero in 45 BC</strong><br /> Sed ut
												perspiciatis unde omnis iste natus error sit voluptatem
												accusantium doloremque laudantium, totam rem aperiam, eaque
												ipsa quae ab illo inventore veritatis et quasi architecto
												beatae vitae dicta sunt explicabo. Nemo enim ipsam
												voluptatem quia voluptas sit aspernatur aut odit aut fugit,
												sed quia consequuntur
											</div>
										</li>
										<li>
											<div class="items-Reviews">
												<div class="comments-area">
													<h4>
														Comments<span>(2)</span>
													</h4>
													<ul class="comment-list mt-30">
														<li>
															<div class="comment-user">
																<img src="images/comment-user.jpg" alt="Shopholic">
															</div>
															<div class="comment-detail">
																<div class="user-name">John Doe</div>
																<div class="post-info">
																	<ul>
																		<li>Fab 11, 2016</li>
																		<li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
																	</ul>
																</div>
																<p>Consectetur adipiscing elit integer sit amet
																	augue laoreet maximus nuncac.</p>
															</div>
															<ul class="comment-list child-comment">
																<li>
																	<div class="comment-user">
																		<img src="images/comment-user.jpg" alt="Shopholic">
																	</div>
																	<div class="comment-detail">
																		<div class="user-name">John Doe</div>
																		<div class="post-info">
																			<ul>
																				<li>Fab 11, 2016</li>
																				<li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
																			</ul>
																		</div>
																		<p>Consectetur adipiscing elit integer sit amet
																			augue laoreet maximus nuncac.</p>
																	</div>
																</li>
																<li>
																	<div class="comment-user">
																		<img src="images/comment-user.jpg" alt="Shopholic">
																	</div>
																	<div class="comment-detail">
																		<div class="user-name">John Doe</div>
																		<div class="post-info">
																			<ul>
																				<li>Fab 11, 2016</li>
																				<li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
																			</ul>
																		</div>
																		<p>Consectetur adipiscing elit integer sit amet
																			augue laoreet maximus nuncac.</p>
																	</div>
																</li>
															</ul>
														</li>
														<li>
															<div class="comment-user">
																<img src="images/comment-user.jpg" alt="Shopholic">
															</div>
															<div class="comment-detail">
																<div class="user-name">John Doe</div>
																<div class="post-info">
																	<ul>
																		<li>Fab 11, 2016</li>
																		<li><a href="#"><i class="fa fa-reply"></i>Reply</a></li>
																	</ul>
																</div>
																<p>Consectetur adipiscing elit integer sit amet
																	augue laoreet maximus nuncac.</p>
															</div>
														</li>
													</ul>
												</div>
												<div class="main-form mt-30">
													<h4>Leave a comments</h4>
													<form>
														<div class="row mt-30 mlr_-20">
															<div class="col-md-4 mb-20 plr-20">
																<input type="text" placeholder="Name" required>
															</div>
															<div class="col-md-4 mb-20 plr-20">
																<input type="email" placeholder="Email" required>
															</div>
															<div class="col-md-4 mb-20 plr-20">
																<input type="text" placeholder="Website" required>
															</div>
															<div class="col-12 mb-20 plr-20">
																<textarea cols="30" rows="3" placeholder="Message"
																	required></textarea>
															</div>
															<div class="col-12 plr-20">
																<button class="btn btn-color" name="submit"
																	type="submit">Submit</button>
															</div>
														</div>
													</form>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- CONTAINER END -->

		<iframe src="http://localhost:8900/getmessage.html" frameborder="0"></iframe>
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>