<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    
</head>


<body>
      
      <div id="container"></div>
      
      
      <script type="text/javascript">
 
      $.ajax({
			url : '<%=request.getContextPath()%>/wychao/querydianji',
			type : 'post',
			datatype : 'json',
			async : true,
			success : function(list) {
				list = eval('('+list+')')
		
				$(document).ready(function() {  
			    	   var chart = {
			    	      type: 'column'
			    	   };
			    	   var title = {
			    	      text: '月销售额'   
			    	   };
			    	   var subtitle = {
			    	      text: 'Source: jk.com'  
			    	   };
			    	   var xAxis = {
			    	      categories: list.xlist,
			    	      crosshair: true
			    	   };
			    	   var yAxis = {
			    	      min: 0,
			    	      title: {
			    	         text: '月销售额 '         
			    	      }      
			    	   };
			    	   var tooltip = {
			    	      headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			    	      pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			    	         '<td style="padding:0"><b>{point.y:1f} RMB</b></td></tr>',
			    	      footerFormat: '</table>',
			    	      shared: true,
			    	      useHTML: true
			    	   };
			    	   var plotOptions = {
			    	      column: {
			    	         pointPadding: 0.2,
			    	         borderWidth: 0
			    	      }
			    	   };  
			    	   var credits = {
			    	      enabled: false
			    	   };
			    	   
			    	   var series= [{
			    	        name: '月销售额 ',
			    	            data: list.ylist,
			    	        }];     
			    	      
			    	   var json = {};   
			    	   json.chart = chart; 
			    	   json.title = title;   
			    	   json.subtitle = subtitle; 
			    	   json.tooltip = tooltip;
			    	   json.xAxis = xAxis;
			    	   json.yAxis = yAxis;  
			    	   json.series = series;
			    	   json.plotOptions = plotOptions;  
			    	   json.credits = credits;
			    	   $('#container').highcharts(json);
			    	  
			    	});
			}
		})
		
		
      </script>
      
</body>
</html>