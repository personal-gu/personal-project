<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="js/layer/skin/layer.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body class="container">

	<div
		class="panel-body col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">

		<form action="${pageContext.request.contextPath}/user_doUpdateUser.action"
			method="post" id="doUpdateUser">
					<s:iterator var="user" value="userList">
						<div>
							<label>学号</label> <input type="text" name="volunteer_stuid"
								value="<s:property value="#user.volunteer_stuid"/>"
								class="form-control">
								
								<input type="hidden" name="volunteer_uid"
								value="<s:property value="#user.volunteer_uid"/>"
								>
						</div>
						<div>
							<label>姓名</label> <input type="text" name="volunteer_name"
								value="<s:property value="#user.volunteer_name"/>"
								class="form-control">
						</div>
						<div>
							<label>密码</label> <input type="text" name="volunteer_ps"
								value="<s:property value="#user.volunteer_ps"/>"
								class="form-control">
						</div>
						<div>
							<label>性别</label> <select name="volunteer_sex"
								class="form-control">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
						<div>
							<label>学院</label> <input type="text" name="volunteer_s"
								value="<s:property value="#user.volunteer_s"/>"
								class="form-control">
						</div>
						<div>
							<label>班级</label>
							<input class="form-control" name="volunteer_c" value="<s:property
									value="#user.volunteer_c" />" class="form-control">
						</div>
						<div>
							<label>电话</label> <input type="text" name="volunteer_p"
								value="<s:property value="#user.volunteer_p"/>"
								class="form-control">
						</div>
						<div>
						
							<label>审核</label> <select name="volunteer_type"
								class="form-control">
								<option value="0">未审核</option>
								<option value="1">审核通过</option>
								
							</select>
						</div>

					</s:iterator>
			
		</form>
	</div>

</body>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/layer/layer.js"></script>
<script type="text/javascript">
function doSubmit(){
	$('#doUpdateUser').submit();
	/* layer.closeAll("iframe"); */
	
}
</script>

</html>