<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>Model 2: 회원목록보기</h3>
	<a href="insertUser.jsp">회원가입하기</a>
	<c:forEach items="${list}" var="vo">
		<div style="border: 1px solid blue;">
			id:<a href="updateUserForm.do?id=${vo.id}&password=${vo.password}&name=${vo.name}&role=${vo.role}">${vo.id}</a><br>
			pw:${vo.password}<br> 
			name:${vo.name}<br>
			role:${vo.role}
		</div>
	</c:forEach>
	<a href="getBoardList.do">게시판목록보기</a><br>
</body>
</html>