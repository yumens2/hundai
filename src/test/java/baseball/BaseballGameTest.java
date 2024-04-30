package baseball;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test //요구사항 1. 컴퓨터는 1~9 까지의 서로 다르면서, 랜덤한 수를 3개 뽑아야 한다.
    void req1Test() {
        BaseballGame baseballGame = new BaseballGame();
        int[] randomComNumbers = baseballGame.getComputerThreeNum();

        assertEquals(3, randomComNumbers.length);
        assertTrue(IntStream.of(randomComNumbers).allMatch(num -> num > 0 && num < 10)); //컴퓨터 랜덤 수 배열의 int Stream의 모든 원소가 1~9 일때만 true
        assertEquals(3, IntStream.of(randomComNumbers).distinct().count()); //컴퓨터 랜덤 수 배열의 int Stream의 서로 다른 원소의 count의 수가 3일때 통과
    }

    @Test
    /*
    * 요구사항 2. 유저는 1~9 까지의 서로 다르면서, 랜덤한 수를 3개 입력 한다.
    * 요구사항 3. 2번에 대한 유효성 검사를 하고, 잘못된 값이 입력 되었을 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 하고, 정상적인 값일 경우 입력값을 저장한다.
    */
    void req23Test(){
        String[] normalArgs = {"123", "915"};
        String[] illegalArgs = {"111", "1837", "abc"};

        BaseballGame baseballGame = new BaseballGame();

        for(String normalArg : normalArgs){
            assertFalse(baseballGame.isIllegalArgument(normalArg));
        }

        try{
            for(String illegalArg : illegalArgs){
                assertTrue(baseballGame.isIllegalArgument(illegalArg));
            }
        } catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("요구사항 4에 대한 테스트")
    void req4Test(){
        BaseballGame baseballGame = new BaseballGame();

        Map<String, Integer> stkAndBall = new HashMap<>(); //strike와 ball count를 저장할 map
        stkAndBall.put("스트라이크", 0);
        stkAndBall.put("볼", 0);

        String[] computerThreeNumStr = {"123", "467", "345", "456"};
        String[] userInputStr = {"123", "476", "534", "987"};

        enum cases{
            ALLSTK, BALLANDSTK, ALLBALL, NOTHING
        }

        int[] computerThreeNum = new int[3];
        int[] userInput = new int[3];

        for (cases c : cases.values()) {
            baseballGame.inputToIntArr(computerThreeNum, computerThreeNumStr[c.ordinal()]);
            baseballGame.inputToIntArr(userInput, userInputStr[c.ordinal()]);
            baseballGame.countStkAndBall(stkAndBall, computerThreeNum, userInput);

            switch (c){
                case ALLSTK -> {
                    assertEquals(0, (int) stkAndBall.get("볼"));
                    assertEquals(3, (int) stkAndBall.get("스트라이크"));
                }
                case BALLANDSTK -> {
                    assertEquals(2, (int) stkAndBall.get("볼"));
                    assertEquals(1, (int) stkAndBall.get("스트라이크"));
                }
                case ALLBALL -> {
                    assertEquals(3, (int) stkAndBall.get("볼"));
                    assertEquals(0, (int) stkAndBall.get("스트라이크"));
                }
                case NOTHING -> {
                    assertEquals(0, (int) stkAndBall.get("볼"));
                    assertEquals(0, (int) stkAndBall.get("스트라이크"));
                }

            }

        }
    }

}