package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {

	public static Connection connect() {
		Connection conn = null;
		String cond = "1";
		try {

			if (cond.equals("1")) {
				// 1. connection pool 방법으로 변경할 것. 사용안함.
				String jdbc_driver = "oracle.jdbc.OracleDriver";
				String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

				// 1.DB connect
				Class.forName(jdbc_driver);
				// 2.연결 URL, driver name
				conn = DriverManager.getConnection(jdbc_url, "spring", "spring");
				// System.out.print("JDBC 연결성공!");
			} else {
				// new 2. connection pool 연결방법으로 처리한다.
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/spring");

				// conn
				conn = ds.getConnection();
				System.out.print("Connection Pool 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}// end of connect()

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of close()

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}

		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
