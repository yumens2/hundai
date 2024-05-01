import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Model.Answer;
import Model.Computer;
import Model.Player;

import utility.CalculateScore;
import utility.CheckPlayerNumberValidity;
import utility.CheckPlayerRestartNumberValidity;
import utility.CheckValidity;


public class ApplicationTest {

    @Test
    @DisplayName("Player클래스에 수가 저장이 잘 되는지 테스트")
    void classPlayerTest() {
        Player player = new Player("123");

        assertThat(player.getPlayerNum()).isEqualTo("123");
    }

    @Test
    @DisplayName("Answer클래스에 수가 저장이 잘 되는지 테스트")
    void classAnswerTest() {
        Answer answer = new Answer("123");

        assertThat(answer.getAnswerNum()).isEqualTo("123");
    }

    //유효성 정수가 맞는지, 3자리가 맞는지, 0을 포함했는지, 중복이 됐는지, 1또는2인지
    @Test
    @DisplayName("숫자가 맞는지 유효성 검사 테스트")
    void checkNumberTet(){
        assertThat(CheckValidity.numberValidity("123")).isEqualTo(true);
        assertThat(CheckValidity.numberValidity("abc")).isEqualTo(false);
    }

    @Test
    @DisplayName("3자리의 정수이면서 양수인지 테스트")
    void overThreeTest(){
        assertThat(CheckValidity.digitValidity("123")).isEqualTo(true);
        assertThat(CheckValidity.digitValidity("1234")).isEqualTo(false);

    }

    @Test
    @DisplayName("0을 포함한 수를 올바르게 검사하는지 테스트")
    void containZeroTest(){
        assertThat(CheckValidity.zeroValidity("123")).isEqualTo(true);
        assertThat(CheckValidity.zeroValidity("204")).isEqualTo(false);

    }

    @Test
    @DisplayName("즁복된 수를 올바르게 검사하는지 테스트")
    void sameNUmberTest(){
        assertThat(CheckValidity.sameValidity("123")).isEqualTo(true);
        assertThat(CheckValidity.sameValidity("112")).isEqualTo(false);
    }

    @Test
    @DisplayName("1 또는 2가 맞는지 테스트")
    void OneOrTwoTest(){
        assertThat(CheckValidity.oneTwoValidity("1")).isEqualTo(true);
        assertThat(CheckValidity.oneTwoValidity("2")).isEqualTo(true);
    }

    @Test
    @DisplayName("올바르지 않은 입력이 IllegalArgumentException을 일으키는지 테스트")
    void IllegalInputTest(){
        assertThatThrownBy(() -> CheckPlayerNumberValidity.playerNumberValidity("a1002"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> CheckPlayerRestartNumberValidity.playerRestartNumberValidity("3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Computer가 올바른 수를 생성하는지 테스트")
    void classComputerTest(){
        String testNumber = Computer.makeRandomNumber();
        assertThat(CheckValidity.sameValidity(testNumber)).isEqualTo(true);
    }

    @Test
    @DisplayName("힌트를 제대로 계산하지는 테스트")
    void calculateHintTest(){
        String answer = "574";
        String player = "548";
        assertThat(CalculateScore.ballCount(answer,player)).isEqualTo(1);
        assertThat(CalculateScore.strikeCount(answer,player)).isEqualTo(1);

    }


}
