<%--
  Created by IntelliJ IDEA.
  User: 谭永生
  Date: 2018/8/11
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>

<head>
    <title>Title</title>
</head>
<body>

<form id="tys_002">


    <input type="hidden"  name="zhangjieid"   value="${zj.zhangjieid}"    ><br>

    章节名称：<input type="text"  name="zhangjiename"  value="${zj.zhangjiename}"   ><br>

    视频：

    <input type="file" id="imgFileBTN" >
    <input type="text" id="hidden-photo" name="shipin">
    <div id="showImgDiv" style="width: 100px;height: 100px;border-style:solid;border-width:1px; border-color:black;">
        <video id="showImg" style="width: 100px;height: 100px;"></video>
    </div>
    <div id="showBars"></div>


    状态：   <input type="radio"  name="shoufeistatus"  value="1"   <c:if test="${zj.shoufeistatus==1}">checked</c:if> > 免费 &nbsp;&nbsp;&nbsp;

            <input type="radio"  name="shoufeistatus"  value="2"   <c:if test="${zj.shoufeistatus==2}">checked</c:if> > 会员<br>

</form>
<script type="text/javascript">
//图片上传
$(function(){
$("#imgFileBTN").uploadify({
//前台请求后台的url 不可忽略的参数
'uploader' :"<%=request.getContextPath()%>/tysheng/uploadImg",
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
'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png;*.MP4;*.wmv',
'fileSizeLimit' : '1000MB',
//给div的进度条加背景 不可忽略
'queueID' : 'showBars',
//controller层方法中接收文件的参数名
'fileObjName' : 'imgs',
//上传成功后的回调函数   data 是上传方法返回的数据
'onUploadSuccess' : function(file, data, response) {
$("#showImg").attr("src",data); //oss需要把根目录删了（返回一个网址），只保留data
$("#hidden-photo").val(data);  //同上
}
});
})

</script>
</body>

</html>
