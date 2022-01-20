package cs06;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Number number = Number.builder()
                .firstNumber(2)
                .lastNumber(100)
                .build();

        List<String> result = number.numberClassification();
        Print print = new Print();
        print.printValue(result);
    }
}