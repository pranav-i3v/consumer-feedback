<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Feedback</title>
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
            width: 375px;
            border: 1px solid #403f3f;
            padding: 25px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            color: #444;
            display: block;
            margin-top: 12px;
        }

        select, textarea {
            width: 100%;
            margin-top: 6px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        textarea {
            height: 140px;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 18px;
            background: #ddd;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
            cursor: pointer;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 12px;
            font-size: 13px;
            color: #555;
        }

        .error {
            color: red;
            font-size: 13px;
        }
    </style>
</head>
<body>
<div class="box">

    <h2>Edit Feedback</h2>
    <form action="/admin/update/${feedback.id}" method="post">
        <label>User:
            <c:out value="${feedback.user.username}"/>
        </label>
        <label>Feedback:</label>
        <textarea name="content" required><c:out value="${feedback.content}"/></textarea>
        <button type="submit">Update</button>
    </form>

    <a href="/admin">Back to Dashboard</a>
</div>
</body>
</html>