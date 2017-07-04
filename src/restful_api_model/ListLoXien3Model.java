package restful_api_model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.LoXien3Model;

@XmlRootElement(name="list_lo_xien_3")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListLoXien3Model {
	@XmlElement(name="lo_xien_3")
	private List<LoXien3Model> list;

	public List<LoXien3Model> getList() {
		return list;
	}

	public void setList(List<LoXien3Model> list) {
		this.list = list;
	}
	
	
}
