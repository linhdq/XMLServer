package api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import restful_api_model.CreateUserModel;
import restful_api_model.LoginModel;
import restful_api_model.LoginResponseModel;
import restful_api_model.ResponseModel;
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
	@Consumes(MediaType.APPLICATION_XML)
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
		String xml = ConvertObjectToXML.convertUserModelToXml(user);
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/all/admins")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllAdmins(LoginModel model) {
		//check login data in database
		List<User> listUser = new ArrayList();
		if(dbContext.openConnection()){
			User user = dbContext.checkLogin(model.getUsername(), model.getPassword());
			if(user!=null &&user.getRole()==0){
				listUser.addAll(dbContext.getAllAdmins());
			}
			dbContext.closeConnection();
		}
		String xml = ConvertObjectToXML.convertListUserModelToXml(listUser);
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/all/clients")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllClients(LoginModel model) {
		//check login data in database
		List<User> listUser = new ArrayList();
		if(dbContext.openConnection()){
			User user = dbContext.checkLogin(model.getUsername(), model.getPassword());
			if(user!=null &&user.getRole()==1){
				listUser.addAll(dbContext.getAllClients());
			}
			dbContext.closeConnection();
		}
		String xml = ConvertObjectToXML.convertListUserModelToXml(listUser);
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/create/admin")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createAdmin(CreateUserModel model) {
		//check login data in database
		ResponseModel responseModel =new ResponseModel();
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null){
				responseModel.setStatus(false);
				responseModel.setMessage("Tên đăng nhập này đã tồn tại!");
			}else{
				user=new User(model.getUsername(), model.getPassword(), model.getFullName(), model.getPhoneNumber(), 1);
				if(dbContext.insertUser(user)){
					responseModel.setStatus(true);
					responseModel.setMessage("Tạo tài khoản thành công!");
				}
			}
			dbContext.closeConnection();
		}
		String xml = ConvertObjectToXML.convertResponseModelToXML(responseModel);
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/create/client")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createClient(CreateUserModel model) {
		//check login data in database
		ResponseModel responseModel =new ResponseModel();
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null){
				responseModel.setStatus(false);
				responseModel.setMessage("Tên đăng nhập này đã tồn tại!");
			}else{
				user=new User(model.getUsername(), model.getPassword(), model.getFullName(), model.getPhoneNumber(), 2);
				if(dbContext.insertUser(user)){
					responseModel.setStatus(true);
					responseModel.setMessage("Tạo tài khoản thành công!");
				}
			}
			dbContext.closeConnection();
		}
		String xml = ConvertObjectToXML.convertResponseModelToXML(responseModel);
		return Response.status(200).entity(xml).build();
	}
}
