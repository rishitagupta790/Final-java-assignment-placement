package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadJDBC {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {

			// 1.load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql:///app";
			String user = "root";
			String password = "root";

			conn = DriverManager.getConnection(url, user, password);

			String sqlSelectQuery = "select id,ename,eage, mobile,email from employee";
			System.out.println("implement class is" + conn.getClass().getName());
			stmt = conn.createStatement();
			System.out.println("implement class is" + stmt.getClass().getName());
			resultSet = stmt.executeQuery(sqlSelectQuery);

			System.out.println("SID\t SNAME\t SAGE\t SADDR");
			while (resultSet.next()) {
				Integer sid = resultSet.getInt(1);
				String sname = resultSet.getString(2);
				Integer sage = resultSet.getInt(3);
				String num = resultSet.getString(4);
				String mail = resultSet.getString(5);

				System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + num + "\t" + mail);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

}
