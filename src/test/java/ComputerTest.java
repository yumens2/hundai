import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {

    @Test
    @DisplayName("랜덤으로 생성된 숫자의 길이가 3인지 테스트")
    public void testCreateRandomNum_ThreeLength(){
        List<Integer> cpuNum = Computer.createRandomNum();
        assertEquals(3,cpuNum.size());
    }

    @Test
    @DisplayName("랜덤으로 생성된 숫자들이 1~9의 숫자인지 테스트")
    public void testCreateRandomNum_isInRange(){
        List<Integer> cpuNum = Computer.createRandomNum();
        for(int num : cpuNum){
            assertTrue(num >=1 && num<=9);
        }
    }

    @Test
    @DisplayName("랜덤으로 생성된 숫자의 중복 검사")
    public void testCreateRandomNum_isDuplicate(){
        List<Integer> cpuNum = Computer.createRandomNum();
        assertEquals(cpuNum.size(), cpuNum.stream().distinct().count());

    }
}
