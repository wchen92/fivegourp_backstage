<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>


</head>


<body>

<input class="easyui-button width_80 l-btn l-btn-small" type='button'onclick="ggggmai()" value="导出">
<div id="container3" style="width: 550px; height: 400px; margin: 0 auto"></div>



<script language="JavaScript">


    $(function(){
        test14();

    });
    function test14(){
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/queryguanggao",
            type: "post",
            dataType: "json",
            success: function(result){
                $(document).ready(function() {


                    var title = {
                        text: '广告收费'
                    };
                    var subtitle = {
                        text: 'Source: jk.com'
                    };
                    var xAxis = {
                        categories: result.xlist,
                        crosshair: true
                    };
                    var yAxis = {
                        title: {
                            text: 'Temperature (\k)'
                        },
                        plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                    };


                    var tooltip = {
                        valueSuffix: '\k'
                    }

                    var legend = {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle',
                        borderWidth: 0
                    };

                    var series =  [
                        {
                            name: '广告费',
                            data: result.ylist,
                        },

                    ];

                    var json = {};

                    json.title = title;
                    json.subtitle = subtitle;
                    json.xAxis = xAxis;
                    json.yAxis = yAxis;
                    json.tooltip = tooltip;
                    json.legend = legend;
                    json.series = series;

                    $('#container3').highcharts(json);
                });
            }
        })
    }


    function ggggmai() {
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/querygoumaigg",
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