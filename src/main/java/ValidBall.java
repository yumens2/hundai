import java.util.HashSet;

public class ValidBall {

    public void validate(int answer) {
        validateInputType(answer);
        validateRange(answer);
        validateDuplication(answer);
    }

    // 아래 validateInputTpye 메서드가 의미가 있을까? MajorLeague에서 결국 인풋 받을 때 Integer.parseInt로 파싱하는데 문자열이 입력되면
    //결국 거기서 에러가 발생할텐데, 그럼 이건 테스트에 넣자
    private <T> void validateInputType(T answer) {
        if (!(answer instanceof Integer)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 시도하세요.");
        }
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
