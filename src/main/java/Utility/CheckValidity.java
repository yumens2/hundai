package Utility;

public class CheckValidity {
    private CheckValidity(){}
    public boolean totalValidity(String number){//서로다른 3자리 수를 검사하는 메소드
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
    public boolean numberValidity(String number){//숫자로 변환이 가능한지 검사하는 메소드
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean digitValidity(String number){//3자리수인지 확인하는 메소드
        if(number.length() != 3) return false;
        return true;
    }
    public boolean zeroValidity(String number){//0을 포함하는지 확인하는 메소드
        for(int i = 0; i < 3; i++){
            if(number.charAt(i) == '0') return false;
        }
        return true;
    }
    public boolean sameValidity(String number){//중복된 수를 가지고 있는지 확인하는 메소드
        boolean[] visited = new boolean[10];
        for(int i = 0; i < 3; i++){
            int nowNumber = number.charAt(i) - '0';
            if(visited[nowNumber]) return false;
            visited[nowNumber] = true;
        }
        return true;
    }
}
