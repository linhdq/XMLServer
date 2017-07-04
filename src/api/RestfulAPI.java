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
import restful_api_model.DeleteRequest;
import restful_api_model.LoginModel;
import restful_api_model.LoginResponseModel;
import restful_api_model.RequestDataModel;
import restful_api_model.ResponseModel;
import xml_util.ConvertObjectToXML;
import database.DBContext;
import model.BaCangModel;
import model.DeModel;
import model.LoModel;
import model.LoXien2Model;
import model.LoXien3Model;
import model.LoXien4Model;
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
	
	@POST
	@Path("/delete/admin")
	@Consumes(MediaType.APPLICATION_XML)
	public Response deleteAdmin(DeleteRequest model) {
		//check login data in database
		ResponseModel responseModel =new ResponseModel();
		if(dbContext.openConnection()){
			User userRequest = dbContext.checkUsernameIsExists(model.getUsernameRequest());
			if(userRequest!=null && userRequest.getRole()==0){
				User userDelete = dbContext.checkUsernameIsExists(model.getUsernameDelete());
				if(userDelete!=null && userDelete.getRole()==1){
					if(dbContext.deleteUser(model.getUsernameDelete())){
						responseModel.setStatus(true);
						responseModel.setMessage("Tài khoản đã được xóa khỏi hệ thống!");
					}else{
						responseModel.setStatus(false);
						responseModel.setMessage("Yêu cầu xóa tài khoản không thành công!");
					}
				}else{
					responseModel.setStatus(false);
					responseModel.setMessage("Bạn không có quyền xóa tài khoản này!");
				}
			}else{
				responseModel.setStatus(false);
				responseModel.setMessage("Bạn không có quyền xóa tài khoản này!");
			}
			dbContext.closeConnection();
		}
		String xml = ConvertObjectToXML.convertResponseModelToXML(responseModel);
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/delete/client")
	@Consumes(MediaType.APPLICATION_XML)
	public Response deleteClient(DeleteRequest model) {
		//check login data in database
		ResponseModel responseModel =new ResponseModel();
		if(dbContext.openConnection()){
			User userRequest = dbContext.checkUsernameIsExists(model.getUsernameRequest());
			if(userRequest!=null && userRequest.getRole()==1){
				User userDelete = dbContext.checkUsernameIsExists(model.getUsernameDelete());
				if(userDelete!=null && userDelete.getRole()==2){
					if(dbContext.deleteUser(model.getUsernameDelete())){
						responseModel.setStatus(true);
						responseModel.setMessage("Tài khoản đã được xóa khỏi hệ thống!");
					}else{
						responseModel.setStatus(false);
						responseModel.setMessage("Yêu cầu xóa tài khoản không thành công!");
					}
				}else{
					responseModel.setStatus(false);
					responseModel.setMessage("Bạn không có quyền xóa tài khoản này!");
				}
			}else{
				responseModel.setStatus(false);
				responseModel.setMessage("Bạn không có quyền xóa tài khoản này!");
			}
			dbContext.closeConnection();
		}
		String xml = ConvertObjectToXML.convertResponseModelToXML(responseModel);
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/de/all")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllDataOfDe(RequestDataModel model) {
		List<DeModel> list = new ArrayList();
		String xml ="";
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null && user.getRole()==1){
				list.addAll(dbContext.getAllDataOfDe());
				xml = ConvertObjectToXML.convertListDeModelToXml(list);
			}else{
				ResponseModel resModel = new ResponseModel();
				resModel.setStatus(false);
				resModel.setMessage("Bạn không có quyền truy cập chức năng này!");
				xml = ConvertObjectToXML.convertResponseModelToXML(resModel);
			}
			dbContext.closeConnection();
		}
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/ba_cang/all")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllDataOfBaCang(RequestDataModel model) {
		List<BaCangModel> list = new ArrayList();
		String xml ="";
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null && user.getRole()==1){
				list.addAll(dbContext.getAllDataOfBaCang());
				xml = ConvertObjectToXML.convertListBaCangModelToXml(list);
			}else{
				ResponseModel resModel = new ResponseModel();
				resModel.setStatus(false);
				resModel.setMessage("Bạn không có quyền truy cập chức năng này!");
				xml = ConvertObjectToXML.convertResponseModelToXML(resModel);
			}
			dbContext.closeConnection();
		}
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/lo/all")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllDataOfLo(RequestDataModel model) {
		List<LoModel> list = new ArrayList();
		String xml ="";
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null && user.getRole()==1){
				list.addAll(dbContext.getAllDataOfLo());
				xml = ConvertObjectToXML.convertListLoModelToXml(list);
			}else{
				ResponseModel resModel = new ResponseModel();
				resModel.setStatus(false);
				resModel.setMessage("Bạn không có quyền truy cập chức năng này!");
				xml = ConvertObjectToXML.convertResponseModelToXML(resModel);
			}
			dbContext.closeConnection();
		}
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/lo_xien_2/all")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllDataOfLoXien2(RequestDataModel model) {
		List<LoXien2Model> list = new ArrayList();
		String xml ="";
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null && user.getRole()==1){
				list.addAll(dbContext.getAllDataOfLoXien2());
				xml = ConvertObjectToXML.convertListLoXien2ModelToXml(list);
			}else{
				ResponseModel resModel = new ResponseModel();
				resModel.setStatus(false);
				resModel.setMessage("Bạn không có quyền truy cập chức năng này!");
				xml = ConvertObjectToXML.convertResponseModelToXML(resModel);
			}
			dbContext.closeConnection();
		}
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/lo_xien_3/all")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllDataOfLoXien3(RequestDataModel model) {
		List<LoXien3Model> list = new ArrayList();
		String xml ="";
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null && user.getRole()==1){
				list.addAll(dbContext.getAllDataOfLoXien3());
				xml = ConvertObjectToXML.convertListLoXien3ModelToXml(list);
			}else{
				ResponseModel resModel = new ResponseModel();
				resModel.setStatus(false);
				resModel.setMessage("Bạn không có quyền truy cập chức năng này!");
				xml = ConvertObjectToXML.convertResponseModelToXML(resModel);
			}
			dbContext.closeConnection();
		}
		return Response.status(200).entity(xml).build();
	}
	
	@POST
	@Path("/get/lo_xien_4/all")
	@Consumes(MediaType.APPLICATION_XML)
	public Response getAllDataOfLoXien4(RequestDataModel model) {
		List<LoXien4Model> list = new ArrayList();
		String xml ="";
		if(dbContext.openConnection()){
			User user = dbContext.checkUsernameIsExists(model.getUsername());
			if(user!=null && user.getRole()==1){
				list.addAll(dbContext.getAllDataOfLoXien4());
				xml = ConvertObjectToXML.convertListLoXien4ModelToXml(list);
			}else{
				ResponseModel resModel = new ResponseModel();
				resModel.setStatus(false);
				resModel.setMessage("Bạn không có quyền truy cập chức năng này!");
				xml = ConvertObjectToXML.convertResponseModelToXML(resModel);
			}
			dbContext.closeConnection();
		}
		return Response.status(200).entity(xml).build();
	}
}
