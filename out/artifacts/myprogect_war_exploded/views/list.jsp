<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: felix
  Date: 14.1.18
  Time: 21.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get users list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div class="w3-container w3-border-blue-grey w3-opacity w3-left-align">
            <h2>
                Users
            </h2>
        </div>
        <%
            List<String> names = (List<String>)request.getAttribute("userNames");

            if (names!=null&&!names.isEmpty()){
                out.println("<ui>");
                for(String s:names){
                    out.println("<li>" +s+"</li>");
                }
                out.println("</ui>");
            } else {
                out.println("<p>There are no users yet!</p>");
            }

        %>
    </div>

</div>

<div>
    <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
