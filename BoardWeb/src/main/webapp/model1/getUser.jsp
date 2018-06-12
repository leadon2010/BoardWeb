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
	<%
		String id = request.getParameter("id");
		System.out.println(id);
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		vo.setId(id);
		UserVO user = dao.getUser(vo);
	%>
	<h3>회원정보조회</h3>
	<%=user %><br>
	id:<%=user.getId()%><br>
	pw:<%=user.getPassword()%><br>
	name:<%=user.getName() %><br>
	roel:<%=user.getRole() %>
</body>
</html>