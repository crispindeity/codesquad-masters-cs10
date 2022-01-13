package findarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final int MAX_INPUT_COUNT = 13;

    public void inputString() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("> 좌표를 입력하세요.");
        String input = buf.readLine();
        CalcLineLength calcLineLength = new CalcLineLength(splitInput(input));
        calcLineLength.calculation();
    }

    public List<String> splitInput(String input) throws IOException {
        List<String> point;
        point = Arrays.stream(input
                        .replace("(", "")
                        .replace(")", "")
                        .split("-")
                )
                .collect(Collectors.toList());
        return checkedInputCount(point);
    }

    private List<String> checkedInputCount(List<String> point) throws IOException {
        try {
            if (point.size() > MAX_INPUT_COUNT) {
                throw new ExceededInputCountException("입력개수를 초과했습니다.");
            }
            return point;
        } catch (ExceededInputCountException e) {
            inputString();
            return new ArrayList<>();
        }
    }
}