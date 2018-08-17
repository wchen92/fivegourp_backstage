<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/14
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="charole" class="easyui-panel" title="条件查询" data-options="iconCls:'icon-save',collapsible:true">
    <center>
        <br>
        <input id="renwuchaxun" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入任务名称'" style="width:300px"> <br><br>
        <a  href="javascript:renwuallsearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 120px;height: 30px">查询</a><br><br>
    </center>
</div>

<table id="wjyrenwuall"></table>

<script type="text/javascript">
    $(function(){
        renwuallsearch();
    })

    function renwuallsearch(){
        $("#wjyrenwuall").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/queryRenwuAll',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            queryParams: {
                renwuname:$("#renwuchaxun").val(),
            },
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
            ]]
        })
    }
</script>
</body>
</html>
