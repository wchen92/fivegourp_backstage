<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/9
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <ul id="queryRolestree"></ul>
</div>

<script type="text/javascript">
    $(function(){
        queryRolestree();
    })

    function queryRolestree(){
        var userid= $("#userid-hiddens").val();
        $('#queryRolestree').tree({
            url:'<%=request.getContextPath()%>/wjyi/queryrole?userid='+userid,
            parentField:'pid',
            checkbox:true,
            success:function(result){
            },
        });
    }


    function addRole(userid){
        var userids="";
        var roleidarr =$('#queryRolestree').tree('getChecked');
        var role= "" ;
        for (var i = 0; i < roleidarr.length; i++) {
            role+= "," + roleidarr[i].roleid;
        }
        roleids=role.substr(1);
        $.ajax({
            url:"<%=request.getContextPath()%>/wjyi/addRoleAndUserid",
            type:"post",
            data:{"userids":userid,"roleids":roleids},
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
