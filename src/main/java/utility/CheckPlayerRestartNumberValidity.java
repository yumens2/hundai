package utility;

public class CheckPlayerRestartNumberValidity {
    private CheckPlayerRestartNumberValidity(){}

    public static void playerRestartNumberValidity(String number){
        if (!CheckPlayerRestartNumberValidity.totalRestartValidity(number)) {//올바른 입력이 아니므로 IllegalArgumentException을 발생시키고 프로그램 종료
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }

    private static boolean totalRestartValidity(String number){
        if (!CheckValidity.numberValidity(number)) {//정수로 변환이 가능한가?
            return false;
        }

        if (!CheckValidity.oneTwoValidity(number)) {//1 또는 2인가?
            return false;
        }

        return true;// 1 또는 2입력이 맞음
    }

}
