package calculator;

import java.util.List;

public class PositionSumCalculator implements SumCalculator<List<Position>,Position>{

    @Override
    public Position sum(List<Position> input) {
        Position result = Position.ZERO;
        for (Position position : input) {
            result = result.sum(position);
        }
        return result;
    }
}
