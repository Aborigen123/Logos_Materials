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
		String user = "zavada";  // root
		String password = "zavada"; // 123456
		
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected? " + !connection.isClosed());
		
		//addTeachers();
		selectTeachers();
		connection.close();
	}
	
	/*	full_name VARCHAR(100),
    	age INT
	*/
	public static void addTeachers() throws SQLException {//		1  2    3  4    5  6
		String query = "INSERT INTO teacher(full_name, age) VALUES (?, ?), (?, ?), (?, ?);";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, "Tim_Bim");
		pstm.setInt(2, 45);
		
		pstm.setString(3, "Bim_Bim");
		pstm.setInt(4, 56);
		
		pstm.setString(5, "Nop_Nop");
		pstm.setInt(6, 12);
		
		pstm.executeUpdate();
		System.out.println("Teachers added");
		pstm.close();
	}
	
	public static void selectTeachers() throws SQLException {
		String query = "SELECT * FROM teacher;";
		PreparedStatement pstm = connection.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + 
					" | " + rs.getString("full_name") +
					" | " + rs.getInt("age"));
		}
	}
}