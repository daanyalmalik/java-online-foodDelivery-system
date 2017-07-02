package BusinessLogic.User;
import BusinessLogic.Controller.Controller;
import DataAccess.ORMapper;

import java.sql.SQLException;

public class User 
{
	private boolean loginStatus;
	private int UserId;
	private static String UserName;
        public static String Usertype;
        public User()
        {
            
        }

	public String ReadUserInfo(String username, String password) throws SQLException
	{
            String authenticated = "";
            authenticated = Controller.DB_OR.Authentication(username, password);
            return authenticated;
            
	}
	
}
