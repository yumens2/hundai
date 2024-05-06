public class NumberGenerator {
    public static int[] generateUniqueRandomNumbers(int length) {
        int[] numArr = new int[length];
        boolean[] used = new boolean[10]; // 사용된 숫자를 추적하기 위한 배열

        for (int i = 0; i < numArr.length; i++) {
            int randomNumber;
            do {
                randomNumber = (int) (Math.random() * 9 + 1);
            } while (used[randomNumber]); // 이미 사용된 숫자라면 다시 난수를 생성

            numArr[i] = randomNumber;
            used[randomNumber] = true;
        }

        return numArr;
    }
}

