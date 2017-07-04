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

import model.BaCangModel;
import model.DeModel;
import model.LoModel;
import model.LoXien2Model;
import model.LoXien3Model;
import model.LoXien4Model;
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
			System.out.println("Connected!");
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
				user = new User(uname, pass, fullname, phone, role);
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
				user = new User(uname, pass, fullname, phone, role);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> getAllAdmins(){
		String sql = "SELECT * FROM Users WHERE Role_ = 1";
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
				User user = new User(uname, pass, fullname, phone, role);
				listUsers.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUsers;
	}
	
	public List<User> getAllClients(){
		String sql = "SELECT * FROM Users WHERE Role_ = 2";
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
				User user = new User(uname, pass, fullname, phone, role);
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
            preStmt = conn.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?)");
            preStmt.setString(1, model.getUsername());
            preStmt.setString(2, model.getPassword());
            preStmt.setString(3, model.getFullName());
            preStmt.setString(4, model.getPhoneNumber());
            preStmt.setInt(5, model.getRole());
            preStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
	}
	
	public boolean deleteUser(String username){
		String sql ="DELETE FROM Users WHERE Username_='"+username+"'";
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
}
