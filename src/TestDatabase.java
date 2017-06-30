import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.User;
import database.DBContext;


public class TestDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBContext dbContext = DBContext.getInst();
		if(dbContext.openConnection()){
			User user = dbContext.checkLogin("admin", "admin");
			if(user!=null){
				System.out.println("Username: "+user.getFullName());
			}
			dbContext.closeConnection();
		}
	}

}
