package com.springbook.biz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BoardClient2 {
	BoardDAO dao;

	@Before
	public void init() {
		dao = new BoardDAO();
	}

	@Test
	public void boardDaoTest(BoardVO pvo) {
		BoardVO vo = dao.getBoard(pvo);
		// assertEquals(vo.getWriter(), "관리자");

		assertNotNull(vo);
	}

	@Test
	public void boardDaoListTest() {
		List<Map<String, Object>> list = dao.getBoardList();
		assertEquals(list.size(), 1);

	}

}
