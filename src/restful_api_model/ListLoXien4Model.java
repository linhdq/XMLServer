package restful_api_model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.LoXien4Model;

@XmlRootElement(name="list_lo_xien_4")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListLoXien4Model {
	@XmlElement(name="lo_xien_4")
	private List<LoXien4Model> list;

	public List<LoXien4Model> getList() {
		return list;
	}

	public void setList(List<LoXien4Model> list) {
		this.list = list;
	}
}
