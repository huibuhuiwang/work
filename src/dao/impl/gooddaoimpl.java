package dao.impl;

import com.goods.web.goods;
import dao.gooddao;
import dbconn.DBconn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dbconn.DBconn.getConnection;

public class gooddaoimpl implements gooddao {
    @Override
    public List<goods> querygoods() throws Exception {
        DBconn DB = new DBconn();
        List<goods> goodsList = new ArrayList<>(); // 创建一个list集合,用于装user集合
        String sql =" select * from goods ";
        Connection conn = DB.getConnection();
        Statement stmt =null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
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
                good.setGoodssales(goodssales);good.setSupplierprice(supplierprice);
                good.setPurchasedata(purchasedata);

                goodsList.add(good);
            }
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return goodsList;
    }
    @Override
    public int queryById(String good_id)throws Exception{
        List<goods> goodsList = new ArrayList<>(); // 创建一个list集合,用于装user集合

        new DBconn();// 打开数据库连接
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(good_id);
        int flag = 0;
        if(id!=' ') {
            String sql = " select * from goods where goodsno = ?;";
            try {
                PreparedStatement prtmt = conn.prepareStatement(sql);
                prtmt.setInt(1, id);
                ResultSet rs = prtmt.executeQuery();
//                while (rs.next()) {
//                    int goodsno = rs.getInt("goodsno");
//                    String goodsname = rs.getString("goodsname");
//                    float goodsprice = rs.getFloat("goodsprice");
//                    int goodnumber = rs.getInt("goodsnumber");
//                    int goodssales = rs.getInt("goodssales");
//                    String purchasedata = rs.getString("purchasedata");
//                    float supplierprice = rs.getInt("supplierprice");
//                    goods good = new goods(); /// 实例化user
//                    good.setGoodsno(goodsno);
//                    good.setGoodsname(goodsname);
//                    good.setGoodsprice(goodsprice);
//                    good.setGoodsnumber(goodnumber);
//                    good.setGoodssales(goodssales);
//                    good.setPurchasedata(purchasedata);
//                    good.setSupplierprice(supplierprice);
//                    goodsList.add(good);
//                    while (goodsList != null) {
//                        req.setAttribute("goodsList", goodsList);
//                        req.getRequestDispatcher("/display.jsp").forward(req, resp);
//                    }
//                }
                if(rs==null){
                    flag = 1;
                }
                else{
                    flag = 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
