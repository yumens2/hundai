package Utility;

public class CheckValidity {
    private CheckValidity(){}
    public static void playerNumbervalidity(String number)throws IllegalArgumentException{
        if(totalValidity(number)){
            return;
        }else {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
    public static void playerRestartNumbervalidity(String number)throws IllegalArgumentException{
        if(totalRestartValidity(number)){
            return;
        }else {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
    private static boolean totalRestartValidity(String number){//서로다른 3자리 수를 검사하는 메소드
        if(!numberValidity(number)){
            return false;
        }
        if(!oneTwoValidity(number)){
            return false;
        }
        return true;
    }
    private static boolean totalValidity(String number){//서로다른 3자리 수를 검사하는 메소드
        if(!numberValidity(number)){
            return false;
        }
        if(!digitValidity(number)){
            return false;
        }
        if(!zeroValidity(number)){
            return false;
        }
        if(!sameValidity(number)){
            return false;
        }
        return true;
    }
    private static boolean numberValidity(String number){//숫자로 변환이 가능한지 검사하는 메소드
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean digitValidity(String number){//3자리수인지 확인하는 메소드
        if(number.length() != 3) return false;
        return true;
    }
    private static boolean zeroValidity(String number){//0을 포함하는지 확인하는 메소드
        for(int i = 0; i < 3; i++){
            if(number.charAt(i) == '0') return false;
        }
        return true;
    }
    private static boolean sameValidity(String number){//중복된 수를 가지고 있는지 확인하는 메소드
        boolean[] visited = new boolean[10];
        for(int i = 0; i < 3; i++){
            int nowNumber = number.charAt(i) - '0';
            if(visited[nowNumber]) return false;
            visited[nowNumber] = true;
        }
        return true;
    }
    private static boolean oneTwoValidity(String number){
        int nowNumber = Integer.parseInt(number);
        if(nowNumber == 1 || nowNumber == 2) return true;
        return false;
    }
}
