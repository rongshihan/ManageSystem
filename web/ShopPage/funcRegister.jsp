<%@ page import="basic.KeyValuePair" %>
<%@ page import="java.util.List" %>
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
    <title>汽车销售管理系统-车辆登记</title>
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
		<script language="javascript" type="text/javascript" src="../../style/js/My97DatePicker/WdatePicker.js"></script>


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
				    <p id= "huanying" class="navbar-brand" align="right"><font size="4">用户：<a href="/SwitchPage?page=setpage" name="userid">${userid}</a> </font></p>
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
					<li><a href="/SwitchPage?page=funcViewCar" >查询车辆信息</a></li>
					<li><a href="/SwitchPage?page=funcUploadCar" >上传车辆信息</a></li>
					<li><a href="/SwitchPage?page=funcViewAppointment" >查询客户预约</a></li>
					<li><a href="/SwitchPage?page=funcPushMsg" >发布通知</a></li>
					<li class="active"><a href="/SwitchPage?page=funcRegister" >登记客户车辆</a></li>
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
					<!--登记车辆信息-->
					<p>
                        <font size="6">
                            在这里你可以登记你旗下客户的车辆信息
                        </font>
                    </p>
					</br>
					<form action="/RegisterCarServlet">
						<label for="name">车牌号</label>
						<input name="plate_number" style="width:500px" type="text" class="form-control"
							   placeholder="请输入车牌号" required>
						<label for="name">${plate_number_error}</label><br>
						<label for="name">客户ID</label>
						<input name="userid" style="width:500px" type="text" class="form-control"
							   placeholder="请输入客户ID" required>
						<label for="name"><font size="4" color="#dc143c">${cusid_error}</font></label><br>


						<%List<KeyValuePair> lists= (List<KeyValuePair>)session.getAttribute("list");
							int i = 101;
							int num  = lists.size();%>
						<input type="hidden" id="length" name=<%=num%>>
						<%for(KeyValuePair pair : lists){ %>
						<input type="hidden" id=<%=i%> name=<%=pair.key%> value=<%=pair.value%> >
						<%i++;%>
						<%}%>
						<label for="name">品牌</label>
						<select name="brand" style="width:500px" id="carlist1" class="form-control" onchange="selectprovince(this);" required>
							<option value=""></option>
						</select>
						<label for="name">车型</label>
						<select name="model" style="width:500px" id="carlist2" class="form-control" required>
							<option value=""></option>
						</select>
						<label for="name"><font size="4" color="#dc143c">${carid_error}</font></label><br>
						<label for="name">登记时间</label>
						<input class="form-control" style="width:500px" name="register_time" type="text" id="d15" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" required=""/>
						<label for="name">交易金额</label>
						<input name="pay_price" style="width:500px" type="text" class="form-control"
							   placeholder="纯交易金额（不含其他费用）" required onkeypress="keyPress();"
							   onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')">
					</br>
						<input type="hidden" id="success" value=${success}>
						<input type="hidden" id="error" value=${error}>
						<div class="btn-group pull-left" style="margin-left: 0px;">
							<button id="addBtn" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>登记</button>
						</div>
					</form>

					<!--//登记车辆信息-->
			    </div>
		    </div>
			<!-- //控制输出内容在右半部分 -->

	    </div>

		<!--内容--> 
			
	    </div>
    </body>
</html>
<script type="text/javascript">
    var list1 = new Array;
    var list2 = new Array;
    var str = document.getElementById("length").name;
    var lengthid=parseInt(str,10);
    for(var m=0;m < lengthid ;m++){
        if(list1.indexOf(document.getElementById(m+101).name)==-1){
            list1[list1.length] = document.getElementById(m+101).name;
        }

    }
    for(var n=0;n <list1.length ; n++){
        var num = document.getElementsByName(list1[n]).length;
        list2[list2.length] = new Array;
        for(var k=0;k<num;k++)
        {
            list2[n][k] = document.getElementsByName(list1[n])[k].value;
        }

    }


    var ddlProvince = document.getElementById("carlist1");
    var ddlCity = document.getElementById("carlist2");
    for(var i =0;i<list1.length; i++)
    {
        var option = document.createElement("option");
        option.appendChild(document.createTextNode(list1[i]));
        option.value = list1[i];
        ddlProvince.appendChild(option);
    }
    function indexof(obj,value)
    {
        var k=0;
        for(;k<obj.length;k++)
        {
            if(obj[k] == value)
                return k;
        }
        return k;
    }
    function selectprovince(obj) {
        ddlCity.options.length = 0;//clear
        var index = indexof(list1,obj.value);
        var list2element = list2[index];
        for(var i =0;i<list2element.length; i++)
        {
            var option = document.createElement("option");
            option.appendChild(document.createTextNode(list2element[i]));
            option.value = list2element[i];
            ddlCity.appendChild(option);
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
<script>
    var error = document.getElementById("error").value;
    var success = document.getElementById("success").value;
    if(error.localeCompare("")) {
        mizhu.alert('', error);
    }
    if(success.localeCompare("")) {
        mizhu.alert('', success);
    }
</script>