 <%@ page import="java.util.Map" %>
<%@ page import="basic.Carview" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>main</title> 
<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fortune Estates Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, SmartPhone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->
<!-- Custom Theme files -->
<link href="../../style/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="../../style/css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="../../style/css/ken-burns.css" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- js -->
<script src="../../style/js/jquery-2.2.3.min.js"></script>
<!-- //js -->
<!-- pop-up-box -->
<script src="../../style/js/jquery.magnific-popup.js" type="text/javascript"></script>
	    <script>
			$(document).ready(function() {
				$('.popup-top-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
				});																							
			}); 
</script>
<!--//pop-up-box -->
<!-- web-fonts -->  
<link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- //web-fonts -->
</head>
<body class="bg">
	<div class="agile-main"> 
		<div class="menu-wrap" id="style-1"> 
			<nav class="top-nav">
				<ul class="icon-list">
					<li class="menu-title">CarManage</li>
					<li><a class="active" href="/jump?action=homepage"><i class="glyphicon glyphicon-home"></i> 主页 </a></li>
					<li><a href="/jump?action=personal_info"><i class="glyphicon glyphicon-info-sign"></i> 个人信息 </a></li>
					<li><a href="/jump?action=testdrive"><i class="glyphicon glyphicon-eye-open"></i> 寻车试驾 </a></li>
					<li><a href="/jump?action=viewcar"><i class="glyphicon glyphicon-picture"></i> 豪车鉴赏</a></li>
					<li><a href="/jump?action=reserve"><i class="glyphicon glyphicon-envelope"></i> 养修预约 </a></li>
					<li><a href="/jump?action=apt_record"><i class="glyphicon glyphicon-briefcase"></i> 预约历史 </a> </li>
					<li><a href="/jump?action=viewhistory"><i class="glyphicon glyphicon-list-alt"></i>浏览历史</a></li>
					<li><a href="/jump?action=help"><i class="glyphicon glyphicon-list-alt"></i> 帮助</a></li>
				</ul>
			</nav>
			<button class="close-button" id="close-button">C</button>
		</div> 
		<div class="content-wrap">
			<div class="header"> 
				<div class="menu-icon">   
					<button class="menu-button" id="open-button">O</button>
				</div>

				<div class="clearfix"> </div>
			</div>
			<div class="content">
				<!-- banner -->
				<div class="banner about-banner"> 
					<div class="banner-img" style=" background: url(../../style/images/first.jpg)no-repeat center";>
						<h3>主页</h3>   
					</div> 
				</div>
				<!-- //banner -->
				<!-- welcome -->
				<div class="welcome">
					<div id="myCarousel" class="carousel slide">

						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner">
                            <%Map<Carview,Double> carviewDoubleMap  = (Map<Carview,Double>)session.getAttribute("car_priority");
                            int i  = 1;%>
                            <%for(Map.Entry<Carview,Double> entry:carviewDoubleMap.entrySet()) {%>
                            <%if(i==1){%>
                            <div class="item active">
                                <a href="/jump?action=car_detail&carid=<%=entry.getKey().getCar_id()%>&shopuserid=<%=entry.getKey().getShopuser_id()%>"><img src=<%=entry.getKey().getPic_url().split("--")[0]%> alt="无图片"></a>
                            </div>
                            <%}%>
                            <%if(i<4&&i>1){%>
							<div class="item">
								<a href="/jump?action=car_detail&carid=<%=entry.getKey().getCar_id()%>&shopuserid=<%=entry.getKey().getShopuser_id()%>"><img src=<%=entry.getKey().getPic_url().split("--")[0]%> alt="无图片"></a>
							</div>
							<%}%>
                            <%i++;%>
							<%}%>
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
				</div>
				<!-- //welcome -->
				<!-- properties -->


				<!--	最新消息模块		-->
				<div class="row" style="margin-top: 20px;">
					<div class="col-xs-10 col-xs-offset-1">
						<div class="list-group">
							<a href="/jump?action=trendslist" class="list-group-item active">
								<h4 class="list-group-item-heading">
									最新消息 <span style="font-size: 80%;">&nbsp;&nbsp;&nbsp;查看更多>></span>
								</h4>
							</a>
							<c:forEach var="U" items="${news}" begin="0" end="4">
								<div class="properties-bottom">
									<div  class="w3ls-text" style="text-overflow:ellipsis;">
										<a href="/jump?action=trends&title=${U.title}&shopuser_id=${U.shopuser_id}" name="news_id"><font size="4">${U.title}</font></a><!--通知1-->
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
				<!-- //welcome -->
				<!-- properties -->
				<div class="w3agile properties">
					<div class="properties-top">
						<h3 class="w3ls-title">功能入口</h3>

					</div> 
					<div class="properties-bottom">
						<div class="properties-img">
							<img src="../../style/images/testdrive.jpg" alt="">
							<div class="view-caption">
								<h4><span class="glyphicon glyphicon-eye-open"></span></h4>  
							</div>
							<div class="w3ls-buy">
								<a href="/jump?action=testdrive">试驾</a>
							</div>
						</div>
						<div class="w3ls-text">
							<h6></h6>
							<p><b></b></p>
							<p><b></b></p>
						</div>
					</div> 
					<div class="properties-bottom">
						<div class="properties-img">
							<img src="../../style/images/g1.jpg" alt="">
							<div class="view-caption rent-caption">
								<h4><span class="glyphicon glyphicon-picture"></span></h4>  
							</div>
							<div class="w3ls-buy">
								<a href="/jump?action=viewcar" class="rent">鉴赏</a>
							</div>
						</div>
						<div class="w3ls-text">
							<h6></h6>
							<p><b></b></p>
							<p><b></b></p>
						</div>
					</div>
					<div class="properties-bottom">
						<div class="properties-img">
							<img src="../../style/images/repair.jpg" alt="">
							<div class="view-caption">
								<h4><span class="glyphicon glyphicon-envelope"></span></h4>  
							</div>
							<div class="w3ls-buy">
								<a href="/jump?action=reserve">养修</a>
							</div>
						</div>
						<div class="w3ls-text">
							<h5><a href="single.html"></a></h5>
							<h6></h6>
							<p><b></b></p>
							<p><b></b></p>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div> 
				<!-- //properties -->
				<!-- brands -->
				<div class="w3agile brands"> 

					<div class="brands-info">
						<div class="brand-grids">
							<img src="../../style/images/b1.jpg" alt=""/>
						</div>
						<div class="brand-grids">
							<img src="../../style/images/b2.jpg" alt=""/>
						</div>
						<div class="brand-grids">
							<img src="../../style/images/b3.jpg" alt=""/>
						</div>
						<div class="brand-grids">
							<img src="../../style/images/b4.jpg" alt=""/>
						</div>
						<div class="brand-grids">
							<img src="../../style/images/b5.jpg" alt=""/>
						</div>
						<div class="brand-grids">
							<img src="../../style/images/b6.jpg" alt=""/>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<!-- //brands -->
				<!-- footer -->
				<div class="w3agile footer"> 

				</div> 
			</div>
		</div>
	</div> 
	<!-- menu-js -->
	<script src="../../style/js/classie.js"></script>
	<script src="../../style/js/main.js"></script>
	<!-- //menu-js -->
	<!-- nice scroll-js -->
	<script src="../../style/js/jquery.nicescroll.min.js"></script>
	<script>
		$(document).ready(function() {
	  
			var nice = $("html").niceScroll();  // The document page (body)
		
			$("#div1").html($("#div1").html()+' '+nice.version);
		
			$("#boxscroll").niceScroll({cursorborder:"",cursorcolor:"#00F",boxzoom:true}); // First scrollable DIV
		});
	</script>
	<!-- //nice scroll-js -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../style/js/bootstrap.js"></script>
</body>
</html>