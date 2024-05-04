import java.util.HashSet;
import java.util.Set;

public class Util {
//    입력된 text가 숫자인지 검사
//    입력은 한자리 숫자
//    숫자가 아니면 IllegalArgumentException 반환

    /**
     * @return 정수로 변환된 숫자
     * @throws IllegalArgumentException
     * @prama num 입력된 문자열이 숫자인지 검사
     */
    public int isNum(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return String[]
     * @throws IllegalArgumentException
     * @prama 입력의 길이가 3인지 검사
     */
    public boolean isOver(String[] arr){
        if(arr.length!=3){
            throw new IllegalArgumentException();
        }
        return true;
    }

    /**
     * @return 숫자 중복 여부
     * @throws IllegalArgumentException
     * @prama num 입력된 문자열들이 중복되는지 검사
     */
    public boolean isDuplicate(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            if (!set.add(num)) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }

//    볼 카운드 출력
    public void printCount(int strike, int ball){
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if (strike != 0 && ball == 0){
            System.out.println(strike + "스트라이크");
        }else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }
}
