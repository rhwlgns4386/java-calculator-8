package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import calculator.model.nonnegative.NonNegative;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

class BigIntegerConverterTest {

    @Test
    void 다중_String_다중_BigInteger_변화() {
        List<String> inputs = List.of("-1","0","1");

        List<BigInteger> result = BigIntegerConverter.toBigIntegers(inputs);

        assertThat(result).containsExactlyInAnyOrder(new BigInteger("-1"), new BigInteger("0"), new BigInteger("1"));
    }

    @Test
    void String_BigInteger_변환() {
        String input = "-1";

        BigInteger result = BigIntegerConverter.toBigInteger(input);

        assertThat(result).isEqualTo(new  BigInteger("-1"));
    }

    @Test
    void 숫자가_아닌_값_입력시_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() ->  BigIntegerConverter.toBigInteger("a"));
    }
}