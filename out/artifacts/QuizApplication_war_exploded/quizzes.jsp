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
<br>
<form action="http://localhost:8090/QuizApplication/showCategories" method="post">
<input type="submit" value="Show categories of quizzes available"/>
</form>

<div id="result1" class="result">
    <pre>
        ${requestScope.categories}
    </pre>
</div>

<div>
    <div class = "container1">

        <form action="http://localhost:8090/QuizApplication/showNames" method="POST">
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

        <form action="http://localhost:8090/QuizApplication/seeTop", method="post">
            <input type="submit" value="See top" />
        </form>
    </div>




    <div class="container2">
        <form method = "post" action = "findQuizByCategory">
            <div>
                <label for="quizCategoryId">Find quiz by category ID: </label>
                <input  type="text" placeholder="Enter category ID" name="quizCategoryId" id = "quizCategoryId">
            </div>

            <div>
                <button class = "btn" type="submit" name="action">Find quiz</button>
            </div>
            <br><br>
        </form>

        <form method = "post" action = "findQuizByName">
            <div>
                <label for="quizName">Find quiz by name: </label>
                <input  type="text" placeholder="Enter quiz name" name="quizName" id = "quizName">
            </div>
            <div>
                <button class = "btn" type="submit" name="action">Find quiz</button>
            </div>
            <br><br>
        </form>

        <form method = "post" action = "findQuizByDescription">
            <div>
                <label for="quizDescription">Find quiz by description: </label>
                <input  type="text" placeholder="Enter quiz description" name="quizDescription" id = "quizDescription">
            </div>

            <div>
                <button class = "btn" type="submit" name="action">Find quiz</button>
            </div>
            <br><br>
        </form>

        <div id="result" class="error">
            <pre>
                ${requestScope.error}
            </pre>
        </div>

    </div>


</div>




</body>

</html>