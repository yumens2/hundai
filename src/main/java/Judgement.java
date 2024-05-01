import java.util.List;

public class Judgement {
    public int matchNumber(List<Integer> computer, List<Integer> player){ //숫자 중 몇개가 같은지 확인하는 메소드
        int result = 0;

        for(int i = 0; i < computer.size(); i++){
            int playerNum = player.get(i);
            computer.contains(playerNum);
            if (computer.contains(playerNum)){
                result++;
            }
        }
        return result;
    }

    public boolean placeCheck(List<Integer> computer, int placeNumber, int number){ //placeNumber에 number가 있는지 확인하는 메소드
        return false;
    }
}

