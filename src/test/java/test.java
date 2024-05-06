import domain.Computer;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Utils;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class test {

    @Test
    @DisplayName("컴퓨터가 랜덤으로 겹치지 않는 3개의 숫자를 뽑아 순서대로 배열에 저장")
    void compRandNumArrayTest(){
        ArrayList<Integer> numArray = Computer.makeRandNumArray();
        for (Integer integer : numArray) {
            System.out.print(integer);
        }
    }

    @Test
    @DisplayName("플레이어가 겹치지 않는 3개의 숫자를 입력해 순서대로 배열에 저장")
    void userInputNumArrayTest() {
        Scanner scanner = new Scanner(System.in);
//        String nStr = scanner.next(); // 3자리 숫자 입력
        String nStr = "243";

        char[] charArray = nStr.toCharArray();
        ArrayList<Integer> userNumArray = new ArrayList<>();

        for (char c : charArray) {
            if(Utils.checkDuplicate(charArray, c)){ // 중복인 경우 에러 발생시킴
                throw new IllegalArgumentException();
            }
            else{
                userNumArray.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        for (Integer integer : userNumArray) {
            System.out.print(integer);
        }
    }
    @Test
    @DisplayName("플레이어가 입력한 숫자(현 배열)에서 중복된 문자가 있는지 판별")
    void checkDuplicateTest() {
        boolean b1 = Utils.checkDuplicate(new char[]{'1', '3', '4'}, '1');
        assertThat(b1).isEqualTo(false);
        boolean b2 = Utils.checkDuplicate(new char[]{'1', '3', '3'}, '3');
        assertThat(b2).isEqualTo(true);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자에 대한 결과 판별")
    void showResult() {
        ArrayList<Integer> userNumArray = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> randNumArray = new ArrayList<>(List.of(2, 1, 3));

        // 1. 스트라이크 개수 정상 확인
        int strikeNum = Utils.countStrike(userNumArray, randNumArray);
        assertThat(strikeNum).isEqualTo(1);
        // 2. 볼 개수 정상 확인
        int ballNum = Utils.countBall(userNumArray, randNumArray);
        assertThat(ballNum).isEqualTo(2) ;
    }

}
