<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<link rel="stylesheet" href="/resource/res/css/bootstrap.min.css" />
<title>상품 상세 정보</title>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="" style="width: 100%" />
			</div>
			<div class="col-md-6">
				<h3></h3>
				<p>
				<p><b>상품 코드 : </b><span class="badge badge-danger"></span>
				<p><b>제조사</b> : 
				<p><b>분류</b> : 
				<p><b>재고 수</b> : 
				<h4>원</h4>
				<!-- <p><a href="#" class="btn btn-info"> 상품 주문 &raquo;</a> --> <a href="/products.do" class="btn btn-secondary"> 상품 목록 &raquo;</a>
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>
