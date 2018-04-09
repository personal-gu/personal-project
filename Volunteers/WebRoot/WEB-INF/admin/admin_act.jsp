<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge; charset=UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">  -->

<title>后台管理员系统</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/mmss.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="js/layer/skin/layer.css" />
<link rel="stylesheet" href="js/fileupload/uploadify.css" />

</head>
<body>
	<header>
	<div class="container-fluid navbar-fixed-top bg-primary">
		<ul class="nav navbar-nav  left">
			<li class="text-white h4">&nbsp;&nbsp;&nbsp;&nbsp;<span
				class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>志愿者服务后台系统</b>
			</li>
		</ul>
		<ul class="nav navbar-nav nav-pills right ">
			<li class="bg-success"><input id="public_date" type="button"
				class="btn btn-primary disabled"></li>
			
			<li class="bg-info dropdown"><a class="dropdown-toggle" href="#"
				data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span>&nbsp;<span>系统管理员</span><span
					class="caret"></span>
			</a>
				<ul class="dropdown-menu dropdown-menu-right">

					<li class="text-center"><a href="http://www.baidu.com"
						target="target"><span class="text-primary">帮助中心</span></a></li>

					<li class="text-center"><a
						href="${pageContext.request.contextPath}/t_quit.action"><span
							class="text-primary">退出登录</span></a></li>
				</ul></li>
		</ul>
	</div>
	</header>
	<section>
	<div class="container-fluid">
		<div class="row ">
			<!--左侧导航开始-->
			<div class="col-xs-2 bg-blue">
				<br />
				<div class="panel-group sidebar-menu" id="accordion"
					aria-multiselectable="true">
					<div class="panel panel-default menu-first menu-first-active">
						<a data-toggle="collapse" data-parent="#accordion"
							href="index.html" aria-expanded="true"
							aria-controls="collapseOne"> <i class="icon-home icon-large"></i>
							主页
						</a>
					</div>
					<div class="panel panel-default menu-first">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne"> <i
							class="icon-book icon-large"></i> 活动管理
						</a> </a>

						<div id="collapseOne" class="panel-collapse collapse in">
							<ul class="nav nav-list menu-second">
								<s:iterator var="order" value="status">
									<input type="hidden" value="<s:property value="#order"/>" id="flag">
									<s:if test="#order == 0">
										<li class="menu-second-selected"><a
											href="${pageContext.request.contextPath}/t_act.action?flag=0"><i
												class="icon-user"></i> 招募中</a></li>
										<li><a
											href="${pageContext.request.contextPath}/t_act.action?flag=1"><i
												class="icon-edit"></i> 进行中</a></li>
										<li><a
											href="${pageContext.request.contextPath}/t_act.action?flag=2"><i
												class="icon-trash"></i> 已结束</a></li>
									</s:if>
									<s:if test="#order == 1">
										<li><a
											href="${pageContext.request.contextPath}/t_act.action?flag=0"><i
												class="icon-user"></i> 招募中</a></li>
										<li class="menu-second-selected"><a
											href="${pageContext.request.contextPath}/t_act.action?flag=1"><i
												class="icon-edit"></i> 进行中</a></li>
										<li><a
											href="${pageContext.request.contextPath}/t_act.action?flag=2"><i
												class="icon-trash"></i> 已结束</a></li>
									</s:if>
									<s:if test="#order == 2">
										<li><a
											href="${pageContext.request.contextPath}/t_act.action?flag=0"><i
												class="icon-user"></i> 招募中</a></li>
										<li><a
											href="${pageContext.request.contextPath}/t_act.action?flag=1"><i
												class="icon-edit"></i> 进行中</a></li>
										<li class="menu-second-selected"><a
											href="${pageContext.request.contextPath}/t_act.action?flag=2"><i
												class="icon-trash"></i> 已结束</a></li>
									</s:if>

								</s:iterator>
							</ul>

						</div>

					</div>
					<div class="panel panel-default menu-first">
						<a class="collapsed" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo"> <i
							class="icon-user-md icon-large"></i> 志愿者管理
						</a> </a>
						<div id="collapseTwo" class="panel-collapse collapse">
							<ul class="nav nav-list menu-second">
								
                                <li><a href="${pageContext.request.contextPath}/user_checkUser.action"><i class="icon-user"></i> 志愿者信息处理</a></li>
                                <li><a href="${pageContext.request.contextPath}/user_userForAct.action"><i class="icon-edit"></i> 志愿者报名处理</a></li>
                       
							</ul>
						</div>
					</div>
					<div class="panel panel-default menu-first">
						<a class="collapsed" data-toggle="collapse"
							data-parent="#accordion" href="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree"> <i
							class="icon-user-md icon-large"></i> 管理员成员处理
						</a> </a>

						<div id="collapseThree" class="panel-collapse collapse">
							<ul class="nav nav-list menu-second">
								<li><a href="${pageContext.request.contextPath}/t_curdAdmint.action"><i class="icon-user"></i> 管理员CURD</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!--左侧导航结束-->
			<!----------------------------------------------------------------------------------------------------->
			<!--右侧内容开始-->
			<div class="col-xs-10">
				<br />
				<form action="${pageContext.request.contextPath}/act_queryForData.action" id="select_form" method="get">
				<s:iterator var="order" value="status">
					<input type="hidden" value="<s:property value="#order"/>" name="flag">
				</s:iterator>
				<select name="select_type" id="select_type" class="form-control line left">
					<option value="null">请选择搜索类型</option>
					<option value="Volunteer_act_uid">活动编号</option>
					<option value="Volunteer_act_name">活动名称</option>
					<option value="Volunteer_act_core">活动主题</option>
					<option value="Volunteer_act_spo">活动主办方</option>
					<option value="Volunteer_act_site">活动地点</option>
				</select>
				<div class="input-group line left">
					<span class="input-group-addon" id="basic-addon2"><span
						class="glyphicon glyphicon-search"></span></span> <input type="text"
						name="select_data" class="form-control" placeholder="输入关键字搜索" id="select_data"
						aria-describedby="basic-addon2">
				</div>

				<!-- 搜素按钮 -->
				<span onclick="doQuery()" class=" btn btn-primary "><span
					class="glyphicon glyphicon-search"></span></span>
				</form>
				<br />
				<br />
				<table
					class="table table-bordered table-striped text-center bg-info">
					<thead>
						<tr class="info">
							<th class="text-center">序号</th>
							<th class="text-center">活动名称</th>
							<th class="text-center">活动主题</th>
							<th class="text-center">活动主办方</th>
							<th class="text-center">活动时间</th>
							<th class="text-center">活动地点</th>
							<th class="text-center">活动流程</th>
							<th class="text-center">人员数</th>
							<th class="text-center">活动状态</th>
							<!-- <th class="text-center">操作</th> -->
						</tr>
					</thead>
					<tbody>

						<s:iterator var="act" value="actList">
							<!--                     <input type="hidden" value="#act.Volunteer_act_uid">
 -->
							<tr>
								<td><input type="checkbox" name="Volunteer_act_uid" value='<s:property value="#act.Volunteer_act_uid" />'></td>
								<td><s:property value="#act.Volunteer_act_name" /></td>
								<td><s:property value="#act.Volunteer_act_core" /></td>
								<td><s:property value="#act.Volunteer_act_spo" /></td>
								<td><s:property value="#act.Volunteer_act_date" /></td>
								<td><s:property value="#act.Volunteer_act_site" /></td>
								<td><s:property value="#act.Volunteer_act_flow" /></td>
								<td><s:property value="#act.Volunteer_act_mans" /></td>
								<td>
									<%--                         	<s:property value="#act.Volunteer_act_status"/>
 --%> <s:if test="#act.Volunteer_act_status==0">招募中</s:if> <s:if
										test="#act.Volunteer_act_status==1">进行中</s:if> <s:if
										test="#act.Volunteer_act_status==2">已结束</s:if>

								</td>
							</tr>
						</s:iterator>

					</tbody>

				</table>
				<div>
					<button onclick="doAdd()" class="btn btn-primary btn-sm">添加</button>
					<button onclick="doEdit()" class="btn btn-primary btn-sm">编辑</button>
					<button onclick="doDel()" class="btn btn-primary btn-sm">删除</button>
					<button onclick="doUploadify()" class="btn btn-primary btn-sm" id="uploadify1">上传</button>
					<input id="uploadify" type="file"
                    name="Filedata" />
				</div>

				<!-- 分页 -->
				<ul class="pagination right">
					<li class="disabled"><a href="#" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
				</ul>
			</div>
			<!--右侧内容结束-->
		</div>
	</div>
	</section>

	<footer class="bg-primary navbar-fixed-bottom">
	<p class="text-center text-white">版权所有&copy;IceTea</p>
	</footer>
	<script src="js/jquery-1.11.3.js"></script>
	
	<!-- 上传插件uploadify的js -->
	<script src="js/fileupload/jquery.uploadify.js"></script>
	
	<script src="js/bootstrap.js"></script>
	<script src="js/icetea.js"></script>
	<script src="js/layer/layer.js"></script>
	<script type="text/javascript">

	function doAdd(){ 
		//添加数据 用layer弹窗插件
		var $flag = $('#flag').val();
		
		var url="${pageContext.request.contextPath}/t_addAct.action";
		layer.open({
			type:2,
			title:'添加活动信息',
			shadeClose:false,
			shade:0.8,
			btn:['保存','取消'], 
			area:['800px','70%'],
			content:url,
			btn1:function(index,layero){
				layero.find("iframe")[0].contentWindow.doSubmit()
				layer.confirm('是否关闭录入窗口',{btn:['嗯']},function(){
					layer.close(index);
					layer.msg("已添加一条活动信息");
				})
			},
			end:function(){
				/* $.ajax({
					type:"post",
					dataType:'json',
					cache:false,
					data:"flag="+$flag,
					url:"${pageContext.request.contextPath}/act_queryForFlag.action",
					beforeSend:function(XMLHttpRequest){},
					success:function(data){
						var str = data.actList;
						layer.msg(str);
						$("#actList").attr("value","str");
					}
				}) */
				doQuery();
			}
		})
	}
	
	function doEdit(){
		//修改功能 获取被选择的值 是一个数组
		var temp = new Array();
		temp = $('input[name="Volunteer_act_uid"]:checked');
		
		console.log(temp[0].value);
		if(temp.length==0){
			window.top.layer.msg("请选择一条记录");
			return;
		}
		if(temp.length>1){
			window.top.layer.msg("只能选择一条记录修改！");
			return;
		}
		if(temp.length==1){
			var hrEmpData = temp[0].value;
			 window.top.layer.open({
						type:2,
						shade:false,
						title:'活动信息修改',
						shadeClose:false,
						shade:0.8,
						area:['800px','70%'],
						content:'${pageContext.request.contextPath}/act_editAct.action?Volunteer_act_uid='+hrEmpData,
						btn:['确认','取消'],
						yes: function(index, layero){
							 //获取弹出层对象 jquery找到form表单的id 然后submit
					          layero.find("iframe")[0].contentWindow.doSubmit();
							 //内嵌一个open弹出层 确认按钮之后 然后做一个弹出层的关闭
					           layer.open({
					        	  content:'已经修改',
					        	  btn:['确定'],
					        	  yes:function(index2,layero){
					        		  layer.closeAll();
					        	  }
					          }) 
							},
							no:function(){
								return;
							},
							end: function () {
								layer.msg("已经修改一条记录");
								doQuery();
				            }						
			});  
		}
	}

	function doDel(){
		//删除某条记录
		var temp = new Array();
		var temps = "?1=1";
		temp = $('input[name="Volunteer_act_uid"]:checked');
		console.log(temp[0].value);
		//将temp数组组成一个字符串
		for(var i=0;i<temp.length;i++){
			temps += "&uid="+temp[i].value;
		}
		console.log(temps);
		layer.confirm(
				'确认删除'+temp.length+'条记录',
				{btn:['确认','取消']},
				function(index){
			//确认删除 发送一个ajax请求
			 $.ajax({
				type:"post",
				dataType:'json',
				data:temps,
				url:"${pageContext.request.contextPath}/act_delAct.action",
				success:function(respData){
					/* window.top.layer.msg('成功删除'+temp.legth+'条记录');
					//然后就是ajaxenywhere的事情了 卧槽 这个鸡巴到底要怎么写 好难ajaxenywhere
					layer.close(index); */
					
				}
			}) 
			layer.close(index);
			window.top.layer.msg('成功删除'+temp.length+'条记录');
			doQuery();
		},function(){
			//返回重新选择
			return;
		})
	}	
	$(function(){
	$("#uploadify").uploadify({
		//上传的信息设置
        'swf': 'js/fileupload/uploadify.swf',//上传使用的Flash
        'uploader': '${pageContext.request.contextPath}/act_testUpload.action',//服务端处理地址
        'method'   :'post',//请求方式
        'queueID': 'fileQueue',
        'auto': true,//选择完文件后自动上传为true 不自动为false
        'multi': false,//允许多文件上传true 不允许为false
        'width': '70',//按钮的宽度
        'height':'20',//按钮的高度
        'buttonClass': null,
        'buttonText':'选择文件',//按钮上的文字信息
        'queueSizeLimit' : 1,//同时上传文件的个数
        'successTimeout':9999,//永不超时 超时时间设置
        'fileTypeExts' : '*.txt;',
    });
	});
	function doQuery(){
		$('#select_form').submit();
		 
	}
</script>
	
</body>
</html>