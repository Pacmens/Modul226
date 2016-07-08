// **** DatabaseManager 				**** //
// **** DatabaseManager				 	**** //
// **** 2010 BBW B.Marti 				**** //

package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

	private DatabaseManager(){}	
	private static DatabaseManager dbm;
	private DatabaseConnection db  = new DatabaseConnection();
	
	//Klasse ist SINGLETON. Eine Instanz wird über die Klassenmethode geholt
	public static DatabaseManager getDatabaseManager(){
		if (dbm == null)
			dbm = new DatabaseManager();
		return dbm;	
	}

	public ResultSet sendQuery(String query)  {
		 return (db.sendQuery(query));
}
	 public void sendUpdate(String query)  {
		 db.sendUpdate(query);
}
	  
	@Override
	public void finalize() throws SQLException {
		if (db == null) return;
		
		db.finalize();
		db = null;
		dbm = null;
 } 

// Diese Methode ist zum Testen der Datenbank /-verbindung
public static void main(String[] args) {
	DatabaseManager db = DatabaseManager.getDatabaseManager();
	System.out.println("Test aus Mainfunktion DATABASE MANAGER");
	try {
        ResultSet rs = db.sendQuery("Select * FROM person");
        while ( rs.next() ) {
        	 	System.out.println("Eintrag " + rs.getString("EMAIL"));
        }
    } catch (SQLException e) {
    	System.out.println(e.getMessage());
    }
}

}
