package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.stream(
                            Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]))
                    .sorted()
                    .toArray();
            answer[i] = tmp[commands[i][2] - 1];
        }
        return answer;
    }
}

class KNumberTest {

    @Test
    void kNumberTest() {
        KNumber kNumber = new KNumber();
        int[] testArr = {1, 5, 2, 6, 3, 7, 4};
        int[][] testCommands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        int[] testResult = {5, 6, 3};
        int[] result = kNumber.solution(testArr, testCommands);

        Assertions.assertArrayEquals(result, testResult);
    }
}