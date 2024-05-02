
public class Application {
    public static void main(String[] args) {
        Print print = new Print();
        int again;
        while(true) {
            print.gamePrint();
            again = checkAgain();
            if (again == 1) continue;
            else break;
        }
    }

    static int checkAgain(){
        NumberScanner scan = new NumberScanner();
        int again;
        again = scan.again();

        return again;
    }

}
