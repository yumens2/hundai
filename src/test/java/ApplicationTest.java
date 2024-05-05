import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ApplicationTest {
    @Test
    public void testRunGameOnce() {
        Player testPlayer = new TestPlayer();
        Computer testComputer = new TestComputer();
        Restart testRestart = new TestRestart();

        Application app = new Application(testComputer, testPlayer, testRestart);
        app.run();

        assertFalse(testRestart.askForRestart(), "게임은 한 번만 실행되고 종료되어야 합니다.");
    }
}