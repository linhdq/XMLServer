package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import restful_api_model.UpdatePriceModel;
import model.BaCangModel;
import model.DeModel;
import model.LoModel;
import model.LoXien2Model;
import model.LoXien3Model;
import model.LoXien4Model;
import model.PriceModel;
import model.User;

public class DBContext {
	private final String server = "DESKTOP-IGRJUI8";
	private final int port = 1433;
	private final String database = "XMLProjectDB";
	private String jdbcUrl;
	private Connection conn;
	//
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private DBContext(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			jdbcUrl = "jdbc:sqlserver://"+server+":"+port+"; user=sa; password=sa; databasename="+database;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static DBContext inst;
	public static DBContext getInst(){
		if(inst==null){
			inst = new DBContext();
		}
		return inst;
	}
	
	public boolean openConnection(){
		try {
			conn = DriverManager.getConnection(jdbcUrl);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void closeConnection(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * User table
	 * */
	
	public User checkLogin(String username, String password){
		String sql = "SELECT * FROM Users WHERE Username_= '"+username+"' AND Password_='"+password+"'";
		Statement statement;
		ResultSet result;
		User user = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				String pass = result.getString(2);
				String fullname = result.getString(3);
				String phone = result.getString(4);
				int role = result.getInt(5);
				String createdBy = result.getString(6);
				user = new User(uname, pass, fullname, phone, role, createdBy);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User checkUsernameIsExists(String username){
		String sql = "SELECT * FROM Users WHERE Username_= '"+username+"'";
		Statement statement;
		ResultSet result;
		User user = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				String pass = result.getString(2);
				String fullname = result.getString(3);
				String phone = result.getString(4);
				int role = result.getInt(5);
				String createdBy = result.getString(6);
				user = new User(uname, pass, fullname, phone, role, createdBy);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User checkUserIsExists(String username, String createdBy){
		String sql = "SELECT * FROM Users WHERE Username_= '"+username+"' AND CreatedBy_= '"+createdBy+"'";
		Statement statement;
		ResultSet result;
		User user = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				String pass = result.getString(2);
				String fullname = result.getString(3);
				String phone = result.getString(4);
				int role = result.getInt(5);
				user = new User(uname, pass, fullname, phone, role, createdBy);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User getSuperAdmin(){
		String sql = "SELECT * FROM Users WHERE Role_= 0";
		Statement statement;
		ResultSet result;
		User user = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				String pass = result.getString(2);
				String fullname = result.getString(3);
				String phone = result.getString(4);
				int role = result.getInt(5);
				String createdBy = result.getString(6);
				user = new User(uname, pass, fullname, phone, role, createdBy);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> getAllAdmins(String username){
		String sql = "SELECT * FROM Users WHERE Role_ = 1 AND CreatedBy_ ='"+username+"'";
		List<User> listUsers = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				String pass = result.getString(2);
				String fullname = result.getString(3);
				String phone = result.getString(4);
				int role = result.getInt(5);
				User user = new User(uname, pass, fullname, phone, role, username);
				listUsers.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUsers;
	}
	
	public List<User> getAllClients(String username){
		String sql = "SELECT * FROM Users WHERE Role_ = 2 AND CreatedBy_ ='"+username+"'";
		List<User> listUsers = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				String pass = result.getString(2);
				String fullname = result.getString(3);
				String phone = result.getString(4);
				int role = result.getInt(5);
				User user = new User(uname, pass, fullname, phone, role, username);
				listUsers.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUsers;
	}
	
	public boolean insertUser(User model){
		PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?,?)");
            preStmt.setString(1, model.getUsername());
            preStmt.setString(2, model.getPassword());
            preStmt.setString(3, model.getFullName());
            preStmt.setString(4, model.getPhoneNumber());
            preStmt.setInt(5, model.getRole());
            preStmt.setString(6, model.getCreatedBy());
            preStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
	}
	
	public void updateUser(User model){
		String sql ="UPDATE Users SET Password_ = '"+model.getPassword()+"', Fullname_ = '"+model.getFullName()
				+"', PhoneNumber_ = '"+model.getPhoneNumber()+"' WHERE "
				+"Username_ = '"+model.getUsername()+"'";
		try {
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean deleteUser(String username){
		deleteDeByUsername(username);
		deleteBaCangByUsername(username);
		deleteLoByUsername(username);
		deleteLoXien2ByUsername(username);
		deleteLoXien3ByUsername(username);
		deleteLoXien4ByUsername(username);
		deleteClientsByCreatedUser(username);
		String sql ="DELETE FROM Users WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteClientsByCreatedUser(String createdBy){
		List<User> list = getAllClients(createdBy);
		if(list!=null){
			for(User u: list){
				deleteDeByUsername(u.getUsername());
				deleteBaCangByUsername(u.getUsername());
				deleteLoByUsername(u.getUsername());
				deleteLoXien2ByUsername(u.getUsername());
				deleteLoXien3ByUsername(u.getUsername());
				deleteLoXien4ByUsername(u.getUsername());
			}
		}
		String sql ="DELETE FROM Users WHERE Role_= 2 AND CreatedBy_ = '"+createdBy+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	/**
	 * De table
	 * */
	
	public List<DeModel> getAllDataOfDe(){
		String sql = "SELECT * FROM Table_De";
		List<DeModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				int price = result.getInt(3);
				String date = result.getString(4);
				DeModel model =new DeModel(uname,number, price, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<DeModel> getAllDataOfDeByDate(String date){
		String sql = "SELECT * FROM Table_De WHERE Date_ = '"+date+"'";
		List<DeModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				int price = result.getInt(3);
				DeModel model =new DeModel(uname,number, price, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<DeModel> getAllDataOfDeByUsername(String username){
		String sql = "SELECT * FROM Table_De WHERE Username_ ='"+username+"'";
		List<DeModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				int price = result.getInt(3);
				String date = result.getString(4);
				DeModel model =new DeModel(uname,number, price, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public boolean deleteDeByUsername(String username){
		
		String sql ="DELETE FROM Table_De WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteDeByUsernameAndDate(String username, String date){
		
		String sql ="DELETE FROM Table_De WHERE Username_='"+username+"' AND Date_ ='"+date+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public boolean insertDeModel(DeModel model){
		PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement("INSERT INTO Table_De VALUES(?,?,?,?)");
            preStmt.setString(1, model.getUsername());
            preStmt.setInt(2, model.getNumber());
            preStmt.setInt(3, model.getPrice());
            preStmt.setString(4, model.getDate());
            preStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
	}
	
	/**
	 * Ba Cang table
	 * */
	
	public List<BaCangModel> getAllDataOfBaCang(){
		String sql = "SELECT * FROM Table_ba_cang";
		List<BaCangModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				int price = result.getInt(3);
				String date = result.getString(4);
				BaCangModel model =new BaCangModel(uname,number, price, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public boolean deleteBaCangByUsername(String username){
		
		String sql ="DELETE FROM Table_ba_cang WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public List<BaCangModel> getAllDataOfBaCangByDate(String date){
		String sql = "SELECT * FROM Table_ba_cang WHERE Date_ = '"+date+"'";
		List<BaCangModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				int price = result.getInt(3);
				BaCangModel model =new BaCangModel(uname,number, price, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<BaCangModel> getAllDataOfBaCangByUsername(String username){
		String sql = "SELECT * FROM Table_ba_cang WHERE Username_ ='"+username+"'";
		List<BaCangModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				int price = result.getInt(3);
				String date = result.getString(4);
				BaCangModel model =new BaCangModel(uname,number, price, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	/**
	 * Lo table
	 * */
	
	public List<LoModel> getAllDataOfLo(){
		String sql = "SELECT * FROM Table_lo";
		List<LoModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				float point = result.getFloat(3);
				String date = result.getString(4);
				LoModel model =new LoModel(uname,number, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public boolean deleteLoByUsername(String username){
		
		String sql ="DELETE FROM Table_lo WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public List<LoModel> getAllDataOfLoByDate(String date){
		String sql = "SELECT * FROM Table_lo WHERE Date_ = '"+date+"'";
		List<LoModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				float point = result.getFloat(3);
				LoModel model =new LoModel(uname,number, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<LoModel> getAllDataOfLoByUsername(String username){
		String sql = "SELECT * FROM Table_lo WHERE Username_ ='"+username+"'";
		List<LoModel> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number = result.getInt(2);
				float point = result.getFloat(3);
				String date = result.getString(4);
				LoModel model =new LoModel(uname,number, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	/**
	 * Lo xien 2 table
	 * */
	
	public List<LoXien2Model> getAllDataOfLoXien2(){
		String sql = "SELECT * FROM Table_lo_xien_2";
		List<LoXien2Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				float point = result.getFloat(4);
				String date = result.getString(5);
				LoXien2Model model =new LoXien2Model(uname,number1, number2, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public boolean deleteLoXien2ByUsername(String username){
		
		String sql ="DELETE FROM Table_lo_xien_2 WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public List<LoXien2Model> getAllDataOfLoXien2ByDate(String date){
		String sql = "SELECT * FROM Table_lo_xien_2 WHERE Date_ = '"+date+"'";
		List<LoXien2Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				float point = result.getFloat(4);
				LoXien2Model model =new LoXien2Model(uname,number1, number2, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<LoXien2Model> getAllDataOfLoXien2ByUsername(String username){
		String sql = "SELECT * FROM Table_lo_xien_2 WHERE Username_ ='"+username+"'";
		List<LoXien2Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				float point = result.getFloat(4);
				String date = result.getString(5);
				LoXien2Model model =new LoXien2Model(uname,number1, number2, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	/**
	 * Lo Xien 3 table
	 * */
	
	public List<LoXien3Model> getAllDataOfLoXien3(){
		String sql = "SELECT * FROM Table_lo_xien_3";
		List<LoXien3Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				int number3 = result.getInt(4);
				float point = result.getFloat(5);
				String date = result.getString(6);
				LoXien3Model model =new LoXien3Model(uname,number1, number2, number3, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public boolean deleteLoXien3ByUsername(String username){
		
		String sql ="DELETE FROM Table_lo_xien_3 WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public List<LoXien3Model> getAllDataOfLoXien3ByDate(String date){
		String sql = "SELECT * FROM Table_lo_xien_3 WHERE Date_ = '"+date+"'";
		List<LoXien3Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				int number3 = result.getInt(4);
				float point = result.getFloat(5);
				LoXien3Model model =new LoXien3Model(uname,number1, number2, number3, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<LoXien3Model> getAllDataOfLoXien3ByUsername(String username){
		String sql = "SELECT * FROM Table_lo_xien_3 WHERE Username_ ='"+username+"'";
		List<LoXien3Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				int number3 = result.getInt(4);
				float point = result.getFloat(5);
				String date = result.getString(6);
				LoXien3Model model =new LoXien3Model(uname,number1, number2, number3, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	/**
	 * Lo Xien 4 table
	 * */
	
	public List<LoXien4Model> getAllDataOfLoXien4(){
		String sql = "SELECT * FROM Table_lo_xien_4";
		List<LoXien4Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				int number3 = result.getInt(4);
				int number4 = result.getInt(5);
				float point = result.getFloat(6);
				String date = result.getString(7);
				LoXien4Model model =new LoXien4Model(uname,number1, number2, number3, number4, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public boolean deleteLoXien4ByUsername(String username){
		
		String sql ="DELETE FROM Table_lo_xien_4 WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public List<LoXien4Model> getAllDataOfLoXien4ByDate(String date){
		String sql = "SELECT * FROM Table_lo_xien_4 WHERE Date_ = '"+date+"'";
		List<LoXien4Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				int number3 = result.getInt(4);
				int number4 = result.getInt(5);
				float point = result.getFloat(6);
				LoXien4Model model =new LoXien4Model(uname,number1, number2, number3, number4, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	public List<LoXien4Model> getAllDataOfLoXien4ByUsername(String username){
		String sql = "SELECT * FROM Table_lo_xien_4 WHERE Username_ ='"+username+"'";
		List<LoXien4Model> listData = new ArrayList();
		Statement statement;
		ResultSet result;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int number1 = result.getInt(2);
				int number2 = result.getInt(3);
				int number3 = result.getInt(4);
				int number4 = result.getInt(5);
				float point = result.getFloat(6);
				String date = result.getString(7);
				LoXien4Model model =new LoXien4Model(uname,number1, number2, number3, number4, point, date);
				listData.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}
	
	/**
	 * Table Price
	 * */
	
	public boolean insertPrice(UpdatePriceModel model){
		PreparedStatement preStmt = null;
        try {
            preStmt = conn.prepareStatement("INSERT INTO Table_price VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            preStmt.setString(1, model.getUsername());
            preStmt.setInt(2, model.getDePrice());
            preStmt.setInt(3, model.getBaCangPrice());
            preStmt.setInt(4, model.getLoNhanPrice());
            preStmt.setInt(5, model.getLoTraPrice());
            preStmt.setInt(6, model.getLoXien2NhanPrice());
            preStmt.setInt(7, model.getLoXien2TraPrice());
            preStmt.setInt(8, model.getLoXien3NhanPrice());
            preStmt.setInt(9, model.getLoXien3TraPrice());
            preStmt.setInt(10, model.getLoXien4NhanPrice());
            preStmt.setInt(11, model.getLoXien4TraPrice());
            preStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
	}
	
	public boolean deletePriceByUsername(String username){
		String sql ="DELETE FROM Table_price WHERE Username_='"+username+"'";
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute(sql);
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public PriceModel getPriceByUsername(String username){
		String sql = "SELECT * FROM Table_price WHERE Username_= '"+username+"'";
		Statement statement;
		ResultSet result;
		PriceModel model = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()){
				String uname = result.getString(1);
				int dePrice = result.getInt(2);
				int bacangPrice = result.getInt(3);
				int loNhanPrice = result.getInt(4);
				int loTraPrice = result.getInt(5);
				int loXien2NhanPrice = result.getInt(6);
				int loXien2TraPrice = result.getInt(7);
				int loXien3NhanPrice = result.getInt(8);
				int loXien3TraPrice = result.getInt(9);
				int loXien4NhanPrice = result.getInt(10);
				int loXien4TraPrice = result.getInt(11);
				model = new PriceModel(dePrice, bacangPrice, loNhanPrice, loTraPrice, loXien2NhanPrice, loXien2TraPrice, loXien3NhanPrice, loXien3TraPrice, loXien4NhanPrice, loXien4TraPrice);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
