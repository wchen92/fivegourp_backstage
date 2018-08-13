<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>章节管理页面</title>
</head>
<body>

<table id="dgzhangjie"></table>
<div id="divzhangjie"></div>


<script type="text/javascript">

    $(function(){
        $('#dgbanxing').datagrid({
            url:'<%=request.getContextPath() %>/zqshun/queryzhangjie',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            fitColumns:true,//自适应父容器
            pagination:true,//开启分页
            pageNumber:1,//初始化页码
            pageSize:3,//每页条数
            pageList:[3,5,8,12],//每页条数的下拉选项
            columns:[[
                //field :对应实体类中的属性名（尽量），必须保证唯一性
                {field:'che',width:100,checkbox:true},
                {field:'zhangjieid',title:'章节号',width:100},
                {field:'zhangjiename',title:'章节名称',width:100},
                {field:'shipin',title:'视频',width:100},
                {field:'shoufeistatus',title:'收费状态',width:100},

                {field:'act',title:'操作',width:100,
                    formatter: function(value,row,index){
                        //return "<a href=\"javascript:void(0)\" onclick=\"banxingupdate('+row.banxingid+')\" >修改</a>";
                        return '<a href="#" onclick="banxingupdate(\'' +row.banxingid+ '\')">修改</a>';

                    }
                },
            ]]
        });
    })


</script>


</body>
</html>
