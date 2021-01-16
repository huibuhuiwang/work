import dbconn.DBconn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String good_id = req.getParameter("goodsno");
        String good_name = req.getParameter("goodsname");
        String good_price = req.getParameter("goodsprice");
        String good_number = req.getParameter("goodsnumber");
        String good_sales = req.getParameter("goodssales");
        String good_purchasedata = req.getParameter("goodspurchasedata");
        String good_supplierprice = req.getParameter("goodssupplierprice");
        //后台输出商品信息

        System.out.println(good_id);
        System.out.println(good_name);
        System.out.println(good_price);
        System.out.println(good_number);
        System.out.println(good_sales);
        System.out.println(good_purchasedata);
        System.out.println(good_supplierprice);

        //回应提交信息
        req.setAttribute("error1","商品信息添加成功！");
        req.getRequestDispatcher("/add.jsp").forward(req,resp);
    }
}
