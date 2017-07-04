package restful_api_model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.LoXien2Model;

@XmlRootElement(name="list_lo_xien_2")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListLoXien2Model {
	@XmlElement(name="lo_xien_2")
	List<LoXien2Model> list;

	public List<LoXien2Model> getList() {
		return list;
	}

	public void setList(List<LoXien2Model> list) {
		this.list = list;
	}
}
