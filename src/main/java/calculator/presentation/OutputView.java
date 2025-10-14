package calculator.presentation;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(String result) {
        System.out.printf("결과 : %s\n", result);
    }
}
