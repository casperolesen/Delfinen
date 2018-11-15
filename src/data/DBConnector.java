package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private Connection connection = null;
	
	//Constants
	private static final String IP       = "localhost";
	private static final String PORT     = "3306";
	public  static final String DATABASE = "marsvinet";
	private static final String USERNAME = "admin"; 
	private static final String PASSWORD = "test";	     	
	
	public DBConnector() throws Exception {
  		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
  		String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
  		this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
	}
	
        
	public Connection getConnection() {
                //System.out.println("Forbundet til DB!");
  		return this.connection;
	}
        
        public ResultSet GetSQLResult(String query) {
        
            ResultSet rs = null;
        
            try{
                Statement stmt = connection.createStatement();
                rs = stmt.executeQuery(query);
            
            } catch(SQLException e) {
                System.out.println("Oopsie");
            }
        
            return rs;
        }
}
