package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springbook.biz.common.ConnectionManager;
import com.springbook.biz.user.UserVO;

//@Repository
public class UserDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	public void updateUser(UserVO vo) {
		System.out.println("DAO================updateUser");
		try {
			conn = ConnectionManager.connect();
			String sql = "update users set password=?, name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "건 수정했습니다.");

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
	}// end of updateUser

	public void insertUser(UserVO vo) {
		System.out.println("DAO================insertUser");
		try {
			int p = 0;
			conn = ConnectionManager.connect();
			String sql = "insert into users values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++p, vo.getId());
			pstmt.setString(++p, vo.getPassword());
			pstmt.setString(++p, vo.getName());
			pstmt.setString(++p, vo.getRole());

			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 입력되었습니다.");

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
	}

	public List<Map<String, Object>> getUserList() {
		System.out.println("DAO================getUserList");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;

		try {
			conn = ConnectionManager.connect();
			String sql = "select * from users order by 1";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getString("id"));
				map.put("password", rs.getString("password"));
				map.put("name", rs.getString("name"));
				map.put("role", rs.getString("role"));

				System.out.println(map.get("id") + "::::::" + map.get("password") + ":::::::::" + map.get("name"));
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
	}// end of getUserList

	public UserVO getUser(UserVO vo) {
		System.out.println("DAO================getUser");
		String sql = "select * from users where id = ?";
		UserVO uvo = new UserVO();
		try {
			conn = ConnectionManager.connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				uvo.setId(rs.getString("id"));
				uvo.setPassword(rs.getString("password"));
				uvo.setName(rs.getString("name"));
				uvo.setRole(rs.getString("role"));

			}
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
		return uvo;
	}// end of getUser

}
