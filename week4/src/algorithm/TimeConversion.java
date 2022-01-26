package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TimeConversionResult {

    public static String timeConversion(String s) {
        StringBuilder sb = new StringBuilder();
        String[] tmp = s.split(":");

        if (tmp[2].split("")[2].equals("P") && Integer.parseInt(tmp[0]) < 12) {
            tmp[0] = String.valueOf(Integer.parseInt(tmp[0]) + 12);
        }

        if (Integer.parseInt(tmp[0]) == 12 && !tmp[2].split("")[2].equals("P")) {
            tmp[0] = "00";
        }

        for (var i : tmp) {
            sb.append(i).append(":");
        }
        return sb.substring(0, sb.length() - 3);
    }
}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}