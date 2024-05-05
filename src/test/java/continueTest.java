import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class continueTest {

    play playing;

    @BeforeEach
    void setUp(){
        playing = new play();
    }

    @Test
    @DisplayName("continue test")
    void continueTesting(){
        //continue
        assertTrue(playing.continueGame(1));
        assertFalse(playing.continueGame(2));
    }
    
}
