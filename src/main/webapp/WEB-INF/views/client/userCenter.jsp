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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/font-awesome-4.7.0/css/font-awesome.min.css" >
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .text-purple {
            color: #6164c1;
        }
        .text-blue {
            color: #13dafe;
        }
        .text-red {
            color: #f96262;
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
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 1%;
            padding: 0;
        }
        .user-info-card .up{
            width: 100%;
            height: 200px;
            background-color: #4fd14b;
        }
        .up .user-content{
            color: white;
            padding-top: 25px;
        }
        .user-content img{
            width: 88px;
            height: 88px;
            border-radius: 50px;
        }
        .user-info-card .down{
            width: 100%;
        }
        .down .user-btm-box{
            margin: 20px 0 ;
        }
        .order-list{
            width: 100%;
        }
        .table th,.table td{
            text-align: center;
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
                    <div class="up">
                        <div class="user-content">
                            <a href="javascript:void(0)" onclick="edit()">
                                <img src="${pageContext.request.contextPath}/static/images/user-head.png"
                                     onmouseover="src='${pageContext.request.contextPath}/static/images/edit-img.png'"
                                     onmouseout="src='${pageContext.request.contextPath}/static/images/user-head.png'"
                                     data-toggle="modal"
                                     data-target="#editInfoModal" alt="">
                            </a>
                            <h4>
                                <c:choose>
                                    <c:when test="${sessionScope.user.gender == '男'}">
                                        <i class="fa fa-mars text-blue"></i>
                                    </c:when>
                                    <c:when test="${sessionScope.user.gender == '女'}">
                                        <i class="fa fa-venus text-red"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="fa fa-question-circle-o text-muted"></i>
                                    </c:otherwise>
                                </c:choose>
                                ${sessionScope.user.username}
                            </h4>
                            <h5>${sessionScope.user.phone}</h5>
                        </div>
                    </div>
                    <div class="down">
                        <div class="user-btm-box row">
                                <%-- 积分 --%>
                            <div class="col-md-4 col-sm-4 text-center">
                                <p class="text-purple"><i class="fa fa-gittip text-purple"></i></p>
                                <h1>${sessionScope.user.point}</h1><span>分</span>
                            </div>
                                <%-- 等级 --%>
                            <div class="col-md-4 col-sm-4 text-center">
                                <p class="text-purple"><i class="fa fa-font-awesome text-blue"></i></p>
                                <h1>${sessionScope.user.rank}</h1><span>级</span>
                            </div>
                                <%-- 所享折扣 --%>
                            <div class="col-md-4 col-sm-4 text-center">
                                <p class="text-purple"><i class="fa fa-stumbleupon text-red"></i></p>
                                <h1>9.5</h1><span>折</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="order-list">
                <h4 class="text-center">我的订单</h4>
                <table class="table">
                    <thead>
                    <tr>
                        <th>订单号</th>
                        <th>金额</th>
                        <th>实付金额</th>
                        <th>创建时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="order" items="${orderList}">
                        <tr>
                            <td>${order.order_id}</td>
                            <td>${order.actual_amount}</td>
                            <td>${order.pay_amount}</td>
                            <td>${order.create_date}</td>
                        </tr>
                    </c:forEach>
<%--                    <tr>--%>
<%--                        <td>201910251323</td>--%>
<%--                        <td>100</td>--%>
<%--                        <td>95</td>--%>
<%--                        <td>2019-10-25 12:34:45</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>201910251323</td>--%>
<%--                        <td>100</td>--%>
<%--                        <td>95</td>--%>
<%--                        <td>2019-10-25 12:34:45</td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>201910251323</td>--%>
<%--                        <td>100</td>--%>
<%--                        <td>95</td>--%>
<%--                        <td>2019-10-25 12:34:45</td>--%>
<%--                    </tr>--%>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
    <!-- 注册提示模态框 -->
    <div class="modal fade" id="editInfoModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">

                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">修改资料</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 模态框主体 -->
                <div class="modal-body">
                    <div class="container-fluid">
                        <form action="${pageContext.request.contextPath}/upgradeUser" method="post">
                            <div class="form-group">
                                <label for="username">用户名:</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="${sessionScope.user.username}" value="${sessionScope.user.username}">
                            </div>
                            <div class="form-group">
                                <label for="phone">手机号：</label>
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="${sessionScope.user.phone}" value="${sessionScope.user.phone}" disabled>
                            </div>
                            <div class="form-group">
                                <label for="gender">性别：</label>
                                <select class="form-control" id="gender" name="gender" selec>
                                    <option selected
                                    <c:choose>
                                        <c:when test="${sessionScope.user.gender == '男'}">
                                            >男</option>
                                            <option>女</option>
                                        </c:when>
                                        <c:when test="${sessionScope.user.gender == '女'}">
                                            >女</option>
                                            <option>男</option>
                                        </c:when>
                                        <c:otherwise>
                                            <i class="fa fa-question-circle-o text-muted"></i>
                                        </c:otherwise>
                                    </c:choose>

                                </select>
<%--                                <input type="password" class="form-control" id="gender" name="gender" placeholder="${sessionScope.user.gender}">--%>
                            </div>
                            <div class="form-group">
                                <label for="address">住址：</label>
                                <input type="text" class="form-control" id="address" name="address" placeholder="${sessionScope.user.address}">
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>

                <!-- 模态框底部 -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">确认更改</button>
                </div>

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
<script>
    function edit() {

    }
</script>
</body>
</html>
