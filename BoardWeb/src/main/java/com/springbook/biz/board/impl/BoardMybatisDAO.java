package com.springbook.biz.board.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardMybatisDAO {

	// private SqlSession sqlSession;
	@Autowired
	SqlSessionTemplate sqlSession;

	// public BoardMybatisDAO() {
	// sqlSession = SqlsessionFactoryBean.getSqlSessionInstance();
	// }

	public void insertBoard(BoardVO vo) {
		sqlSession.insert("boardDAO.insertBoard", vo);
		sqlSession.commit();
	}

	public void updateBoard(BoardVO vo) {
		sqlSession.update("boardDAO.updateBoard", vo);
		sqlSession.commit();
	}

	public void deleteBoard(BoardVO vo) {
		sqlSession.delete("boardDAO.deleteBoard", vo);
		sqlSession.commit();
	}

	public BoardVO getBoard(BoardVO vo) {
		return sqlSession.selectOne("boardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList2() {
		return sqlSession.selectList("boardDAO.getBoardList");
	}

	public List<Map<String, Object>> getBoardList() {
		return sqlSession.selectList("boardDAO.getBoardList");
	}

}
