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



    public static void main(String[] args){
        int ContinueGameSet = YES;
        int ContinueUserSet = YES;

        BaseballNumber baseballNumber;

        while (ContinueGameSet == YES) {
            baseballNumber = new BaseballNumber();
            baseballNumber.setRandomNum(pickNum());


            while (ContinueUserSet == YES) {

            }

        }
    }
}
