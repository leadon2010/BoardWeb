<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<h3>Model 2: 회원정보수정</h3>
	<a href="getUserList.do">회원목록보기</a>
	<form action="updateUser.do">
		${user}<br> 
		ID:<input name="id" type="text" value='${user.id}' />
		Password:<input type="text" name="password" value='${user.password }' />
		Name:<input type="text" name="name" value='${user.name }' /> 
		Role:<input type="text" name="role" value='${user.role }' /> 
		<input type="submit" value="수정" />
	</form>
</body>
</html>