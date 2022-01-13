package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import findarea.Calc;
import findarea.ExceededInputCountException;
import findarea.Input;
import findarea.Print;

class CalcTest {

    Print print = new Print();
    Calc calc = new Calc(print);
    Input input = new Input(calc);

    @Test
    @DisplayName("직선길이구하기 테스트")
    void lengthCalculationTest() throws IOException {
        String testValue = "(10,10)-(14,15)-(10,10)-(12,13)-(20,21)-(5,3)-(4,11)-(2,5)";
        List<Double> value = calc.lengthCalculation(input.splitInput(testValue));
        assertTrue(Math.abs((value.get(0)) - 6.40312423) < 0.0005);
        assertTrue(Math.abs((value.get(1)) - 3.60555127) < 0.0005);
        assertTrue(Math.abs((value.get(2)) - 23.4307490) < 0.0005);
        assertTrue(Math.abs((value.get(3)) - 6.32455532) < 0.0005);
    }

    @Test
    @DisplayName("입력값 초과 예외처리 테스트")
    void exceededInputCountExceptionTest() {
        String testValue = "(10,10)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)-(14,15)";
        Assertions.assertThrows(ExceededInputCountException.class,
                () -> calc.lengthCalculation(input.splitInput(testValue)));
    }
}