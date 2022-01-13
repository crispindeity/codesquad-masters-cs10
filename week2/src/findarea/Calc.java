package findarea;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    private final Print print;

    public Calc(Print print) {
        this.print = print;
    }

    public void calculation(List<String> point) {
        print.printValue(lengthCalculation(point));
    }

    public List<Double> lengthCalculation(List<String> point) {
        List<Double> values = new ArrayList<>();
        for (int i = 0; i < point.size(); i += 2) {
            double xCoordinate = Double.parseDouble(point.get(i).split(",")[0]) - Double.parseDouble(point.get(i + 1).split(",")[0]);
            double yCoordinate = Double.parseDouble(point.get(i).split(",")[1]) - Double.parseDouble(point.get(i + 1).split(",")[1]);
            values.add(Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2)));
        }
        return values;
    }
}