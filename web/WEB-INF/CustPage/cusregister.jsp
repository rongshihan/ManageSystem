<%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/10
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../style/css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="../../style/js/My97DatePicker/WdatePicker.js">  </script>
<link href="../../style/css/style1.css" rel="stylesheet">
<script src="../../style/js/jquery-1.7.1.min.js"></script>
<script src="../../style/js/ui.js"></script>
<title>用户注册</title>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../style/css/bootstrap.min.css" />
    <title>用户注册</title>
</head>
<body>
<input type="hidden" id="failed" value=${failed}>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <p class="navbar-brand"><font size="5">汽车销售管理系统</font></p>
        </div>
    </div>
</nav>

<div class="container" style="margin-top: 80px;">
    <div class="col-md-6 col-md-offset-3">
        <a href="/webToWx"><font size="5" color="#dc143c"><<返回</font></a>
        <br>
        <form action="/regist" class="">
            <label for="user_id"><font size="4">用户名*</font></label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                <input id="user_id" class="form-control" placeholder="请输入2-20个字母/数字/下划线" name="username" maxlength="20" type="text" required="" oninput="checkId();"/>
            </div>
            <span id="id-message" style="color: red; font-size: small;"></span>
            <%if(request.getAttribute("msg")!=null){ %>
            <label><font size="4" color="#dc143c"> <%=request.getAttribute("msg")%></font></label>
            <%  }%>

            <div class="form-group">
                <label for="password"><font size="4">密码*</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="password" class="form-control" placeholder="请输入密码,至少含有两个字符" name="password" maxlength="20" type="password" required="" oninput="checkPassword();"/>
                </div>
                <span id="password-message" style="color: red; font-size: small;"></span>
            </div>

            <div class="form-group">
                <label for="repassword"><font size="4">确认密码*</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="repassword" class="form-control" placeholder="请再次输入密码" maxlength="20" name="chkpassword" type="password" required="" oninput="checkPasswordRepeat();"/>
                </div>
                <span id="repassword-message" style="color: red; font-size: small;"></span>
            </div>

            <div class="form-group">
                <label for="username"><font size="4">姓名*</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input id="username" class="form-control" placeholder="请输入用户真实姓名" name="name" maxlength="45" type="text" required="" oninput="checkName();"/>
                </div>
                <span id="name-message" style="color: red; font-size: small;"></span>
            </div>

            <div class="form-group">
                <center>
                    <label class="radio-inline" style="font-size: smaller;">
                        <input type="radio" name="gender" id="emp_add_gender1" value="男" checked="checked"> 先生 </label>
                    <label class="radio-inline" style="font-size: smaller;"> <input type="radio" name="gender" id="emp_add_gender2" value="女"> 女士 </label>
                </center>
            </div>

            <div class="form-group">
                <label for="user_phone"><font size="4">手机号码*</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input id="user_phone" class="form-control" placeholder="请输入11位手机号码" name="phone"
                           maxlength="11" type="text" required="" oninput="checkPhone();" onkeypress="keyPress();"
                           onkeyup="if(event.keyCode !=37 && event.keyCode != 39)value=value.replace(/\D/g,'')"/>
                </div>
                <span id="phone-message" style="color: red; font-size: small;"></span>
            </div>

            <div class="form-group">
                <label for="user_phone"><font size="4">出生日期*</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    <input class="Wdate form-control" style="height: 35px;border: solid 1px #ccc;" name="birthday" type="text" id="birthday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" required=""/>
                </div>
            </div>

            <div class="form-group">
                <label for="address"><font size="4">地址*</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                    <input id="address" class="form-control" placeholder="请输入地址(少于45个字符)" name="address" maxlength="45" type="text" required="" oninput="checkAddress();" />
                </div>
                <span id="address-message" style="color: red; font-size: small;"></span>
            </div>

            <div class="form-group">
                <input class="form-control btn btn-primary" id="register" type="submit" onclick="checkSubmit();" value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册" />
            </div>
            <div class="form-group">
                <input id="reset" class="form-control btn btn-danger" type="reset" value="重置"/>
            </div>

        </form>
    </div>
</div>

<script>
    function checkId() {
        //字母数字下划线
        var regex = /^[^_][A-Za-z]*[a-z0-9_]*$/;
        var inputValue = document.getElementById("user_id").value;
        var ret = regex.test(inputValue);
        if(inputValue == ""){
            document.getElementById("id-message").innerHTML = ""
        }else if(inputValue.length > 20 || inputValue.length == 1 || ret != true){
            document.getElementById("id-message").innerHTML = "输入2-20位数字字母下划线";
            return false;
        }else{
            document.getElementById("id-message").innerHTML = ""
        }
    }

    function checkPassword() {
        var inputValue = document.getElementById("password").value;
        if(inputValue.length == 1 || inputValue.length > 20){
            document.getElementById("password-message").innerHTML = "请输入2-20个任意字符"
            return false;
        }else if (inputValue == "") {
            document.getElementById("password-message").innerHTML = ""
        }else{
            document.getElementById("password-message").innerHTML = "";
        }
    }

    function checkPasswordRepeat(){
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        if (repassword == "") {
            document.getElementById("repassword-message").innerHTML = ""
        } else if (repassword != password) {
            document.getElementById("repassword-message").innerHTML = "请确保两次输入的密码一致"
            return false;
        } else{
            document.getElementById("repassword-message").innerHTML = "";
        }
    }

    function checkPhone(){
        //只输入数字
        var number = /^1[3|4|5|8][0-9]\d{4,8}$/;
        var phone = document.getElementById("user_phone").value;
        var ret = number.test(phone);
        if(phone == ""){
            document.getElementById("phone-message").innerHTML = "";
        }else if((phone.length < 11 && phone.length > 0) || (ret != true && phone.length > 0)){
            document.getElementById("phone-message").innerHTML = "请确保正确输入11位手机号码";
            return false;
        }else{
            document.getElementById("phone-message").innerHTML = "";
        }
    }

    function checkName(){
        //只输入字母和汉字
        var word = /^[a-zA-Z\u4e00-\u9fa5]+$/;
        var name = document.getElementById("username").value;
        var ret = word.test(name);
        if(ret != true && name.length > 0){
            document.getElementById("name-message").innerHTML = "请确保您输入的内容只有汉字和字母";
            return false;
        }else{
            document.getElementById("name-message").innerHTML = "";
        }
    }

    function checkAddress(){
        var address = document.getElementById("address").value;
        if(address == ""){
            document.getElementById("address-message").innerHTML = "";
        }else if(address.length > 45){
            document.getElementById("address-message").innerHTML = "请检查您的地址格式，并确保少于45个字符"
            return false;
        }else{
            document.getElementById("address-message").innerHTML = "";
        }
    }

    function checkSubmit(){
        if(checkId() == false || checkPassword() == false || checkPasswordRepeat() == false || checkName() == false || checkPhone() == false || checkAddress() == false){
            alert("您的表单包含无效信息，请检查并修改后再次提交！");
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
    var failed = document.getElementById("failed").value;
    if(failed.localeCompare("")) {
        mizhu.alert('', failed);
    }
</script>

</body>
</html>