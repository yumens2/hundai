public class Game {

    // 게임의 진행을 담당
    public void run() {

        Player player = new Player();
        Computer computer = new Computer();
        Referee referee = new Referee();
        GameManager gameManager = new GameManager();
        boolean again = true;

        computer.generate();
        while (again) {
            player.inputNumbers();
            JudgeDTO judgeDTO = referee.judge(player.getPlayerNumbers(),
                computer.getComputerNumbers());
            showJudge(judgeDTO);
            if (judgeDTO.getStrikeCount() == 3) {
                again = false;
            }
        }
        gameManager.decideRestart();
    }

    private void showJudge(JudgeDTO judgeDTO) {
        int strike = judgeDTO.getStrikeCount();
        int ball = judgeDTO.getBallCount();

        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            return;
        }
        if (ball != 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }
}
