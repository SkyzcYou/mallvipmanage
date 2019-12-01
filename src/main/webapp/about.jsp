<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <title>樱诺商城-关于我们</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
    <style>
        .main{
            height: 500px;
            background-color: white;
            margin-top: 15px;
            margin-bottom: 30px;
            padding: 30px;
        }
        .breadcrumb{
            padding-left: 0;
        }
    </style>
</head>
<body style="background-color: #f6f6f6">
<div class="container" style="height: 1080px">
    <div class="header">
        <%@include file="WEB-INF/views/client/head.jsp"%>
    </div>
    <div class="main">
        <div class="center_head">
            <h4>关于我们</h4>
            <ol class="breadcrumb bg-white">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">首页</a></li>
                <li class="breadcrumb-item active">关于我们</li>
            </ol>
        </div>
        商城名字：${name}<br/>
        联系方式：${phoneNumber}<br/>
        地址：${address}<br/>
    </div>
    <div class="foot">
        <%@include file="WEB-INF/views/client/foot.jsp"%>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
