import java.util.*;

public class Application {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            String number = UtilClass.start();
            boolean canNext = UtilClass.game(number);
            if (!canNext) return;
        } while (sc.nextLine().equals("1"));
    }


}