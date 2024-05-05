package baseball.utils;

import baseball.system.constants.Rule;
import baseball.validator.RandomNumberValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 난수 생성기
 */
public final class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    /**
     * 인자로 전달받은 자릿수 만큼의 난수를 생성합니다. (단, 생성된 숫자 내부에서 같은 숫자는 존재하지 않습니다.)
     *
     * @param length 난수의 길이
     * @return 같은 숫자가 없는 난수
     */
    public static List<Integer> getNonDuplicateNumbers(int length) {
        RandomNumberValidator.validateDistinctNumberSize(length);

        Random random = new Random();
        List<Integer> generatedNumbers = new ArrayList<>();

        while (isNotEnough(length, generatedNumbers)) {
            int randomNumber = random.nextInt(Rule.MAXIMUM_NUMBER) + Rule.MINIMUM_NUMBER;
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }

        return generatedNumbers;
    }

    private static boolean isNotEnough(int length, List<Integer> numbers) {
        return numbers.size() != length;
    }
}
