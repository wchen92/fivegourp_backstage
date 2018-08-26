<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html><!--<![endif]--><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9, IE=8"> <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的资料--专注于分布式&amp;微服务的在线教育</title>
    <meta name="author" content="http://www.itmayiedu.com">
    <meta name="keywords" content="蚂蚁课堂,Java视频教程,Java高级架构师教程,SpringBoot视频教程,SpringCloud视频教程,Redis视频教程,ActivityMQ视频教程">
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <meta name="description" content="蚂蚁课堂：专属于年轻人的在线学习平台，因为年轻，所以坚持不懈！网站包含了【微服务实战】【分布式架构】【高并发与高可用】等视频课程。官方QQ群:193086273"> <link rel="shortcut icon" href="http://www.itmayiedu.com/favicon.ico" type="image/x-icon"> <link rel="stylesheet" type="text/css" href="http://www.itmayiedu.com/static/inxweb/css/reset.css"> <link rel="stylesheet" type="text/css" href="http://www.itmayiedu.com/static/inxweb/css/theme.css"> <link rel="stylesheet" type="text/css" href="http://www.itmayiedu.com/static/inxweb/css/global.css"> <link rel="stylesheet" type="text/css" href="http://www.itmayiedu.com/static/inxweb/css/web.css"> <link href="http://www.itmayiedu.com/static/inxweb/css/mw_320_768.css" rel="stylesheet" type="text/css" media="screen and (min-width: 320px) and (max-width: 768px)"> <script src="http://push.zhanzhang.baidu.com/push.js"></script><script async="" src="http://widget.daovoice.io/widget/3b2adbb4.js" charset="utf-8"></script><script type="text/javascript" src="http://www.itmayiedu.com/static/common/webutils.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/static/common/jquery-1.7.2.min.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/static/inxweb/user/ucTop.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/static/inxweb/header/header.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/static/inxweb/js/common.js"></script> <!--[if lt IE 9]><script src="http://www.itmayiedu.com/static/common/html5.js"></script><![endif]--> <script>var baselocation = "http://www.itmayiedu.com";var keuploadSimpleUrl='http://www.itmayiedu.com/image/keupload?';var uploadServerUrl='http://www.itmayiedu.com';var uploadSimpleUrl="http://www.itmayiedu.com/image/gok4?";</script> <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> <link rel="stylesheet" type="text/css" href="http://www.itmayiedu.com/static/inxweb/css/reset.css"> <link rel="stylesheet" type="text/css" href="http://www.itmayiedu.com/static/common/jcrop/jquery.Jcrop.min.css"> <script type="text/javascript" src="http://www.itmayiedu.com/static/common/jcrop/jquery.Jcrop.min.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/static/inxweb/user/user.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/kindeditor/kindeditor-all.js"></script> <script type="text/javascript" src="http://www.itmayiedu.com/static/inxweb/js/shopcart.js"></script>
    <script type="text/javascript">
    $(function () {
        showTab('2');//选项控制显示
        uploadImg('fileupload', 'uploadfile');
        memberType("1",null);
    });

</script> <style type="text/css">
    .ke-upload-area {
        min-width: 54px;
        width: auto;
    }
    .ke-upload-area .ke-button-common, .ke-upload-area .ke-button-common input {
        border: 1px solid #FF5F16;
        background: #FFF7F3;
    }
    .ke-upload-area .ke-button-common input {
        border: none;
        width: 100px;
        color: #FF5F16;
        font-weight: bold;
    }
    .ke-upload-area .ke-button-common input:hover {
        background: #FFF2EC;
    }
</style>
    <link href="http://www.itmayiedu.com/kindeditor/themes/default/default.css" rel="stylesheet">
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/default/easyui.css" type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/EasyUI/themes/icon.css" type="text/css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/uploadify/uploadify.css" type="text/css"/>
</head>
<body>

<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.min.js"></script>

<div class="in-wrap">
    <header id="header">
        <section class="container"><a href="http://cn.mikecrm.com/kz8uPv0" target="_blank"> </a>
            <h1 id="logo" class="current">
                <a href="<%=request.getContextPath()%>/wchenindexcontroller/gotoshowall" title=""> <img src="https://save0517.oss-cn-beijing.aliyuncs.com/aliyun/jinkelong.png" width="100%" alt="">
                </a>
            </h1>
            <div class="h-r-nsl">
                  <ul class="nav">
                      <li><a href="<%=request.getContextPath()%>/wchenindexcontroller/gotoshowall" title="首页">首页</a></li>
                      <li><a href="<%=request.getContextPath()%>/linshuiindex/TestYeMian" title="课程">课程</a></li>
                      <li><a href="https://save0517.oss-cn-beijing.aliyuncs.com/aliyun/kecheng.jpg" title="路线" target="_blank">路线</a></li>
                      <li><a href="<%=request.getContextPath()%>/zqshunindex/huiyuan" title="会员">会员</a></li>
                      <li><a href="/questions/list" title="问答">问答</a></li>
                      <li><a href="http://cn.mikecrm.com/kz8uPv0" title="培训" target="_blank">培训</a></li>
                  </ul>
                   <ul class="h-r-login">
                       <li class="h-r-user undis" id="is-login-two" style="display: list-item;">
                           <span id="wchenindextitel"></span>
                       </li>
                  </ul>
                <aside class="h-r-search">
                    <label class="h-r-s-box">
                        <input type="text" placeholder="输入你想学的课程" id="selectsolrgo" value="">
                        <button type="submit" class="s-btn" onclick="selectsolr()">
                            <em class="icon18">&nbsp;</em>
                        </button>
                    </label>
                </aside>
            </div>
            <aside class="mw-nav-btn"><div class="mw-nav-icon"></div></aside>
            <div class="clear"></div>
        </section>
    </header>
    <div class="h-mobile-mask"></div>
    </div>

    <div class="bg-fa of">
        <section class="container">
            <div class="u-body mt40">
                <script>$(function(){var str = '<section style="color: #666;position:absolute;left:50%;bottom:20px;z-index:7;margin-left:-80px;">';str+='<span>Powered by</span>';str+='<a href="http://www.inxedu.com" target="_blank" title="因酷教育软件" style="margin-left: 2px;color: #666;">因酷教育软件</a>';str+='</section>';$("body").append(str); });</script>
                <article class="col-7 fl"> <div class="u-r-cont"> <section> <div>
                    <section class="c-infor-tabTitle c-tab-title">
                        <a href="javascript: void(0)" title="我的资料" style="cursor: default;"></a>
                        <a href="javascript: void(0)" title="基本资料" class="clickAvailable current">
                            <span id="jiben">基本资料</span>
                        </a>
                        <a href="javascript: void(0)"  title="密码设置" class="clickAvailable">密码设置</a>
                    </section>
                </div>
                    <div class="mt40" id="p_tCont"> <div class="u-account-box" style="display: block;">


                    <form method="post" id="updateForm">
                        <ol class="u-account-li">
                            <input type="hidden" name="yonghuid" value="${qiantai.yonghuid}">
                            <li>
                                <label class="u-a-title"> <span class="fsize16 c-999">用户类型</span> </label>
                                <span style="color: #999;">
                                    <c:if test="${qiantai.shifouhuiyuan==1 }">
                                     <input type="hidden"  name="shifouhuiyuan" value="1"  readonly="readonly" disabled="disabled"
                                           <%-- <c:if test="${qiantai.shifouhuiyuan==1 }">checked</c:if>--%>
                                     >您已是会员</c:if>
                                     <c:if test="${qiantai.shifouhuiyuan==2 }">
                                    <input type="hidden"  name="shifouhuiyuan" value="2"  readonly="readonly" disabled="disabled"
                                          <%-- <c:if test="${qiantai.shifouhuiyuan==2 }">checked</c:if>--%>
                                    >您不是会员
                                </span>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/zqshunindex/huiyuan" style="color: #12c287">点击我充值会员</a></c:if>
                                </li>
                            <li>
                                <label class="u-a-title"> <span class="fsize16 c-999">邮&nbsp;&nbsp;箱</span> </label>
                                <input type="text" class="u-a-inpt" name="yonghuyouxiang" value="${qiantai.yonghuyouxiang}" placeholder="">
                            </li>
                            <li><label class="u-a-title"> <span class="fsize16 c-999">手机号</span> </label>
                                <input type="text" class="u-a-inpt" name="yonghushoujihao" value="${qiantai.yonghushoujihao}" placeholder="">
                            </li>
                            <li><label class="u-a-title"> <span class="fsize16 c-999">头像</span> </label>
                                <input type="file" id="imgFileBTN" >
                                <input type="hidden" id="hidden-photos" name="yonghutouxiang" value="${qiantai.yonghutouxiang}">
                                <div id="showImgsDiv" style="width: 100px;height: 100px;border-style:solid;border-width:1px; border-color:black;">
                                    <img src="${qiantai.yonghutouxiang}" id="showImgs" style="width: 100px;height: 100px;">
                                </div>
                                <div id="showBarss"></div>
                            </li>
                            <li><label class="u-a-title"> <span class="fsize16 c-999">姓 名</span> </label>
                                <input type="text" class="u-a-inpt" name="yonghuname" value="${qiantai.yonghuname}" placeholder="">
                            </li>
                            <li><label class="u-a-title"> <span class="fsize16 c-999">昵 称</span> </label>
                                <input type="text" class="u-a-inpt" name="yonghunicheng" value="${qiantai.yonghunicheng}" placeholder="">
                            </li>
                            <li><label class="u-a-title"> <span class="fsize16 c-999">性 别</span> </label>
                                <input type="radio" name="yonghusex" value="1"
                                       <c:if test="${qiantai.yonghusex==1 }">checked</c:if>><span class="vam fsize14 c-666">男</span>
                                <input type="radio" name="yonghusex" value="2"
                                       <c:if test="${qiantai.yonghusex==2 }">checked</c:if>><span class="vam fsize14 c-666">女</span>
                            </li>
                            <li><label class="u-a-title"> <span class="fsize16 c-999">年 龄</span> </label>
                                <input type="text" class="u-a-inpt" name="yonghunianling" value="${qiantai.yonghunianling}" placeholder="">
                            </li>
                        </ol>
                    </form>
                    <div class="ml50 mt50 pl50">
                        <a href="javascript:void(0)" title="" class="comm-btn c-btn-7" onclick="updatexinxi()">提 交</a>
                    </div>
                </div>
                    <div class="u-account-box undis" style="display: none;">

                        <form method="post" name="pwdForm" id="pwdForm">
                            <input type="hidden" name="yonghuid" value="${qiantai.yonghuid}">
                            <ol class="u-account-li">
                                <li>
                                    <label class="u-a-title"> <span class="fsize16 c-999">旧密码</span></label>
                                    <input type="text" class="u-a-inpt" name="" value="${qiantai.yonghumima}" placeholder="" maxlength="16">
                                    <span class="u-a-error"></span>
                                </li>
                                <li><label class="u-a-title"> <span class="fsize16 c-999">新密码</span> </label>
                                    <input type="text" id="pwd" name="yonghumima" class="easyui-validatebox"  data-options="required:true" style="width:300px;height: 30px"> <span class="u-a-error"></span>
                                </li>
                                <li><label class="u-a-title"> <span class="fsize16 c-999">新密码确认</span> </label>
                                    <input type="text" id="rpwd" name="confirmPwd" class="easyui-validatebox"  required="required" validType="equals['#pwd']" style="width:300px;height: 30px">
                                    <span class="u-a-error"></span>
                                </li>
                            </ol>
                        </form>
                        <div class="ml50 mt50 pl50">
                            <a href="javascript:updatemima()" title="" class="comm-btn c-btn-7" >修 改</a>
                            <a href="javascript:void(0)" title="" class="comm-btn c-btn-7" onclick="javascript:$('#pwdForm').find('input').val('');">重 置</a>
                        </div>
                    </div> <div style="display: none;"> <form action="http://wx.inxedu.com/order/bank" name="orderForm" id="orderForm" method="get" target="_blank"> <input id="orderId" name="orderId" type="hidden" value=""> <input id="defaultbank" name="bankId" type="hidden" value=""> <input id="payType" name="payType" type="hidden" value="ALIPAY"> </form> </div> <div style="display: none;"> <input id="couponCodeHidden" type="hidden" value=""> </div> <div class="mt30" style="display: none;"> <header class=""><span class="fsize24 c-333">支付方式</span></header> <div class="c-pay-method"> <div class="of"> <header class="c-p-title">网上银行</header> <div class="buyB_payPlat"> <ul class="clearfix"> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="CEB-NET-B2C" bankname="光大银行"> <img src="/static/inxweb/img/pay/bank_ZGGDYH.png" alt="光大银行"></label> </li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="ICBC-NET-B2C" bankname="中国工商银行"><img src="/static/inxweb/img/pay/bank_ZGGSYH.png" alt="中国工商银行"></label></li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="CCB-NET-B2C" bankname="中国建设银行"><img src="/static/inxweb/img/pay/bank_ZGJSYH.png" alt="中国建设银行"></label></li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="ABC-NET-B2C" bankname="中国农业银行"><img src="/static/inxweb/img/pay/bank_ZGNYYH.png" alt="中国农业银行"></label></li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="CMBCHINA-NET-B2C" bankname="招商银行"><img src="/static/inxweb/img/pay/bank_ZSYH.png" alt="招商银行"></label> </li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="BOC-NET-B2C" bankname="中国银行"><img src="/static/inxweb/img/pay/bank_ZGYH.png" alt="中国银行"></label> </li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="BOCO-NET-B2C" bankname="中国交通银行"><img src="/static/inxweb/img/pay/bank_JTYH.png" alt="中国交通银行"></label> </li> <li><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="POST-NET-B2C" bankname="中国邮政储蓄银行"><img src="/static/inxweb/img/pay/bank_ZGYZCXYH.png" alt="中国邮政储蓄银行"></label></li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="CIB-NET-B2C" bankname="兴业银行"><img src="/static/inxweb/img/pay/bank_XYYH.png" alt="兴业银行"></label> </li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="CMBC-NET-B2C" bankname="中国民生银行"><img src="/static/inxweb/img/pay/bank_ZGMSYH.png" alt="中国民生银行"></label></li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="ECITIC-NET-B2C" bankname="中信银行"><img src="/static/inxweb/img/pay/bank_ZXYH.png" alt="中信银行"></label> </li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="PINGANBANK-NET-B2C" bankname="平安银行"><img src="/static/inxweb/img/pay/bank_PAYH.png" alt="平安银行"></label> </li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="SDB-NET-B2C" bankname="深圳发展银行"><img src="/static/inxweb/img/pay/bank_SZFZYH.png" alt="深圳发展银行"></label></li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="SHB-NET-B2C" bankname="上海银行"><img src="/static/inxweb/img/pay/bank_SHYH.png" alt="上海银行"></label> </li> <li class="buyB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="GDB-NET-B2C" bankname="广发银行"><img src="/static/inxweb/img/pay/bank_GFYH.png" alt="广发银行"></label> </li> <li class="payB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="SPDB-NET-B2C" bankname="上海浦东发展银行"><img src="/static/inxweb/img/pay/bank_PFYH.png" alt="上海浦东发展银行"></label></li> <li class="payB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="HXB-NET-B2C" bankname="华夏银行"><img src="/static/inxweb/img/pay/bank_HXYH.png" alt="华夏银行"></label> </li> <li class="payB_payPlatNone"><label><input type="radio" onclick="checkbank('YEEPAY')" name="defaultbank" value="BCCB-NET-B2C" bankname="北京银行"><img src="/static/inxweb/img/pay/wal_bank03_beiJIng.jpg" alt="北京银行"></label> </li> </ul> </div> </div> <div class="of"> <header class="c-p-title">第三方支付</header> <div class="buyB_payPlat"> <ul class="clearfix" id="ulPayType"> <li><label> <input type="radio" onclick="checkbank('ALIPAY')" checked="checked" name="alipay" value=""> <img alt="支付宝" src="/static/inxweb/img/pay/buyB_pay_kuaiqian3.jpg"> </label></li> <li><label><input type="radio" onclick="checkbank('WEIXIN')" name="weixin" value=""> <img alt="微信" src="/static/inxweb/img/pay/buyB_pay_wx.jpg"> </label></li> <li> <label><input type="radio" value="00" name="yeepay" onclick="checkbank('YEEPAY')"> <img src="/static/inxweb/img/pay/buyB_pay_yibao.jpg" alt="易宝"></label></li> </ul> </div> </div> </div> </div> <div class="mt30" style="display: none;"> <header class=""><span class="fsize24 c-333">结算信息</span></header> <div class="c-pay-method c-p-m"> <div> <div class="fr tar ddzj"> <p class="fsize14 c-333"><span class=" hLh30">订单总价：<tt class="c-master f-fG fsize18 price">￥100</tt></span></p> <p class="fsize14 c-333 hLh30 mt10"><span>优惠类型：<tt class="c-master" id="yhTypeId">无</tt></span> </p> <p class="fsize18 c-333 mt20 hLh30"><span>订单支付金额：<tt class="c-master fsize34 f-fG price">￥100</tt></span></p> </div> <div class="clear"></div> </div> <div class="tar mt40 cx-tj-btnbox"> <a id="order" href="javascript:order(17,'MEMBER')" class="order-btn">提交订单</a> </div> </div> </div> <article class="mt30" id="order_success" style="display: none"> <div class="order-table pb20"> <section class="mt20 mr20 mb20 ml20"> <div class="orderSuccess pr ml20"> <ol> <li><h2 class="hLh30 line3 pb10"><strong class="c-333 fsize20"><tt>订单号:</tt><font class="ml5 mr5 c-orange" id="orderId_success"></font>下单成功，订单总额<font class="ml5 c-orange" id="amount_success"></font></strong> </h2></li> <li><h2 class="hLh30 line3 pb10"><strong class="c-333 fsize20"><tt>帐户余额:</tt><font class="ml5 mr5 c-orange" id="balance_s">￥0.00</font><font class="ml5 c-orange" id="bankAmount_s">，需充值￥0.00</font></strong> </h2></li> <li class="mt10"> <span class="vam"><a class="order-submit" title="" id="payNow" href="javascript:void(0)" onclick="goToBank()">立即支付</a></span> </li> <li class="tac"></li> <li class="mt20"><span class="c-333 fsize14">您现在可以：<a id="repaylink" class="c-333 mr10" title="查看订单信息" href="/front/repay/"><u>返回修改支付方式</u></a> | <a class="c-4e ml10 mr10" title="进入学习中心" href="http://wx.inxedu.com/uc/home"><u>进入学习中心</u></a> | <a class="c-4e ml10" title="返回首页" href="http://wx.inxedu.com/"><u>返回首页</u></a></span> </li> </ol> <span class="succIcon pa"></span> </div> </section> </div> </article> </div></section></div></article> </div> </section></div> </div>    <div class="clear"></div>    <link href="http://www.itmayiedu.com/static/inxweb/css/qq.css " rel="stylesheet"> <footer id="footer"> <section class="container"> <div class=""> <h4 class="hLh30"> <span class="fsize18 f-fM c-999">友情链接</span> </h4> <ul class="of flink-list"> <li><a href="https://www.meitedu.com" title="每特学院" target="_blank">每特学院</a> </li> <li><a href="https://ms.meitedu.com" title="Java面试宝典" target="_blank">Java面试宝典</a> </li> <li><a href="http://www.itresource.org" title="Java视频教程" target="_blank">Java视频教程</a> </li> <li><a href="http://www.meiteedu.com/" title="每特公司">每特公司</a> </li> <li><a href="http://mini.eastday.com/a/170618074857596.html" title="媒体报道" target="_blank">媒体报道</a> </li> <li><a href="http://www.itresource.org/plugin.php?id=qgroup:qgroup" title="粉丝群" target="_blank">粉丝群</a> </li> </ul> <div class="clear"></div> </div> <div class="b-foot"> <section class="fl col-7"> <section class="mr20"> <section class="b-f-link"> <a href="/front/articleinfo/117.html" title="关于我们">关于我们</a>| <span>服务热线：400-006-5079</span> <span>Email：644064779@qq.com&nbsp;Java技术交流群:116295598</span> </section> <section class="b-f-link mt10"> <span>©2016-2018 上海每特教育科技有限公司版本所有</span> </section> </section> </section> <aside class="fl col-3 tac mt15"> <section class="gf-tx"> <span><img src="http://www.itmayiedu.com/static/inxweb/img/wx-icon.png" alt=""></span> <div class="gf-tx-ewm"> <img src="http://www.itmayiedu.com/images/upload/image/20171222/1513928038043.jpg" alt=""> </div> </section> <section class="gf-tx"> <span><img src="http://www.itmayiedu.com/static/inxweb/img/wb-icon.png" alt=""></span> <div class="gf-tx-ewm"> <img src="http://www.itmayiedu.com/images/upload/image/20150908/1441801298938.png" alt=""> </div> </section></aside> <div class="clear"></div></div></section> </footer>

    <script>

        $(function (){
            $("#jiben").trigger("click");
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


            //头部用户信息
            $.ajax({
                url:"<%=request.getContextPath()%>/wchencontroller/selecttitle",
                type:"post",
                async:true,
                success: function(list){
                    var spanwchenindextitel = "";
                    spanwchenindextitel = "<a href='<%=request.getContextPath()%>/wjyiiindex/queryAllxinxi' title=''> <img src='"+list.yonghutouxiang+"' width='30' height='30' class='vam picImg' alt=''></a><a href='javascript:void(0)' title='退出' onclick='exit();' class='ml5'>退出</a>";
                    $("#wchenindextitel").html(spanwchenindextitel);
                },
            });

        })

        //确认密码
        $.extend($.fn.validatebox.defaults.rules,{
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '密码不一致'
            }
        })
        //修改信息
        function updatexinxi(){
            $.ajax({
                url:"<%=request.getContextPath()%>/wjyi/updatexinxi",
                type:"post",
                data:$("#updateForm").serialize(),
                datatype:"json",
                success:function(reslut){
                    if(reslut==1){
                        alert("修改成功")
                    }
                },
                error: function(){
                    alert("修改失败");
                }
            });
        }

        //修改密码
        function updatemima() {
            $.ajax({
                url: "<%=request.getContextPath()%>/wjyi/updatemima",
                type: "post",
                data: $("#pwdForm").serialize(),
                datatype: "json",
                success: function (reslut) {
                    if (reslut == 1) {
                        alert("修改成功")
                    }
                },
                error: function () {
                    alert("修改失败");
                }
            })
        }

        //图片上传

        //头部搜索（solr）
        function selectsolr(){
            var getwitei = $("#selectsolrgo").val();
            location.href="<%=request.getContextPath()%>/linshuiindex/TestYeMian?allsolrselect="+getwitei;
        }
        </script>
</section>
</body>
</html>