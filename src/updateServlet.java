

import dbconn.DBconn;
import com.goods.web.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import static dbconn.DBconn.getConnection;

public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Goodsno = req.getParameter("goodsno");
        /*if (Goodsno != null && !Goodsno.equals("")) {
            int id = Integer.valueOf(Goodsno);
            AdminDao dao = new AdminDao();
            Admin admin = dao.selectAdminById(id);
          req.setAttribute("goodsno", id);
        } */
        req.setAttribute("goodsno", Goodsno);
        req.getRequestDispatcher("update.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        new DBconn();
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String good_id = req.getParameter("goodsno");
        String good_name = req.getParameter("goodsname");
        String good_price = req.getParameter("goodsprice");
        String good_number = req.getParameter("goodsnumber");
        String good_sales = req.getParameter("goodssales");
        String good_purchasedata = req.getParameter("purchasedata");
        String good_supplierprice = req.getParameter("supplierprice");
        //后台输出商品信息

        System.out.println(good_id);
        System.out.println(good_name);
        System.out.println(good_price);
        System.out.println(good_number);
        System.out.println(good_sales);
        System.out.println(good_purchasedata);
        System.out.println(good_supplierprice);
        int goodsno = Integer.parseInt(good_id);
        float price = Float.parseFloat(good_price);
        int number = Integer.parseInt(good_number);
        int sale = Integer.parseInt(good_sales);
        float supplierprice = Float.parseFloat(good_supplierprice);
        String sql = "update goods set goodsname = ? ,goodsprice = ? ,goodsnumber = ? ," +
                "goodssales = ?,purchasedata = ?,supplierprice =? where goodsno =?";
        try {
            PreparedStatement prtmt = conn.prepareStatement(sql); // 预编译
            goods good = new goods();
            System.out.println("hhhvhvvjvjvkf");
            prtmt.setString(1, good_name);
            System.out.println(good_name);
            prtmt.setFloat(2, price);
            prtmt.setInt(3, number);
            prtmt.setInt(4, sale);
            System.out.println("fdfffffff");
            prtmt.setString(5,good_purchasedata);
            prtmt.setFloat(6,supplierprice);
            prtmt.setInt(7, goodsno); // 给id赋值
            int resInt = prtmt.executeUpdate();
            System.out.println("zzzzzzzzzz");
            req.setAttribute("resInt", resInt);//返回影响数
            req.setAttribute("right0","商品信息修改成功！");
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




