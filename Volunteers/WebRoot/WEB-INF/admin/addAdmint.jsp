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

		<form action=""
			method="post" id="addActForm">
			<s:iterator var="eOrA" value="editOrAdd">
				<s:if test="#eOrA==1">
					<s:iterator var="vo" value="admintList">
						<div>
							<label>管理员名称</label> <input type="text" name="admin_name"
								value="<s:property value="#vo.admin_name"/>"
								class="form-control">
								<input type="hidden" name="admin_uid"
								value="<s:property value="#vo.admin_uid"/>"
								>
						</div>
						<div>
							<label>管理员密码</label> <input type="password" name="admin_ps"
								value="<s:property value="#vo.admin_ps"/>"
								class="form-control">
						</div>
						<div>
							<label>管理员电话</label> <input type="text" name="admin_p"
								value="<s:property value="#vo.admin_p"/>"
								class="form-control">
						</div>
						<div>
							<label>管理员类型</label> <input type="text" name="admin_dept"
								value="<s:property value="#vo.admin_dept"/>"
								class="form-control">
						</div>
					</s:iterator>
				</s:if>
				<s:if test="#eOrA==0">
					<div>
						<label>管理员名称</label> <input type="text" name="admin_name"
							class="form-control">
					</div>
					<div>
						<label>管理员密码</label> <input type="password" name="admin_ps"
							class="form-control">
					</div>
					<div>
						<label>管理员电话</label> <input type="text" name="admin_p"
							class="form-control">
					</div>
					<div>
						<label>管理员类型</label> <input type="text" name="admin_dept"
							class="form-control">
					</div>
				</s:if>
			</s:iterator>
			<%-- <br/>
			
			<div>
				<button type="button" class="btn btn-default">取消</button>
				<button type="button" onclick="doSubmit()" class="btn btn-primary">保存</button>
			</div>
			<s:iterator var="order" value="status">
                  <input type="hidden" value="<s:property value="#order"/>" id="flag">
            </s:iterator> --%>
		</form>
	</div>

</body>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/layer/layer.js"></script>
<script type="text/javascript">
function doSubmit(){
	
	var url = "${pageContext.request.contextPath}/t_SOUAdmint.action"; 
    //更改form的action  
    $('#addActForm').attr('action', url);
	$('#addActForm').submit();
	/* layer.closeAll("iframe"); */
	
}
</script>

</html>