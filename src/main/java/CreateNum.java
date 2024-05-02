import java.util.HashSet;
import java.util.Random;

public class CreateNum {

    private CreateNum() {

    }

    public static String createNumbers() {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[3];

        CreateNum.loopNum(set, arr);
        return CreateNum.toString(arr);
    }

    public static void loopNum(HashSet<Integer> set, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random r = new Random();
            int temp = r.nextInt(8) + 1;
            if (set.contains(temp)) {
                i -= 1;
            } else {
                set.add(temp);
                arr[i] = temp;
            }
        }
    }

    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}


