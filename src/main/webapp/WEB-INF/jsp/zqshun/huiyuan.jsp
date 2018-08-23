<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>

    <link rel="stylesheet" type="text/css"
          href="http://www.itmayiedu.com/static/inxweb/css/reset.css?t=2018-06-19">
    <link rel="stylesheet" type="text/css"
          href="http://www.itmayiedu.com/static/inxweb/css/theme.css?t=2018-06-19">
    <link rel="stylesheet" type="text/css"
          href="http://www.itmayiedu.com/static/inxweb/css/global.css?t=2018-06-19">
   <link rel="stylesheet" type="text/css"
          href="http://www.itmayiedu.com/static/inxweb/css/web.css?t=2018-06-19">
    <link rel="stylesheet" type="text/css"
          href="http://www.itmayiedu.com/static/inxweb/css/adaptive.css?t=2018-06-19">
    <!-- 引入JQuery -->
<script type="text/javascript"
        src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>

</head>
<body class="W-body">

<%----%>

<div class="in-wrap">

    <header id="header">
        <section class="container">
            <a href='http://cn.mikecrm.com/kz8uPv0' target="_blank">

            </a>
            <h1 id="logo">
                <a href="http://www.itmayiedu.com/" title=""> <img
                        src="http://www.itmayiedu.com/images/upload/websiteLogo/20161107/1478524048493.png" width="100%"
                        alt="">
                </a>
            </h1>

        </section>
    </header>
</div>
<aside class="mw-nav-btn">
    <div class="mw-nav-icon"></div>
</aside>
<div class="clear"></div>

<div class="h-mobile-mask"></div>
<div class="head-mobile">


</div>


<script>
    $(function() {
        var str = '<section style="color: #666;position:absolute;left:50%;bottom:20px;z-index:7;margin-left:-80px;">';
        str += '<span>Powered by</span>';
        str += '<a href="http://www.itmayiedu.com" target="_blank" title="蚂蚁课堂" style="margin-left: 2px;color: #666;">蚂蚁课堂</a>';
        str += '</section>';
        $("body").append(str);
    });
</script>

<div class="bg-fa of">
    <section class="container">
        <section class="i-article">
            <div class="fl col-7">
                <section class="hLh30 txtOf mt5 pb20 mreadnum"></section>
                <h2 style="padding-bottom: 18px;">蚂蚁课堂充值会员须知</h2>
                <div id="art-infor-body">

                    <p style="text-align: center;">
                        <strong>蚂蚁课堂为了能够更好的服务大家，该课程必须要会员才能观看！</strong>
                    </p>
                    <p style="text-align: center;">
                        <strong><span style="color: rgb(255, 0, 0);"></span></strong>
                    </p>
                    <p style="text-align: center;">
                        <strong>会员享受特权</strong>
                    </p>
                    <p style="text-align: center;">
                        <strong>java分布式/微服务/并发编程/性能优化/等视频教程免费观看！SpringBoot/SpringCloud/Duboo/Dubbo/实战分布式微服务视频教程
                            一切定位企业符合实际、高端技术、按照目前互联网最新主流技术同步更新。 </strong>
                    </p>

                    <p style="text-align: center;">
                        <b>1024p，超清加速观看，无广告。</b>
                    </p>
                    <center>
                        <a href="javascrip:void(0)" id="notUser" class="button">

                            <span id="yhid"></span>

                        </a>
                    </center>
                </div>
            </div>
        </section>
    </section>
</div>

<ul class="h-r-login">
    <li class="undis" id="no-login"><a href="javascript:lrFun()"
                                       title="登录"> <em class="icon18 login-icon">&nbsp;</em><span
            class="vam ml5">登录</span>
    </a> | <a href="javascript:lrFun(2)" title="注册"> </em><span
            class="vam ml5">注册</span>
    </a></li>
    <li class="mr10 undis" id="is-login-one"><a
            href="http://www.itmayiedu.com/uc/letter" title="消息" id="headerMsgCountId"> <em
            class="icon18 news-icon">&nbsp;</em>
    </a><q class="red-point" style="display: none">&nbsp;</q></li>
    <li class="h-r-user undis" id="is-login-two"><a
            href="http://www.itmayiedu.com/uc/index" title=""> <img
            src="http://www.itmayiedu.com/static/inxweb/img/avatar-boy.gif" width="30"
            height="30" class="vam picImg" alt=""> <!--<span
						class="vam disIb" id="userName"></span>-->
    </a> <a href="javascript:void(0)" title="退出" onclick="exit();"
            class="ml5">退出</a></li>
    <!-- /未登录显示第1 li；登录后显示第2，3 li -->
</ul>

<script type="application/javascript">

    $(function(){

        var id ="548d0af1-b4ab-4862-85b8-022f3dba9cee";
            $.ajax({
                url:"<%=request.getContextPath()%>/zqshun/selecthy",
                type : "post",
                data : {id:id},
                success : function(data){
                        if(data==2){
                            $("#yhid").html('<font style="color: green"  size="5" onclick="denglu()" >非会员,请充值</font>');
                        }else{
                            $("#yhid").html('<font style="color: green"  size="5">会员用户</font>');
                        }
                }
            })
    })

    function denglu(){
        lrFun(1);
    }


    function lrFun(type) {
        var oBg = $('<div class="bMask"></div>').appendTo($("body")), dialogEle = $(
                '<div class="dialogWrap" style="position: absolute;border:3px solid rgb(234, 234, 234);border-radius: 3%;"><div class="dialog-ele"><h4 class="d-s-head pr"><a id="close" href="javascript:void(0)" title="关闭" class="dClose icon16 pa">&nbsp;</a><span id="d-s-head-tab" class="d-s-head-tab"><a href="javascript:void(0)" class="current">会员充值</a></span></h4><div class="of"><div id="lrEleWrap" class="mt10 mb20 ml20"></div></div></div></div>')
            .appendTo($("body")), rlEle = [ '<div id="d-s-head-cont" class="lrWrap">'
        + '<section class="dis e-login-ele">'
        + '<div class="mt10">'
        + '<p class="e-l-jy"></p>'
        + '</div>'
        + '<div>'
        + '<ol class="e-login-options">'
        + '<li>'
        + '<input id="u-email" type="text" placeholder="会员充值"  name="" value="" onkeyup="$(this).next().html(\'\');">'
        /*
         * '<section class="hLh30 of pl10"><span class="fr"><a
         * href="/uc/register" class="c-master fsize12">没有账号？去注册→</a></span>'+
         */
            +'<section class="hLh30 of pl10">'
            + '</section>'
            + '<section class="mt20 tac">'
            + '<a href="javascript:void(0)" title="充值" class="e-login-btn" onclick="dialogLogin()">充值</a>'
            + '</section>'


        + '</div>' ];
        $("#lrEleWrap").html(rlEle[0]);
        var dTop = (parseInt(document.documentElement.clientHeight, 10) / 2)
            + (parseInt(document.documentElement.scrollTop
                || document.body.scrollTop, 10)), dH = dialogEle.height(), dW = dialogEle
            .width(), dHead = $(".dialog-ele>h4");
        dialogEle.css({
            "top" : (dTop - (dH / 2)),
            "margin-left" : -(dW / 2)
        });
        dHead.css({
            "width" : (dW - "12")
        }); // ie7下兼容性;

        $(".dClose").bind("click", function() {
            dialogEle.remove();
            oBg.remove();
        });
        if (type == 2) {
            $("#d-s-head-tab").find("a:eq(1)").click();
            $(".dialogWrap").css('top','113px');
        }

    }

        function dialogLogin(){
            alert("充值")

        }




</script>
</body>
</html>
