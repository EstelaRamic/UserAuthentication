package DAO;

import java.sql.SQLException;
import DTO.User;

public interface UserInterface {

	public User validateUser(String username, String password);

	public boolean register(User user) throws SQLException;
	
	public User update(User user, User editUser) throws SQLException;

}
