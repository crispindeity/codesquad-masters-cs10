package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalLong;

public class Bjo1009_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCount = Integer.parseInt(buf.readLine());
        OptionalLong data;

        for (int i = 0; i < testCount; i++) {
            data = Arrays.stream(buf.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .reduce(Bjo1009_2::customPow);
            long result = data.orElse(0) % 10;
            if (result == 0) {
                result = 10;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static long customPow(long a, long b) {
        long exponent = b % 4;
        if (exponent == 0) {
            exponent = 4;
        }
        return (long) Math.pow(a, exponent);
    }
}