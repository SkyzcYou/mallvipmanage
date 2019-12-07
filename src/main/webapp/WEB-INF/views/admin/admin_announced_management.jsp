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
        <li class="nav-left-item active">
            <a class="link active" href="${pageContext.request.contextPath}/admin/manageAnnounce">商城公告管理</a>
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
        <li class="nav-left-item">
            <a class="link" href="${pageContext.request.contextPath}/admin/manageAdmin">管理员管理</a>
        </li>
    </ul>
</nav>
<div class="tip-head">
    <h5>欢迎来到商城管理中心</h5>
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">控制台</a></li>
        <li class="breadcrumb-item">商城公告管理</li>
    </ol>
</div>
<div class="main-bg">
    <div class="table_show">
        <div class="table-box">
            <div id="toolbar" class="btn-group operation">
                <button id="btn_edit" type="button" class="btn bg-primary text-white">
                    <i class="fa fa-pencil text-white" aria-hidden="true"></i> 修改
                </button>
            </div>
            <table id="table" class="my-table table-hover table-bordered"></table>
        </div>
    </div>
    <!-- 编辑模态框 -->
    <div class="modal fade" id="editAnnModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">修改公告:</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- 模态框主体 -->
                <div class="modal-body">
                    <div class="container-fluid">
                        <form id="editAnnForm" action="" method="post">
                            <div class="form-group">
                                <label for="edit_ann_name">公告名字(不可更改):</label>
                                <input type="text" class="form-control" id="edit_ann_name" name="ann_name" placeholder="输入名字" disabled>
                            </div>
                            <div class="form-group">
                                <label for="edit_ann_content01">第一条公告</label>
                                <input type="text" class="form-control" id="edit_ann_content01" name="ann_content01" placeholder="输入内容">
                            </div>
                            <div class="form-group" id="form-group02">
                                <label for="edit_ann_content02">第二条公告</label>
                                <input type="text" class="form-control" id="edit_ann_content02" name="ann_content02" placeholder="输入内容">
                            </div>
                            <div class="form-group" id="form-group03">
                                <label for="edit_ann_content03">第三条公告</label>
                                <input type="text" class="form-control" id="edit_ann_content03" name="ann_content03" placeholder="输入内容">
                            </div>
                            <button type="button" class="btn btn-primary" id="editAnn-btn">确认修改</button>
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
            field: 'ann_id',
            title: 'ann_ID'
        }, {
            field: 'ann_name',
            title: '公告名称'
        }, {
            field: 'ann_content',
            title: '公告内容'
        }],
        data: [
    <c:forEach var="ann" items="${annList}">
            {
        ann_id:'${ann.ann_id}',
        ann_name:'${ann.ann_name}',
        ann_content:'${ann.ann_content}'
            },
    </c:forEach>
    ]
    });
    // 编辑
    $("#btn_edit").click(function () {
        var selectedRows = $("#table").bootstrapTable('getSelections');
        if (selectedRows.length === 0){
            alert("请先选中要修改的数据");
        }else {
            if (selectedRows[0].ann_id !== "1"){
                $("#form-group02").hide();
                $("#form-group03").hide();
            }
            $("#editAnnModal").modal("show");
            $("#edit_ann_name").val(selectedRows[0].ann_name);
            var strArray = new Array();
            strArray=selectedRows[0].ann_content.split("&");
            $("#edit_ann_content01").val(strArray[0]);
            $("#edit_ann_content02").val(strArray[1]);
            $("#edit_ann_content03").val(strArray[2]);
        }
    });
    $("#editAnn-btn").click(function () {
        if ($("#edit_ann_name").val() === "" || $("#edit_ann_content").val() === ""){
            alert("不能留空")
        }else {
            var selectedRows = $("#table").bootstrapTable('getSelections');
            var ann_id = selectedRows[0].ann_id;
            var ann_name = selectedRows[0].ann_name;
            var data=$('#editAnnForm').serialize();
            data= "ann_id="+ann_id+"&"+"ann_name="+ann_name+"&"+decodeURIComponent(data,true);
            console.log("eidtAnn:"+data);
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/editAnn",
                type: "POST",
                data: data,
                success:function (result) {
                    var obj = jQuery.parseJSON(result);
                    console.log( obj.msg);
                    if (obj.msg){
                        alert("修改公告成功")
                        window.location.reload()
                    }else {
                        alert("修改公告失败")
                    }
                },
                error:function () {
                    console.log(e.status);
                    console.log(e.responseText);
                    alert("修改公告失败")
                }
            })
        }
    });



</script>
</body>
</html>
