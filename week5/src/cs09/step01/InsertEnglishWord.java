package cs09.step01;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertEnglishWord {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("week5/src/cs09/db/englishWord");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String word = scan.next();
            insert(word);
        }
    }
    public static void insert(String word) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/pcRoomDB";
            conn = DriverManager.getConnection(url, "", "");

            String sql = "INSERT INTO english_word VALUES (?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, word);
            int count = pstmt.executeUpdate();
            if( count == 0 ){
                System.out.println("데이터 입력 실패");
            }
        }
        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        } finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
}