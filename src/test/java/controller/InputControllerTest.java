package controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputControllerTest {

    InputController inputController = new InputController();

    @Test // [MethodName][StateUnderTest][ExpectedBehavior]
    void testGeneratedUserNum() {
        String input = "1 2 3";
        // String을 setIn을 통해 입력시킨다.new ByteArrayInputStream(input.getBytes())는 input 문자열을 바이트 배열로
        // 변환한 후, 이를 사용하여 새로운 ByteArrayInputStream 객체를 생성합니다. ByteArrayInputStream은 InputStream의 하위
        // 클래스로, 바이트 배열에서 데이터를 읽는 데 사용됩니다.
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ArrayList<Integer> result = inputController.generateUserNum();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);
    }

    @Test
    void testGenerateComputerNumSize() {
        Set<Integer> result = inputController.generateComputerNum();
        assertThat(result.size()).isEqualTo(3);
    }
}
