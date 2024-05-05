import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateRandomNumber {
    public StringBuilder randomNum() {
        StringBuilder answer = new StringBuilder();
        Random random = new Random();       // 랜덤 객체 생성
        Set<Integer> generatedNumbers = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            int random_num;
            do {
                random_num = random.nextInt(9) + 1;
            } while (generatedNumbers.contains(random_num));
            generatedNumbers.add(random_num);
            answer.append(random_num + "");
        }

        return answer;
    }
}

