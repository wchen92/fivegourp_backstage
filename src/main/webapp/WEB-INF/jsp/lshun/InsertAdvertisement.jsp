<%--
  Created by IntelliJ IDEA.
  User: 王晨
  Date: 2018/8/7
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css">
<body>
<script src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.min.js"></script>
</head>
<form id="shopforms">
	广告价格:<input name="money" class="easyui-numberspinner" style="width:80px;"
				required="required" data-options="min:10,max:10000,editable:true"> <br>
	广告名称:<input name="guanggaoname" type="text" class="easyui-textbox" style="width:200px"> <br>
	<input type="file" id="imgFileBTN" >
	<input type="hidden" id="hidden-photo" name="guanggaophoto">
	<div id="showImgDiv" style="width: 100px;height: 100px;border-style:solid;border-width:1px; border-color:black;">
		<img src="" id="showImg" style="width: 100px;height: 100px;">
	</div>
	<div id="showBars"></div>
</form>


<script type="text/javascript">

    //图片上传
    $(function(){
        $("#imgFileBTN").uploadify({
            //前台请求后台的url 不可忽略的参数
            'uploader' :"<%=request.getContextPath()%>/liushun/uploadImg",
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
