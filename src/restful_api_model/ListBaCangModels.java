package restful_api_model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.BaCangModel;

@XmlRootElement(name="list_ba_cang")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListBaCangModels {
	@XmlElement(name="ba_cang")
	private List<BaCangModel> list;

	public List<BaCangModel> getList() {
		return list;
	}

	public void setList(List<BaCangModel> list) {
		this.list = list;
	}
}
