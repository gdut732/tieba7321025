<%@page import="cn.bean.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta charset="UTF-8">
<title>渔夫社交网</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	var index;

	window.onresize = function() {
		var html = document.getElementsByTagName("html")[0];
		var width = window.innerWidth;
		var font_Size = 16 / 1920 * width;
		html.style.fontSize = font_Size + "px";
	};
	$(function() {
		$(".naviItem").bind({
			mouseover : function() {
				$(this).css("background", "rgb(159,211,233)");
			},
			mouseout : function() {
				$(this).css("background", "none");
			}
		});
		$("#toindex").click(function() {
			window.location.href = "Index.do";
		});
		$("#login").click(function() {
			/*show_Win('div_Test', 'title', event);*/
			var s_Width = document.documentElement.scrollWidth; //滚动 宽度
			var s_Height = document.documentElement.scrollHeight; //滚动 高度
			var js_Title = $(document.getElementById("loginview")); //标题
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
			var msgObj = $("#" + "div_Test");
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
		$("#exitbt").click(function() {
			$("#div_Test").css("display", "none");
			$("#div_Bg").css("display", "none");
		});
		$("#register").click(function() {
			location.href = "Register.do";
		});
		/* $("#problem").click(function() {
			alert("反馈问题");
		}); */
		$("#logout").click(function() {
			//location.href="Index.do?user=0";
			var s = confirm("请问你是否要退出登录吗？");
			if (s) {
				location.href = "Index.do?user=0";
			}
		});
		$("#newmsg").click(function() {
			location.href="Homepage.do";
		});
		$(".t2").bind({
			click : function() {
				//$(this).children("div").html("<ul><li>1</li><li>2</li><li>3</li><li>4</li></ul>");
				var t = this;
				$("#fishlabel" + $(t).val()).siblings("div").html("");
				$.ajax({
					type : "post",
					url : "Index.ajax?lno=" + $(t).val(),
					dataType : "Text",
					success : function(msg) {
						//	alert(msg);
						//$(t).children("div").html(msg);
						$("#fishlabel" + $(t).val()).html(msg);
						//$(t).html(msg);
					},
					error : function() {

					}
				});
			}
		});
		$(".t3").live({
			click : function() {
				location.href="FishPound.do?fno="+$(this).val();
			}
		});
		$(".heat").click(function(){
			location.href="Topic11.do?tno="+$(this).val();
		});
		$("#heat").bind({
			click : function() {
				$(this).css("background", "rgb(159,211,233)");
				$(this).siblings().css("background", "none");
			},
			mouseover : function() {
				$(this).css("border-top", "1px solid rgb(74,79,109)");
			},
			mouseout : function() {
				$(this).css("border-top", "none");
			}
		});
		$("#ucare").bind({
			click : function() {
				$(this).css("background", "rgb(159,211,233)");
				$(this).siblings().css("background", "none");
			},
			mouseover : function() {
				$(this).css("border-top", "1px solid rgb(74,79,109)");
			},
			mouseout : function() {
				$(this).css("border-top", "none");
			}
		});
		$(".heat").bind({
			mouseover : function() {
				$(this).css("background", "rgb(159,211,233)");
			},
			mouseout : function() {
				$(this).css("background", "none");
			}
		});
		$("#searchbt").click(function() {
			var tx = $("#searchtext").val();
			var pno = $("#fishpoundno").val();
			$
					.ajax({
						scriptCharset : "utf-8",
						contentType : "application/x-www-form-urlencoded;charset=utf-8",
						type : "get",
						url : "Index.ajax?likename=" + tx
								+ "&pno=" + pno,
						success : function(data) {
							$("#content").html(data);
						}
					});
		});
		$("#sure").click(
				function() {
					var $name = $("#accountnum").val();
					var $pwd = $("#pwd").val();
					$("#loginInfo").html("");
					$
							.ajax({
								type : "post",
								url : "Login.ajax?accountnum=" + $name
										+ "&pwd=" + $pwd,
								dataType : "Text",
								success : function(msg) {
									if (msg == 1) {
										alert("登录成功!");
										$("#div_Test").css("display", "none");
										$("#div_Bg").css("display", "none");
										//	window.location.href ="Index.do?accountnum="+$name+"&pwd="+$pwd;
										//location.href="Index.do?accountnum="+$name+"&pwd="+$pwd;
										$.ajax({
											type : "POST",
											url : "Index.do?accountnum="
													+ $name + "&pwd=" + $pwd,
											success : function(data) {
												location.href = "Index.do";
											}
										});
									} else {
										$("#loginInfo").html(msg);
									}
								},
								error : function() {
									alert("asd");
								}
							});
					/*  $("#loginInfo").load("Login.ajax","accountnum="+$name+"&pwd="+$pwd,function(response,status,xhr){
						
						 if(xhr.responseText==1){
							alert("登录成功!");
							$("#div_Test").css("display","none");
					    	$("#div_Bg").css("display","none");
					    	
					    	//location.href="Index.do?accountnum="+$name+"&pwd="+$pwd;
					    	
						 }else{
							 $(this).html(xhr.responseText);
						 }
						
					 }); */
				});
		$("#nowtop1nextpage").click(
				function() {
					var num = $("#nowtop1indexpage").val();
					var maxpage = $("#nowtop1maxpage").val();
					num = parseInt(num) + 1;
					if (num <= maxpage) {
						$("#nowtop1indexpage").val(num);
						$("#nowindexpage").html(num);
						//alert(num);
						$("#content").load("Index.ajax", "page=" + num,
								function(response, status, xhr) {
									$(this).html(xhr.responseText);
								});
					} else {
						alert("没有下一页了");
					}

				});

		$("#nowtop1parpage").click(
				function() {
					var num = $("#nowtop1indexpage").val();
					//alert($num);
					num = parseInt(num) - 1;
					if (num != 0) {
						$("#nowtop1indexpage").val(num);
						//alert(num);
						$("#nowindexpage").html(num);
						$("#content").load("Index.ajax", "page=" + num,
								function(response, status, xhr) {
									$(this).html(xhr.responseText);
								});
					} else {
						alert("没有上一页了");
					}

				});
		$("#fistpage").click(
				function() {
					$("#nowtop1indexpage").val(1);
					//alert(num);
					$("#nowindexpage").html(1);
					$("#content").load("Index.ajax", "page=1",
							function(response, status, xhr) {
								$(this).html(xhr.responseText);
							});
				});
		$("#lastpage").click(
				function() {
					var maxpage = $("#nowtop1maxpage").val();
					$("#nowtop1indexpage").val(maxpage);
					//alert(num);
					$("#nowindexpage").html(maxpage);
					$("#content").load("Index.ajax", "page=" + (maxpage),
							function(response, status, xhr) {
								$(this).html(xhr.responseText);
							});
				});
		$("#userinfo").click(function(){
			location.href="Homepage.do";
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
			$("#feedback").css("display", "none");
			$("#div_Bg").css("display", "none");
		});
		$(".otheruserid").live({
			click:function(){
				var uno2 = $(this).attr("id");
				if(${User!=null})
				{
					location.href="Otheruser.do?uno2="+uno2;
				}
				else
				{
					alert("请先登录");
				}
			}
		});
	});
</script>
</head>

<body>
	<div id="head">
		<div id="headinner">
			<ul id="headnavi">
				<li id="problem" class="naviItem">反馈问题</li>
				<c:choose>
					<c:when test="${User!=null}">
						<li id="logout" class="naviItem">注销</li>
						<c:if test="${MsgSum!=null}">
							<li id="newmsg" class="naviItem">消息[<a id="newmsgnum">${MsgSum}</a>]条</li>
						</c:if>
						
					</c:when>
					<c:otherwise>
						<li id="register" class="naviItem">注册</li>
						<li id="login" class="naviItem">登录</li>
					</c:otherwise>
				</c:choose>
				<li id="toindex" class="naviItem">首页</li>
			</ul>
		</div>
		<hr id="headline" />
		<div id="headsearch">
			<center>
				<div id="searchmod">
					<input id="searchtext" type="text" /> <input id="searchbt"
						type="button" value="搜索" />
				</div>
			</center>
		</div>
	</div>
	<div id="body">
		<div id="left">
			<c:if test="${User!=null}">
				<div id="userinfo">
					<img id="headimg" src="upload/${User.uheadimg }" /><br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID： <label id="uno">${User.uno}</label>
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<a id="uname">${User.uname}</a><br />
				</div>
			</c:if>

			<div id="label">
				<div id="t1">鱼塘大类&nbsp;————————</div>
				<hr id="headline" />
				<ul>
					<c:forEach var="labellist" items="${LabelList}">
						<li class="t2" value="${labellist.lno}">${labellist.name}</li>
						<div id="fishlabel${labellist.lno}"></div>
						<hr id="headline" />
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="middle">
			<div id="sub_navi_list">
				<ul>
					<li id="heat">最新推荐</li>
					<!-- <li id="ucare">个性话题</li> -->
				</ul>
			</div>
			<div id="content">
				<c:forEach var="top1list" items="${NowTop1List}">
					<table class="topic1">
						<tr>
							<td class="fishpound">${top1list.fp.title}</td>
						</tr>
						<tr>
							<td class="title"><a href="Topic11.do?tno=${top1list.tno}">${top1list.title}</a></td>
						</tr>
						<tr>
							<td>${top1list.content}<br /> 
							<c:forEach var="imglist" items="${top1list.imagesrc}">
								<img src="upload/${imglist}" /> 
							</c:forEach>
							
							</td>
						</tr>
						<tr>
							<td class="speaker">话题发起者：<a id="${top1list.uno.uno}" class="otheruserid">${top1list.uno.uname}</a></td>
						</tr>
						<tr>
							<td>
								<hr class="topicline" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<div id="footer">
					<p>攻城狮：Awesome—stanlance</p>
				</div>
			</div>
			<center>

				<a id="fistpage">首页</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a id="nowtop1parpage">上一页</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <input id="nowtop1indexpage" type="hidden" value="${NowTop1Listpb.pageIndex}" />
				<input id="nowtop1maxpage" type="hidden" value="${NowTop1Listpb.pageCount}" />第<label id="nowindexpage">${NowTop1Listpb.pageIndex}</label>/<label>${NowTop1Listpb.pageCount}</label>页&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="nowtop1nextpage">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="lastpage">末页</a>
			</center>
			
		</div>

		<div id="right">
			<div id="heatTopichead">热议榜</div>
			<div id="heatTopiccontent">
				<ul>
				<% int i=1; %>
					<c:forEach var="topic1list"  items="${HotTop1List}">
						<li class="heat" value="${topic1list.tno}"><%=i++%>. ${topic1list.title}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>

	<div id="div_Test">
		<div id="loginview">
			<div id="exit">
				<input type="button" id="exitbt" value="X" />
			</div>
			<form action="" method="post">
				<table>
					<th colspan="2">登录</th>
					<tr>
						<td>账号：</td>
						<td><input type="text" id="accountnum" name="accountnum"
							value="" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" id="pwd" name="pwd" value="" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" id="sure" value="登录" />
							<input type="button" id="cancel" value="去注册" /></td>
					</tr>
				</table>
				<div id="loginInfo"></div>
			</form>
		</div>
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