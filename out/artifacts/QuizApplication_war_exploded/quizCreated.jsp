<%--
  Created by IntelliJ IDEA.
  User: mindit
  Date: 5/26/2019
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz Application</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/quizCreated.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:70px">You successfully created a new quiz!</h1>
    </div>
</div>

<form action="http://localhost:8090/QuizApplication/">
    <input type="submit" value="Go back to the main page" />
</form>

</body>
</html>
