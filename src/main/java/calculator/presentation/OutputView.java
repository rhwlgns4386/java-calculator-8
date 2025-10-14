package calculator.presentation;

public class OutputView {

    public static final String OUTPUT_MESSAGE_PREFIX = "결과 : ";

    private OutputView() {
    }

    public static void printResult(String result) {
        System.out.println(OUTPUT_MESSAGE_PREFIX + result);
    }
}
