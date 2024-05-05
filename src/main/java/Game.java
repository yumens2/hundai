public class Game {
    private static final int GAME_NUM = GameNum.GAME_NUM.getGameNum();
    private Computer computer;
    private User user;
    private Validator validator;
    private CheckNum checkNum;

    public Game(Computer computer, User user, Validator validator, CheckNum checkNum) {
        this.computer = computer;
        this.user = user;
        this.validator = validator;
        this.checkNum = checkNum;
    }

    public void start(){
        computer.createGameNumber();
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = user.readNumber();
        if(!validator.isUserInputValid(userInput)){
            throw new IllegalArgumentException("invalid Input");
        }

        while (true){
            int strike = checkNum.strikeCheck(computer.getComNum(), user.toArray(userInput));
            int ball = checkNum.ballCheck(computer.getComNum(), user.toArray(userInput));
            System.out.println(ball + "볼" + strike + "스트라이크");
            if(strike==3){
                end(1);
                break;
            }
            userInput = user.readNumber();
        }
        restart();
    }

    public void restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInput = user.readNumber();

        if(!validator.isRestartInputValid(restartInput)){
            throw new IllegalArgumentException();
        }
        if (restartInput.equals("1")){
            start();
        }
        if (restartInput.equals("2")){
            end(2);
        }
    }

    public void end(int op){
        if (op==1) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (op==2){
            System.out.println("게임을 종료합니다.");
        }
    }


}
