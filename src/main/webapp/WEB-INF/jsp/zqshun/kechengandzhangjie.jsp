<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>课程下所属章节页面</title>
</head>
<body>

<form>

<c:forEach items="${zhangJie}" var="zj">
    <tr>
       <td> ${zj.zhangjieid}<br></td>
       <td>${zj.kechengid}<br></td>
       <td>  ${zj.keandzhangid}<br></td>
       <td> ${zj.kechengid}<br></td>
       <td> ${zj.zhangjieid}<br></td>


    </tr>

</form>






</c:forEach>
--%>






</body>
</html>
