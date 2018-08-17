<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>


</head>

<input class="easyui-button width_80 l-btn l-btn-small" type='button' onclick="kengcheng()" value="课程">
<body>
<div id="container3" style="width: 550px; height: 400px; margin: 0 auto"></div>



<script language="JavaScript">


    $(function(){
        test14();

    });
    function test14(){
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/querydianji",
            type: "post",
            dataType: "json",
            success: function(result){
                $(document).ready(function() {
                    var title = {
                        text: '平均购买量'
                    };
                    var subtitle = {
                        text: 'Source: jk.com'
                    };
                    var xAxis = {
                        date:result.xlist,
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
                            name: '购买量',
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
    function kengcheng(){


        location.href= "<%=request.getContextPath()%>/wychao/kengchengExcel"


    }
</script>
</body>
</html>