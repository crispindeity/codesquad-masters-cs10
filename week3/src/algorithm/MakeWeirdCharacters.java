package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MakeWeirdCharacters {
    public String solution(String s) {

        StringBuilder answer = new StringBuilder();
        int tmp = 0;
        String[] strings = s.split("");
        for (String string : strings) {
            tmp = string.equals(" ") ? 0 : tmp + 1;
            answer.append(tmp % 2 == 0 ? string.toLowerCase() : string.toUpperCase());
        }
        return answer.toString();
    }
}

class MakeWeirdCharactersTest {

    @Test
    void makeWeirdCharactersTest() {
        String testString = "try hello world";
        MakeWeirdCharacters makeWeirdCharacters = new MakeWeirdCharacters();
        String result = makeWeirdCharacters.solution(testString);
        String testResult = "TrY HeLlO WoRlD";

        assertEquals(result, testResult);
    }

    @Test
    void makeWeirdCharactersTest2() {
        String testString = "sHow Me THe moNey";
        MakeWeirdCharacters makeWeirdCharacters = new MakeWeirdCharacters();
        String result = makeWeirdCharacters.solution(testString);
        String testResult = "ShOw Me ThE MoNeY";

        assertEquals(result, testResult);
    }

    @Test
    void makeWeirdCharactersTest3() {
        String testString = "POWER OVERWHELMING";
        MakeWeirdCharacters makeWeirdCharacters = new MakeWeirdCharacters();
        String result = makeWeirdCharacters.solution(testString);
        String testResult = "PoWeR OvErWhElMiNg";
        assertEquals(result, testResult);
    }
}