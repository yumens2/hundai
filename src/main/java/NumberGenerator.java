public class NumberGenerator {
    public static int[] generateUniqueRandomNumbers(int length) {
        int[] numArr = new int[length];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 9 + 1);
            for (int j = 0; j < i; j++) {
                if (numArr[j] == numArr[i]) {
                    i--;
                    break;
                }
            }
        }

        return numArr;
    }
}
