<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/10 0010
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>课程管理回显页面</title>
    <script type="text/javascript" src="/uploadify/jquery.uploadify.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/uploadify/uploadify.css" />
</head>
<body>

<center>
    <form id="kechengupdate">
        <input type="hidden" name="kechengid" value="${keCheng.kechengid}">
        课程名称:<input name="kechengname" value="${keCheng.kechengname}" class="easyui-textbox" style="width:200px"><br><br>
        课程价格:<input name="kechengprice" value="${keCheng.kechengprice}" class="easyui-textbox" style="width:200px"><br><br>
        课程数:<input name="keshishu" value="${keCheng.keshishu}" class="easyui-textbox" style="width:200px"><br><br>
        课程介绍:<textarea name="kechengjieshao">${keCheng.kechengjieshao}</textarea><br><br>
        会员状态:<input type="radio" name="huiyuanstatus" ${keCheng.huiyuanstatus==1 ? 'checked' : '' } value="1">会员
        <input type="radio" name="huiyuanstatus" value="2" ${keCheng.huiyuanstatus==2 ? 'checked' : '' }  >非会员<br><br>
       <input type="hidden" name="shenhestatus" value="2">
        课程图片<input type="file" id="imgFileBTN" >
        <input type="text" id="hidden-photos" name="kechengphoto" value="${keCheng.kechengphoto}">
        <div id="showImgDiv" style="width: 100px;height: 100px;border-style:solid;border-width:1px; border-color:black;">
            <img src="${keCheng.kechengphoto}" id="showImgs" style="width: 100px;height: 100px;">
        </div>
        <div id="showBars"></div>


    </form>

</center>
<script>
    //图片上传
    $(function(){
        $("#imgFileBTN").uploadify({
            //前台请求后台的url 不可忽略的参数
            'uploader' :"<%=request.getContextPath()%>/zqshun/uploadImg",
            //插件自带 不可忽略的参数
            'swf' : '<%=request.getContextPath()%>/uploadify/uploadify.swf',
            //撤销按钮的图片路径
            'cancelImg' : '<%=request.getContextPath() %>/uploadify/uploadify-cancel.png',
            //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
            'auto' : true,
            //可以同时选择多个文件 默认为true 不可忽略
            'multi' : false,
            //给上传按钮设置文字
            'buttonText' : '上传图片',
            //上传后队列是否消失
            'removeCompleted' : true,
            'removeTimeout' : 1,
            //上传文件的个数
            'uploadLimit' : 2,
            'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
            'fileSizeLimit' : '2MB',
            //给div的进度条加背景 不可忽略
            'queueID' : 'showBarss',
            //controller层方法中接收文件的参数名
            'fileObjName' : 'imgs',
            //上传成功后的回调函数   data 是上传方法返回的数据
            'onUploadSuccess' : function(file, data, response) {
                $("#showImgs").attr("src",data); //oss需要把根目录删了（返回一个网址），只保留data
                $("#hidden-photos").val(data);  //同上
            }
        });
    })

</script>


</body>
</html>
