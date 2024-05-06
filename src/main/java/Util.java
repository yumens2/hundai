import java.util.Random;
import java.util.Scanner;

public class Util {
    public boolean process(int userInput, int gameAnswer){
        int strike; //스트라이크의 갯수를 담는 변수
        int ball; //볼의 갯수를 담는 변수


        strike = countStrike(userInput, gameAnswer);
        if (strike ==3)
            return true;
        else
            return false;
    }

    public int countStrike(int userInput, int gameAnswer){
        int[] input = new int[3];
        input[0] = userInput/100;
        input[1] = userInput/10 - input[0]*100;
        input[2] = userInput%10;

        int[] answer = new int[3];
        answer[0] = userInput/100;
        answer[1] = userInput/10 - answer[0]*100;
        answer[2] = userInput%10;

        int cnt = 0;
        for(int i = 0; i< input.length; i++){
            if(input[i]==answer[i])
                cnt++;
        }

        return cnt;
    }

}
