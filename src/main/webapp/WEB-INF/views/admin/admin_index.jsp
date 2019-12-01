<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>樱诺商城-管理页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
</head>
<body>
<h1>樱诺商城-管理页面，当前管理员：${sessionScope.admin.admin_name}</h1>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
