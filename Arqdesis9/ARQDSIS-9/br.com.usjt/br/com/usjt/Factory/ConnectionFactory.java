package br.com.usjt.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	{     
		try{        
			Class.forName("com.mysql.jdbc.Driver");   
		} catch (ClassNotFoundException e){          
			throw new RuntimeException(e);     
		}  
	}  
	public static Connection connection() throws SQLException{       
		return DriverManager.getConnection ("jdbc:mysql://localhost/projeto?user=root" );   
	}
}