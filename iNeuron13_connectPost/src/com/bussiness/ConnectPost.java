package com.bussiness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class PostAccess {
	int operation() {
		String url = "jdbc:postgresql:///RishitaDB";
		String user = "root123";
		String pass = "root";
		String inputFile = "student.txt"; // Path to input file
		String sql = "INSERT INTO student (sname, saddress,sage) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line;
			int count = 0;

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				stmt.setString(1, data[0]);
				stmt.setString(2, data[1]);
				stmt.setInt(3, Integer.parseInt(data[2]));
				stmt.addBatch();
				count++;
				if (count % 1000 == 0) {
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}

			stmt.executeBatch();
			System.out.println("Batch update completed successfully.");
		} catch (SQLException | NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}

public class ConnectPost {

	public static void main(String[] args) {
		PostAccess pa = new PostAccess();
		pa.operation();
	}

}
