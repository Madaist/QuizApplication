<%--
  Created by IntelliJ IDEA.
  User: mindit
  Date: 5/25/2019
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Score</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/calculateScore.css">
</head>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:50px">Your score is: ${requestScope.score} </h1>
    </div>
</div>

<div id="result" class="result">
    <pre>
        ${requestScope.showRightAnswers}
    </pre>
</div>


<form action="http://localhost:8090/QuizApplication/seeTop", method="post">
    <input type="submit" value="See top" />
</form>

</body>
</html>
