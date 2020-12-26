package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회");
		String seq = request.getParameter("seq");

		BoardVO board = new BoardVO();
		board.setSeq(Integer.parseInt(seq));

		HttpSession session = request.getSession();
		session.setAttribute("board", board);

		return "getBoard";
	}
}
