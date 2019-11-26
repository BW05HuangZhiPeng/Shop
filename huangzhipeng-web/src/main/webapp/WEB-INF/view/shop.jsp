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

		<!-- CONTAIN START -->
		<section class="ptb-60">
			<div class="container">
				<div class="product-listing-view">
					<div class="row m-0">
						<div id="sidebar"
							class="col-xl-3 col-lg-3 p-0 pr-10 mb-sm-30 static-sidebar">
							<form action="shop" method="post">
							<div class="sidebar__inner">
								<div class="sidebar-block gray-bg">
									<div class="sidebar-box listing-box mb-30">
										<span class="opener plus"></span>
										<div class="sidebar-title">
											<h3>
												<i class="fa fa-bars"></i> 分类
											</h3>
										</div>
										<div class="sidebar-contant">
											<ul>
												<c:forEach items="${map.categoryList}" var="category" varStatus="index">
													<div class="radio">
														<span> <input id="category${index.count }"
															class="radio-button" type="radio"
															value="${category.id }" name="categoryId"  <c:if test="${sku.categoryId==category.id}">checked</c:if>>
															<label for="category${index.count }">${category.name }</label>
														</span>
													</div>
												</c:forEach>
											</ul>
										</div>
									</div>
									<div class="sidebar-box mb-30">
										<span class="opener plus"></span>
										<div class="sidebar-title">
											<h3>
												<i class="fa fa-bars"></i> 品牌
											</h3>
										</div>
										<div class="sidebar-contant">
											<ul>
												<c:forEach items="${map.brandList}" var="brand"
													varStatus="index">
													<li>
														<div class="radio">
															<span> <input id="brand${index.count }"
																class="radio-button" type="radio"
																value="${brand.id}" name="brandId"  <c:if test="${sku.brandId==brand.id}">checked</c:if>>
																<label for="brand${index.count }">${brand.name}</label>
															</span>
														</div>
													</li>
												</c:forEach>
											</ul>
										</div>
									</div>
									<div class="sidebar-box mb-30">
										<span class="opener plus"></span>
										<div class="sidebar-title">
											<h3>
												<i class="fa fa-filter"></i> 过滤
											</h3>
										</div>
										<div class="sidebar-contant">
											<div class="price-range mb-30">
												<div class="inner-title">价格范围</div>
												<div>
												<input class="price-txt" type="text" style="width:10%" id="startPrice" name="startPrice" value="${sku.startPrice}">
												至
												<input class="price-txt" type="text" style="width:10%" id="endPrice" name="endPrice" value="${sku.endPrice}">
												</div>
												<div id="slider-range"></div>
											</div>
											<c:forEach items="${map.specList}" var="spec"
												varStatus="index">
												<div class="mb-20">
													<div class="inner-title">${spec.specName }</div>
													<div>
														<ul class="listing">
															<c:forEach items="${spec.options}"
																var="specOption" varStatus="index1">
																<li>
																<div class="check-box">
																	<span>
																	<input type="checkbox" class="checkbox" id="optionIds${index.index}${index1.index }"
																name="optionIds[${index.index}][${index1.index }]" value="${specOption.id}" <c:if test="${sku.optionIds[index.index][index1.index]==specOption.id}">checked</c:if>>
																<label for="optionIds${index.index}${index1.index }">
																	${specOption.optionName}</label></span>
																</div>
																</li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</c:forEach>
											<input class="btn btn-color" type="submit" value="查询"/>
										</div>
									</div>
								</div>
							</div>
							</form>
						</div>
						<div id="content" class="col-xl-9 col-lg-9 p-0 pl-10">
							<div class="shorting mb-20">
								<div class="row">
									<div class="col-xl-6">
										<div class="view">
											<div class="list-types grid active ">
												<a>
												</a>
											</div>
											<div class="list-types list">
												<a>
												</a>
											</div>
										</div>
										<div class="short-by float-right-sm">
											<span>Sort By :</span>
											<div class="select-item select-dropdown">
												<fieldset>
													<select name="speed" id="sort-price" class="option-drop">
														<option value="" selected="selected">Name (A to
															Z)</option>
														<option value="">Name(Z - A)</option>
														<option value="">price(low&gt;high)</option>
														<option value="">price(high &gt; low)</option>
														<option value="">rating(highest)</option>
														<option value="">rating(lowest)</option>
													</select>
												</fieldset>
											</div>
										</div>
									</div>
									<div class="col-xl-6">
										<div class="show-item float-left-sm">
											<span>Show :</span>
											<div class="select-item select-dropdown">
												<fieldset>
													<select name="speed" id="show-item" class="option-drop">
														<option value="" selected="selected">24</option>
														<option value="">12</option>
														<option value="">6</option>
													</select>
												</fieldset>
											</div>
											<span>Per Page</span>
										</div>
									</div>
								</div>
							</div>
							<div class="product-listing grid-type">
								<div class="inner-listing">
									<div class="row mlr_-20">
										<c:forEach items="${map.pageInfo.list}" var="sku">
											<div class="col-md-3 col-6 plr-20 item-width mb-20">
												<div class="product-item">
													<div class="product-item-inner">
														<div class="product-image">
															<a href="page?id=${sku.id}"> <img alt="Shopholic"
																src="pic/${sku.image }">
															</a>
														</div>
														<div class="product-item-details">
															<div class="product-item-name">
																<a href="page?id=${sku.id}">${sku.title }</a>
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
									<div class="row">
										<div class="col-12">
											<div class="pagination-bar">
												<ul>
													<li><a href="#"><i class="fa fa-angle-left"></i></a></li>
													<li class="active"><a href="#">1</a></li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
												</ul>
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
		<!-- CONTAINER END -->

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>