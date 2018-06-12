package com.springbook.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springbook.biz.common.ConnectionManager;

//@Repository("boardDAO")
public class BoardDAO {

	static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;

	public void deleteBoard(BoardVO vo) {
		int rowCount = 0;
		String sql = "delete from board where seq = ?";
		try {
			conn = ConnectionManager.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSeq());
			rowCount = pstmt.executeUpdate();

			System.out.println(rowCount + " 건 수정됐습니다.");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}// end of deleteBoard

	public void updateBoard(BoardVO vo) {
		int rowCount = 0;
		String sql = "UPDATE board SET title=?, writer=?, content=?, regdate=SYSDATE WHERE  seq = ?";
		try {
			conn = ConnectionManager.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getSeq());

			rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "건 수정되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}// end of updateBoard

	public int insertBoard(BoardVO vo) {
		int rowCount = 0;
		String sql = "INSERT INTO board VALUES ((SELECT MAX(seq) + 1 FROM board),?,?,?,SYSDATE,0)";
		try {
			conn = ConnectionManager.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "건 입력되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowCount;
	}// end of insertBoard(BoardVO vo)

	public List<Map<String, Object>> getBoardList() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;

		try {
			conn = ConnectionManager.connect();
			String sql = "select * from board order by 1";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("seq", rs.getInt("seq"));
				map.put("title", rs.getString("title"));
				map.put("writer", rs.getString("writer"));
				map.put("content", rs.getString("content"));
				map.put("regDate", rs.getString("regdate"));
				map.put("cnt", rs.getInt("cnt"));

				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}// end of getBoardList()

	public BoardVO getBoard(BoardVO pvo) {
		BoardVO vo = null;
		try {
			conn = ConnectionManager.connect();
			String sql = "select * from board where to_char(seq) = " + pvo.getSeq();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO();
				vo.setCnt(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return vo;
	}// end of getBoard(String b_seq)

}
