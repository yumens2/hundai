package src.util;

import java.util.HashSet;
import java.util.Set;
import src.game.GameOption;

public class Validator {

    public static int validateGuessNumber(String userInput) {
        try {
            int parsedUserInput = Integer.parseInt(userInput);

            // 길이 검증
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
            }

            // 중복 숫자 검증
            boolean isDuplicated = checkDuplicatedDigits(userInput);
            if (isDuplicated) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }

            return parsedUserInput;
        } catch (NumberFormatException e) {
            // Integer.parseInt() 오류 시 발생하는 에러
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private static boolean checkDuplicatedDigits(String userInput) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            char c = userInput.charAt(i);
            set.add(c);
        }

        return set.size() < 3;  // 중복을 허용하지 않으므로 숫자가 줄어들면 중복 존재
    }

    public static GameOption validateOptionNumber(String userInput) {
        try {
            int parsedUserInput = Integer.parseInt(userInput);

            return GameOption.valueOf(parsedUserInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
