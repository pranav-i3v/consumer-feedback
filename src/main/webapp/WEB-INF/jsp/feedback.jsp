<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Feedback</title>
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
            background: #fff;
            border: 1px solid #403f3f;
            padding: 25px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .tabs {
            display: flex;
            gap: 15px;
            margin-bottom: 20px;
        }

        .tabs a {
            flex: 1;
            text-align: center;
            padding: 12px;
            background: #ddd;
            border: 1px solid #ccc;
            border-radius: 3px;
            color: #222;
            text-decoration: none;
        }

        .tabs a.active {
            background: #ccc;
            border: 2px solid #333;
        }

        label { color: #444; }

        textarea {
            width: 100%;
            height: 140px;
            margin-top: 6px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            font-family: monospace;
            font-size: 15px;
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

        .msg {
            font-size: 13px;
            color: #a15c00;
            margin-bottom: 10px;
        }

        .ok {
            font-size: 13px;
            color: green;
            margin-bottom: 10px;
        }

        .logout {
            display: block;
            text-align: right;
            font-size: 12px;
            color: #555;
        }

    </style>
</head>
<body>
<div class="box">
    <a class="logout" href="/logout">Logout</a>
    <h2>Feedback</h2>

    <div class="tabs">
        <a href="/feedback?mode=add" class="${mode == 'add' ? 'active' : ''}">Add Feedback</a>
        <a href="/feedback?mode=edit" class="${mode == 'edit' ? 'active' : ''}">Edit Feedback</a>
    </div>

    <c:if test="${param.success == 'true'}"><div class="ok">Feedback saved successfully.</div></c:if>
    <c:if test="${not empty message}"><div class="msg">${message}</div></c:if>

    <form action="/feedback" method="post">
        <input type="hidden" name="mode" value="${mode}">
        <label>Your Feedback:</label>
        <textarea name="content" placeholder="Write your feedback here..." required><c:out value="${content}"/></textarea>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>