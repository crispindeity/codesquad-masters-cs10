package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class Bjo1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCount = Integer.parseInt(buf.readLine());
        OptionalInt result;

        for (int i = 0; i < testCount; i++) {
            result = Arrays.stream(buf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .reduce(Bjo1009::solve);
            if (result.orElse(0) % 10 == 0) {
                result = OptionalInt.of(10);
            }
            sb.append(result.orElse(0)).append("\n");
        }
        System.out.println(sb);
    }

    public static int solve(int a, int b) {
        int result = 1;
        for (int i = 0; i < b % 4; i++) {
            result = (result * a) % 10;
        }
        return result;
    }
}