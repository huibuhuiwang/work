<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/10/28
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<% String path3 = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有商品信息</title>
    <style>
        table,  th tr
        {border: 1px solid gray;}
        td{border: 1px solid gray;}
        th{border: 1px solid gray;}
        a{
            color: black;
            TEXT-DECORATION:none
        }
        .btns{
            background: white;
            float: left;
            list-style: none;
            width: 160px;
            height: 100px;
            text-align: center;
            line-height: 100px;
            color: #DCF4F4;
        }
        .btns:hover{
            color: white;
            font-weight: bold;
            background: blue;
        }
    </style>
</head>

<body>
嗨 你好!${username}<a href="login.jsp">退出</a>
<br><br>
<div class="btns"><a href="add.jsp">添加商品</a></div>
<div class="btns"><a href="delete.jsp">删除商品</a></div>
<div class="btns"><a href="update.jsp">修改商品信息</a></div>
<div class="btns"><a href="query.jsp">查询商品</a></div>
<div class="btns"><a href="display.jsp">显示商品信息</a></div>
<br><br><br><br><br>
<br>
    <table>
        <thead>

        <tr>
            <th>序号</th>
            <th>商品号</th>
            <th>商品名字</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>商品售价</th>
            <th>商品进货日期</th>
            <th>商品进货价格</th>
        </tr>
    </thead>
        <tbody>
        <c:forEach items="${ goodsList }" var="goodsList" varStatus="vs">
        <tr>
            <td>${vs.index + 1}</td>
            <td>${goodsList.goodsno }</td>
            <td>${goodsList.goodsname }</td>
            <td>${goodsList.goodsprice }</td>
            <td>${goodsList.goodsnumber}</td>
            <td>${goodsList.goodssales}</td>
            <td>${goodsList.purchasedata}</td>
            <td>${goodsList.supplierprice}</td>
            <td colspan="2"><a href="updateServlet?goodsno=${goodsList.goodsno}">编辑</a>
                <button class="btn btn-danger delBtn" data-toggle="modal"
                        data-target=".delModal" value="${goodsList.goodsno }">删除</button></td>
        </tr>
        </tbody>
    </c:forEach>
    </table>
</body>
</html>
    <script>

    </script>
