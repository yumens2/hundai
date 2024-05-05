package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    @DisplayName("getNumber method must return int array type")
    void getNumberReturnIntArrayTypeTest() throws Exception {
        //given
        User user = new User("123");

        //when
        int[] expectedNumbers = {1, 2, 3};

        //then
        assertThat(user.getNumbers()).containsExactly(expectedNumbers);
    }

    @Test
    @DisplayName("getNumber throws exception for invalid input test")
    void getNumberThrowsExceptionForInvalidInputTest() throws Exception {
        //given
        User user = new User("abc");

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            user.getNumbers();
        });
    }
}