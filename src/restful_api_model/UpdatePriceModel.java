package restful_api_model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="price")
public class UpdatePriceModel implements Serializable{
	private String username;
	private int dePrice;
	private int baCangPrice;
	private int loNhanPrice;
	private int loTraPrice;
	private int loXien2NhanPrice;
	private int loXien2TraPrice;
	private int loXien3NhanPrice;
	private int loXien3TraPrice;
	private int loXien4NhanPrice;
	private int loXien4TraPrice;
	
	public UpdatePriceModel(){
		
	}
	
	public UpdatePriceModel(String username, int dePrice, int baCangPrice, int loNhanPrice,
			int loTraPrice, int loXien2NhanPrice, int loXien2TraPrice,
			int loXien3NhanPrice, int loXien3TraPrice, int loXien4NhanPrice,
			int loXien4TraPrice) {
		super();
		this.username = username;
		this.dePrice = dePrice;
		this.baCangPrice = baCangPrice;
		this.loNhanPrice = loNhanPrice;
		this.loTraPrice = loTraPrice;
		this.loXien2NhanPrice = loXien2NhanPrice;
		this.loXien2TraPrice = loXien2TraPrice;
		this.loXien3NhanPrice = loXien3NhanPrice;
		this.loXien3TraPrice = loXien3TraPrice;
		this.loXien4NhanPrice = loXien4NhanPrice;
		this.loXien4TraPrice = loXien4TraPrice;
	}

	public String getUsername() {
		return username;
	}
	@XmlElement(name="username")
	public void setUsername(String username) {
		this.username = username;
	}

	public int getDePrice() {
		return dePrice;
	}
	@XmlElement(name="de_price")
	public void setDePrice(int dePrice) {
		this.dePrice = dePrice;
	}

	public int getBaCangPrice() {
		return baCangPrice;
	}
	@XmlElement(name="ba_cang_price")
	public void setBaCangPrice(int baCangPrice) {
		this.baCangPrice = baCangPrice;
	}

	public int getLoNhanPrice() {
		return loNhanPrice;
	}
	@XmlElement(name="lo_nhan_price")
	public void setLoNhanPrice(int loNhanPrice) {
		this.loNhanPrice = loNhanPrice;
	}

	public int getLoTraPrice() {
		return loTraPrice;
	}
	@XmlElement(name="lo_tra_price")
	public void setLoTraPrice(int loTraPrice) {
		this.loTraPrice = loTraPrice;
	}

	public int getLoXien2NhanPrice() {
		return loXien2NhanPrice;
	}
	@XmlElement(name="lo_xien_2_nhan_price")
	public void setLoXien2NhanPrice(int loXien2NhanPrice) {
		this.loXien2NhanPrice = loXien2NhanPrice;
	}

	public int getLoXien2TraPrice() {
		return loXien2TraPrice;
	}
	@XmlElement(name="lo_xien_2_tra_price")
	public void setLoXien2TraPrice(int loXien2TraPrice) {
		this.loXien2TraPrice = loXien2TraPrice;
	}

	public int getLoXien3NhanPrice() {
		return loXien3NhanPrice;
	}
	@XmlElement(name="lo_xien_3_nhan_price")
	public void setLoXien3NhanPrice(int loXien3NhanPrice) {
		this.loXien3NhanPrice = loXien3NhanPrice;
	}

	public int getLoXien3TraPrice() {
		return loXien3TraPrice;
	}
	@XmlElement(name="lo_xien_3_tra_price")
	public void setLoXien3TraPrice(int loXien3TraPrice) {
		this.loXien3TraPrice = loXien3TraPrice;
	}

	public int getLoXien4NhanPrice() {
		return loXien4NhanPrice;
	}
	@XmlElement(name="lo_xien_4_nhan_price")
	public void setLoXien4NhanPrice(int loXien4NhanPrice) {
		this.loXien4NhanPrice = loXien4NhanPrice;
	}

	public int getLoXien4TraPrice() {
		return loXien4TraPrice;
	}
	@XmlElement(name="lo_xien_4_tra_price")
	public void setLoXien4TraPrice(int loXien4TraPrice) {
		this.loXien4TraPrice = loXien4TraPrice;
	}
	
	
}
