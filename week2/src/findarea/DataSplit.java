package findarea;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataSplit {

    public void splitInput(String input) {
        String pattern = "^[0-9],[0-9]";
        List<String> point;
        point = Arrays.stream(input
                        .replace("(", "")
                        .replace(")", "")
                        .split("-")
                )
                .collect(Collectors.toList());
        isValidData(pattern, point);
    }

    private void isValidData(String pattern, List<String> point) {
        for (var i : point) {
            boolean isValid = Pattern.matches(pattern, i);
            if (!isValid) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}