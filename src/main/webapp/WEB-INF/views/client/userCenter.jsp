<%--
  Created by IntelliJ IDEA.
  User: youzh
  Date: 2019/11/27
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
    <title>樱诺商城</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .main{
            background-color: white;
            margin-top: 15px;
            margin-bottom: 30px;
            padding: 30px;
        }
        .breadcrumb{
            padding-left: 0;
        }
        .center-content{
            width: 100%;
        }
        .user-card{
            padding: 30px;
        }
        .user-info-card{
            background-color: #8fd19e;
            border: #ba8b00 solid 1px;
            border-radius: 15px;
        }
        .order-list{
            width: 100%;
            height: 400px;
            background-color: #ba8b00;
        }
    </style>
</head>
<body style="background-color: #f6f6f6">
<div class="container" style="height: 1080px">
    <div class="header">
        <%@include file="head.jsp"%>
    </div>
    <div class="main">
        <div class="center_head">
            <h4>用户中心</h4>
            <ol class="breadcrumb bg-white">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">首页</a></li>
                <li class="breadcrumb-item active">用户中心</li>
            </ol>
        </div>
<%--        用户名：${sessionScope.user.username}<br/>--%>
<%--        联系方式：${sessionScope.user.phone}<br/>--%>
<%--        地址：${sessionScope.user.address}<br/>--%>
        <div class="center-content">
            <div class="user-card row align-items-center justify-content-center">
                <div class="user-info-card text-center col-md-6">
                    <h1>用户信息卡片</h1>
                </div>
            </div>
            <div class="order-list">

            </div>
        </div>

    </div>
    <div class="foot">
        <%@include file="foot.jsp"%>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
