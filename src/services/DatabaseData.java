package services;

public interface DatabaseData {

    String selectUsernames = "SELECT username from user";
    String insertUser = "INSERT INTO user(username, last_name, first_name, phone_number, password) VALUES(?, ?, ?, ?, ?)";
    String selectPassword = "SELECT password FROM user where username = ?";
    String selectQuizIdByDescription = "SELECT id FROM quiz where description = ? ";
    String selectQuizIdByCategory = "SELECT id FROM quiz where category = ? ";
    String selectQuizIdByName = "SELECT id FROM quiz where name = ? ";
    String selectQuizNameById = "SELECT name FROM quiz WHERE id = ?";
    String selectQuestionsByQuizId = "SELECT * FROM questions WHERE quiz_id = ?";
    String selectUserByUsername = "SELECT * FROM user WHERE username = ?";
    String insertScore = "INSERT INTO score_table(score, user_id, quiz_id) VALUES (?, ?, ?)";
    String selectScore = "SELECT * FROM score_table ORDER BY score DESC";
    String selectUserByUserId = "SELECT * FROM user WHERE user_id = ?";




}
