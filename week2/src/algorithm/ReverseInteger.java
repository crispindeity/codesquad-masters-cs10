package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseInteger {

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int tmp = x % 10;
            x /= 10;
            result = result * 10 + tmp;
        }
        if (result >= -Integer.MAX_VALUE && result <= Integer.MAX_VALUE) {
            return (int) result;
        }
        return 0;
    }
}

class ReverseIntegerTest {

    @Test
    void reverseIntegerTest() {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(1534236469);

        assertEquals(result, 0);
    }
}
