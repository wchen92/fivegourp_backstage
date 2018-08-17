<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>系统人员审核</h1>

<div id="wjyshen"></div>
<table id="wjyshenhe"></table>

<script type="text/javascript">
    $(function(){
        shenheusersearch();
    })

    function shenheusersearch(){
        $("#wjyshenhe").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/shenheuser',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            toolbar: [{
                text:'审核系统人员',
                iconCls: 'icon-edit',
                handler: function(){
                    var arr = $("#wjyshenhe").datagrid('getChecked');
                    var idlength = arr.length;
                    if(idlength==0){
                        alert("请选择要审核的数据");
                        return false;
                    }
                    var shu="";
                    for(var i=0;i<arr.length;i++){
                        if(i==0){
                            shu+=arr[i].userid;
                        }else{
                            shu+=","+arr[i].userid;
                        }
                    }
                    if(confirm("确定审核"+idlength+"条数据吗")){
                        $.ajax({
                            url:'<%=request.getContextPath() %>/wjyi/piliangquerenuserid?userid='+shu,
                            type:"post",
                            dataType:"text",
                            success:function(data){
                                if(data==1){
                                    alert("审核成功")
                                    $("#wjyshenhe").datagrid('load');
                                }
                            },
                            error:function(){
                                alert("请求失败");
                            }
                        })
                    }
                }
            }],
            columns:[[
                {field:'check',checkbox:true},
                {field:'userid',title:'用户编号',width:100},
                {field:'text',title:'用户名称',width:100},
                {field:'pid',title:'pid',width:100},
                {field:'password',title:'密码',width:100},
                {field:'userstatus',title:'用户状态',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "已审核";
                        }else if(value == 2){
                            return "未审核";
                        }
                    }
                },
            ]]
        })
    }

</script>
</body>
</html>
