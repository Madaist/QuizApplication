import java.sql.*;
import java.sql.DriverManager;


//SINGLETON
public class DatabaseConnection {
    static Connection connection;

    public static Connection getConnection(){
         connection = null;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapplication?useSSL=false&allowPublicKeyRetrieval=true", "root", "pass123");
           //System.out.println("Connection established");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: database connection failed");
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null)
            try {
                connection.close();
               // System.out.println("The database has been succesfully closed");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("The database could not be closed");
            }
    }


}
