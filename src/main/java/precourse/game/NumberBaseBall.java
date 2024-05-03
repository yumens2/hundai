package precourse.game;

import precourse.utils.DigitUtil;

import java.util.function.Supplier;

public class NumberBaseBall {
    private final Validator validator;
    private GameStatus gameStatus;
    private String numbers;

    public NumberBaseBall(Validator validator){
        this.validator = validator;
    }

    //초기화 메서드 필요 없을듯

    public void startRound(int numberLength){
        //시작된 상태가 아닌지 검증
        checkTrueOrThrow(!isSameStatus(GameStatus.ROUND_STARTED), Messages.ALREADY_STARTED::getMessage);
        //인풋 검증
        validator.validateStartRoundInput(numberLength);
        //numbers 초기화
        this.numbers = DigitUtil.createUniqueDigits(numberLength);
        //라운드 시작
        updateGameStatus(GameStatus.ROUND_STARTED);
        //숫자를 입력하세요 메세지 띄우기
        showMessage(Messages.REQUIRE_NUMBERS.getMessage());
    }

    public void playTurn(String userNumbers){
        //시작된 상태인지 검증
        checkTrueOrThrow(isSameStatus(GameStatus.ROUND_STARTED), Messages.NOT_STARTED::getMessage);
        //유저의 숫자 검증
        validator.validatePlayTurnInput(this.numbers, userNumbers);
        //결과 VO 객체 생성 - numbers, userNumbers
        TurnResult turnResult = TurnResult.of(this.numbers, userNumbers);
        //vo.toString()을 메세지로 띄우기 (몇 볼 몇 스트라이크)
        showMessage(turnResult.toString());
        //모두 스트라이크가 아니면 숫자를 입력하세요 메세지 띄우기 (얼리리턴)
        if (!turnResult.isAllStrike()){
            showMessage(Messages.REQUIRE_NUMBERS.getMessage());
            return;
        }
        //올 스트라이크 메세지 띄우기
        showMessage(String.format(Messages.ALL_STRIKE_FORMAT.getMessage(), this.numbers.length()));
        //라운드 종료 상태로 변경
        updateGameStatus(GameStatus.ROUND_ENDED);
        //게임 계속할건지 물어보는 메세지 띄우기
        showMessage(Messages.REQUIRE_END_COMMAND.getMessage());
    }

    public void enterEndCommand(String strEndCommand) {
        checkTrueOrThrow(isSameStatus(GameStatus.ROUND_ENDED), Messages.NOT_ENDED::getMessage); // 게임은 끝난 상태여야 함
        EndCommand endCommand = EndCommand.commandOf(strEndCommand) // 커맨드 가져오기
                .orElseThrow(() -> new IllegalArgumentException(Messages.INVALID_COMMAND.getMessage()));
        processEndCommand(endCommand); //커맨드 처리
    }

    public boolean isRoundStarted(){
        return isSameStatus(GameStatus.ROUND_STARTED);
    }
    public boolean isRoundEnded(){
        return isSameStatus(GameStatus.ROUND_ENDED);
    }
    public boolean isNONE(){
        return isSameStatus(GameStatus.NONE);
    }

//내부 로직
    private boolean isSameStatus(GameStatus gameStatus){
        return this.gameStatus == gameStatus;
    }
    private void checkTrueOrThrow(boolean bool, Supplier<String> exceptionMessageSupplier){
        if (bool) throw new IllegalArgumentException(exceptionMessageSupplier.get());
    }
    private void showMessage(String message){
        System.out.println(message);
    }
    private void updateGameStatus(GameStatus gameStatus){
        this.gameStatus = gameStatus;
    }
    private void processEndCommand(EndCommand endCommand){
        if (endCommand == EndCommand.CONTINUE)
            startRound(this.numbers.length());
        if (endCommand == EndCommand.STOP)
            updateGameStatus(GameStatus.NONE);
    }

}
