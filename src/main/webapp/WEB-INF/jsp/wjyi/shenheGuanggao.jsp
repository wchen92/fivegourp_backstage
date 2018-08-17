<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>广告位审核</h1>

<table id="wjyShenheGuanggao"></table>

<script type="text/javascript">
    $(function(){
        shenheguangsearch();
    })

    function shenheguangsearch(){
        $("#wjyShenheGuanggao").datagrid({
            url:'<%=request.getContextPath()%>/wjyi/querywjyGuang',
            singleSelect:true,
            checkOnSelect:false,
            selectOnCheck:false,
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,5,8,10],
            toolbar: [{
                text:'审核广告位',
                iconCls: 'icon-edit',
                handler: function(){
                    var arr = $("#wjyShenheGuanggao").datagrid('getChecked');
                    var idlength = arr.length;
                    if(idlength==0){
                        alert("请选择要审核的数据");
                        return false;
                    }
                    var shu="";
                    for(var i=0;i<arr.length;i++){
                        if(i==0){
                            shu+=arr[i].guanggaoid;
                        }else{
                            shu+=","+arr[i].guanggaoid;
                        }
                    }
                    if(confirm("确定审核"+idlength+"条数据吗")){
                        $.ajax({
                            url:'<%=request.getContextPath() %>/wjyi/piliangQuerenGuanggao?guanggaoid='+shu,
                            type:"post",
                            dataType:"text",
                            success:function(data){
                                if(data==1){
                                    alert("审核成功")
                                    $("#wjyShenheGuanggao").datagrid('load');
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
                {field:'guanggaoid',title:'广告编号',width:100},
                {field:'guanggaoname',title:'广告名称',width:100},
                {field:'money',title:'广告价格',width:100},
                {field:'guanggaodate',title:'创建广告时间',width:100},
                {field:'zhanshistatus',title:'广告展示状态',width:100,
                    formatter:function(value,row,index){
                        if(value == 1){
                            return "已审核";
                        }else if(value == 2){
                            return "未审核";
                        }
                    }
                },
                {field:'chuliren',title:'广告处理人',width:100},
                {field:'guanggaophoto',title:'图片展示',width:100,
                    formatter: function(value,row,index){
                        return "<img width='50' height='50'  src='"+row.guanggaophoto+"' / >";
                    }
                },

            ]]
        })
    }
</script>
</body>
</html>
