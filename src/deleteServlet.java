

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dbconn.DBconn;
import static dbconn.DBconn.getConnection;

public class deleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         new DBconn();
        Connection  conn = null;
        try {
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int goodsno = Integer.parseInt(req.getParameter("goodsno")); // 传入id;
        if (goodsno != ' ') {
            String sql = "delete from goods where goodsno = ?";
            try {
                PreparedStatement prtmt = conn.prepareStatement(sql); // 预编译

                prtmt.setInt(1, goodsno); // 给id赋值
                int resInt = prtmt.executeUpdate(); // 执行sql返回影响行数;
                req.setAttribute("resInt", resInt);
                req.setAttribute("right","商品信息删除成功！");
                req.getRequestDispatcher("/delete.jsp").forward(req, resp);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
