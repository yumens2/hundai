import java.util.HashSet;

public class ValidBall {

    public void validate(int answer) {
        validateRange(answer);
        validateDuplication(answer);
    }

    private void validateDuplication(int answer) {
        HashSet<Integer> set = new HashSet<>();
        while (answer > 0) {
            int digit = answer % 10;
            if (!set.add(digit)) {
                throw new IllegalArgumentException("입력된 숫자 중 중복되는 숫자가 있습니다.");
            }
            answer /= 10;
        }
    }

    private void validateRange(int number) {
        if ((number < 111) || (number > 999)) {
            throw new IllegalArgumentException("잘못된 범위의 입력입니다");
        }
    }
}
