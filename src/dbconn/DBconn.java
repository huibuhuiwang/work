package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBconn {
    private static final String driver ="com.server.jdbc.Driver";
    private static final String url ="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=goods;";
    private static final String username ="sa";
    private static final  String password ="123456";
    private static Connection conn =null;

    public static void Driver(){
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 单例模式返回数据库连接对象
    public static Connection getConnection() throws Exception {
         Driver();
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn;
    }
    public static void main(String[] args) {
        try {
            Connection conn = DBconn.getConnection();
            if (conn != null) {
                System.out.println("数据库连接正常");
            } else {
                System.out.println("数据库连接异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
