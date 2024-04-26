import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CreateRandomNum {

    private Integer[] RandomNum;

    //    랜덤 넘버 생성
    public CreateRandomNum() {
        int create = 3;
        int rangeMax = 9;
        int rangeMin = 1;

        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        while (set.size() < create) {
            int num = random.nextInt(rangeMax) + rangeMin;
            set.add(num);
        }

        RandomNum = set.toArray(new Integer[0]);
    }

    /**
     * @param num   입력된 숫자
     * @param index 입력된 위치
     * @return 스트라이크 여부
     */
    public Boolean isStrike(int num, int index) {
        if (RandomNum[index] == num) {
            return true;
        }
        return false;
    }

    /**
     * @param num   입력된 숫자
     * @param index 입력된 위치
     * @return 볼 여부
     */
    public Boolean isBall(int num, int index) {
        for (int i = 0; i < 3; i++) {
            if (index == i) {
                continue;
            }
            if (RandomNum[i] == num) {
                return true;
            }
        }
        return false;
    }

    //  테스트용
    public Integer[] getRandomNum() {
        return RandomNum;
    }
}
