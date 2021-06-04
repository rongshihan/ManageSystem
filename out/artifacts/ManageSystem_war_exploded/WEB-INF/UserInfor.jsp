<%--
  Created by IntelliJ IDEA.
  User: rsh
  Date: 2018/7/5
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="U" items="${userAll}">
    <h1><c:out value="${U.shopuser_id}"></c:out></h1>
    <h1><c:out value="${U.pswd}"></c:out></h1>
    <h1><c:out value="${U.shop_name}"></c:out></h1>
    <h1><c:out value="${U.shop_phone}"></c:out></h1>
    <h1><c:out value="${U.shop_address}"></c:out></h1>
    <h1><c:out value="${U.shop_manager}"></c:out></h1>
    <h1><c:out value="${U.description}"></c:out></h1>
</c:forEach>
</body>
</html>
