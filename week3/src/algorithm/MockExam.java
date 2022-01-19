package algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
    public int[] solution(int[] answers) {

        int[] studentA = {1, 2, 3, 4, 5};
        int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] studentSolveCount = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (studentA[i % studentA.length] == answers[i]) {
                studentSolveCount[0]++;
            }
            if (studentB[i % studentB.length] == answers[i]) {
                studentSolveCount[1]++;
            }
            if (studentC[i % studentC.length] == answers[i]) {
                studentSolveCount[2]++;
            }
        }
        List<Integer> tmp = new ArrayList<>();
        int max = Arrays.stream(studentSolveCount).max().orElse(0);

        for (int i = 0; i < studentSolveCount.length; i++) {
            if (studentSolveCount[i] == max) {
                tmp.add(i + 1);
            }
        }

        int[] answer = new int[tmp.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}

class MockExamTest {

    @Test
    void mockExamTest() {
        MockExam mockExam = new MockExam();
        int[] answers = {1, 2, 3, 4, 5};
        int[] highScorePerson = {1};
        int[] result = mockExam.solution(answers);

        assertArrayEquals(highScorePerson, result);
    }

    @Test
    void mockExamTest2() {
        MockExam mockExam = new MockExam();
        int[] answers = {1, 3, 2, 4, 2};
        int[] highScorePerson = {1, 2, 3};
        int[] result = mockExam.solution(answers);

        assertArrayEquals(highScorePerson, result);
    }
}
