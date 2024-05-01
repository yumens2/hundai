package utils;

public class Validation {
    /**
     * 재시작 혹은 게임종료 선택 숫자 유효성 검증 메서드
     * @param input
     * @throws IllegalArgumentException
     */

    public static void isValidRestartOrGameOverNum(int input) throws IllegalArgumentException {

        if(input != 1 && input != 2){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

    }
    /**
     * 입력값 유효성 검증 메서드
     * @param input
     * @throws IllegalArgumentException
     */
    public static void isValidInputNum(String input) throws IllegalArgumentException {

        if((input.length() !=3) ||
                (input.charAt(0)==input.charAt(1) || input.charAt(0)==input.charAt(2)||input.charAt(1)==input.charAt(2))
                ||(input.contains("0"))){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        for(String num : input.split("")){
            if(!Character.isDigit(num.charAt(0))){
                throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
            }
        }

    }
}
