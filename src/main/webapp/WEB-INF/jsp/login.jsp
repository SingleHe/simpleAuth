<%--
  Created by IntelliJ IDEA.
  User: SingleHe
  Date: 2017/12/16
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red}</style>
</head>
<body>
<div class="error">${error}</div>
<form action="" method="post">
    用户名:<input type="text" name="username" value="<shiro:principal/>"><br/>
    密码:<input type="text" name="password"><br/>
    自动登录:<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
