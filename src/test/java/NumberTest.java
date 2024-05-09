import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
    public final ByteArrayOutputStream output=new ByteArrayOutputStream();
    Number number = new Number();
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }
    @Test
    @DisplayName("길이 오류 체크.")
    void getNum_lengthError(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("1234");
            number.getNum();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("12");
            number.getNum();
        });
    }
    @Test
    @DisplayName("숫자가 아닌 값 입력시 오류.")
    void getNum_numericError(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("aaaa");
            number.getNum();
        });
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("1a");
            number.getNum();
        });
    }
    @Test
    @DisplayName("같은 값 입력 시 오류")
    void getNum_notValid(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("990");
            number.getNum();
        });
    }
    @Test
    @DisplayName("게임종료 여부 입력 시 오류")
    void finishedGameError(){
        Assertions.assertThrows(java.lang.Exception.class, () -> {
            systemIn("3");
            number.finishedGame();
        });
    }
    @Test
    @DisplayName("입력값 비교 후 출력 값 확인")
    void printWhatSame(){
        number.STRIKE=0;
        number.BALL=2;
        number.printWhat();
        assertThat(output.toString().trim())
            .isEqualTo("2볼");
        restoreOutputStream();
        number.STRIKE=1;
        number.BALL=1;
        number.printWhat();
        assertThat(output.toString().trim())
            .isEqualTo("1볼 1스트라이크");
        restoreOutputStream();
        number.STRIKE=0;
        number.BALL=0;
        number.printWhat();
        assertThat(output.toString().trim())
            .isEqualTo("낫싱");
        restoreOutputStream();
        number.STRIKE=2;
        number.BALL=0;
        number.printWhat();
        assertThat(output.toString().trim())
            .isEqualTo("2스트라이크");
    }
    @Test
    @DisplayName("숫자가 같은지 확인")
    void compareNumCorrect(){
        number.MY_NUM[0]=1;
        number.MY_NUM[1]=2;
        number.MY_NUM[2]=3;
        number.RANDOM_NUM[0]=1;
        number.RANDOM_NUM[1]=2;
        number.RANDOM_NUM[2]=3;
        number.compareNum();
        assertThat(number.STRIKE).isEqualTo(3);
        assertThat(number.BALL).isEqualTo(0);
        number.STRIKE=0; number.BALL=0;
        number.RANDOM_NUM[0]=2;
        number.RANDOM_NUM[1]=4;
        number.RANDOM_NUM[2]=1;
        number.compareNum();
        assertThat(number.BALL).isEqualTo(2);
        assertThat(number.STRIKE).isEqualTo(0);
        number.STRIKE=0; number.BALL=0;
        number.RANDOM_NUM[0]=1;
        number.RANDOM_NUM[1]=4;
        number.RANDOM_NUM[2]=2;
        number.compareNum();
        assertThat(number.BALL).isEqualTo(1);
        assertThat(number.STRIKE).isEqualTo(1);
    }
}

