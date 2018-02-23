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
</head>
<body>
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
                <label>Name:
                    <input type="text" name="name"><br />
                </label>
                <label>Password:
                    <input type="password" name="pass"><br />
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
