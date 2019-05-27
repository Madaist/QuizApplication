package domain;

public class Score {
    public User user;
    public int score;
    public String quizName;

    public Score(User user, int score, String quizName) {
        this.user = user;
        this.score = score;
        this.quizName = quizName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user.getLastName() + " " + user.getFirstName());
        int space1 = 35 - stringBuilder.length();
        for(int i = 0; i < space1; i++)
            stringBuilder.append(" ");
        stringBuilder.append(quizName);
        int space2 = 65 - stringBuilder.length();
        for(int i = 0; i < space2; i++)
            stringBuilder.append(" ");
        stringBuilder.append(score);
        stringBuilder.append("\n");
        return stringBuilder.toString();

    }
}
