<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 10:15
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
        <input id="rolechaxun" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入角色名称'" style="width:300px"> <br><br>
        <a  href="javascript:rolesearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 120px;height: 30px">查询</a><br><br>
    </center>
</div>


<div id="wjyr"></div>
<table id="wjyrole"></table>
<input type="hidden" id="roleid-hiddens" >
<input type="hidden" id="userid-hiddens" >

<script type="text/javascript">
    $(function(){
        rolesearch();
    })

    function rolesearch(){
        $("#wjyrole").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/queryRole',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            queryParams: {
                text:$("#rolechaxun").val(),
            },
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#wjyr').dialog({
                        title: "新增信息",
                        width: 400,
                        height: 200,
                        href: "<%=request.getContextPath()%>/wjyiiindex/addRoleShow",
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/wjyi/addRole",
                                    type:"post",
                                    data:$("#addRoleformid").serialize(),
                                    datatype:"json",
                                    success:function(reslut){
                                        if(reslut==1){
                                            alert("新增成功")
                                            $("#wjyrole").datagrid('load');
                                            $("#wjyr").dialog('close');
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
                                $("#wjyr").dialog('close');
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var arr = $("#wjyrole").datagrid('getChecked');
                    var idlength = arr.length;
                    if(idlength==0){
                        alert("请选择要删除的数据");
                        return false;
                    }
                    var shu="";
                    for(var i=0;i<arr.length;i++){
                        if(i==0){
                            shu+=arr[i].roleid;
                        }else{
                            shu+=","+arr[i].roleid;
                        }
                    }
                    if(confirm("确定删除吗")){
                        $.ajax({
                            url:"<%=request.getContextPath() %>/wjyi/deleteRole?roleid="+shu,
                            type:"post",
                            dataType:"text",
                            success:function(data){
                                if(data==1){
                                    alert("删除成功")
                                    $("#wjyrole").datagrid('load');
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
                {field:'roleid',title:'角色编号',width:100},
                {field:'text',title:'角色名称',width:100},
                {field:'pid',title:'pid',width:100},
                {field:'caozuo',title:'操作',width:100,
                    formatter:function(value,row,index){
                        return "<a class='icon-edit' onclick ='updaterole(\""+row.roleid+"\")'>&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                    }
                },
                {field:'fu',title:'操作2',width:100,
                    formatter: function(value,row,index){
                        return "<a onclick='fupower(\""+row.roleid+"\",\""+row.userid+"\")'>角色赋权限</a>";
                    }
                }
            ]]
        })
    }
    function updaterole(roleid){
        $('#wjyr').dialog({
            title: "修改",
            width: 400,
            height: 200,
            href: "<%=request.getContextPath()%>/wjyiiindex/queryRoleById?roleid="+roleid,
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/wjyi/updateRole",
                        type:"post",
                        data:$("#updateRoleformid").serialize(),
                        datatype:"json",
                        success:function(reslut){
                            if(reslut==1){
                                alert("修改成功")
                                $("#wjyrole").datagrid('load');
                                $("#wjyr").dialog('close');
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
                    $("#wjyr").dialog('close');
                }
            }]
        });
    }

    function  fupower(roleid,userid) {
            $("#roleid-hiddens").val(roleid);
            $("#userid-hiddens").val(userid);
            $('#wjyr').dialog({
                title: '新增',
                width: 600,
                height: 600,
                href: '<%=request.getContextPath() %>/wjyiiindex/comeToPowerTree',
                modal: true  ,
                buttons:[{
                    text:'保存',
                    handler:function(){
                        addquanxian(roleid);
                        $('#wjyr').window('close');
                    }
                },
                    {
                        text:'关闭',
                        handler:function(){
                            $('#wjyr').window('close');
                        }
                    }]
            });
    }
</script>



</body>
</html>
