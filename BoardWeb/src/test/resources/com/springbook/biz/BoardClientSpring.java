package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:transactionContext.xml" })
public class BoardClientSpring {

	@Autowired
	BoardService boardService;

	@Test
	public void BoardInsertTest() {

		BoardVO vo = new BoardVO();

		vo.setTitle("제목123");
		vo.setContent("내용123");
		vo.setWriter("작성자123");
		vo.setSeq(3);

		boardService.insertBoard(vo);

		// 글목록 조회
		List<Map<String, Object>> list = boardService.getBoardList();
		System.out.println("getBoardList 111111111111111111111");
		for (Map<?, ?> map : list) {
			System.out.println(
					map.get("seq") + " : " + map.get("title") + " : " + map.get("writer") + " : " + map.get("content"));
		}

		List<BoardVO> volist = boardService.getBoardList2();
		System.out.println("getBoardList 222222222222222222222");
		for (BoardVO vo2 : volist) {
			System.out.println(vo2.getSeq() + " : " + vo2.getTitle() + " : " + vo2.getContent());

		}

	}

}
