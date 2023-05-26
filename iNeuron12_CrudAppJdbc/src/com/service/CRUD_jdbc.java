package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_jdbc {

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

			// View records in the table
			String selectQuery = "select id,wname,cost,quantity  from company";
			System.out.println("implement class is" + conn.getClass().getName());
			stmt = conn.createStatement();
			System.out.println("implement class is" + stmt.getClass().getName());
			resultSet = stmt.executeQuery(selectQuery);

			System.out.println("SID\t NAME\t COST\t QUANTITY");
			while (resultSet.next()) {
				Integer sid = resultSet.getInt(1);
				String sname = resultSet.getString(2);
				Integer cst = resultSet.getInt(3);
				Integer qty = resultSet.getInt(4);

				System.out.println(sid + "\t" + sname + "\t" + cst + "\t" + qty);
			}

			// Add Record
			String insertQuery = "INSERT INTO company (wname, cost, quantity) VALUES ('fosssil', 30000, 2)";
			stmt.executeUpdate(insertQuery);

			// Update Record
			String updateQuery = "UPDATE company SET cost = 220000 WHERE wname = 'titan'";
			stmt.execute(updateQuery);

			// Delete a record
			String deleteQuery = "DELETE FROM company WHERE wname = 'raha'";
			stmt.executeUpdate(deleteQuery);

		}

		catch (ClassNotFoundException | SQLException e) {

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
