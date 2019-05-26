<%--
  Created by IntelliJ IDEA.
  User: mindit
  Date: 5/26/2019
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create quiz</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/createQuiz.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:100px">Create Quiz</h1>
    </div>
</div>
<form method = "post" action="createQuizPart1">
<div>
    <label for="category">Quiz category: </label>
    <input type="text" placeholder="Enter the quiz category" name="category" id = "category" required>
</div>

<div>
    <label for="name">Quiz name: </label>
    <input type="text" placeholder="Enter the quiz name" name="name" id = "name" required>
</div>

<div>
    <label for="description">Quiz description: </label>
    <input type="text" placeholder="Enter the quiz description" name="description" id = "description" required>
</div>

<div>
    <label for="numberQ">Number of questions: </label>
    <input type="number" placeholder="Enter the number of questions" name="numberQ" id = "numberQ" required>
</div>

<div>
    <label for="nrAnswers">Number of answers for a question: </label>
    <input type="number" placeholder="Enter the question's number of answers: " name="nrAnswers" id="nrAnswers" required>
</div>
<br><br>

    <div>
        <button class = "btn" type="submit" name="action">Insert quiz in database</button>
    </div>


</form>


<!--

<% for(int i = 0; i < 10; i++) { %>

<div>
    <label for="content">Question content: </label>
    <input type="text" placeholder="Enter the question's content: " name="content" id="content" required>
</div>

<div>
    <label for="score">Question score: </label>
    <input type="number" placeholder="Enter the question's score: " name="score" id="score" required>
</div>

<div>
    <label for="nrAnswers">Question number of answers: </label>
    <input type="number" placeholder="Enter the question's number of answers: " name="nrAnswers" id="nrAnswers1" required>
</div>

<% for(int j = 0; j < 4; j++) { %>

<div>
    <label for="answer">Answer </label>
    <input type="text" placeholder="Enter answer: " name="answer" id="answer" required>
</div>

<% } %>

<div>
    <label for="rightAnswer">Right answer: </label>
    <input type="text" placeholder="a/b/c/d " name="rightAnswer" id="rightAnswer" required>
</div>

<br><br>
<% } %>
</form action ="/createQuiz" method="post">
 <div>
        <button class = "btn" type="submit" name="action">Create quiz</button>
    </div>
</form>
-->


</body>
</html>
