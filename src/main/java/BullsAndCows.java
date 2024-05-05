import java.util.List;

public class BullsAndCows {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        Compare compare = new Compare();
        ResultPrint resultPrint = new ResultPrint();
        RestartTheGame restartTheGame = new RestartTheGame();

        boolean playAgain = true;

        while (playAgain) {
            int strike = 0;
            int contain = 0;

            // 랜덤한 수 생성
            StringBuilder computerNumber = generateRandomNumber.randomNum();

            while (strike != 3) {
                // 사용자 입력 받기
                List<String> playerNumber = userInput.input();

                // 비교하기
                strike = compare.strike(playerNumber, computerNumber);
                contain = compare.contain(playerNumber, computerNumber);

                // 결과 출력하기
                String result = resultPrint.judge(contain, strike);
                System.out.println(result);
            }
            // 재게임 여부 확인
            playAgain = restartTheGame.regame();
        }
    }
}
