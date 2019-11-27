<%--
  Created by IntelliJ IDEA.
  User: youzh
  Date: 2019/11/27
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body style="text-align: center">
    <a href="${pageContext.request.contextPath}/CharacterServlet?name=葵花子&password=123456">直接登录</a>
    <form action="${pageContext.request.contextPath}/CharacterServlet" method="post">
        <table border="1" width="600px" cellpadding="0" cellspacing="0" align="center">
            <tr>
                <td height="30" align="center">用户名：</td>
                <td>&nbsp;<input type="text" name="name"></td>
            </tr>
            <tr>
                <td height="30" align="center">密&nbsp;码</td>
                <td>&nbsp;<input type="password" name="password"></td>
            </tr>
            <tr>
                <td height="30" colspan="2" align="center">
                    <input type="submit" value="登录">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
