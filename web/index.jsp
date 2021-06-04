<%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/3
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="../style/css/bootstrap.min.css">
  <link href="../style/css/signin.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
    </div>

  </div>
</nav>

<div class="container" style="margin-top: 120px">

  <form class="form-signin"  action="/login">
    <h2 class="form-signin-heading" id="sign_top">登录</h2>  <br><br>
    <label for="username" class="sr-only">username</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名" autofocus>
    </br>
    <%if(request.getAttribute("msg0")!=null){ %>
    <p><font size="4" color="#dc143c"><%=request.getAttribute("msg0")%>！</font></p>
    <%  }%>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="请输入密码" >
    <%if(request.getAttribute("msg1")!=null){ %>
    <p><font size="4" color="#dc143c"><%=request.getAttribute("msg1")%>！</font></p>
    <%  }%>
    <%if(request.getAttribute("msg2")!=null){ %>
    <p><font size="4" color="#dc143c"><%=request.getAttribute("msg2")%></font></p>
    <%  }%>
    <div class="checkbox">
      <br>

    </div>

    <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="登录">登录</button>
    <span class="signup">还没有账户，

          <button type="submit" name="submit" class="reg_btn" value="立即注册">立即注册</button>

      </span>
  </form>
  <%--<form action="/webToWx">
    <input type="submit" value="顾客登陆">
  </form>--%>


</div>
</body>
</html>
