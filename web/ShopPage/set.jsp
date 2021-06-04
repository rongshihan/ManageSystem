<%--
  Created by IntelliJ IDEA.
  User: 47337
  Date: 2018/7/17
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Shopuser" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../css/favicon.ico">
    <title>汽车销售管理系统-设置</title>
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
                <li><a href="/SwitchPage?page=setpage" class="active" ><font size="3">用户设置</font></a></li>
                <li><a href="/SwitchPage?page=helppage" ><font size="3">帮助界面</font></a></li>
            </ul>
        </div>
    </div>
</nav>
<!--//导航栏-->
<div class="tab-content">
    <!--内容-->
    <!-- 左边导航栏 -->
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">

            <li class="active"><a href="set.html" >设置基本信息</a></li>

                <!--功能可以继续扩展-->
        </ul>
    </div>


<!-- 控制输出内容在右半部分 -->
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    <div class="tab-content">
        <!--上传车辆信息-->
        <form action="/updateshop" enctype="multipart/form-data">
            <p>
                <font size="6">
                    在这里你可以修改你的商店信息
                </font>
            </p></br>
            <div>

                <%Shopuser shopuser = (Shopuser) request.getAttribute("shopuser");%>
                <label>商店ID：</label>
                <%=shopuser.getShopuser_id()%>
            </div>
            <div>
                <label>商店名称:</label>
                <%=shopuser.getShop_name()%>
            </div>
            <div>
                <label>联系方式</label>
                <input name="shop_phone" style="width:500px" type="text" value="<%=shopuser.getShop_phone()%>" class="form-control"
                       placeholder="请输入联系方式（不能为空）" required onkeypress="keyPress();"
                       onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')">
                <div>
                    <label>商店地址</label>
                    <input name="shop_address" style="width:500px" type="text" value="<%=shopuser.getShop_address()%>" class="form-control"
                           placeholder="请输入店址（不能为空）" required>
                    <div>
                        <label>负责人</label>
                        <input name="shop_manager" style="width:500px" type="text" value="<%=shopuser.getShop_manager()%>" class="form-control"
                               placeholder="请输入负责人姓名（不能为空）" required>
                    </div>
                </div>
                <div>
                    <label>商店描述</label>
                    <div>
                        <textarea name="description" style="width:1000px;" rows="5" warp="virtual" placeholder="输入商店描述（不能为空）" required><%=shopuser.getDescription()%></textarea>
                    </div>
                </div>
            </div>
            <%String success = (String) request.getAttribute("success");%>
            <%String failed = (String) request.getAttribute("failed");%>
            <input type="hidden" id="success" value=<%=success%>>
            <input type="hidden" id="failed" value=<%=failed%>>

            </br>
            <div class="btn-group pull-left" style="margin-left: 0px;">
                <button id="addBtn" type="submit" class="btn btn-success">
                    <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>更新信息</button>
            </div>
        </form>
        <!--//上传车辆信息-->
    </div>
</div>
</div>
</body>
</html>
<script>
    var failed = document.getElementById("failed").value;
    var success = document.getElementById("success").value;
    if(failed.localeCompare(null)) {
        mizhu.alert('', failed);
    }
    if(success.localeCompare(null)) {
        mizhu.alert('', success);
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
