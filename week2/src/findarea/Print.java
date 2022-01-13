package findarea;

import java.text.DecimalFormat;
import java.util.List;

public class Print {

    public void printValue(List<Double> value) {
        for (var i : value) {
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.println("두 점 사이 거리는 " + df.format(i));
        }
    }
}