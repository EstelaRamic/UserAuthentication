package DTO;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	//public boolean valid;

	public User(){
		
	}
	
	public User( String firstName, String lastName, String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String newUsername) {
		username = newUsername;
	}

	/*public boolean isValid() {
		return valid;
	}*/

	/*public void setValid(boolean newValid) {
		valid = newValid;
	}*/

	@Override
	public String toString() {
		return "User [first name=" + firstName + ", last name=" + lastName + ", username=" + username + ", password="
				+ password + "]"; //", valid user=" + valid + "]";
	}
}
