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

    <link
            href="<%=request.getContextPath()%>/js/css/bootstrap.css"
            rel="stylesheet">
    <link
            href="<%=request.getContextPath()%>/js/link/bootstrap/bootstrap.min.css"
            rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script
            src="<%=request.getContextPath()%>/js/link/bootstrap/bootstrap.min.js"></script>
    <!-- bootstrap-treeview -->
    <link
            href="<%=request.getContextPath()%>/js/link/bootstrap-treeview/bootstrap-treeview.min.css"
            rel="stylesheet">
    <script
            src="<%=request.getContextPath()%>/js/link/bootstrap-treeview/bootstrap-treeview.min.js"></script>
    <!-- bootstrap.addtabs -->
    <link
            href="<%=request.getContextPath()%>/js/link/bootStrap-addTabs/bootstrap.addtabs.css"
            rel="stylesheet">
    <script
            src="<%=request.getContextPath()%>/js/link/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
    <!-- bootstrap-table -->
    <link
            href="<%=request.getContextPath()%>/js/link/bootstrap-table/bootstrap-table.min.css"
            rel="stylesheet">
    <script
            src="<%=request.getContextPath()%>/js/link/bootstrap-table/bootstrap-table.min.js"></script>
    <script
            src="<%=request.getContextPath()%>/js/link/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
    <!-- bootstrap-fileinput -->
    <link
            rel="stylesheet" href="<%=request.getContextPath()%>/js/link/bootstrap-fileinput/fileinput.min.css" />
    <script
            type="text/javascript" src="<%=request.getContextPath()%>/js/link/bootstrap-fileinput/fileinput.min.js"></script>
    <script
            type="text/javascript" src="<%=request.getContextPath()%>/js/link/bootstrap-fileinput/zh.js"></script>
    <!-- new bootstrap-datetimepicker -->
    <link
            href="<%=request.getContextPath()%>/js/link/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"
            rel="stylesheet">
    <script
            src="<%=request.getContextPath()%>/js/link/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
    <script
            src="<%=request.getContextPath()%>/js/link/bootstrap-datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
    <style type="text/css">
        .row1{
            padding-top: 100px;
        }

    </style>

</head>
<body>


<form id="zhangjieformadd">


    <input type="hidden" name="zhangjieid" value="${zhangJie.zhangjieid}">
    <div class="form-group">
        <label  class="col-sm-2 control-label">章节名称</label>
        <div class="col-sm-4">
            <input class="form-control" name="zhangjiename" value="${zhangJie.zhangjiename}" type="text" >
        </div>
    </div><br><br>

    <div class="form-group">
        <label  class="col-sm-2 control-label">收费状态</label>
        <input type="radio" name="shoufeistatus" value="1" ${zhangJie.shoufeistatus==1 ? 'checked' : '' } >收费
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        <input type="radio" name="shoufeistatus" value="2" ${zhangJie.shoufeistatus==2 ? 'checked' : '' }>免费<br><br>

    </div><br>

    <div id="zhui">
        <label class="col-md-2 control-label">视频:</label>
        <div class="col-md-4 tl th" style="height: 350px">

            <input  id="addimg_Img" name="addimg_Img"  type="file" multiple data-min-file-count="1"/>
            <input class="form-control" id="scg" name="shipin" type="text" value="${zhangJie.shipin}" />
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <label  class="col-sm-8 control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        <div class="col-sm-4">
            <button onclick="edit()" type="button" class="btn btn-default list-group-item-success">
                <span class="glyphicon glyphicon-plus" ></span>提交
            </button>
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
        $("#scg").val(data.response.imgname);
    });

    function edit() {
        $.ajax({
            url : "<%=request.getContextPath()%>/zqshun/updatezhangjie",
            type : "post",
            dataType : "json",
            data:$("#zhangjieformadd").serialize(),
            success : function() {
                window.history.back(-1);
            },
            error:function(){
                alert("系统错误")
            }

        });
    }

</script>

<jsp:include page="/js/link/link.jsp"></jsp:include>

</body>
</html>
