<%--
  Created by IntelliJ IDEA.
  User: mindit
  Date: 5/25/2019
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Take Quiz</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/takeQuiz.css">
</head>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:70px">
            <div id="result" class="result">
    <pre>
        ${requestScope.quizName}
    </pre>
            </div>
        </h1>
    </div>
</div>

<form action="http://localhost:8090/QuizApplication/calculateScore" method="POST">
<div id="result1" class="result">
    <pre>
        ${requestScope.question1}
    </pre>
</div>

<div class="button">
    <label for="answerQ1">Your answer (a/b/c/d): </label>
    <input  type="text" placeholder="Enter your answer: " name="answerQ1" id = "answerQ1">
    <br>
</div>

    <div id="result2" class="result">
    <pre>
        ${requestScope.question2}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ2">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ2" id = "answerQ2">
        <br><br>
    </div>


    <div id="result3" class="result">
    <pre>
        ${requestScope.question3}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ3">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ3" id = "answerQ3">
        <br><br>
    </div>

    <div id="result4" class="result">
    <pre>
        ${requestScope.question4}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ4">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ4" id = "answerQ4">
        <br><br>
    </div>

    <div id="result5" class="result">
    <pre>
        ${requestScope.question5}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ1">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ5" id = "answerQ5">
        <br><br>
    </div>

    <div id="result6" class="result">
    <pre>
        ${requestScope.question6}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ1">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ6" id = "answerQ6">
        <br><br>
    </div>

    <div id="result7" class="result">
    <pre>
        ${requestScope.question7}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ7">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ7" id = "answerQ7">
        <br><br>
    </div>

    <div id="result8" class="result">
    <pre>
        ${requestScope.question8}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ8">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ8" id = "answerQ8">
        <br><br>
    </div>

    <div id="result9" class="result">
    <pre>
        ${requestScope.question9}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ9">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ9" id = "answerQ9">
        <br><br>
    </div>

    <div id="result10" class="result">
    <pre>
        ${requestScope.question10}
    </pre>
    </div>

    <div class="button">
        <label for="answerQ10">Your answer (a/b/c/d): </label>
        <input  type="text" placeholder="Enter your answer: " name="answerQ10" id = "answerQ10">
        <br><br>
    </div>

        <div>
            <button class = "btn" type="submit" name="action">Submit quiz</button>
        </div>
</form>



</body>
</html>
