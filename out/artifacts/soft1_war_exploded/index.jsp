<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/10/13
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>商品后台首页</title>
    <script type="javascript">
          function indexServlet() {
              $.ajax({
                  url: "sql",//servlet文件的名称
                  type: "GET",
                  success: function (e) {
                      alert("servlet调用成功！");
                  }
                  }
              )
          }
    </script>
  </head>
  <style>
  body{
  background-origin: border-box;/*从边框区域显示*/
  background-size:cover;/*指定图片大小，此时会保持图像的纵横比并将图像缩放成将完全覆盖背景定位区域的最小大小*/
  }
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
  <body onload="indexServlet()">
  <br>
  <body background="image/image2.jpg"></body>
  嗨 你好!${username}<a href="login.jsp">退出</a>
  <br><br>
  <div class="btns"><a href="add.jsp">添加商品</a></div>
  <div class="btns"><a href="delete.jsp">删除商品</a></div>
  <div class="btns"><a href="update.jsp">修改商品信息</a></div>
  <div class="btns"><a href="query.jsp">查询商品</a></div>
    <div class="btns"><a href="display.jsp">显示商品信息</a></div>

  </body>
</html>
