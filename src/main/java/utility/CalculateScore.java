package utility;

public class CalculateScore {
    private CalculateScore(){}

    public static int ballCount(String answer, String inputNumber){
        int ball = 0;//볼의 개수
        // 입력된 수의 왼쪽부터 1번째 자리 에서 3번째 짜리까지 다른 자리에 같은 수가 있는지 검사하여 같은 수가 있으면 ball의 값을 1증가
        if (inputNumber.charAt(0) == answer.charAt(1) || inputNumber.charAt(0) == answer.charAt(2)) {
            ball++;
        }

        if (inputNumber.charAt(1) == answer.charAt(0) || inputNumber.charAt(1) == answer.charAt(2)) {
            ball++;
        }

        if (inputNumber.charAt(2) == answer.charAt(0) || inputNumber.charAt(2) == answer.charAt(1)) {
            ball++;
        }

        return ball;
    }

    public static int strikeCount(String answer, String inputNumber){
        int strike = 0;//스트라이크 수
        //입력된 수가 같은 자리에 같은 수가있다면 strike 1즐가
        if (answer.charAt(0) == inputNumber.charAt(0)) {
            strike++;
        }

        if (answer.charAt(1) == inputNumber.charAt(1)) {
            strike++;
        }

        if (answer.charAt(2) == inputNumber.charAt(2)) {
            strike++;
        }

        return strike;
    }

}
