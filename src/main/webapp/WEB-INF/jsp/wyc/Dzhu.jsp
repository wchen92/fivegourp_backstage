<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<input class="easyui-button width_80 l-btn l-btn-small" type='button' value="导出" onclick="goumai()" />

<div id="container1" style="width: 550px; height: 400px; margin: 0 auto"></div>
<div id="sliders">
    <table>
        <tr><td>Alpha Angle</td><td><input id="R0" type="range" min="0" max="45" value="15"/> <span id="R0-value" class="value"></span></td></tr>
        <tr><td>Beta Angle</td><td><input id="R1" type="range" min="0" max="45" value="15"/> <span id="R1-value" class="value"></span></td></tr>
    </table>
</div>

<script language="JavaScript">

    $(function(){
        test134();

    });
    function test134(){
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/querygoumai",
            type: "post",
            dataType: "json",
            success: function(result){


                $(document).ready(function() {
                    var chart = {
                        renderTo: 'container1',
                        type: 'column',
                        margin: 75,
                        options3d: {
                            enabled: true,
                            alpha: 15,
                            beta: 15,
                            depth: 50,
                            viewDistance: 25
                        }
                    };
                    var title = {
                        text: '购买量'
                    };
                    var subtitle = {

                    };

                    var plotOptions = {
                        column: {
                            depth: 25
                        }
                    };

                    var xAxis = {
                        categories: result.xlist,
                        crosshair: true
                    };
                    var series= [{
                        data: result.ylist,
                    }];

                    var json = {};
                    json.xAxis = xAxis;
                    json.chart = chart;
                    json.title = title;
                    json.subtitle = subtitle;
                    json.series = series;
                    json.plotOptions = plotOptions;
                    var highchart = new Highcharts.Chart(json);

                    function showValues() {
                        $('#R0-value').html(highchart.options.chart.options3d.alpha);
                        $('#R1-value').html(highchart.options.chart.options3d.beta);
                    }

                    // Activate the sliders
                    $('#R0').on('change', function () {
                        highchart.options.chart.options3d.alpha = this.value;
                        showValues();
                        highchart.redraw(false);
                    });
                    $('#R1').on('change', function () {
                        highchart.options.chart.options3d.beta = this.value;
                        showValues();
                        highchart.redraw(false);
                    });

                    showValues();
                });
            }
        })
    }



    function goumai(){
        $.ajax({
            url:"<%=request.getContextPath()%>/wychao/querygoumaigg",
            type:"post",
            datatype:"json",
            success:function(){
               alert("成功");
            },
            error: function(){
                alert("修改失败");
            }
        });







    }


</script>
</body>
</html>