package calculator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 음수_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.of(-1L));
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.of("a"));
    }

    @Test
    void 영_이상_입력시_정상_생성() {
        assertThatCode(() -> Position.of(0L)).doesNotThrowAnyException();
    }
}
