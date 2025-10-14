package calculator;

import calculator.model.expression.ExpressionSumCalculatorFactory;
import calculator.presentation.CalculatorRunner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorRunner runner = new CalculatorRunner(ExpressionSumCalculatorFactory.createCalculator());
        runner.run();
    }
}
