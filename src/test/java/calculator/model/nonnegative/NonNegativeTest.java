package calculator.model.nonnegative;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class NonNegativeTest {

    @Test
    void 음수_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() ->  NonNegative.from(new BigInteger("-1")));
    }

    @Test
    void 영_이상_입력시_정상_생성() {
        assertThatCode(() ->  NonNegative.from(new BigInteger("0"))).doesNotThrowAnyException();
    }

    @Test
    void NonNegative_덧셈() {
        NonNegative result = NonNegative.from(new BigInteger("1")).sum( NonNegative.from(new BigInteger("2")));
        assertThat(result).isEqualTo( NonNegative.from(new BigInteger("3")));
    }

    @Test
    void NonNegative_동등성() {
        assertThat( NonNegative.from(new BigInteger("10")))
                .isEqualTo( NonNegative.from(new BigInteger("10")));
    }

    @Test
    void 캐시_동작_확인() {
        NonNegative p1 =  NonNegative.from(new BigInteger("100"));
        NonNegative p2 =  NonNegative.from(new BigInteger("100"));
        assertThat(p1).isSameAs(p2);
    }
}
