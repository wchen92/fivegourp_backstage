<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>课程下所属章节页面</title>
</head>
<body>



      <table border="1">
            <thead>
                <tr>
                    <td>编号</td>
                    <td>名称</td>
                    <td>收费状态</td>
                    <td>视频</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${zj}" var="ccc">
                <tr>
                <td>${ccc.zhangjieid}</td>
                <td>${ccc.zhangjiename}</td>
                <td>
                        ${ccc.shoufeistatus ==1 ? '收费': ''}
                        ${ccc.shoufeistatus ==2 ? '免费': ''}
                </td>
                <td>${ccc.shipin}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


</body>
</html>
