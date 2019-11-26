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
        <h1 class="banner-title">Checkout</h1>
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
              <li class="active"> 
                <a href="checkout.html">
                  <div class="step">
                    <div class="line"></div>
                    <div class="circle">1</div>
                  </div>
                  <span>Shipping</span> 
                </a> 
              </li>
              <li> 
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
          <div class="checkout-content" >
            <div class="row">
              <div class="col-12">
                <div class="heading-part align-center">
                  <h2 class="heading">请填写收货信息</h2>
                </div>
              </div>
            </div>
            <div class="row justify-content-center">
              <div class="col-xl-6 col-lg-8 col-md-8">
                <form action="addShippingAddress" class="main-form full">
                  <div class="row mb-20">
                    <div class="col-12 mb-20">
                      <div class="heading-part">
                        <h3 class="sub-heading">收货地址</h3>
                      </div>
                      <hr>
                    </div>
                    <div class="col-md-12">
                      <div class="input-box">
                        	姓名：<input type="text" name="username" required placeholder="输入姓名">
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="input-box">
                        	邮箱：<input type="email" name="email" required placeholder="输入邮箱">
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="input-box">
                        	手机号：<input type="text" name="phone" required placeholder="输入手机号">
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="input-box">
                        	收货地址：<input type="text" name="address" required placeholder="输入收货地址">
                      </div>
                    </div>
                    <div class="col-md-12"> 
                      <a href="/addressAdd" class="btn btn-color right-side">Next</a> 
                    </div>
                  </div>
                </form>
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
