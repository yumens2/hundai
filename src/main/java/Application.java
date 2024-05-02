
public class Application {
    public static void main(String[] args) {
        Print print = new Print();
        int again;
        while(true) {
            print.gamePrint();
            again = checkAgain();
            if (again == 1) continue;
            else if (again == 2) break;
            else throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    static int checkAgain(){
        NumberScanner scan = new NumberScanner();
        int again;
        again = scan.again();

        return again;
    }

}
