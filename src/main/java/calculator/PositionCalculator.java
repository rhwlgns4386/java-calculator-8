package calculator;

import java.util.List;

public class PositionCalculator implements SumCalculator<List<Position>,Position>{

    @Override
    public Position sum(List<Position> input) {
        Long sum = 0L;
        for (Position position : input) {
            sum += position.toLong();
        }
        return Position.of(sum);
    }
}
