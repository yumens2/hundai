package kim.half.domain;

import static kim.half.ui.OutputBuilder.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE;

import java.util.Objects;

public class Baseball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int baseballNumber;

    public Baseball(int baseballNumber) {
        isValidBaseballNumber(baseballNumber);

        this.baseballNumber = baseballNumber;
    }

    public int getNumber() {
        return baseballNumber;
    }

    private void isValidBaseballNumber(int baseballNumber) {
        if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return baseballNumber == baseball.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumber);
    }
}
