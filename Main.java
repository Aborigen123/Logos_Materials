package ua.logos.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	static Connection connection;
		
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/online_course";// online_course - назва бази даних(створіть її ще до початку роботи з Java)
		String user = "username"; // ваш username
		String password = "password"; // ваш password
		
		connection = DriverManager.getConnection(url, user, password);
		System.out.println("Connected? " + !connection.isClosed());
		
		addRow();
		selectRows();
		System.out.println();
		selectWithJoin();
		//deleteById();
		updateById();
		connection.close();
	}
	
	public static void addRow() throws SQLException {
		String query = "INSERT INTO "
				+ "teacher(first_name, last_name, age, description) "
				+ "VALUES (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?); ";
		
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, "Tim");
		pstm.setString(2, "Buchalka");
		pstm.setInt(3, 45);
		pstm.setString(4, "jksdfidsnjdsfs");
		
		pstm.setString(5, "ERTYUI");
		pstm.setString(6, "djfkvhidsunvds");
		pstm.setInt(7, 45);
		pstm.setString(8, "sdkjioewfjs");
		
		pstm.setString(9, "Uhascash");
		pstm.setString(10, "Djsdnvkdj");
		pstm.setInt(11, 45);
		pstm.setString(12, "sajfdshiufhdu");
		
		pstm.executeUpdate();
		System.out.println("Insert data to Teacher table");
		pstm.close();
	}

	public static void selectRows() throws SQLException {
		String query = "SELECT * FROM teacher;";
		PreparedStatement pstm = connection.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
	
		while(rs.next()) {
			System.out.println(
					"ID: " + rs.getInt("id") + " | " + 
					"First Name: " + rs.getString("first_name") + " | " +
					"Last Name: " + rs.getString("last_name") + " | " + 
					"Age: " + rs.getInt("age") + " | " + 
					"Description: " + rs.getString("description"));
		}
		pstm.close();
	}
	
	public static void selectWithJoin() throws SQLException {
		String query = "SELECT "
				+ "c.title, c.price, "
				+ "t.first_name AS teacher_first_name, "
				+ "t.last_name AS teacher_last_name, "
				+ "t.description "
				+ "FROM course c "
				+ "JOIN teacher t ON t.id = c.teacher_id "
				+ "ORDER BY c.title asc;";
		PreparedStatement pstm = connection.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"Title: " + rs.getString("title") + " | " + 
				    "Price: " + rs.getDouble("price") + " | " +
					"Teacher First name: " + rs.getString("teacher_first_name") + " | " +
				    "Teacher Last Name: " + rs.getString("teacher_last_name") + " | " +
					"Description: " + rs.getString("description")
					);
		}
		
		pstm.close();
	}
	
	public static void deleteById() throws SQLException {
		String query = "DELETE FROM teacher WHERE id = ?;";
		
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setInt(1, 5);
		
		pstm.executeUpdate();
		pstm.close();
	}
	
	public static void updateById() throws SQLException {
		String query = "UPDATE teacher SET isdeleted = ? WHERE id = ?;";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setBoolean(1, true);
		pstm.setInt(2, 6);
		pstm.executeUpdate();
		
		pstm.close();
	}
}
