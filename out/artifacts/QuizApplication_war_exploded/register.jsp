
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/registerPage.css">
    <title>QuizApplication - Register Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="register-img">
    <div class="register-text">
        <h1 style="font-size:100px">Register</h1>
    </div>
</div>

<div class="container">
    <div class="c1">
        <label for="lastName">Last name: </label>
        <input  type="text" placeholder="Enter last name" name="lastName" id = "lastName" required >
    </div>

    <div class="c2">
        <label for="firstName">First name: </label>
        <input  type="text" placeholder="Enter first name" name="firstName" id = "firstName" required >
    </div>

    <div class="c3">
        <label for="phoneNumber">Phone number: </label>
        <input  type="text" placeholder="Enter phone number" name="phoneNumber" id = "phoneNumber">
    </div>

    <div class="c4">
        <label for="username">Username: </label>
        <input  type="text" placeholder="Enter Username" name="username" id = "username" required >
    </div>

    <div class="c5">
        <label for="password">Password: </label>
        <input type="password" placeholder="Enter Password" name="password" id = "password" required>
    </div>

    <div>
        <button class = "btn" type="submit" name="action">Register</button>
    </div>



</div>

</body>
</html>