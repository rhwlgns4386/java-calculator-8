package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PositionSumCalculatorTest {

    @Test
    void Position_리스트_합계_계산() {
        PositionSumCalculator positionSumCalculator = new PositionSumCalculator();
        List<Position> positions = List.of(Position.of(1L), Position.of(2L));

        Position result = positionSumCalculator.sum(positions);

        assertThat(result).isEqualTo(Position.of(3L));
    }
}
