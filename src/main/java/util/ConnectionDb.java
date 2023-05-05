package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/shoppingCart";
    private static String USER = "root";
    private static String PASSWORD = "123456789";
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static void closeConnecction(Connection conn){
        try {
            if (conn != null) {
                conn.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectionDb.getConnection();
    }
}
