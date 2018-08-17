<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/14
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="wjyzhi"></div>
<table id="wjyzhipai"></table>

<script type="text/javascript">
    $(function(){
        renwusearch();
    })

    function renwusearch(){
        $("#wjyzhipai").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/queryZhipai',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            fit: true,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            columns:[[
                {field:'zpr',title:'指派编号',width:100},
                {field:'rwmc',title:'任务名称',width:100},
                {field:'rwnr',title:'任务内容',width:100},
                {field:'fbr',title:'发布人',width:100},
                {field:'wczt',title:'完成状态',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "已完成";
                        }else if(value == 2){
                            return "未完成";
                        }
                    }
                },
            ]]
        })
    }
</script>
</body>
</html>
