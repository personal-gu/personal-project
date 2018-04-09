<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<script type="text/javascript">
function dosubmit(){
	$('#submit').submit();
}
</script>
<body>

<div class="register-container">
	<h1>注 册</h1>
	
	<div class="connect">
		<p>予人玫瑰，手有余香，欢迎你的加入。</p>
	</div>
		<div>
						<s:actionerror />
		</div>
	<form action="${pageContext.request.contextPath}/user_doRegist.action" method="post" id="registerForm">
		<div>
			<input type="text" name="volunteer_stuid" class="uid" placeholder="输入学号" autocomplete="off" id="uid"/>
		</div>
		<div>
			<input type="text" name="volunteer_name" class="username" placeholder="您的姓名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="volunteer_ps" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
			<span><s:fielderror fieldName="password"/></span>
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
<!-- 			<input type="text" name="volunteer_sex" class="sex" placeholder="输入性别" autocomplete="off" id="sex"/>
 -->		<select name="volunteer_sex" class="form-control" >
				<option value="1">男</option>
				<option value="0">女</option>
			</select>
		</div>
		<div>
			<input type="text" name="volunteer_s" class="college" placeholder="输入学院" autocomplete="off" id="college"/>
		</div>
		<div>
			<input type="text" name="volunteer_c" class="classbj" placeholder="输入班级" autocomplete="off" id="classbj"/>
		</div>
		<div>
			<input type="text" name="volunteer_p" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
		</div>
		<div>
			<input type="text" name="volunteer_like" class="phone_number" placeholder="输入性格类型" autocomplete="off" id="number"/>
		</div>
		
		
	
		<button id="submit" onclick="dosubmit()">注 册</button>
	</form>
	<a href="${pageContext.request.contextPath}/index">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<!--背景图片自动更换-->
<script src="${pageContext.request.contextPath}/js/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/js/supersized-init.js"></script>
<!--表单验证-->
<%-- <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js?var1.14.0"></script> 
 --%></html>