package baseball;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        Baseball baseball=new Baseball();
        boolean replay=true;
        boolean except=false;
        while(replay){
            try {
                baseball.run();
            }
            catch (IllegalArgumentException e){
                except=true;
                replay=false;
                break;
            }
            if(!except) {
                replay = baseball.replay();
            }
        }
    }
}
