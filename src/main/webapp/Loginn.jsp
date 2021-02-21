<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19/2/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<!-- Font -->
<link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&family=Montserrat:wght@600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/loginn.css">
<body>
<div class="container">
    <div class="box">
        <input type="checkbox" id="toggle" class="box__toggle" hidden>
        <img src="https://images.unsplash.com/photo-1543796076-c3de9336288a?ixid=MXwxMjA3fDB8MHxzZWFyY2h8N3x8eWVsbG93JTIwY2FyfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60" alt="Picture by Autumn Studio" class="box__image">
        <form class="form form--register" action="register" method="post">
            <h1 class="form__title">Sign up</h1>
            <p class="text-danger">${error}</p>
            <div class="form__helper">
                <input type="username" name="user" id="new-user" placeholder="User" class="form__input" />
                <label class="form__label" for="new-user">User</label>
            </div>

            <div class="form__helper">
                <input type="email" name="email" id="email" placeholder="Email" class="form__input" />
                <label class="form__label" for="email">Email</label>
            </div>

            <div class="form__helper">
                <input type="password" name="password" id="new-user-password" placeholder="Password" class="form__input" />
                <label class="form__label" for="new-user-password">Password</label>
            </div>

            <div class="form__helper">
                <input type="password" name="repassword" id="confirm-password" Placeholder="Confirm password" class="form__input" />
                <label class="form__label" for="confirm-password">Confirm password</label>
            </div>

            <button type="submit" class="form__button">Register</button>

            <p class="form__text">Already have an account? <label for="toggle" class="form__link">Sign in!</label>
        </form>

        <form class="form form--login" action="login" method="post">
            <h1 class="form__title">Sign in</h1>
             <p class="text-danger">${error}</p>
            <div class="form__helper">
                <input type="text" name="user" id="user" placeholder="User" class="form__input" />
                <label class="form__label" for="user">User</label>
            </div>

            <div class="form__helper">
                <input type="password" name="password" id="password" placeholder="Password" class="form__input" />
                <label class="form__label" for="password">Password</label>
            </div>

            <button type="submit" class="form__button">Login</button>

            <p class="form__text">Don't have an account? <label for="toggle" class="form__link">Sign up!</label>
        </form>
    </div>
</div>
</body>

</html>
