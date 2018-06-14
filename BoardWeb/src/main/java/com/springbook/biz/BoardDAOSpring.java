package com.springbook.biz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//@Repository("boardDAO")
public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void deleteBoard(BoardVO vo) {
		System.out.println("JDBC Connect================");
		String sql = "delete from board where seq = ?";
		jdbcTemplate.update(sql, vo.getSeq());

	}

	public void insertBoard(BoardVO vo) {
		System.out.println("JDBC Connect================");
		// String sql = "INSERT INTO board VALUES ((SELECT MAX(seq) + 1 FROM board),?,?,?,SYSDATE,0)";
		String sql = "INSERT INTO board VALUES (?,?,?,?,SYSDATE,0)";
		jdbcTemplate.update(sql, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());

	}

	public void updateBoard(BoardVO vo) {
		System.out.println("JDBC Connect================");
		String sql = "UPDATE board SET title=?, writer=?, content=?, regdate=SYSDATE WHERE  seq = ?";
		jdbcTemplate.update(sql, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq());

	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("JDBC Connect================");
		String sql = "SELECT * FROM board WHERE seq = ?";
		Object[] args = { vo.getSeq() };
		jdbcTemplate.queryForObject(sql, args, new BoardRowMapper());

		return null;

	}

	public List<Map<String, Object>> getBoardList() {
		System.out.println("JDBC Connect================");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from board order by 1";
		list = jdbcTemplate.queryForList(sql);

		return list;
	}

	public List<BoardVO> getBoardList2() {
		String sql = "select * from board order by 1";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}

}

class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BoardVO vo = new BoardVO();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getString("regdate"));
		vo.setCnt(rs.getInt("cnt"));
		return vo;
	}

}