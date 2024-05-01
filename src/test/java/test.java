import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class test {

    @Test
    void makeRandNumArray(){
        ArrayList<Integer> numArray = new ArrayList<>();
        while(numArray.size() < 3){
            Random random = new Random();
            // 1~9 난수 생성
            int n = random.nextInt(8) + 1;
            // 배열에 없는 경우 숫자 추가
            if(!numArray.contains(n)) {
                numArray.add(n);
            }
        }
        for (Integer integer : numArray) {
            System.out.println(integer);
        }
    }
}
