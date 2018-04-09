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

		<form action="${pageContext.request.contextPath}/act_doAddAct.action"
			method="post" id="addActForm">
			<s:iterator var="eOrA" value="editOrAdd">
				<s:if test="#eOrA==1">
					<s:iterator var="act" value="actList">
						<div>
							<label>活动名称</label> <input type="text" name="Volunteer_act_name"
								value="<s:property value="#act.Volunteer_act_name"/>"
								class="form-control">
								<input type="hidden" name="Volunteer_act_uid"
								value="<s:property value="#act.Volunteer_act_uid"/>"
								>
						</div>
						<div>
							<label>活动主题</label> <input type="text" name="Volunteer_act_core"
								value="<s:property value="#act.Volunteer_act_core"/>"
								class="form-control">
						</div>
						<div>
							<label>活动主办方</label> <input type="text" name="Volunteer_act_spo"
								value="<s:property value="#act.Volunteer_act_spo"/>"
								class="form-control">
						</div>
						<div>
							<label>活动时间</label> <input type="Date" name="Volunteer_act_date"
								class="form-control">
						</div>
						<div>
							<label>活动地点</label> <input type="text" name="Volunteer_act_site"
								value="<s:property value="#act.Volunteer_act_site"/>"
								class="form-control">
						</div>
						<div>
							<label>活动流程</label>
							<textarea class="form-control" name="Volunteer_act_flow" rows="3"><s:property
									value="#act.Volunteer_act_flow" /></textarea>
						</div>
						<div>
							<label>人员数</label> <input type="text" name="Volunteer_act_mans"
								value="<s:property value="#act.Volunteer_act_mans"/>"
								class="form-control">
						</div>
						<div>
						
							<label>活动状态</label> <select name="Volunteer_act_status"
								class="form-control">
								<option value="0">招募中</option>
								<option value="1">进行中</option>
								<option value="2">已结束</option>
							</select>
						</div>

					</s:iterator>
				</s:if>
				<s:if test="#eOrA==0">
					<div>
						<label>活动名称</label> <input type="text" name="Volunteer_act_name"
							class="form-control">
					</div>
					<div>
						<label>活动主题</label> <input type="text" name="Volunteer_act_core"
							class="form-control">
					</div>
					<div>
						<label>活动主办方</label> <input type="text" name="Volunteer_act_spo"
							class="form-control">
					</div>
					<div>
						<label>活动时间</label> <input type="Date" name="Volunteer_act_date"
							class="form-control">
					</div>
					<div>
						<label>活动地点</label> <input type="text" name="Volunteer_act_site"
							class="form-control">
					</div>
					<div>
						<label>活动流程</label>
						<textarea class="form-control" name="Volunteer_act_flow" rows="3"></textarea>
					</div>
					<div>
						<label>人员数</label> <input type="text" name="Volunteer_act_mans"
							class="form-control">
					</div>
					<div>
						<label>活动状态</label> <select name="Volunteer_act_status"
							class="form-control">
							<option value="0">招募中</option>
							<option value="1">进行中</option>
							<option value="2">已结束</option>
						</select>
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
	
	var url = "${pageContext.request.contextPath}/act_doAddAct.action"; 
    //更改form的action  
    $('#addActForm').attr('action', url);
	$('#addActForm').submit();
	/* layer.closeAll("iframe"); */
	
}
</script>

</html>