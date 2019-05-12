<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>QuizApplication</title>
    <link rel="stylesheet" href="css/mainPage.css">
</head>

<body>
<!-- banner -->
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:100px">Quiz Application</h1>
    </div>
</div>

<!--casuta de login-->
<div class="login-text">
    <p>Already have an account? <br>
    Do you feel lucky? <br>
    Login and have fun! </p>

    <form action = "http://localhost:8080/QuizApplication/web/mainPage.jsp" method = "POST">

        <div class="container">
            <div>
                <label for="uname">Username: </label>
                <input  type="text" placeholder="Enter Username" name="uname" id = "uname" required >
            </div>

            <div>
                <label for="psw">Password: </label>
                <input type="password" placeholder="Enter Password" name="psw" id = "psw" required>
            </div>

            <div>
                <button class = "btn" type="submit" name="action">Login</button>
            </div>
        </div>
    </form>
</div>








</body>

</html>