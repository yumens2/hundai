package baseball.domain;


import baseball.exception.constants.ErrorMessage;
import baseball.system.constants.Rule;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 숫자야구에서 사용될 숫자 집합
 */
public class BaseballNumber {

    private final List<Integer> baseballNumbers;

    public BaseballNumber(List<Integer> baseballNumbers) {
        validateSize(baseballNumbers.size());
        validateDuplication(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(int size) {
        if (size != Rule.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_SIZE.getDescription());
        }
    }

    private void validateDuplication(List<Integer> baseballNumbers) {
        int beforeSize = baseballNumbers.size();
        int distinctSize = baseballNumbers.stream().distinct().toList().size();
        if (beforeSize != distinctSize) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_INPUT.getDescription());
        }
    }

    public List<Integer> getBaseballNumbers() {
        return Collections.unmodifiableList(baseballNumbers);
    }

    public boolean isBall(int number) {
        return baseballNumbers.contains(number);
    }

    public boolean isStrike(int number, int index) {
        return baseballNumbers.indexOf(number) == index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        baseballNumbers.forEach(sb::append);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(baseballNumbers, that.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }
}
