import java.util.HashSet;

public class ValidBall implements Valid {
    public ValidBall() {
        super();
    }

    @Override
    public void valid(int number) {

        HashSet<Integer> set = new HashSet<>();

        if ((number < 111) || (number > 999)) {
            throw new IllegalArgumentException("잘못된 범위의 입력입니다");
        }

        while (number > 0) {
            int digit = number % 10;
            if (!set.add(digit)) {
                throw new IllegalArgumentException("입력된 숫자 중 중복되는 숫자가 있습니다.");
            }
            number /= 10;
        }



    }
}
