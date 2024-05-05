package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    @DisplayName("getNumber method must return int array type")
    void getNumberReturnIntArrayTypeTest() throws Exception {
        //given
        User user = new User();
        user.setUserInput("123");

        //when
        int[] expectedNumbers = {1, 2, 3};

        //then
        assertArrayEquals(expectedNumbers, user.getNumbers());
    }

    @Test
    @DisplayName("getNumber throws exception for invalid input test")
    void getNumberThrowsExceptionForInvalidInputTest() throws Exception {
        //given
        User user = new User();

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUserInput("abc");
        });
    }
    
    @Test
    @DisplayName("getNumber throws exception for non distinct number")
    void getNumberThrowsExceptionForNonDistinctNumber() throws Exception {
        //given
        User user = new User();

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUserInput("111");
        });
    }
}