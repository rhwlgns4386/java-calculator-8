package calculator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class PositiveTest {

    @Test
    void 음수_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.of(-1L));
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> Positive.of("a"));
    }

    @Test
    void 영_이상_입력시_정상_생성() {
        assertThatCode(() -> Positive.of(0L)).doesNotThrowAnyException();
    }
}
