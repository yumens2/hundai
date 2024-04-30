
import Model.Answer;
import Model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {
    /*
        1.
        2.
        3.
        4.
        5.
        6.
        7.
        8.
        유효성 검사(정수가 맞는지, 3자가 맞는지, 0이 있는지, 중복되진 않는지



     */
    @Test
    @DisplayName("Player클래스에 수가 저장이 잘 되는지 테스트")
    void Player검사() {
        Player player = new Player("123");
        assertThat(player.getPlayerNum()).isEqualTo("123");
    }

    @Test
    @DisplayName("Answer클래스에 수가 저장이 잘 되는지 테스트")
    void Answer검사() {
        Answer answer = new Answer("123");
        assertThat(answer.getAnswerNum()).isEqualTo("123");
    }


    //컴퓨터 랜덤숫자 만드는지 (보류)
    //answer에 저장(저장이 잘되는지)
    //Player예 입력된 수 저장(저장이 잘되는지)
    //입력된 수 유효성 검사(정수가 맞는지, 3자가 맞는지, 0이 있는지, 중복되진 않는지)
    //힌트 계산
    //계산된 힌트 출력문구
    //3스트라이크면 게임종료 아니면 반복
    //재시학할지 종료할지 입력( 유효성검사, 1,2아니면 싹다 아님)
    //startGame이 true를 리턴하는지
}
