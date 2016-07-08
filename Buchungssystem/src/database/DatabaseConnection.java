package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DatabaseConnection {

    private MysqlDataSource database;
    private Connection connection;

    public DatabaseConnection(){
        database = new MysqlDataSource();
        
       /* database.setDatabaseName("jsfguestbook2");
        database.setServerName("localhost");
        database.setPort(Integer.parseInt("3306"));
        database.setUser("root");
        database.setPassword("#1234");*/
        
        database.setDatabaseName("budget_db");
        database.setServerName("127.0.0.1");
        database.setPort(Integer.parseInt("3306"));
        database.setUser("root");
        database.setPassword("");
        
        
        try {
            connection = database.getConnection();
        } catch (SQLException e) {
            System.err.println("Es konnte keine Verbindung zur Datenbank aufgebaut werden!");
            //System.exit(1);
        }
    }

    public ResultSet sendQuery(String query){
        try {     	
            	return connection.createStatement().executeQuery(query);
        } catch (SQLException e) {
        	
        	System.out.println("Exception SendQuery " + e.toString());
            e.printStackTrace();
            
            return null;
        }
    }
    
    // für inserts/updates/delete
    public void sendUpdate(String query){
        try {
            connection.createStatement().executeUpdate(query);
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finalize(){
        try {
            connection.close();
            
            System.out.println("DB Connection closed");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

