package calculator.presentation;

import calculator.model.SumCalculator;

public class CalculatorRunner {

    private final SumCalculator<String, String> sumCalculator;

    public CalculatorRunner(SumCalculator<String, String> sumCalculator) {
        this.sumCalculator = sumCalculator;
    }

    public void run() {
        String input = InputView.readExpression();
        String result = sumCalculator.sum(input);
        OutputView.printResult(result);
    }
}
