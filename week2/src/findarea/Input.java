package findarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private final Calc calc;

    private static final int MAX_INPUT_COUNT = 13;

    public Input(Calc calc) {
        this.calc = calc;
    }

    public void inputString() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("> 좌표를 입력하세요.");
        String input = buf.readLine();
        calc.calculation(splitInput(input));
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
        } catch (ExceededInputCountException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            inputString();
        }
        return point;
    }
}