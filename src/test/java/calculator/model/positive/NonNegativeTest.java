package calculator.model.positive;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class NonNegativeTest {

    @Test
    void 음수_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> NonNegativeFactory.from("-1"));
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> NonNegativeFactory.from("a"));
    }

    @Test
    void 영_이상_입력시_정상_생성() {
        assertThatCode(() -> NonNegativeFactory.from("0")).doesNotThrowAnyException();
    }
}
