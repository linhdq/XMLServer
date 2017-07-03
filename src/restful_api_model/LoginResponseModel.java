package restful_api_model;

public class LoginResponseModel {
	private boolean status;
	private String xml;
	
	public LoginResponseModel(boolean status, String xml){
		this.status=status;
		this.xml=xml;
	}
}
