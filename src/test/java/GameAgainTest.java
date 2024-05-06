import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//
class GameAgainTest {
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
    void gameAgain() {
        String [] success = {"1","2"};
        String[] fails = {"3","4", "ㄱㄴㄷ"};
        GameAgain gameAgain = new GameAgain();

        sysIn(success[0]);
        assertThat(gameAgain.gameAgain()).isTrue();

        sysIn(success[1]);
        assertThat(gameAgain.gameAgain()).isFalse();

        for(int i = 0; i < fails.length; i++){
            sysIn(fails[i]);
            assertThrows(IllegalArgumentException.class, ()->{gameAgain.gameAgain();});
        }
    }
}