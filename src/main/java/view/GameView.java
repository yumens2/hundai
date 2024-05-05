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
        String inputNumber = null;
        System.out.print("숫자를 입력해 주세요 : ");
        inputNumber = reader.readLine();
        return inputNumber;
    }
}
