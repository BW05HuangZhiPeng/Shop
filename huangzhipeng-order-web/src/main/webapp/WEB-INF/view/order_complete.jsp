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
<body >
<div class="se-pre-con"></div>
<div class="main"> 
	<jsp:include page="header.jsp" />  
 
  <!-- Bread Crumb STRAT -->
  <div class="banner inner-banner1">
    <div class="container">
      <section class="banner-detail center-xs">
        <h1 class="banner-title">Order Complete</h1>
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
              <li> <a href="checkout.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">1</div>
                </div>
                <span>Shipping</span> </a> </li>
              <li> <a href="order-overview.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">2</div>
                </div>
                <span>Order Overview</span> </a> </li>
              <li> <a href="payment.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">3</div>
                </div>
                <span>Payment</span> </a> </li>
              <li class="active"> <a href="order-complete.html">
                <div class="step">
                  <div class="line"></div>
                  <div class="circle">4</div>
                </div>
                <span>Order Complete</span> </a> </li>
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
                  <h2 class="heading">Order Complete</h2>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-8 mb-sm-30">
                <div id="form-print" class="admission-form-wrapper">
                  <div class="cart-item-table complete-order-table commun-table mb-30">
                    <div class="table-responsive">
                      <table class="table">
                        <thead>
                          <tr>
                            <th>Product</th>
                            <th>Product Detail</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>
                              <a href="product-page.html">
                                <div class="product-image">
                                  <img alt="Shopholic" src="images/1.jpg">
                                </div>
                              </a>
                            </td>
                            <td>
                              <div class="product-title"> 
                                <a href="product-page.html">Cross Colours Camo Print Tank half mengo</a>
                                <div class="product-info-stock-sku m-0">
                                  <div>
                                    <label>Price: </label>
                                    <div class="price-box"> 
                                      <span class="info-deta price">$80.00</span> 
                                    </div>
                                  </div>
                                </div>
                                <div class="product-info-stock-sku m-0">
                                  <div>
                                    <label>Quantity: </label>
                                    <span class="info-deta">1</span> 
                                  </div>
                                </div>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <a href="product-page.html">
                                <div class="product-image">
                                  <img alt="Shopholic" src="images/2.jpg">
                                </div>
                              </a>
                            </td>
                            <td>
                              <div class="product-title"> 
                                <a href="product-page.html">Cross Colours Camo Print Tank half mengo</a>
                                <div class="product-info-stock-sku m-0">
                                  <div>
                                    <label>Price: </label>
                                    <div class="price-box"> 
                                      <span class="info-deta price">$80.00</span> 
                                    </div>
                                  </div>
                                </div>
                                <div class="product-info-stock-sku m-0">
                                  <div>
                                    <label>Quantity: </label>
                                    <span class="info-deta">1</span> 
                                  </div>
                                </div>
                              </div>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <div class="complete-order-detail commun-table mb-30">
                    <div class="table-responsive">
                      <table class="table">
                        <tbody>
                          <tr>
                            <td><b>Order Places :</b></td>
                            <td>17 December 2016</td>
                          </tr>
                          <tr>
                            <td><b>Total :</b></td>
                            <td><div class="price-box"> <span class="price">$160.00</span> </div></td>
                          </tr>
                          <tr>
                            <td><b>Payment :</b></td>
                            <td>COD</td>
                          </tr>
                          <tr>
                            <td><b>Order No. :</b></td>
                            <td>#011052</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <div class="mb-30">
                    <div class="heading-part">
                      <h3 class="sub-heading">Order Confirmation</h3>
                    </div>
                    <hr>
                    <p class="mt-20">Quisque id fermentum tellus. Donec fringilla mauris nec ligula maximus sodales. Donec ac felis nunc. Fusce placerat volutpat risus, ac fermentum ex tempus eget.</p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-12">
                    <div class="print-btn">
                      <button onclick="printDiv('form-print')" class="btn btn-color" type="button">Print</button>
                      <div class="right-side float-none-xs mt-sm-30"> 
                        <a class="btn btn-black" href="http://localhost:8080">
                          <span><i class="fa fa-angle-left"></i></span>Continue Shopping
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="cart-total-table address-box commun-table mb-30">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Shipping Address</th>
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
                <div class="cart-total-table address-box commun-table">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Billing Address</th>
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
