package startupMain;

public class StaffAuthenticator {

	private String username;
	private String password;

	public StaffAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean verify() {
		
		//if username and password are correct
		if (username=="1" && password=="1") return true;
		
//		if (/*username and password are valid (according to our database)*/) {
//			return true;
//		}
		
		//if either username or password is wrong
		return false;
	}

}
