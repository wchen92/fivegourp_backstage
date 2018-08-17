<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改章节页面</title>
    <style type="text/css">
        .row1{
            padding-top: 100px;
        }
    </style>
</head>
<body>
<form id="zhangjieformaupdate">

            <input type="hidden" name="zhangjieid" value="${zhangJie.zhangjieid}">
    <div class="form-group">
        <label  class="col-sm-2 control-label">章节名称</label>
        <div class="col-sm-4">
            <input class="form-control" name="zhangjiename" value="${zhangJie.zhangjiename}" type="text" >
        </div>
    </div><br><br>
    <div class="form-group">
        <label  class="col-sm-2 control-label">收费状态</label>
        <input type="radio" name="shoufeistatus" value="1" ${zhangJie.shoufeistatus==1 ? 'checked' : '' }>收费
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        <input type="radio" name="shoufeistatus" value="2" ${zhangJie.shoufeistatus==2 ? 'checked' : '' }>免费<br><br>
    </div><br>
        <div id="zhui">
            <label class=" control-label">视频:</label>
               <div  style="height: 240px;width: 300px">
                    <input  id="addimg_Img" name="addimg_Img"  type="file" multiple data-min-file-count="1"/>
                    <input class="form-control" id="scgs" name="shipin" type="text" value="${zhangJie.shipin}" />
                </div>
        </div>
</form>
<script type="text/javascript">
    $('#addimg_Img').fileinput({
        language: 'zh',
        //uploadAsync:false,
        //showCaption:false;
        uploadUrl: '${pageContext.request.contextPath}/zqshun/headImgUpload',
        allowedPreviewTypes : ['image', 'html', 'text', 'video', 'audio', 'flash','MP4','mp4','wmv',],
    });
    $('#addimg_Img').on('fileuploaded', function(event, data, previewId, index) {
//        	   alert(data.response.url);
        $("#scgs").val(data.response.imgname);
    });
</script>
</body>
</html>
