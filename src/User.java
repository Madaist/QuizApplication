import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class User {
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String userName;
    private String password;
    private int ID;


    public void setID(int ID) {
        this.ID = ID;
    }

    /*public String getLastName() {
        return lastName;
    }*/

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public String getFirstName() {
        return firstName;
    }*/

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*public String getPhoneNumber() {
        return phoneNumber;
    }*/

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public String getPassword() {
        return password;
    }*/

    public void setPassword(String password) {

        this.password = password;
    }

    /*
        private static ResultSet getResultSet(String query) {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResultSet resultSet = null;
            try {
                assert statement != null;
                resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return resultSet;
        }
    */
    public static String findPassword(String loginUsername) {

        Connection connection = DatabaseConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            assert statement != null;
            resultSet = statement.executeQuery("SELECT username, password FROM user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String user = null;
            try {
                user = resultSet.getString("username");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (user.equals(loginUsername)) {
                try {
                    return resultSet.getString("password");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        DatabaseConnection.closeConnection(connection);
        return null;
    }


    public ArrayList<String> selectUsernames() {

        Connection connection = DatabaseConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = null;
        try {
            assert statement != null;
            resultSet = statement.executeQuery("SELECT username FROM user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<String> usernames = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String user = null;
            try {
                user = resultSet.getString("username");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            usernames.add(user);
        }
        DatabaseConnection.closeConnection(connection);
        return usernames;
    }

    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Last name: ");
        setLastName(sc.next());
        System.out.println("First name:");
        setFirstName(sc.next());
        System.out.println("Phone number:");
        setPhoneNumber(sc.next());
        System.out.println("Username: ");
        setUserName(sc.next());
        System.out.println("Password (at least 4 characters):");
        setPassword(sc.next());

        ArrayList<String> usernames = selectUsernames();
        while (usernames.contains(userName)) {
            System.out.println("Username already exists. Please insert another username:");
            setUserName(sc.next());
        }

        while (password == null || password.length() < 4) {
            System.out.println("Password has to contain at least 4 characters. Please insert another password: ");
            password = sc.next();
        }

        String insertUser = "INSERT INTO user VALUES (" + "\"" + userName + "\"" + ", " +
                "\"" + lastName + "\"" + ", " + "\"" + firstName + "\"" + ", " +
                "\"" + phoneNumber + "\"" + ", " + "\"" + password + "\"" + ")";

        Connection connection = DatabaseConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert statement != null;
            statement.executeUpdate(insertUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConnection.closeConnection(connection);
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username: ");
        String userLogin = sc.next();
        System.out.println("Password: ");
        String passwordLogin = sc.next();

        ArrayList<String> usernames = selectUsernames();
        while (!usernames.contains(userLogin)) {
            System.out.println("Username is not correct. Please insert your username again.");
            userLogin = sc.next();
        }
        while (!passwordLogin.equals(findPassword(userLogin))) {
            System.out.println("Password is not correct. Please insert your password again.");
            passwordLogin = sc.next();
        }
    }

    public ArrayList<Integer> findByDescription(String desc) {

        Connection connection = DatabaseConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String selectQuizzes = "SELECT description, id FROM quiz";
        ResultSet resultSet = null;
        ArrayList<Integer> quizzes = new ArrayList<>();
        try {
            assert statement != null;
            resultSet = statement.executeQuery(selectQuizzes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                assert resultSet != null;
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String description = null;
            try {
                description = resultSet.getString("description");
                if (description.contains(desc)) {
                    int id = resultSet.getInt("ID");
                    quizzes.add(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DatabaseConnection.closeConnection(connection);
        return quizzes;
    }

    public ArrayList<Integer> findByCategory(String cat) {
        ArrayList<Integer> quizzes = new ArrayList<>();
        ResultSet resultSet = executeQuery("SELECT category, id FROM quiz");
        while (true) {
            try {
                assert resultSet != null;
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String category = null;
            try {
                category = resultSet.getString("category");
                if (category.contains(cat)) {
                    int id = resultSet.getInt("ID");
                    quizzes.add(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quizzes;
    }

    public ResultSet executeQuery(String query) {

        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> findByName(String name) {

        Connection connection = DatabaseConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String selectQuizzes = "SELECT name, id FROM quiz";
        ResultSet resultSet = null;
        ArrayList<Integer> quizzes = new ArrayList<>();
        try {
            assert statement != null;
            resultSet = statement.executeQuery(selectQuizzes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                assert resultSet != null;
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String quizName = null;
            try {
                quizName = resultSet.getString("name");
                if (quizName.contains(name)) {
                    int id = resultSet.getInt("ID");
                    quizzes.add(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DatabaseConnection.closeConnection(connection);
        return quizzes;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String returnQuizNames(int id) {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String selectQuizzes = "SELECT name, id FROM quiz";
        ResultSet resultSet = null;
        try {
            assert statement != null;
            resultSet = statement.executeQuery(selectQuizzes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String quizName = null;
        while (true) {
            try {
                assert resultSet != null;
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            int ID;
            try {
                ID = resultSet.getInt("id");
                if (ID == id) {
                    quizName = resultSet.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DatabaseConnection.closeConnection(connection);
        return quizName;
    }


    public int calculateScore(int quizId) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = null;
        try {
            String selectQuestion = "SELECT content, answer_a, answer_b, answer_c, answer_d, right_answer FROM questions WHERE quiz_id = ?";
            statement = connection.prepareStatement(selectQuestion);
            statement.setInt(1, quizId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = null;
        try {
            assert statement != null;
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String question = null;
        String answerA;
        String answerB;
        String answerC;
        String answerD;
        Character rightAnswer;
        ArrayList<Character> userAnswers = new ArrayList<>();
        ArrayList<Character> correctAnswers = new ArrayList<>();
        //rightAnswer in luam la sfarsit, le punem intr un vector si le comparam cu raspunsurile date din usert
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                assert resultSet != null;
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                question = resultSet.getString("content");
                answerA = resultSet.getString("answer_a");
                answerB = resultSet.getString("answer_b");
                answerC = resultSet.getString("answer_c");
                answerD = resultSet.getString("answer_d");

                rightAnswer = resultSet.getString("right_answer").charAt(0);
                correctAnswers.add(rightAnswer);

                System.out.println(question);
                System.out.println(answerA);
                System.out.println(answerB);
                System.out.println(answerC);
                System.out.println(answerD);

                System.out.println("Your answer is: ");
                char answer = sc.next().charAt(0);
                userAnswers.add(answer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        int score = 0;
        for(int i = 0; i < correctAnswers.size(); i++)
        {
            if(correctAnswers.get(i).equals(userAnswers.get(i)))
                score += 10;
        }

       return score;


      //  DatabaseConnection.closeConnection(connection);
    }



    public void takeQuiz() {

        System.out.println("Cautare dupa: 1- descriere, 2 - categorie, 3 - nume");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: {
                System.out.println("Introduceti descrierea: ");
                String description = sc.next();
                ArrayList<Integer> ids = findByDescription(description);
                ArrayList<String> names = new ArrayList<>();
                for (int i = 0; i < ids.size(); i++)
                    names.add(returnQuizNames(ids.get(i)));
                for (int i = 0; i < names.size(); i++) {
                    System.out.print("Nume: " + names.get(i) + ". ID:  " + ids.get(i) + "\n");
                }
                System.out.println("Introduceti ID-ul chestionarului: ");
                int id = sc.nextInt();
                int userScore = calculateScore(id);
                System.out.println(userScore);
                String username = getUserName();
                //functie care selecteaza din baza de date id-ul userului dupa username
                //apoi inseram in score_table

                break;
            }
        }
    }
}