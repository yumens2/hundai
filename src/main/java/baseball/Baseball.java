package baseball;

import java.util.List;
import java.util.Scanner;

public class Baseball {
    //게임시작
    public void run(){
        BaseballMaker baseballMaker=new BaseballMaker();
        User user=new User();
        Referee referee=new Referee();
        List<Integer> game=baseballMaker.makeBaseball();
//        for(int i=0; i<3; i++){
//            System.out.println(game.get(i));
//        }
        String baseballCount="";
        boolean except=false;
        while(!baseballCount.equals("3스트라이크")){
            List<Integer> userNum;
            try {
                userNum = user.userNumber();
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                except=true;
//                break;
                throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
            }
            int ball=referee.ball(game,userNum);
            int strike=referee.strike(game,userNum);
            baseballCount=referee.ballCount(ball,strike);
            System.out.println(baseballCount);
        }
        if(!except) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
        }
    }
    //재시작 여부
    public boolean replay(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){
            return true;
        }
        return false;
    }

}
