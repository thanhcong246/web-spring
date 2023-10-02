<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Sản phẩm</title>

</head>

<body>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px; font-size: 20px; font-weight: bold;">Danh
				sách sản phẩm</span> <select class="pull-right">
				<option>A-Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>
		<div class="row-fluid">
			<c:if test="${productsPaginate.size() > 0}">
				<ul class="thumbnails">
					<c:forEach var="item" items="${productsPaginate }" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a
									href="<c:url value="/chi-tiet-san-pham/${item.id_product }" />"
									class="overlay"></a> <a class="zoomTool"
									href="<c:url value="/chi-tiet-san-pham/${item.id_product }" />"
									title="add to cart"><i class="fa-solid fa-magnifying-glass"></i>
									Xem</a> <a
									href="<c:url value="/chi-tiet-san-pham/${item.id_product }" />"><img
									src='<c:url value="/assets/user/img/${item.img }" />' alt=""></a>
								<div class="caption cntr">
									<p>${item.name }</p>
									<p>
										<strong><fmt:formatNumber type="number"
												groupingUsed="true" value="${item.price }" />₫ </strong>
									</p>
									<h4>
										<a class="shopBtn" href="#" title="add to cart"> Add to
											cart </a>
									</h4>
									<div class="actionList">
										<a class="pull-left" href="#">Add to Wish List </a> <a
											class="pull-left" href="#"> Add to Compare </a>
									</div>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if
							test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == productsPaginate.size() }">
				</ul>
				<c:if test="${(loop.index + 1) < productsPaginate.size() }">
					<ul class="thumbnails">
				</c:if>
			</c:if>
			</c:forEach>
			</c:if>
		</div>

	</div>

	<div class="pagination">
		<c:forEach var="item" begin="1" end="${paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${(loop.index) == paginateInfo.currentPage }">
				<a href='<c:url value="/san-pham/${idCategory }/${loop.index }" />'
					class="active">${loop.index }</a>
			</c:if>
			<c:if test="${(loop.index) != paginateInfo.currentPage }">
				<a href='<c:url value="/san-pham/${idCategory }/${loop.index }" />'>${loop.index }</a>
			</c:if>
		</c:forEach>
	</div>

</body>
