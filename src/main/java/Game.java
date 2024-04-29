import java.util.Scanner;

public abstract class Game {
    public abstract void play();
    protected abstract void printEndGame();
    protected int askNewGame() {
        int select=0;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        try{
            select = scanner.nextInt();
        }catch (Exception e ){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if(select>2 || select<1)
            throw new IllegalArgumentException("잘못된 입력입니다.");
        return select;
    }
}