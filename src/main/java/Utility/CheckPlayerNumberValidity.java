package Utility;

public class CheckPlayerNumberValidity {
    public static void playerNumberValidity(String number){
        if(totalValidity(number)){//올바른 입력인가?
            return;
        }else {//올바른 입력이 아니므로 IllegalArgumentException 발생 후에 프로그램 종료
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
    private static boolean totalValidity(String number){
        if(!CheckValidity.numberValidity(number)){//정수로 변환이 가능한가?
            return false;
        }
        if(!CheckValidity.digitValidity(number)){//3자리수가 맞는 가?
            return false;
        }
        if(!CheckValidity.zeroValidity(number)){//0을 포함하고 있는가?
            return false;
        }
        if(!CheckValidity.sameValidity(number)){//같은 수 즉 중복된 수가 있는가?
            return false;
        }
        return true;//plyer가 입력한 수는 올바른 입력
    }
}
