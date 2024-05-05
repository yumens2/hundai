public class Exception {
    public static void main(String[] args) {
        //checkZero(0);
    }
    // 각 자리에 중복된 수가 있는지 확인
    public static void checkDuplicate(int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            char currentDigit = numStr.charAt(i);
            for (int j = i + 1; j < numStr.length(); j++) {
                if (currentDigit == numStr.charAt(j)) {
                    throw new IllegalArgumentException("중복된 수가 있습니다.");
                }
            }
        }
    }
    // 세 자리의 수인지 확인
    public static void checkLength(int num) {
        if (num < 100 || num > 999) {
            throw new IllegalArgumentException("세 자리 정수가 아닙니다.");
        }
    }
    // 0을 입력 받았는지 확인
    public static void checkZero(int num) {
        String numStr = String.valueOf(num);
        if (numStr.contains("0")) {
            throw new IllegalArgumentException("1~9까지의 숫자를 입력해주세요.");
        }
    }
    // 숫자가 아닌 값이 들어온 경우 ex. 문자열, 소수
}
