<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><ul id="querypowertreelist"></ul></div>

<script type="text/javascript">
    $(function(){
        querypowertree();
    })

    function querypowertree(){
        var userid= $("#userid-hiddens").val();
        var roleid= $("#roleid-hiddens").val();
        $('#querypowertreelist').tree({
            url:'<%=request.getContextPath()%>/wjyi/queryRoleAndPower?roleid='+roleid + "&userid=" + userid ,
            parentField:'pid',
            checkbox:true,

        });
    }
    function addquanxian(roleids){
        var quanxianidarr =$('#querypowertreelist').tree('getChecked');
        var quanxian="";
        for (var i = 0; i < quanxianidarr.length; i++) {
            quanxian+= "," + quanxianidarr[i].id;
        }
        quanxianids=quanxian.substr(1)
        $.ajax({
            url:"<%=request.getContextPath()%>/wjyi/addPowerAndRoleid",
            type:"post",
            data:{"quanids":quanxianids,"roleids":roleids},
            success:function(result){
                if(result==1){
                    alert("添加成功")
                }
            }
        })
    }
</script>
</body>
</html>
