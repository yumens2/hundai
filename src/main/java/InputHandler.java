import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String getUserInput() throws IOException {
        System.out.print("숫자를 입력해 주세요: ");
        return br.readLine();
    }
}
