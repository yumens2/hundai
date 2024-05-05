public class Application {

    public static void main(String[] args) {
        CreateNumber ranNum = new CreateNumber();
        Input input = new Input();
        Judge judge = new Judge();
        Restart restart = new Restart();
        boolean re = true;

        while (re){
            int[] computer = ranNum.create();
            String result = "";
            while (!result.equals("3스트라이크")){
                int[] player = input.PlayerNum();
                result = judge.Judgement(computer, player);
                System.out.println(result);
            }
            re = restart.restart();

        }


    }


}
