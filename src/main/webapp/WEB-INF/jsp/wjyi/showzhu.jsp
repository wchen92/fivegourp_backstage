<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/9
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/EasyUI/themes/default/easyui.css" type="text/css"/>

    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/EasyUI/themes/icon.css" type="text/css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css">
    <link
            href="<%=request.getContextPath()%>/js/link/bootstrap/bootstrap.min.css"
            rel="stylesheet">
    <link
            href="<%=request.getContextPath()%>/js/link/bootstrap/bootstrap.min.css"
            rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/link/bootstrap-dialog/bootstrap-dialog.min.css" >
    <!-- bootstrap-fileinput -->
    <link
            rel="stylesheet" href="<%=request.getContextPath()%>/js/link/bootstrap-fileinput/fileinput.min.css" />
</head>
<body>

        <div id="wjydialog"></div>

<!-- 引入JQuery -->
<script type="text/javascript"
        src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>

<!-- 引入EasyUI -->
<script type="text/javascript"
        src="<%=request.getContextPath()%>/EasyUI/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
        src="<%=request.getContextPath()%>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/util-js.js"></script>
<script src="https://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://code.highcharts.com/highcharts-3d.js"></script>
<script src="http://code.highcharts.com/highcharts-more.js"></script>


<script
        src="<%=request.getContextPath()%>/js/link/bootstrap/bootstrap.min.js"></script>
<script  src="<%=request.getContextPath()%>/js/link/bootstrap-dialog/bootstrap-dialog.js"></script>
<script
        type="text/javascript" src="<%=request.getContextPath()%>/js/link/bootstrap-fileinput/fileinput.min.js"></script>
<script
        type="text/javascript" src="<%=request.getContextPath()%>/js/link/bootstrap-fileinput/zh.js"></script>
<style>a{TEXT-DECORATION:none}</style>

<div id="wjycc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'蚂蚁课堂',split:true" style="height:200px;">
        <center><h1>蚂蚁课堂后台管理系统</h1></center>

        <a  href="javascript:searchwjyrenwu()" class="easyui-linkbutton" size="large" data-options="iconCls:'icon-search'" style="width: 200px;height: 30px">未完成任务(<span id="weiwanchengshu"></span>)</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a  href="javascript:searchzhipai()" class="easyui-linkbutton" size="large"  data-options="iconCls:'icon-search'" style="width: 200px;height: 30px">指派任务查看(<span id="zhipaishu"></span>)</a>

    </div>
    <div data-options="region:'west',title:'权限',split:true" style="width:200px;"   >
        <ul id="wjytree"></ul>
    </div>
    <div data-options="region:'center',title:'展示'" >
        <div id="wjytt" class="easyui-tabs" data-options="fit:true" >
            <div title="首页" >
                tab1
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        weiwanchengshusearch();
        zhipaishusearch()
    })
    $(function(){
        $("#wjytree").tree({
            url:'<%=request.getContextPath()%>/wjyi/queryTree',
            parentField:'pid',
            onClick: function(node){
                if(node.url != null && node.url != ''){
                    addtabs(node.text,node.url);
                }
            }
        })
    })

    function addtabs(titleStr,urlStr){
        if($("#wjytt").tabs('exists',titleStr)){
            $("#wjytt").tabs('select',titleStr);
        }else{
            $("#wjytt").tabs('add',{
                title:titleStr,
                href:"<%=request.getContextPath() %>/"+urlStr,
                closable:true
            })
        }
    }

    function searchwjyrenwu(){
        $('#wjydialog').dialog({
            title: "未完成任务查看",
            width: 1000,
            height: 400,
            href: "<%=request.getContextPath()%>/wjyiiindex/comeToRenwu",
            modal: true,
        });
    }

    function searchzhipai(){
        $('#wjydialog').dialog({
            title: "指派任务查看",
            width: 1000,
            height: 400,
            href: "<%=request.getContextPath()%>/wjyiiindex/comeToZhipai",
            modal: true,
        });
    }

    function weiwanchengshusearch() {
        $.ajax({
            url:"<%=request.getContextPath()%>/wjyi/queryWeiwanchengShu",
            type:"post",
            datatype:"json",
            success:function(reslut){
                    $("#weiwanchengshu").html(reslut);
            },
        });
    }

    function zhipaishusearch() {
        $.ajax({
            url:"<%=request.getContextPath()%>/wjyi/queryZhipaiShu",
            type:"post",
            datatype:"json",
            success:function(reslut){
                $("#zhipaishu").html(reslut);
            },
        });
    }
</script>
</body>
</html>
