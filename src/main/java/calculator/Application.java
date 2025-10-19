package calculator;

import calculator.model.expression.ExpressionSumCalculatorFactory;
import calculator.presentation.CalculatorRunner;

public class Application {
    public static void main(String[] args) {
        CalculatorRunner runner = new CalculatorRunner(ExpressionSumCalculatorFactory.createCalculator());
        runner.run();
    }
}
