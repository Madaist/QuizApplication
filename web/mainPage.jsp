
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


<div>
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
                <% String userLogin = request.getParameter("uname"); %>
            </div>

            <div>
                <label for="psw">Password: </label>
                <input type="password" placeholder="Enter Password" name="psw" id = "psw" required>
                <% String passwordLogin = request.getParameter("psw"); %>
            </div>

            <div>
                <button class = "btn" type="submit" name="action">Login</button>
            </div>

        </div>
    </form>
</div>

    <!-- casuta de register -->
    <div class="register-text">
        <p>Don't have an account?<br>
           Don't miss all the fun!<br>
            Register now. :) </p>
        
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