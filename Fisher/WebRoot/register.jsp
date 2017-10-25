<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册吧，老铁！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/register.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<script type="text/javascript">
		
		//页面密码	强度显示
		function PasswordStrength(passwordID,strengthID){
			  this.init(strengthID);
			  var _this = this;
			  document.getElementById(passwordID).onkeyup = function(){
			    _this.checkStrength(this.value);
			  }
		};
		PasswordStrength.prototype.init = function(strengthID){
		  var id = document.getElementById(strengthID);
		  var div = document.createElement('div');
		  var strong = document.createElement('strong');
		  this.oStrength = id.appendChild(div);
		  this.oStrengthTxt = id.parentNode.appendChild(strong);
		};
		PasswordStrength.prototype.checkStrength = function (val){
		  var aLvTxt = ['','低','中','高'];
		  var lv = 0;
		  if(val.match(/[a-z]/g)){lv++;}
		  if(val.match(/[0-9]/g)){lv++;}
		  if(val.match(/(.[^a-z0-9])/g)){lv++;}
		  if(val.length < 6){lv=0;}
		  if(lv > 3){lv=3;}
		  this.oStrength.className = 'strengthLv' + lv;
		  this.oStrengthTxt.innerHTML = aLvTxt[lv];
		};
		function showx()
		{
			var t=document.getElementById("stronglv");
			t.style.display="inline-block";
		}
		function hiddenx()
		{
			var t=document.getElementById("stronglv");
			var pwdcontent=document.getElementById("pwd").value;
			if(pwdcontent.length>0){
				t.style.display="inline-block";
			}else{
				t.style.display="none";
			}
			
		}
			//选择注册方式时背景
			$(function(){
				
				$(".reg_select").bind({
					click:function()
						{
							$(this).css("background","rgb(159,211,233)");
							$(this).siblings().css("background","none");
						},
					mouseover:function()
						{
							$(this).css("border-top","1px solid rgb(74,79,109)");
						},
					mouseout:function()
						{
							$(this).css("border-top","none");
						}
				});
			});
			//选择注册，切换模块
			$(function(){
				
				$("#phone_reg").click(function(){
					$("#phone_div").css("display","block");
					$("#email_div").css("display","none");
					$("#emailNum").val("");
				});
				$("#email_reg").click(function(){
					$("#email_div").css("display","block");
					$("#phone_div").css("display","none");
					$("#phoneNum").val("");
				});
			});
			
			//进行判断
			$(function(){
				var name1t=0;
				var phone1t=0;
				var email1t=0;
				var pwd1t=0;
				var repwd1t=0;
				$("input").focus(function(){
					$(this).siblings(".little").css("display","inline-block");});
				//用户名写进时判断是否可用
				$("#username").blur(function(){
					$(this).siblings(".little").css("display","none");
					var uname=$("#username").val();
					var ret_name=/^[a-zA-Z]{1}[a-zA-Z0-9]{5,20}$/;
					if(ret_name.test(uname)){
						/*$("#nameli").css("display","inline-block");
						$("#nameli").html("可用");*/
						
						$.ajax({
								type : "post",
								url : "Register.ajax?username=" + $("#username").val(),
								dataType : "Text",
								success : function(msg) {
								//alert(msg);
									if(msg==1){
										$("#nameli").css("display","inline-block");
										$("#nameli").html("你真的！可用");
										name1t=1;
									}else{
										$("#nameli").css("display","inline-block");
										$("#nameli").html("✘该用户名已被占用！");
										name1t=2;
									}
									
								},
								error : function() {
									alert(msg);
								}
							});	
					}
					else
					{
						$("#nameli").css("display","inline-block");
						$("#nameli").html("✘不可用!长度应为6位以上！");
						
					}
				});
				
				$("#phoneNum").blur(function(){
					$(this).siblings(".little").css("display","none");
					var uphone=$("#phoneNum").val();
					var ret_phone=/^1[3578]{1}\d{9}$/;
					if(ret_phone.test(uphone)){
						$.ajax({
								type : "post",
								url : "Register.ajax?phoneNum=" + $("#phoneNum").val(),
								dataType : "Text",
								success : function(msg) {
									if(msg!=2){
										$("#phoneli").css("display","inline-block");
										$("#phoneli").html("手机！可用");
										phone1t=1;
									}else{
										$("#phoneli").css("display","inline-block");
										$("#phoneli").html("✘该手机号已经被注册过了！！");
										phone1t=2;
									}
									
								},
								error : function() {
									alert(msg);
								}
							});	
					}
					else
					{
						$("#phoneli").css("display","inline-block");
						$("#phoneli").html("✘大陆手机mmp");
						phone1t=2;
						
					}
				});	
				
				$("#emailNum").blur(function(){
					$(this).siblings(".little").css("display","none");
					var uemail=$("#emailNum").val();
					var ret_email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9]{2,3}){1,2})$/
					if(ret_email.test(uemail)){
						/*$("#nameli").css("display","inline-block");
						$("#nameli").html("可用");*/
						$.ajax({
								type : "post",
								url : "Register.ajax?emailNum=" + $("#emailNum").val(),
								dataType : "Text",
								success : function(msg) {
									if(msg!=3){
										$("#emailli").css("display","inline-block");
										$("#emailli").html("邮箱！可用");
										email1t=1;
									}else{
										$("#emailli").css("display","inline-block");
										$("#emailli").html("✘该邮箱已经被注册过了！！");
										email1t=2;
									}
									
								},
								error : function() {
									alert(msg);
								}
							});	
					}
					else
					{
						$("#emailli").css("display","inline-block");
						$("#emailli").html("✘能用在的邮箱！mmp");
						email1t=2;
						
					}
				});	
	
				//判断两次密码是否相符
				$("#repwd").focus(function(){
					$(".recli").css("display","inline-block");
				});
				$("#repwd").blur(function(){
						var pwd=$("#pwd").val();
						if(pwd.length>5){
							pwd1t=1;
						}
						var repwd=$("#repwd").val();
						if(repwd==pwd){
							if(pwd!=""){
								$("#recpwd").html("两次密码相符！");
								repwd1t=1;
							}
						}else{
							if(repwd!=""){
								$("#recpwd").html("两次密码不一致！");
								repwd1t=2;
							}else{
								$("#recpwd").html("");
								repwd1t=2;
							}
							
					}
				});
				
				
				$("#myreg").click(function(){
					var ischeked=$("#checkRule").is(":checked");
					if((email1t==1||phone1t==1)&&pwd1t==1&&repwd1t==1&&ischeked&&name1t==1){
								$("#regForm").attr("action","Register.do");	
					}
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

			});
			
		
			
			
			
		
		</script>
	</head>
	<body>
		<div id="header">
		<div id="headinner">
			<ul id="headnavi">
				<li id="problem" class="naviItem">反馈问题</li>
				<li id="login" class="naviItem">登录</li>
				<li id="toindex" class="naviItem">首页</li>
			</ul>
		</div>
		<hr id="headline" />
		
	</div>
		<div id="main">
			<div id="main_left">
				<form method="post"  id="regForm">
				<div id="select_span">
				<span id="phone_reg" class="reg_select">手机注册</span>
				<span id="email_reg" class="reg_select">邮箱注册</span>
				<p></p>
				</div>
				
				<p class="pass_item">用户名：
						<input type="text" placeholder="用户名可用于登录" id="username" name="username" />
						<span  class="little" id="nameli" >仅能为英文或英文数字组合，长度为6-14位，不可更改</span>
					</p>
				<div id="phone_div">
					<div>
					<p class="pass_item">
					
					手机号：
						<input type="tel" placeholder="手机认证亦可用于登录" id="phoneNum" name="phoneNum"/>	
					
						<span id="phoneli" class="little" >
							请使用大陆运营商手机号码
						</span>
					
					</p>
					</div>
				</div>
				<div id="email_div">
					
					<p class="pass_item">
						&nbsp;&nbsp;邮&nbsp;箱：
						<input type="tel" placeholder="邮箱用于认证和登录" id="emailNum" name="emailNum"/>
						<span id="emailli" class="little">
							请输入正确的邮箱
						</span>
					</p>
					
				</div>
				<p class="pass_item">
						密&nbsp;&nbsp;&nbsp;码：
						<input type="password" id="pwd" maxlength="20" name="pwd" value=""  onkeydown="showx()" onblur="hiddenx()" />
						<span id="pwdli" class="little">
							密码应为6-20位英文、数字、符号的混合字符串
						</span>
						<div id="stronglv" class="pass-wrap"  style="display: none;">
							<em>密码强度：</em>
							<div id="passStrength"></div>	
						</div>
				</p>
				<p class="pass_item">
						确认密码：
						<input type="password" id="repwd"  />
						<span id="recpwd" class="recli">
							请输入一致的密码
						</span>
						
						
				</p>
				<p class="pass_item">
						
					<input type="checkbox" id="checkRule"/>
						
					<span id="" style="display: inline-block;">
						同意《<a href="FisherRule.jsp" target="_blank">渔夫手册</a>》
					</span>
				</p>
				<input type="submit" value="注册" id="myreg"  />	
				<input type="hidden" id="regsucc" class="regs" >
				
				
					<div id="ddiv"></div>
				</form>
			</div>
			<div id="main_right">
				
			</div>
		</div>
		<div id="headnav">
			<hr />
		</div>
		<div id="footer">
				<p>攻城狮：Awesome—stanlance</p>
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
<script type="text/javascript">
new PasswordStrength('pwd','passStrength');
</script>
	