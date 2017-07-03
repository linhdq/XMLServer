package xml_util;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import restful_api_model.ResponseModel;
import restful_api_model.Users;
import model.User;

public class ConvertObjectToXML {
	
	public static String convertUserModelToXml(User model){
		try {
			JAXBContext contectObj = JAXBContext.newInstance(User.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(model, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	
	public static String convertListUserModelToXml(List<User> list){
		try {
			Users users =new Users();
			users.setListUser(list);
			JAXBContext contectObj = JAXBContext.newInstance(Users.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(users, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	
	public static String convertResponseModelToXML(ResponseModel model){
		try {
			JAXBContext contectObj = JAXBContext.newInstance(ResponseModel.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(model, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
}
