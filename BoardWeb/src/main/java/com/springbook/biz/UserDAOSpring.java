package com.springbook.biz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOSpring {

	JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getUserList() {
		System.out.println("SPRING JDBC================getUserList");
		String sql = "select * from users order by 1 desc";
		return jdbcTemplate.queryForList(sql);

	}

	public List<UserVO> getUserList2() {
		System.out.println("SPRING JDBC================getUserList2");
		String sql = "select * from users order by 1 desc";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	public UserVO getUser(UserVO vo) {
		System.out.println("SPRING JDBC================getUser");
		String sql = "select * from users where id = ?";
		Object[] args = { vo.getId() };
		return jdbcTemplate.queryForObject(sql, args, new UserRowMapper());
	}

	public void insertUser(UserVO vo) {
		System.out.println("SPRING JDBC================insertUser");
		String sql = "insert into users values(?,?,?,?)";
		jdbcTemplate.update(sql, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	public void updateUser(UserVO vo) {
		System.out.println("SPRING JDBC================updateUser");
		String sql = "update users set password=?, name=?, role=? where id=?";
		jdbcTemplate.update(sql, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}

}

class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		UserVO vo = new UserVO();

		vo.setId(rs.getString("id"));
		vo.setPassword(rs.getString("password"));
		vo.setName(rs.getString("name"));
		vo.setRole(rs.getString("role"));

		return vo;
	}

}
