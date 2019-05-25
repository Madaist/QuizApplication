package domain;

import java.util.ArrayList;

public class Question {

    private int questionID;
    private String content;
    private int score;
    ArrayList<String> answers;
    private int quizId;

    public Question(){}

    public Question(int questionID, String content, int score, ArrayList<String> answers) {
        this.questionID = questionID;
        this.content = content;
        this.score = score;
        this.answers = answers;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        /*StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(content + "\n");
        for(int i = 0; i < answers.size()-1; i++)
            stringBuilder.append(answers.get(i) + "\n");
        stringBuilder.append("\n\n\n");
        return stringBuilder.toString(); */

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(content + "\n");
        char letter = 'a';
        for (int i = 0; i < answers.size() - 1; i++) {
            stringBuilder.append(letter + ".  " + answers.get(i) + "\n");
            letter++;
        }
        return stringBuilder.toString();

    }
}
