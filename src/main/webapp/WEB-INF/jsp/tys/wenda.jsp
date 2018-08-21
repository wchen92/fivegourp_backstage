<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>

<html>
<!--<![endif]-->
<head>

    <title>Title</title>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/EasyUI/themes/default/easyui.css" type="text/css"/>

    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/EasyUI/themes/icon.css" type="text/css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css">





    <link rel="shortcut icon" href="http://www.itmayiedu.com/favicon.ico" type="image/x-icon">
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
    <link href="http://www.itmayiedu.com/static/inxweb/css/mw_320_768.css?t=2018-06-19" rel="stylesheet"
          type="text/css"
          media="screen and (min-width: 320px) and (max-width: 768px)">


    <!--[if lt IE 9]><script src="http://www.itmayiedu.com/static/common/html5.js"></script><![endif]-->

    <%--<script type="text/javascript"--%>
            <%--src="http://www.itmayiedu.com/static/common/jquery-1.7.2.min.js?t=2018-06-19"></script>--%>


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






    <script type="text/javascript" src="http://www.itmayiedu.com/static/common/webutils.js?t=2017-04-30"></script>
    <script type="text/javascript"
            src="http://www.itmayiedu.com/static/inxweb/header/header.js?t=2018-06-19"></script>
    <script type="text/javascript" src="http://www.itmayiedu.com/static/inxweb/js/common.js?t=2018-06-19"></script>

    <script>


        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?b43c1c82b09cda6b125e6981fbde442c";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <script>var baselocation = "http://www.itmayiedu.com";var keuploadSimpleUrl='http://www.itmayiedu.com/image/keupload?';var uploadServerUrl='http://www.itmayiedu.com';var uploadSimpleUrl="http://www.itmayiedu.com/image/gok4?";</script>

    <script type="text/javascript">
        $(document).ready(function() {
            var i = setInterval(function() {
                if ($(".in-wrap").next().is(":hidden")) {
                    clearTimeout(i);
                    $(".in-wrap").next().show();
                    //如果元素为隐藏,则将它显现
                } else {
                    $(".in-wrap").next().html('');
                    $(".in-wrap").next().hide(); //如果元素为显现,则将其隐藏
                }

            }, 1);

        });
    </script>
</head>

<body class="W-body">
<div class="in-wrap">

    <!-- 公共头引入 -->
    <!-- /global header begin-->


    <script>
        $(document).ready(function (){



        });
    </script>

    <header id="header">
        <section class="container">
            <a href='http://cn.mikecrm.com/kz8uPv0' target="_blank">
                <!--
                        <img  id="topImg"    alt="" style='height:0px;width:100%' src="http://www.itmayiedu.com/images/hs/1510242080873.png">
                 -->
            </a>
            <h1 id="logo">
                <a href="http://www.itmayiedu.com/" title=""> <img
                        src="http://www.itmayiedu.com/images/upload/websiteLogo/20161107/1478524048493.png" width="100%"
                        alt="">
                </a>
            </h1>
            <div class="h-r-nsl">



            </div>
            <aside class="mw-nav-btn">
                <div class="mw-nav-icon"></div>
            </aside>
            <div class="clear"></div>
        </section>
    </header>
    <!-- /global header end-->
    <div class="h-mobile-mask"></div>
    <div class="head-mobile">

        <div class="head-mobile-box">


        </div>

    </div>


    <!-- 公共头引入 -->
    <script>$(function(){var str = '<section style="color: #666;position:absolute;left:50%;bottom:20px;z-index:7;margin-left:-80px;">';str+='<span>Powered by</span>';str+='<a href="http://www.inxedu.com" target="_blank" title="因酷教育软件" style="margin-left: 2px;color: #666;">因酷教育软件</a>';str+='</section>';$("body").append(str); });</script>
    <div class="bg-fa of">
        <section class="container">
            <section class="i-question">
                <div class="fl col-7">
                    <section class="mr30 pt10">

                        <div class="js-wrap">
                            <section class="fr">
								<span class="c-ccc"> <tt class="c-master f-fM">1</tt>/<tt class="c-666 f-fM">6</tt>
								</span>
                            </section>
                            <section class="fl">
                                <ol class="js-tap clearfix">
                                    <li class="current bg-orange"><a  href="javascript:void(0)" title="最新">最新</a></li> &nbsp;
                                    <li  class="current bg-orange"><a onclick="submitForm('replycount','order')" href="javascript:void(0)" title="热门">我要留言</a></li>

                                </ol>
                            </section>
                        </div>

                        <!-- /新增的DIV -->
                        <div id="tys_xin"></div>
                        <!-- /问题列表 开始 -->

                        <c:forEach items="${treeList}" var="t">

                        <div class="q-list">




                            <section class="q-all-list">

                                <ul>
                                    <li>
                                        <aside class="q-head-pic">
                                            <img src="http://www.itmayiedu.com/static/inxweb/img/avatar-boy.gif" alt="">
                                            <p class="hLh30 txtOf">
                                                <span class="c-999"> 游客</span>
                                            </p>
                                        </aside>
                                        <section class="q-txt-box">
                                            <a class="replyBrowseNum" href="http://www.itmayiedu.com/questions/info/151" title="">
                                                <%--<div class="replyNum">--%>
                                                    <%--<span class="r-b-num">0</span>--%>
                                                    <%--<p class="hLh30">--%>
                                                        <%--<span class="c-999 f-fA">回复</span>--%>
                                                    <%--</p>--%>
                                                <%--</div> --%>
                                                <%--<div class="browseNum">--%>
                                                    <%--<span class="r-b-num">7</span>--%>
                                                    <%--<p class="hLh30">--%>
                                                        <%--<span class="c-999 f-fA">浏览数</span>--%>
                                                    <%--</p>--%>
                                                <%--</div>--%>
                                            </a>

                                            <h3 class="hLh30 txtOf">
                                                <em class="icon16 q-tw">&nbsp;</em>
                                                <a onclick="huifu666(${t.id})" href="javascript:void(0)"  title="" class="fsize16 c-333 vam">
                                                        ${t.text}</a>
                                            </h3>
                                            <c:forEach items="${t.list }"  var="arr">
                                                <h3 class="hLh30 txtOf mt5">
                                                    <em class="icon16 q-hd">&nbsp;</em>
                                                    <span class="fsize12 c-999 vam">${arr.text}</span>
                                                    <!-- 没有回答时的内容 -->
                                                </h3>
                                            </c:forEach>
                                            <div class="mt15">
                                                <span class="c-ccc fl vam">${t.wdate}</span>



                                            </div>
                                        </section>
                                    </li>
                                    </c:forEach>


    <script type="text/javascript">
        //自带的样式不能删
        function IsPC() {
            var userAgentInfo = navigator.userAgent;
            var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"
            ];
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

        //新增弹框

        function submitForm(){
           alert("新增弹框");
            $('#tys_xin').dialog({
                title: '添加',
                width: 500,
                height: 300,
                closed: false,
                cache: false,
                href: '<%=request.getContextPath()%>/tyshengIndex/savewenda',
                modal: true,
                buttons:[{
                    text:'保存',
                    handler:function(){
                        $('#tys_wenda').form('submit', {
                            url:'<%=request.getContextPath()%>/tysheng/savawendaone',
                            onSubmit: function(){

                            },
                            success:function(){
                                alert("保存成功");
                              location.href="<%=request.getContextPath()%>/tyshengIndex/queryTreeList"

                            }
                        });
                    }
                }]
            });

        }
//回复页面跳转
        function  huifu666(id) {

       location.href="<%=request.getContextPath()%>/tyshengIndex/queryhuifu666?id="+id;

        }
//初始化加载数据查询
        $(function(){
            searchtys()

        })

        function searchtys(){

            $.ajax({
                url:"<%=request.getContextPath()%>/tyshengIndex/queryTreeList",
                type:"post",
                dataType:"text",
                success:function(){

                }
            })

        }



    </script>

    </div>

</body>
</html>
