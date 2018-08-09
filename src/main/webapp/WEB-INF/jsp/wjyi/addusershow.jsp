<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/9
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form id="adduserformid">
        <input type="hidden" name="userid" value="${user.userid}">
        姓名： <input type="text" name="text" value="${user.text}"></br>
        密码：<input type="text" name="password" value="${user.password}"></br>
    </form>
</body>
</html>
