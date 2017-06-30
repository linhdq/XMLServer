package model;

public class BaCangModel{
	private String username;
	private int number;
	private int price;
	private String date;
	
	public BaCangModel() {
		// TODO Auto-generated constructor stub
	}
	
	public BaCangModel(String username, int number, int price, String date) {
		super();
		this.username = username;
		this.number = number;
		this.price = price;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
