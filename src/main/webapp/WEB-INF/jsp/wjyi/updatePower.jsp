<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="updatePowerformid">
    <input type="hidden" name="id" value="${power.id}">
    <table >
        <tr>
            <td>权限名称：</td>
            <td> <input type="text" name="text" value="${power.text}" class="easyui-textbox" style="width:200px"></td>
        </tr>
        <tr>
            <td> pid：</td>
            <td> <input type="text" name="pid" value="${power.pid}" class="easyui-textbox" style="width:200px"></td>
        </tr>
    </table>
</form>
</body>
</html>
