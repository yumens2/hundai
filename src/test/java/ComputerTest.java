import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.*;
import java.io.*;

public class ComputerTest {

    @Test
    public void RandomThreeNumberTest() {
        Computer computer = new Computer();
        int[] cpunum = new int[3];

        computer.RandomThreeNumber(cpunum);

        //cpunum의 배열에 있는 수가 모두 1 ~ 9 사이의 숫자인지 확인합니다.
        for (int i = 0; i < cpunum.length; i++) {
            assertTrue(cpunum[i] >= 1 && cpunum[i] <= 9);
        }
        //Arrays.stream()은 지정된 배열에서 스트림을 생성합니다.
        //distinct()는 스트림에서 중복 항목을 제거합니다.
        //count()는 스트림의 요소 수를 반환합니다.
        //즉 cpunum 배열을 스트림으로 변환하고 중복된 요소를 제거한 후 스트림의 요소 수를 계산합니다.
        //계산된 값이 3과 일치한다면 배열에 중복이 없다는 것을 알게 되고 어설션을 통과합니다.
        assertEquals(3, Arrays.stream(cpunum).distinct().count());
    }
}
