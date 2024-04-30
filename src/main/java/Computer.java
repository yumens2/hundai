import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Random;

public class Computer {
    /**
     * 랜덤 수를 생성하는 메소드
     * @return 랜덤 3자리수 ArrayList<Integer>
     */
    public List<Integer> generatAnswer(){
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size()<3){
            numbers.add(random.nextInt(9) + 1);
        }
        return new ArrayList<>(numbers);
    }
}
