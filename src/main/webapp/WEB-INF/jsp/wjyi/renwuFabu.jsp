<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/14
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="redivid"></div>
<form id="fabuformid">
    <center>
    <table >
        <tr>
            <td> 任务名称：<br/><br/></td>
            <td> <input type="text" name="renwuname" class="easyui-textbox" style="width:200px"><br/><br/></td>
        </tr>
        <tr>
            <td>  任务内容：<br/><br/></td>
            <td> <input type="text" name="renwuneirong" class="easyui-textbox" style="width:200px"><br/><br/></td>
        </tr>
        <tr>
            <td>  指派人：<br/><br/></td>
            <td><input id="wjy_sh_id" name="zpr" > <br/><br/>
               <%-- <select id="wjyFabuCombo" name = "chulirenid" class="easyui-combotree" style="width:200px;"  data-options="required:true"></select>--%>
            </td>
        </tr>
        <tr>
            <td colspan="2"><center> <input type="button" value="发布" onclick="faburenwu()"  class="easyui-linkbutton" style="width:200px"></center></td>
        </tr>
    </table>
    </center>


    <script type="text/javascript">
        function faburenwu(){
            $.ajax({
                url:"<%=request.getContextPath()%>/wjyi/fabuRenwu",
                type:"post",
                data:$("#fabuformid").serialize(),
                datatype:"json",
                success:function(reslut){
                    if(reslut==1){
                        alert("新增成功")
                        location.href="<%=request.getContextPath()%>/wjyiiindex/comezhu";
                    }
                },
                error: function(){
                    alert("新增失败");
                }
            });
        }

        $(function(){
            $("#wjy_sh_id").combobox({
                url:'<%=request.getContextPath()%>/wjyi/queryComboUser',
                valueField:'userid',
                textField:'text',
            });
        });

    </script>
</form>
</body>
</html>
