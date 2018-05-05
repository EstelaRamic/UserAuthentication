package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	// localhost//imeBazeNaKojuSeSpajamo
	private static final String CONN_STRING = "jdbc:mysql://localhost/authentication";
	// error? dodati na kraj stringa ?useSSL=false

	public static void main(String[] args) throws SQLException {

		// napraviti SQL Query
		String query = "CREATE TABLE user (" +  
		"firstName VARCHAR(70)," + 
		"lastName VARCHAR(70)," + 
		"username VARCHAR(70)," + 
		"password VARCHAR(70)" + ");";
		
		

		try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				// java.sql.Statement
				Statement statement = connection.createStatement();) {
			// pokrenuti query
			statement.executeUpdate(query);
			System.out.println("Baza podataka uspjesno updateana.");
		}
	}
}
