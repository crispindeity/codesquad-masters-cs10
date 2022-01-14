package findarea;

import java.util.ArrayList;
import java.util.List;

public class CalcTriangleArea implements Calculator {

    private final List<Double> xLocation = new ArrayList<>();
    private final List<Double> yLocation = new ArrayList<>();

    public CalcTriangleArea(List<String> location) {
        split(location);
        calculation();
        result(0.0);
    }

    @Override
    public void calculation() {

    }

    @Override
    public void result(double value) {
        PrintView printView = new PrintView();
        printView.printResult("삼각형의 넓이는 ", value);
    }

    @Override
    public void split(List<String> location) {
        for (String s : location) {
            double x = Double.parseDouble(s.split(",")[0]);
            double y = Double.parseDouble(s.split(",")[1]);
            xLocation.add(x);
            yLocation.add(y);
        }
    }
}
