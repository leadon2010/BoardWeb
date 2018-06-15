package com.springbook.biz;

import java.util.List;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardMybatisDAO;

public class BoardServiceClient {
	public static void main(String[] args) {
		BoardMybatisDAO boardDAO = new BoardMybatisDAO();
		BoardVO vo = new BoardVO();

		vo.setTitle("new case 3");
		vo.setWriter("홍길동3");
		vo.setContent("mybatis 내용3");
		boardDAO.insertBoard(vo);

		//vo.setSearchKeyword("title");
		//vo.setSearchCondition("case");

		List<BoardVO> boardlist = boardDAO.getBoardList2();
		for (BoardVO list : boardlist) {
			System.out.println("--->" + list.toString());
		}
	}
}
