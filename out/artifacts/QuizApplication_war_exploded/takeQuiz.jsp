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
</div>

<div id="result" class="result">
    <pre>
        ${requestScope.questions}
    </pre>
</div>




</body>
</html>
