<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/10
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="addPowerformid">
    <table >
        <tr>
            <td> 权限名称：</td>
            <td> <input type="text" name="text" class="easyui-textbox" style="width:200px"></td>
        </tr>
        <tr>
            <td> 父级权限id：</td>
            <td>
                <select id="wjyCombo" name = "pid" class="easyui-combotree" style="width:200px;"  data-options="required:true"></select>
            </td>
        </tr>
    </table>
    <script type="text/javascript">
        $('#wjyCombo').combotree({
            url: '<%=request.getContextPath()%>/wjyi/queryComboPower',
            required: true,
            parentField:"pid",
            onSelect:function(node){
                var t = $('#wjyCombo').combotree('tree');	// 获取树对象
               if(t.tree('isLeaf', node.target)){
                    $.messager.show({
                        title:'我的消息',
                        msg:'请选择具体的部门',
                        timeout:1000,
                        showType:'slide'
                    });
                    $('#wjyCombo').combotree('clear');
                }
            },
        });
    </script>
</form>
</body>
</html>
