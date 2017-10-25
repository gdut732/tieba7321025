<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <html>
	<head>
		<meta charset="UTF-8">
		<title>${topic.fp.title}塘</title>
		<link rel="stylesheet" type="text/css" href="css/topic1.css">
		<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var index;
			var tno2=0;
			var listType=1;
			window.onresize=function(){
				var html=document.getElementsByTagName("html")[0];
				var width=window.innerWidth;
				var font_Size=16/1920*width;
				html.style.fontSize=font_Size+"px";
				};	
			$(function(){
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
				$("#toindex").click(function(){
					window.location.href="Index.do";
				});
				$("#login").click(function(){
					
					var s_Width = document.documentElement.scrollWidth; //滚动 宽度
		            var s_Height = document.documentElement.scrollHeight; //滚动 高度
		            var js_Title = $(document.getElementById("loginview")); //标题
		            js_Title.css("cursor", "move");
		            //创建遮罩层
		            $("<div id=\"div_Bg\"></div>").css({ "position": "absolute", "left": "0px", "right": "0px", "width": s_Width + "px", "height": s_Height + "px", "background-color": "#ffffff", "opacity": "0.6" }).prependTo("body");
		            //获取弹出层
		            var msgObj = $("#" + "div_Test");
		            msgObj.css('display', 'block'); //必须先弹出此行，否则msgObj[0].offsetHeight为0，因为"display":"none"时，offsetHeight无法取到数据；如果弹出框为table，则为'',如果为div，则为block，否则textbox长度无法充满td
		            //y轴位置
		            var js_Top = -parseInt(msgObj.height()) / 2 + "px";
		            //x轴位置
		            var js_Left = -parseInt(msgObj.width()) / 2 + "px";
		            msgObj.css({ "margin-left": js_Left, "margin-top": js_Top });
		            
				});
				$("#exitbt").click(function(){
		        	$("#div_Test").css("display","none");
		        	$("#div_Bg").css("display","none");
		        });
				$("#register").click(function(){
					location.href = "Register.do";
				});
				/* $("#problem").click(function(){
					alert("反馈问题");
				}); */
				$("#logout").click(function(){
					var s = confirm("请问你是否要退出登录吗？");
					if (s) {
						location.href = "Index.do?user=0";
					}
				});
				$("#newmsg").click(function(){
					alert("消息页");
				});
				$("#searchbt").click(function(){
					var t = $("#searchtext").val();
					alert(t);
				});
				$("#cancelfocus").click(function(){
					$("#surefocus").css("display","block");
					$("#cancelfocus").css("display","none");
				});
				$("#surefocus").click(function(){
					$("#surefocus").css("display","none");
					$("#cancelfocus").css("display","block");
				});
				$(".headpage").click(function(){
					var tno=$("#tno1").text();
					var nowpage = $("#nowpage").text();
					//alert(listType);
					if(nowpage==1)
					{
						alert("已经是首页了");
					}
					else
					{
						var pageIndex = parseInt(nowpage);
						$.ajax({
							type:"post",
							url:"Topic1.ajax",
							data:"tno="+tno+"&pageIndex="+pageIndex+"&listType="+listType,
							dataType:"json",
							success:function(msg){
								/* $("#topic2list").html(msg); */
								/* alert(msg.list.length); */
								$("#topic2list").html("");
								for(var i=0;i<msg.length;i++)
								{
									$("#topic2list").append("<table class='topic1'><tr>"+"<td rowspan='4' class='speakerinfo'><img src='upload/"+msg[i].uno.uheadimg+"' class='speakerimg'/>"
											+"<p><a id='"+msg[i].uno.uno+"' class='otheruserid'>"+msg[i].uno.uname+"</a></p></td></tr><tr><td>"+msg[i].content+"</td></tr><tr><td>"
											+"<span class='speaker' id='lookreply' style='float: right;'>"
											+"<span style='display:none'>"+msg[i].tno+"</span><button type='button' class='lookreply' >查看回复</button></span>"
											+"<span class='speaker' id='dislookreply' style='float: right;'><button type='button' class='dislookreply' style='display: none'>收起回复</button></span>"
											+"<span class='speaker' style='float: right;'>回复时间："+msg[i].createdate+"</span><br />"
											+"<div class='replycontent' style='display: none;'>"
											+"<div class='topic3rely'>"
											+"<input type='text' class='t3reply' value='' /><br/>"
											+"<input type='button' class='t3replybt' value='回复' /></div>"
											+"</div></td></tr></table>"
											+"<hr class='topicline'/>");
									
									
								}
								$("#nowpage").html(pageIndex); 
								
							},
							error:function(){
								$("#topic2list").html("出错了");
							}
						});
					}
				});
				$(".previous").click(function(){
					var tno=$("#tno1").text();
					var nowpage = $("#nowpage").text();
				//	alert(listType);
					if(nowpage==1)
					{
						alert("已经是第一页了");
					}
					else
					{
						var pageIndex = parseInt(nowpage)-1;
						$.ajax({
							type:"post",
							url:"Topic1.ajax",
							data:"tno="+tno+"&pageIndex="+pageIndex+"&listType="+listType,
							dataType:"json",
							success:function(msg){
								$("#topic2list").html("");
								for(var i=0;i<msg.length;i++)
								{
									$("#topic2list").append("<table class='topic1'><tr>"
											+"<td rowspan='4' class='speakerinfo'><img src='upload/"+msg[i].uno.uheadimg+"' class='speakerimg'/>"
											+"<p><a id='"+msg[i].uno.uno+"' class='otheruserid'>"+msg[i].uno.uname+"</a></p></td></tr><tr><td>"+msg[i].content+"</td></tr><tr><td>"
											+"<span class='speaker' id='lookreply' style='float: right;'>"
											+"<span style='display:none'>"+msg[i].tno+"</span><button type='button' class='lookreply' >查看回复</button></span>"
											+"<span class='speaker' id='dislookreply' style='float: right;'><button type='button' class='dislookreply' style='display: none'>收起回复</button></span>"
											+"<span class='speaker' style='float: right;'>回复时间："+msg[i].createdate+"</span><br />"
											+"<div class='replycontent' style='display: none;'>"
											+"<div class='topic3rely'>"
											+"<input type='text' class='t3reply' value='' /><br/>"
											+"<input type='button' class='t3replybt' value='回复' /></div>"
											+"</div></td></tr></table>"
											+"<hr class='topicline'/>");
								}
								$("#nowpage").html(pageIndex); 
								
							},
							error:function(){
								$("#topic2list").html("出错了");
							}
						});
					}
				});
				$(".next").click(function(){
					var tno=$("#tno1").text();
					var nowpage = $("#nowpage").text();
					var maxpage = $("#maxpage").text();
				//	alert(listType);
					if(nowpage==maxpage)
					{
						alert("已经是最后一页了");
					}
					else
					{
						var pageIndex = parseInt(nowpage)+1;
						$.ajax({
							type:"post",
							url:"Topic1.ajax",
							data:"tno="+tno+"&pageIndex="+pageIndex+"&listType="+listType,
							dataType:"json",
							success:function(msg){
								$("#topic2list").html("");
								for(var i=0;i<msg.length;i++)
								{
									$("#topic2list").append("<table class='topic1'><tr>"
											+"<td rowspan='4' class='speakerinfo'><img src='upload/"+msg[i].uno.uheadimg+"' class='speakerimg'/>"
											+"<p><a id='"+msg[i].uno.uno+"' class='otheruserid'>"+msg[i].uno.uname+"</a></p></td></tr><tr><td>"+msg[i].content+"</td></tr><tr><td>"
											+"<span class='speaker' id='lookreply' style='float: right;'>"
											+"<span style='display:none'>"+msg[i].tno+"</span><button type='button' class='lookreply' >查看回复</button></span>"
											+"<span class='speaker' id='dislookreply' style='float: right;'><button type='button' class='dislookreply' style='display: none'>收起回复</button></span>"
											+"<span class='speaker' style='float: right;'>回复时间："+msg[i].createdate+"</span><br />"
											+"<div class='replycontent' style='display: none;'>"
											+"<div class='topic3rely'>"
											+"<input type='text' class='t3reply' value='' /><br/>"
											+"<input type='button' class='t3replybt' value='回复' /></div>"
											+"</div></td></tr></table>"
											+"<hr class='topicline'/>");
								}
								$("#nowpage").html(pageIndex); 
								
							},
							error:function(){
								$("#topic2list").html("出错了");
							}
						});
						
					}
				});
				$(".lastpage").click(function(){
					var tno=$("#tno1").text();
					var nowpage = $("#nowpage").text();
					var maxpage = $("#maxpage").text();
					//alert(listType);
					if(nowpage==maxpage)
					{
						alert("已经是尾页了");
					}
					else
					{
						var pageIndex = parseInt(maxpage);
						$.ajax({
							type:"post",
							url:"Topic1.ajax",
							data:"tno="+tno+"&pageIndex="+pageIndex+"&listType="+listType,
							dataType:"json",
							success:function(msg){
								$("#topic2list").html("");
								for(var i=0;i<msg.length;i++)
								{
									$("#topic2list").append("<table class='topic1'><tr>"
											+"<td rowspan='4' class='speakerinfo'><img src='upload/"+msg[i].uno.uheadimg+"' class='speakerimg'/>"
											+"<p><a id='"+msg[i].uno.uno+"' class='otheruserid'>"+msg[i].uno.uname+"</a></p></td></tr><tr><td>"+msg[i].content+"</td></tr><tr><td>"
											+"<span class='speaker' id='lookreply' style='float: right;'>"
											+"<span style='display:none'>"+msg[i].tno+"</span><button type='button' class='lookreply' >查看回复</button></span>"
											+"<span class='speaker' id='dislookreply' style='float: right;'><button type='button' class='dislookreply' style='display: none'>收起回复</button></span>"
											+"<span class='speaker' style='float: right;'>回复时间："+msg[i].createdate+"</span><br />"
											+"<div class='replycontent' style='display: none;'>"
											+"<div class='topic3rely'>"
											+"<input type='text' class='t3reply' value='' /><br/>"
											+"<input type='button' class='t3replybt' value='回复' /></div>"
											+"</div></td></tr></table>"
											+"<hr class='topicline'/>");
								}
								$("#nowpage").html(pageIndex); 
								
							},
							error:function(){
								$("#topic2list").html("出错了");
							}
						});
					}
				});
				$(".opera").click(function(){
					var tno=$("#tno1").text();
					alert(tno);
				});
				$("#listorder").children("option").click(function(){
					listType = $(this).val();
					var tno1=$("#tno1").text();
					$.ajax({
						type:"post",
						url:"Topic1.ajax?",
						data:"tno="+tno1+"&listType="+listType,
						dataType:"json",
						success:function(msg)
						{
							$("#topic2list").html("");
							for(var i=0;i<msg.length;i++)
							{
								$("#topic2list").append("<table class='topic1'><tr>"
										+"<td rowspan='4' class='speakerinfo'><img src='upload/"+msg[i].uno.uheadimg+"' class='speakerimg'/>"
										+"<p><a id='"+msg[i].uno.uno+"' class='otheruserid'>"+msg[i].uno.uname+"</a></p></td></tr><tr><td>"+msg[i].content+"</td></tr><tr><td>"
										+"<span class='speaker' id='lookreply' style='float: right;'>"
										+"<span style='display:none'>"+msg[i].tno+"</span><button type='button' class='lookreply' >查看回复</button></span>"
										+"<span class='speaker' id='dislookreply' style='float: right;'><button type='button' class='dislookreply' style='display: none'>收起回复</button></span>"
										+"<span class='speaker' style='float: right;'>回复时间："+msg[i].createdate+"</span><br />"
										+"<div class='replycontent' style='display: none;'>"
										+"<div class='topic3rely'>"
										+"<input type='text' class='t3reply' value='' /><br/>"
										+"<input type='button' class='t3replybt' value='回复' /></div>"
										+"</div></td></tr></table>"
										+"<hr class='topicline'/>");
							}
							$("#nowpage").html(1); 
						},
						error:function(){
							$("topic2list").html("_(:зゝ∠)_出错了");
						}
					});
				});
				$("#searchtopicbt").click(function(){
					var t = $("#searchtopic").val();
					alert(t);
					$("#navi_rs").css("display","block");
				});
				$("#fabiao").click(function(){
					if(${User!=null})
					{
						var zhengwen = $(this).siblings("textarea").val();
						var tno1=$("#tno1").text();
							location.href = "Topic2.do?textf="+zhengwen+"&tno1="+tno1;
						
					}
					else
					{
						var s_Width = document.documentElement.scrollWidth; //滚动 宽度
			            var s_Height = document.documentElement.scrollHeight; //滚动 高度
			            var js_Title = $(document.getElementById("loginview")); //标题
			            js_Title.css("cursor", "move");
			            //创建遮罩层
			            $("<div id=\"div_Bg\"></div>").css({ "position": "absolute", "left": "0px", "right": "0px", "width": s_Width + "px", "height": s_Height + "px", "background-color": "#ffffff", "opacity": "0.6" }).prependTo("body");
			            //获取弹出层
			            var msgObj = $("#" + "div_Test");
			            msgObj.css('display', 'block'); //必须先弹出此行，否则msgObj[0].offsetHeight为0，因为"display":"none"时，offsetHeight无法取到数据；如果弹出框为table，则为'',如果为div，则为block，否则textbox长度无法充满td
			            //y轴位置
			            var js_Top = -parseInt(msgObj.height()) / 2 + "px";
			            //x轴位置
			            var js_Left = -parseInt(msgObj.width()) / 2 + "px";
			            msgObj.css({ "margin-left": js_Left, "margin-top": js_Top });
					}
				});
				$(".lookreply").live(
					"click",function(){
					
					$(".replycontent").css("display","none");
					$(".lookreply").css("display","block");
					$(".dislookreply").css("display","none");
					$(this).css("display","none");
					$(this).parent().siblings("#dislookreply").children(".dislookreply").css("display","block");
					$(this).parent().siblings("div").css("display","block");
					$t = $(this).parent().siblings("div");
					tno2 = $(this).prev().text();
					 $.ajax({
						type:"post",
						url:"Topic3.ajax",
						data:"tno2="+tno2,
						dataType:"json",
						success:function(data){
							
							$t.html("");
							for(var i=0;i<data.length;i++)
							{
								if(data[i].uno2.uno==data[i].uno3.uno)
								{
									$t.append("<div><span><a class='t3user' id='"+data[i].uno1.uno+"'>"+data[i].uno1.uname+"</a> 回复：");
								}
								else
								{
									$t.append("<div><span><a class='t3user' id='"+data[i].uno1.uno+"'>"+data[i].uno1.uname+"</a> 回复：<a class='otheruser' id='"+data[i].uno2.uno+"'>"+data[i].uno2.uname+"</a>");
								}
								$t.append("<input type='button'  class='topic3' value='回复'/></span>"
										 +"<div class='topic2'>"+data[i].content+"</div></div>");
										 
							}
							$t.append("<div class='topic3rely'>"
									 +"<input type='text' class='t3reply' value='' /><br/>"
									 +"<input type='button' class='t3replybt' value='回复' /></div>");
						},
						error:function(){
							$t.html("_(:зゝ∠)_出错了");
						}
					}); 
				});
				$(".dislookreply").live(
					"click",function(){
						$(this).parent().siblings("div").css("display","none");
						$(this).parent().siblings("#lookreply").children(".lookreply").css("display","block");
						$(this).css("display","none");
				});
				$(".topic3").live(
					"click",function(){
						
						var u3 = $(this).prev("div").children().children(".t3user").text();
						$(this).siblings(".topic3rely").children(".t3reply").val("回复"+u3+":");
					}
				);
				$(".t3replybt").live(
					"click",function(){
						if(${User!=null})
						{
							var u3 = $(this).siblings(".t3reply").val();
						//	alert(1);
							 $.ajax({
									type:"post",
									url:"Addtopic3.ajax",
									data:"tno2="+tno2+"&content="+u3,
									dataType:"json",
									success:function(data){
										$t.html("");
										for(var i=0;i<data.length;i++)
										{
											if(data[i].uno2.uno==data[i].uno3.uno)
											{
												$t.append("<div><span><a class='t3user' id='"+data[i].uno1.uno+"'>"+data[i].uno1.uname+"</a> 回复：");
											}
											else
											{
												$t.append("<div><span><a class='t3user' id='"+data[i].uno1.uno+"'>"+data[i].uno1.uname+"</a id='"+data[i].uno2.uno+"'> 回复：<a>"+data[i].uno2.uname+"</a>");
											}
											$t.append("<input type='button'  class='topic3' value='回复'/></span>"
													 +"<div class='topic2'>"+data[i].content+"</div></div>");
													 
										}
										$t.append("<div class='topic3rely'>"
												 +"<input type='text' class='t3reply' value='' /><br/>"
												 +"<input type='button' class='t3replybt' value='回复' /></div>");
									},
									error:function(){
										$t.html("_(:зゝ∠)_出错了");
									}
								}); 
						}
						else
						{
							var s_Width = document.documentElement.scrollWidth; //滚动 宽度
				            var s_Height = document.documentElement.scrollHeight; //滚动 高度
				            var js_Title = $(document.getElementById("loginview")); //标题
				            js_Title.css("cursor", "move");
				            //创建遮罩层
				            $("<div id=\"div_Bg\"></div>").css({ "position": "absolute", "left": "0px", "right": "0px", "width": s_Width + "px", "height": s_Height + "px", "background-color": "#ffffff", "opacity": "0.6" }).prependTo("body");
				            //获取弹出层
				            var msgObj = $("#" + "div_Test");
				            msgObj.css('display', 'block'); //必须先弹出此行，否则msgObj[0].offsetHeight为0，因为"display":"none"时，offsetHeight无法取到数据；如果弹出框为table，则为'',如果为div，则为block，否则textbox长度无法充满td
				            //y轴位置
				            var js_Top = -parseInt(msgObj.height()) / 2 + "px";
				            //x轴位置
				            var js_Left = -parseInt(msgObj.width()) / 2 + "px";
				            msgObj.css({ "margin-left": js_Left, "margin-top": js_Top });
						}
					}
				);
				$("#sure").click(
						function() {
							var $name = $("#accountnum").val();
							var $pwd = $("#pwd").val();
							$("#loginInfo").html("");
							$.ajax({
										type : "post",
										url : "Login.ajax?accountnum=" + $name
												+ "&pwd=" + $pwd,
										dataType : "Text",
										success : function(msg) {
											if (msg == 1) {
												alert("登录成功!");
												$("#div_Test").css("display", "none");
												$("#div_Bg").css("display", "none");
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
				$(".t3user").live({
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
					<li id="problem" class="naviItem" style="display: block;">反馈问题</li>
					<c:choose>
						<c:when test="${User!=null}">
							<li id="logout" class="naviItem">注销</li>
						</c:when>
						<c:otherwise>
							<li id="register" class="naviItem">注册</li>
							<li id="login" class="naviItem">登录</li>
						</c:otherwise>
					</c:choose>
					<li id="toindex" class="naviItem" style="display: block;">首页</li>
				</ul>
			</div>
			<hr id="headline" />
			<div id="headsearch">
				<center>
					<div id="searchmod">
						<input id="searchtext" type="text" />
						<input id="searchbt" type="button" value="搜索" />
					</div>
				</center>
			</div>
		</div>
		<div id="body">
			<div id="ponudinfo">
				<div id="ponudinfohead">
					<div id="headimg">
						<img src="upload/${topic.fp.headimg}"/>
					</div>
				</div>
				<div id="ponudinfom">
					<div id="pname">
						<p style="font-size: 20px;">${topic.fp.title}塘</p>
					</div>
					<div id="otherinfo" style="font-size: 12px;">
						<span class="ponudinfo_split"></span>
						<span id="focusnum" class="otherinfospan">关注人数：${collnum}</span>
						<span class="ponudinfo_split"></span>
						<span id="topicnum" class="otherinfospan">总帖数：${tcount}</span>
						<span class="ponudinfo_split "></span>
						<span id="psign" class="otherinfospan">${topic.fp.sign}</span>
						<span class="ponudinfo_split"></span>
					</div>
				</div>
			</div>
			<div id="bl">
				<div id="navi_h">
					<div id="topic1title">
						<span id="titlethis" title="${topic.title}">${topic.title}</span>
						<div style="dispaly:none" id="tno1">${topic.tno}</div>
					</div>
					<div id="orderlist">
						<select id="listorder">
							<option value="1">正序查看</option>
							<option value="2">倒序查看</option>
							<option value="3">只看楼主</option>
						</select>
					</div>
				</div>
				<div id="navi_b">
					<table class="topic1" >
						<tr>
							<td rowspan="4" class="speakerinfo">
								<img src="upload/${topic.uno.uheadimg}" class="speakerimg"/>
								
								<p><a id="${topic.uno.uno}" class="otheruserid">${topic.uno.uname}</a></p>
							</td>
						</tr>
						<tr>
							<td>
								${topic.content}<br /> 
								<c:forEach var="imglist" items="${topic.imagesrc}">
									<img src="upload/${imglist}" /> 
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td>
								<span class="speaker" style="float: right;">话题时间：${topic.createdate}</span>
							</td>
						</tr>
					</table>
					<hr class="topicline" />
					
					<div id="topic2list" style="float:left">
						<c:forEach var="t2" items="${pb.list}">
							<table class="topic1" >
								<tr>
									<td rowspan="4" class="speakerinfo">
										<img src="upload/${t2.uno.uheadimg }" class="speakerimg"/>
										<p><a id="${t2.uno.uno}" class="otheruserid">${t2.uno.uname}</a></p>
									</td>
								</tr>
								<tr>
									<td>
										${t2.content}
									</td>
								</tr>
								<tr>
									<td>
									
										<span class="speaker" id="lookreply" style="float: right;">
											<span style="display:none" >${t2.tno}</span>
											<button type="button" class="lookreply" >查看回复</button>
										</span>
										<span class="speaker" id="dislookreply" style="float: right;">
											<button type="button" class="dislookreply" style="display: none">收起回复</button>
										</span>
										<span class="speaker" style="float: right;">回复时间：${t2.createdate}</span><br />
										<div class="replycontent" style="display: none;">
											<div class="topic3rely">
												<input type="text" class="t3reply" value="" /><br/>
												<input type="button" class="t3replybt" value="回复" />
											</div>
										</div>
										
									</td>
								</tr>
							</table>
							<hr class="topicline" />
						</c:forEach>
					</div>	
						<center>
							<input type="button" class="headpage" value="首页" />
							<input type="button" class="previous" value="上一页" />
							第<span id=nowpage>${pb.pageIndex}</span>页
							<input type="button" class="next" value="下一页" />
							<input type="button" class="lastpage" value="尾页" />
							<span style="float:right">共<span id=maxpage>${pb.pageCount}</span>页</span>
						</center>
						<div id="createtopic2">
								<span>吐个槽:</span><br />
								<textarea name="newtopic"></textarea><br />
								<input id="fabiao" type="button" value="发表" />
						</div>
						<div id="footer">
							<p>攻城狮：Awesome—stanlance</p>
						</div>
					</div>
			</div>
			<div id="brt" style="display: none">
				<div id="navi_s">
					<center>
						<div id="searchmod2">
							<input id="searchtopic" type="text" value="" placeholder="塘内搜索" />
							<input id="searchtopicbt" type="button" value="搜索" />
						</div>
					</center>
				</div>
				<div id="navi_rs" style="display: none">
					<c:if test="${User!=null}">
						<div id="userinfo">
							<img id="headimg" src="upload/${User.uheadimg }" /><br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID： <label id="uno">${User.uno}</label>
							<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<a id="uname" href="Homepage.do">${User.uname}</a><br />
						</div>
					</c:if>
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
