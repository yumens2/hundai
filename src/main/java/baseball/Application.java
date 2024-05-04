package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args){
        BaseballMaker baseballmaker=new BaseballMaker();
        Baseball baseball=new Baseball();
        boolean replay=true;
        while(replay){
            List<Integer> game=baseballmaker.makeBaseball();
            replay=baseball.replay();
        }
    }
}
