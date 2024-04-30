import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private Computer computer;
    private User user;
    private boolean isGameOver;

    public BaseballGame(){
        this.computer = new Computer();
        this.user = new User();
        this.isGameOver = false;
    }
    public void startGame(){
        try{
            while(!isGameOver) {
                playTurn();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            // System.exit()를 사용하지 말라는 요구사항이 있었음
            return;
        }
    }
    private void playTurn(){
        String userInput = user.getUserInputNumbers();
        if (NumValidator.isValidInput(userInput)){
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        }
        List<Integer> userInputInt = new ArrayList<>();
        for (char c : userInput.toCharArray()){
            userInputInt.add((int)c);
        }
        computeNum(userInputInt);
    }

    private StrikeAndBallCounter computeNum(List<Integer> userInputInt){
        int strikes = 0;
        int balls = 0;
        List<Integer> comNum = computer.getComputerNumbers();
        for (int i = 0; i < 3; i++){
            if (comNum.get(i).equals(userInputInt.get(i))) {
                strikes += 1;
            }
            else if(comNum.contains(userInputInt.get(i))){
                balls += 1;
            }
        }
        // 이러면 매 천 마다 객체 생성된다는 말인데... 조금 더 고민해보자
        StrikeAndBallCounter strikeAndBallCounter = new StrikeAndBallCounter(strikes, balls);
        return strikeAndBallCounter;
    }
}
