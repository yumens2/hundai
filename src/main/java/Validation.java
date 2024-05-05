import java.util.HashSet;
import java.util.stream.Collectors;

public class Validation {

    /**
     * 사용자가 입력한 수가 유효한지 판별하는 함수이다.
     * 유효하지 않다면 IllegalArgumentException이 발생한다.
     *
     * @param input - 사용자가 입력한 수
     * @return 유효하면 true, 유효하지 않으면 false
     */
    public static boolean isValidNum(String input) {
        try {
            // set으로 중복 값 제거
            HashSet<Character> set = input.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toCollection(HashSet::new));

            // 3개의 수가 아니거나 0이 있으면 IllegalArgumentException 발생
            if (set.size() != 3 || set.contains('0')) {
                throw new IllegalArgumentException();
            }

            // 문자가 포함되어 있으면 IllegalArgumentException 발생
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 수를 입력하였습니다.");

            return false;
        }

        return true;
    }

    /**
     * 종료 옵션의 입력 값이 유효한지 판별하는 함수이다.
     * 유효하지 않다면 IllegalArgumentException이 발생한다.
     *
     * @param input - 사용자가 입력한 값
     * @return 유효하면 true, 유효하지 않으면 false
     */
    public static boolean isValidEnd(String input) {
        try {
            // 문자가 포함되어 있으면 IllegalArgumentException 발생
            int temp = Integer.parseInt(input);

            // 옵션 이외의 값이면 IllegalArgumentException 발생
            if (temp != 1 && temp != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다.");

            return false;
        }

        return true;
    }
}
