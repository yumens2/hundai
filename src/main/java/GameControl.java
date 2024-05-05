import java.util.List;

public class GameControl {

    public static void main(String[] args) {
        BallCount ballCount = new BallCount();
        CreateCnum createCnum = new CreateCnum();
        IO io = new IO();
        boolean status = true;  // 게임 진행 상태

        while(status) { // 게임 진행 상태 On일 때 계속 실행
            List<Integer> ComNumber = createCnum.ComputerNumber();
            boolean gamestatus = false; // 게임 결과 상태
            while(!gamestatus) {
                try {
                    String input = io.Input();;
                    gamestatus = ballCount.Count(input, ComNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            status = io.Regame();   // 게임 종료 or 다시 게임 여부 결정

        }
    }
}
