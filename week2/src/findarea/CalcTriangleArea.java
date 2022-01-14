package findarea;

import java.util.List;

public class CalcTriangleArea implements Calculator {

    public CalcTriangleArea(List<String> location) {
        split(location);
        calculation();
    }

    @Override
    public void calculation() {

    }

    @Override
    public void result(double value) {
        PrintView printView = new PrintView();
        printView.printResult("삼각형", value);
    }

    @Override
    public void split(List<String> location) {

    }
}
