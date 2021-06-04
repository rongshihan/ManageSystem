<%@ page import="model.Shopowncar" %>
<%@ page import="model.Car" %>
<%@ page import="DAO.CarDAO" %>
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
    <title>修改车辆信息</title>
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
    <style type="text/css">
        #result{
            width: 500px;
            height: 300px;
            border:0px solid #eee;
        }
        #result img{
            width: auto;
        }
        input{
            width: 75px;
            margin-top: 10px;
        }
        @-moz-document url-prefix() { input { width:65px; } }/*单独对火狐进行设置*/
    </style>
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
    <script type="text/javascript">
        //var files = document.getElementById('pic').files;
        var form = new FormData();//通过HTML表单创建FormData对象
        var url = '127.0.0.1:8080/'
        function selectFile(){
            var files = document.getElementById('pic').files;
            console.log(files[0]);
            if(files.length == 0){
                return;
            }
            var file = files[0];
            //把上传的图片显示出来
            var reader = new FileReader();
            // 将文件以Data URL形式进行读入页面
            console.log(reader);
            reader.readAsBinaryString(file);
            reader.onload = function(f){
                var result = document.getElementById("result");
                var src = "data:" + file.type + ";base64," + window.btoa(this.result);
                result.innerHTML = '<img onclick="fileSelect();" src ="'+src+'"/>';
            }
            console.log('file',file);
            ///////////////////
            form.append('file',file);
            console.log(form.get('file'));
        }
        function fileSelect() {
            document.getElementById("pic").click();
        }
    </script>

</head>

<body>
<style type="text/css">
    #result{
        width: 800px;
        height:500px;
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
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

        <div class="tab-content">
            <!--修改车辆信息-->
            <form action="/updatecar">
                <p>
                    <font size="4">
                        在这里你可以修改你旗下的车辆信息
                    </font>
                </p>
                </br>

                <div>

                       <%Shopowncar soc = (Shopowncar)request.getAttribute("soc");%>
                        <input type="hidden" name="carid" value="<%=soc.getCar_id()%>">
                        <%String brand = (String) request.getAttribute("brand");%>
                        <%String model = (String) request.getAttribute("model");%>
                        <label for="name">品牌:<%=brand%></label>
                    <br><br>
                        <label for="name">型号:<%=model%></label>
                </div>
                <div>
                    <br>
                    <br>
                    <label for="name">修改库存</label>
                    <input name="stock" style="width:500px" id="stock" type="text" value=<%=soc.getStock()%> class="form-control"
                           placeholder="请输入库存（不能为空）"  required onkeypress="keyPress();"
                           onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')">
                    <span id="stock-message" style="color: red; font-size: small;"></span>
                    <div>
                        <label for="name">修改售价</label>
                        <input name="price" id="price" style="width:500px" type="text" value=<%=soc.getPrice()%> class="form-control"
                               placeholder="请输入价格（不能为空）" required onkeypress="keyPress();"
                               onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')">
                        <span id="price-message" style="color: red; font-size: small;"></span>
                        <label for="name">修改车辆信息</label>
                        <div>
                            <textarea name="description" style="width:1000px;" rows="5" warp="virtual" placeholder="输入修改后的车辆描述（不能为空）" required><%=soc.getDescription()%></textarea>
                        </div>
                        <%if(request.getAttribute("error")!=null){ %>
                        <%=request.getAttribute("error")%>
                        <%  }%>
                        <br/>
                        <br/>
                    </div>
                </div>
                </br>
                <div class="btn-group pull-left" style="margin-left: 0px;">
                    <button id="addBtn" name="access" type="submit" value="更新" class="btn btn-success">
                        <span class="glyphicon glyphicon-upload" aria-hidden="true"></span>更新
                    </button>
                </div>

                <div>
                    <button id="addBtn" name="access" type="submit" value="返回" class="btn btn-danger" style="margin-left: 20px">
                        <span class="glyphicon glyphicon-step-backward" aria-hidden="true"></span>返回
                    </button>
                </div>
            </form>
            <form method="post" action="/uploadimg" enctype="multipart/form-data">
                <div>
                    <label>
                        点击上传车辆图片
                    </label>
                </div>

                    <div id = "result">
                        <img src="../../style/images/plus.jpg" onclick="fileSelect();">
                    </div>
                    <div class="face">
                        <input id="pic" type="file" name = 'pic' accept = "image/*" onchange = "selectFile();" style="display: none;" required>
                    </div>


                <input type="hidden" name="121" value=<%=soc.getCar_id()%>>

                <input type="hidden" id="msg" value=<%=request.getAttribute("message")%>>

                <input class="btn btn-success" type="submit" value="上传"/>

            </form>

            <!--//修改车辆信息-->
        </div>
    </div>
</div>

<!--内容-->

</div>

<script>
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
    var msg = document.getElementById("msg").value;
    if(msg.localeCompare(null)) {
        mizhu.alert('', msg);
    }

</script>

</body>
</html>