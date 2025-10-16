package calculator.model.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionTest {

    @Test
    void Expression_생성() {
        Expression expression = new Expression("separator", "context");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.customSeparator("separator"));
        assertThat(expression.getContext()).isEqualTo("context");
    }

    @Test
    void Expression_동등성() {
        Expression expr1 = new Expression("sep", "ctx");
        Expression expr2 = new Expression("sep", "ctx");
        Expression expr3 = new Expression("different", "ctx");

        assertThat(expr1).isEqualTo(expr2);
        assertThat(expr1).isNotEqualTo(expr3);
        assertThat(expr1.hashCode()).isEqualTo(expr2.hashCode());
    }

    @Test
    void 빈_문자열로_Expression_생성() {
        Expression expression = new Expression("", "");

        assertThat(expression.getSeparator()).isEqualTo(SeparatorFactory.defaultSeparator());
        assertThat(expression.getContext()).isEmpty();
    }
}