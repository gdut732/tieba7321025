<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${user2.uname}的主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/otheruser.css">
	<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			if(${isfocus==1})
			{
				$("#cancelfocus").css("display","block");
				$("#surefocus").css("display","none")
			}
			else
			{
				$("#cancelfocus").css("display","none");
				$("#surefocus").css("display","block");
				;
			}
			$(".naviItem").bind({
				mouseover:function()
				{
					$(this).css("background","rgb(159,211,233)");
				},
				mouseout:function()
				{
					$(this).css("background","none");
				}
			});
			$("#cancelfocus").click(function()
			{
				var uno2 = $("#u2id").text();
				$.ajax({
					type:"post",
					url:"FocusUser.ajax",
					data:"flag=del&uno2="+uno2,
					dataType:"Text",
					success:function(msg)
					{
						if(msg=="ok")
						{
							alert("取关成功");
							$("#cancelfocus").css("display","none");
							$("#surefocus").css("display","block");
						}
						else
						{
							alert("取关失败");
						}
					},
					error:function()
					{
						alert("出错了！");
					}
				});
				
			});
			$("#surefocus").click(function()
			{
				var uno2 = $("#u2id").text();
				$.ajax({
					type:"post",
					url:"FocusUser.ajax",
					data:"flag=add&uno2="+uno2,
					dataType:"Text",
					success:function(msg)
					{
						if(msg=="ok")
						{
							alert("关注成功");
							$("#cancelfocus").css("display","block");
							$("#surefocus").css("display","none");
						}
						else
						{
							alert("关注失败");
						}
					},
					error:function()
					{
						alert("出错了！");
					}
				});
				
			});
			$("#toindex").click(function(){
				window.location.href="Index.do";
			});
			$("#logout").click(function(){
				var s = confirm("请问你是否要退出登录吗？");
				if (s) {
					location.href = "Index.do?user=0";
				}
			});
				//问题反馈
			$("#problem").click(function() {
				/*show_Win('div_Test', 'title', event);*/
				var s_Width = document.documentElement.scrollWidth; //滚动 宽度
				var s_Height = document.documentElement.scrollHeight; //滚动 高度
				var js_Title = $(document.getElementById("feedbackview")); //标题
				js_Title.css("cursor", "move");
				//创建遮罩层
				$("<div id=\"div_Bg\"></div>").css({
					"position" : "absolute",
					"left" : "0px",
					"right" : "0px",
					"width" : s_Width + "px",
					"height" : s_Height + "px",
					"background-color" : "#ffffff",
					"opacity" : "0.6"
				}).prependTo("body");
				//获取弹出层
				var msgObj = $("#" + "feedback");
				msgObj.css('display', 'block'); //必须先弹出此行，否则msgObj[0].offsetHeight为0，因为"display":"none"时，offsetHeight无法取到数据；如果弹出框为table，则为'',如果为div，则为block，否则textbox长度无法充满td
				//y轴位置
				var js_Top = -parseInt(msgObj.height()) / 2 + "px";
				//x轴位置
				var js_Left = -parseInt(msgObj.width()) / 2 + "px";
				msgObj.css({
					"margin-left" : js_Left,
					"margin-top" : js_Top
				});
				//使弹出层可移动
				msgObj.draggable({
					handle : js_Title,
					scroll : false
				});
			});
			
			$("#feedbackexbt").click(function() {
				$("#feedback").css("display", "none");
				$("#div_Bg").css("display", "none");
			});
			$("#sure1").click(function(){
				var s=confirm("感谢您的建议与意见，我们必定更加努力！谢谢！");
				if(s){
					location.href="Index.do";
				}
			});
			$("#cancel1").click(function(){
				location.href="Index.do";
			});
		});
		</script>
  </head>
  
  <body>
    <div id="head">
			<div id="headinner">
				<ul id="headnavi">
					<li id="problem" class="naviItem">反馈问题</li>
					<li id="logout" class="naviItem">注销</li>
					<li id="toindex" class="naviItem">首页</li>
				</ul>
			</div>
			<hr id="headline"/>
			<div id="headsearch">
			</div>
		</div>
		<div id="body">
			<div id="userinfo">
				<div id="userinfohead">
					<div id="headimg">
						<img src="upload/${user2.uheadimg}"/>
					</div>
				</div>
				<div id="userinfom">
					<div id="focus">
							<input type="button" class="focusbt" id="cancelfocus" value="取消关注" style="display:none" />
							<input type="button" class="focusbt" id="surefocus" value="关注" style="display:none"/>
					</div>
					<div id='u2id' style="display:none">${user2.uno}</div>
					<div id="uname">
						${user2.uname}
					</div>
					<div id="otherinfo">
						<span id="sex" class="otherinfospan">性别：${ui2.sex}</span>
						<span class="userinfo_split"></span>
						<span id="age" class="otherinfospan">创建日期：${ui2.createDate}</span>
						<span class="userinfo_split"></span>
					</div>
				</div>
			</div>
			<div id="usercontent">
				<div id="uleft">
					<div id="navi_item">
						最新动态
					</div>
					<div id="navi_content">
						<div id="mycollectV" class="navi_content" style="display: block;">
						<c:forEach var="t1" items="${pb.list}">
							<table class="topic1">
								<tr>
									<td class="fishpound">${t1.fp.title}</td>
								</tr>
								<tr>
									<td class="title"><a href="Topic11.do?tno=${t1.tno}">${t1.title}</a></td>
								</tr>
								<tr>
									<td>
										${t1.content}
									</td>
								</tr>
								<tr>
									<td class="speaker">话题发起者：${user2.uname}</td>
								</tr>
							</table>
							<hr class="topicline" />
						</c:forEach>
						<hr class="topicline" />
						</div>
					</div>		
				</div>
		</div>
			
		</div>
		<div id="footer">
					<p>攻城狮：Awesome—stanlance</p>
		</div>
		<div id="feedback">
		<div id="feedbackview">
			<div id="exitfee">
				<input type="button" id="feedbackexbt" value="X" />
			</div>
			<form action="" method="post">
				<table>
					<th colspan="2" >问题反馈</th>
					<tr>
						<td >类型：</td>
						<td><select>
							<option>请选择</option>
							<option>垃圾网站</option>
							<option>服务延迟</option>
							<option>优质报错</option>
							<option>其他</option>	
						</select> 
						</td>
						
					</tr>
					
					<tr>
						<td>描述：</td>
						<td><textarea rows="" cols="" style="height: 66px;width: 180px;"></textarea></td>
					</tr>
					<tr><td>&nbsp;<td></tr>
					<tr>
						<td colspan="2">
							<input type="button" id="sure1" value="提交" />
							<input type="button" id="cancel1" value="取消" /></td>
					</tr>
				</table>
				<div id="feebackInfo"></div>
			</form>
		</div>
	</div>
  </body>
</html>
