import java.util.List;

public class ScoreCounting {
    public boolean count(List<Integer> randInputs, List<Integer> userInputs){
        String result = "";
        int strike = 0;
        int ball = 0;
        int miss = 0;
        for (int i = 0; i < userInputs.size(); i++){
            if (userInputs.get(i).equals(randInputs.get(i))){
                ball++;
            } else if (randInputs.contains(userInputs.get(i))) {
                strike++;
            }
            else{
                miss++;
            }
        }
        if (ball == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (miss == 3){
            result = "낫싱";
        }
        else{
            if (ball > 0){
                result += (ball+"볼 ");
            }
            if (strike > 0){
                result += (strike+"스크라이트");
            }
        }
        System.out.println(result);
        return false;
    }
}
