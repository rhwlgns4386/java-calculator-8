package calculator.model.nonnegative;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void NonNegative_덧셈() {
        NonNegative result = NonNegativeFactory.from("1").sum(NonNegativeFactory.from("2"));
        assertThat(result).isEqualTo(NonNegativeFactory.from("3"));
    }

    @Test
    void NonNegative_동등성() {
        assertThat(NonNegativeFactory.from("10"))
                .isEqualTo(NonNegativeFactory.from("10"));
    }

    @Test
    void 캐시_동작_확인() {
        NonNegative p1 = NonNegativeFactory.from("100");
        NonNegative p2 = NonNegativeFactory.from("100");
        assertThat(p1).isSameAs(p2);
    }
}
