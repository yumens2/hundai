import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    InputStream sysInBackup;
    @BeforeEach
    void setUp() {
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);
    }

    void sysIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @Test
    void getInput() {
        String[] success = {"123", "451", "874"};
        String[] fails = {"ㄱㄴㄷ", "42", "119", "001", "1111"};
        Input input = new Input();
        for(int i = 0; i < success.length; i++){
            sysIn(success[i]);
            assertThat(input.isValid(input.getInput())).isTrue();
        }

        for(int i = 0; i < fails.length; i++){
            sysIn(fails[i]);
            assertThrows(IllegalArgumentException.class, ()->{input.getInput();});
        }

    }

    @Test
    void isValid() {
        int[] success ={123, 124, 125};
        int[] fails ={111, 102, 022};
        Input input = new Input();
        for(int i  = 0; i < success.length;i++){
            assertThat(input.isValid(success[i])).isTrue();
        }

        for(int i  = 0; i < fails.length;i++){
            assertThat(input.isValid(fails[i])).isFalse();
        }
    }
}