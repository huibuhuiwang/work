<%--
  Created by IntelliJ IDEA.
  User: liuwenjiang
  Date: 2020/10/24
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@ page import="dbconn.DBconn" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="good" class="com.goods.web.goods"></jsp:useBean>
<jsp:setProperty  name="good" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
    try{
        new DBconn();
        /*try {
            Class.forName("com.server.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();

        }
        String  url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=goods;";
        String userName = "sa"; // 用户名
        String userPwd = "123456"; // 密码
        Connection conn = DriverManager.getConnection(url, userName, userPwd);*/
        Connection conn =DBconn.getConnection();

        String sql = "insert into goods(goodsno,goodsname,goodsprice,goodsnumber,goodssales,purchasedata,supplierprice)values(?,?,?,?,?,?,?)";
        //System.out.println("hfdhfnfnf");
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, good.getGoodsno());
        ps.setString(2, good.getGoodsname());
        ps.setFloat(3, good.getGoodsprice());
        ps.setInt(4, good.getGoodsnumber());
        ps.setInt(5, good.getGoodssales());
        ps.setString(6,good.getPurchasedata());
        ps.setFloat(7,good.getSupplierprice());

        int row = ps.executeUpdate();
        if(row > 0){
            out.print("成功添加了 " + row + "条数据！ ");
        }
        //ps.close();
       // conn.close();
    }catch(Exception e){
        out.print("添加失败!!!  " + e.toString());
    }
%>
<br>
      <div><a href="/displayServlet">返回</a>
</body>
</html>
