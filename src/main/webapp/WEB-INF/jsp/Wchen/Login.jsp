<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/10
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="wchentable"></table>

<script>
    $('#wchentable').datagrid({
        url:'<%=request.getContextPath()%>/wchencontroller/selectlog',
        singleSelect:true,
        checkOnSelect:false,
        selectOnCheck:false,
        pagination:true,//开启分页
        pageNumber:1,//初始化页码
        pageSize:3,//每页条数
        pageList:[3,6,8],//每页条数的下拉选项
        columns:[[
            {field:'classname',title:'访问类',width:100},
            {field:'methodName',title:'访问方法',width:100},
            {field:'userid',title:'访问人id',width:100},
            {field:'createTime',title:'访问时间',width:100},
        ]]
    });
</script>
</body>
</html>
