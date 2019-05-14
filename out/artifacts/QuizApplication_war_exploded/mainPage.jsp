<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>QuizApplication - Main Page</title>
    <link rel="stylesheet" href="css/mainPage.css">
</head>

<body>
<!-- banner -->
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:100px">Quiz Application</h1>
    </div>
</div>


<div>
    <!--casuta de login-->
    <div class="login-text">
         <p><b>Already have an account? <br>
            Do you feel lucky? <br>
             Login and have fun! </b></p>

    <form action = "/home" method = "GET">

        <div class="container">
            <div>
                <label for="username">Username: </label>
                <input  type="text" placeholder="Enter Username" name="username" id = "username" required >
            </div>

            <div>
                <label for="password">Password: </label>
                <input type="password" placeholder="Enter Password" name="password" id = "password" required>
            </div>

            <div>
                <button class = "btn" type="submit" name="action">Login</button>
            </div>

        </div>
    </form>
</div>

    <!-- casuta de register -->
    <div class="register-text">
        <p><b>Don't have an account?<br>
           Don't miss all the fun!<br>
            Register now. :)</b> </p>

        <form action="/QuizApplication/web/register.jsp">
            <input type="submit" value="Register" />
        </form>
    </div>

    <div class="animated-gif">
        <img src="css/gallery/blank-paper.gif" alt = "quiz gif">
    </div>

</div>

</body>

</html>