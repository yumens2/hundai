package baseball;

import java.util.List;
import java.util.Scanner;

public class Baseball {

    public void run(){
        BaseballMaker baseballMaker=new BaseballMaker();
        User user=new User();
        Referee referee=new Referee();
        List<Integer> game=baseballMaker.makeBaseball();
        String baseballCount="";
        while(!baseballCount.equals("3스트라이크")){
            List<Integer> userNum;
            try {
                userNum = user.userNumber();
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                //replay=false;
                break;
            }
            int ball=referee.ball(game,userNum);
            int strike=referee.strike(game,userNum);
            baseballCount=referee.ballCount(ball,strike);
            System.out.println(baseballCount);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
    }
    public boolean replay(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){
            return true;
        }
        return false;
    }
//    public int ball(List<Integer> baseballNum, List<Integer> userNum){
//        int count=0;
//        for(int i=0; i<3; i++){
//            if(baseballNum.contains(userNum.get(i))){
//                count++;
//            }
//        }
//        return count;
//    }
//    public int strike(List<Integer> baseballNum,List<Integer>userNum){
//        int count=0;
//        for(int i=0; i<3; i++){
//            if(baseballNum.get(i)==userNum.get(i)){
//                count++;
//            }
//        }
//        return count;
//    }
//    public String ballCount(int ball, int strike){
//        if(strike>0){
//            ball-=strike;
//        }
//        if(ball==0 && strike==0){
//            return "낫싱";
//        }
//        else if(ball==0){
//            return strike+"스트라이크";
//        }
//        else if(strike==0){
//            return ball+"볼";
//        }
//        return ball+"볼"+strike+"스트라이크";
//
//    }
//    public boolean replay(){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        if(n==1){
//            return true;
//        }
//        return false;
//    }
}
