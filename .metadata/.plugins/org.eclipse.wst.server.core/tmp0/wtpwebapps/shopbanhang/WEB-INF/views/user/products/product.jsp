<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>

</head>

<div class="row">
	<div id="sidebar" class="span3">
		<div class="well well-small">
			<ul class="nav nav-list">
				<c:forEach var="item" items="${categorys }">
					<li><a href='<c:url value="/san-pham/${item.id }" />'><i
							class="fa-solid fa-play" style="margin-right: 4px"></i>${item.name }</a></li>
				</c:forEach>
				<li><a class="totalInCart" href="cart.html"><strong>Tổng
							tiền <span class="badge badge-warning pull-right"
							style="line-height: 18px;"><fmt:formatNumber type="number"
									groupingUsed="true" value="${TotalPriceCart }" />₫</span>
					</strong></a></li>
			</ul>
		</div>

		<div class="well well-small alert alert-warning cntr">
			<h2>50% Discount</h2>
			<p>
				only valid for online order. <br> <br> <a
					class="defaultBtn" href="#">Click here </a>
			</p>
		</div>
		<div class="well well-small">
			<a href="#"><img src="assets/img/paypal.jpg"
				alt="payment method paypal"></a>
		</div>

		<a class="shopBtn btn-block" href="#">Upcoming products <br>
			<small>Click to view</small></a> <br> <br>
		<ul class="nav nav-list promowrapper">
			<li>
				<div class="thumbnail">
					<a class="zoomTool" href="product_details.html" title="add to cart"><span
						class="icon-search"></span> QUICK VIEW</a> <img
						src="assets/img/bootstrap-ecommerce-templates.png"
						alt="bootstrap ecommerce templates">
					<div class="caption">
						<h4>
							<a class="defaultBtn" href="product_details.html">VIEW</a> <span
								class="pull-right">$22.00</span>
						</h4>
					</div>
				</div>
			</li>
			<li style="border: 0">&nbsp;</li>
			<li>
				<div class="thumbnail">
					<a class="zoomTool" href="product_details.html" title="add to cart"><span
						class="icon-search"></span> QUICK VIEW</a> <img
						src="assets/img/shopping-cart-template.png"
						alt="shopping cart template">
					<div class="caption">
						<h4>
							<a class="defaultBtn" href="product_details.html">VIEW</a> <span
								class="pull-right">$22.00</span>
						</h4>
					</div>
				</div>
			</li>
			<li style="border: 0">&nbsp;</li>
			<li>
				<div class="thumbnail">
					<a class="zoomTool" href="product_details.html" title="add to cart"><span
						class="icon-search"></span> QUICK VIEW</a> <img
						src="assets/img/bootstrap-template.png" alt="bootstrap template">
					<div class="caption">
						<h4>
							<a class="defaultBtn" href="product_details.html">VIEW</a> <span
								class="pull-right">$22.00</span>
						</h4>
					</div>
				</div>
			</li>
		</ul>

	</div>
	<div class="span9">
		<!-- 
New Products
-->
		<div class="well well-small">
			<h3>Sản phẩm</h3>
			<div class="row-fluid">
				<c:if test="${products.size() > 0}">
					<ul class="thumbnails">
						<c:forEach var="item" items="${products }" varStatus="loop">
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href='chi-tiet-san-pham/${item.id_product }' title="Xem chi tiết"><i
										class="fa-solid fa-magnifying-glass"></i> Xem</a> <a
										href="chi-tiet-san-pham/${item.id_product }"><img
										src='<c:url value="/assets/user/img/${item.img }" />' alt=""></a>
									<div class="caption">
										<h5>${item.name }</h5>
										<h4>
											<a class="defaultBtn" href="product_details.html"
												title="Click to view"><span
												class="fa-solid fa-magnifying-glass-plus"></span></a> <a
												class="shopBtn"
												href="<c:url value="/AddCart/${item.id_product }" />"
												title="Thêm vào giỏ hàng"><span class="fa-solid fa-plus"></span></a>
											<span class="pull-right"><fmt:formatNumber
													type="number" groupingUsed="true" value="${item.price }" />₫
											</span>
										</h4>
									</div>
								</div>
							</li>

							<c:if
								test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == products.size() }">
					</ul>
					<c:if test="${(loop.index + 1) < products.size() }">
						<ul class="thumbnails">
					</c:if>
				</c:if>
				</c:forEach>
				</c:if>
			</div>

		</div>
	</div>
</div>
<!-- 
Clients 
-->
</body>