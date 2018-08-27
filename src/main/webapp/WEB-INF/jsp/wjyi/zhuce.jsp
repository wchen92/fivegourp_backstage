<%--
  Created by IntelliJ IDEA.
  User: sansan
  Date: 2018/8/18
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            background-image: url(<%=request.getContextPath()%>/images/121.png);
            background-size:100%;
        }
        .mybtn14_3 a
        {
            color:#fff;
        }
    </style>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/default/easyui.css" type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/icon.css" type="text/css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css" type="text/css"/>

</head>
<body background="<%=request.getContextPath()%>/images/121.png">
<br/><br/><br/>
<center>
<form id="addzhuceformid">

    <table >
        <tr>
            <td> 昵称：</td>
            <td> <input type="text" name="yonghunicheng" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入昵称'" style="width:200px"></td>
        </tr>
        <tr>
            <td> 名称：</td>
            <td><input type="text" name = "yonghuname" class="easyui-textbox" style="width:200px;" data-options="iconCls:'icon-man',prompt:'请输入名称'" onchange="queryName()" ></td>
        </tr>
        <tr>
            <td> 性别：</td>
            <td>
                <input type="radio" name = "yonghusex"  value="1" >男
                <input type="radio" name = "yonghusex"  value="2" >女
            </td>
        </tr>
        <tr>
            <td> 年龄：</td>
            <td><input type="text" name = "yonghunianling" class="easyui-textbox" style="width:200px;" data-options="prompt:'请输入年龄'" ></td>
        </tr>
        <tr>
            <td> 头像：</td>
            <td>
                <input type="file" id="imgFileBTN" >
                <input type="hidden" id="hidden-photos" name="yonghutouxiang">
                <div id="showImgsDiv" style="width: 100px;height: 100px;border-style:solid;border-width:1px; border-color:black;">
                    <img src="" id="showImgs" style="width: 100px;height: 100px;">
                </div>
                <div id="showBarss"></div>
            </td>
        </tr>
        <tr>
            <td> 密码：</td>
            <td><%--<input type="text" name = "yonghumima" class="easyui-textbox" style="width:200px;"  >--%>
                <input id="pwd" name="yonghumima" type="text" class="easyui-validatebox" data-options="required:true" data-options="prompt:'请输入密码'"/>
            </td>
        </tr>
        <tr>
            <td> 确认密码：</td>
            <td><%--<input type="text"  class="easyui-textbox" style="width:200px">--%>
                <input id="rpwd" name="queren" type="text" class="easyui-validatebox" required="required" validType="equals['#pwd']" data-options="prompt:'请再次输入密码'"/>
            </td>
        </tr>

        <tr>
            <td> 手机号：</td>
            <td><input type="text" name = "yonghushoujihao" id="yonghuphoneid" class="easyui-textbox" style="width:200px;"  data-options="prompt:'请输入手机号'"></td>
        </tr>
        <tr>
            <td> 验证码：</td>
            <td>
                <input  type="text" id="yanzhengma2"  class="easyui-textbox" style="width:200px" data-options="prompt:'请输入验证码'">
                <a  href="javascript:fasongduanxin1(this)" class="easyui-linkbutton" size="large"  data-options="iconCls:'icon-redo'" style="width:100px;height:25px">发送短信</a>
            </td>
        </tr>
        <tr>
            <td> 邮箱：</td>
            <td><input type="text" name = "yonghuyouxiang" class="easyui-textbox" style="width:200px;" data-options="prompt:'请输入邮箱'" ></td>
        </tr>
        <tr>
            <td colspan="2">
                <center><a  href="javascript:saveYongHu()" class="easyui-linkbutton"  data-options="iconCls:'icon-redo'" >立即注册</a></center>
            </td>
        </tr>
    </table>

</form>
</center>
<input type="hidden" id="yanzhengma1">

<!-- 引入JQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.min.js"></script>

<script type="text/javascript">

    //确认密码
    $.extend($.fn.validatebox.defaults.rules, {
        equals: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: '密码不一致'
        }
    })

    //判断用户名是否存在，如存在则不可用
    function queryName(){
        var aa=   $("#nn").val()
        //alert(aa)
        if(aa.length>=4&&aa.length<=20){
            $.ajax({

                url: "<%=request.getContextPath()%>/wjyi/queryYongHuByName",
                type: "post",
                data: {yonghuname:aa},
                dataType: "json",
                success: function(result){
                    if(result == 1){
                        alert("用户名可用")

                    }else{
                        alert("用户名不可用")
                    }
                },
                error: function(){
                    alert("请求失败！")
                }
            })
        }
    }


    //用户注册
    function saveYongHu(){

        var yanzhengmaa =	$("#yanzhengma1").val()
        var yanzhengmab =	$("#yanzhengma2").val()

        if(yanzhengmab!=null&yanzhengmab!=""&yanzhengmaa==yanzhengmab){
            $.ajax({
                url: "<%=request.getContextPath()%>/wjyi/saveYongHu",
                type: "post",
                data: $("#addzhuceformid").serialize(),
                dataType: "json",
                success: function(result){
                    if(result == 1){
                        alert("注册成功！")
                        location.href="<%=request.getContextPath()%>/wjyiiindex/comeTologin";
                    }
                },
                error: function(){
                    alert("请求失败！")
                }
            })
        }else{
            alert("验证码不正确,请重新输入.")
        }
    }


    //短信验证码
    function fasongduanxin1(val){
        var phoneNumbers = $("#yonghuphoneid").val();
        //alert(phoneNumbers)
        $.ajax({
            url: "<%=request.getContextPath()%>/wjyi/fasonngduanxin",
            type: "post",
            data: {phoneNumber:phoneNumbers},
            dataType: "json",
            success: function(result){
                alert("短信发送成功！");
                $("#yanzhengma1").val(result);
                //将按钮变成倒计时
                settime(val);
            },
            error: function(){
                alert("请求失败！")
            }
        })
    }

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
