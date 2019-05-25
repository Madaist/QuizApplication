package services;

import domain.Category;
import domain.Score;

import java.util.ArrayList;

public class ShowQuizzesService {

    public static StringBuffer categoryArrayToString(ArrayList<Category> categories){
        StringBuffer stringBuffer = new StringBuffer();
        for(Category category : categories)
            stringBuffer.append("Category Id: " + category.getCategoryId() + "    " +
                                "Category name: " + category.getName() + "\n        ");
        return stringBuffer;
    }

    public static StringBuffer namesArrayToString(ArrayList<String> quizNames){
        StringBuffer stringBuffer = new StringBuffer();
        for(String name : quizNames)
            stringBuffer.append(name + "\n        ");
        return stringBuffer;
    }

    public static StringBuffer descriptionsArrayToString(ArrayList<String> quizDescriptions){
        StringBuffer stringBuffer = new StringBuffer();
        for(String desc : quizDescriptions)
            stringBuffer.append(desc + "\n        ");
        return stringBuffer;
    }

    public static StringBuilder scoresArrayToString(ArrayList<Score> scores){
        StringBuilder stringBuilder = new StringBuilder();
        for(Score score : scores)
            stringBuilder.append(score);
        return stringBuilder;
    }


}
