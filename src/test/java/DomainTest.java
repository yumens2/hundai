
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.Computer;
import baseball.domain.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DomainTest {

    @Test
    public void playerTest(){
        Player player = new Player();
        List<Integer> playerList = Arrays.asList(1,2,3);

        player.setPlayerNumbers(playerList);
        List<Integer> getPlayerNumbers = player.getPlayerNumbers();

        assertEquals(playerList,getPlayerNumbers);
    }

    @Test
    public void ComputerTest(){
        Computer computer = new Computer();

        computer.setComputerNumber();
        List<Integer> computerList1 = computer.getComputerNumbers();

        computer = new Computer();
        computer.setComputerNumber();
        List<Integer> computerList2 = computer.getComputerNumbers();

        assertNotEquals(computerList1,computerList2);
    }

}
