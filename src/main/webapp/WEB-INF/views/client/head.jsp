
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
</head>
<body>
<div class="container" style="padding: 0">
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #30b30e">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index">樱诺商城</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/mallInfo">关于</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <c:choose>
                    <c:when test="${sessionScope.user  == null }">
                        <button type="button" class="btn btn-success btn-outline-light" data-toggle="modal"
                                data-target="#myModal" style="margin-right: 5px">注册
                        </button>
                        <button type="button" class="btn btn-success btn-outline-light"
                                onclick="location.href = '${pageContext.request.contextPath}/login.jsp'">登录
                        </button>
                    </c:when>
                    <c:otherwise>
                        <h6 style="color: white">你好：<a href="${pageContext.request.contextPath}/userCenter" style="color: #98d4ff">${sessionScope.user.username}</a>
                            <a href="${pageContext.request.contextPath}/logout" style="color: white">，注销</a>
                        </h6>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </nav>
    <!-- 注册提示模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">提示：</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 模态框主体 -->
                <div class="modal-body">
                    注册暂未开放，请在商城结账时提供手机号进行开卡 ^_^
                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>