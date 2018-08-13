<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="<%=request.getContextPath()%>/EasyUI/themes/default/easyui.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/icon.css" type="text/css"/>
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
	background-image: url(<%=request.getContextPath()%>/images/timg.jpg);
	background-size:100%;
} 
.mybtn14_3 a  
{  
   color:#fff;  
}  
</style>
</head>
<body>
     <div class="mybtn14_3">  
</div>  
     <div id="cc" class="easyui-layout"  data-options="fit:true">   
	    <div data-options="region:'center'" style="background-color:rgba(0, 0, 0, 0.4)">
	       <center>
			    <form id="form_loid">
			         <h2 style="color:white">用户登录</h2>
			         <h3 style="color:white">The User login</h3>
		     <font size="4" color="white">账户:</font><input name="text" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入姓名'" style="width:200px;height:30px">  <br> <br>
			  
			   <font size="4" color="white">密码:</font><input name="password" class="easyui-textbox" data-options="iconCls:'icon-lock',type:'password',prompt:'请输入密码'" style="width:200px;height:30px"><br>
			    <span id="spid"></span><br>
			    <a  href="javascript:querylogin()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" style="width: 250px;height: 30px">登录</a>
			 <%--   <h5 style="color:white">没有账号?<a href=javascript:registe()>立即免费注册?</a></h5>--%>
			    
			    
			   </form>
		  </center>
	    </div>   
	</div>  

<script type="text/javascript"  src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
 
 <script type="text/javascript">
 	function registe(){
 		
 		location.href="<%=request.getContextPath()%>/registe.jsp"
 	}
 
    function querylogin(){
    	 $.ajax({
             url:"<%=request.getContextPath()%>/liushun/login",
             type:"post",
             data:$("#form_loid").serialize(),
             dataType:"json",
             success:function(msg) {
                 /*   1:用户名不存在 3：密码错误 2：登录成功*/
                 if (msg == '0') {
                     alert("用户名不存在或者用户未审核通过")
                 }
                 if (msg == '3') {
                     alert("密码错误")
                 }
                 if (msg == '2') {

                     location.href = "<%=request.getContextPath()%>/linshuiindex/fivelogin"
                 }
             },
             error:function(){
               alert("请求失败");
             }
             
           });
                
    }
 
 
 </script>
 
     
</body>
</html>