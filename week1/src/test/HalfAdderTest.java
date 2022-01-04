package test;

import binaryadder.Adder;
import binaryadder.LogicGate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HalfAdderTest {

    LogicGate logicGate = new LogicGate();

    @Test
    @DisplayName("반쪽덧셈 테스트")
    void halfAdderTest() {
        Adder adder = new Adder(logicGate);

        boolean[] answer = adder.halfAdder(true, true);
        assertTrue(answer[0]);
        assertFalse(answer[1]);

        answer = adder.halfAdder(true, false);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = adder.halfAdder(false, true);
        assertFalse(answer[0]);
        assertTrue(answer[1]);

        answer = adder.halfAdder(false, false);
        assertFalse(answer[0]);
        assertFalse(answer[1]);
    }
}