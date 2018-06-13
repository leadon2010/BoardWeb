package com.springbook.biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("request uri ::::::::::::::::" + path);

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		UserVO vo = new UserVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setRole(request.getParameter("role"));

		UserDAO dao = new UserDAO();

		BoardVO bvo = new BoardVO();

		if (request.getParameter("seq") != null && !request.getParameter("seq").equals(""))
			bvo.setSeq((Integer.parseInt(request.getParameter("seq"))));

		bvo.setTitle(request.getParameter("title"));
		bvo.setWriter(request.getParameter("writer"));
		bvo.setContent(request.getParameter("content"));

		BoardDAO bdao = new BoardDAO();

		if (path.equals("/login.do")) {
			System.out.println("UserServlet================login");

			UserVO result = dao.getUser(vo);

			if (result == null) {
				out.print("<script>alert('id error');history.go(-1);</script>");

			} else if (vo.getPassword().equals(result.getPassword())) {
				session.setAttribute("id", result.getId());
				response.sendRedirect("getUser.do?id=" + vo.getId());

			} else {
				out.print("<script>alert('pw error');history.go(-1);</script>");

			}
		} else if (path.equals("/logout.do")) {
			System.out.println("UserServlet================logout");

		} else if (path.equals("/insertUser.do")) {
			System.out.println("UserServlet================insertUser");

			dao.insertUser(vo);
			response.sendRedirect("getUserList.do");

		} else if (path.equals("/getUser.do")) {
			System.out.println("UserServlet================getUser");

			request.setAttribute("user", dao.getUser(vo));
			request.getRequestDispatcher("getUser.jsp").forward(request, response);

		} else if (path.equals("/updateUserForm.do")) {
			System.out.println("UserServlet================updateUserForm");

			request.setAttribute("user", dao.getUser(vo));
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);

		} else if (path.equals("/updateUser.do")) {
			System.out.println("UserServlet================updateUser");

			dao.updateUser(vo);
			// request.setAttribute("list", dao.getUserList());
			// response.sendRedirect("getUserList.jsp");
			response.sendRedirect("getUserList.do");

		} else if (path.equals("/getUserList.do")) {
			System.out.println("UserServlet================getUserList");

			request.setAttribute("list", dao.getUserList());
			request.getRequestDispatcher("getUserList.jsp").forward(request, response);

		} else if (path.equals("/getBoardList.do")) {
			System.out.println("UserServlet================getUserList");

			request.setAttribute("boardlist", bdao.getBoardList());
			request.getRequestDispatcher("getBoardList.jsp").forward(request, response);

		} else if (path.equals("/getBoard.do")) {
			System.out.println("UserServlet================getBoard");

			request.setAttribute("board", bdao.getBoard(bvo));
			request.getRequestDispatcher("getBoard.jsp").forward(request, response);

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("UserServlet================insertBoard");

			bdao.insertBoard(bvo);
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoard.do")) {
			System.out.println("UserServlet================updateBoard");

			bdao.updateBoard(bvo);
			response.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoardForm.do")) {
			System.out.println("UserServlet================updateBoardForm");

			request.setAttribute("board", bdao.getBoard(bvo));
			request.getRequestDispatcher("updateBoard.jsp").forward(request, response);

		} else {
			System.out.println("UserServlet================else");

		}
	}

}
