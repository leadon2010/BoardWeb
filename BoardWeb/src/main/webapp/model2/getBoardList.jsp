<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>Model 2: 게시판목록</h3>
	<a href="insertBoard.jsp">게시글등록하기</a>
	<c:forEach items="${boardlist}" var="board">
		<div style="border: 1px solid blue;">
			seq:<a href="getBoard.do?seq=${board.seq}">${board.seq}</a><br>
			title:${board.title}<br>
			writer:${board.writer}<br>
			content:${board.content}<br>
			regdate:${board.regdate}<br>
		</div>
	</c:forEach>
	<a href="getUserList.do">회원목록보기</a><br>
</body>
</html>