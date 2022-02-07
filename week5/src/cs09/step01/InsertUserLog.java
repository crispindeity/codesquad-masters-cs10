package cs09.step01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertUserLog {
    public static void main(String[] args) {
        insert();
    }

    private static void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/pcRoomDB";
            conn = DriverManager.getConnection(url, "", "");

            conn.setAutoCommit(false);
            String sql = "INSERT INTO user_log VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);

            userLog(conn, pstmt);

        } catch (SQLException e) {
            System.out.println("에러 " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void userLog(Connection conn, PreparedStatement pstmt) throws SQLException {
        Random random = new Random(System.currentTimeMillis());
        int leftLimit = 97;
        int rightLimit = 122;
        int stringLength = 4;
        List<String> word = selectEnglishWord();

        for (int i = 0; i < 100001; i++) {
            int randomNumber = (random.nextInt(8999) + 1000);
            String randomString = random.ints(leftLimit, rightLimit + 1)
                    .limit(stringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            String nickname = word.get(random.nextInt(100)) + randomString + randomNumber;
            int money = (random.nextInt(100000));
            LocalDateTime dateTime = LocalDateTime.now().minusSeconds(random.nextInt(2678400));
            insertData(pstmt, nickname, money, dateTime);
            commitData(conn, pstmt, i);
        }
        pstmt.executeBatch();
        conn.commit();
    }

    private static void insertData(PreparedStatement pstmt, String nickname, int money, LocalDateTime dateTime) throws SQLException {
        pstmt.setString(1, nickname);
        pstmt.setBigDecimal(2, BigDecimal.valueOf(money));
        pstmt.setObject(3, dateTime);

        pstmt.addBatch();
        pstmt.clearParameters();
    }

    private static void commitData(Connection conn, PreparedStatement pstmt, int i) throws SQLException {
        if( i % 10000 == 0 ){
            pstmt.executeBatch();
            pstmt.clearBatch();
            conn.commit();
        }
    }

    private static List<String> selectEnglishWord() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<String> word = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/pcRoomDB";
            conn = DriverManager.getConnection(url, "", "");

            stmt = conn.createStatement();

            String sql = "SELECT word FROM english_word ORDER BY RAND()";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                word.add(rs.getString(1));
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
        return word;
    }
}