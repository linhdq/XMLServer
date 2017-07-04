package restful_api_model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.LoModel;

@XmlRootElement(name="list_lo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListLoModels {
	@XmlElement(name="lo")
	private List<LoModel> listLo;

	public List<LoModel> getListLo() {
		return listLo;
	}

	public void setListLo(List<LoModel> listLo) {
		this.listLo = listLo;
	}
}
