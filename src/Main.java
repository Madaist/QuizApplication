import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

       // Connection connection = DatabaseConnection.getConnection();

       /* System.out.println(User.findPassword("OanaNeagu"));
        System.out.println(User.findPassword("alexandram"));
        System.out.println(User.findPassword("madaist"));*/

       User user = new User();
        user.takeQuiz();







        //DatabaseConnection.closeConnection(connection);


    }
}
