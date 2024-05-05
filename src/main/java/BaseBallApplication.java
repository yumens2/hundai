import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaseBallApplication {

    public static void main(String[] args) throws IOException {
        do {
            if (!MajorLeague.playBaseBall()) {
                break;
            }
        } while (true);
    }
}