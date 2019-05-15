<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/quizzes.css">
    <title>QuizApplication - Quizzes Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="quizzes-img">
</div>
<!--
<form method = "post" action = "findQuiz">

    <div class="container">
        <div>
            <label for="quizCategory">Find quiz by category: </label>
            <input  type="text" placeholder="Enter category" name="quizCategory" id = "quizCategory">
        </div>

        <div>
            <label for="quizName">Find quiz by name: </label>
            <input  type="text" placeholder="Enter quiz name" name="quizName" id = "quizName">
        </div>

        <div>
            <label for="quizDescription">Find quiz by description: </label>
            <input  type="text" placeholder="Enter quiz description" name="quizDescription" id = "quizDescription">
        </div>


    </div>
</form>
-->


<form action="http://localhost:8090/QuizApplication/showCategories" method="post">
<input type="submit" value="Show categories of quizzes available"/>
</form>

<div id="result1" class="result">
    <pre>
        ${requestScope.categories}
    </pre>
</div>


<form action="http://localhost:8090/QuizApplication/showNames" method="post">
    <input type="submit" value="Show the names of quizzes"/>
</form>

<div id="result2" class="result">
    <pre>
        ${requestScope.names}
    </pre>
</div>

<form action="http://localhost:8090/QuizApplication/showDescriptions" method="post">
    <input type="submit" value="Show the description of quizzes"/>
</form>

<div id="result3" class="result">
    <pre>
        ${requestScope.descriptions}
    </pre>
</div>

</body>

</html>