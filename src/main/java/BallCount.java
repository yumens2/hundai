import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallCount {
    int Num = 3;    // 숫자 개수는 총 3개

    public boolean Count(String input, List<Integer> CNum) {
        if (!isValidInput(input)) {
            // 입력 값 형식 올바르지 않을 시 실행
            throw new IllegalArgumentException("숫자를 올바르지 않은 형식으로 입력하셨습니다.");
        }
        int strike = 0, ball = 0;
        for (int i = 0; i < Num; i++)
        {
            int n = Character.getNumericValue(input.charAt(i)); // 각 자리수 값
            if (n == CNum.get(i)) {
                strike++;
            }
            else {
                ball++;
            }
        }
        if(strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if(ball == 3) {
            System.out.println(ball + "볼");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return strike == Num;
    }

    // 입력값 올바른지 판단해주는 메서드, boolean으로 구현
    public boolean isValidInput(String input) {
        if(input.length() != Num) { // input의 길이가 일치하지 않을 시 실행
            return false;
        }
        Set<Character> dig = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || !dig.add(c)) { //숫자 형태가 아님 || 중복된 숫자
                return false;
            }
        }
        return true;
    }


}
