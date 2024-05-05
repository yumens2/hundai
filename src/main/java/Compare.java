import java.util.Vector;

public class Compare {
    public int strike(Vector<Integer> player_num, Vector<Integer> computer_num){
        int strike = 0;

        for(int i = 0; i < player_num.size(); i++){
            if(computer_num.get(i) == player_num.get(i)) strike++;
        }

        return strike;
    }

    public int result(Vector<Integer> player_num, Vector<Integer> computer_num){
        int result = 0;

        for(int i = 0; i < player_num.size(); i++){
            if(computer_num.contains(player_num.get(i))) result++;
        }

        return result;
    }

    public boolean compareTo(Vector<Integer> player_num, Vector<Integer> computer_num){
        int result = result(player_num, computer_num), strike = strike(player_num, computer_num);

        int ball = result - strike;

        if(ball != 0) System.out.print(ball+"볼 ");
        if(strike != 0) System.out.print(strike+"스트라이크");
        if(result == 0)System.out.print("낫싱");
        System.out.println();

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else return false;
    }
}
