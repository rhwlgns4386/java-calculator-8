package calculator;

public interface InputParser {

    Separator extractSeparator(String input);
    String extractContent(String input);
}
