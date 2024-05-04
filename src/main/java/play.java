import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class play {

    public List<Integer> checkInput(){

        inputNum numToList = new inputNum();
        isCorrect chkInput = new isCorrect();
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = true;

        System.out.print("숫자를 입력해 주세요 : ");
        String inputValue = sc.nextLine();
        isValidInput = chkInput.isCorrectInput(inputValue);

        if(!isValidInput){
            sc.close();
            throw new IllegalArgumentException("wrong input");
        }
    
        return numToList.numToList(inputValue);
    }
    
    public boolean continueGame(){

        Scanner sc = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int continueGame = sc.nextInt();
        sc.close();

        if(continueGame == 1){
            return true;
        }else if(continueGame == 2){
            return false;
        }else{
            throw new IllegalArgumentException("wrong input");
        }

    }


    public boolean playGame(List<Integer> computer){

        compare compareNum = new compare();
        String result = "낫싱";

        try{
            while(!Objects.equals(result, "3스트라이크")) {
                List<Integer> user = checkInput();
                result = compareNum.compareNum(computer, user);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return continueGame();

        }catch(IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }
}
