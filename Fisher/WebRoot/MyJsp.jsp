<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			$("#nowtop1nextpage").click(
						function() {
					/* 		var num = $("#nowtop1indexpage").val();
							var pno=$("#fishpoundno").val();
							var maxpage = $("#nowtop1maxpage").val();
							num = parseInt(num) + 1;
							
							if (num < maxpage) {
								$("#nowtop1indexpage").val(num);
								$("#nowindexpage").html(num);
								alert(maxpage);
								$("#content").load("http://www.baidu.com","page="+num+"&pno="+pno,function(response, status, xhr) {
											$(this).html(xhr.responseText);
										}); 
							} else {
								alert("没有下一页了");
							} */
							//alert("没有下一页了");
							window.location.href("www.baidu.com"); 
							/* $("#content").load("http://www.baidu.com","page=1",function(response, status, xhr) {
								$(this).html(xhr.responseText);
							});  */
						});
		});
		
	</script>
  </head>
  
  <body>
    <a id="nowtop1nextpage">下一页</a>
  </body>
</html>
