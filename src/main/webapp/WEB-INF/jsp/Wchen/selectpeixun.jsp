<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/27
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="wchenpeixuntable"></table>
<div id="updatepeixun"></div>
<script>
    $('#wchenpeixuntable').datagrid({
        url:'<%=request.getContextPath()%>/wchencontroller/selectpeixun',
        singleSelect:true,
        checkOnSelect:false,
        selectOnCheck:false,
        pagination:true,//开启分页
        pageNumber:1,//初始化页码
        pageSize:3,//每页条数
        pageList:[3,6,8],//每页条数的下拉选项
        columns:[[
            {field:'name',title:'姓名',width:100},
            {field:'sex',title:'性别',width:100,
                formatter:function(value,row,index){
                    if(value == 1){
                        return "男";
                    }else if(value == 2){
                        return "女";
                    }
                }
            },
            {field:'shouji',title:'手机号',width:100},
            {field:'qqhao',title:'QQ号码',width:100},
            {field:'weixinhao',title:'微信号',width:100},
            {field:'xueli',title:'最高学历',width:100,
                formatter:function(value,row,index){
                    if(value == 1){
                        return "初中";
                    }
                    if(value == 2){
                        return "高中";
                    }
                    if(value == 3){
                        return "大学";
                    }
                    if(value == 4){
                        return "研究生";
                    }
                }},
            {field:'biyeshijian',title:'毕业时间',width:100},
            {field:'xinzi',title:'当前薪资',width:100},
            {field:'zhuangtai',title:'当前状态',width:100,
                formatter:function(value,row,index){
                    if(value == 1){
                        return "在读";
                    }
                    if(value == 2){
                        return "在实习";
                    }
                    if(value == 3){
                        return "刚毕业";
                    }
                    if(value == 4){
                        return "一年以内工作经验";
                    }
                    if(value == 5){
                        return "两年以内工作经验";
                    }
                    if(value == 6){
                        return "三年以内工作经验";
                    }
                    if(value == 7){
                        return "其他";
                    }
                }
            },
            {field:'caozuo',title:'操作',width:100,
                formatter:function(value,row,index){
                    return "<a  onclick ='oklianxi(\""+row.id+"\")'>完成</a>";
                }
            }
        ]]
    });

    function oklianxi(id){
        $('#updatepeixun').dialog({
            title: "结果填写",
            width: 400,
            height: 200,
            href: "<%=request.getContextPath()%>/wchenindexcontroller/updatepeixun",
            modal: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    var jieguo = $("#jieguo").val();
                    $.ajax({
                        url:"<%=request.getContextPath()%>/wchencontroller/peixunok",
                        type:"post",
                        data:{id:id,jieguo:jieguo},
                        datatype:"json",
                        success:function(reslut){
                            if(reslut==1){
                                alert("操作成功")
                                $("#wchenpeixuntable").datagrid('load');
                                $("#updatepeixun").dialog('close');
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
                    $("#updatepeixun").dialog('close');
                }
            }]
        });
    }
</script>
</body>
</html>
