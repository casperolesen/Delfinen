package data;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBConnector {
    private Connection connection = null;
	
	//Constants
	private static String IP;
        //private static String IP       = "10.50.137.144";
	private static String PORT;
	public  static String DATABASE = "delfinen";
	private static String USERNAME; 
	private static String PASSWORD;	     	
	
	public DBConnector() throws Exception {
            
            Charset cs = Charset.forName("ISO-8859-1");
            Path path = Paths.get("dbinfo.txt");
            List<String> lines = Files.readAllLines(path, cs);
            
            IP = lines.get(0).split(";")[0].trim();
            PORT = lines.get(0).split(";")[1].trim();
            USERNAME = lines.get(0).split(";")[2].trim();
            PASSWORD = lines.get(0).split(";")[3].trim();
            
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
