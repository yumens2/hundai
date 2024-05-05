import java.util.Random;

public class MakeNumbers {
    public static int[] makeNumbers() {
        // 1 ~ 9 중 랜덤하게 3개 선택해서 리턴
        Random random = new Random();
        int[] numbers = new int[3];
        boolean[] used = new boolean[9];

        for (int i = 0; i < 3; i++) {
            int tmpNum;
            do {
                tmpNum = random.nextInt(8) + 1;
            } while (used[tmpNum]);
            numbers[i] = tmpNum;
            used[tmpNum] = true;
        }

        return numbers;
    }
}
