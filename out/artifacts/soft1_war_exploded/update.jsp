<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/11/7
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<% String path5 = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form method="post" name="form"  action="updateServlet" >
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>修改商品信息</h1></td>
        </tr>
        <tr>
            <td>商品id:</td>
            <td><input  type="text" name="goodsno" value="${goodsno}" readonly="readonly"/></td>
        </tr>

        <tr>
            <td>商品名称:</td>
            <td><input  type="text" name="goodsname" /></td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><input  type="text" name="goodsprice"/></td>
        </tr>
        <tr>
            <td>商品数量:</td>
            <td><input  type="text" name="goodsnumber" /></td>
        </tr>
        <tr>
            <td>商品销量:</td>
            <td><input  type="text" name="goodssales"/></td>
        </tr>
        <tr>
            <td>商品进货日期:</td>
            <td><input  type="text" name="purchasedata"/></td>
        </tr>
        <tr>
            <td>商品进价:</td>
            <td><input  type="text" name="supplierprice" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input  type="submit" value="提交" onclick="updateVerify()"/>
                <input  type="button" value="返回" onclick="history.go(-1)"/>
            </td>
        </tr>
    </table>
</form>
${right0}
</body>
</html>
    <script>
            function updateVerify() {
                var goodsno = document.getElementById("goodsno").value;
                var goodsname = document.getElementById("goodsname").value;
                var goodsprice = document.getElementById("goodsprice").value;
                var goodsnumber = document.getElementById("goodsnumber").value;
                var goodssales = document.getElementById("goodssales").value;
                var purchasedata = document.getElementById("purchasedata").value;
                var supplierprice = document.getElementById("supplierprice").value;

                if(goodsno==''||goodsname==''||goodsprice==''||goodsnumber==''||
                goodssales==''||purchasedata==''||supplierprice=='')
                {
                    alert('所修改信息不能为空！');
                    return;
                }
                document.getElementById("form").submit();
            }
    </script>
