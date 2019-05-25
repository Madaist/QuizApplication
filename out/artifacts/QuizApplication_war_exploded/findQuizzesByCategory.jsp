<%--
  Created by IntelliJ IDEA.
  User: mindit
  Date: 5/17/2019
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find quizzes by category</title>
    <link rel="stylesheet" href="css/findQuizzesByCategory.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>


<body>

<div class = "cover">
    <div class="cover-text">
        <h1 style="font-size:80px">Find the perfect quiz for you</h1>
    </div>
</div>


<h1>Category is: </h1>
 <div id="result1" class="result">
    <pre>
        ${requestScope.categoryName}
    </pre>
</div>

<h1> Quizzes from the selected category are: </h1>
<div id="result2" class="result">

    <pre>
        ${requestScope.quizzesByCategory}
    </pre>

</div>

<form action="http://localhost:8090/QuizApplication/findQuizByNameFromCategories" method="POST">
    <div class="button">
        <label for="quizName">Enter the quiz name you want to take:  </label>
        <input  type="text" placeholder="Enter quiz name" name="quizName" id = "quizName">
        <br>
        <div>
            <button class = "btn" type="submit" name="action">Start quiz</button>
        </div>
    </div>
</form>

    <div id="result" class="error">
            <pre>
                ${requestScope.error}
            </pre>
    </div>

</body>
</html>
