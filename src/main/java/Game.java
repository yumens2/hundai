import java.util.Scanner;

public class Game {
    Player player;
    Computer computer;
    Compare compare;

    public Game() {
        start();
    }

    public void start(){
        this.player = new Player();
        this.computer = new Computer();
        this.compare = new Compare();
        do{
            player.pickNumber();
        }
        while(compare.compareTo(player.getNum(), computer.getNum()) == false);

        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        if(res == 1) start();
    }
}
