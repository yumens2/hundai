package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    private BaseballGame baseballGame = new BaseballGame();


    @Test
    @DisplayName("요구사항 1에 대한 테스트")
    void req1Test() {
        int[] randomComNumbers = baseballGame.getComputerThreeNum();

        assertThat(randomComNumbers).hasSize(3);
        assertThat(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}).contains(randomComNumbers);
        assertThat(IntStream.of(randomComNumbers).distinct().count()).isEqualTo(3);
        //컴퓨터 랜덤 수 배열의 int Stream의 서로 다른 원소의 count의 수가 3일때 통과
    }

    @Test
    @DisplayName("요구사항 2, 3에 대한 테스트")
    void req23Test(){
        String[] normalArgs = {"123", "915"};
        String[] illegalArgs = {"111", "1837", "abc"};

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
    @DisplayName("요구사항 4, 5, 6에 대한 테스트")
    void req456Test(){

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

            // 참고 : https://velog.io/@rudnf003/Java-콘솔창-출력-테스트하기

            ByteArrayOutputStream outputMsg = new ByteArrayOutputStream(); // OutputStream 생성
            System.setOut(new PrintStream(outputMsg)); // 생성한 OutputStream 으로 설정

            baseballGame.inputToIntArr(computerThreeNum, computerThreeNumStr[c.ordinal()]);
            baseballGame.inputToIntArr(userInput, userInputStr[c.ordinal()]);
            baseballGame.countStkAndBall(stkAndBall, computerThreeNum, userInput);

            switch (c){

                case ALLSTK -> {
                    assertThat((int) stkAndBall.get("볼")).isEqualTo(0);
                    assertThat((int) stkAndBall.get("스트라이크")).isEqualTo(3);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    assertThat(outputMsg.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }

                case BALLANDSTK -> {
                    assertThat((int) stkAndBall.get("볼")).isEqualTo(2);
                    assertThat((int) stkAndBall.get("스트라이크")).isEqualTo(1);
                    baseballGame.printSBmap(stkAndBall);
                    assertThat(outputMsg.toString().trim()).isEqualTo("2볼 1스트라이크");
                }

                case ALLBALL -> {
                    assertThat((int) stkAndBall.get("볼")).isEqualTo(3);
                    assertThat((int) stkAndBall.get("스트라이크")).isEqualTo(0);
                    baseballGame.printSBmap(stkAndBall);
                    assertThat(outputMsg.toString().trim()).isEqualTo("3볼");
                }

                case NOTHING -> {
                    assertThat((int) stkAndBall.get("볼")).isEqualTo(0);
                    assertThat((int) stkAndBall.get("스트라이크")).isEqualTo(0);
                    baseballGame.printSBmap(stkAndBall);
                    assertThat(outputMsg.toString().trim()).isEqualTo("낫싱");
                }

            }
            System.setOut(System.out); // 원상복귀
        }

    }

    @DisplayName("요구사항 7에 대한 테스트")
    @Test
    void req7Test(){
        Scanner input;

        input = new Scanner("1\n");
        assertFalse(baseballGame.isEndGame(input));

        input = new Scanner("2\n");
        assertTrue(baseballGame.isEndGame(input));

        input = new Scanner("asdf\n");
        Scanner finalInput = input;
        assertThatIllegalArgumentException().isThrownBy(() -> baseballGame.isEndGame(finalInput));

        input = new Scanner("123412\n");
        Scanner finalInput2 = input;
        assertThatIllegalArgumentException().isThrownBy(() -> baseballGame.isEndGame(finalInput2));


    }

}