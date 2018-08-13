<%--
  Created by IntelliJ IDEA.
  User: 谭永生
  Date: 2018/8/9
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="p" class="easyui-panel" title="搜索窗"   align="center" data-options="height:'100px', collapsible:true,collapsed:true">
    名字：<input class="easyui-textbox" id="docname" data-options="iconCls:'icon-key'" style="width:200px">
    <a id="btn" href="javascript:searchss()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
</div>
<div id="tysxz"></div>

<div id="tysxg"></div>

<table id="tysgrid"></table>

<script type="text/javascript">
    function searchss(){
        $("#tysgrid").datagrid({
            url:"<%=request.getContextPath()%>/tysheng/queryjslist2",
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,//开启分页
            pageNumber:1,//初始化页码
            pageSize:3,//每页条数
            pageList:[3,5,8],//每页条数的下拉选项
            queryParams: {

            },
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#tysxz').dialog({
                        title: '新增',
                        width: 500,
                        height: 500,
                        closed: false,
                        cache: false,
                        href: '<%=request.getContextPath()%>/tyshengIndex/saveteacherjsp',
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/tysheng/saveteacher",
                                    data:$("#tys_001").serialize(),
                                    type:"post",
                                    dataType:"text",
                                    async:false,
                                    success:function(msg){
                                        alert("新增成功");
                                        $("#tysxz").dialog("close")
                                        $("#tysgrid").datagrid("reload")

                                    }
                                })
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var  ff = $("#tysgrid").datagrid("getChecked")
                    var  gg = "";
                    for (var i = 0; i < ff.length; i++) {
                        gg+=","+"'"+ff[i]['jiangshiid']+"'";
                    }
                    var  ss=gg.substring(1)
                    $.ajax({
                        url:"<%=request.getContextPath()%>/tysheng/deleteteacher",
                        type:"post",
                        data:{"ss":ss},
                        dataType:"text",
                        async:false,
                        success:function(){
                            alert("删除成功");
                            $("#tysgrid").datagrid("reload")
                        }
                    })
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    var  ffs = $("#tysgrid").datagrid("getChecked")
                    alert(ffs[0].jiangshiid)
                    $('#tysxg').dialog({
                        title: '修改',
                        width: 400,
                        height: 400,
                        closed: false,
                        cache: false,
                        href: '<%=request.getContextPath()%>/tyshengIndex/queryteacherbyid?jiangshiid='+ffs[0].jiangshiid,
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/tysheng/updateteacher",
                                    data:$("#tys_001").serialize(),
                                    type:"post",
                                    dataType:"text",
                                    async:false,
                                    success:function(){
                                        alert("修改成功");
                                        $("#tysxg").dialog("close")
                                        $("#tysgrid").datagrid("reload")

                                    }
                                })
                            }
                        }]
                    });


                }
            }],
            columns:[[
                {field:'userchek',checkbox:true},
                {field:'jiangshiid',title:'编号',width:100},
                {field:'jiangshiname',title:'讲师名称 ',width:100},

                {field:'jiangshishenfen',title:'讲师身份',width:100},
                {field:'jiangshijieshao',title:'讲师简介',width:100},

            ]]
        });
    }
    $(function(){
        searchss();
    })
</script>
</body>
</html>
