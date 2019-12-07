<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <title>樱诺商城-管理员管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/static/images/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/bootstrap-table-1.15.1/bootstrap-table.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/libs/font-awesome-4.7.0/css/font-awesome.min.css" >
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>

    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .clear{
            clear: both;
        }
        a,a:hover{
            text-decoration: none;
        }
        .text-bold{
            font-weight: bold;
        }
        .color-blue{
            color: #13DAFE;
        }
        .text-purple {
            color: #6164c1;
        }
        .active{
            background-color: #13DAFE !important;
            color: white !important;
        }
        body{
            background-color: #EAECF2;
        }

        .nav-top {
            padding: 0 16px 0 0;
            background-color: white;
            box-shadow:0 15px 10px -15px #ccc;
        }
        .nav-top .top-left-part{
            width: 220px;
            float: left;
            line-height: 56px;
            background: #3a3f51;
            padding-left: 16px;
        }
        .top-left-part .logo{
            color: white;
            font-size: 16px;
        }
        .nav-top .navbar-nav{
            position: absolute;
            right: 0;
            padding-right: 25px;
        }
        .navbar-nav .admin-btn:hover{
            background-color: #E5E5E5;
            border-radius: 50px;
        }
        .nav-top .navbar-nav img{
            border-radius: 50%;
            width: 36px;
            height: 36px;
            margin-top: 3px;
        }
        .nav-top .navbar-nav a{
            color: black;
            font-weight: bold;
        }

        .nav-left {
            width: 220px;
            height: 100vh;
            background-color: #3A3F51;
            color: #575B6A;
            position: fixed;
            left: 0;
            top: 56px;
        }
        .nav-left .nav-left-ul{

        }
        .nav-left-ul .nav-left-item{
            color: rgba(255, 255, 255, .4);
            height: 56px;
            padding-left: 16px;
        }
        .nav-left-ul .nav-left-item:hover{
            background-color: #3A3F51;
        }
        .nav-left-ul .nav-left-item a{
            line-height: 56px;
            color: rgba(255, 255, 255, .4);
        }

        .tip-head{
            position: absolute;
            top: 90px;
            left: 235px;
            padding-left: 20px;
        }
        .tip-head h5{
            font-weight: bold;
        }
        .tip-head .breadcrumb{
            padding-top: 0;
            padding-left: 0;

        }
        .main-bg {
            background-color: #F1F2F7;
            width: 1683px;
            height: 1080px;
            position: absolute;
            top: 168px;
            left: 220px;
            padding: 15px;
        }
        .table_show{
            background-color: white;
            margin: 0;
            width: 100%;
            padding-bottom: 75px;
            border-radius: 5px;
            margin-bottom: 15px;
        }
        .table-box{
            width: 100%;
            padding: 10px;
        }
        .btn-group{
            margin-bottom: 10px;
        }
        .btn{
            margin-right: 10px;
        }

    </style>
    <script>
        //窗口大小改变时，执行
        $(window).resize(function () {
            //执行代码块
            editMainBg();
        });
        function editMainBg() {
            let now_width = $(document.body).width()-220-30;
            $(".main-bg").width(now_width);
            console.log("动态更改 main-bg 的宽度" + now_width);
        }
    </script>
</head>
<body onload="editMainBg()">
<nav class="fixed-top fixed-top navbar navbar-expand-sm nav-top">
    <div class="top-left-part">
        <a class="logo" href="#"><i class="fa fa-fire color-blue"></i>&nbsp;
            <span class="hidden-xs">MY ADMIN</span>
        </a>
    </div>
    <ul class="navbar-nav">
        <li class="nav-item admin-btn">
            <img src="${pageContext.request.contextPath}/static/images/admin/admin-head.png" alt="" class="nav-img float-left">
            <a class="nav-link float-left" href="">${sessionScope.admin.admin_name}</a>
            <a class="nav-link float-left text-danger" href="${pageContext.request.contextPath}/adminLogout">，注销</a>
            <div class="clear"></div>
        </li>
    </ul>
    <div class="clear"></div>
</nav>
<nav class="nav-left">
    <ul class="nav-left-ul">
        <li class="nav-left-item">
            <a class="link" href="${pageContext.request.contextPath}/admin">控制台</a>
        </li>
        <li class="nav-left-item">
            <a class="link" href="${pageContext.request.contextPath}/admin/manageAnnounce">商城公告管理</a>
        </li>
        <li class="nav-left-item">
            <a class="link" href="${pageContext.request.contextPath}/admin/manageUser">用户管理</a>
        </li>
        <li class="nav-left-item">
            <a class="link" href="${pageContext.request.contextPath}/admin/manageOrder">订单管理</a>
        </li>
        <li class="nav-left-item">
            <a class="link" href="${pageContext.request.contextPath}/admin/manageVipRule">会员体系管理</a>
        </li>
        <li class="nav-left-item active">
            <a class="link active" href="${pageContext.request.contextPath}/admin/manageAdmin">管理员管理</a>
        </li>
    </ul>
</nav>
<div class="tip-head">
    <h5>欢迎来到商城管理中心</h5>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">控制台</a></li>
        <li class="breadcrumb-item">管理员管理</li>
    </ol>
</div>
<div class="main-bg">
    <div class="table_show">
        <div class="table-box">
<%--             页面上的三个button，增删改--%>
            <div id="toolbar" class="btn-group operation">
                <button id="btn_add" type="button" class="btn bg-success text-white" data-toggle="modal" data-target="#addAdminModal">
                    <i class="fa fa-plus text-white" aria-hidden="true"></i>新增
                </button>
                <button id="btn_edit" type="button" class="btn bg-primary text-white">
                    <i class="fa fa-pencil text-white" aria-hidden="true"></i> 修改
                </button>
                <button id="btn_delete" type="button" class="btn btn-danger">
                    <i class="fa fa-minus text-white" aria-hidden="true"></i> 删除
                </button>
            </div>
            <table id="table" class="my-table table-hover table-bordered"></table>
        </div>

<%--        <table class="table table-bordered table-hover" id="table">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>Admin ID</th>--%>
<%--                <th>会员名</th>--%>
<%--                <th>密码</th>--%>
<%--                <th>备注</th>--%>
<%--                <th>操作</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach var="admin" items="${adminList}">--%>
<%--                <tr>--%>
<%--                    <td>${admin.admin_id}</td>--%>
<%--                    <td>${admin.admin_name}</td>--%>
<%--                    <td>${admin.password}</td>--%>
<%--                    <td>${admin.note}</td>--%>
<%--                    <td>--%>
<%--                        <button class="btn-primary" id="view-data-btn">查看</button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
    </div>
    <!-- 新增模态框 -->
    <div class="modal fade" id="addAdminModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">新建管理员:</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- 模态框主体 -->
                <div class="modal-body">
                    <div class="container-fluid">
                        <form id="addAdminForm" action="" method="post">
                            <div class="form-group">
                                <label for="admin_name">管理员:</label>
                                <input type="text" class="form-control" id="admin_name" name="admin_name" placeholder="输入名字">
                            </div>
                            <div class="form-group">
                                <label for="password">管理员密码：</label>
                                <input type="text" class="form-control" id="password" name="password" placeholder="设置密码">
                            </div>
                            <div class="form-group">
                                <label for="note">备注：</label>
                                <input type="text" class="form-control" id="note" name="note" placeholder="输入该管理员备注">
                            </div>
                            <button type="button" class="btn btn-primary" id="createAdmin-btn">新建</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 编辑模态框 -->
    <div class="modal fade" id="editAdminModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">修改管理员信息:</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- 模态框主体 -->
                <div class="modal-body">
                    <div class="container-fluid">
                        <form id="editAdminForm" action="" method="post">
                            <div class="form-group">
                                <label for="edit_admin_name">名字:</label>
                                <input type="text" class="form-control" id="edit_admin_name" name="admin_name" placeholder="输入名字">
                            </div>
                            <div class="form-group">
                                <label for="edit_password">管理员密码：</label>
                                <input type="text" class="form-control" id="edit_password" name="password" placeholder="设置密码">
                            </div>
                            <div class="form-group">
                                <label for="edit_note">备注：</label>
                                <input type="text" class="form-control" id="edit_note" name="note" placeholder="输入该管理员备注">
                            </div>
                            <button type="button" class="btn btn-primary" id="editAdmin-btn">确认修改</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-table-1.15.1/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/static/libs/bootstrap-table-1.15.1/bootstrap-table-zh-CN.min.js"></script>

<script>
    $('#table').bootstrapTable({
        striped:true,  // 是否显示行间隔色
        uniqueId: "admin_id",  // 每行唯一标识
        pageSize:"10",  // 分页大小
        toolbar: '#toolbar', // 指定工具栏
        search: true,   // 搜索框
        pagination:true, // 开启分页
        showHeader: true,     //是否显示列头
        showLoading: true,   // 显示加载
        clickToSelect: true, //是否启用点击选中行
        singleSelect : true,// 单选
        columns: [
            {
                checkbox:true
            },{
            field: 'admin_id',
            title: 'Admin_ID'
        }, {
            field: 'admin_name',
            title: '管理员名'
        }, {
            field: 'password',
            title: '密码'
        },{
            field:'note',
            title:'备注'
        }],
        data: [
    <c:forEach var="admin" items="${adminList}">
            {
        admin_id:'${admin.admin_id}',
        admin_name:'${admin.admin_name}',
        password:'${admin.password}',
        note:'${admin.note}'
            },
    </c:forEach>
    ]
    });
    // 删除
    $("#btn_delete").click(function () {
        var selectedRows = $("#table").bootstrapTable('getSelections');
        if (selectedRows.length === 0){
            alert("请先选中要删除的数据");
        }else {
            $.ajax({
                url:"${pageContext.request.contextPath}/admin/delAdminByAdminId",
                type:"GET",
                data: {admin_id:selectedRows[0].admin_id},
                success:function (result) {
                    console.log(result);
                    var obj = jQuery.parseJSON(result);
                    console.log( obj.msg);
                    if (obj.msg){
                        alert("删除数据成功")
                    }
                    window.location.reload()
                },
                error:function (e) {
                    console.log(e.status);
                    console.log(e.responseText);
                }
            })
        }

    });
    // 新建
    $("#createAdmin-btn").click(function () {
        if ($("#admin_name").val() === "" || $("#password").val() === "" || $("#note").val() === ""){
            alert("不能留空")
        }else {
            var data=$('#addAdminForm').serialize();
            data= decodeURIComponent(data,true);
            console.log("New data:"+data);
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/addAdmin",
                type: "POST",
                data: data,
                success:function (result) {
                    var obj = jQuery.parseJSON(result);
                    console.log( obj.msg);
                    if (obj.msg){
                        alert("新增管理员成功");
                        window.location.reload()
                    }else {
                        alert("新增管理员失败")
                    }
                },
                error:function () {
                    console.log(e.status);
                    console.log(e.responseText);
                    alert("新增管理员失败")
                }
            })
        }
    });
    // 编辑
    $("#btn_edit").click(function () {

        var selectedRows = $("#table").bootstrapTable('getSelections');
        console.log(selectedRows.length);
        if (selectedRows.length === 0){
            alert("请先选中要修改的数据");
        }else {
            $("#editAdminModal").modal("show");
            $("#edit_admin_name").val(selectedRows[0].admin_name);
            $("#edit_password").val(selectedRows[0].password);
            $("#edit_note").val(selectedRows[0].note)
        }
    });
    $("#editAdmin-btn").click(function () {
        if ($("#edit_admin_name").val() === "" || $("#edit_password").val() === "" || $("#edit_note").val() === ""){
            alert("不能留空")
        }else {
            var selectedRows = $("#table").bootstrapTable('getSelections');
            var admin_id = selectedRows[0].admin_id;
            var data=$('#editAdminForm').serialize();
            data= "admin_id="+admin_id+"&"+decodeURIComponent(data,true);
            console.log("New data:"+data);
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/editAdmin",
                type: "POST",
                data: data,
                success:function (result) {
                    var obj = jQuery.parseJSON(result);
                    console.log( obj.msg);
                    if (obj.msg){
                        alert("修改管理员信息成功")
                        window.location.reload()
                    }else {
                        alert("修改管理员信息失败")
                    }
                },
                error:function () {
                    console.log(e.status);
                    console.log(e.responseText);
                    alert("修改管理员信息失败")
                }
            })
        }
    });



</script>
</body>
</html>
