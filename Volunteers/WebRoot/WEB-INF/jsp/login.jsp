<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no;charset=UTF-8"/>
<title>登录</title>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<body>

<div class="login-container">
	<h1>青春是我们的名片,服务是我们的志愿</h1>
	
	<div class="connect">
		<p>欢迎进入志愿者管理系统</p>
	</div>
	
	<form action="${pageContext.request.contextPath}/user_doLogin.action" method="post" id="loginForm">
		<div>
			<input type="text" name="volunteer_name" class="username" value="" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="volunteer_ps" class="password" value="" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
		
			<select name="select" id="select_user" class="register-tis">
				<option value="0">志愿者</option>
				<option value="1">管理员</option>
			</select>
		
		</div>
		<div class="title">
			<font color="red"><s:actionerror /></font>
		</div>
		<button id="submit" type="submit">登 陆</button>
	</form>

	<a href="${ pageContext.request.contextPath }/user_goRegistPage.action">
		<button type="button" class="register-tis">注 册</button>
	</a>

</div>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script> 
<!--背景图片自动更换-->
<%-- <script src="${pageContext.request.contextPath}/js/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/js/supersized-init.js"></script> --%>
<!--表单验证-->
<%-- <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js?var1.14.0"></script>
 --%>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

</div>
</body>
</html>