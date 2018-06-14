package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		// 1.컨테이너(=applicationContext)
		@SuppressWarnings("resource")
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// boardService (DI)
		BoardService boardService = (BoardService) container.getBean("boardService");
		BoardVO vo = new BoardVO();
		vo.setTitle("client test");
		vo.setContent("content test");
		vo.setWriter("writer");

		boardService.insertBoard(vo);

		// 글목록 조회
		List<Map<String, Object>> list = boardService.getBoardList();

		for (Map<?, ?> map : list) {
			System.out.println(map.get("seq") + " : " + map.get("title") + " : " + map.get("content"));
		}

	}

}
