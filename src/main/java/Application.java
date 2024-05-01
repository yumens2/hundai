import java.util.ArrayList;

public class Application {
    public static void main(String[] args){
        boolean start = true;
        Input input = new Input();
        ResultChecker rc = new ResultChecker();
        ReStart rs = new ReStart();

        while(start) {
            ArrayList<Integer> target = RandomNumber.generateRandomNumber();
            boolean round = true;
            System.out.println(target);
           while(round){
               ArrayList<Integer> userInput = input.getUserNumber();
               round = rc.checkRes(userInput,target);
           }
           System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
           start = rs.selectContinue();
        }
    }
}
