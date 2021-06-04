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
    <title>汽车销售管理系统-帮助</title>
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
		
		<!--导航栏-->
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
						<li><a href="/SwitchPage?page=funcpage" ><font size="3">使用功能</font></a></li>
						<li><a href="/SwitchPage?page=setpage" ><font size="3">用户设置</font></a></li>
						<li><a href="/SwitchPage?page=helppage" class="active" ><font size="3">帮助界面</font></a></li>
				    </ul>
			    </div>
		    </div>
	    </nav>
		<!--//导航栏-->


		<div class="tab-content">
			<!--内容-->
			<div class="container-fluid">

				<!-- 左边空白部分 -->
				<div class="col-sm-3 col-md-2 sidebar">

				</div>
				<!-- //左边空白部分 -->


				<!-- 控制输出内容在右半部分 -->
				<div class="col-sm-9 col-sm-offset-3 col-md-7 col-md-offset-2 main">
					<!--帮助手册内容-->
					<div>
						<h1><font>帮助手册</font></h1>
						<hr>
						<h2>1. 概述</h2>
						<h3>1.1 需求和背景</h3>
						<p>实际4S店运营过程中，一直存在着营销手段单一、流程繁琐落后、信息传输速度慢、运营获客成本高、利润快速下降等缺点，4S店运营预期不断下滑，行业发展严峻，竞争激烈。本系统帮助4S店提升运营水平，满足终端用户需求。</p>
						<h3>1.2 服务对象</h3>
						<p>本产品主要面向各种4S店和经销商，适用于连锁形式的经销商，帮助他们统一管理品牌，客户以及各种业务信息，提升服务水准和效率，增加利润。</p>
						<h3>1.3 组成和简介</h3>
						<p>本项目主要分为三个部分：面向经销商的PC端、面向客户的手机端、微信公众号。其中PC端主要由各个经销商操作和管理，主要用来处理各种业务；手机端主要为客户提供在线的服务平台，包括汽车的展示，各种预约的提交以及客户个人的个性化数据管理。微信端主要利用公众号平台为经销商，现有客户和潜在客户提供一个额外的简便的交互平台，目前可以实现每日的推送以及自动回复功能，菜单中还提供了部分用户手机网页的链接（目前公众号尚未完成认证，功能尚未完善，敬请期待）</p>
						<hr>
						<h2>2. 经销商帮助文档</h2>
						<br/>
						<h3>2.1 页面介绍</h3><br/>
						<h4>2.1.1 注册和登录页面</h4>
						<p>经销商在加盟之后，可以在网上注册一个账号来登录我们的系统，进而在系统中实现各种管理操作。</p>
						<h4>2.1.2 导航栏</h4>
						<p>在系统内所有的页面中，我们都有一个可以快速移动都页面内各个位置的导航栏。导航栏主要可以跳转到四个页面：主页，功能页面，用户设置页面以及帮助界面。你也可以在这里看到你当前所登录的用户。</p>
						<h4>2.1.3 主页</h4>
						<p>登录后自动进入系统的主页，主页主要由两部分组成：管理系统主页的广告和快速入口。经销商可以在管理系统的主页看到我们整个系统统一的广告推送栏位。下方是三个快速的功能入口，这些功能可以在上方导航栏中的“使用功能”页面中寻找到对应的功能标签。</p>
						<h4>2.1.4 功能页面</h4>
						<p>在导航栏单击“使用功能”标签即可进入使用功能界面。这个界面有一个子菜单，分别对应了系统的各种主要功能，是我们系统的核心部分。你可以通过点击屏幕左侧的导航标签来进入不同的功能页面。</p>
						<h4>2.1.5 设置页面</h4>
						<p>在这里经销商可以修改自己的相关信息：地址信息，联系方式，经销商基本描述之类，但注意：经销商的名字和注册ID是无法自己修改的，如果有必要，还请联系管理员进行修改。</p>

						<br/>
						<h3>2.2 功能介绍</h3><br/>
						<h4>2.1.1 功能概览</h4>
						<p>在系统中任何位置点击导航栏中的“使用功能”标签即可自动跳转到这个页面。这个页面没有实际的操作空间，主要是一些关于系统的基本介绍。</p>
						<h4>2.1.2 查询旗下车辆信息</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“查询车辆信息”。在这个页面中，你可以查看当前经销商所有的车辆的品牌型号，数量和标价信息。你也可以在上方输入你的筛选条件查看特定条件的车辆信息。</p>
						<h4>2.1.3 车辆信息修改</h4>
						<p>在上面介绍的查询当前经销商的页面中，单击每一条车辆嘻信息后面的查看详情按钮即可查看该车辆的完整信息以及它在系统中所展示的图片。如果想要修改，则需要点击每条车辆信息后面的“更新信息”按钮，在这里，你可以在这里修改车辆的库存，售价，还可以上传车辆的图片。</p>
						<h4>2.1.4 上传新车辆信息</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“上传车辆信息”。在这里，你可以上传一辆你库存中没有记录的车辆的信息，同时你能上传一张图片。如果你想要上传更多的图片，你则需要在之前的“修改车辆信息”页面中进行补充和上传。</p>
						<h4>2.1.5 查询客户预约信息</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“查询客户预约”。在这里你可以查询当前经销商所有客户的预约信息：包括试驾预约，保养预约以及维修预约。你可以在上方输入筛选条件来选择查看特定的一些预约记录。</p>
						<h4>2.1.6 处理客户预约</h4>
						<p>在查询客户预约页面中，每一条预约信息的后面都会有查看预约或者处理预约的按钮（这是根据该预约的当前状态自动决定的），单击这些按钮，即可进入对应预约记录的功能页面，你可以选择接受客户的预约或者拒绝客户的预约，同时附上一些立候和备注信息。</p>
						<h4>2.1.7 发布通知</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“发布通知”。在这个地方，作为经销商可以发布一条通知，这条通知可以被所有客户看到，适合发布一些重要的信息，当然仅限于文字通知，如果想要推广的话，还是选择其他方式吧。</p>
						<h4>2.1.8 登记车辆</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“登记客户车辆”。客户在4S店购买车辆之后，将能够享受4S店的一些福利待遇，然而这些服务需要客户登记在案才可以实现，所以在客户完成基本的购车流程之后，需要进行相关车辆的登记操作，这样客户在以后选择相应的服务时，就可以直接选择自己相应的车辆了。</p>
						<h4>2.1.9 查询登记车辆</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“查询登记车辆”。作为经销商，需要把握自己旗下到底有多少客户登记了车辆，登记的情况如何。在这里我们可以很轻松地查询到当前经销商旗下所登记的所有车辆的信息。你也可以在上方输入一些条件来进行范围筛选。</p>
						<h4>2.1.10 查看客户浏览记录</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“查看浏览记录”。我们的系统有一套自己的浏览记录系统，客户浏览某种车辆的次数，时间，都会被记录下来，用以做4S的运营参考。在这里你可以查看旗下每种车辆的浏览记录，包括浏览的次数，浏览的客户数量。你还可以在上方输入特定的时间区间，从而查看在某个时间段中每种车型的浏览情况。同时，单击每条车辆信息的后面的按钮，可以进而查看到浏览过这辆车的所有客户和他们的浏览次数，从而识别对这辆车特别关心的客户。</p>
						<h4>2.1.11 浏览数据分析</h4>
						<p>点击导航栏中的“使用功能”点击左侧的“浏览数据分析”。在这里，我们提供了快速简便的数据分析工具：图表绘制工具，你可以根据近期的浏览数据绘制出浏览记录的柱状图和饼状图，从而更加直观地看出特定时间内的用户动向，分析潜在的客户群体。</p>
						<br/>
						<hr>
						<h2>3. 团队介绍</h2>
						<br/>
						<p>VISpeed,一个由六名成员组成的小团队，在半个月时间内完成了这个系统的基本功能，可能还有许多不足之处，敬请谅解。感谢您的使用！</p>
						<p>欢迎提供您宝贵的意见：9078390897@qq.com</p>
					</div>


					<!--帮助手册内容-->



					<div class="container">
						<div style="position:fixed; top: 58%; right:0px; text-align: center;">
							<span>关注我们</span>
							<img src="../style/images/公众号二维码.jpg" class="img-responsive" alt="Cinque Terre" width="200" height="150">
						</div>

						<button onclick="topFunction()" id="myBtn" title="返回顶部">返回顶部</button>

					</div>



				</div>
				<!-- //控制输出内容在右半部分 -->


			</div>
			<!--内容-->

		</div>
		<style type="text/css">
			#myBtn {
				display: none;
				position: fixed;
				bottom: 20px;
				right: 30px;
				z-index: 99;
				border: none;
				outline: none;
				background-color: rgb(15,130,218);
				color: white;
				cursor: pointer;
				padding: 15px;
				border-radius: 10px;
			}
			#myBtn:hover {
				background-color: #555;
			}
		</style>

		<script type="text/javascript">
            window.onscroll = function() {scrollFunction()};

            function scrollFunction() {console.log(121);
                if (document.body.scrollTop > 20 || document.documentElement	.scrollTop > 20) {
                    document.getElementById("myBtn").style.display = "block";
                } else {
                    document.getElementById("myBtn").style.display = "none";
                }
            }
            function topFunction() {
                document.body.scrollTop = 0;
                document.documentElement.scrollTop = 0;
            }
		</script>

	</body>
</html>