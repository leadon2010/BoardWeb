package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1l;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	public void init() {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");

	}

	protected void goGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));

		Controller ctrl = handlerMapping.getController(path);
		String viewName = ctrl.handleRequest(request, response);

		String view = null;
		if (!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		response.sendRedirect(view);
	}
}
