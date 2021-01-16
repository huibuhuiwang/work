<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/10/17
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path2 = request.getContextPath();%>
<html>
<head>
    <title>删除商品界面</title>
</head>
<body>
<table>
    <h1>删除商品</h1><br>
    <thead>请仔细输入商品信息!</thead>
    <tbody>
    <form method="get" action="<%=path2%>/deleteServlet">
        <tr>
        <td><label>删除商品id：</label></td>
        <td><input type="text" id="good_id" name="goodsno"></td>
        </tr>
        <br>
        <tr>
            <td><label>删除商品名字：</label></td>
            <td><input type="text" id="good_name" name="goodsname"></td>
        </tr>
        <br>
        <tr align="center">
        <td><input type="submit" id="del_submit" name="del_submit" onclick="delVerify()" value="确认删除"></td>
        </tr>
    </form>
    </tbody>
</table>
${right}
<br>
<a href="display.jsp">返回</a>
</body>
</html>
    <script type="text/javascript">
           function delVerify() {
               var goodsno = document.getElementById("goodsno").value;
               var goodsname = document.getElementById("goodsname").value;

                if(goodsno ==null||goodsno==='')
                {var flag="fdsfd";

                    alert('商品id不能为空！');
                    document.write(flag);//alert之后
                    return;
                }
                if(goodsname ==null||goodsno==='')
                {
                    alert('商品名字不能为空！');
                    return;
                }
             document.getElementById("form");
           }
    </script>