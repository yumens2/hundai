public class Application {
    public static void main(String[] args) {

        boolean endFlag=false;

        while(!endFlag){

            GenerateTargetNumber generateTargetNumber = new GenerateTargetNumber();

            for(int i=0;i<3;i++) System.out.println(generateTargetNumber.getTargetNumbers()[i]);

            int strike = 0;

            while(strike!=3){
                PlayerInput playerInput = new PlayerInput(); // 사용자 입력
                Compare compare=new Compare(); // 비교 객체
                compare.compare(generateTargetNumber.getTargetNumbers(), playerInput.getPlayerNumber()); //출력을 함
                strike = compare.strikeCount();
            }

            PlayerInputValidator playerInputValidator = new PlayerInputValidator();
            if(!playerInputValidator.validateInput()) endFlag = true; // 다시 한다
        }
    }
}
