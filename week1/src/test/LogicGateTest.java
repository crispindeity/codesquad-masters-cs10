package test;

import binaryadder.LogicGate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicGateTest {

    @Test
    @DisplayName("andGate테스트")
    void andGateTest() {
        LogicGate logicGate = new LogicGate();

        assertFalse(logicGate.andGate(false, false));
        assertFalse(logicGate.andGate(false, true));
        assertFalse(logicGate.andGate(true, false));
        assertTrue(logicGate.andGate(true, true));
    }

    @Test
    @DisplayName("orGate테스트")
    void orGateTest() {
        LogicGate logicGate = new LogicGate();

        assertFalse(logicGate.orGate(false, false));
        assertTrue(logicGate.orGate(false, true));
        assertTrue(logicGate.orGate(true, false));
        assertTrue(logicGate.orGate(true, true));
    }

    @Test
    @DisplayName("nandGate테스트")
    void nandGateTest() {
        LogicGate logicGate = new LogicGate();

        assertTrue(logicGate.nandGate(false, false));
        assertTrue(logicGate.nandGate(false, true));
        assertTrue(logicGate.nandGate(true, false));
        assertFalse(logicGate.nandGate(true, true));
    }

    @Test
    @DisplayName("xorGate테스트")
    void xorGateTest() {
        LogicGate logicGate = new LogicGate();

        assertTrue(logicGate.xorGate(false, false));
        assertFalse(logicGate.xorGate(false, true));
        assertFalse(logicGate.xorGate(true, false));
        assertTrue(logicGate.xorGate(true, true));
    }
}