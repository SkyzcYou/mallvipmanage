<%--
  Created by IntelliJ IDEA.
  User: youzh
  Date: 2019/11/28
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <title>樱诺商城</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
    <style>
        html,body{
            height: 100%;
            width: 100%;
            overflow: hidden;
            padding: 0;
            margin: 0;
            background: url(${pageContext.request.contextPath}/static/images/admin/admin_login_bg.jpg) center center no-repeat;
            background-size: cover;
        }
        .login_box{
            text-align: center;
            border: #8d8d8d solid 1px;
            border-radius: 5px;
            margin-top: 200px;
        }
        .login_box h4{
            margin: 20px 0;
        }
        .login_btn{
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-4 login_box">
            <h4>管理员登录</h4>
            <form action="${pageContext.request.contextPath}/admin_loginCheck" method="post">
                <div class="form-group row justify-content-center">
                    <input type="text" class="form-control  col-md-8" name="admin_name" placeholder="管理员">
                </div>
                <div class="form-group row justify-content-center">
                    <input type="password" class="form-control col-md-8" name="password" placeholder="密码">
                </div>
                <h5 class="text-danger">${register_message}</h5>
                <button type="submit" class="btn btn-primary col-md-8 login_btn">登录</button>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script>

</script>
</body>
</html>
