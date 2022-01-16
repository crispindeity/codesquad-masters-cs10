package algorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int testSaveX = x;
        int result = 0;
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            int tmp = x % 10;
            x /= 10;
            result = result * 10 + tmp;
        }
        return result == testSaveX;
    }
}

class IsPalindromeTest {

    @Test
    void isPalindromeTest() {
        IsPalindrome isPalindrome = new IsPalindrome();

        boolean result = isPalindrome.isPalindrome(-121);

        assertTrue(result);
    }
}
