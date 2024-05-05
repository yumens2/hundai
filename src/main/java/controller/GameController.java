package controller;

import service.GameService;

import java.util.Scanner;

public class GameController {

    private GameService gameService;
    private final Scanner sc;
    public GameController () {
        this.gameService = new GameService();
        this.sc = new Scanner(System.in);
    }


    public void playGame() {
        while (true) {
            gameService.generateSecretNumber();
            while (true) {
                try {
                    System.out.print("숫자를 입력해 주세요 : ");
                    String input = sc.nextLine();
                    validateInput(input);
                    String result = gameService.checkGuess(input);
                    System.out.println(result);

                    if ("3스트라이크".equals(result)) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int choose = sc.nextInt();
                        validateChoose(choose);
                        if (choose == 1) {
                            break;
                        }
                        else {
                            System.out.println("게임을 완전히 종료합니다.");
                            sc.close();
                            return;
                        }
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    sc.close();
                    return;
                }
            }
        }
    }
    private void validateInput (String input) {
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1에서 9까지의 숫자로 이루어진 3자리 숫자를 입력하세요.");
        }
    }

    private void validateChoose (int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
