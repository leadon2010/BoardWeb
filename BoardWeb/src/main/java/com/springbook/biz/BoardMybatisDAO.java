package com.springbook.biz;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardMybatisDAO {
	// SqlSessionTemplate sqlSession;
	private SqlSession sqlSession;

	public BoardMybatisDAO() {
		sqlSession = SqlsessionFactoryBean.getSqlSessionInstance();
	}

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

	public List<BoardVO> getBoardList() {
		return sqlSession.selectList("boardDAO.getBoardList");
	}

}
