package cs06;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;

@Builder
public class Number {

    private final int firstNumber;
    private final int lastNumber;
    private final List<Integer> numbers = new ArrayList<>();

    public Number(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        addNumber();
    }

    private void addNumber() {
        for (int i = firstNumber; i <= lastNumber; i++) {
            numbers.add(i);
        }
    }

    public List<String> numberClassification() {
        ClassifierAlpha classifierAlpha = new ClassifierAlpha(numbers);
        return classifierAlpha.classifier();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
