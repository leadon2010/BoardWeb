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
	<h3>Model 2: 게시글정보조회</h3>
	<a href="getBoardList.do">게시판목록보기</a><br>
	seq:${board.getSeq()}<br>
	pw:${board.getTitle()}<br>
	name:${board.getWriter()}<br>
	role:${board.getContent()}<br>
	regDate:${board.getRegDate()}<br>
</body>
</html>