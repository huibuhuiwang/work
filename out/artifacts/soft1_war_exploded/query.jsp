<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/10/17
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path4 = request.getContextPath();%>
<html>
<head>
    <title>商品查询界面</title>
</head>
<body>
<table>
    <h1>查询商品</h1><br>
    <thead></thead>
    <tbody>
    <form method="get" id="form" action="<%=path4%>/QueryServlet">
        <tr>
            <td><label>输入商品id：</label></td>
            <td><input type="text" id="good_id" name="goodsno"></td>
        </tr>
        <tr align="center">
            <td><input type="submit" name="Q_sub" id="Q_sub" onclick="QueryVerify()" value="查询"></td>
        </tr>



        <c:forEach items="${ goodsList }" var="goodsList">
            <tr>
                <th>商品号</th>
                <th>商品名字</th>
                <th>商品价格</th>
                <th>商品数量</th>
                <th>商品售价</th>
                <th>商品进货日期</th>
                <th>商品进货价格</th>
            </tr>
            <tr>
                <td>${goodsList.goodsno }</td>
                <td>${goodsList.goodsname }</td>
                <td>${goodsList.goodsprice }</td>
                <td>${goodsList.goodsnumber}</td>
                <td>${goodsList.goodssales}</td>
                <td>${goodsList.purchasedata}</td>
                <td>${goodsList.supplierprice}</td>
                <td colspan="2"><button class="btn btn-primary edBtn"
                                        data-toggle="modal" data-target="#edModal" value="${goodsList.goodsno }" n="${ goodsList.goodsname }" p="${goodsList.goodsprice }"
                                        a="${goodsList.goodsnumber}">编辑</button>
                    <button class="btn btn-danger delBtn" data-toggle="modal"
                            data-target=".delModal" value="${goodsList.goodsno }">删除</button></td>
            </tr>

        </c:forEach>
    </form>
    </tbody>
</table>
<br>
</body>
</html>
<script>
    function QueryVerify() {
        var goodsno = document.getElementById("goodsno").value;
        // var no = 1
        if(goodsno.empty() ||goodsno == null)
        {
            alert('商品号不能为空！');
            //return;
        }
        alert('sdads');

        // else {
        //     document.getElementById("form").submit();
        // }
    }
</script>