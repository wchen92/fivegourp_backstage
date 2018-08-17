<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="chapower" class="easyui-panel" title="条件查询" data-options="iconCls:'icon-save',collapsible:true">
    <center>
        <br>
        <input id="powerchaxun" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入权限名称'" style="width:300px"> <br><br>
        <a  href="javascript:powersearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 120px;height: 30px">查询</a><br><br>
    </center>
</div>

<div id="wjypow"></div>
<table id="wjypower"></table>

<script type="text/javascript">
    $(function(){
       powersearch();
    })

    function powersearch(){
        $("#wjypower").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/queryPower',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            queryParams: {
                text:$("#powerchaxun").val(),
            },
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#wjypow').dialog({
                        title: "新增信息",
                        width: 400,
                        height: 200,
                        href: "<%=request.getContextPath()%>/wjyiiindex/addPowerShow",
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/wjyi/addPower",
                                    type:"post",
                                    data:$("#addPowerformid").serialize(),
                                    datatype:"json",
                                    success:function(reslut){
                                        if(reslut==1){
                                            alert("新增成功")
                                            $("#wjypower").datagrid('load');
                                            $("#wjypow").dialog('close');
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
                                $("#wjypow").dialog('close');
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var arr = $("#wjypower").datagrid('getChecked');
                    var idlength = arr.length;
                    if(idlength==0){
                        alert("请选择要删除的数据");
                        return false;
                    }
                    var shu="";
                    for(var i=0;i<arr.length;i++){
                        if(i==0){
                            shu+=arr[i].id;
                        }else{
                            shu+=","+arr[i].id;
                        }
                    }
                    if(confirm("确定删除"+idlength+"条数据吗")){
                        $.ajax({
                            url:"<%=request.getContextPath() %>/wjyi/deletePower?id="+shu,
                            type:"post",
                            dataType:"text",
                            success:function(data){
                                if(data==1){
                                    alert("删除成功")
                                    $("#wjypower").datagrid('load');
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
                {field:'id',title:'权限编号',width:100},
                {field:'text',title:'权限名称',width:100},
                {field:'pid',title:'权限父级id',width:100},
                /*{field:'caozuo',title:'操作',width:100,
                    formatter:function(value,row,index){
                        return "<a class='icon-edit' onclick ='updatepower(\""+row.id+"\")'>&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                    }
                },*/
            ]]
        })
    }
    function updatepower(id){
        $('#wjypow').dialog({
            title: "修改",
            width: 400,
            height: 200,
            href: "<%=request.getContextPath()%>/wjyiiindex/queryPowerById?id="+id,
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/wjyi/updatePower",
                        type:"post",
                        data:$("#updatePowerformid").serialize(),
                        datatype:"json",
                        success:function(reslut){
                            if(reslut==1){
                                alert("修改成功")
                                $("#wjypower").datagrid('load');
                                $("#wjypow").dialog('close');
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
                    $("#wjypow").dialog('close');
                }
            }]
        });
    }


</script>

</body>
</html>
