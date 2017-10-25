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
<base href="<%=basePath%>">
<title>${FishPond.title}</title>

<link rel="stylesheet" type="text/css" href="css/fishpound.css">
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
		$("form").submit(function(e) {
			var uno = $("#uno").val();
			if (uno == null) {
				alert("未登录用户");
			} else {
				var zhengwen = $("#newtopictext").val();
				var title = $("#topic1title").val();
				if (zhengwen.length < 20 || title.length < 10) {
					alert("标题字符不能小于10个字符、文本内容不能小于20个字符!");
					return false;
				} else {
					alert("提交成功！");
					return true;
				}
			}
			return false;
		});
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
			var s = confirm("请问你是否要退出登录吗？");
			if (s) {
				location.href = "Index.do?user=0";
			}
		});
		$("#newmsg").click(function() {
			location.href="Homepage.do";
		});
		$("#searchbt").click(function() {
			var t = $("#searchtext").val();
			alert(t);
		});
		$("#cancelfocus")
				.live(
						{
							click : function() {
								var fno = $("#fishpoundno").val();
								var uno = $("#uno").val();
								if (uno != null) {
									$("#focus")
											.load(
													"FishPound.ajax",
													"uno=" + uno + "&fno="
															+ fno + "&focus=2",
													function(response, status,
															xhr) {
														if (xhr.responseText != null) {
															$("#focus")
																	.html(
																			xhr.responseText);

															$("#focusnum")
																	.html(
																			""
																					+ $(
																							"#focusnum")
																							.html()
																					- 1);
															alert("取消关注成功！");
														} else {
															alert("取消关注失败！");

														}

													});
								} else {
									var s_Width = document.documentElement.scrollWidth; //滚动 宽度
									var s_Height = document.documentElement.scrollHeight; //滚动 高度
									var js_Title = $(document
											.getElementById("loginview")); //标题
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
									var js_Top = -parseInt(msgObj.height()) / 2
											+ "px";
									//x轴位置
									var js_Left = -parseInt(msgObj.width()) / 2
											+ "px";
									msgObj.css({
										"margin-left" : js_Left,
										"margin-top" : js_Top
									});
									//使弹出层可移动
									msgObj.draggable({
										handle : js_Title,
										scroll : false
									});
								}

							}
						});
		$("#cancelfocus").click(function() {

		});

		$("#surefocus")
				.live(
						{
							click : function() {
								var fno = $("#fishpoundno").val();
								var uno = $("#uno").val();
								if (uno != null) {
									$("#focus")
											.load(
													"FishPound.ajax",
													"uno=" + uno + "&fno="
															+ fno + "&focus=1",
													function(response, status,
															xhr) {
														if (xhr.responseText != null) {
															$("#focus")
																	.html(
																			xhr.responseText);
															$("#focusnum")
																	.html(
																			""
																					+ $(
																							"#focusnum")
																							.html()
																					- 1
																					+ 2);
															alert("关注成功！");

														} else {
															alert("关注失败！");
														}

													});
								} else {
									var s_Width = document.documentElement.scrollWidth; //滚动 宽度
									var s_Height = document.documentElement.scrollHeight; //滚动 高度
									var js_Title = $(document
											.getElementById("loginview")); //标题
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
									var js_Top = -parseInt(msgObj.height()) / 2
											+ "px";
									//x轴位置
									var js_Left = -parseInt(msgObj.width()) / 2
											+ "px";
									msgObj.css({
										"margin-left" : js_Left,
										"margin-top" : js_Top
									});
									//使弹出层可移动
									msgObj.draggable({
										handle : js_Title,
										scroll : false
									});
								}
							}
						});
		$(".headpage").click(function() {
			alert("首页");
		});
		$(".previous").click(function() {
			alert("前一页");
		});
		$(".next").click(function() {
			alert("下一页");
		});
		$(".lastpage").click(function() {
			alert("尾页");
		});
		$(".opera").click(function() {
			alert("取消关注");
		});
		/*------------------------------------------------------------------------------------------------------------  */
		$("#listorder").children("option").click(

				function() {
					//alert($("#nowtop1indexpage").val());
					var t = $(this).val();
					var fno = $("#fishpoundno").val();
					$("#content").load("FishPound.ajax",
							"listorder=" + t + "&fno=" + fno,
							function(response, status, xhr) {
								$("#nowtop1indexpage").attr("value", 1);
								$("#nowindexpage").html("1");
								$(this).html(xhr.responseText);

							});

				});
		$("#searchtopicbt")
				.click(
						function() {
							var tx = $("#searchtopic").val();
							var pno = $("#fishpoundno").val();
							/* $("#content").load("FishPound.ajax",
									"likename=" + tx + "&pno=" + pno,
									function(response, status, xhr) {
										$(this).html(xhr.responseText);
									}); */
							$
									.ajax({
										scriptCharset : "utf-8",
										contentType : "application/x-www-form-urlencoded;charset=utf-8",
										type : "get",
										url : "FishPound.ajax?likename=" + tx
												+ "&pno=" + pno,
										success : function(data) {
											$("#content").html(data);
										}
									});
						});
		$("#nowtop1nextpage").click(
				function() {
					var num = $("#nowtop1indexpage").val();
					var pno = $("#fishpoundno").val();
					var maxpage = $("#nowtop1maxpage").val();
					num = parseInt(num) + 1;

					if (num <= maxpage) {
						$("#nowtop1indexpage").val(num);
						$("#nowindexpage").html(num);
						$("#content").load("FishPound.ajax",
								"page=" + num + "&pno=" + pno,
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
				});
		$("#logout").click(function() {
			//location.href="Index.do?user=0";
			var s = confirm("请问你是否要退出登录吗？");
			if (s) {
				location.href = "Index.do?user=0";
			}
		});
		$("#logout").click(function() {
			//location.href="Index.do?user=0";
			var s = confirm("请问你是否要退出登录吗？");
			if (s) {
				location.href = "Index.do?user=0";
			}
		});
		$("#addimagefile")
				.live(
						{
							click : function() {
								var allfile = $(".imagefile");
								var $textarea = $("#newtopictext").val();
								var index = allfile.length;
								//	
								if (allfile[index - 1].value != "") {
									if (allfile.length > 4) {
										var img=allfile[index - 1].value;
										if(img.lastIndexOf("\\")!=-1){
											img=img.substring(img.lastIndexOf("\\")+1,img.length);
										}
										
										alert("上传图片数量大于5张");
										$textarea = $textarea + "[图片："
												+ img
												+ "]";
										$("#newtopictext").val($textarea);
									} else {
										var img=allfile[index - 1].value;
										if(img.lastIndexOf("\\")!=-1){
											img=img.substring(img.lastIndexOf("\\")+1,img.length);
										}
										$textarea = $textarea + "[图片："
												+ img
												+ "]";
										$("#newtopictext").val($textarea);
										$("#otherfile")
												.append(
														"<input class='imagefile' name='upfile' type='file' accept='image/jpeg,image/png,' /><br/>");
									}
								} else {
									alert("未选择图片");
								}
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
				<li id="problem" class="naviItem" style="display: block;">反馈问题</li>
				<c:choose>
					<c:when test="${User!=null}">
						<li id="logout" class="naviItem">注销</li>
						<c:if test="${MsgSum!=null}">
							<li id="newmsg" class="naviItem">消息[<a class="newmsgnum">${MsgSum}</a>]条</li>
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
		<div id="ponudinfo">
			<div id="ponudinfohead">
				<div id="headimg">
					<img src="upload/${FishPond.headimg}" />
				</div>
			</div>
			<div id="ponudinfom">
				<div id="focus">
					<c:if test="${IsFocusPound==1}">
						<input type="button" class="focusbt" id="cancelfocus" value="取消关注" />
					</c:if>
					<c:if test="${IsFocusPound!=1}">
						<input type="button" class="focusbt" id="surefocus" value="关注" />
					</c:if>
				</div>
				<div id="pname">
					<p style="font-size: 30px;">${FishPond.title}</p>
				</div>
				<div id="otherinfo">
					<span class="ponudinfo_split"></span> 关注人数：<span id="focusnum"
						class="otherinfospan">${CollNum}</span> <span
						class="ponudinfo_split"></span> <span id="topicnum"
						class="otherinfospan">总帖数：${Topic1Num}</span> <span
						class="ponudinfo_split "></span> <span id="psign"
						class="otherinfospan">${FishPond.sign}</span> <span
						class="ponudinfo_split"></span> <input id="fishpoundno"
						type="hidden" value="${FishPond.no}" />
				</div>
			</div>
		</div>
		<div id="bl">
			<div id="navi_h">
				<select id="listorder">
					<option value="uptodate">最新发布</option>
					<option value="hottest">热门话题</option>
				</select>
			</div>
			<div id="navi_b">
				<div id="content">
					<c:forEach var="topic1list" items="${Topic1List}">
						<table class="topic1">
							<tr>
								<td class="title"><a href="Topic11.do?tno=${topic1list.tno}">${topic1list.title}</a></td>
							</tr>
							<tr>
								<td>${topic1list.content}<br /> 
									<c:forEach var="imglist" items="${topic1list.imagesrc}">
										<img src="upload/${imglist}" /> 
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td><span class="speaker">话题发起者：<a id="${topic1list.uno.uno}" class="otheruserid">${topic1list.uno.uname}</a></span>
									<span class="ponudinfo_split"></span> <span class="speaker">话题时间：${topic1list.createdate}</span>
								</td>
							</tr>
							<tr>
								<td>
									<hr class="topicline" />
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
				<center>
					<div id="page">
						<a id="fistpage">首页</a>&nbsp;<a id="nowtop1parpage">上一页</a>&nbsp;
						<input id="fishpoundno" type="hidden" value="${FishPond.no}" /> <input
							id="nowtop1indexpage" type="hidden"
							value="${Topic1ListPb.pageIndex}" /><input id="nowtop1maxpage"
							type="hidden" value="${Topic1ListPb.pageCount}" />第<label
							id="nowindexpage">${Topic1ListPb.pageIndex}</label>/<label>${Topic1ListPb.pageCount}</label>页&nbsp;
						<a id="nowtop1nextpage">下一页</a>&nbsp;<a id="lastpage">末页</a>
					</div>
				</center>
				<div id="createtopic">
					<form id="createtopicform"
						action="CreateTopic1.do?pno=${FishPond.no}" method="post"
						enctype="multipart/form-data">
						标题：<input type="text" id="topic1title" name="topictitle" value="" /><br />
						<textarea id="newtopictext" name="topictext" value=""></textarea>
						<br /> 图片：<input name="upfile" class="imagefile" type="file"
							accept="image/jpeg,image/png," /> <input id="fabiao"
							type="submit" value="发表" /><br />
						<div id="otherfile"></div>
						<input type="button" id="addimagefile" value="确定" />
					</form>
				</div>

				<div id="footer">
					<p>攻城狮：Awesome—stanlance</p>
				</div>
			</div>
		</div>
		<div id="brt">
			<div id="navi_s">
				<center>
					<div id="searchmod2">
						<input id="searchtopic" type="text" value="" placeholder="塘内搜索" />
						<input id="searchtopicbt" type="button" value="搜索" />
					</div>
				</center>
			</div>
			<div id="navi_rs" style="display: block">

				<c:if test="${User!=null}">
					<input id="uno" type="hidden" value="${User.uno}" />
					<div id="userinfo">
						<img id="headimg" src="upload/${User.uheadimg}" /><br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID：${User.uno}
						<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<a id="uname"
							href="Homepage.do">${User.uname}</a><br />

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
			<form>
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
