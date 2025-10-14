package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ExpressionSumCalculator calculator = ExpressionSumCalculatorFactory.createCalculator();
        calculator.sum(Console.readLine());
    }
}
