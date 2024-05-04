import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {
    User user;

    @BeforeEach
    void createUserInstance() {
        user = new User();
    }

    @Test
    @DisplayName("유저 예측 숫자 입력 테스트")
    void setInputNumTest() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        user.setInputNum();
        assertThat(user.getInputNum()).isEqualTo("123");

        System.setIn(new ByteArrayInputStream("456".getBytes()));
        user.setInputNum();
        assertThat(user.getInputNum()).isEqualTo("456");
    }

    @Test
    @DisplayName("유저 게임 재시작/종료 선택 입력 테스트")
    void setRetryOrFinishTest() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        user.setRetryOrFinish();
        assertThat(user.chooseRetryOrFinish()).isEqualTo(1);

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        user.setRetryOrFinish();
        assertThat(user.chooseRetryOrFinish()).isEqualTo(2);
    }
}
