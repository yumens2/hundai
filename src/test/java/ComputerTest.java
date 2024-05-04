import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer = new Computer();
    int[] tmp = computer.getComNum();

    @Test
    void 난수생성(){
        computer.createGameNumber();
        assertNotEquals(0,tmp[1]);
    }
}