package algorithm;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DiagonalDifferenceResult {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftToRightDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            leftToRightDiagonal += arr.get(i).get(i);
        }

        int rightToLeftDiagonal = 0;
        for (int i = arr.size() - 1; i > -1; i--) {
            rightToLeftDiagonal += arr.get((arr.size() - 1) - i).get(i);
        }

        return Math.abs(leftToRightDiagonal - rightToLeftDiagonal);
    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifferenceResult.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}