import java.util.Random;
import java.util.Scanner;

public class Util { //
    public boolean process(int userInput, int gameAnswer) {
        int[] input = new int[3]; //볼과 스트라이크 계산을 위해 userInput을 크기가 3인 배열에 대입.
        input[0] = userInput / 100;
        input[1] = userInput / 10 - input[0] * 10;
        input[2] = userInput % 10;

        int[] answer = new int[3]; //볼과 스트라이크 계산을 위해 gameAnswer을 크기가 3인 배열에 대입.
        answer[0] = gameAnswer / 100;
        answer[1] = gameAnswer / 10 - gameAnswer * 10;
        answer[2] = gameAnswer % 10;

        int strike; //스트라이크의 갯수를 담는 변수
        int ball; //볼의 갯수를 담는 변수

        strike = countStrike(input, answer);
        ball = countBall(input, answer);
        ball = ball - strike; // 볼의 갯수는 앞에서 구한 볼의 갯수에서strike를 빼줘야 함.
        if (strike + ball == 0) { //볼과 스트라이크의 갯수가0인 경우에는 낫싱
            System.out.println("낫싱");
            return false;
        } else {
            switch (ball) {
                case 0:
                    break;
                default: //볼이 있는 경우 볼 출력
                    System.out.print(ball + "볼");
                    break;

            }
            switch (strike) {
                case 0:
                    return false;
                case 1:
                case 2:
                    System.out.println(strike + "스트라이크");
                    return false;
                default:
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    return true;
            }
        }
    }

    public int countStrike(int[] input, int[] answer){ //strike의 갯수를 구하는 함수
        int cnt = 0;
        for(int i = 0; i< input.length; i++){
            if(input[i]==answer[i])
                cnt++;
        }

        return cnt;
    }

    public int countBall(int[] input, int[] answer){ //ball의 갯수를 구하는 함수
        int cnt = 0;
        for(int i = 0; i< input.length; i++){
            if(input[i]==answer[0] || input[i] == answer[1] || input[i] == answer[2])
                cnt++;
        }
        return cnt;
    }
}
