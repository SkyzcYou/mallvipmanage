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
        .dosomething{
            margin: 0;
        }
        .dosomething .do-left{
            padding-left: 0;
            padding-right: 0;
        }
        .dosomething .do-right{
            padding-right: 0;
            padding-left: 7px;
        }
        .do-left-in{
            background-color: white;
            border-radius: 5px;
            height: 100%;
            padding: 15px;
        }
        .do-right-in{
            background-color: white;
            border-radius: 5px;
            height: 100%;
            padding: 15px;
        }
        .new-order-list{
            list-style: none;
        }
        .new-order-list .new-order{
            border-bottom: 1px solid rgba(120, 130, 140, .13);;
        }
        .new-order-list .new-order:last-child{
            border-bottom: none;
        }
        .new-order-list .new-order img{
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }
        .new-order .text-area{
            margin-left: 10px;
        }
        .new-order-list .new-order .text-area p{
            margin-bottom: 0;
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
        <li class="nav-left-item active">
            <a class="link active" href="${pageContext.request.contextPath}/admin/manageVipRule">会员体系管理</a>
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
        <li class="breadcrumb-item">商城会员体系管理</li>
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
    <div class="dosomething row">
        <div class="do-left col-md-12">
            <div class="do-left-in">
                <h6 class="text-bold">会员体系说明：</h6>
                樱诺商城拥有独特的一套会员体系：<br>
                1.会员一共分为6个等级，相应积分对应不同等级，可根据线下商城规模大小灵活配置积分与等级关系，但是6个等级不可更改。<br>
                2.会员在每次结算时会根据会员体系规则自动更新积分、等级。
            </div>
        </div>
    </div>
    <!-- 编辑模态框 -->
    <div class="modal fade" id="editVipRuleModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">修改会员体系:</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <!-- 模态框主体 -->
                <div class="modal-body">
                    <div class="container-fluid">
                        <form id="editVipRuleForm" action="" method="post">
                            <div class="form-group">
                                <label for="edit_id">ID(不可更改):</label>
                                <input type="text" class="form-control" id="edit_id" name="id" placeholder="输入规则ID" disabled>
                            </div>
                            <div class="form-group">
                                <label for="edit_max_point">等级对应最大积分</label>
                                <input type="text" class="form-control" id="edit_max_point" name="max_point" placeholder="输入内容">
                            </div>
                            <div class="form-group">
                                <label for="edit_is_rank">等级</label>
                                <input type="text" class="form-control" id="edit_is_rank" name="is_rank" placeholder="输入内容">
                            </div>
                            <div class="form-group">
                                <label for="edit_rebate">所享折扣</label>
                                <input type="text" class="form-control" id="edit_rebate" name="rebate" placeholder="输入内容">
                            </div>
                            <button type="button" class="btn btn-primary" id="editVipRule-btn">确认修改</button>
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
        uniqueId: "id",  // 每行唯一标识
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
            field: 'id',
            title: 'ID'
        }, {
            field: 'max_point',
            title: '等级最大积分'
        }, {
            field: 'is_rank',
            title: '等级'
        },{
            field:'rebate',
            title:'享受优惠'
        }],
        data: [
    <c:forEach var="vipRule" items="${vipRuleList}">
            {
        id:'${vipRule.id}',
        max_point:'${vipRule.max_point}',
        is_rank:'${vipRule.is_rank}',
        rebate:'${vipRule.rebate}'
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
            $("#editVipRuleModal").modal("show");
            $("#edit_id").val(selectedRows[0].id);
            $("#edit_max_point").val(selectedRows[0].max_point);
            $("#edit_is_rank").val(selectedRows[0].is_rank);
            $("#edit_rebate").val(selectedRows[0].rebate);
        }
    });
    $("#editVipRule-btn").click(function () {
        if ($("#edit_id").val() === "" || $("#edit_max_point").val() === "" || $("#edit_is_rank").val() === "" || $("#edit_rebate").val() === ""){
            alert("不能留空")
        }else {
            var selectedRows = $("#table").bootstrapTable('getSelections');
            var data=$('#editVipRuleForm').serialize();
            data= "id="+selectedRows[0].id+"&"+decodeURIComponent(data,true);
            console.log("eidtVipRule:"+data);
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/editVipRule",
                type: "POST",
                data: data,
                success:function (result) {
                    var obj = jQuery.parseJSON(result);
                    console.log( obj.msg);
                    if (obj.msg){
                        alert("修改规则成功")
                        window.location.reload()
                    }else {
                        alert("修改规则出错")
                    }
                },
                error:function () {
                    console.log(e.status);
                    console.log(e.responseText);
                    alert("修改规则失败")
                }
            })
        }
    });



</script>
</body>
</html>
