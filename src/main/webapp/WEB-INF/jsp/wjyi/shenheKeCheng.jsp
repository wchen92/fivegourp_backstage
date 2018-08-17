<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>课程审核</h1>

<table id="wjyshenhekecheng"></table>

<script type="text/javascript">
    $(function(){
        shenhekechengsearch();
    })

    function shenhekechengsearch(){
        $("#wjyshenhekecheng").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/querywjyKeCheng',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            toolbar: [{
                text:'审核课程',
                iconCls: 'icon-edit',
                handler: function(){
                    var arr = $("#wjyshenhekecheng").datagrid('getChecked');
                    var idlength = arr.length;
                    if(idlength==0){
                        alert("请选择要审核的数据");
                        return false;
                    }
                    var shu="";
                    for(var i=0;i<arr.length;i++){
                        if(i==0){
                            shu+=arr[i].kechengid;
                        }else{
                            shu+=","+arr[i].kechengid;
                        }
                    }
                    if(confirm("确定审核"+idlength+"确认吗")){
                        $.ajax({
                            url:'<%=request.getContextPath() %>/wjyi/piliangQuerenKecheng?kechengid='+shu,
                            type:"post",
                            dataType:"text",
                            success:function(data){
                                if(data==1){
                                    alert("审核成功")
                                    $("#wjyshenhekecheng").datagrid('load');
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
                {field:'kechengid',title:'课程编号',width:100},
                {field:'kechengname',title:'课程名称',width:100},
                {field:'kechengprice',title:'课程价格',width:100},
                {field:'keshishu',title:'课程数',width:100},
                {field:'kechengphoto',title:'课程图片',width:100,
                    formatter: function(value,row,index){
                        return "<img width='50' height='50'  src='"+row.kechengphoto+"' / >";
                    }
                },
                {field:'kechengjieshao',title:'课程介绍',width:100},
                {field:'huiyuanstatus',title:'会员状态',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "会员";
                        }else if(value == 2){
                            return "非会员";
                        }
                    }
                },
                {field:'shenhestatus',title:'审核状态',width:100,
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
