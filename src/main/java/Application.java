
public class Application {
    public static void main(String[] args) {
        Print print = new Print();
        NumberScanner scan = new NumberScanner();
        int again;

        while(true) {
            print.gamePrint();
            again = scan.again();
            if (again == 1) continue;
            else if (again == 2) break;
            else throw new IllegalArgumentException();
        }
    }
}
