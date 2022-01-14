package findarea;

import java.util.ArrayList;
import java.util.List;

public class CalcLineLength implements Calculator {

    private final List<Double> xLocation = new ArrayList<>();
    private final List<Double> yLocation = new ArrayList<>();

    public CalcLineLength(List<String> location) {
        split(location);
        calculation();
    }

    @Override
    public void calculation() {
        double value = 0;
        for (int i = 0; i < xLocation.size() - 1; i++) {
            value = Math.sqrt(Math.pow(xLocation.get(i) - xLocation.get(i + 1), 2) + Math.pow(yLocation.get(i) - yLocation.get(i + 1), 2));
        }
        printValue(value);
    }

    @Override
    public void printValue(double value) {
        System.out.println("두 점 사이 거리는 " + value);
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