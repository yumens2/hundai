import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
객체 지향 5대 원칙 SOLID
SRP(Single Responsibility Principle): 단일 책임 원칙
OCP(Open Closed Principle): 개방 폐쇄 원칙
LSP(Liskov Substitution Principle): 리스코프 치환 원칙
ISP(Interface Segregation Principle): 인터페이스 분리 원칙
DIP(Dependency Inversion Principle): 의존 역전 원칙
 */


public class BaseBall {

    public static void main(String[] args) {
        baseball();
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (answer == 1) {baseball();}
            else if (answer == 2) {scanner.close(); break;}
        }
    }

    private static void baseball() {

        Scanner scanner = new Scanner(System.in);
        PlayBall play = new PlayBall();
        RandomBall random = new RandomBall();
        ValidBall validBall = new ValidBall();

        int number = random.makeRandomBall();

        while (true) {

            System.out.println("숫자를 입력해 주세요 :");
            int answer = scanner.nextInt();
            validBall.valid(answer);

            List<Integer> result = play.baseBall(number, answer);

            int ballCount = result.get(0);
            int strikeCount = result.get(1);

            if ((ballCount==0)&&(strikeCount==0)) {System.out.println("낫싱");}
            else {System.out.println("결과: " + ballCount + "볼, " + strikeCount + "스트라이크");}

            if (strikeCount == 3) {System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); break;}
        }
    }
}