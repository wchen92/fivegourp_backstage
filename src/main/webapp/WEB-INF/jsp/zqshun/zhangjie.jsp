<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>章节管理页面</title>
</head>
<body>

<table id="dgzhangjie"></table>
<div id="divzhangjie"></div>


<script type="text/javascript">

    $(function(){
        $('#dgzhangjie').datagrid({
            url:'<%=request.getContextPath() %>/zqshun/queryzhangjie',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            fitColumns:true,//自适应父容器
            pagination:true,//开启分页
            pageNumber:1,//初始化页码
            pageSize:3,//每页条数
            pageList:[3,5,8,12],//每页条数的下拉选项
            toolbar: [{
                iconCls: 'icon-remove',
                handler: function(){
                    var arr = $("#dgzhangjie").datagrid('getChecked');
                    console.info(arr);
                    var id ="";
                    for(var i=0; i<arr.length;i++){
                        id+=","+arr[i].zhangjieid;
                    }
                    ids=id.substr(1);

                    if(arr.length>0){
                        var zjie="确定要删除"+arr.length+"条数据";
                        if(confirm(zjie)){
                            $.ajax({
                                url:"<%=request.getContextPath()%>/zqshun/deletezhangcheng",
                                type:"post",
                                data:{ids:ids},
                                dataType:"json",
                                success:function(result){
                                    if(result==1){
                                        alert("删除成功");
                                        $('#dgzhangjie').datagrid('reload');
                                    }
                                },
                                error:function(){
                                    alert("删除失败");
                                }
                            });
                        }
                    }
                }
            }],
            columns:[[
                //field :对应实体类中的属性名（尽量），必须保证唯一性
                {field:'che',width:100,checkbox:true},
                {field:'zhangjieid',title:'章节号',width:100},
                {field:'zhangjiename',title:'章节名称',width:100},
                {field:'shipin',title:'视频',width:100,
                    formatter: function(value,row,index){
                    return '<embed width="200" height="100" loop="true" autostart="true"  src="'+row.shipin+'">'
                    }
                },
                {field:'shoufeistatus',title:'收费状态',width:100,
                    formatter: function(value,row,index){
                            if(row.shoufeistatus==1){
                                return "收费";
                            }else if(row.shoufeistatus==2){
                                return "免费";
                            }
                    }
                },
                {field:'act',title:'操作',width:100,
                    formatter: function(value,row,index){
                        return '<a href="#" onclick="zhangjieupdate(\'' +row.zhangjieid+ '\')">修改</a>';
                    }
                },
            ]]
        });
    })

   function zhangjieupdate(zjid){
        BootstrapDialog.show({
            type : BootstrapDialog.TYPE_SUCCESS,
            title : '修改 ',
            height:600,
            message : $("<div></div>").load("<%=request.getContextPath() %>/zqshunindex/zhangjieupdate?zjid="+zjid),
            buttons : [ {// 设置关闭按钮
                label : '关闭',
                action : function(dialogItself) {
                    dialogItself.close();
                },
            },{
                label : '保存',
                action : function(dialogItself) {
                    $.ajax({
                        url : "<%=request.getContextPath()%>/zqshun/updatezhangjie",
                        type : "post",
                        dataType : "json",
                        data:$("#zhangjieformaupdate").serialize(),
                        success : function() {
                            alert("修改成功")
                            dialogItself.close();
                        },
                        error:function(){
                            alert("系统错误")
                        }
                    });
                }
            }
            ]
        });
    }



</script>


</body>
</html>
