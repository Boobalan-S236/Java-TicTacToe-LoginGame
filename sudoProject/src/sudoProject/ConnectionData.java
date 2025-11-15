package sudoProject;

import java.sql.*;

public class ConnectionData {
	private static final String url="jdbc:mysql://localhost:3306/Login";
	private static final String name="root";
	private static final String password="NEW_PASSWORD";
	
	public static Connection ConnectionDemo() throws Exception{
		
		return (Connection) DriverManager.getConnection(url,name,password);
		
	}
}
