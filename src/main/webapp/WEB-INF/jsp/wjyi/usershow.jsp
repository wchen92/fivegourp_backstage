<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/9
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div id="wjyu"></div>
    <table id="wjyuser"></table>
    <input type="hidden" id="userid-hiddens">

<script type="text/javascript">
    $(function(){
        usersearch();
    })

    function usersearch(){
        $("#wjyuser").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/queryuser',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#wjyu').dialog({
                        title: "新增用户信息",
                        width: 400,
                        height: 200,
                        href: "<%=request.getContextPath()%>/wjyiiindex/addusershow",
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/wjyi/adduser",
                                    type:"post",
                                    data:$("#adduserformid").serialize(),
                                    datatype:"json",
                                    success:function(reslut){
                                        if(reslut==1){
                                            alert("新增成功")
                                            $("#wjyuser").datagrid('load');
                                            $("#wjyu").dialog('close');
                                        }
                                    },
                                    error: function(){
                                        alert("新增失败");
                                    }
                                });
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#wjyu").dialog('close');
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var arr = $("#wjyuser").datagrid('getChecked');
                    var idlength = arr.length;
                    if(idlength==0){
                        alert("请选择要删除的数据");
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
                    if(confirm("确定删除吗")){
                        $.ajax({
                            url:"<%=request.getContextPath() %>/wjyi/deleteuser?userid="+shu,
                            type:"post",
                            dataType:"text",
                            success:function(data){
                                if(data==1){
                                    alert("删除成功")
                                    $("#wjyuser").datagrid('load');
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
                {field:'userstatus',title:'用户状态',width:100},
                {field:'caozuo',title:'操作',width:100,
                    formatter:function(value,row,index){
                        return "<a class='icon-edit' onclick ='updateuser("+row.userid+")'>&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                    }
                },
                {field:'fu',title:'操作2',width:100,
                    formatter:function(value,row,index){
                        return "<a onclick=' fujuese(\""+row.userid+"\")'>用户赋角色&nbsp;&nbsp;&nbsp;</a >";
                    }
                }
            ]]
        })
    }
    function updateuser(userid){
        $('#wjyu').dialog({
            title: "修改",
            width: 400,
            height: 200,
            href: "<%=request.getContextPath()%>/wjyiiindex/queryById?userid="+userid,
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/wjyi/updateuser",
                        type:"post",
                        data:$("#adduserformid").serialize(),
                        datatype:"json",
                        success:function(reslut){
                            if(reslut==1){
                                alert("修改成功")
                                $("#wjyuser").datagrid('load');
                                $("#wjyu").dialog('close');
                            }
                        },
                        error: function(){
                            alert("修改失败");
                        }
                    });
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#wjyu").dialog('close');
                }
            }]
        });
    }

    function fujuese(userid){
        $("#userid-hiddens").val(userid);
        $('#wjyu').dialog({
            title: "修改",
            width: 400,
            height: 200,
            href: "<%=request.getContextPath()%>/wjyiiindex/queryRoleTree",
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    addRole(userid);
                    $('#wjyuser').window('close');
                }
            },
                {
                    text:'关闭',
                    handler:function(){
                        $('#wjyu').window('close');
                    }
                }]
        });
        }
</script>
</body>
</html>
