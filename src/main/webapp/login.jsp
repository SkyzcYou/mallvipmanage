<%--
  Created by IntelliJ IDEA.
  User: youzh
  Date: 2019/11/27
  Time: 0:40
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
    <style>
        .main{
            background-color: white;
            margin-top: 15px;
            height: 600px;
        }
        .content{
            padding-top: 30px;
        }
        .login_form_div{
            margin: 0 auto;
            width: 400px;
            padding: 30px;
            border: #8d8d8d 1px solid;
            border-radius: 5px;
            text-align: center;
        }
        .form-group{
            padding: 0 15px;
        }
    </style>
</head>
<body style="background-color: #f6f6f6">
    <div class="container" style="height: 1080px">
        <div class="header">
            <%@include file="WEB-INF/views/client/head.jsp"%>
        </div>
        <div class="main">
            <div class="content row">
                <div class="login_form_div col-md-4 align-self-center">
                    <h5>登录</h5><hr>
                    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
                        <div class="form-group row">
                            <label for="phone" class="col-md-4">手机号:</label>
                            <input type="text" class="form-control col-md-8" id="phone" name="phone" placeholder="输入您的手机号">
                        </div>
                        <div class="form-group row">
                            <label for="password" class="col-md-4">输入密码:</label>
                            <input type="password" class="form-control col-md-8" id="password" name="password" placeholder="输入密码">
                        </div>
                        <button type="submit" class="btn btn-primary" style="width: 100%;padding: 0 15px">登录</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="foot" style="margin-top: 10px">
            <%@include file="WEB-INF/views/client/foot.jsp"%>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script>

    </script>
</body>
</html>
