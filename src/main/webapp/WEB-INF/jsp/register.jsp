<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <style>
        body {
            font-family: sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .box {
            width: 230px;
            background: #f7f7f7;
            border: 1px solid #403f3f;
            padding: 25px;
            text-align: center;
        }

        h3 {
            color: #333;
        }

        input {
            width: 100%;
            padding: 6px;
            margin: 6px 0;
            border: 1px solid #999;
            border-radius: 3px;
            box-sizing: border-box;
            font-size: 11px;
        }

        button {
            width: 100%;
            padding: 6px;
            background: #ddd;
            border: 1px solid #999;
            border-radius: 3px;
            cursor: pointer;
            font-size: 11px;
        }

        p {
            font-size: 9px;
            color: #555;
            margin-top: 12px;
        }

        a {
            text-decoration: none;
        }

        .error {
            color: red;
            font-size: 11px;
        }
    </style>
</head>
<body>
<div class="box">

    <h3>Register</h3>

    <c:if test="${not empty error}"><div class="error">${error}</div></c:if>

    <form action="/register" method="post">

        <input type="text" name="username" placeholder="Username" required>

        <input type="email" name="email" placeholder="Email" required>

        <input type="password" name="password" placeholder="Password" required>

        <input type="password" name="confirmPassword" placeholder="Confirm Password" required>

        <button type="submit">Sign Up</button>

    </form>

    <p>Already have an account? <a href="/login">Log In</a></p>
</div>
</body>
</html>