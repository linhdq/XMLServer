package restful_api_model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.DeModel;
import model.User;

@XmlRootElement(name="list_de")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDeModels {
	@XmlElement(name="de")
	private List<DeModel> listDe;

	public List<DeModel> getListDe() {
		return listDe;
	}

	public void setListDe(List<DeModel> listDe) {
		this.listDe = listDe;
	}

	
}
