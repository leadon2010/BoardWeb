<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<h3>Model 2: 게시글등록하기</h3>
<a href="getBoardList.do">게시글목록보기</a>
<form action="insertBoard.do">
	title:<input type="text" name="title"/>
	writer:<input type="text" name="writer"/>
	content:<input type="text" name="content"/>
	<input type="submit" value="게시글등록"/>
</form>
<a href="getUserList.do">회원목록보기</a>
</body>
</html>