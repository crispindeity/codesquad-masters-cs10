package cs09.step01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Select {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/pcRoomDB";
            conn = DriverManager.getConnection(url, "", "");

            stmt = conn.createStatement();

            String sql = "SELECT nickname, money, last_visit FROM user_log";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString(1);
                BigDecimal money = rs.getBigDecimal(2);
                LocalDateTime lastVisit = (LocalDateTime) rs.getObject(3);

                System.out.println(name + " " + money + " " + lastVisit);
            }

        }
        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }
        finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}