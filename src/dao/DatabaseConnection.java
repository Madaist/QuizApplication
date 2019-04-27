package dao;

import domain.Question;
import domain.Score;
import domain.User;
import services.DatabaseData;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    private static Connection connection;


    public static Connection getConnection() {
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

    public static void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(User user){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.insertUser)){
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getPhoneNumber());
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        close();
    }

    public static User selectUser(String username){
        User user = new User();
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectUserByUsername)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user.setUserName(resultSet.getString("username"));
                user.setLastName(resultSet.getString("last_name"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));
                user.setID(resultSet.getInt("user_id"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public static User selectUser(int userId){
        User user = new User();
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectUserByUserId)){
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                user.setUserName(resultSet.getString("username"));
                user.setLastName(resultSet.getString("last_name"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setPassword(resultSet.getString("password"));
                user.setID(resultSet.getInt("user_id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public static String getPassword(String username){

        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectPassword)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            String password = null;
            if(resultSet.next())
                 password =  resultSet.getString("password");
            resultSet.close();
            close();
            return password;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> getAllUsernames(){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectUsernames)){
            ResultSet resultSet = statement.executeQuery();
            ArrayList<String> usernames = new ArrayList<>();
            while(resultSet.next()){
                String username = resultSet.getString("username");
                usernames.add(username);
            }
            resultSet.close();
            close();
            return usernames;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static  ArrayList<Integer> getQuizIdByDescription(String description){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizIdByDescription)){
            statement.setString(1, description);
            ArrayList<Integer> quizzes = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int quizId = resultSet.getInt("ID");
                quizzes.add(quizId);
            }
            resultSet.close();
            close();
            return quizzes;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Integer> getQuizIdByCategory(String category){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizIdByCategory)){
            statement.setString(1, category);
            ArrayList<Integer> quizzes = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int quizId = resultSet.getInt("ID");
                quizzes.add(quizId);
            }
            resultSet.close();
            close();
            return quizzes;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList<Integer> getQuizIdByName(String name){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizIdByName)){
            statement.setString(1, name);
            ArrayList<Integer> quizzes = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int quizId = resultSet.getInt("ID");
                quizzes.add(quizId);
            }
            resultSet.close();
            close();
            return quizzes;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public static String getQuizName(int id){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizNameById)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            String quizName = null;
            if(resultSet.next())
             quizName = resultSet.getString("name");
            resultSet.close();
            close();
            return quizName;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Question> getQuestions(int quizId){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuestionsByQuizId)){
            statement.setInt(1, quizId);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Question> questions = new ArrayList<>();
            while(resultSet.next()){
                Question question = new Question();
                question.setQuestionID(resultSet.getInt("question_id"));
                question.setContent(resultSet.getString("content"));
                question.setScore(resultSet.getInt("question_score"));
                ArrayList<String> answers = new ArrayList<>();
                answers.add(resultSet.getString("answer_a"));
                answers.add(resultSet.getString("answer_b"));
                answers.add(resultSet.getString("answer_c"));
                answers.add(resultSet.getString("answer_d"));
                answers.add(resultSet.getString("right_answer"));
                question.setAnswers(answers);
                questions.add(question);
            }
            resultSet.close();
            close();
            return questions;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public static void insertScore(int score, int userId, int quizId){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.insertScore)){
            statement.setInt(1, score);
            statement.setInt(2, userId);
            statement.setInt(3, quizId);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        close();
    }

    public static ArrayList<Score> getTop(){
        ArrayList<Score> scores = new ArrayList<>();
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectScore)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int score = resultSet.getInt("score");
                int userId = resultSet.getInt("user_id");
                int quizId = resultSet.getInt("quiz_id");
                User user = selectUser(userId);
                String quizName = getQuizName(quizId);
                Score s = new Score(user, score, quizName);
                scores.add(s);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return scores;
    }


}
