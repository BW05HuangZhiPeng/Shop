<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<head>
<jsp:include page="common.jsp" />
</head>
<body >
<div class="se-pre-con"></div>
<div class="main"> 
	<jsp:include page="header.jsp" />
  <!-- Bread Crumb STRAT -->
  <div class="banner inner-banner1">
    <div class="container">
      <section class="banner-detail center-xs">
        <h1 class="banner-title">Order Overview</h1>
        <div class="bread-crumb right-side float-none-xs">
          <ul>
            <li><a href="index.html"><i class="fa fa-home"></i>Home</a>/</li>
            <li><a href="cart.html">Cart</a>/</li>
            <li><span>Checkout</span></li>
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
          <div class="checkout-step mb-40">
            <ul>
              <li> 
                  <a href="checkout.html">
                  <div class="step">
                    <div class="line"></div>
                    <div class="circle">1</div>
                  </div>
                  <span>Shipping</span> 
                </a> 
              </li>
              <li class="active"> 
                <a href="order-overview.html">
                  <div class="step">
                    <div class="line"></div>
                    <div class="circle">2</div>
                  </div>
                  <span>Order Overview</span> 
                </a> 
              </li>
              <li> 
                <a href="payment.html">
                  <div class="step">
                    <div class="line"></div>
                    <div class="circle">3</div>
                  </div>
                  <span>Payment</span> 
                </a> 
              </li>
              <li> 
                <a href="order-complete.html">
                  <div class="step">
                    <div class="line"></div>
                    <div class="circle">4</div>
                  </div>
                  <span>Order Complete</span> 
                </a> 
              </li>
              <li>
                <div class="step">
                  <div class="line"></div>
                </div>
              </li>
            </ul>
            <hr>
          </div>
          <div class="checkout-content">
            <div class="row">
              <div class="col-12">
                <div class="heading-part align-center">
                  <h2 class="heading">订单预览</h2>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-8 mb-sm-30">
                <div class="cart-item-table commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>图片</th>
                          <th>标题</th>
                          <th>价格</th>
                          <th>数量</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${cartList}" var="cart">
                        <tr>
                          <td>
                            <div class="product-image">
                            <a href="http://localhost:9090/page?id=${cart.skuid}"><img alt="Honour" src="pic/${cart.image}"></a></div>
                          </td>
                          <td>
                          	<div class="product-title"> 
                          	<a href="http://localhost:9090/page?id=${cart.skuid}">${cart.title}</a>
                            </div>
                         </td>
                          <td>
                            <div class="product-info-stock-sku m-0">
                                  <div class="price-box"> <span class="info-deta price">${cart.price}</span></div>
	                        </div>
                            </td>
                            <td>
                            	<div class="product-info-stock-sku m-0">
	                                  <span class="info-deta">${cart.pnum}</span> 
                              	</div>
                            </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="cart-total-table commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th colspan="2">总计</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>商品总价</td>
                          <td><div class="price-box"> <span class="price">${totalPrice}</span> </div></td>
                        </tr>
                        <tr>
                          <td>运费</td>
                          <td><div class="price-box"> <span class="price">$10.00</span> </div></td>
                        </tr>
                        <tr>
                          <td><b>实际总价</b></td>
                          <td><div class="price-box"> <span class="price"><b>${totalPrice+10 }</b></span> </div></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="right-side float-none-xs"> <a href="javascript:void(0)" onclick="$('#orderForm').submit()" class="btn btn-color">Next</a> </div>
              </div>
              <div class="col-md-4">
                <div class="cart-total-table address-box commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>收货地址</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>
                            <ul>
                              <li class="inner-heading"> <b>Denial tom</b> </li>
                              <li>
                                <p>5-A kadShopholici aprtment,opp. vasan eye care,</p>
                              </li>
                              <li>
                                <p>Risalabaar,City Road, deesa-405001.</p>
                              </li>
                              <li>
                                <p>India</p>
                              </li>
                            </ul>
                          </td>
                        </tr>
                      </tbody>
                    </table>
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

<form id="orderForm"  action="/orderCreate" method="post">
	<input type="hidden" name="paymentType" value="2"/>
	<input type="hidden" name="postFee" value="10"/>
	<input type="hidden" name="totalPrice" value="${totalPrice}"/>
	<input type="hidden" name="actualPrice" value="${totalPrice + 10}"/>
	<c:forEach items="${cartList }" var="cart" varStatus="status">
		<input type="hidden" name="orderDetails[${status.index}].skuId" value="${cart.skuid}"/>
		<input type="hidden" name="orderDetails[${status.index}].num" value="${cart.pnum }"/>
		<input type="hidden" name="orderDetails[${status.index}].price" value="${cart.price}"/>
		<input type="hidden" name="orderDetails[${status.index}].title" value="${cart.title}"/>
		<input type="hidden" name="orderDetails[${status.index}].image" value="${cart.image}"/>
	</c:forEach>
</form>

  <jsp:include page="footer.jsp" /> 
</div>
<script src="js/jquery-1.12.3.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="js/bootstrap.js"></script>  
<script src="js/jquery.downCount.js"></script>
<script src="js/jquery-ui.min.js"></script> 
<script src="js/fotorama.js"></script>
<script src="js/jquery.magnific-popup.js"></script> 
<script src="js/owl.carousel.min.js"></script>  
<script src="js/custom.js"></script>
</body>
</html>
