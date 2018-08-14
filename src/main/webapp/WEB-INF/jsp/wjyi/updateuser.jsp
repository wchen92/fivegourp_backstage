<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/9
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="updateuserformid">
    <input type="hidden" name="userid" value="${user.userid}">
    <table >
        <tr>
            <td> 姓名：</td>
            <td> <input type="text" name="text" value="${user.text}" class="easyui-textbox" style="width:200px"></td>
        </tr>
        <tr>
            <td>  密码：</td>
            <td> <input type="text" name="password" value="${user.password}" class="easyui-textbox" style="width:200px"></td>
        </tr>
    </table>
    <%--用户状态 ：
    <input type="radio" name="userstatus" value="${user.userstatus}"
           <c:if test="${user.userstatus==1}">checkecd</c:if>
    >已审核
    <input type="radio" name="userstatus" value="${user.userstatus}"
           <c:if test="${user.userstatus==2}">checkecd</c:if>
    >未审核</br>--%>
</form>
</body>
</html>
