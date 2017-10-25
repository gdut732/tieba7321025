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
    <meta charset="UTF-8">
    <title>${User.uname}的主页</title>
    
		<link rel="stylesheet" href="css/personalHomepage.css" type="text/css" />
		<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var nowdiv =null;
				
			
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
				$(".navi_item").bind({
					mouseover:function()
					{
						$(this).css("border-top","1px solid rgb(74,79,109)");
						$(this).siblings().css("border-top","0px");
					},
					click:function()
					{
						$(this).css("background","rgb(159,211,233)");
						$(this).siblings().css("background","none");
						var iid=$(this).attr("id");
						var id ="#"+$(this).attr("id")+"V";
						$(id).css("display","block");
						$(id).siblings("div").css("display","none");
						nowdiv=iid;
						if(iid=="Myindex")
						{
							$("#pagenavi").css("display","none");
						}
						else
						{
							$("#pagenavi").css("display","block");
							$("#nowpage").html(1);	
							
							/*获取数据  */
							$.ajax({
								type:"post",
								url:iid+".ajax",
								data:"n=1",
								dataType:"Text",
								scriptCharset: "utf-8",
								contentType: "application/x-www-form-urlencoded;charset=utf-8",
								success : function(msg)
								{
									$(id).html(msg);
								},
								error : function() {
									$(id).html("出错了_(:зゝ∠)_");
								}
							});
							/*获取最大页数  */
							$.ajax({
								type:"post",
								url:iid+".ajax",
								data:"n=0",
								dataType:"Text",
								scriptCharset: "utf-8",
								contentType: "application/x-www-form-urlencoded;charset=utf-8",
								success : function(msg)
								{
									$("#maxpage").html(msg);
								},
								error : function() {
									$("#maxpage").html("出错了_(:зゝ∠)_");
								}
							});
						}
					}
				});
				$(".headpage").click(function(){
					var nowpage=$("#nowpage").text();
					var id ="#"+nowdiv+"V";
					if(nowpage==1)
					{
						alert("已经第一页了！");
					}
					else
					{
						$.ajax({
							type:"post",
							url:nowdiv+".ajax",
							data:"pageIndex=1",
							dataType:"Text",
							scriptCharset: "utf-8",
							contentType: "application/x-www-form-urlencoded;charset=utf-8",
							success : function(msg)
							{
								$(id).html(msg);
								$("#nowpage").html(1);
							},
							error : function() {
								$(id).html("出错了_(:зゝ∠)_");
							}
						});
						$("#nowpage").html(1);
					}
					
				});
				$(".previous").click(function(){
					var nowpage=$("#nowpage").text();
					var id ="#"+nowdiv+"V";
					if(nowpage==1)
					{
						alert("没有上一页了");
					}
					else
					{
						
						var t = parseInt(nowpage)-1;
						$.ajax({
							type:"post",
							url:nowdiv+".ajax",
							data:"pageIndex="+t,
							dataType:"Text",
							scriptCharset: "utf-8",
							contentType: "application/x-www-form-urlencoded;charset=utf-8",
							success : function(msg)
							{
								$(id).html(msg);
								$("#nowpage").html(t);
							},
							error : function() {
								$(id).html("出错了_(:зゝ∠)_");
							}
						});
						$("#nowpage").html(t);
					}
				});
				$(".next").click(function(){
					var nowpage=$("#nowpage").text();
					var maxpage=$("#maxpage").text();
					var id ="#"+nowdiv+"V";
					if(maxpage==nowpage)
					{
						alert("没有下一页了");
					}
					else
					{
						var t = parseInt(nowpage)+1;
						$.ajax({
							type:"post",
							url:nowdiv+".ajax",
							data:"pageIndex="+t,
							dataType:"Text",
							scriptCharset: "utf-8",
							contentType: "application/x-www-form-urlencoded;charset=utf-8",
							success : function(msg)
							{
								$(id).html(msg);
								$("#nowpage").html(t);
							},
							error : function() {
								$(id).html("出错了_(:зゝ∠)_");
							}
						});
					}
				});
				$(".lastpage").click(function(){
					var nowpage=$("#nowpage").text();
					var maxpage=$("#maxpage").text();
					var id ="#"+nowdiv+"V";
					if(nowpage==maxpage)
					{
						alert("已经最后一页了！");
					}
					else
					{
						$.ajax({
							type:"post",
							url:nowdiv+".ajax",
							data:"pageIndex="+maxpage,
							dataType:"Text",
							scriptCharset: "utf-8",
							contentType: "application/x-www-form-urlencoded;charset=utf-8",
							success : function(msg)
							{
								$(id).html(msg);
								$("#nowpage").html(maxpage);
							},
							error : function() {
								$(id).html("出错了_(:зゝ∠)_");
							}
						});
					}
				});
				$(".opera").live({
					click:function(){
						var fuid = $(this).parent().siblings(".fuid").text();
						var id ="#"+nowdiv+"V";
						$.ajax({
							type:"post",
							url:nowdiv+".ajax",
							data:"fid="+fuid,
							dataType:"Text",
							scriptCharset: "utf-8",
							contentType: "application/x-www-form-urlencoded;charset=utf-8",
							success : function(msg)
							{
								$(id).html(msg);
								$("#nowpage").html(1);
							},
							error : function() {
								$(id).html("出错了_(:зゝ∠)_");
							}
						});
						/*获取最大页数  */
						$.ajax({
							type:"post",
							url:nowdiv+".ajax",
							data:"n=0",
							dataType:"Text",
							scriptCharset: "utf-8",
							contentType: "application/x-www-form-urlencoded;charset=utf-8",
							success : function(msg)
							{
								$("#maxpage").html(msg);
							},
							error : function() {
								$("#maxpage").html("出错了_(:зゝ∠)_");
							}
					});
				}
				});
				$(".alarm_navi").click(function(){
					/*$(this).next("div").html();*/
					$(this).next("div").css("display","block");
					/*$(this).next("div").siblings("div").html("");*/
					$(this).next("div").siblings("div").css("display","none");
				});
				$("#signsure").click(function(){
					var text = $("#signtext").val();
					if(text!="")
					{
						window.location.href="GG.do?text="+text+"&t=1";
					}else
					{
						alert("什么都没有填！");
					};
						
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
				$("#changeinfobt").click(function(){
					$("#changediv").toggle();
					if($("#csex").val()!="")
					{
						$("#csex").attr("disabled","true");
					}
					if($("#realname").val()!="")
					{
						$("#realname").attr("disabled","true");
					}
					if($("#idnum").val()!="")
					{
						$("#idnum").attr("disabled","true");
					}
				});
				$("#sureinfobt").submit(function(){
					var idnumcheck=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X|x)$/;
					var idnum = $("#idnum").val();
					 if(idnumcheck.test(idnum))
					{
						return true;
					}
					else
					{
						alert("填写信息有误！");
					}
				});
				$(".otheruserid").live({
					click:function(){
						var uno2 = $(this).attr("id");
						location.href="Otheruser.do?uno2="+uno2;
						
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
					<li id="logout" class="naviItem">注销</li>
										<c:if test="${MsgSum!=null}">
							<li id="newmsg" class="naviItem">消息[<a class="newmsgnum">${MsgSum}</a>]条</li>
						</c:if>
					<li id="toindex" class="naviItem">首页</li>
				</ul>
			</div>
			<hr id="headline"/>
			<div id="headsearch">
				<center>
					<div id="searchmod">
						<input id="searchtext" type="text"/>
						<input id="searchbt" type="button" value="搜索"/>
					</div>
				</center>
			</div>
		</div>
		<div id="body">
			<div id="userinfo">
				<div id="userinfohead">
					<div id="headimg">
						<img src="upload/${User.uheadimg}"/>
					</div>
				</div>
				<div id="userinfom">
					<div id="changeinfo">
						<input type="button" name="changeinfobt" id="changeinfobt" value="完善信息" />
						<div id="changediv" style="display:none">
						<form action="Homepage.do?change=y" method="post">
							<span>
							性别：<input type="text" name="csex" id="csex" style="width:30px" value="${userinfo.sex}" />
							</span>
							<span>
							真实姓名：<input type="text" name="realname" id="realname" style="width:80px" value="${userinfo.realname}" />
							</span>
							<span>
							身份证号：<input type="text" name="idnum" id="idnum" value="${userinfo.idnumber}" />
							</span>
							<input type="submit" name="sureinfobt" id="sureinfobt" value="确定" />
						</form>
						</div>
					</div>
					<div id="uname">
						${User.uname}
					</div>
					<div id="otherinfo">
						<span id="sex" class="otherinfospan">性别：${userinfo.sex}</span>
						<span class="userinfo_split"></span>
						<span id="age" class="otherinfospan">创建时间：${userinfo.createDate}</span>
						<span class="userinfo_split"></span>
						<span id="num" class="otherinfospan">话题：${topic1count}</span>
					</div>
				</div>
			</div>
			<div id="usercontent">
				<div id="uleft">
					<div id="navi_item">
						<ul>
							<li id="Myindex" class="navi_item" style="background:rgb(159,211,233) ;">主页</li>
							<li id="Myfocusu" class="navi_item">关注的人</li>
							<li id="Mycollect" class="navi_item">收藏</li>
							<li id="Myfocusp" class="navi_item">关注的塘</li>
							<li id="Mytopic1" class="navi_item">我的话题</li>
						</ul>
					</div>
					<div id="navi_content">
						<div id="MyindexV"  class="navi_content" style="display: block;">
							<div id="myindextop">
							<!--上传头像  -->
								<form action="GG.do" method="post" enctype="multipart/form-data">
									<p style="font-size: 25px;text-align: center;line-height: 50px;">上传新头像</p>
									<input id="fileimg" name="upfile" type="file" accept="image/png,image/jpeg,,image/jpg" value="" style="margin:50px 0 0 230px ;"/>
									<br />
									<input type="submit" value="确定" id="imgsure"/>
								</form>
							</div>
							
							<div id="myindexbottom">
							<!--上传签名档  -->
								<p style="font-size: 25px;">签名档</p>
								<textarea  id="signtext" name="sign" maxlength="100" style="width: 300px;height: 130px;resize: none;">${userinfo.sign}</textarea>
								<br />
								<input type="button"  id="signsure" value="提交"/>
							
							</div>
						</div>
						<div id="MyfocusuV" class="navi_content" style="display: none;">
						</div>
						<div id="MycollectV" class="navi_content" style="display: none;">
						</div>
						<div id="MyfocuspV" class="navi_content" style="display: none;">
						</div>
						<div id="Mytopic1V" class="navi_content" style="display: none;">
						</div>
						<center id="pagenavi" style="display:none;">
								<input type="button" class="headpage" value="首页" />
								<input type="button" class="previous" value="上一页" />
								第<span id="nowpage"></span>页
								<input type="button" class="next" value="下一页" />
								<input type="button" class="lastpage" value="尾页" />
								<span style="float:right">共<span id="maxpage"></span>页</span>
						</center>
						</div>
				</div>
			<div id="uright">
					<div id="alarm">
						<div id="alarmhead">
							消息盒子
						</div>
						<div id="alarmnavi">
							<ul id="alarmnaviul">
								<li class="alarm_navi">回复我的     [<a class="newmsgnum">${msgcount}</a>] 条</li>
								<div>
									<c:forEach var="list" items="${alarmlist}">
										<a href="Topic11.do?tno=${list.topic1.tno}&ano=${list.uano}">
										<h5>小话题：${list.topic1.title}</h5><br />
										${list.sender.uname} 回复 :<br />${list.msg}
										</a>
										<hr />
									</c:forEach>
								</div>
								<li class="alarm_navi">收到的赞</li>
								<div >
									xxx 点赞 <br />
									帖子名：多久啊索拉卡道具卡老实交代克拉
									<hr />
								</div>
								<li class="alarm_navi">系统通知</li>
								<div>
									系统： <br />
									你被封号了！
									<hr />
								</div>
								<li class="alarm_navi">我的私信</li>
								<div>
									xxx  私信： <br />
									fuck you !
									<hr />
								</div>
							</ul>
						</div>
					</div>
				</div>
		</div>
		<div id="footer">
			<p>攻城狮：Awesome—stanlance</p>
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
