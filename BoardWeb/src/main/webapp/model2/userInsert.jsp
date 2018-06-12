<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<h3>회원가입</h3>
<a href="getUserList.do">회원목록보기</a>
<form action="insertUser.do">
	ID:<input name="id" type="text"/>
	Password:<input type="text" name="password"/>
	Name:<input type="text" name="name"/>
	Role:<input type="text" name="role"/>
	<input type="submit" value="회원가입"/>
</form>
</body>
</html>