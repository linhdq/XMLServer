package restful_api_model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
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
	@XmlElement(name="username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	@XmlElement(name="password")
	public void setPassword(String password) {
		this.password = password;
	}
}
