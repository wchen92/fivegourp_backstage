<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/14
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="wjyren"></div>
<table id="wjyrenwu"></table>

<script type="text/javascript">
    $(function(){
        renwusearch();
    })

    function renwusearch(){
        $("#wjyrenwu").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/queryRenwu',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            fit: true,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            columns:[[
                {field:'rwid',title:'任务编号',width:100},
                {field:'rwmc',title:'任务名称',width:100},
                {field:'rwnr',title:'任务内容',width:100},
                {field:'wczt',title:'完成状态',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "已完成";
                        }else if(value == 2){
                            return "未完成";
                        }
                    }
                },
                {field:'clr',title:'处理人',width:100},
                {field:'fbr',title:'发布人',width:100},
                {field:'zpr',title:'指派人',width:100},
                {field:'sfzp',title:'是否指派',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "已指派";
                        }else if(value == 2){
                            return "未指派";
                        }
                    }
                },
                {field:'caozuo',title:'操作',width:100,
                    formatter:function(value,row,index){
                        return "<a  onclick ='updatewanchengstatus(\""+row.rwid+"\")'>完成</a>";
                    }
                },
            ]]
        })
    }

    function updatewanchengstatus(rwid){
        $.ajax({
            url:"<%=request.getContextPath()%>/wjyi/updateWanchengStatus?rwid="+rwid,
            type:"post",
            datatype:"json",
            success:function(reslut){
                if(reslut==1){
                    alert("修改成功")
                    $("#wjyrenwu").datagrid('load');
                }
            },
            error: function(){
                alert("修改失败");
            }
        });
    }
</script>
</body>
</html>
