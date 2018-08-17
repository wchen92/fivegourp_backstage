<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    
</head>


<body>

<input class="easyui-button width_80 l-btn l-btn-small" type='button' onclick="goumai()" value="购买">
<div id="container2" style="width: 550px; height: 400px; margin: 0 auto"></div>
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
                        type: 'area'
                    };
                    var title = {
                        text: 'US and USSR nuclear stockpiles'
                    };
                    var subtitle = {
                        text: 'Source: <a href="http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf">' +
                        'thebulletin.metapress.com</a>'
                    };
                    var xAxis = {

                        allowDecimals: false,
                        labels: {
                            formatter: function () {
                                return this.value; // clean, unformatted number for year
                            }
                        }
                    };
                    var yAxis = {
                        title: {
                            text: 'Nuclear weapon states'
                        },
                        labels: {
                            formatter: function () {
                                return this.value / 1000 + 'k';
                            }
                        }
                    };
                    var tooltip = {
                        pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
                    };
                    var plotOptions = {
                        area: {
                            pointStart: 1940,
                            marker: {
                                enabled: false,
                                symbol: 'circle',
                                radius: 2,
                                states: {
                                    hover: {
                                        enabled: true
                                    }
                                }
                            }
                        }
                    };
                    var series= [{
                        name: 'USA',
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

    function goumai(){


        location.href= "<%=request.getContextPath()%>/wychao/Excel"

    }
</script>
</body>
</html>