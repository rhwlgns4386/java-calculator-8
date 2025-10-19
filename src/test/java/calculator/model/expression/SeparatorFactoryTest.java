package calculator.model.expression;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SeparatorFactoryTest {

    @Test
    void 커스텀_구분자_생성() {
        Separator separator = SeparatorFactory.customSeparator("a");

        assertThat(separator).isEqualTo(new Separator(",", ":","a"));
    }

    @Test
    void 기본_구분자_생성() {
        Separator separator = SeparatorFactory.defaultSeparator();

        assertThat(separator).isEqualTo(new Separator(",", ":"));
    }
}