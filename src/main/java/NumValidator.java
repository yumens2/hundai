import java.util.HashSet;

public class NumValidator {
    // 입력받은 String 길이가 3개인지 확인하는 함수
    public static boolean isCorrectLength(String input){
        return input.length() == 3;

    }

    // 입력받은 String이 1~9인지 확인하는 함수
    public static boolean isOneToNine(String input){
        for (char c : input.toCharArray()){
            if (!Character.isDigit(c) || c < '1' || c > '9' ) return false;
        }
        return true;
    }

    // 입력받은 String이 중복되지 않는 수들인지 확인하는 함수
    // Set은 중복을 허용하지 않는 자료구조이니까 사용.
    public static boolean isNotDuplicateNum(String input) {
        HashSet<Character> chars = new HashSet<>();
        for (char c: input.toCharArray()){
            // 중복검사
            if (!chars.add(c)){
                return false;
            }
        }
        return true;
    }

    // 최종적으로 사용자의 입력이 유효한 숫자인지 확인하는 함수
    public static boolean isValidInput(String input){
        return (isCorrectLength(input) && isOneToNine(input) && isNotDuplicateNum(input));
    }
}

