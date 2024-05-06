package global.validator;

public class Validator {

    /**
     * 옳바른 입력인지 확인
     *
     * @param gamePackListSize,input
     * @return void
     */
    public static void validGamePackInput(int gamePackListSize, String input) {
        validGamePackDigit(input);
        validGamePackSize(gamePackListSize, input);
    }


    /**
     * 게임팩 선택이 옳바르지 아닐 경우
     *
     * @param gamePackListSize, input
     * @return void
     */
    public static void validGamePackSize(int gamePackListSize, String input) {
        if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > gamePackListSize) {
            throw new IllegalArgumentException("옳바른 게임팩을 선택해주세요.");
        }
    }

    /**
     * 게임팩 선택이 숫자가 아닐경우
     *
     * @param input
     * @return void
     */
    public static void validGamePackDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }


}
