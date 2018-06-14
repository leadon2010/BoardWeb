<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>게시판</h3>
	<table border="1">
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.seq}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>$320,800</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>