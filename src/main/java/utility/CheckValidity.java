package utility;

public class CheckValidity {//유효한 입력인지 검사하는 클래스
    private CheckValidity(){}

    public static boolean numberValidity(String number){ // 정수로 변환이 가능한지 검사하는 메소드
        try { //정수로 변환 가능

            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) { // 정수로 변환 불가능
            return false;
        }

    }
    
    public static boolean digitValidity(String number){ // 3자리수인지 확인하는 메소드
        if (number.length() != 3) {
            return false;
        }

        return true;
    }

    public static boolean zeroValidity(String number){ // 0을 포함하는지 확인하는 메소드
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) == '0') {
                return false; // 0을 포함하면 false
            }

        }

        return true; // 0이 포함되지 않음
    }
    public static boolean sameValidity(String number){ // 중복된 수를 가지고 있는지 확인하는 메소드
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int nowNumber = number.charAt(i) - '0'; // 왼쪽부터 i+1번째 의 수
            if (visited[nowNumber]) {
                return false; // visited가 true라는 것은 이미 썻던 수라는 것이므로 false 리턴
            }

            visited[nowNumber] = true;//방문 처리
        }

        return true; // 중복된 수가 아니라는 것
    }
    public static boolean oneTwoValidity(String number){ // 1또는 2인지 검사하는 메소드
        int nowNumber = Integer.parseInt(number);
        if (nowNumber == 1 || nowNumber == 2) {
            return true; // 1 또는 2면 true
        }

        return false; // 아니면 false
    }
}
