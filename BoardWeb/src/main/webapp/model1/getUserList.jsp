<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		List<Map<String, Object>> userlist = dao.getUserList();
	%>
	<h3>회원정보조회</h3>
	<%
		for (Map user : userlist) {
	%>
	<div style="border: 1px solid blue;">
		id:<a href="getUser.jsp?id='<%=user.get("id")%>'"><%=user.get("id") %></a><br>
		pw:<%=user.get("password") %><br>
		name:<%=user.get("name") %><br>
		role:<%=user.get("role") %>
	</div>
	<%
		}
	%>
</body>
</html>