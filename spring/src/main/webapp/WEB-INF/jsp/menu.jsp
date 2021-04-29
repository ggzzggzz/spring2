<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="./welcome.do">Home</a>
        </div>
    </div>
    <div>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="/member/loginMember.do">로그인 </a></li>
            <li class="nav-item"><a class="nav-link" href='/member/addMember.do'>회원 가입</a></li>
            <li class="nav-item">${sessionId}</li>
        </ul>
    </div>
</nav>