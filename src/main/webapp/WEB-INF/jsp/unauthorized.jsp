<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有权限</title>
    <style type="text/css">
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <div class="error">Sorry 啊~ 您没有权限[${exception.message}]</div>
</body>
</html>
