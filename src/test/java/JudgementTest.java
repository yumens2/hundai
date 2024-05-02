import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {

    @Test
    @DisplayName("컴퓨터와 플레이어의 숫자 리스트 비교 - 일치하는 숫자가 없는 경우")
    void matchNumber_noMatch() {
        //given
        Judgement judgement = new Judgement();
        List<Integer> computer = Arrays.asList(1,2,3);
        List<Integer> player = Arrays.asList(5,6,7);

        //when
        int result = judgement.matchNumber(computer, player);

        //then
        assertEquals(0,result);
    }

    @Test
    @DisplayName("컴퓨터와 플레이어의 숫자 리스트 비교 - 일치하는 숫자 2개인 경우")
    void matchNumber_twoMatch() {
        //given
        Judgement judgement = new Judgement();
        List<Integer> computer = Arrays.asList(1,2,3);
        List<Integer> player = Arrays.asList(2,3,7);

        //when
        int result = judgement.matchNumber(computer, player);

        //then
        assertEquals(2,result);
    }

    @Test
    @DisplayName("placeCheck 정상 작동 테스트")
    void placeCheck() {
        //given
        Judgement judgement = new Judgement();
        List<Integer> computer = Arrays.asList(1,2,3);
        int number = 2;
        int placenumber = 1;
        
        //when
        boolean result = judgement.placeCheck(computer, placenumber, number);
        System.out.println(result);
        //then
        assertTrue(result);
    }
}