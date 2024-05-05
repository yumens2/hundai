import java.util.List;

public class Application {
    public static void main(String[] args) {
        GenerateRandomNum randomNum = new GenerateRandomNum();
        Input input = new Input();
        Judge judge = new Judge();
        Playagain playagain = new Playagain();
        boolean again = true;

        while (again){
            List<Integer> computer = randomNum.create();
            String result = "";
            while (!result.equals("3스트라이크")){
                List<Integer> data = input.playerNumber();
                isNotValid(data);
                result = judge.judgement(computer, data);
                System.out.println(result);
            }
            again = playagain.playagain();
        }

    }

    public static void isNotValid(List<Integer> data){
        Input input = new Input();
        try{
            input.isValid(data);
        }catch(IllegalArgumentException e){
            System.exit(0);
        }
    }
}