<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/9 0009
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班型管理</title>


</head>
<body>

<table id="dgbanxing"></table>
<div id="divbanxing"></div>


<script type="text/javascript">

    $(function(){
        $('#dgbanxing').datagrid({
            url:'<%=request.getContextPath() %>/zqshun/querybanxing',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            fitColumns:true,//自适应父容器
            pagination:true,//开启分页
            pageNumber:1,//初始化页码
            pageSize:3,//每页条数
            pageList:[3,5,8,12],//每页条数的下拉选项
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){

                    $('#divbanxing').dialog({
                        title: '新增',
                        width: 400,
                        height: 400,
                        closed: false,
                        cache: false,
                        href: '<%=request.getContextPath()%>/zqshunindex/banxingadd',
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/zqshun/addbanxing",
                                    data:$("#banxingadd").serialize(),
                                    type:"post",
                                    dataType:"text",
                                    async:false,
                                    success:function(){
                                        alert("新增成功");
                                        $("#divbanxing").dialog("close");
                                        $("#dgbanxing").datagrid("reload")

                                    }
                                })
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var arr = $("#dgbanxing").datagrid('getChecked');
                    console.info(arr);
                    var	id="";
                    for(var i=0; i<arr.length;i++){
                        id+=","+arr[i].banxingid;
                    }
                    ids=id.substr(1);
                    if(arr.length>0){
                        var ss="确定要删除"+arr.length+"条数据";
                        if(confirm(ss)){

                            $.ajax({
                                url:"<%=request.getContextPath()%>/zqshun/deletebanxing",
                                type:"post",
                                data:{ids:ids},
                                dataType:"json",
                                success:function(result){
                                    if(result==1){
                                        alert("批删成功");
                                        $('#dgbanxing').datagrid('reload');
                                    }
                                },
                                error:function(){
                                    alert("批量删除失败");
                                }
                            });
                        }
                    }
                }
            }],
            columns:[[
                //field :对应实体类中的属性名（尽量），必须保证唯一性
                {field:'che',width:100,checkbox:true},
                {field:'banxingid',title:'班型号',width:100},
                {field:'banxingname',title:'班型名称',width:100},

                {field:'act',title:'操作',width:100,
                    formatter: function(value,row,index){
                        //return "<a href=\"javascript:void(0)\" onclick=\"banxingupdate('+row.banxingid+')\" >修改</a>";
                        return '<a href="#" onclick="banxingupdate(\'' +row.banxingid+ '\')">修改</a>';

                    }
                },
            ]]
        });
    })

    //编辑
    function banxingupdate(zid){
        $('#divbanxing').dialog({
            title: 'My Dialog',
            width: 300,
            height: 200,
            closed: false,
            cache: false,
            href: "<%=request.getContextPath() %>/zqshunindex/selectbanxing?zid="+zid,
            modal: false,
            buttons:[{
                text:'保存',
                handler:function(){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/zqshun/updatebanxing",
                        type:"post",
                        data:$("#banxingupdate").serialize(),
                        dataType:"json",
                        success:function(result){
                            if(result == 1){
                                alert("修改成功")
                                $("#divbanxing").window("close");
                                $('#dgbanxing').datagrid('reload');
                            }
                        }
                    });
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#divbanxing").window("close");
                    $('#dgbanxing').datagrid('reload');
                }
            }]

        });
    }


</script>


</body>
</html>
