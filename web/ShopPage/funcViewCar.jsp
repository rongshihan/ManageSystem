<%@ page import="basic.KeyValuePair" %>
<%@ page import="java.util.List" %>
<%@ page import="basic.Carinfo" %>
<%@ page import="DAO.CarDAO" %>
<%@ page import="DAO.DAOFactory" %><%--
Created by IntelliJ IDEA.
User: 17308
Date: 2018/7/3
Time: 18:46
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
	<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>汽车销售管理系统-查询车辆</title>
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
	<link href="../style/css/style1.css" rel="stylesheet">
		<script src="../style/js/jquery-1.7.1.min.js"></script>
		<script src="../style/js/ui.js"></script>
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
		    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			    
			    <div class="tab-content">				
					<!--查看你旗下的车辆信息-->
					<form action="/Search">
						<p>
							<font size="6">
								在这里你可以查看你旗下的车辆信息
							</font>
						</p></br>
						<%List<Carinfo> carinfos = (List<Carinfo>) request.getAttribute("searchcars");int i = 0;%>
						<%CarDAO carDAO = DAOFactory.getCarDAO();
						List<String> brands = carDAO.findAllBrand();
						List<String> types = carDAO.findAllType();%>
						<label>品牌</label>
						<select name="Bybrand" style="width:100px;height:35px">
							<option value="">所有品牌</option>
							<%for(int n = 0;n<brands.size();n++){%>
							<option><%=brands.get(n)%></option>
							<%}%>
						</select>
						<label>类型</label>
						<select name="Bytype" style="width:100px;height:35px">
							<option value="">所有类型</option>
							<%for(int n = 0;n<types.size();n++){%>
							<option><%=types.get(n)%></option>
							<%}%>
						</select>
						<button id="queryBtn2" type="submit" class="btn btn-default" class="btn-group pull-left" style="margin-left: 10px;">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
					</form>

					<input type="hidden" id="msg" value=<%=request.getAttribute("msg")%>
					<p></br></br>
						<font size="4">
							查询结果
						</font>
					</p></br>

					<table class="table table-bordered table-striped">
						<thead>

						<tr>
							<th>品牌</th>
							<th>型号</th>
							<th>车型</th>
							<th>库存</th>
							<th>价格</th>
							<th>详情</th>
							<th>更新</th>
						</tr>
						</thead>
						<%for(Carinfo carinfo:carinfos){%>
						<tr>
							<th><%=carinfo.getBrand()%></th>
							<th><%=carinfo.getModel()%></th>
							<th><%=carinfo.getType()%></th>
							<th><%=carinfo.getStock()%></th>
							<th>¥<%=carinfo.getPrice()%></th>
							<th><a href="/jumpupdate?action=search&brand=<%=carinfo.getBrand()%>&model=<%=carinfo.getModel()%>" >
								<button  type="button" class="btn btn-info" class="btn-group pull-left" style="margin-left: 10px;">
									<span class="glyphicon glyphicon-equalizer" aria-hidden="true"></span>查看详情</button>
							</a></th>
							<th><a href="/jumpupdate?action=update&brand=<%=carinfo.getBrand()%>&model=<%=carinfo.getModel()%>" >
								<button  type="button" class="btn btn-info" class="btn-group pull-left" style="margin-left: 10px;">
									<span class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>更新信息</button>
							</a></th>
							<%i++;}%>
						</tr>
					</table>
			    </div>
		    </div>
			<!-- //控制输出内容在右半部-->

	    </div>

		<!--内容--> 
			
	    </div>
    </body>
</html>
<script>
	var msg = document.getElementById("msg").value;
	if(msg.localeCompare(null)) {
        mizhu.alert('', msg);
    }
</script>