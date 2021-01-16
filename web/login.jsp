<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/10/14
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品后台登录</title>
    <style>
        table
        {
            color: #99a9bf;
            background-color: rgba(0,0,0,0.4);
            position: relative;
            width: 520px;
            max-width: 100%;
            padding: 160px 35px 0;
            margin: 0 auto;
            overflow: hidden;
        }
        td th
        {border: 0px solid gray;}
        body{
            margin: 0px;
            padding: 0;
            background-origin: border-box;/*从边框区域显示*/
            background-size:cover;/*指定图片大小，此时会保持图像的纵横比并将图像缩放成将完全覆盖背景定位区域的最小大小*/
        }
        #poster {
            background:url("image/login_ui.jpg") no-repeat;
            background-position: center;
            height: 100%;
            width:100%;
            background-size: cover;
            position: fixed;
        }
        .title-container {
            position: relative; }
        .title {
            font-size: 50px;
            color: #eee;
            text-align: center;
            font-weight: bold;
        }
        input {
            background: transparent;
            border: 0px;
            -webkit-appearance: none;
            border-radius: 0px;
            padding: 12px 5px 12px 15px;
            color: #eee;
            height: 47px;
            caret-color:#fff;
            display: inline-block;
            height: 47px;
            width: 85%;
        }
        form{
            color: #99a9bf;
            background-color: rgba(0,0,0,0.4);
            position: relative;
            width: 520px;
            max-width: 100%;
            padding: 160px 35px 0;
            margin: 0 auto;
            overflow: hidden;
        }
    </style>
</head>
<body id="poster">
<div class="title-container">
    <h3 class="title">商品后台管理系统</h3>
</div>
<table align="center">
    <form method="get" id="form" action="<%=path%>/LoginServlet">
    <thead></thead>
    <tbody>

        <tr>
            <td><label>用户名</label>
                <input type="text"  tabindex="1" id="username" name="username" value="${param.username}" placeholder="请输入用户名"/></td>
            <br>
        </tr>
        <tr>
            <td><label>&nbsp&nbsp&nbsp密码</label>
                <input type="password"  tabindex="1" id="password" name="password" placeholder="请输入密码"/></td>
            <br>
        </tr>
    </tbody>
    <tfoot>
    <tr align="center">
        <td colspan="2">
            <button type="button" name="LoginButton" style="width:100%;margin-bottom:30px;" onclick="LoginVerify();">登录</button>
        </td>
    </tr>
    <tr align="center">
        <td> ${error}</td>
    </tr>
    </tfoot>
    </form>
</table>
</body>
</html>
<script>
    function LoginVerify(){
        var username =document.getElementById("username").value;
        var password =document.getElementById("password").value;
        if(username === ''|| username == null) {
            alert('用户名不能为空！');
            return;
        }
        if(password === ''||password == null) {
            alert('密码不能为空！');
            return;}
        //调用后台servlet
        document.getElementById("form").submit();
    }
</script>
