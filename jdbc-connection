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
		String user = "zavada";
		String password = "zavada";
		
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Conected? " + !connection.isClosed());
		
		//addTeacher();
		selectTeachers();
		connection.close();
	}
	// INSERT INTO teacher(full_name, age) VALUES ("John_John", 45), ("Bill_Bill", 25);
	public static void addTeacher() throws SQLException {
		String query = "INSERT INTO teacher(full_name, age) " // String | INT 
				+ "VALUES (?, ?), (?, ?), (?, ?)";
		
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, "Java_JAVA");
		pstm.setInt(2, 34);
		
		pstm.setString(3, "Spring_Spring");
		pstm.setInt(4, 45);
		
		pstm.setString(5, "mySQL_MYSQL");
		pstm.setInt(6, 23);
		
		pstm.executeUpdate();
		
		System.out.println("Added new row to table Teacher");
		pstm.close();
	}
	
	public static void selectTeachers() throws SQLException {
		String query = "SELECT * FROM teacher";
		PreparedStatement pstm = connection.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + " | Full_name: " + rs.getString("full_name"));
		}
	}
}
