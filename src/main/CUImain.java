package main;

import java.sql.SQLException;
import java.util.Scanner;
import DAO.UserImplementantion;
import DTO.User;

public class CUImain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int choice = mainMenu (input);
		//System.out.println(choice);
		
		switch (choice) {
		case 1:
			User validUser = login (input);
			
			if (validUser == null){
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				//signup(input);
			} else {
				welcome(validUser);
				int choice2=loginMenu(input);
				switch (choice2) {
				case 1:
					edit(input, validUser);
					break;
				case 2:
					exit();
					break;
				default:
					break;
				};
			}
			break;
		case 2:
			// metoda singup
			signup(input);
			break;
		default:
			choice = mainMenu(input);
			break;
		};
		
		
		input.close();
		
		
		
	}

	public static int mainMenu(Scanner input) {
		System.out.println("User authentification form");
		System.out.println("----------------------------------------------");
		System.out.println("1. Log In");
		System.out.println("2. Sign Up");
		System.out.println("----------------------------------------------");

		System.out.println("What do you want to do?");
		int choice = input.nextInt();
		return choice;
	}
	
	public static User login(Scanner input) {
		System.out.println("----------------------------------------------");
		System.out.print("username: ");
		String username = input.next();
		System.out.print("password: ");
		String passwrd = input.next();
		System.out.println("----------------------------------------------");

		UserImplementantion user = new UserImplementantion();

		User validUser = user.validateUser(username, passwrd);

		return validUser;

	}

	public static void welcome(User validUser) {
		System.out.println("Welcome " + validUser.getUsername());
		System.out.println("***********************************");
		System.out.println(" First name: " + validUser.getFirstName());
		System.out.println(" Last  name: " + validUser.getLastName());
		System.out.println("   username: " + validUser.getUsername());
		System.out.println("   password: " + validUser.getPassword());
		System.out.println("***********************************");
	}
	
	public static void signup(Scanner input){
		UserImplementantion userDAO = new UserImplementantion();
		
		System.out.println();
		System.out.println("Please fill the fields");
		System.out.println("----------------------------------------------");
		System.out.print("First name: ");
		String firstname = input.next();
		System.out.print("Last name: ");
		String lastname = input.next();
		System.out.print("username: ");
		String username = input.next();
		System.out.print("password: ");
		String password = input.next();
		System.out.println("----------------------------------------------");
		
		User user = new User(firstname, lastname, username, password);
		try {

			if (userDAO.register(user)) {
				welcome(user);
				System.out.println("You are succesfully registered!");
				//mainMenu(input);
			} ;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static int loginMenu(Scanner input) {
		System.out.println("Choose your next action:");
		System.out.println("----------------------------------------------");
		System.out.println("1. Edit");
		System.out.println("2. Exit");
		System.out.println("----------------------------------------------");

		System.out.println("What do you want to do?");
		int choice = input.nextInt();
		return choice;
	}
	
	public static void exit(){
		System.out.println("---------------------------------------------");
		System.out.println("You are succesfully loged out!");
	}
	
	public static void edit(Scanner input, User user) {
		
		UserImplementantion userDAO = new UserImplementantion();

		System.out.println();
		System.out.println("Please fill the fields");
		System.out.println("----------------------------------------------");
		System.out.print("First name (" + user.getFirstName() + ") :");
		String firstname = input.next();
		System.out.print("Last name(" + user.getLastName() + ") :");
		String lastname = input.next();
		System.out.print("username(" + user.getUsername() + ") :");
		String username = input.next();
		System.out.print("password(" + user.getPassword() + ") :");
		String password = input.next();
		System.out.println("----------------------------------------------");

		User editUser = new User(firstname, lastname, username, password);
		try {

			welcome(userDAO.update(userDAO.validateUser(user.getUsername(), user.getPassword()), editUser));
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
