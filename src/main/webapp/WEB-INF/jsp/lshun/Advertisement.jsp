<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%--<div id="p" class="easyui-panel" title="条件查询"
		        data-options="iconCls:'icon-save',collapsible:true">   
		   <center>
		   <br>
		     <input id="orsearch" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'查询广告名称'" style="width:300px">  <br> <br>
		    <a  href="javascript:querydrug()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width: 120px;height: 30px">查询</a>
		     
		   <br><br>
		   </center> 
		   	 </div>--%>
	<div id="divids"></div>	   	 
      <table id="drug"></table> 

      <div id="upde"></div>

<script type="text/javascript">
     function querydrug(){
    	 $('#drug').datagrid({    
     	    url:'<%=request.getContextPath()%>/liushun/queryAdvertisementList',
     	   queryParams: {
     		  drugname:$("#orsearch").val(),
     		},
     	    pagination:true,
     	    singleSelect:true,
     	    checkOnSelect:false,
     	    selectOnCheck:false,
     	    pageNumber:1,
     	    pageSize:3,
     	    pageList:[3,5,10],
     	   toolbar: [{
   			iconCls: 'icon-add',
   			handler: function(){
   				$("#divids").dialog({
  			 	title: 'dialog的使用',    
  			    width: 300,    
  			    height: 300, 
  			    
  			    resizable:true,	
  		    	//closed: true,    
  			    href: '<%=request.getContextPath()%>/linshuiindex/InsertAdvertisement',
  			    modal: true ,
  			    buttons:[{
  					text:'保存',
  					handler:function(){

  						$.ajax({
  							  url:"<%=request.getContextPath()%>/liushun/InsertAdvertisementList",
  							  data:$("#shopforms").serialize(),
  						    	type:"post",
  						    	datatype:'json',
  						    	
  							  success:function(result){
  								if(result ==1 ){
  									querydrug();
  									$("#divids").dialog('close');
  								}
  							  }  
  						});
  							  
  					}
  				},{
  					text:'关闭',
  					handler:function(){
  						
  						$("#divids").dialog('close');
  					}
  				}]
  		})
  		}
   		},'-',{
   			iconCls: 'icon-remove',
   			handler: function(){
   					var arr=$('#drug').datagrid('getChecked');
   					var ids="";
   					var count=0;
   					for(var i=0;i<arr.length;i++){
                        ids+=",'"+arr[i]['guanggaoid']+"'";
   						count++;
   					}
   					ids=ids.substring(1);
					 if(confirm("你确定删除"+count+"条信息吗")){
  					$.ajax({
  						  url:"<%=request.getContextPath()%>/liushun/DeleteAdvertisementList",
  					    data:{ids:ids},
  					    	type:"post",
  					    	datatype:'json',
  					    	
  						  success:function(result){
  							if(result ==1 ){
  								querydrug();
  							}
  						  }  
  					});
					 }  
   			}
   		}],

     	    columns:[[    
           	         	{field:'userchek',checkbox:true}, 
              	       /* {field:'guanggaoid',title:'广告编号',width:100},*/
              	        {field:'money',title:'广告价格',width:100,
              	        },
              	        {field:'guanggaodate',title:'广告时间',width:100,
                            formatter : function(value){
                                var date = new Date(value);
                                var y = date.getFullYear();
                                var m = date.getMonth() + 1;
                                var d = date.getDate();
                                return y + '-' +m + '-' + d;
                            }
						},
               		 {
                    field: 'zhanshistatus', title: '展示状态', width: 100,
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return "<font color='blue'>已审核</font>";
                        }
                        if (value == 2) {
                            return "<font color='red'>未审核</font>";
                        }

                    }
                },
                	{field:'chuliren',title:'处理人',width:100},
                {field:'guanggaophoto',title:'图片展示',width:100,

                    formatter: function(value,row,index){

                        return "<img width='50' height='50'  src='"+row.guanggaophoto+"' / >";

                    }
                },
              	       {field:'act',title:'操作',width:100,
                	        	formatter: function(value,row,index){
                	        		
                	        		return "<a onclick='updatedrug(\""+row.guanggaoid+"\")'  class='icon-edit' >&nbsp;&nbsp;&nbsp;&nbsp;</a>";
                	  		}
                  	      }
                  	    ]]    
                  	});  
                  }
     
     $(function(){
    	 querydrug();
      });
     function updatedrug(id){
      	  alert(id)
      	  $("#upde").dialog({
      		 	title: 'dialog的使用',    
      		    width: 300,    
      		    height: 300, 
      		    
      		    resizable:true,	
      	    	//closed: true,    
      		    href: '<%=request.getContextPath()%>/linshuiindex/queryAdvertisementById?id='+id,
      		    modal: true ,
      		    buttons:[{
      				text:'保存',
      				handler:function(){

      					$.ajax({
      						  url:"<%=request.getContextPath()%>/liushun/UpdateAdvertisement",
      						  data:$("#char_forms").serialize(),
      					    	type:"post",
      					    	datatype:'json',
      					    	
      						  success:function(result){
      							if(result ==1 ){
      								querydrug();
      								$("#upde").dialog('close');
      							}
      						  }  
      					});
      						  
      				}
      			},{
      				text:'关闭',
      				handler:function(){
      					
      					$("#upde").dialog('close');
      				}
      			}]
      				})
      				}
     </script>
     
</body>
</html>