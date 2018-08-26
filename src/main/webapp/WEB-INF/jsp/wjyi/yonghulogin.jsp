<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/18
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/default/easyui.css" type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/icon.css" type="text/css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css" type="text/css"/>
    <style type="text/css">
        .col-center-block {
            float: none;
            display: block;
            margin-top:130px;
            margin-left: auto;
            margin-right: auto;
        }
        body{
            background-color:#eee;
            background-image: url(<%=request.getContextPath()%>);
            background-size:100%;
        }
        .mybtn14_3 a
        {
            color:#fff;
        }
    </style>
</head>
<body >

<div id="zhucedialog"></div>
    <img src="<%=request.getContextPath()%>/images/121.png" style="width: 1500px;height:300px">
    <div id="cc" class="easyui-layout"  data-options="fit:true" >
        <div data-options="region:'center'" style="background-color:rgba(0, 0, 0, 0.4)">
            <center>
                <form id="loginform">
                    <h2 style="color:white">用户登录</h2>
                    <h3 style="color:white">The User login</h3>
                    <font size="4" color="white">名 称：</font><input name="yonghuname" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入姓名'" style="width:200px;height:30px">  <br> <br>
                    <font size="4" color="white">密 码：</font><input name="yonghumima" class="easyui-textbox" data-options="iconCls:'icon-lock',type:'password',prompt:'请输入密码'" style="width:200px;height:30px"><br>
                    <span id="spid"></span><br>
                    <a  href="javascript:login()" class="easyui-linkbutton"  data-options="iconCls:'icon-redo'" style="width:200px;height:30px">登录</a><br/><br/>
                    <a  href="<%=request.getContextPath()%>/wjyiiindex/comeToZhuce" class="easyui-linkbutton"  data-options="iconCls:'icon-redo'" style="width:200px;height:30px">注册</a>
                </form>
            </center>
        </div>
    </div>
</form>

<!-- 引入JQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.min.js"></script>

<script type="text/javascript">
    function login(){
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/wjyi/login",
            data : $("#loginform").serialize(),
            async:false,
            success : function(msg) {
                if (msg == '0') {
                    alert("用户名错误")
                } else if (msg == '1') {
                    alert("密码错误")
                 } else if (msg == '2') {
                    location.href = "<%=request.getContextPath()%>/wchenindexcontroller/gotoshowall"
                }
            }
        })
    }

    function zhuce(){
        $('#zhucedialog').dialog({
            title: "注册",
            width: 800,
            height: 600,
            href: "<%=request.getContextPath()%>/wjyiiindex/comeToZhuce",
            modal: true,
        });
    }

</script>
</body>
</html>
