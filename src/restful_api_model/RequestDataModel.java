package restful_api_model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="requestData")
public class RequestDataModel implements Serializable{
	private String username;
	
	public RequestDataModel(){
		
	}

	public RequestDataModel(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	@XmlElement(name="username")
	public void setUsername(String username) {
		this.username = username;
	}
}
