package test;

import binaryadder.FullAdder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FullAdderTest {

    @Test
    @DisplayName("전체덧셈 테스트")
    void fullAdderTest() {
        FullAdder fullAdder = new FullAdder();
        boolean[] answer;

        answer = fullAdder.fullAdder(false, false, false);
        assertFalse(answer[0]);
        assertFalse(answer[1]);

        answer = fullAdder.fullAdder(false, false, true);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = fullAdder.fullAdder(false, true, false);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = fullAdder.fullAdder(false, true, true);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = fullAdder.fullAdder(true, false, false);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = fullAdder.fullAdder(true, false, true);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = fullAdder.fullAdder(true, true, false);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = fullAdder.fullAdder(true, true, true);
        assertTrue(answer[0]);
        assertTrue(answer[1]);
    }
}