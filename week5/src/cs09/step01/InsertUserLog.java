package cs09.step01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertUserLog {
    public static void main(String[] args) throws IOException {
        insert();
    }

    private static void insert() throws IOException {
        long beforeTime = System.currentTimeMillis();
        userLog();
        long afterTime = System.currentTimeMillis();
        System.out.println((afterTime - beforeTime) / 1000);
    }

    private static void userLog() throws IOException {
        Random random = new Random(System.currentTimeMillis());
        int leftLimit = 97;
        int rightLimit = 122;
        int stringLength = 4;
        List<String> word = selectEnglishWord();
        File csvFile = new File("week5/src/cs09/step01/data.sql");
        BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true));
        bw.write("SET AUTOCOMMIT = FALSE; ");
        for (int i = 0; i < 100; i++) {
            bw.write("INSERT user_log VALUES");
            for (int j = 1; j < 10001; j++) {
                int randomNumber = (random.nextInt(8999) + 1000);
                String randomString = random.ints(leftLimit, rightLimit + 1)
                        .limit(stringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                String nickname = word.get(random.nextInt(100)) + randomString + randomNumber;
                int money = (random.nextInt(100000));
                LocalDateTime dateTime = LocalDateTime.now().minusSeconds(random.nextInt(2678400));
                bw.write("('" + nickname + "', " + money + ", '" + dateTime + "')");
                bw.write(j < 10001 - 1 ? ", " : "; ");
//                progressPercentage(j, 100000);
            }
        }
        bw.write("COMMIT; SET AUTOCOMMIT = TRUE;");
        bw.flush();
        bw.close();
    }

    public static void progressPercentage(int remain, int total) {
        if (remain > total) {
            throw new IllegalArgumentException();
        }
        int maxBareSize = 10;
        int remainPercent = ((100 * remain) / total) / maxBareSize;
        char defaultChar = '-';
        String icon = "#";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        String bareDone = "[" +
                icon.repeat(Math.max(0, remainPercent));
        String bareRemain = bare.substring(remainPercent);
        System.out.print("\r" + bareDone + bareRemain + " " + remainPercent * 10 + "%");
        if (remain == total) {
            System.out.print("\n");
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
            conn = DriverManager.getConnection(url, "geombong", "123456");

            stmt = conn.createStatement();

            String sql = "SELECT word FROM pcRoomDB.english_word ORDER BY RAND()";

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