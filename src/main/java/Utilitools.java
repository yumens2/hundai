import java.util.Random;
import java.util.Vector;

public class Utiltools {
    public static void makeNumber(int[] computer) {
        Random random = new Random();
        Vector<Integer> number = new Vector<>();
        int buffer;

        for (int i=1; i<10; i++) {
            number.add(i);
        }

        for (int i=0; i<3; i++) {
            buffer = random.nextInt(9-i); // 0~8 random index
            computer[i] = number.get(buffer); // select num(w.random index) and save in computer vector
            number.remove(buffer); //remove for prevent reduplication
        }
    }

    public static void changeType(int[] userNumber, String userNum) {
        int buffer = Integer.parseInt(userNum);

        for (int i = 0; i < 3; i++) {
            userNumber[2-i] = buffer % 10;
            buffer = buffer / 10;
        }
    }

    public static int isCorrect(int indexC, int indexI, int comNum, int userNum) {
        if (comNum == userNum) {
            if (indexC == indexI) {
                return 1;
            }
            else {
                return 0;
            }
        }
        return 2;
    }

    public static void compareNum(int[] computerNumber, int[] userNumber, int[] result) {
        int indexC = 0, indexI = 0;

        for (int comNum : computerNumber) {
            for (int userNum : userNumber) {
                result[isCorrect(indexC, indexI, comNum, userNum)] += 1;
                indexI += 1;
            }
            indexC += 1;
            indexI = 0;
        }
    }

    public static void clearResult(int[] result) {
        for (int i = 0; i < 3; i++) {
            result[i] = 0;
        }
    }
}
