package test;

import convertor.Convertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorTest {

    @Test
    @DisplayName("10진수에서 2진수 변환테스트")
    void dec2binTest() {
        Convertor convertor = new Convertor();
        boolean[] answer = convertor.dec2bin(10);
        boolean[] value = {false, true, false, true};

        assertArrayEquals(answer, value);

        boolean[] answer2 = convertor.dec2bin(173);
        boolean[] value2 = {true, false, true, true, false, true, false, true};

        assertArrayEquals(answer, value);
        assertArrayEquals(answer2, value2);
    }

    @Test
    @DisplayName("2진수에서 10진수 변환테스트")
    void bin2decTest() {
        Convertor convertor = new Convertor();
        boolean[] value = {false, true ,true, true};
        boolean[] value2 = {true, true ,true, true, false, true, false, true};

        int answer = convertor.bin2dec(value);
        int answer2 = convertor.bin2dec(value2);

        assertEquals(answer, 14);
        assertEquals(answer2, 175);
    }
}