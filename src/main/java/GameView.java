public class GameView {
    public void displayNumberInputRequest() {
        System.out.print("숫자를 입력해 주세요 : ");
    }
    /**
     * 스트라이크와 볼을 출력하는 메소드
     *
     * @param strikes 스트라이크 개수
     * @param balls   볼 개수
     */
    public void displayResult(int strikes, int balls) {
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크 ");
        }
        if (balls > 0) {
            System.out.print(balls + "볼");
        }
        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    /**
     * 정답 시 메시지 출력
     */
    public void displayGameWonMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 정답 이후 선택지 메시지 출력
     */
    public void displayPlayAgainMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
