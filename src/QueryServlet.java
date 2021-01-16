

import com.goods.web.goods;
import dbconn.DBconn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dbconn.DBconn.getConnection;

public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<goods> goodsList = new ArrayList<>(); // 创建一个list集合,用于装user集合

        new DBconn();// 打开数据库连接
        Connection conn = null;
        try {
            conn = getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
       // if (conn == null) {
            //System.out.println("conn为空");
       // } else {
          //  System.out.println("有这句");
       // }
        int good_id = Integer.parseInt(req.getParameter("goodsno"));System.out.println(good_id);
        if(good_id!=' ') {
            String sql = " select * from goods where goodsno = ?;";

            try {
                PreparedStatement prtmt = conn.prepareStatement(sql);
                prtmt.setInt(1, good_id);
                if (good_id == ' ') {
                    System.out.println("kong");
                } else {
                    System.out.println(good_id);
                }
                ResultSet rs = prtmt.executeQuery();

                while (rs.next()) {
                    int goodsno = rs.getInt("goodsno");
                    String goodsname = rs.getString("goodsname");
                    float goodsprice = rs.getFloat("goodsprice");
                    int goodnumber = rs.getInt("goodsnumber");
                    int goodssales = rs.getInt("goodssales");
                    String purchasedata = rs.getString("purchasedata");
                    float supplierprice = rs.getInt("supplierprice");
                    goods good = new goods(); /// 实例化user
                    good.setGoodsno(goodsno);
                    good.setGoodsname(goodsname);
                    good.setGoodsprice(goodsprice);
                    good.setGoodsnumber(goodnumber);
                    good.setGoodssales(goodssales);
                    good.setPurchasedata(purchasedata);
                    good.setSupplierprice(supplierprice);
                    goodsList.add(good);
                    while (goodsList != null) {
                        req.setAttribute("goodsList", goodsList);
                        req.getRequestDispatcher("/display.jsp").forward(req, resp);
                    }
                }
                //DB.close(); // 关闭数据库连接
                //       List<goods> List = goodsList;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
