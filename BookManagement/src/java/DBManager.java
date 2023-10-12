import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 


public class DBManager{//Class used for the database connection.
    public static Connection initDB()
    {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        
        String dbName = "bookmanagement";
        String dbUsername = "gkiokas";
        String dbPswd = "12345";
        Connection con = null;
        
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL + dbName, dbUsername,
            dbPswd);
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return con;
    }
}
