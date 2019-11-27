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
        /*.float-left{*/
        /*    float: left;*/
        /*}*/
        .clear{
            clear: both;
        }
        .text-golden{
            color: #ea9518;
        }
        /* 使图像填满布局 */
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
        /* 轮播图垂直 */
        .carousel-vertical .carousel-inner .carousel-item-next.carousel-item-left,
        .carousel-vertical .carousel-inner .carousel-item-prev.carousel-item-right {
            -webkit-transform: translateY(0);
            transform: translateY(0);
        }
        .carousel-vertical .carousel-inner .active.carousel-item-left,
        .carousel-vertical .carousel-inner .carousel-item-prev {
            -webkit-transform: translateY(-100%);
            transform: translateY(-100%);
        }
        .carousel-vertical .carousel-inner .active.carousel-item-right,
        .carousel-vertical .carousel-inner .carousel-item-next {
            -webkit-transform: translateY(100%);
            transform: translateY(100%);
        }
        .notice{
            height: 40px;
        }
        .notice .notice-img{
            width: 25px;
            height: 25px;
        }
        /* mall-list */
        .mall_list_div{
            zoom: 1;
            margin-top: 30px;
        }
        .mall_list_div ul{
            text-decoration: none;
            overflow: hidden;
            padding-left: 10px;
        }
        .mall_list_div ul li{
            float: left;
            list-style: none;
            margin-right: 5px;
            margin-bottom: 40px;
        }
        .mall_list_div ul li:last-child{
            margin-right: 0px;
        }
        .mall_list_img{
            width: 117px;
            height: 60px;
            border: #dcdcdc 1px solid;
        }
        .mall_list_img:hover{
            border: #30b30e 1px solid;
        }
    </style>
</head>
<body style="background-color: #f6f6f6">
    <div class="container" style="height: 1080px">
        <div class="header">
            <%@include file="WEB-INF/views/head.jsp"%>
        </div>
        <div class="main" style="background-color: white;margin-top: 15px">
            <!-- 轮播 banner -->
            <div id="banner-carousel" class="carousel slide" data-ride="carousel">

                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>

                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img id="img-banner01" src="${pageContext.request.contextPath}/static/images/banner01.jpg">
                        <div class="carousel-caption">
                            <h3>全球美酒感恩回馈</h3>
                            <p>第二件0元!</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img id="img-banner02" src="${pageContext.request.contextPath}/static/images/banner02.jpg">
                        <div class="carousel-caption">
                            <h3>中华好粮</h3>
                            <p>特惠火拼周</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img id="img-banner03" src="${pageContext.request.contextPath}/static/images/banner03.jpg">
                        <div class="carousel-caption">
                            <h3>清洁去污好帮手</h3>
                            <p>3件7折！！！</p>
                        </div>
                    </div>
                </div>

                <!-- 左右切换按钮 -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>

            </div>
            <!-- 通知 -->
            <div class="notice" style="margin-top: 5px;">
                <img src="${pageContext.request.contextPath}/static/images/notice_img.png" alt="notice" class="notice-img float-left">
                <div id="notice-carousel" class="carousel slide carousel-vertical float-left" data-ride="carousel" style="margin-left:4px;margin-top:2px">
                    <!-- 轮播通知 -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <h6 class="text-golden">今日特价</h6>
                        </div>
                        <div class="carousel-item">
                            <h6 class="text-golden">明日特价</h6>
                        </div>
                        <div class="carousel-item">
                            <h6 class="text-golden">后天特价</h6>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <!-- 合作商列表 -->
            <div class="mall_list_div">
                <ul>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li01.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li02.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li03.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li04.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li05.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li06.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li07.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li08.jpg" alt=""></li>
                    <li><img class="mall_list_img" src="${pageContext.request.contextPath}/static/images/malllistimg/li09.jpg" alt=""></li>
                </ul>
            </div>
        </div>
        <div class="foot" style="margin-top: 10px">
            <%@include file="WEB-INF/views/foot.jsp"%>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script>

    </script>
</body>
</html>
