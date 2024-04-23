package application;
import java.util.ArrayList;


public class UserManager {
	
	 private ArrayList<User> userList = new ArrayList<>();

	    public void addUser(User user) {
	        userList.add(user);
	    }

	    public ArrayList<User> getUserList() {
	        return userList;
	    }

}
