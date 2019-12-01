<%--
  Created by IntelliJ IDEA.
  User: skyzc
  Date: 2019/12/1
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>页面走丢了</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css" >
    <style>
        .error-box {
            height: 100%;
            position: fixed;
            background: url(${pageContext.request.contextPath}/static/images/error-bg.jpg) center center no-repeat #fff !important;
            width: 100%
        }

        .error-box .footer {
            width: 100%;
            left: 0;
            right: 0
        }

        .error-body {
            padding-top: 5%
        }

        .error-body h1 {
            font-size: 210px;
            font-weight: 900;
            line-height: 210px
        }
        .text-muted {
            color: #8d9ea7
        }
        .m-t-30 {
            margin-top: 30px !important
        }
        .m-b-30 {
            margin-bottom: 30px !important
        }
        .m-b-40 {
            margin-bottom: 40px !important
        }
        .btn-rounded {
            border-radius: 60px
        }
        .waves-effect {
            position: relative;
            cursor: pointer;
            display: inline-block;
            overflow: hidden;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            -webkit-tap-highlight-color: transparent
        }


    </style>
</head>
<body>
    <section id="wrapper" class="error-page">
        <div class="error-box">
            <div class="error-body text-center">
                <h1>404</h1>
                <h3 class="text-uppercase">页面走丢了</h3>
                <p class="text-muted m-t-30 m-b-30">您希望尝试找到回家的路</p>
                <a href="${pageContext.request.contextPath}/index" class="btn btn-primary btn-rounded waves-effect waves-light m-b-40">返回主页</a> </div>
            <footer class="footer text-center">2019 © 樱诺商城</footer>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
