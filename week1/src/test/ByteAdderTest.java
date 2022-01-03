package test;

import binaryadder.ByteAdder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByteAdderTest {

    @Test
    @DisplayName("1바이트 뎃셈기 테스트")
    void byteAdderTest() {
        ByteAdder byteAdder = new ByteAdder();
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};

        boolean[] value = byteAdder.byteAdder(byteA, byteB);

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
}