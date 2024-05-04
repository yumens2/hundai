import java.util.List;

public class Main {

    public static void main(String[] args) {

        makeRand numMaker = new makeRand();
        play playing = new play();

        boolean continueGame = true;

        while(continueGame){

            List<Integer> computer = numMaker.makeRandNum();
            continueGame = playing.playGame(computer);
        }
    }

}