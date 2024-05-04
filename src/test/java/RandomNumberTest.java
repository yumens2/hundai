import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.RandomNumber;

import static org.hamcrest.MatcherAssert.assertThat;

public class RandomNumberTest {

    @Test
    @DisplayName("랜덤으로 생성되는 숫자가 3자리인지 확인")
    public void validRandomNumberDigit() {
        int size = RandomNumber.generateRandomNumbers().size();

        if (size != 3) {
            System.out.println("3자리 숫자가 생성되지 않았습니다.");
        } else {
            System.out.println("3자리 숫자가 생성되었습니다.");
        }
    }

    @Test
    @DisplayName("랜덤으로 생성되는 숫자의 각 자릿수가 1~9 사이의 숫자인지 확인")
    public void validRandomNuberValue() {
        boolean isValid = true;
        for (int number : RandomNumber.generateRandomNumbers()) {
            if (number < 1 || number > 9) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("1~9 사이의 숫자가 생성되지 않았습니다.");
        } else {
            System.out.println("1~9 사이의 숫자가 생성되었습니다.");
        }
    }

    @Test
    @DisplayName("랜덤으로 생성되는 숫자가 중복되지 않는지 확인")
    public void validRandomNumberDuplication() {
        boolean isDuplicated = false;
        for (int i = 0; i < 100; i++) {
            if (RandomNumber.generateRandomNumbers().size() != 3) {
                isDuplicated = true;
                break;
            }
        }

        if (isDuplicated) {
            System.out.println("중복된 숫자가 생성되었습니다.");
        } else {
            System.out.println("중복된 숫자가 생성되지 않았습니다.");
        }
    }
}
