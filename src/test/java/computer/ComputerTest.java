package computer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private final Computer computer = new Computer();

    @Test
    @DisplayName("컴퓨터 서로다른 3자리 숫자 생성 테스트")
    void computerInitTest(){
        String number = computer.getNumber();

        Set<Integer> numbers = new HashSet<>();

        for(int i=0; i<3; i++){
            numbers.add(Integer.valueOf(number.charAt(i)));
        }

        assertThat(numbers.size()).isEqualTo(3);
    }

}