import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player =  new Player();
    private CreateRandom createRandom = new CreateRandom();
    private Judgement judgement = new Judgement();
    public void run(){

        ArrayList<Integer> computer = createRandom.createList();

        boolean start = true;
        while(start) {

            ArrayList<Integer> user = player.input();

            int[] cnt = judgement.judge(computer, user);
            judgement.result(cnt);

            if (cnt[1] == 3) {
                start = player.restart();
                computer = createRandom.createList();
            }
        }
    }
}
