public class Game {
    private InputOutput inputOutput = new InputOutput();
    private Validate validate = new Validate();
    private Number number = new Number();
    private BaseballUtil baseballUtil = new BaseballUtil();

    public void start() {
        while (true) {
            // 임의의 세 자리 숫자 생성
            String random = number.create();

            // 숫자 야구 게임 진행
            oneGame(random);

            // 다시 게임을 진행할 것인지, 종료할 것 인지 여부 출력 및 입력
            inputOutput.restartOutput();
            String yesOrNo = inputOutput.yesOrNoInput();
            if (!validate.yesOrNoValidate(yesOrNo)) {
                throw new IllegalArgumentException();
            }
            if (yesOrNo.equals("2")) {
                break;
            }
        }
    }

    /*
        한 번의 숫자 야구 게임의 진행
     */
    public void oneGame(String random) {
        while (true) {
            inputOutput.startOutput();
            String input = inputOutput.numberInput();
            if (!validate.numberValidate(input)) {
                throw new IllegalArgumentException();
            }
            inputOutput.hitterResultOutput(baseballUtil.ball(random, input),
                    baseballUtil.strike(random, input));
            if (baseballUtil.strike(random, input) == 3) {
                inputOutput.endOutput();
                break;
            }
        }
    }
}
