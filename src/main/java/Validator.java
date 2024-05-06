public class Validator {

    private Validator() {}

    public static void validateGuess(int num) {
        if (num <= 100 || num >= 1000) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        } else if (num/100 == (num%100)/10 || num/100 == num%10 || (num%100)/10 == num%10) {
            throw new IllegalArgumentException("서로 다른 세 숫자를 입력해야 합니다.");
        } else if ((num%100)/10 == 0 || num%10 == 0) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.");
        }
    }

    public static void validateReGame(int num) {
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}
