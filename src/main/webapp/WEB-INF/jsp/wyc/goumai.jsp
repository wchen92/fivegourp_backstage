<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    
</head>


<body>

<input class="easyui-button width_80 l-btn l-btn-small" type='button' onclick="kecheng()" value="导出">
<div id="container2" style="width: 550px; height: 400px; margin: 0 auto"></div>
<script language="JavaScript">



    $(function(){
        test134();

    });
    function test134(){
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/queryshiji",
            type: "post",
            dataType: "json",
            success: function(result){

                $(document).ready(function() {
                    var chart = {
                        type: 'area'
                    };
                    var title = {
                        text: '时间分段课程购买表'
                    };
                    var subtitle = {

                    };
                    var xAxis = {
                        categories: result.xlist,
                        crosshair: true
                    };
                    var yAxis = {
                        title: {
                            text: '购买数'
                        },
                        labels: {
                            formatter: function () {
                                return this.value / 1000 + 'k';
                            }
                        }
                    };
                    var tooltip = {

                    };
                    var plotOptions = {
                        area: {
                            pointStart: 2018,
                            marker: {
                                enabled: false,

                                states: {
                                    hover: {
                                        enabled: true
                                    }
                                }
                            }
                        }
                    };
                    var series= [{

                        data: result.ylist,
                    }, ]


                    var json = {};
                    json.chart = chart;
                    json.title = title;
                    json.subtitle = subtitle;
                    json.tooltip = tooltip;
                    json.xAxis = xAxis;
                    json.yAxis = yAxis;
                    json.series = series;
                    json.plotOptions = plotOptions;
                    $('#container2').highcharts(json);

                });

            }})}





    function kecheng() {
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/querykecheng",
            type: "post",
            datatype: "json",
            success: function () {
                alert("成功");
            },
            error: function () {
                alert("修改失败");
            }
        });
    }
</script>
</body>
</html>