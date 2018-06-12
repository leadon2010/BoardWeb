<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>사용자 목록</h3>
	<c:forEach items="${list}" var="user">
		${user}<br>
	</c:forEach>
</body>
</html>