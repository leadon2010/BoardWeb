<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");

	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(pw);

	UserDAO dao = new UserDAO();
	UserVO result = dao.getUser(vo);

	if (result == null) {
		out.print("<script>alert('id error');history.go(-1);</script>");

	} else if (pw.equals(result.getPassword())) {
		session.setAttribute("id", result.getId());
		response.sendRedirect("getUser.jsp?id=" + id);

	} else {
		out.print("<script>alert('pw error');history.go(-1);</script>");

	}
%>