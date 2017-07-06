package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="price")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceModel {
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
	
	public PriceModel(){
		
	}
	
	public PriceModel(int dePrice, int baCangPrice, int loNhanPrice,
			int loTraPrice, int loXien2NhanPrice, int loXien2TraPrice,
			int loXien3NhanPrice, int loXien3TraPrice, int loXien4NhanPrice,
			int loXien4TraPrice) {
		super();
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

	public int getDePrice() {
		return dePrice;
	}

	public void setDePrice(int dePrice) {
		this.dePrice = dePrice;
	}

	public int getBaCangPrice() {
		return baCangPrice;
	}

	public void setBaCangPrice(int baCangPrice) {
		this.baCangPrice = baCangPrice;
	}

	public int getLoNhanPrice() {
		return loNhanPrice;
	}

	public void setLoNhanPrice(int loNhanPrice) {
		this.loNhanPrice = loNhanPrice;
	}

	public int getLoTraPrice() {
		return loTraPrice;
	}

	public void setLoTraPrice(int loTraPrice) {
		this.loTraPrice = loTraPrice;
	}

	public int getLoXien2NhanPrice() {
		return loXien2NhanPrice;
	}

	public void setLoXien2NhanPrice(int loXien2NhanPrice) {
		this.loXien2NhanPrice = loXien2NhanPrice;
	}

	public int getLoXien2TraPrice() {
		return loXien2TraPrice;
	}

	public void setLoXien2TraPrice(int loXien2TraPrice) {
		this.loXien2TraPrice = loXien2TraPrice;
	}

	public int getLoXien3NhanPrice() {
		return loXien3NhanPrice;
	}

	public void setLoXien3NhanPrice(int loXien3NhanPrice) {
		this.loXien3NhanPrice = loXien3NhanPrice;
	}

	public int getLoXien3TraPrice() {
		return loXien3TraPrice;
	}

	public void setLoXien3TraPrice(int loXien3TraPrice) {
		this.loXien3TraPrice = loXien3TraPrice;
	}

	public int getLoXien4NhanPrice() {
		return loXien4NhanPrice;
	}

	public void setLoXien4NhanPrice(int loXien4NhanPrice) {
		this.loXien4NhanPrice = loXien4NhanPrice;
	}

	public int getLoXien4TraPrice() {
		return loXien4TraPrice;
	}

	public void setLoXien4TraPrice(int loXien4TraPrice) {
		this.loXien4TraPrice = loXien4TraPrice;
	}
}
