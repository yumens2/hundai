package baseballtest;

import static org.assertj.core.api.Assertions.assertThat;
import baseball.ComputerNum;
import org.junit.jupiter.api.Test;

public class ComputerNumTest {
    @Test
    public void testGenerateComputerNumbers() {
        ComputerNum computer = new ComputerNum();
        computer.generateComputerNumbers();
        assertThat(computer.getComputerNumbers()).hasSize(3);
        assertThat(computer.getComputerNumbers()).doesNotHaveDuplicates();
        assertThat(computer.getComputerNumbers()).allMatch(num -> num > 0 && num <= 9);
    }
}