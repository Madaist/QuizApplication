
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/registerPage.css">
    <title>Login as administrator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="register-img">
    <div class="register-text">
        <h1 style="font-size:80px">Login as administrator</h1>
    </div>
</div>
<form method="post" action="adminLogin">
    <div class="container">

        <div class="c4">
            <label for="username">Username: </label>
            <input  type="text" placeholder="Enter Username" name="username" id = "username" required >
        </div>

        <div class="c5">
            <label for="password">Password: </label>
            <input type="password" placeholder="Enter Password" name="password" id = "password" required>
        </div>

        <div>
            <button class = "btn" type="submit" name="action">Login</button>
        </div>

    </div>
</form>

<div id="result" class="result">
    <pre>
        ${requestScope.loginStatus}
    </pre>
</div>

</body>
</html>