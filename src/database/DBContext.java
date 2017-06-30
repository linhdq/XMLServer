package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class DBContext {
	private final String server = "DESKTOP-1GDVB36";
	private final int port = 1433;
	private final String database = "XMLProjectDB";
	private String jdbcUrl;
	private Connection conn;
	
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
}
