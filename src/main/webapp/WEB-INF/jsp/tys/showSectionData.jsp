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
<div id="tysxz2"></div>

<div id="tysxg2"></div>

<table id="tysgrid2"></table>

<script type="text/javascript">
    function searchss2(){
        $("#tysgrid2").datagrid({
            url:"<%=request.getContextPath()%>/tysheng/queryzjlist",
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,//开启分页
            pageNumber:0,//初始化页码
            pageSize:3,//每页条数
            pageList:[3,5,8],//每页条数的下拉选项
            queryParams: {

            },
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#tysxz2').dialog({
                        title: '新增',
                        width: 500,
                        height: 500,
                        closed: false,
                        cache: false,
                        href: '<%=request.getContextPath()%>/tyshengIndex/savesectionjsp',
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/tysheng/savesection",
                                    data:$("#tys_002").serialize(),
                                    type:"post",
                                    dataType:"text",
                                    async:false,
                                    success:function(msg){
                                        alert("新增成功");
                                        $("#tysxz2").dialog("close")
                                        $("#tysgrid2").datagrid("reload")

                                    }
                                })
                            }
                        }]
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    var  ff = $("#tysgrid2").datagrid("getChecked")
                    var  gg = "";
                    for (var i = 0; i < ff.length; i++) {
                        gg+=","+"'"+ff[i]['zhangjieid']+"'";
                    }
                    var  ss=gg.substring(1)
                    $.ajax({
                        url:"<%=request.getContextPath()%>/tysheng/deletesection",
                        type:"post",
                        data:{"ss":ss},
                        dataType:"text",
                        async:false,
                        success:function(){
                            alert("删除成功");
                            $("#tysgrid2").datagrid("reload")
                        }
                    })
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    var  ffs = $("#tysgrid2").datagrid("getChecked")
                    alert(ffs[0].zhangjieid)
                    $('#tysxg2').dialog({
                        title: '修改',
                        width: 400,
                        height: 400,
                        closed: false,
                        cache: false,
                        href: '<%=request.getContextPath()%>/tyshengIndex/querysectionbyid?zhangjieid='+ffs[0].zhangjieid,
                        modal: true,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $.ajax({
                                    url:"<%=request.getContextPath()%>/tysheng/updatesection",
                                    data:$("#tys_002").serialize(),
                                    type:"post",
                                    dataType:"text",
                                    async:false,
                                    success:function(){
                                        alert("修改成功");
                                        $("#tysxg2").dialog("close")
                                        $("#tysgrid2").datagrid("reload")

                                    }
                                })
                            }
                        }]
                    });


                }
            }],
            columns:[[
                {field:'userchek',checkbox:true},
                {field:'zhangjieid',title:'编号',width:100},
                {field:'zhangjiename',title:'章节名称',width:100},

                {field:'shipin',title:'视频',width:100},
                {field:'shoufeistatus',title:'收费状态',width:100,
                    formatter: function(value,row,index){
                        if(row.shoufeistatus==1){
                            return  "免费"
                        }
                        if(row.shoufeistatus==2){
                            return  "收费"
                        }


                    }



                },

            ]]
        });
    }
    $(function(){
        searchss2();
    })
</script>
</body>
</html>
