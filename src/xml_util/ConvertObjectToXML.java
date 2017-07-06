package xml_util;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import restful_api_model.ListBaCangModels;
import restful_api_model.ListDeModels;
import restful_api_model.ListLoModels;
import restful_api_model.ListLoXien2Model;
import restful_api_model.ListLoXien3Model;
import restful_api_model.ListLoXien4Model;
import restful_api_model.ResponseModel;
import restful_api_model.Users;
import model.BaCangModel;
import model.DeModel;
import model.LoModel;
import model.LoXien2Model;
import model.LoXien3Model;
import model.LoXien4Model;
import model.PriceModel;
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
	
	public static String convertPriceModelToXML(PriceModel model){
		try {
			JAXBContext contectObj = JAXBContext.newInstance(PriceModel.class);
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
	
	public static String convertDeModelToXML(DeModel model){
		try {
			JAXBContext contectObj = JAXBContext.newInstance(DeModel.class);
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
	
	public static String convertListDeModelToXml(List<DeModel> list){
		try {
			ListDeModels listDe = new ListDeModels();
			listDe.setListDe(list);
			JAXBContext contectObj = JAXBContext.newInstance(ListDeModels.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(listDe, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	
	public static String convertListBaCangModelToXml(List<BaCangModel> list){
		try {
			ListBaCangModels listBaCang = new ListBaCangModels();
			listBaCang.setList(list);
			JAXBContext contectObj = JAXBContext.newInstance(ListBaCangModels.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(listBaCang, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	
	public static String convertListLoModelToXml(List<LoModel> list){
		try {
			ListLoModels listLo =new ListLoModels();
			listLo.setListLo(list);
			JAXBContext contectObj = JAXBContext.newInstance(ListLoModels.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(listLo, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	
	public static String convertListLoXien2ModelToXml(List<LoXien2Model> list){
		try {
			ListLoXien2Model listLo = new ListLoXien2Model();
			listLo.setList(list);
			JAXBContext contectObj = JAXBContext.newInstance(ListLoXien2Model.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(listLo, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	public static String convertListLoXien3ModelToXml(List<LoXien3Model> list){
		try {
			ListLoXien3Model listLo = new ListLoXien3Model();
			listLo.setList(list);
			JAXBContext contectObj = JAXBContext.newInstance(ListLoXien3Model.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(listLo, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
	public static String convertListLoXien4ModelToXml(List<LoXien4Model> list){
		try {
			ListLoXien4Model listLo = new ListLoXien4Model();
			listLo.setList(list);
			JAXBContext contectObj = JAXBContext.newInstance(ListLoXien4Model.class);
			Marshaller marshaller = contectObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw =new StringWriter();
			marshaller.marshal(listLo, sw);
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}
}
