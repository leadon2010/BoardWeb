package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	// BoardDAO dao;
	// BoardDAOSpring dao;
	BoardMybatisDAO dao;

	// private Log4jAdvice log = new Log4jAdvice();

	@Override
	public List<Map<String, Object>> getBoardList() {
		// log.printLogging();
		System.out.println("board service list ===== ");
		// int a = 5 / 0;
		return dao.getBoardList();
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// log.printLogging();
		System.out.println("board getboard list ===== ");
		return dao.getBoard(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// log.printLogging();
		// dao.insertBoard(vo);
		dao.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		// log.printLogging();
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
	}

	@Override
	public void deleteBoardList(List<String> list) {

	}

	@Override
	public List<BoardVO> getBoardList2() {
		// TODO Auto-generated method stub
		return dao.getBoardList2();
	}

}
