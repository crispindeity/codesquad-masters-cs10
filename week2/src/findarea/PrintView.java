package findarea;

import java.text.DecimalFormat;

public class PrintView {

    DecimalFormat df = new DecimalFormat("0.00000");

    public void printResult(String type, double result) {
        System.out.println(type + " 넓이는 " + df.format(result));
    }

    public void printLineResult(double result) {
        System.out.println("두 점 사이 거리 " + df.format(result));
    }
}
