package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class PuppetDraw {
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> tmp = new Stack<>();

        int numberOfMissingDolls = 0;
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int boardValue = board[j][move - 1];

                if (!tmp.empty() && boardValue == tmp.peek()) {
                    tmp.pop();
                    numberOfMissingDolls += 2;
                    board[j][move - 1] = 0;
                    break;
                }

                if (boardValue != 0) {
                    tmp.push(boardValue);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        int answer = numberOfMissingDolls;
        return answer;
    }
}

class PuppetDrawTest {

    @Test
    void puppetDrawTest() {
        PuppetDraw puppetDraw = new PuppetDraw();
        int[][] testBoard = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] testMoves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = puppetDraw.solution(testBoard, testMoves);

        assertEquals(4, result);
    }

    @Test
    void puppetDrawTest2() {
        PuppetDraw puppetDraw = new PuppetDraw();

        int[][] testBoard = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] testMoves = {1, 5, 3, 5, 1, 2, 2, 1, 4};


        int result = puppetDraw.solution(testBoard, testMoves);
        assertEquals(8, result);
    }
}