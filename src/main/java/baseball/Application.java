package baseball;


import java.util.List;

public class Application {
    public static void main(String[] args) {
//        BaseballMaker baseballmaker=new BaseballMaker();
        Baseball baseball=new Baseball();
//        User user=new User();
        boolean replay=true;
        while(replay){
            baseball.run();
            
//            List<Integer> game=baseballmaker.makeBaseball();
//            String baseballCount="";
//            while(!baseballCount.equals("3스트라이크")){
//                List<Integer> userNum;
//                try {
//                    userNum = user.userNumber();
//                }
//                catch (IllegalArgumentException e){
//                    System.out.println(e.getMessage());
//                    replay=false;
//                    break;
//                }
//                int ball=baseball.ball(game,userNum);
//                int strike=baseball.strike(game,userNum);
//                baseballCount=baseball.ballCount(ball,strike);
//                System.out.println(baseballCount);
//            }
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
            replay=baseball.replay();
        }
    }
}
