<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>Model 2: 게시글정보수정</h3>
	<a href="getBoardList.do">게시글목록보기</a>
	<form action="updateBoard.do">
		${board}<br>
		seq:<input type="text" name="seq" value='${board.getSeq()}' /><br>
		title:<input type="text" name="title" value='${board.getTitle()}' /><br>
		writer:<input type="text" name="writer" value='${board.getWriter()}' /><br>
		content:<input type="text" name="content" value='${board.getContent()}' /><br>
		<input type="submit" value="수정" />
	</form>
</body>
</html>