package restful_api_model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="requestData")
public class RequestDataModel implements Serializable{
	private String username;
	private String date;
	
	public RequestDataModel(){
		
	}

	public RequestDataModel(String username, String date) {
		super();
		this.username = username;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}
	@XmlElement(name="username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}
	@XmlElement(name="date")
	public void setDate(String date) {
		this.date = date;
	}
}
