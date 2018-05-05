package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.User;

public class UserImplementantion implements UserInterface {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public User validateUser(String username, String password)  {
		User user = null;

		String query = "SELECT * FROM user WHERE username=? and password=?";
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, username);
			statement.setString(2, password);

			rs = statement.executeQuery();

			if (rs.next()) {
				user = new User();

				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public boolean register(User user) throws SQLException {

		String query = "INSERT INTO authentication.user(firstName,lastName, username, password) VALUES(?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}
	
	@Override
	public User update(User user, User editUser) throws SQLException {
		//User updatedUser = null;
		
		String query = "UPDATE authentication.user SET firstName = ?, lastName=? , username=?, password=? WHERE username=? AND password=?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, editUser.getFirstName());
			statement.setString(2, editUser.getLastName());
			statement.setString(3, editUser.getUsername());
			statement.setString(4, editUser.getPassword());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*query = "SELECT * FROM user WHERE username=? and password=?";
	
		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, editUser.getUsername());
			statement.setString(2, editUser.getPassword());

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				updatedUser = new User();

				updatedUser.setFirstName(rs.getString("firstName"));
				updatedUser.setLastName(rs.getString("lastName"));
				updatedUser.setUserName(rs.getString("username"));
				updatedUser.setPassword(rs.getString("password"));
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return validateUser(editUser.getUsername(),editUser.getPassword());
		

	}
	
}

