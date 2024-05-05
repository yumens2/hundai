package start;

public class ExceptOccurCheck {
    public static void checkInputValidation(String usrInput) {
        if(usrInput.length() != 3) {
            throw new IllegalArgumentException("숫자가 3개가 아닙니다.");
        }
        if(!usrInput.matches("[1-9]+")) {
            throw new IllegalArgumentException("1~9사이의 숫자만 입력하세요.");
        }
        else {
            // 1~9사이에 숫자이면 중복을 체크 한다.
            if(usrInput.charAt(0) == usrInput.charAt(1) || usrInput.charAt(0) == usrInput.charAt(2) || usrInput.charAt(1) == usrInput.charAt(2)) {
                throw new IllegalArgumentException("숫자의 중복이 발생되었습니다.");
            }
        }
    }

    public static void checkInputValidation(int usrInput) {
        if(usrInput < 1 || usrInput > 2)
            throw new IllegalArgumentException("1 또는 2만 입력하세요.");
    }
}
