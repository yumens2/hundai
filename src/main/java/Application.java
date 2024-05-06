import java.util.List;

public class Application {
    public static void main(String[] args) {
        Player pl = new Player();
        Computer com = new Computer();
        OneGameProgress oneGameProgress= new OneGameProgress();

        boolean gameProgress = true;

        while (gameProgress) {
            List<Integer> comNums= com.setComNum();
            oneGameProgress.oneGame(comNums,pl,com);
            gameProgress = oneGameProgress.gameRestart();
        }


    }
}
