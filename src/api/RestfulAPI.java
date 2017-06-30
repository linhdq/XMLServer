package api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restful_api_model.LoginModel;
import xml_util.ConvertObjectToXML;

import database.DBContext;
import model.User;

@Path("/api")
public class RestfulAPI {
	DBContext dbContext = DBContext.getInst();
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML(){
		String response = "<?xml version='1.0'?>"
				+ "<hello>Hello Na^`m</hello>";
		return response;
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response checkLogin(LoginModel model) {
		//check login data in database
		User user = null;
		if(dbContext.openConnection()){
			user = dbContext.checkLogin(model.getUsername(), model.getPassword());
			dbContext.closeConnection();
		}
		String result = "";
		if(user!=null){
			user.setSuccess(true);
		}else{
			user = new User("", "", "", "", -1);
		}
		result = ConvertObjectToXML.convertUserModelToXml(user);
		return Response.status(200).entity(result).build();
	}
}
