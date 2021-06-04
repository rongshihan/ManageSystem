<%@ page import="model.Car" %>
<%@ page import="model.Shopowncar" %>
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
    <title>车辆信息</title>
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
			#myimg{
				width: 100px;
				height:100px;
				border:1px solid #eee;
			}
	    </style>
		
		<!--上方导航栏-->
	    <nav class="navbar navbar-inverse navbar-fixed-top">
		    <div class="container-fluid">
				<div class="navbar-header">
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
						<li><a href="/SwitchPage?page=homepage"><font size="3">系统主页</font></a></li>
						<li><a href="/SwitchPage?page=funcpage"><font size="3">使用功能</font></a></li>
						<li><a href="/SwitchPage?page=setpage"><font size="3">用户设置</font></a></li>
						<li><a href="/SwitchPage?page=helppage"><font size="3">帮助界面</font></a></li>
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
                    <li><a href="/SwitchPage?page=funcpage">功能概览</a></li>
                    <li class="active"><a href="/SwitchPage?page=funcViewCar" >查询车辆信息</a></li>
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
			<%Car c = (Car) request.getAttribute("car");%>
			<%Shopowncar soc = (Shopowncar) request.getAttribute("soc");%>

		    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			    <div class="w3ls-details">   
					<!--车辆信息-->	
					<div class="w3ls-text">
						<h4>车辆信息</h4>
						<p><b>品牌 :</b> <%=c.getBrand()%> </p>
						<p><b>型号 :</b> <%=c.getModel()%> </p>
						<p><b>车型 :</b> <%=c.getType()%> </p>
						<p><b>库存 :</b> <%=soc.getStock()%> </p>
						<p><b>参考价格 :</b> ¥<%=soc.getPrice()%> </p>
						<p><b>车辆简介 :</b> <%=soc.getDescription()%> </p>
						<br/>
						<h4>车辆图片</h4> 
					</div>
					<!--车辆信息-->
					<br/>
					<br/>
					<div display:block>
					<%if(soc.getPic_url()!=null){%>
					<%String []imgs=soc.getPic_url().split("--");
					for(int i = 0;i<imgs.length;i++){%>
					<img class="thumbnail" 
					align = "left"
					width="280" height="192"
					src=<%=imgs[i]%> data-src="holder.js/500x500/auto"
					>
					<%}%>
					<%}%>

					</div>
					<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

						<div>
						<a href="/carback?userid=<%=soc.getShopuser_id()%>&carid=<%=soc.getCar_id()%>">
							<button id="addBtn" name="access" type="submit" value="返回" class="btn btn-danger">
								<span class="glyphicon glyphicon-step-backward" aria-hidden="true"></span>返回
							</button>
						</a>
						</div>

				</div>
					
			    
		    </div>
			<!-- //控制输出内容在右半部分 -->

	    </div>
		<!--内容--> 
			
	    </div>
    </body>
</html>