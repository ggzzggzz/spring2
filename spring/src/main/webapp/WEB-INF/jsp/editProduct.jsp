<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="./resource/res/css/bootstrap.min.css" />
<title>상품 편집</title>
<script type="text/javascript">
	function deleteConfirm(productId) {
		if (confirm("해당 상품을 삭제합니다!!") == true)
			location.href = "/deleteProduct.do?productId=" + productId;
		else
			return;
	}
</script>
</head>
<%
	String edit = request.getParameter("edit");
%>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 편집</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<div class="col-md-4">
				<c:forEach var="result" items="" varStatus="status">
					<img src="" style="width: 100%">
				<h3></h3>
				<p>
				<p>$원
				<p><a href="./updateProduct.do?productId=" class="btn btn-success" role="button"> 수정 &raquo;></a>
				<a href="#" onclick="deleteConfirm('')" class="btn btn-danger" role="button">삭제 &raquo;></a>
				</c:forEach>	
			</div>
				
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>