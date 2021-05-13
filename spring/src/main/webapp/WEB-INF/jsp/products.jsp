<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="/resource/res/css/bootstrap.min.css" />
<title>상품 목록</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 목록</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row" align="center">
			<div class="col-md-4">
				<c:forEach var="result" items="${list}" varStatus="status">
                    <img src="${result.fileName}" style="width: 100%">
                <h3>${result.pname}</h3>
                <p>${result.description}
                <p>${result.unitPrice}원
                <p><a href="/product.do?productId=${result.productId}"class="btn btn-secondary" role="button">상세 정보 &raquo;></a>
                </c:forEach>	
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>
