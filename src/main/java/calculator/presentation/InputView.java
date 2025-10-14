package calculator.presentation;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PRINT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private InputView() {
    }

    public static String readExpression() {
        System.out.println(PRINT_MESSAGE);
        return Console.readLine();
    }
}
