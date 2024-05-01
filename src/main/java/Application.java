public class Application {
    public static void main(String[] args) {
        Print print = new Print();
        int again = print.gamePrint();
        while(again == 1){
            again = print.gamePrint();
            if(again == 1) continue;
            else if(again == 2) break;
            else throw new IllegalArgumentException("입력값이 유효하지 않습니다");
        }
    }
}
