package baseball;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        BaseballMaker baseballmaker=new BaseballMaker();
        Baseball baseball=new Baseball();
        User user=new User();
        boolean replay=true;
        while(replay){
            List<Integer> game=baseballmaker.makeBaseball();
            String baseballCount="";
            while(!baseballCount.equals("3스트라이크")){
                List<Integer> userNum;
                try {
                    userNum = user.userNumber();
                }
                catch (IllegalArgumentException e){
                    replay=false;
                    break;
                }
                int ball=baseball.ball(game,userNum);
                int strike=baseball.strike(game,userNum);
                baseballCount=baseball.ballCount(ball,strike);
                System.out.println(baseballCount);
            }
            replay=baseball.replay();
        }
    }
}
