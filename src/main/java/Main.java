import java.io.*;
import java.util.*;

public class Main {
    private static final int YES = 1;
    private static final int NO = 0;

    public static final int NUMBER_OF_CASE = 3;

    private static List<Integer> pickNum() {
        Random random = new Random();
        List<Integer> randomNum = new ArrayList<>();
        while (randomNum.size() != NUMBER_OF_CASE) {
            int ranNum = random.nextInt(9 ) + 1;
            if (!randomNum.contains(ranNum)) {
                randomNum.add(ranNum);
            }
        }
        return randomNum;
    }

    private static List<Integer> getUserNum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("숫자를 입력해주세요");
        String[] userArr = br.readLine().split("");
        checkUserNum(userArr);
        List<Integer> userNum = new ArrayList<>();
        userNum.add(Integer.parseInt(userArr[0]));
        userNum.add(Integer.parseInt(userArr[1]));
        userNum.add(Integer.parseInt(userArr[2]));
        System.out.println(userNum);
        return userNum;
    }

    private static void checkUserNum(String[] userArr) {
        if (userArr.length != NUMBER_OF_CASE) {
            throw new IllegalArgumentException();
        }
    }



    public static void main(String[] args) throws IOException {
        int ContinueGameSet = YES;
        int ContinueUserSet = YES;

        BaseballNumber baseballNumber;
        Hint hint = new Hint();

        while (ContinueGameSet == YES) {
            baseballNumber = new BaseballNumber();
            baseballNumber.setRandomNum(pickNum());

            while (ContinueUserSet == YES) {
                int numberOfStrike = 0;
                int numberOfBall = 0;

                baseballNumber.setUserNum(getUserNum());

                numberOfStrike = baseballNumber.countStrike();
                numberOfBall = baseballNumber.countBall();
                hint.setNumberOfStrike(numberOfStrike);
                hint.setNumberOfBall(numberOfBall);

                ContinueUserSet = hint.printAnswer();
            }

        }
    }
}
