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
                <li class="active"><a href="#">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/user_goInfo.action">我的参与</a></li>
                <li><a href="${pageContext.request.contextPath}/user_goUserForAct.action">活动报名</a></li>
                
              </ul>
              <ul class="nav navbar-nav navbar-right hidden-sm">
            	<li><a href="${pageContext.request.contextPath}/t_quit.action" >退出登录</a></li>
         	 </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

<!-- 主体部分文字展示 -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <!-- <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol> -->
      <div class="carousel-inner" role="listbox">
      
      <s:iterator var="vo" status="s" value="actList">
      <s:property value="s.index+1" />
      <s:if test='#s.index==0'>
      	 <div class="item active"> 
          <div class="container">
            <div class="carousel-caption">
            <!-- 后台获取标题  -->
            <!-- 在数据库中日期最新前三的 -->
              <h1><s:property value="#vo.Volunteer_act_name" /></h1><!-- 活动名称放这里VOLUNTEER_ACT_NAME -->
              <p><s:property value="#vo.Volunteer_act_core" /></p><!-- 活动主题VOLUNTEER_ACT_CORE -->
              <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/user_goUserForAct.action" role="button">带上我</a></p>
            </div>
          </div>
          </div>
      </s:if>
      <s:else>
      <div class="item">
      	<div class="container">
            <div class="carousel-caption">
            	<!-- 后台获取标题  -->
            	<!-- 在数据库中日期最新前三的 -->
              	<h1><s:property value="#vo.Volunteer_act_name" /></h1><!-- 活动名称放这里VOLUNTEER_ACT_NAME -->
             	<p><s:property value="#vo.Volunteer_act_core" /></p><!-- 活动主题VOLUNTEER_ACT_CORE -->
              	<p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/user_goUserForAct.action" role="button">带上我</a></p>
            </div>
          </div>
        </div>
      </s:else>
         
      </s:iterator> 
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    
    <ul class="nav nav-tabs jobpress-dynamic-tabs flex space-center items-center no-column">
		<li class="active"><a data-toggle="tab" href="#company"><i class="ion-ios-glasses-outline"></i>Company</a></li>
		<li><a data-toggle="tab" href="#how-it-works"><i class="ion-ios-cog-outline"></i>How it works</a></li>
		<li><a data-toggle="tab" href="#team"><i class="ion-ios-person-outline"></i>Team</a></li>
		<li><a href="#"><i class="ion-ios-help-empty"></i>Faq</a></li>
		<li><a href="#"><i class="ion-ios-email-outline"></i>Contact Us</a></li>
	</ul>
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
</body>
</html>