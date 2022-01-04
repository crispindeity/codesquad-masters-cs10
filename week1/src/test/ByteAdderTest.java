package test;

import binaryadder.Adder;
import binaryadder.LogicGate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByteAdderTest {

    LogicGate logicGate = new LogicGate();

    @Test
    @DisplayName("1바이트 뎃셈기 테스트")
    void byteAdderTest() {
        Adder adder = new Adder(logicGate);
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};

        boolean[] value = adder.byteAdder(byteA, byteB);

        assertFalse(value[0]);
        assertFalse(value[1]);
        assertFalse(value[2]);
        assertTrue(value[3]);
        assertFalse(value[4]);
        assertTrue(value[5]);
        assertFalse(value[6]);
        assertFalse(value[7]);
        assertTrue(value[8]);
    }

    @Test
    @DisplayName("1바이트 뎃셈기 테스트2")
    void byteAdderTest2() {
        Adder adder = new Adder(logicGate);
        boolean[] byteA = {true, true, false, false, true, false, true, false};
        boolean[] byteB = {true, true, false, true, true, false, false, true};

        boolean[] value = adder.byteAdder(byteA, byteB);

        assertFalse(value[0]);
        assertTrue(value[1]);
        assertTrue(value[2]);
        assertTrue(value[3]);
        assertFalse(value[4]);
        assertTrue(value[5]);
        assertTrue(value[6]);
        assertTrue(value[7]);
        assertFalse(value[8]);
    }
}