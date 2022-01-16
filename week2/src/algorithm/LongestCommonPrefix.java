package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        Arrays.sort(strs, (s1, s2) -> {
            return Integer.compare(s1.length(), s2.length());
        });
        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) return "";
            }
        }
        return result;
    }
}

class LongestCommonPrefixTest {
    @Test
    void longestCommonPrefixTest() {
        String[] testValue = {"flower", "flow", "flight"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String result = longestCommonPrefix.longestCommonPrefix(testValue);

        assertEquals(result, "fl");
    }
}