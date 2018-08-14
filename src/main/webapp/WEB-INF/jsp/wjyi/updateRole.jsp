<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="updateRoleformid">
    <input type="hidden" name="roleid" value="${role.roleid}">
    <table >
        <tr>
            <td> 角色名称：</td>
            <td> <input type="text" name="text" value="${role.text}" class="easyui-textbox" style="width:200px"></td>
        </tr>
    </table>
</form>
</body>
</html>
