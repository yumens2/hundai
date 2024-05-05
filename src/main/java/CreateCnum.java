import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CreateCnum {
    int Num = 3;    // 숫자 개수는 3

    public List<Integer> ComputerNumber() {
        List<Integer> CNum = new ArrayList<>();
        Set<Integer> usedNum = new HashSet<>();
        Random random = new Random();
        while (CNum.size() < Num) {
            int dig = random.nextInt(9) + 1;    // 랜덤으로 숫자 생성
            if (usedNum.add(dig))
                CNum.add(dig);
        }
        return CNum;
    }

}
