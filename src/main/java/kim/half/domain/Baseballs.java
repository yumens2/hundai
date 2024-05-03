package kim.half.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import kim.half.ui.OutputBuilder;

public class Baseballs {

    private static final int VALID_BASEBALLS_SIZE = 3;
    private static final int ZERO_START_INDEX = 0;
    private static final int EXIST_NUMBER = 1;

    private final List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs) {
        isValidSize(baseballs);

        this.baseballs = baseballs;
    }

    public int size() {
        return this.baseballs.size();
    }

    public Baseball get(int index) {
        return this.baseballs.get(index);
    }

    private void isValidSize(List<Baseball> baseballs) {
        if (baseballs.size() != VALID_BASEBALLS_SIZE) {
            throw new IllegalArgumentException(OutputBuilder.BASEBALLS_SIZE_EXCEPTION_MESSAGE);
        }
    }


    public int countStrike(Baseballs cmpBaseballs) {
        return (int) IntStream.range(ZERO_START_INDEX, VALID_BASEBALLS_SIZE)
            .filter(i -> baseballs.get(i).equals(cmpBaseballs.baseballs.get(i)))
            .count();
    }

    public int countBall(Baseballs cmpBaseballs) {
        return (int) IntStream.range(ZERO_START_INDEX, VALID_BASEBALLS_SIZE)
            .filter(i -> !baseballs.get(i).equals(cmpBaseballs.baseballs.get(i)) &&
                EXIST_NUMBER == cmpBaseballs.baseballs.stream()
                    .filter(baseball -> baseball.equals(this.baseballs.get(i)))
                    .count())
            .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseballs baseballs = (Baseballs) o;
        return VALID_BASEBALLS_SIZE ==
            IntStream.range(ZERO_START_INDEX, VALID_BASEBALLS_SIZE)
                .filter(i -> this.baseballs.get(i).equals(baseballs.baseballs.get(i)))
                .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballs);
    }
}