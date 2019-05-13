package dao;

import domain.*;
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
        } catch(Exception e){
            e.printStackTrace();
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
        ArrayList<Integer> quizzes = new ArrayList<>();
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizIdByDescription)){
            statement.setString(1, description);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int quizId = resultSet.getInt("ID");
                quizzes.add(quizId);
            }
            resultSet.close();
            close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return quizzes;
    }

    public static ArrayList<Integer> getQuizIdByCategory(int categoryId){
        ArrayList<Integer> quizzes = new ArrayList<>();
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizIdByCategory)){
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int quizId = resultSet.getInt("ID");
                quizzes.add(quizId);
            }
            resultSet.close();
            close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return quizzes;
    }


    public static int getQuizIdByName(String name){
        int quizId = -1;
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuizIdByName)){
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                  quizId = resultSet.getInt("ID");
            }
            resultSet.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizId;
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
        ArrayList<Question> questions = new ArrayList<>();
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.selectQuestionsByQuizId)){
            statement.setInt(1, quizId);
            ResultSet resultSet = statement.executeQuery();
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
        } catch(SQLException e){
            e.printStackTrace();
        }
        return questions;
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

    public static void insertQuiz(Quiz quiz){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.insertQuiz)){
            statement.setInt(1, quiz.getCategoryId());
            statement.setString(2, quiz.getDescription());
            statement.setInt(3, quiz.getNumberOfQuestions());
            statement.setString(4, quiz.getQuizName());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static  void insertQuestion(Question question){
        try(PreparedStatement statement = getConnection().prepareStatement(DatabaseData.insertQuestion)){
            statement.setString(1, question.getContent());
            statement.setInt(2, question.getQuizId());
            statement.setInt(3, question.getScore());
            int k = 4;
            for(int i = 0; i < question.getAnswers().size()-1; i++){
                statement.setString(k, question.getAnswers().get(i));
                k++;
            }
            statement.setString(8, question.getAnswers().get(question.getAnswers().size()-1));
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertCategory(Category category) {
        try (PreparedStatement statement = getConnection().prepareStatement(DatabaseData.insertCategory)) {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static ArrayList<Category> selectCategories () {
        ArrayList<Category> categories = new ArrayList<>();
            try (PreparedStatement statement = getConnection().prepareStatement(DatabaseData.insertCategory)) {
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    int categoryId = resultSet.getInt("category_id");
                    String categoryName = resultSet.getString("category_name");
                    Category category = new Category(categoryId, categoryName);
                    categories.add(category);
                }
             resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  categories;
        }
    }