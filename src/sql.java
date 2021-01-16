import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class sql {
    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=goods;";
        String sql = "select * from goods";
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, "sa", "123456");
            // 建立Statement对象
            stmt = conn.createStatement();
            /**
             * Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
             */
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql);
            /**
             * ResultSet executeQuery(String sql) throws SQLException 执行给定的 SQL
             * 语句，该语句返回单个 ResultSet 对象
             */
            while (rs.next()) {
                int id = rs.getInt("goodsno");
                String name = rs.getString("goodsname");
                float goodsprice = rs.getFloat("goodsprice");
                int goodsnumber = rs.getInt("goodsnumber");
                int goodssales = rs.getInt("goodssales");
                String purchasedata = rs.getString("purchasedata");
                float supplierprice = rs.getFloat("supplierprice");
                System.out.println("goodsno:" + id + "\tgoodsname:" + name + "\tgoodsprice:" + goodsprice +"\tgoodsnumber:"+ goodsnumber
                + "\tgoodssales:" + goodssales +"\tpurchasedata:" + purchasedata +"\tsupplierprice:" +supplierprice);
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}