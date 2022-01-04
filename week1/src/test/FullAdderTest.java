package test;

import binaryadder.Adder;
import binaryadder.LogicGate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FullAdderTest {

    LogicGate logicGate = new LogicGate();

    @Test
    @DisplayName("전체덧셈 테스트")
    void fullAdderTest() {
        Adder adder = new Adder(logicGate);
        boolean[] answer;

        answer = adder.fullAdder(false, false, false);
        assertFalse(answer[0]);
        assertFalse(answer[1]);

        answer = adder.fullAdder(false, false, true);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = adder.fullAdder(false, true, false);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = adder.fullAdder(false, true, true);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = adder.fullAdder(true, false, false);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = adder.fullAdder(true, false, true);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = adder.fullAdder(true, true, false);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = adder.fullAdder(true, true, true);
        assertTrue(answer[0]);
        assertTrue(answer[1]);
    }
}