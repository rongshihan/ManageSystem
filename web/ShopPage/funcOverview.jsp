<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
	<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../css/favicon.ico">
    <title>汽车销售管理系统-功能概览</title>
	<!-- css引用 -->
    <!-- Bootstrap core CSS -->
    <link href="../style/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../style/css/childstyle.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../style/css/childmenu.css" type="text/css" media="screen">
	<link rel="stylesheet" href="../style/css/bootstrap-table.css"/>
	<link rel="stylesheet" href="../style/css/bootstrap-table-fixed-columns.css"/>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../style/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../style/css/dashboard.css" rel="stylesheet">
	<link href="../style/css/carousel.css" rel="stylesheet">

    <script src="../style/js/ie-emulation-modes-warning.js"></script>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!--jquery和box和bootstrap-->
	<script type="text/javascript" src="../style/js/jquery.min.js"></script>
	<script type="text/javascript" src="../style/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script><!-- 如果断网，需要下载这个js -->
	<script type="text/javascript" src="../style/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="../style/js/bootstrap-table-zh-CN.js"></script>


    </head>

    <body>
	    <style type="text/css">
		    #result{
			    width: 800px;
			    height:500px;
			    border:1px solid #eee;
		    }
		    #result img{
			    height:500px;
		    }
	    </style>
		
		<!--上方导航栏-->
	    <nav class="navbar navbar-inverse navbar-fixed-top">
		    <div class="container-fluid">
				<div class="navbar-header" >
					<img src="../../style/images/mainlogo.png" style="width:50px">
				</div>
			    <div class="navbar-header">
		  		    <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
			    </div>
			    <div>
				    <p id= "huanying" class="navbar-brand" align="right"><font size="4">用户：<a href="/SwitchPage?page=setpage">${userid}</a> </font></p>
			    </div>

			    <div id="navbar" class="navbar-collapse collapse">
				    <ul class="nav navbar-nav navbar-right">
						<li><a href="/SwitchPage?page=homepage" ><font size="3">系统主页</font></a></li>
						<li><a href="/SwitchPage?page=funcpage" class="active" ><font size="3">使用功能</font></a></li>
						<li><a href="/SwitchPage?page=setpage" ><font size="3">用户设置</font></a></li>
						<li><a href="/SwitchPage?page=helppage" ><font size="3">帮助界面</font></a></li>
				    </ul>
			    </div>
		    </div>
	    </nav>
		<!--//上方导航栏-->
		
		
		<!--内容-->
	    <div class="container-fluid">
		
			<!-- 左边导航栏 -->
		    <div class="col-sm-3 col-md-2 sidebar">
			    <ul class="nav nav-sidebar">
				    <li class="active"><a href="/SwitchPage?page=funcpage">功能概览</a></li>
				    <li><a href="/SwitchPage?page=funcViewCar" >查询车辆信息</a></li>
				    <li><a href="/SwitchPage?page=funcUploadCar" >上传车辆信息</a></li>
				    <li><a href="/SwitchPage?page=funcViewAppointment" >查询客户预约</a></li>
				    <li><a href="/SwitchPage?page=funcPushMsg" >发布通知</a></li>
					<li><a href="/SwitchPage?page=funcRegister" >登记客户车辆</a></li>
					<li><a href="/SwitchPage?page=funcViewReg" >查询登记车辆</a></li>
					<li><a href="/SwitchPage?page=funcViewRecord" >查看浏览记录</a></li>
					<li><a href="/SwitchPage?page=funcDataAnalyze" >浏览数据分析</a></li>
				    <!--功能可以继续扩展-->
			    </ul>
		    </div>
			<!-- //左边导航栏 -->

			<!-- 控制输出内容在右半部分 -->
		    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			    
			    <div class="tab-content">
				
				
					<!--功能概览-->
				    <div class="tab-pane fade in active">
					    <p>
						    <font size="6">
						    在这里可以看到功能的概览
						    </font>
					    </p>
				    </div>
					<!-- START THE FEATURETTES -->

					<hr class="featurette-divider">

					<div class="row featurette">
						<div class="col-md-7 col-md-push-5">
							<h2 class="featurette-heading">
								汽车销售管理系统 </br> <span class="text-muted">  </span></h2>
							<p class="lead">专为汽车4S店、二手车、新车经销商设计的车辆销售管理系统。系统功能强大、操作简单、容易上手。</p>
						</div>
						<div class="col-md-5 col-md-pull-7">
							<img class="featurette-image img-responsive center-block" src="../style/images/client-manage.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
						</div>
					</div>

					<hr class="featurette-divider">

					<div class="row featurette">
						<div class="col-md-7 col-md-push-5">
							<h2 class="featurette-heading">精细化管理客户 <span class="text-muted">  </span></h2>
							<p class="lead">程序化快速建档，自有服务器存储客户信息，避免客户数据丢失；精准管理客户信息，定期整理站内数据</p>
						</div>
						<div class="col-md-5 col-md-pull-7">
							<img class="featurette-image img-responsive center-block" src="../style/images/car-manage.png" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
						</div>
					</div>

					<hr class="featurette-divider">

					<div class="row featurette">
						<div class="col-md-7 col-md-push-5">
							<h2 class="featurette-heading">精准方便的数据分析<span class="text-muted">  </span></h2>
							<p class="lead">详细记录客户信息，更好的把控客户进度，以多种形式自动生成报告，反映总体需求，指导企业战略调整</p>
						</div>
						<div class="col-md-5 col-md-pull-7">
							<img class="featurette-image img-responsive center-block" src="../style/images/team.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
						</div>
					</div>


					<hr class="featurette-divider">

					<!-- /END THE FEATURETTES -->
					<!--//功能概览-->
					
					
				  
			    </div>
		    </div>
			<!-- //控制输出内容在右半部分-->

	    </div>

		<!--内容--> 
			
	    </div>
    </body>
</html>