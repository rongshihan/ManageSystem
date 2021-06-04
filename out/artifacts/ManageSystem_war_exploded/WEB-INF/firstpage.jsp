<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="basic.KeyValuePair" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/3
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
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
    <title>汽车销售管理系统</title>
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

  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
          <div class="navbar-header">
              <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
          </div>
          <div>
              <p id= "huanying" class="navbar-brand" align="right"><font size="4">欢迎您！<a href="/SearchUserServlet" name="userid">${userid}</a> </font></p>
          </div>

          <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                  <li><a href="#A" class="active" data-toggle="tab"><font size="3">系统主页</font></a></li>
                  <li><a href="#B" data-toggle="tab"><font size="3">使用功能</font></a></li>
                  <li><a href="#C" data-toggle="tab"><font size="3">用户设置</font></a></li>
                  <li><a href="#D" data-toggle="tab"><font size="3">帮助界面</font></a></li>
              </ul>
              <!--页内切换-->
              <!--
              <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
              </form>
              -->
          </div>
      </div>
  </nav>

  <div class="tab-content">
      <div class="tab-pane fade in active" id="A">
          <!-- Carousel
          ================================================== -->
          <div id="myCarousel" class="carousel slide" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner" role="listbox">
                  <div class="item active">
                      <img class="first-slide" src="../img/1.jpg"  alt="First slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题一</h1>
                              <p>段落一</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#B" data-toggle="tab"role="button">马上使用功能</a></p>
                          </div>
                      </div>
                  </div>
                  <div class="item">
                      <img class="second-slide" src="" alt="Second slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题二</h1>
                              <p>段落二</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#C" data-toggle="tab"role="button">查看用户设置</a></p>
                          </div>
                      </div>
                  </div>
                  <div class="item">
                      <img class="third-slide" src="" alt="Third slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题三</h1>
                              <p>段落三</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#D" role="button">查看帮助界面</a></p>
                          </div>
                      </div>
                  </div>
              </div>
              <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
              </a>
              <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
              </a>
          </div><!-- /.carousel -->
          <!-- Marketing messaging and featurettes
      ================================================== -->
          <!-- Wrap the rest of the page in another container to center all the content. -->

          <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>Heading</h2>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>关于我们</h2>
          <p>团队介绍</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->/.col-lg-4 -->
              </div><!-- /.row -->


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">
          汽车销售管理系统 精细化管理客户</br> <span class="text-muted">  </span></h2>
          <p class="lead">专为汽车4S店、二手车、新车经销商设计的车辆销售管理系统。系统功能强大、操作简单、容易上手。 程序化快速建档，自有服务器存储海量客户，避免客户数据丢失；意向客户及保险到期及时提醒，方便执行</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="../img/car-manage.png" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">精细化管理客户 <span class="text-muted">  </span></h2>
          <p class="lead">程序化快速建档，自有服务器存储海量客户，避免客户数据丢失；意向客户及保险到期及时提醒，方便执行</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="../img/client_manage.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">员工满意度提升 <span class="text-muted">  </span></h2>
          <p class="lead">详细记录客户信息，更好的把控客户进度，以业绩为导向，通过目标管理聚焦关键任务，形成团队协同力。</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="../img/service.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>


      <hr class="featurette-divider">

              <!-- /END THE FEATURETTES -->


              <!-- FOOTER -->
              <footer>
                  <p class="pull-right"><a href="#">返回顶部</a></p>
                  <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
              </footer>

          </div><!-- /.container -->
      <div class="tab-pane fade" id="B">
          <!-- 功能主页实现 -->
          <div class="container-fluid">
              <div class="col-sm-3 col-md-2 sidebar">
                  <ul class="nav nav-sidebar">
                      <li class="active"><a href="#0"data-toggle="tab">功能概览</a></li>
                      <li><a href="#1" data-toggle="tab">查询车辆信息</a></li>
                      <li><a href="#2" data-toggle="tab">上传车辆信息</a></li>
                      <li><a href="#3" data-toggle="tab">查询客户预约</a></li>
                      <li><a href="#4" data-toggle="tab">进行消息推送</a></li>
                      <!--功能可以继续扩展-->
                  </ul>
              </div>



              <!--查询所有车的类型型号，设置下拉框-->
              <%List<KeyValuePair> lists= (List<KeyValuePair>)session.getAttribute("list");
                  int i = 101;
                  int num  = lists.size();%>
              <input type="hidden" id="length" name=<%=num%>>
              <%for(KeyValuePair pair : lists){ %>
              <input type="hidden" id=<%=i%> name=<%=pair.key%> value=<%=pair.value%> >
              <%i++;%>
              <%}%>



              <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                  <!-- 控制输出内容在右半部分 -->
                  <div class="tab-content">
                      <div class="tab-pane fade in active" id="0">
                          <p>
							<font size="4">
							在这里可以看到功能的概览
							</font>
                          </p>
                      </div>
                      <div class="tab-pane fade" id="1">
                          <div>
                    <form action="/Search">
					<p>
						<font size="4">
						在这里你可以查看你旗下的车辆信息
						</font>
					</p></br>
                        <label>品牌</label>
                        <select name="Bybrand" style="width:100px;height:35px">
                            <option value="全部车辆">全部车辆</option>
                            <option value="Benz">Benz</option>
                            <option value="Audi">Audi</option>
                            <option value="Lamborghini">Lamborghini</option>
                            <option value="Rolls-Royce">Rolls-Royce</option>
                        </select>
                        <label>车型号</label>
                        <select name="Bymodel" style="width:100px;height:35px">
                            <option value="全部车辆">全部车辆</option>
                            <option value="Benz307">Benz307</option>
                            <option value="A6">A6</option>
                            <option value="URUS">URUS</option>
                            <option value="幻影">幻影</option>
                        </select>
                        <label>类型</label>
                        <select name="Bytype" style="width:100px;height:35px">
                            <option value="全部车辆">全部车辆</option>
                            <option value="轿车">轿车</option>
                            <option value="超级跑车">超级跑车</option>
                            <option value="高级轿车">高级轿车</option>
                        </select>
                        <button id="queryBtn2" type="submit" class="btn btn-default" class="btn-group pull-left" style="margin-left: 10px;">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
                        </form>
					</div>
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
                                  <th>图片</th>
                              </tr>
                              </thead>
                          </table>
                              </form>
                      </div>

                      <!--
                      <div class="tab-pane fade" id="1">
                      <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                          <div class="form-inline">
                          <button id="queryBtn" type="button" class="btn btn-default" >
                          <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>

                          <button id="btn_edit" type="button" class="btn btn-default" >
                          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</button>

                          <button id="btn_delete" type="button" class="btn btn-default" onClick="erpdel();">
                          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>
                          <button id="addBtn" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增</button>
                          </div>
                      </div>
                      </div>
                      -->



                    <div class="tab-pane fade" id="2">
                        <form action="/addcar">
                          <p>
                              <font size="4">
                                  在这里你可以上传你旗下的车辆信息
                              </font>
                          </p></br>

						<div>
                            <label>选择品牌</label>
                            <select id="carlist1" name="brand" runat="server" onchange="selectprovince(this);" style=" width:95px;">
                                <option value=""></option>
                            </select>
                            <label>选择型号</label>
                            <select id="carlist2" name="model" runat="server" style=" width:95px;">
                                <option value=""></option>
                            </select>
                        </div>
                        <div>
                           <br><br>
                            <label for="name">库存（数量）</label>
                            <input name="stock" style="width:500px" type="text" class="form-control"
                                   placeholder="请输入库存">
							<div>
							<label for="name">价格（自填）</label>
							<input name="price" style="width:500px" type="text" class="form-control"
							placeholder="请输入价格">

							</div>
						</div><!--
                          <div class="form-group">
                              <label for="inputfile">车辆展示图片上传</label>
                              <input type="file" id="inputfile">
                              <p class="help-block">请选择文件图片上传</p>

                          </div>
                          -->
					</br>
                          <div class="btn-group pull-left" style="margin-left: 20px;">
                              <button id="addBtn" type="submit" class="btn btn-default">
                                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>上传</button>
                          </div>
                        </form>
                      </div>

                      <div class="tab-pane fade" id="3">
                          <p>
                              <font size="4">
                                  在这里你可以查看你旗下的客户预约
                              </font>
                          </p></br>
                          <form action="/handlebook" class="navbar-form navbar-left">
                              <label>预约状态</label>
                              <select name="appointstate" style="width:100px;height:35px">
                                  <option >全部预约</option>
                                  <option >已处理预约</option>
                                  <option >未处理预约</option>
                              </select>
                              <label>预约类型</label>
                              <select name="appointtype" style="width:100px;height:35px">
                                  <option >全部预约</option>
                                  <option >试驾预约</option>
                                  <option >维修预约</option>
                                  <option >保养预约</option>
                                  <option >购车预约</option>
                              </select>
                              <input type="text" class="form-control" name="customername" placeholder="输入需要查询的客户姓名"></input>
                              <button id="queryBtn2" type="submit" class="btn btn-default" class="btn-group pull-left" style="margin-left: 10px;">
                                  <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
                          </form>
					<p></br></br></br>
                              <font size="4">
                                  查询结果
                              </font>
                          </p></br>

                          <table class="table table-bordered table-striped">

                              <thead>
                              <tr>
                                  <th>预约号</th>
                                  <th>客户姓名</th>
                                  <th>联系方式</th>
                                  <th>预约类型</th>
                                  <th>预约时间</th>
                                  <th>预约状态</th>

                              </tr>
                              </thead>
                          </table>
                  </div>
				<div class="tab-pane fade" id="4">
					<p>
						<font size="4">
							在这里可以进行微信端的消息推送
						</font>
					</p>
					<form role="form">
						<div>
							<textarea name="customermessage" style="width:1000px;" rows="5" warp="virtual" placeholder="输入要推送给客户的信息"></textarea>
						</div>
						<div class="btn-group pull-left" style="margin-left: 0px;">
							<button id="addBtn" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>推送</button>
						</div>
					</form>
				</div>
                      <!--具体功能实现区-->
                  </div>
              </div>
          </div>
      </div>
      <div class="tab-pane fade" id="C">
          <p>
              用户设置
          </p>
      </div>
      <div class="tab-pane fade" id="D">
          <p>
              帮助界面
          </p>
      </div>
  </div>
  </body>
</html>
<script type="text/javascript">
    var list1 = new Array;
    var list2 = new Array;
    var str = document.getElementById("length").name;
    var lengthid=parseInt(str,10);
    for(var m=1;m < lengthid  ;m++){
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
        //city initialize
        var firstprovince = list2[0];
        for (var j = 0; j < firstprovince.length; j++) {
            var optioncity = document.createElement("option");
            optioncity.appendChild(document.createTextNode(firstprovince[j]));
            optioncity.value = firstprovince[j];
            ddlCity.appendChild(optioncity);
        }
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
</script>
