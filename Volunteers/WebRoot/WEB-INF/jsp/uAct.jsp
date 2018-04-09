<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>主页</title>

<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/index/fonts/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet">
<link href="index/css/owl.theme.default.css" rel="stylesheet">
<link href="index/css/animate.min.css" rel="stylesheet">
<link href="index/css/magnific-popup.css" rel="stylesheet">
<link href="index/css/tagsinput.css" rel="stylesheet">
<link href="index/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="js/layer/skin/layer.css" />
</head>
<body>
<!-- 导航部分 -->
<div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">导航栏</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/user_goIndex.action">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/user_goInfo.action">我的参与</a></li>
                <li  class="active"><a href="${pageContext.request.contextPath}/user_goUserForAct.action">活动报名</a></li>
                
              </ul>
              <ul class="nav navbar-nav navbar-right hidden-sm">
            	<li><a href="${pageContext.request.contextPath}/t_quit.action" >退出登录</a></li>
         	 </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

<div class="section Latest-jobs-section">
	<div class="inner">
		<div class="container">
		<hr>
			<div class="section-top-content flex items-center">
			
			</div> <!-- end .section-top-content -->
			<div class="jobs-table">
				<div class="table-header">
					<div class="table-cells flex">
						<div class="job-title-cell"><h6>&nbsp&nbsp&nbsp活动主题&&主要内容</h6></div>
						
						<div class="location-cell"><h6>活动主办方</h6></div>
						<div class="expired-date-cell"><h6>活动日期</h6></div>
						<div class="salary-cell"><h6>参与人数</h6></div>					
						<div class="job-type-cell"><h6>操作</h6></div>	
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-header -->
				<s:iterator var="vo" value="act_List">
				<div class="table-row">
					<div class="table-cells flex no-wrap">
						<div class="cell job-title-cell flex no-column no-wrap">
							
							<div class="content">
								<h4><a href="#"><s:property value="#vo.Volunteer_act_name" /></a></h4><!-- 活动名称 -->
								<p class="small"><s:property value="#vo.Volunteer_act_core" /></p><!-- 活动内容 -->
							</div> <!-- end .content -->
						</div> <!-- end .job-title-cell -->
						
						<div class="cell location-cell flex no-column no-wrap">
							<div class="cell-mobile-label"><!-- 活动主办方 -->
								<h6><s:property value="#vo.Volunteer_act_spo" /></h6>
							</div> <!-- end .cell-label -->
							<p><s:property value="#vo.Volunteer_act_spo" /></p>
						</div>
						<div class="cell expired-date-cell flex no-column no-wrap">
							<div class="cell-mobile-label"><!-- 活动日期 -->
								<h6>Expired date</h6>
							</div> <!-- end .cell-label -->
							<p><s:property value="#vo.Volunteer_act_date" /></p>
						</div>
						<div class="cell salary-cell flex no-column no-wrap">
							<div class="cell-mobile-label"><!-- 参与人数 -->
								<h6>Salary</h6>
							</div> <!-- end .cell-label -->
							<p><s:property value="#vo.Volunteer_act_mans" /></p>
						</div>
						<div class="cell job-type-cell flex no-column no-wrap">
							<div class="cell-mobile-label"><!-- 活动状态 -->
								<h6><s:property value="#vo.Volunteer_act_name" /></h6>
							</div> <!-- end .cell-label -->
							<s:if test="#vo.Volunteer_act_status==0">
								<button type="button" onclick="doRec(<s:property value="#vo.Volunteer_act_uid" />)" class="button full-time">我要报名</button>
							</s:if>
							<s:if test="#vo.Volunteer_act_status==1">
								<button type="button" class="button part-time">进行中</button>
							</s:if>
							<s:if test="#vo.Volunteer_act_status==2">
								<button type="button" class="button freelancer">已结束</button>
							</s:if>
						</div>
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-row -->						
				</s:iterator>
				<div class="table-footer flex space-between items-center">
					<h6>Showing<span>1-5</span>of 23 jobs</h6>
					<div class="jobpress-custom-pager list-unstyled flex space-between no-column items-center">
						<a href="#0" class="button"><i class="ion-ios-arrow-left"></i>Prev</a>
						<ul class="list-unstyled flex no-column items-center">
							<li><a href="#0">1</a></li>
							<li><a href="#0">2</a></li>
							<li><a href="#0">3</a></li>
							<li><a href="#0">4</a></li>
							<li><a href="#0">5</a></li>									
						</ul>
						<a href="#0" class="button">Next<i class="ion-ios-arrow-right"></i></a>
					</div> <!-- end .jobpress-custom-pager -->
				</div>
			</div> <!-- end .jobs-table -->
		</div> <!-- end .container -->
	</div> <!-- end .inner -->
</div> <!-- end .section -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

<script src="js/layer/layer.js"></script>
<script type="text/javascript">
	function doRec(temp){
		console.log(temp);
		var temps="uid="+temp;
		$.ajax({
			type:"post",
			dataType:'json',
			data:temps,
			url:"${pageContext.request.contextPath}/rec_doRec.action",
			success:function(respData){
				if(respData.success){
					layer.msg("报名成功",{icon:1});
				}else{
					layer.msg("报名有误",{icon:2})
				}
				location.replace(location.href);
			}
		})
		
	}
</script>
</body>
</html>