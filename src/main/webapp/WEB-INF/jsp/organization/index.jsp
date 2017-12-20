<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>组织欢迎页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/static/css/layout-default-latest.css">
</head>
<body>
    <iframe name="content" class="ui-layout-center" src="" scrolling="auto"></iframe>
    <iframe name="tree" class="ui-layout-west"
            src="${pageContext.request.contextPath}/organization/tree" frameborder="0"
            scrolling="auto"></iframe>
    <script src="${pageContext.request.contextPath}/WEB-INF/static/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/WEB-INF/static/js/jquery.layout-latest.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(Document).ready(function () {
                $('body').layout({applyDemoStyle:true});
            });
        });
    </script>
</body>
</html>
