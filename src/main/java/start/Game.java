package start;

public class Game {
    static boolean gameStatus = true;
    static boolean errStatus = false;

    public static void gameStart() {
        while(gameStatus) {
            int[] compArr = RandomThreeNumGenerator.generateRanNum();
            gamePlay(compArr);

            if(!gameStatus && !errStatus) {
                gamePause();
            }
        }
    }

    private static void gamePlay(int[] compArr) {
        while(true) {
            String userInput = UserInput.getUserInput();

            try {
                ExceptOccurCheck.checkInputValidation(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                gameStatus = false;
                errStatus = true;
                return;
            }

            String result = ResultCalculator.calculateResult(compArr,userInput);
            System.out.println(result);

            if(result == "3스트라이크") {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameStatus = false;
                return;
            }

        }
    }

    private static void gamePause() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = UserInput.getUser_int_Input();

        try {
            ExceptOccurCheck.checkInputValidation(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gameStatus = false;
            return;
        }
        if(userInput == 1) {
            gameStatus = true;
        }
        else if(userInput == 2) {
            gameStatus = false;
        }
    }
}
