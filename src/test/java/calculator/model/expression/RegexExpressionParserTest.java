package calculator.model.expression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class RegexExpressionParserTest {

    @Test
    void 패턴_매칭_성공() {
        ExpressionParser parser = new RegexExpressionParser("^(?<separator>.*)split(?<context>.*)$");

        Expression expression = parser.parse("우테코split우우테코테우테코코우테코");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.customSeparator("우테코"));
        assertThat(expression.getContext()).isEqualTo("우우테코테우테코코우테코");
    }

    @Test
    void 패턴_매칭_실패() {
        ExpressionParser parser = new RegexExpressionParser("^(?<separator>.*)split(?<context>.*)$");

        Expression expression = parser.parse("abc");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.defaultSeparator());
        assertThat(expression.getContext()).isEqualTo("abc");
    }

    @Test
    void 빈_문자열_입력() {
        ExpressionParser parser = new RegexExpressionParser("^(?<separator>.*)split(?<context>.*)$");

        Expression expression = parser.parse("");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.defaultSeparator());
        assertThat(expression.getContext()).isEmpty();
    }

    @Test
    void separator만_있고_context_없음() {
        ExpressionParser parser = new RegexExpressionParser("^(?<separator>.*)split(?<context>.*)$");

        Expression expression = parser.parse("abcsplit");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.customSeparator("abc"));
        assertThat(expression.getContext()).isEmpty();
    }

    @Test
    void context만_있고_separator_없음() {
        ExpressionParser parser = new RegexExpressionParser("^(?<separator>.*)split(?<context>.*)$");

        Expression expression = parser.parse("splitabc");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.defaultSeparator());
        assertThat(expression.getContext()).isEqualTo("abc");
    }

    @Test
    void 잘못된_패턴_separator_그룹_없음() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RegexExpressionParser("^(.*)split(?<context>.*)$"))
                .withMessageContaining("separator");
    }

    @Test
    void 잘못된_패턴_context_그룹_없음() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RegexExpressionParser("^(?<separator>.*)split(.*)$"))
                .withMessageContaining("context");
    }

    @Test
    void 잘못된_패턴_그룹_개수_초과() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RegexExpressionParser("^(?<separator>.*)split(?<context>.*)(?<extra>)$"));
    }

    @Test
    void 잘못된_패턴_그룹_개수_부족() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RegexExpressionParser("^(?<separator>.*)$"));
    }
}