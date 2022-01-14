package findarea;

import java.text.DecimalFormat;

public class PrintView {

    DecimalFormat df = new DecimalFormat("0.00000");

    public void printResult(String outputText, double result) {
        System.out.println(outputText + df.format(result));
    }
}