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

    // 게임 시작 메서드. isGameOver 가 false 일 때 playTurn() 호출.
    // 도중에 사용자가 잘못된 값을 입력하면 playTurn()이 던진 예외를 잡아 오류 메세지 출력
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

    // 한 게임의 매 턴을 담당하는 메서드
    // 사용자가 잘못된 값을 입력하면 예외 던짐
    private void playTurn(){
        String userInput = user.getUserInputNumbers();
        if (NumValidator.isValidInput(userInput)){
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        }
        List<Integer> userInputInt = new ArrayList<>();
        for (char c : userInput.toCharArray()){
            // 기존에 (int)c로 코드를 짰었는데 이러면 안된다고 하네요
            // int로 강제 캐스팅하면 문자 아스키 코드가 int로 변환되기 때문에 이렇게 '0'을 빼줘서 리스트에 넣으면 된다는 것을 처음 알았습니다.
            userInputInt.add(c - '0');
        }
        playContinue(userInputInt);

    }

    // playTurn 에서 예외 없이 실행됐다면 이 메서드를 실행함. 문제없이 입력을 받았을 때 턴을 계속하는 메서드
    private void playContinue(List<Integer> userInputInt){
        BaseballCounter baseballCounter = computeNum(userInputInt);
        baseballResultPrint(baseballCounter);
    }

    // 스트라이크와 볼을 계산하는 메서드
    private BaseballCounter computeNum(List<Integer> userInputInt){
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
        // 이러면 매 턴 마다 객체 생성된다는 말인데... 조금 더 고민해보자
        // 음 상관없나?
        BaseballCounter baseballCounter = new BaseballCounter(strikes, balls);
        return baseballCounter;
    }

    // 이번 턴의 결과를 출력하는 메서드
    private void baseballResultPrint(BaseballCounter baseballCounter){
        if (baseballCounter.strikes() == 0 && baseballCounter.balls() == 0){
            System.out.println("낫싱");
        }
        else{
            System.out.println(baseballCounter.balls() + "볼 " + baseballCounter.strikes() + "스트라이크");
        }
    }

}
