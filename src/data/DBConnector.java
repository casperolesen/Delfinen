package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private Connection connection = null;
	
	//Constants
	//private static final String IP       = "localhost";
        private static final String IP       = "10.50.137.144";
	private static final String PORT     = "3306";
	public  static final String DATABASE = "delfinen";
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
        
        public void newQuery(PreparedStatement psmt) throws SQLException{
            try{
                psmt.execute();
            
            } catch(SQLException e) {
                throw new SQLException();
            }
        }
        
        public void newQuery(String query) throws SQLException{
            try{
                Statement stmt = connection.createStatement();
                stmt.executeQuery(query);
            } catch(SQLException e) {
                System.out.println("SQL HALLA");
                throw new SQLException();
            }
        }
}
