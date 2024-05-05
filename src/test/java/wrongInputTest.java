import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.BeforeEach;

public class wrongInputTest {

    play playing;

    @BeforeEach
    void setUp(){
        playing = new play();
    }


    @Test
    @DisplayName("wrong input test")
    public void testing() {
        try {
            String input = "1234";
            playing.checkInput(input);
        } catch (IllegalArgumentException e) {
            return;
        }		
        fail("no exception!");
    }

}
