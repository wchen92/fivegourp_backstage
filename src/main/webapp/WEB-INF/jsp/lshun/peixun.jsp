<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">


</head>

<body>
<!-- 引入JQuery -->
<script type="text/javascript"
        src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>


<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>



<form id="peixunfrom_id">
    <center>
    <div class="form-group" style="width:300px;height: 200px;" style="position:relative;" >
        <label for="exampleInputEmail1" >姓名
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <input type="email" class="form-control" id="exampleInputEmail1" name="name" style="width:300px;font-size:1em;" placeholder="姓名"><br>
        <label for="exampleInputEmail1" >性别
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label><br>
        <label class="radio-inline">
            <input type="radio"  id="inlineRadio1" value="1" name="sex"> 男
        </label>
        <label class="radio-inline">
            <input type="radio"  id="inlineRadio2" value="2" name="sex"> 女
        </label><br><br>
        <label for="exampleInputEmail1" >手机号
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <input type="email" class="form-control" id="exampleInputEmail11" name="shouji" style="width:300px;font-size:1em;" placeholder="手机号"><br>
        <label for="exampleInputEmail1" >QQ号码
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <input type="email" class="form-control" id="exampleInputEmail111" style="width:300px;font-size:1em;" placeholder="QQ号码" name="qqhao"><br>
        <label for="exampleInputEmail1" >微信号</label>
        <input type="email" class="form-control" id="exampleInputEmail1111" style="width:300px;font-size:1em;" placeholder="微信号" name="weixinhao"><br>
        <label for="exampleInputEmail1" >最高学历
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <select class="form-control" name="xueli">
            <option value="0">请选择</option>
            <option value="1">初中</option>
            <option value="2">高中</option>
            <option value="3">大学</option>
            <option value="4">研究生</option>
        </select><br>
        <label for="exampleInputEmail1" >毕业时间
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <input class="form_datetime form-control" type="date" value="" size="16" name="biyeshijian"><br>
        <label for="exampleInputEmail1" >当前薪资
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <input type="email" class="form-control" id="exampleInputEmail11111" style="width:300px;font-size:1em;" placeholder="当前薪资" name="xinzi"><br>
        <label for="exampleInputEmail1" >当前状态
            <a href="#" style="color: red" >
                <span class="glyphicon glyphicon-star"></span>
            </a>
        </label>
        <select class="form-control" name="zhuangtai">
            <option value="0">请选择</option>
            <option value="1">在读</option>
            <option value="2">在实习</option>
            <option value="3">刚毕业</option>
            <option value="4">一年以内工作经验</option>
            <option value="5">两年以内工作经验</option>
            <option value="6">三年以内工作经验</option>
            <option value="7">其他</option>
        </select>
        <br>
        <br>
        <button type="button" class="btn btn-primary" onclick="peixunadd()">立即报名</button>
    </div>

    </center>

</form>
<script type="text/javascript">
    function peixunadd() {
        $.ajax({
            url:"<%=request.getContextPath()%>/wchencontroller/addpeixun",
            data:$("#peixunfrom_id").serialize(),
            type:"post",
            dataType:"text",
            async:false,
            success:function(data){
                if(data=="1"){
                    alert("报名成功请耐心等待工作人员联系");
                }
                $("#peixunfrom_id")[0].reset();
            }
        })
    }

</script>

</body>

</html>