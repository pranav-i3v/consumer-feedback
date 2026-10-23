<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: sans-serif;
            background: #f8f8f8;
            margin: 0;
            padding: 40px;
        }

        .box {
            max-width: 900px;
            margin: auto;
            border: 1px solid #403f3f;
            padding: 25px;
        }

        h2 {
            color: #333;
            display: inline-block;
        }

        .top {
            display: flex;
            justify-content: space-between;
            align-items: center;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
            vertical-align: top;
        }

        th {
            background: #eee;
        }

        a.btn, button {
            padding: 6px 12px;
            background: #ddd;
            border: 1px solid #ccc;
            border-radius: 3px;
            color: #222;
            text-decoration: none;
            font-size: 13px;
            cursor: pointer;
        }

        form {
            display: inline;
        }

        #logout-link {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="box">
    <div class="top">
        <h2>Admin Feedback Dashboard</h2>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Feedback</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${feedbacks}" var="f">
            <tr>
                <td>${f.id}</td>
                <td>
                    <c:out value="${f.content}"/>
                </td>
                <td>
                    <c:out value="${f.createdAt}"/>
                </td>
                <td>
                    <a class="btn" href="/admin/edit/${f.id}">Edit</a>
                    <form action="/admin/delete/${f.id}" method="post"
                          onsubmit="return confirm('Delete this feedback?');">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty feedbacks}">
            <tr>
                <td colspan="5">No feedback found.</td>
            </tr>
        </c:if>
    </table>
    <div id="logout-link">
        <a href="/logout">Logout</a>
    </div>
</div>

</body>
</html>