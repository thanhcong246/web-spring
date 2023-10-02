<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Giỏ Hàng</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Giỏ hàng</li>
			</ul>
			<div class="well well-small">
				<h1>
					Giỏ hàng
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr bgcolor="#FFF">
							<th>Hình ảnh</th>
							<th>Mô tả</th>
							<th>Màu sắc</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Chỉnh sửa</th>
							<th>Xóa</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${Cart }">
							<tr bgcolor="#FFF">
								<td style="text-align: center; vertical-align: middle;"><img
									width="70"
									src='<c:url value="/assets/user/img/${item.value.product.img }" />'
									alt=""></td>
								<td>${item.value.product.title }</td>
								<td><span class="shopBtn"
									style="background-color: ${item.value.product.code_color}; border-radius: 50%;"><i
										class="fa-solid fa-check"></i></span></td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${item.value.product.price }" />₫</td>
								<td><input class="span1"
									style="min-width: 60px; max-width: 60px"
									id="quanty-cart-${item.key }" size="10" type="number" min="0"
									max="100" value="${item.value.quanty }"
									oninput="checkValue(this)"></td>
								<td><button data-id="${item.key }"
										class="btn btn-mini btn-success edit-cart" type="button">
										<i class="fa-solid fa-pen-to-square"></i>
									</button></td>
								<td><a href='<c:url value="/DeleteCart/${item.key }" />'
									class="btn btn-mini btn-danger" type="button"> <i
										class="fa-solid fa-circle-minus"></i>
								</a></td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${item.value.totalPrice }" />₫</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="products.html" class="shopBtn btn-large"><i
					class="fa-solid fa-circle-chevron-left"></i> Tiếp tục mua sắm </a> <a
					href='<c:url value="checkout" />' class="shopBtn btn-large pull-right">Thanh
					toán <i class="fa-solid fa-circle-chevron-right"></i>
				</a>

			</div>
		</div>
	</div>
	<content tag="script"> <script type="text/javascript">
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-" + id).val();
			window.location = "EditCart/" + id + "/" + quanty;
		});

		function checkValue(input) { // kiểm tra người dùng nhập số lượng sản phẩm
			// Chuyển đổi giá trị thành số nguyên
			var value = parseInt(input.value);

			// Kiểm tra nếu giá trị nhỏ hơn 0 hoặc lớn hơn 100
			if (isNaN(value) || value < 0) {
				input.value = "0"; // Đặt giá trị về 0 nếu nhỏ hơn 0
			} else if (value > 100) {
				input.value = "100"; // Đặt giá trị về 100 nếu lớn hơn 100
			}
		}
	</script> </content>
</body>
