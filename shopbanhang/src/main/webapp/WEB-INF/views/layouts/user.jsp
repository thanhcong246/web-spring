<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="Master-layout" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css" />"
	rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css" />" rel="stylesheet" />

<!-- Customize styles -->
<link href="<c:url value="/assets/user/style1.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link href="<c:url value="/assets/user/font-awesome/css/all.min.css" />"
	rel="stylesheet">

<link rel="shortcut icon"
	href="<c:url value="/assets/user/ico/logo.png" /> ">

</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><i class="fa-brands fa-facebook"></i></a> <a href="#"><i
							class="fa-brands fa-twitter"></i></a> <a href="#"><i
							class="fa-brands fa-youtube"></i></a> <a href="#"><i
							class="fa-brands fa-apple"></i></a>
					</div>
					<a class="nav-link" href='<c:url value="/" />'> <i
						class="fa-solid fa-house"></i> Trang Chủ
					</a>

					<c:if test="${not empty LoginInfo}">
						<a href="#"><span class="fa-solid fa-user"></span>
							${LoginInfo.display_name }</a>
					</c:if>
					<c:if test="${empty LoginInfo}">
						<a class="nav-link" href='<c:url value="/dang-nhap" />'><span
							class="fa-solid fa-user"></span> Đăng Nhập </a>
					</c:if>
					<a href="contact.html"><i class="fa-solid fa-envelope"></i> TC
						Shop</a> <a class="nav-link" href="<c:url value="/gio-hang" />"><span
						class="fa-solid fa-cart-shopping"></span> Số lượng:
						${TotalQuantyCart } - <span class="badge badge-warning"><fmt:formatNumber
								type="number" groupingUsed="true" value="${TotalPriceCart }" />₫
					</span></a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>

		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

		<decorator:body />

		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
		<!-- /container -->
	</div>

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img
					src="<c:url value="/assets/user/img/maestro.png" />" alt="payment"></a>
				<a href="#"><img src="<c:url value="/assets/user/img/mc.png" />"
					alt="payment"></a> <a href="#"><img
					src="<c:url value="/assets/user/img/pp.png" />" alt="payment"></a>
				<a href="#"><img
					src="<c:url value="/assets/user/img/visa.png" />" alt="payment"></a>
				<a href="#"><img
					src="<c:url value="/assets/user/img/disc.png" />" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2023<br> congnt.21it@vku.udn.vn
			</span>
		</div>
	</div>
	<a href="#" class="gotop" id="goTopBtn"> <i
		class="fa-solid fa-angles-up" style="margin-top: 4px"></i>
	</a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/assets/user/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value="/assets/user/js/shop.js" />"></script>

	<!--  -->
	<decorator:getProperty property="page.script"></decorator:getProperty>

	<script type="text/javascript">
		// sử lý active
		document.addEventListener("DOMContentLoaded", function() {
			var currentPageURL = window.location.pathname;
			var navLinks = document.querySelectorAll(".nav-link");

			navLinks.forEach(function(link) {
				var linkURL = link.getAttribute("href");
				var linkURL1 = "shopbanhang" + link.getAttribute("href");
				if ((linkURL === currentPageURL)
						|| (linkURL1 === currentPageURL)) {
					link.classList.add("active");
				} else {
					link.classList.remove("active");
				}
			});
		});

		// Lắng nghe sự kiện scroll
		window.addEventListener('scroll', function() {
			var goTopBtn = document.getElementById('goTopBtn');

			// Hiển thị hoặc ẩn nút "trượt về đầu trang" dựa trên vị trí cuộn
			if (window.pageYOffset > 100) { // Thay 100 bằng ngưỡng bạn muốn
				goTopBtn.style.display = 'block';
			} else {
				goTopBtn.style.display = 'none';
			}
		});

		// Xử lý khi nút được bấm
		document.getElementById('goTopBtn').addEventListener('click',
				function() {
					// Cuộn trang về đầu
					window.scrollTo({
						top : 0,
						behavior : 'smooth' // Tạo hiệu ứng trượt mượt
					});
				});
	</script>
</body>
</html>
