<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/10 0010
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
</head>
<body>

<table id="dgkecheng"></table>
<div id="divkecheng"></div>


<script type="text/javascript">

    $(function(){
        $('#dgkecheng').datagrid({
            url:'<%=request.getContextPath() %>/zqshun/querykecheng',
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
                    $('#divkecheng').dialog({
                        title: '新增',
                        width: 400,
                        height: 500,
                        closed: false,
                        cache: false,
                        href: '<%=request.getContextPath()%>/zqshunindex/kechengadd',
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/zqshun/addkecheng",
                                    data:$("#kechengadd").serialize(),
                                    type:"post",
                                    dataType:"text",
                                    async:false,
                                    success:function(){
                                        alert("新增成功");
                                        $("#divkecheng").dialog("close");
                                        $("#dgkecheng").datagrid("reload")
                                    }
                                })
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var arr = $("#dgkecheng").datagrid('getChecked');
                    console.info(arr);
                    var	id="";
                    for(var i=0; i<arr.length;i++){
                        id+=","+arr[i].kechengid;
                    }
                    ids=id.substr(1);

                    if(arr.length>0){
                        var ss="确定要删除"+arr.length+"条数据";
                        if(confirm(ss)){

                            $.ajax({
                                url:"<%=request.getContextPath()%>/zqshun/deletekecheng",
                                type:"post",
                                data:{ids:ids},
                                dataType:"json",
                                success:function(result){
                                    if(result==1){
                                        alert("批删成功");
                                        $('#dgkecheng').datagrid('reload');
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
                {field:'kechengid',title:'课程号',width:100},
                {field:'kechengname',title:'课程名称',width:100},
                {field:'kechengprice',title:'课程价格',width:100},
                {field:'keshishu',title:'课程数',width:100},
                {field:'kechengphoto',title:'课程图片',width:100,
                    formatter: function(value,row,index){
                        return "<img width='100' height='100'  src='"+row.kechengphoto+"'/>";
                    }
                },
                {field:'kechengjieshao',title:'课程介绍',width:100},
                {field:'huiyuanstatus',title:'会员状态',width:100,
                    formatter: function(value,row,index) {
                        if(row.huiyuanstatus==1){
                            return "会员";
                        }else if(row.huiyuanstatus==2){
                            return "非会员";
                        }
                    },
                },
                {field:'shenhestatus',title:'审核状态',width:100,
                    formatter: function(value,row,index) {
                        if(row.shenhestatus==1){
                            return "已审核";
                        }else if(row.shenhestatus==2){
                            return "未审核";
                        }
                    },
                },
                {field:'act',title:'操作',width:100,
                    formatter: function(value,row,index){
                        //return "<a href=\"javascript:void(0)\" onclick=\"banxingupdate('+row.banxingid+')\" >修改</a>";
                        return '<a href="#" onclick="kechengupdate(\'' +row.kechengid+ '\')">修改</a>';
                    }
                },
            ]]
        });
    })

    //编辑
    function kechengupdate(sid){
        $('#divkecheng').dialog({
            title: 'My Dialog',
            width: 400,
            height: 500,
            closed: false,
            cache: false,
            href: "<%=request.getContextPath() %>/zqshunindex/selectkecheng?sid="+sid,
            modal: false,
            buttons:[{
                text:'保存',
                handler:function(){
                    $.ajax({
                        url:"<%=request.getContextPath()%>/zqshun/updatekecheng",
                        type:"post",
                        data:$("#kechengupdate").serialize(),
                        dataType:"json",
                        success:function(result){
                            if(result == 1){
                                alert("修改成功")
                                $("#divkecheng").window("close");
                                $('#dgkecheng').datagrid('reload');
                            }
                        }
                    });
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#divkecheng").window("close");
                    $('#dgkecheng').datagrid('reload');
                }
            }]

        });
    }


</script>

</body>
</html>
