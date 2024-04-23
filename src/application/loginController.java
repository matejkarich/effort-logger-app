package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.input.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import javafx.event.*;

//The following code was implemented by Richard Matejka

public class loginController {
	public loginController(){
		
	}
	
	@FXML 
	private Button loginButton;
	
	@FXML 
	private Button signUpButton;
	
	@FXML
	private Label loginSuccess;
	
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	private Main m = new Main();
	
	private UserManager userManager = new UserManager();
	
	//private Dictionary<String, String> users = new Hashtable<>(); //temporary data structure instead of a database
	//private ArrayList<String> names = new ArrayList<String>();	//stores usernames for parsing for duplicates
	private boolean duplicate = false, access = false;
	
	@FXML
	public void gotoHome(ActionEvent event) throws IOException {
		//Richard's Code Here 
		//If Login Successful
        Enumeration<String> keys = Main.users.keys();	//Enumeration object used to iterate through the dictionary
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();	//iterates to the next element in the dictionary while storing the current one in the variable
			if (hash(username.getText().toString()).equals(key)) {
				if (hash(password.getText().toString()).equals(Main.users.get(key))) {
					access = true;
					//printData(userManager);
					break;
				}
				else {
					loginSuccess.setText("Wrong Username or Password");
					break;
				}
			}
		}
		if (access) {
			access = false;
			m.changeScene("Home Page.fxml");
		}
		else {
			loginSuccess.setText("Wrong Username or Password");
		}
	}
	
	@FXML 
	public void createUser(ActionEvent event) throws IOException {
		//ADD NEW USER
		for (String name: Main.names) {	//loops through a list containing usernames to check for duplicates
			if (name.equals(username.getText().toString())) {
				duplicate = true;
			}
		}
		if (duplicate) {	//restarts the loop if a duplicate is found
			loginSuccess.setText("This username already exists");
			duplicate = false;
			return;
		}
		Main.names.add(username.getText().toString());
		String hashedUsername = hash(username.getText().toString());
		String hashedPassword = hash(password.getText().toString());
		Main.users.put(hashedUsername, hashedPassword);
		User user = new User(hashedUsername, hashedPassword);
	    userManager.addUser(user); // Add user to userManager
		username.setText("");
		password.setText("");
        loginSuccess.setText("New User Added");	
	}
	
	private static String hash(String input) {
		MessageDigest digest = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");	//creates a hashing object using SHA256 architecture
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));	//converts the String input to byte representation
		String encoded = Base64.getEncoder().encodeToString(hash);	//hashes the resulting byte sequence
		
		return encoded;
	}
    
    private static void printData(UserManager userManager) {
		System.out.println("User Database:");
		for (User user : userManager.getUserList()) {
	        System.out.print("Username: " + user.getUsername() + "\tPassword: " + user.getPassword());
	        System.out.println();
	    }
	}
	
	
	
}
