package ua.logos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	static Connection connection;
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/online_course";
		String user = "zavada"; //root
		String password = "zavada";

		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected? " + !connection.isClosed());
		
		addTeacher();
		selectTeachers();
		connection.close();
	}

	public static void addTeacher() throws SQLException {
		String query = "INSERT INTO teacher(full_name, age)"
				+ "VALUES (?, ?), (?, ?) ";
					//     1  2    3  4
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, "Bom_bom");
		pstm.setInt(2, 28);
		
		pstm.setString(3, "Bum_BUm");
		pstm.setInt(4, 78);
		
		pstm.executeUpdate();
		System.out.println("Added to Teacher table");
	}
	
	public static void selectTeachers() throws SQLException {
		String query = "SELECT * FROM teacher";
		PreparedStatement pstm = connection.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + " | " + rs.getString("full_name") + " | " + rs.getInt("age"));
		}
		pstm.close();
	}
	
}
