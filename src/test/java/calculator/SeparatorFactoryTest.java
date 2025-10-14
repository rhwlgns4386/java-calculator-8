package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SeparatorFactoryTest {

    @Test
    public void 기본구분자_추출() {
        SeparatorFactory separatorFactory = new SeparatorFactory();
        String input = "";

        Separator separator = separatorFactory.extract(input);

        assertThat(separator).isEqualTo(new Separator(",", ":"));
    }

    @Test
    public void 커스텀구분자_추출() {
        SeparatorFactory separatorFactory = new SeparatorFactory();
        String input = "//우테코 화이팅\n";

        Separator separator = separatorFactory.extract(input);

        assertThat(separator).isEqualTo(new Separator("우테코 화이팅"));
    }
}
