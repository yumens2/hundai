package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GameView {
    private BufferedReader reader;

    public GameView(InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in));
    }

    public String getUserInput() throws IOException {
        System.out.print("숫자를 입력해 주세요 : ");
        return reader.readLine();
    }

    public void displayResult(String feedback) {
        System.out.println(feedback);
    }

    public void displayGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean checkRestartGame() {}
}
