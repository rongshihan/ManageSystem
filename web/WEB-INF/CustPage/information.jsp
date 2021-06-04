<%@ page import="model.Customeruser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>imformation</title> 
<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fortune Estates Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, SmartPhone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->
<!-- Custom Theme files -->
<link href="../../style/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="../../style/css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="../../style/css/lightbox.css">

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
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});																							
	}); 
</script>
	<script language="javascript" type="text/javascript" src="../../style/js/My97DatePicker/WdatePicker.js"></script>
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
					<li><a href="/jump?action=homepage"><i class="glyphicon glyphicon-home"></i> 主页 </a></li>
					<li><a class="active" href="/jump?action=personal_info"><i class="glyphicon glyphicon-info-sign"></i> 个人信息 </a></li>
					<li><a href="/jump?action=testdrive"><i class="glyphicon glyphicon-eye-open"></i> 寻车试驾 </a></li>
					<li><a href="/jump?action=viewcar"><i class="glyphicon glyphicon-picture"></i> 豪车鉴赏</a></li>
					<li><a href="/jump?action=reserve"><i class="glyphicon glyphicon-envelope"></i> 养修预约 </a></li>
					<li><a href="/jump?action=apt_record"><i class="glyphicon glyphicon-briefcase"></i> 预约历史 </a> </li>
					<li><a href="/jump?action=viewhistory"><i class="glyphicon glyphicon-list-alt"></i> 浏览历史</a></li>
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
					<div class="banner-img">  
						<h3>个人信息</h3>   
					</div> 
				</div>
				<!-- //banner -->
				<!-- agents -->
				<!--这里需要动态显示用户的信息-->
				<div class="w3agile agents"> 
					<h3 class="w3ls-title">个人信息</h3> 
					<div class="w3agent-grid">
						<img src="../../style/images/head.jpeg">
						<div class="w3agent-text">
							<%Customeruser customeruser = (Customeruser)request.getAttribute("user_info");%>
							<h4><%=customeruser.getCus_name()%></h4>
							<p><i class="glyphicon glyphicon-earphone"></i><%=customeruser.getCus_phone()%></p>
							<p><i class="glyphicon glyphicon-info-sign"></i> <%=customeruser.getSex()%></p>
							<p><i class="glyphicon glyphicon-user" aria-hidden="true"></i><%=customeruser.getBirthday()%></p>
							<p><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i><%=customeruser.getAddress()%></p>
						</div>
					</div>
					
					<div class="clearfix"> </div>
				</div>
				<!-- //agents --> 
				
				<div class="w3agile gallery"> 
					 
					

			
					<!-- 按钮触发模态框 -->
					<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="margin-left: 80px">
						点击修改
					</button>
					<!-- 模态框（Modal） -->
					<div class="lightboxOverlay" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" display:block;>
						<!--提交表-->
						<div class="w3agile properties">
							<div class="w3ls-related">   
								<h3 class="w3ls-title">用户信息</h3>
								<div class="contact-form"> 
									<form action="/modify">
										<label>联系方式</label>
										<input type="text" name="phone" id="phone" value=<%=customeruser.getCus_phone()%> placeholder="联系方式" required=""
												onkeypress="keyPress();" onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')"
											   style="ime-mode: inactive">

										<label>性别</label>
										<div>
										<select name="sex" style="height: 38px" value=<%=customeruser.getSex()%> required="">
											<option>男</option>
											<option>女</option>
										</select>
										</div>
										<br>
										<label>出生日期</label><input class="Wdate" style="height: 38px" name="birthday" type="text" value="<%=customeruser.getBirthday()%>" id="d15" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" required=""/>
										<label>地址</label><input type="text" name="address" value=<%=customeruser.getAddress()%> placeholder="地址" required="">

										<input type="submit" value="提交">
										<button type="button" class="btn btn-success" data-dismiss="modal">关闭</button>
									</form> 
								</div> 
							</div>
						</div>

					</div>

					<!--  light box js -->
					<script src="../../style/js/lightbox-plus-jquery.min.js"> </script>
					<!-- //light box js-->
				</div>
				<!-- //gallery -->
			</div>
		</div>

	</div> 
	<!-- menu-js -->
	<script src="../../style/js/classie.js"></script>
	<script src="../../style/js/main.js"></script>
	<!-- //menu-js -->
	<script src="../../style/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<!-- nicescroll-js -->
	<script src="../../style/js/jquery.nicescroll.min.js"></script>
	<script>
		$(document).ready(function() {
	  
			var nice = $("html").niceScroll();  // The document page (body)
		
			$("#div1").html($("#div1").html()+' '+nice.version);
		
			$("#boxscroll").niceScroll({cursorborder:"",cursorcolor:"#00F",boxzoom:true}); // First scrollable DIV
		});
	</script>
	<!-- //nicescroll-js -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../style/js/bootstrap.js"></script>

	<script>
        function checkPhone() {
            var number = /^1[3|4|5|8][0-9]\d{4,8}$/;
            var inputValue = document.getElementById("phone")
            var ret = number.test(inputValue);
            if (inputValue == ""){
                document.getElementById("phone-message"),innerHTML = "";
            }else if (inputValue.length<11 || ret != true){
                document.getElementById("phone-message").innerHTML = "请确保输入正确的手机号码";
				return false;
            } else{
                document.getElementById("phone-message").innerHTML = "";
            }
        }

        function checkSubmit() {
            if (checkPhone() == false) {
                alert("请确保正确填写每一项内容！")
            }
        }
        function keyPress() {

            var keyCode = event.keyCode;

            if ((keyCode >= 48 && keyCode <= 57))

            {

                event.returnValue = true;

            } else {

                event.returnValue = false;

            }

        }
	</script>

</body>
</html>