package findarea;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataSplit {

    public void splitInput(String input) {
        List<String> point;
        point = Arrays.stream(input
                        .replace("(", "")
                        .replace(")", "")
                        .split("-")
                )
                .collect(Collectors.toList());
        isValidData(point);
    }

    private List<String> isValidData(List<String> point) {
        String pattern = "^[0-9],[0-9]";
        for (var i : point) {
            boolean isValid = Pattern.matches(pattern, i);
            if (!isValid) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return point;
    }
}