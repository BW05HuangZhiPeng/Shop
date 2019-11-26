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
        <h1 class="banner-title">Payment</h1>
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
              <li> 
                <a href="order-overview.html">
                  <div class="step">
                    <div class="line"></div>
                    <div class="circle">2</div>
                  </div>
                  <span>Order Overview</span> 
                </a> 
              </li>
              <li class="active"> 
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
                  <h2 class="heading">Select a payment method</h2>
                </div>
              </div>
            </div>
            <div class="row justify-content-center">
              <div class="col-xl-6 col-lg-8 col-md-8 ">
                <div class="payment-option-box mb-30">
                  <div class="payment-option-box-inner gray-bg">
                    <div class="payment-top-box">
                      <div class="radio-box left-side"> <span>
                        <input type="radio" id="paypal" value="paypal" name="payment_type">
                        </span>
                        <label for="paypal">PayPal</label>
                      </div>
                      <div class="paypal-box">
                        <div class="paypal-top"> <img src="images/paypal-img.png" alt="Shopholic"> </div>
                        <div class="paypal-img"> <img src="images/payment-method.png" alt="Shopholic"> </div>
                      </div>
                    </div>
                    <p>If you Don't have CCAvenue Account, it doesn,t matter. You can also pay via CCAvenue with you credit card or bank debit card</p>
                    <p>Payment can be submitted in any currency.</p>
                  </div>
                </div>
                <div class="payment-option-box mb-30">
                  <div class="payment-option-box-inner gray-bg">
                    <div class="payment-top-box">
                      <div class="radio-box left-side"> <span>
                        <input type="radio" id="cash" value="cash" name="payment_type">
                        </span>
                        <label for="cash">Would you like to pay by Cash on Delivery?</label>
                      </div>
                    </div>
                    <p>Vestibulum semper accumsan nisi, at blandit tortor maxi'mus in phasellus malesuada sodales odio, at dapibus libero malesuada quis.</p>
                  </div>
                </div>
                <div class="right-side float-none-xs"> <a class="btn btn-color" href="order-complete.html">Place Order<span><i class="fa fa-angle-right"></i></span></a> </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- CONTAINER END --> 

  <!-- FOOTER START -->
  <div class="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">
          <div class="col-xl-3 col-lg-3 col-sm-12 center-sm mb-sm-20">
          <div class="f-logo">
            <a href="index.html" class="">
              <img src="images/footer-logo.png" alt="Shopholic">
            </a>
          </div>
          </div>
          <div class="col-xl-6 col-lg-6 col-sm-12 center-sm mb-sm-20 align-center">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consequat massa quis lorem hendrerit ultrices.</p>
          </div>
          <div class="col-xl-3 col-lg-3 col-sm-12 center-sm">
          <div class="footer_social right-side float-none-md">
            <ul class="social-icon">
              <li><a title="Facebook" class="facebook"><i class="fa fa-facebook"></i></a></li>
              <li><a title="Twitter" class="twitter"><i class="fa fa-twitter"></i></a></li>
              <li><a title="Linkedin" class="linkedin"><i class="fa fa-linkedin"> </i></a></li>
              <li><a title="RSS" class="rss"><i class="fa fa-rss"> </i></a></li>
              <li><a title="Pinterest" class="pinterest"><i class="fa fa-pinterest"> </i></a></li>
            </ul>
          </div>
          </div>
        </div>
      </div>
    </div>
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
