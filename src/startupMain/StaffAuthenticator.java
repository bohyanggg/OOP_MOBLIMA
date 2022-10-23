package startupMain;

public class StaffAuthenticator {

	public boolean verify(String username, String password) {
		
		//if username and password are correct
		if (username.equals("staff") && password.equals("admin")) return true;
		
		//if either username or password is wrong
		return false;
	}

}
