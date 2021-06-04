<%@ page import="java.util.List" %>
<%@ page import="basic.Carview" %>
<%@ page import="model.Shopowncar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>testdrive</title> 
<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fortune Estates Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, SmartPhone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->
<!-- Custom Theme files -->
<link href="../../style/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="../../style/css/style.css" type="text/css" rel="stylesheet" media="all">
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
					<li><a href="/jump?action=homepage"><i class="glyphicon glyphicon-home"></i> 主页 </a></li>
					<li><a href="/jump?action=personal_info"><i class="glyphicon glyphicon-info-sign"></i> 个人信息 </a></li>
					<li><a class="active" href="/jump?action=testdrive"><i class="glyphicon glyphicon-eye-open"></i> 寻车试驾 </a></li>
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
					<div class="banner-img3">
						<h3>寻车试驾</h3>   
					</div> 
				</div>
				<!-- //banner -->

				<div class="w3agile agents">

					<form action="/searchcar">
						<div class="input-group">
                            <!--智能提醒功能-->
                            <%List<Carview> carviews = (List<Carview>)session.getAttribute("allshopcars");
                            int  i = 0;
                            int num = carviews.size();%>
                            <input type="hidden" id="length" name=<%=num%>>
                            <%for(Carview carview:carviews){%>
                            <input id=<%=i+num%> type="hidden" value=<%=carview.getBrand()%>>
                            <%i++;%>
                            <%}%>
							<input id="search_text" type="text" name= "con" class="form-control" placeholder="搜索汽车品牌" style="width:100%"  autocomplete="off" disableautocomplete>
                            <div id="auto_div">
                            </div>
							<span class="input-group-btn">
							<button class="btn btn-default" onclick="checkSubmit();" type="submit">Go!</button>
							</span>
						</div><!-- /input-group -->
						<div>
							<lable>价格区间：¥</lable>
							<input type="text" id="min_price" name="min_price" style="width: 20%" onkeypress="keyPress();"
								   onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')">
							--
							<input name="max_price" id="max_price" type="text" style="width:20%"  onkeypress="keyPress();"
								   onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')">
							<span id="price-message" style="color: red; font-size: small;"></span>
						</div>
					</form>


					<div class="properties-bottom">
                        <% List<Carview> cars = (List<Carview>)request.getAttribute("cars");%>
                        <%if(cars.size()!=0){
                            for(Carview car:cars){%>
						<div class="properties-img">
							<img src=<%=car.getPic_url().split("--")[0]%> alt="">
                            <div class="view-caption"><!--加rent-caption为蓝色-->
                                <h4><span class="glyphicon glyphicon-eye-open"></span> <%=car.getBrand()%> </h4> <!--车辆简介-->
                            </div>
							<div class="w3ls-buy">
								<a href="/jump?action=car_detail&carid=<%=car.getCar_id()%>&shopuserid=<%=car.getShopuser_id()%>">详细</a> <!--加class="rent"为蓝色-->
							</div>
						</div>
						<div class="w3ls-text">
							<h5><%=car.getModel()%></h5><!--车名-->
							<h6>¥<%=car.getPrice()%></h6><!--价格-->
						</div>
                        <%}}else{%>
                        <div class="text-center"><label><font size="4" color="#dc143c">没有对应车辆！</font></label></div>
                        <%}%>
					</div>

					<div class="clearfix"> </div>
				</div>

				<div class="w3agile brands"> 

					<div class="brands-info">
						<div class="brand-grids">
							<a href="#"><img src="../../style/images/b1.jpg" alt=""/></a>
						</div>
						<div class="brand-grids">
							<a href="#"><img src="../../style/images/b2.jpg" alt=""/></a>
						</div>
						<div class="brand-grids">
							<a href="#"><img src="../../style/images/b3.jpg" alt=""/></a>
						</div>
						<div class="brand-grids">
							<a href="#"><img src="../../style/images/b4.jpg" alt=""/></a>
						</div>
						<div class="brand-grids">
							<a href="#"><img src="../../style/images/b5.jpg" alt=""/></a>
						</div>
						<div class="brand-grids">
							<a href="#"><img src="../../style/images/b6.jpg" alt=""/></a>
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
        function checkMinPrice() {
            var num = /^d+$/;
            var inputValue = document.getElementById("min_price").value;
            var ret = num.test(inputValue);
            if (inputValue == ""){
                ducuent.getElementById("price_message").innerHTML = "";
            } else if (inputValue < 0 || ret == false){
                ducuent.getElementById("price_message").innerHTML = "请输入正确的价格区间！";
                return false;
            }

        }

        function checkMaxPrice(){
            var num = /^d+$/;
            var minPrice = document.getElementById("min_price").value;
            var maxPrice = document.getElementById("max_price").value;
            var ret = num.test(maxPrice);
            if (maxPrice == ""){
                document.getElementById("price-messae").innerHTML = "";
            } else if(ret == false || maxPrice < minPrice){
                document.getElementById("price-messae").innerHTML = "请输入正确的价格区间！";
                return false;
            }else{
                document.getElementById("price-messae").innerHTML = "";
            }
        }

        checkSubmit()
		{
            if(checkMinPrice() == false || checkMaxPrice() == false){
                alert("请检查您的价格区间！");
            }
        }
	</script>

</body>
</html>
<style type="text/css">

    .search

    {

        left: 0;

        position: relative;

    }

    #auto_div

    {

        display: none;

        width:90%;

        border: 1px #74c0f9 solid;

        background: #FFF;

        position: absolute;

		z-index:100;

        top: 34px;

        left: 0;

        color: #323232;

    }

</style>
<script type="text/javascript">

    //测试用的数据，这里可以用AJAX获取服务器数据
    var test_list = new Array();
    var length = document.getElementById("length").name;
    var lengthid=parseInt(length,10);
    for(var m=0;m < lengthid ;m++){
        if(test_list.indexOf(document.getElementById(lengthid+m).value)==-1){
            test_list[test_list.length] = document.getElementById(lengthid+m).value;
        }

    }

    var old_value = "";

    var highlightindex = -1;   //高亮

    //自动完成

    function AutoComplete(auto, search, mylist) {

        if ($("#" + search).val() != old_value || old_value == "") {

            var autoNode = $("#" + auto);   //缓存对象（弹出框）

            var carlist = new Array();

            var n = 0;

            old_value = $("#" + search).val();

            for (i in mylist) {

                if (mylist[i].indexOf(old_value) >= 0) {

                    carlist[n++] = mylist[i];

                }

            }

            if (carlist.length == 0) {

                autoNode.hide();

                return;

            }

            autoNode.empty();  //清空上次的记录

            for (i in carlist) {

                var wordNode = carlist[i];   //弹出框里的每一条内容
                wordNode=wordNode.replace(old_value,"<font color='red'>"+old_value+"</font>");
                var newDivNode = $("<div>").attr("id", i);    //设置每个节点的id值

                newDivNode.attr("style", "font:14px/25px arial;height:25px;padding:0 8px;cursor: pointer;");

                newDivNode.html(wordNode).appendTo(autoNode);  //追加到弹出框

                //鼠标移入高亮，移开不高亮

                newDivNode.mouseover(function () {

                    if (highlightindex != -1) {        //原来高亮的节点要取消高亮（是-1就不需要了）

                        autoNode.children("div").eq(highlightindex).css("background-color", "white");

                    }

                    //记录新的高亮节点索引

                    highlightindex = $(this).attr("id");

                    $(this).css("background-color", "#ebebeb");

                });

                newDivNode.mouseout(function () {

                    $(this).css("background-color", "white");

                });

                //鼠标点击文字上屏

                newDivNode.click(function () {

                    //取出高亮节点的文本内容

                    var comText = autoNode.hide().children("div").eq(highlightindex).text();

                    highlightindex = -1;

                    //文本框中的内容变成高亮节点的内容

                    $("#" + search).val(comText);

                })

                if (carlist.length > 0) {    //如果返回值有内容就显示出来

                    autoNode.show();

                } else {               //服务器端无内容返回 那么隐藏弹出框

                    autoNode.hide();

                    //弹出框隐藏的同时，高亮节点索引值也变成-1

                    highlightindex = -1;

                }

            }

        }

        //点击页面隐藏自动补全提示框

        document.onclick = function (e) {

            var e = e ? e : window.event;

            var tar = e.srcElement || e.target;

            if (tar.id != search) {

                if ($("#" + auto).is(":visible")) {

                    $("#" + auto).css("display", "none")

                }

            }

        }

    }

    $(function () {

        old_value = $("#search_text").val();

        $("#search_text").focus(function () {

            if ($("#search_text").val() == "") {

                AutoComplete("auto_div", "search_text", test_list);

            }

        });

        $("#search_text").keyup(function () {

            AutoComplete("auto_div", "search_text", test_list);

        });

    });
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