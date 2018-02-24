<%--
  Created by IntelliJ IDEA.
  User: felix
  Date: 14.1.18
  Time: 21.08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

    <div>
        <%
            if (request.getAttribute("userName")!=null){
                out.println("<p>User'"+request.getAttribute("userName")+"' added!<!p>");
            }
        %>
    </div>
    <div>
        <div>
            <div>
                <h2>Add User</h2>
            </div>

            <form method="post">
                <label>Добавление пользователя
                    <button class="w3-btn w3-hover-light-blue w3-round-large w3-right-align" type="submit">Сохранить </button><br />
                </label>
                <label>Name:
                    <input type="text" name="name"><br />
                </label>
                <label>Password:
                    <input type="password" name="pass"><br />
                </label>

            </form>


        </div>
    </div>

    <div>
        <button class="w3-btn w3-hover-pale-red w3-hover-text-red w3-round-large w3-left-align" onclick="location.href='/'">Возврат/Отмена</button>
    </div>
</body>
</html>
