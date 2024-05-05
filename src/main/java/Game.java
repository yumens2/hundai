import java.util.ArrayList;

public class Game {
    private Player player =  new Player();
    private CreateRandom createRandom = new CreateRandom();
    private Judgement judgement = new Judgement();
    private ArrayList<Integer> user;
    private ArrayList<Integer> computer;
    public void run(){

        computer = createRandom.createList();

        boolean start = true;
        while(start) {

            user = player.input();

            int[] cnt = judgement.judge(computer, user);
            judgement.result(cnt);

            if (cnt[1] == 3) {
                start = player.restart();
                computer = createRandom.createList();
            }
        }
    }
}
