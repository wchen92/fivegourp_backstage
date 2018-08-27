<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>Insert title here</title>
</head>
<body>
<input class="easyui-button width_80 l-btn l-btn-small" type='button'onclick="guanggaoss()" value="导出">
<div id="container5" style="width: 350px; height: 200px; margin: 0 auto"></div>
<div id="container4" style="width: 550px; height: 400px; margin: 0 auto"></div>

<script language="JavaScript">
    $(function () {
        /*
         * Get the current time
         */
        function getNow() {
            var now = new Date();
            return {
                hours: now.getHours() + now.getMinutes() / 60,
                minutes: now.getMinutes() * 12 / 60 + now.getSeconds() * 12 / 3600,
                seconds: now.getSeconds() * 12 / 60
            };
        }
        /*
         * Pad numbers
         */
        function pad(number, length) {
            // Create an array of the remaining length + 1 and join it with 0's
            return new Array((length || 2) + 1 - String(number).length).join(0) + number;
        }
        var now = getNow();
        // Create the chart
        $('#container5').highcharts({
                chart: {
                    type: 'gauge',
                    plotBackgroundColor: null,
                    plotBackgroundImage: null,
                    plotBorderWidth: 0,
                    plotShadow: false,
                    height: 200
                },
                credits: {
                    enabled: false
                },
                title: {
                    text: ''
                },
                pane: {
                    background: [{
                        // default background
                    }, {
                        // reflex for supported browsers
                        backgroundColor: Highcharts.svg ? {
                            radialGradient: {
                                cx: 0.5,
                                cy: -0.4,
                                r: 1.9
                            },
                            stops: [
                                [0.5, 'rgba(255, 255, 255, 0.2)'],
                                [0.5, 'rgba(200, 200, 200, 0.2)']
                            ]
                        } : null
                    }]
                },
                yAxis: {
                    labels: {
                        distance: -20
                    },
                    min: 0,
                    max: 12,
                    lineWidth: 0,
                    showFirstLabel: false,
                    minorTickInterval: 'auto',
                    minorTickWidth: 1,
                    minorTickLength: 5,
                    minorTickPosition: 'inside',
                    minorGridLineWidth: 0,
                    minorTickColor: '#666',
                    tickInterval: 1,
                    tickWidth: 2,
                    tickPosition: 'inside',
                    tickLength: 10,
                    tickColor: '#666',
                    title: {
                        text: 'Powered by<br/>Highcharts',
                        style: {
                            color: '#BBB',
                            fontWeight: 'normal',
                            fontSize: '8px',
                            lineHeight: '10px'
                        },
                        y: 10
                    }
                },
                tooltip: {
                    formatter: function () {
                        return this.series.chart.tooltipText;
                    }
                },
                series: [{
                    data: [{
                        id: 'hour',
                        y: now.hours,
                        dial: {
                            radius: '60%',
                            baseWidth: 4,
                            baseLength: '95%',
                            rearLength: 0
                        }
                    }, {
                        id: 'minute',
                        y: now.minutes,
                        dial: {
                            baseLength: '95%',
                            rearLength: 0
                        }
                    }, {
                        id: 'second',
                        y: now.seconds,
                        dial: {
                            radius: '100%',
                            baseWidth: 1,
                            rearLength: '20%'
                        }
                    }],
                    animation: false,
                    dataLabels: {
                        enabled: false
                    }
                }]
            },
            // Move
            function (chart) {
                setInterval(function () {
                    now = getNow();
                    var hour = chart.get('hour'),
                        minute = chart.get('minute'),
                        second = chart.get('second'),
                        // run animation unless we're wrapping around from 59 to 0
                        animation = now.seconds === 0 ?
                            false :
                            {
                                easing: 'easeOutElastic'
                            };
                    // Cache the tooltip text
                    chart.tooltipText =
                        pad(Math.floor(now.hours), 2) + ':' +
                        pad(Math.floor(now.minutes * 5), 2) + ':' +
                        pad(now.seconds * 5, 2);
                    hour.update(now.hours, true, animation);
                    minute.update(now.minutes, true, animation);
                    second.update(now.seconds, true, animation);
                }, 1000);
            });
    });
    // Extend jQuery with some easing (copied from jQuery UI)
    $.extend($.easing, {
        easeOutElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t===0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*0.3;
            if (a < Math.abs(c)) { a=c; s=p/4; }
            else s = p/(2*Math.PI) * Math.asin (c/a);
            return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
        }
    });

    $(function(){


            test10()
    }


    )

    function test10(){
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/querygoumai",
            type: "post",
            dataType: "json",
            success: function(result) {


                $(document).ready(function () {
                    var chart = {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    };
                    var title = {
                        text: '占比'
                    };
                    var tooltip = {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    };
                    var plotOptions = {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
                                style: {
                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                }
                            }
                        }
                    };
                    var series = [{
                        type: 'pie',
                        name: '占比',
                        data: [


                            {
                                name: 'java',
                                y: 22.8,
                                sliced: true,
                                selected: true
                            },
                            {
                                name: 'ajax',
                                y: 12.8,
                                sliced: true,
                                selected: true
                            },
                            {
                                name: 'php',
                                y: 5.8,
                                sliced: true,
                                selected: true
                            },

                        ]
                    }];
                  /*  // Radialize the colors
                    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
                        return {
                            radialGradient: {cx: 0.5, cy: 0.3, r: 0.7},
                            stops: [
                                [0, color],
                                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
                            ]
                        };
                    });*/

                    var json = {};
                    json.chart = chart;
                    json.title = title;
                    json.tooltip = tooltip;
                    json.series = series;
                    json.plotOptions = plotOptions;
                    $('#container4').highcharts(json);
                });
            }})}


    function guanggaoss() {
        $.ajax({
            url: "<%=request.getContextPath()%>/wychao/queryguanggaogg",
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

</script >

</body>
</html>