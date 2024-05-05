import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallCount {
    int Num = 3;

    public boolean Count(String input, List<Integer> CNum) {
        if (!isValidInput(input)) {
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

    public boolean isValidInput(String input) {
        if(input.length() != Num) {
            return false;
        }
        Set<Character> dig = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || !dig.add(c)) {
                return false;
            }
        }
        return true;
    }


}
