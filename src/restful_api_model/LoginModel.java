package restful_api_model;

import java.io.Serializable;

public class LoginModel implements Serializable{
	private String username;
	private String password;
	
	public LoginModel(){
		
	}

	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
