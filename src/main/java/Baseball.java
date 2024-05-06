public class Baseball {
    //야구 게임 전반적인 흐름을 처리
    public static boolean play(){
        Util myutil = new Util();
        Input input = new Input();
        GenerateAnswer answer = new GenerateAnswer();

        int gameAnswer = answer.generateAnswer(); //숫자 3자리를 생산해냄
        int userInput; //사용자의 입력을 받는 변수


        while (true) {
            try {
                userInput = input.getInput(); //사용자의 입력값을 받음.
            } catch (IllegalArgumentException e){ //예외 발생시 잘못됐음을 출력하고 게임 종료
                System.out.println(e.getMessage());
                break;
            }

            boolean result; //사용자가 답을 맞췄는지 여부를 담는 변수

            result = myutil.process(userInput, gameAnswer);
            if (result){ //답을 맞춘 경우에는 현재 게임 종료
                break;
            }
            else
                continue; //그렇지 않은 경우는 답을 맞추기 위해서 다시 시도
        }
    }
}
