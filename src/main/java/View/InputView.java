package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputView(){}

    public static String Input()throws IOException {//입력받는 함수
        return br.readLine();
    }
}
