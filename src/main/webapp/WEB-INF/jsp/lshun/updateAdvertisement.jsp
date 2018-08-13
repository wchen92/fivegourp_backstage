<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="char_forms">
	<input type="hidden" name="guanggaoid" value="${list.guanggaoid}">
   
   广告价格:<input type="text"  value="${list.money }" class="form-control" name="money"><br>
   广告时间:<input type="text"  value="<fmt:formatDate value="${list.guanggaodate}" pattern="yyyy-MM-dd"/>" class="easyui-datetimebox" name="guanggaodate" style="width:150px" data-options="required:true,showSeconds:false"><br>
    处理人:<input type="text"  value="${list.chuliren }" class="form-control" name="chuliren"><br>
    <input type="file" id="imgFileBTN2" >
    <input type="hidden" id="hidden-photo2" name="guanggaophoto" value="${list.guanggaophoto}">
    <div id="showImgDiv" style="width: 200px;height: 200px;border-style:solid;border-width:1px; border-color:black;">
        <img src="${list.guanggaophoto}" id="showImg2" style="width: 200px;height: 200px;">
    </div>
    <div id="showBars"></div>

  </form>
<script type="text/javascript">
    //图片上传
    $(function(){
        $("#imgFileBTN2").uploadify({
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
                $("#showImg2").attr("src",data); //oss需要把根目录删了（返回一个网址），只保留data
                $("#hidden-photo2").val(data);  //同上
            }
        });
    })
</script>
</body>
</html>