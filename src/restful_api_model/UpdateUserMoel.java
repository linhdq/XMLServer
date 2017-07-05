package restful_api_model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class UpdateUserMoel{
	private String username;
	private String password;
	private String fullName;
	private String phoneNumber;
	
	public UpdateUserMoel(){
		
	}
	
	public UpdateUserMoel(String username, String password, String fullName, String phoneNumber) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	@XmlElement(name="username")
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	
	public String getPassword() {
		return password;
	}
	@XmlElement(name="password")
	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement(name="fullName")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	@XmlElement(name="phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
}
