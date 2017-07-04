package restful_api_model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="delete_request")
public class DeleteRequest {
	private String usernameRequest;
	private	String usernameDelete;
	
	public DeleteRequest(){
		
	}
	
	public DeleteRequest(String usernameRequest, String usernameDelete) {
		super();
		this.usernameRequest = usernameRequest;
		this.usernameDelete = usernameDelete;
	}

	public String getUsernameRequest() {
		return usernameRequest;
	}
	@XmlElement(name="username_request")
	public void setUsernameRequest(String usernameRequest) {
		this.usernameRequest = usernameRequest;
	}

	public String getUsernameDelete() {
		return usernameDelete;
	}
	@XmlElement(name="username_delete")
	public void setUsernameDelete(String usernameDelete) {
		this.usernameDelete = usernameDelete;
	}
}
