<%@page import="com.springbook.biz.UserVO"%>
<%@page import="com.springbook.biz.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>Model 2: 회원정보조회</h3>
	<a href="getUserList.do">회원목록보기</a><br>
	id:${user.getId()}
	<br> pw:${user.getPassword()}
	<br> name:${user.getName() }
	<br> role:${user.getRole() }
</body>
</html>