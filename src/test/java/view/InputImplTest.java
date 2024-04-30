package view;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class InputImplTest {
    @Test
    public void endInputTest1() {
        // given
        Input input = new InputImpl();

        // when
        String testUserInput = "3";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));

        // then
        Assertions.assertThrows(IllegalArgumentException.class, input::endInput);
    }

    @Test
    public void endInputTest2() {
        // given
        Input input = new InputImpl();

        // when
        String testUserInput = "a";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));

        // then
        Assertions.assertThrows(IllegalArgumentException.class, input::endInput);
    }

    @Test
    public void baseballInputTest1() {
        // given
        Input input = new InputImpl();

        // when
        String testUserInput = "1234";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));

        // then
        Assertions.assertThrows(IllegalArgumentException.class, input::baseballInput);
    }

    @Test
    public void baseballInputTest2() {
        // given
        Input input = new InputImpl();

        // when
        String testUserInput = "12a";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));

        // then
        Assertions.assertThrows(IllegalArgumentException.class, input::baseballInput);
    }
}