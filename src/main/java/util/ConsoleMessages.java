package util;

public class ConsoleMessages {
    private ConsoleMessages() {
    }

    static public void requestNumberInput(){
        System.out.print("숫자를 입력해 주세요 : ");
    }
    static public void ball(int ballCount){
        System.out.print(ballCount+"볼 ");
    }
    static public void strike(int strikeCount){
        System.out.print(strikeCount+"스트라이크");
    }
    static public void nothing(){
        System.out.print("낫싱");
    }
    static public void gameClear(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    static public void requestRestartGameOrExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
